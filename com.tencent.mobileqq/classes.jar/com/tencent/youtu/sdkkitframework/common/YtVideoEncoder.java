package com.tencent.youtu.sdkkitframework.common;

import android.graphics.Bitmap;
import android.graphics.YuvImage;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class YtVideoEncoder
{
  private static final int AUDIO_CHANNEL_NUM = 1;
  private static final int BIT_RATE = 2000000;
  private static final int FRAME_RATE = 30;
  private static final int I_FRAME_INTERVAL = 1;
  private static final String MIME_TYPE = "video/avc";
  private static final String TAG = YtVideoEncoder.class.getSimpleName();
  private static int mHeight;
  private static int mWidth;
  private int addedTrackCount = 0;
  private boolean audioEncodeFinished = false;
  private ConcurrentLinkedQueue<byte[]> audioEncodeQueue = new ConcurrentLinkedQueue();
  private Thread audioEncodeThread;
  private MediaCodec audioEncoder;
  private int audioGenerateIndex = 0;
  private AudioRecord audioRecord = null;
  private int audioSampleRate = 8000;
  private int audioTrackIndex;
  private int colorFormat = 21;
  private boolean isEncodingStarted = false;
  private boolean isMediaMuxerStarted = false;
  private boolean mAbort = false;
  private YtVideoEncoder.IYUVToVideoEncoderCallback mCallback;
  private final Object mFrameSync = new Object();
  private boolean mNeedWork = false;
  private CountDownLatch mNewFrameLatch;
  private boolean mNoMoreFrames = false;
  private File mOutputFile;
  private ConcurrentLinkedQueue<YtVideoEncoder.MediaData> mediaDataQueue = new ConcurrentLinkedQueue();
  private MediaMuxer mediaMuxer;
  private final Object mediaMuxerSync = new Object();
  private int minAudioBufferSize = 0;
  private boolean needAudio = false;
  private int realColorFormat = 0;
  private MediaCodec videoEncoder;
  private int videoGenerateIndex = 0;
  private int videoTrackIndex;
  private ConcurrentLinkedQueue<YuvImage> vidoeEncodeQueue = new ConcurrentLinkedQueue();
  private byte[] yuvnv12;
  
  public YtVideoEncoder(YtVideoEncoder.IYUVToVideoEncoderCallback paramIYUVToVideoEncoderCallback, boolean paramBoolean)
  {
    this.mCallback = paramIYUVToVideoEncoderCallback;
    this.mNeedWork = paramBoolean;
  }
  
  private byte[] I420ToNV21(int paramInt1, int paramInt2, YuvImage paramYuvImage)
  {
    if (this.yuvnv12 == null) {
      this.yuvnv12 = new byte[paramInt1 * paramInt2 * 3 / 2];
    }
    paramYuvImage = paramYuvImage.getYuvData();
    paramInt1 *= paramInt2;
    if (paramInt1 >= 0) {
      System.arraycopy(paramYuvImage, 0, this.yuvnv12, 0, paramInt1);
    }
    int j = paramInt1 / 4 + paramInt1;
    paramInt2 = paramInt1;
    int i = paramInt1;
    while (i < paramInt1 * 3 / 2)
    {
      this.yuvnv12[j] = paramYuvImage[i];
      this.yuvnv12[paramInt2] = paramYuvImage[(i + 1)];
      j += 1;
      paramInt2 += 1;
      i += 2;
    }
    return this.yuvnv12;
  }
  
  private byte[] NV12ToNV21(int paramInt1, int paramInt2, YuvImage paramYuvImage)
  {
    if (this.yuvnv12 == null) {
      this.yuvnv12 = new byte[paramInt1 * paramInt2 * 3 / 2];
    }
    paramYuvImage = paramYuvImage.getYuvData();
    paramInt2 = paramInt1 * paramInt2;
    if (paramInt2 >= 0) {
      System.arraycopy(paramYuvImage, 0, this.yuvnv12, 0, paramInt2);
    }
    paramInt1 = paramInt2;
    while (paramInt1 < paramInt2 * 3 / 2)
    {
      if ((paramInt1 + 1) % 2 == 0)
      {
        this.yuvnv12[paramInt1] = paramYuvImage[(paramInt1 - 1)];
        this.yuvnv12[(paramInt1 - 1)] = paramYuvImage[paramInt1];
      }
      paramInt1 += 1;
    }
    return this.yuvnv12;
  }
  
  private long computePresentationTime(long paramLong, int paramInt)
  {
    return 132L + 1000000L * paramLong / paramInt;
  }
  
  private byte[] convertYUV(int paramInt1, int paramInt2, YuvImage paramYuvImage)
  {
    if (this.colorFormat == 21) {
      return NV12ToNV21(paramInt1, paramInt2, paramYuvImage);
    }
    return I420ToNV21(paramInt1, paramInt2, paramYuvImage);
  }
  
  private void encodeYUV420SP(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = paramInt1 * paramInt2;
    int i = 0;
    int j = 0;
    int n = 0;
    int i1;
    label25:
    int m;
    int i2;
    int i4;
    int i3;
    if (n < paramInt2)
    {
      i1 = 0;
      if (i1 < paramInt1)
      {
        m = paramArrayOfInt[j];
        m = (paramArrayOfInt[j] & 0xFF0000) >> 16;
        i2 = (paramArrayOfInt[j] & 0xFF00) >> 8;
        int i5 = paramArrayOfInt[j] & 0xFF;
        i4 = (m * 66 + i2 * 129 + i5 * 25 + 128 >> 8) + 16;
        i3 = (m * -38 - i2 * 74 + i5 * 112 + 128 >> 8) + 128;
        i2 = (m * 112 - i2 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i4 < 0)
        {
          m = 0;
          label169:
          paramArrayOfByte[i] = ((byte)m);
          if ((n % 2 != 0) || (j % 2 != 0)) {
            break label329;
          }
          i4 = k + 1;
          if (i3 >= 0) {
            break label273;
          }
          m = 0;
          label204:
          paramArrayOfByte[k] = ((byte)m);
          if (i2 >= 0) {
            break label296;
          }
          k = 0;
          label219:
          paramArrayOfByte[i4] = ((byte)k);
          k = i4 + 1;
        }
      }
    }
    label273:
    label296:
    label329:
    for (;;)
    {
      i1 += 1;
      j += 1;
      i += 1;
      break label25;
      m = i4;
      if (i4 <= 255) {
        break label169;
      }
      m = 255;
      break label169;
      if (i3 > 255)
      {
        m = 255;
        break label204;
      }
      m = i3;
      break label204;
      if (i2 > 255)
      {
        k = 255;
        break label219;
      }
      k = i2;
      break label219;
      n += 1;
      break;
      return;
    }
  }
  
  private ByteBuffer getInputBuffer(YtVideoEncoder.MediaType paramMediaType, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaType == YtVideoEncoder.MediaType.VideoType) {
        return this.videoEncoder.getInputBuffer(paramInt);
      }
      return this.audioEncoder.getInputBuffer(paramInt);
    }
    if (paramMediaType == YtVideoEncoder.MediaType.VideoType) {
      return this.videoEncoder.getInputBuffers()[paramInt];
    }
    return this.audioEncoder.getInputBuffers()[paramInt];
  }
  
  private byte[] getNV21(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt1 * paramInt2 * 3 / 2];
    encodeYUV420SP(arrayOfByte, arrayOfInt, paramInt1, paramInt2);
    paramBitmap.recycle();
    return arrayOfByte;
  }
  
  private ByteBuffer getOutputBuffer(YtVideoEncoder.MediaType paramMediaType, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaType == YtVideoEncoder.MediaType.VideoType) {
        return this.videoEncoder.getOutputBuffer(paramInt);
      }
      return this.audioEncoder.getOutputBuffer(paramInt);
    }
    if (paramMediaType == YtVideoEncoder.MediaType.VideoType) {
      return this.videoEncoder.getOutputBuffers()[paramInt];
    }
    return this.audioEncoder.getOutputBuffers()[paramInt];
  }
  
  private static boolean isRecognizedFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void onAudioStart()
  {
    this.audioEncoder.start();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    long l4 = 0L;
    long l3 = 0L;
    this.audioEncodeFinished = false;
    long l1 = l4;
    long l2 = l3;
    label34:
    int i;
    ByteBuffer localByteBuffer;
    for (;;)
    {
      if (!this.audioEncodeFinished)
      {
        byte[] arrayOfByte = (byte[])this.audioEncodeQueue.poll();
        if (arrayOfByte == null)
        {
          try
          {
            Thread.sleep(1L);
          }
          catch (InterruptedException localInterruptedException)
          {
            YtLogger.e(TAG, localInterruptedException.getLocalizedMessage());
          }
        }
        else
        {
          i = this.audioEncoder.dequeueInputBuffer(10000L);
          if (i < 0) {
            break label439;
          }
          localByteBuffer = getInputBuffer(YtVideoEncoder.MediaType.AudioType, i);
          localByteBuffer.clear();
          localByteBuffer.limit(localInterruptedException.length);
          localByteBuffer.put(localInterruptedException);
          l1 = localInterruptedException.length + l1;
          if (this.isEncodingStarted)
          {
            this.audioEncoder.queueInputBuffer(i, 0, localInterruptedException.length, l2, 0);
            label158:
            l2 = 1000000L * (l1 / 1L) / this.audioSampleRate / 2L;
            this.audioGenerateIndex += 1;
          }
        }
      }
    }
    label439:
    for (;;)
    {
      for (;;)
      {
        i = this.audioEncoder.dequeueOutputBuffer(localBufferInfo, 10000L);
        if (i == -2)
        {
          ??? = this.audioEncoder.getOutputFormat();
          startMediaMuxer(YtVideoEncoder.MediaType.AudioType, (MediaFormat)???);
          break label34;
          YtLogger.d(TAG, "End of audio stream");
          this.audioEncodeFinished = true;
          this.audioEncoder.queueInputBuffer(i, 0, ???.length, l2, 4);
          break label158;
        }
        if ((i == -1) || (i < 0)) {
          break label34;
        }
        l4 = l1;
        l3 = l2;
        if (localBufferInfo.size == 0) {
          break;
        }
        localByteBuffer = getOutputBuffer(YtVideoEncoder.MediaType.AudioType, i);
        l4 = l1;
        l3 = l2;
        if (localByteBuffer == null) {
          break;
        }
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        YtLogger.d(TAG, "media muxer write audio data outputindex " + this.audioGenerateIndex + " buff size:" + localBufferInfo.size);
        synchronized (this.mediaMuxer)
        {
          this.mediaMuxer.writeSampleData(this.audioTrackIndex, localByteBuffer, localBufferInfo);
          this.audioEncoder.releaseOutputBuffer(i, false);
        }
      }
      YtLogger.d(TAG, "Audio encoder stop");
      return;
    }
  }
  
  /* Error */
  private void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 97	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxerSync	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 187	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   11: ifnull +31 -> 42
    //   14: aload_0
    //   15: getfield 187	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   18: invokevirtual 346	android/media/MediaCodec:stop	()V
    //   21: aload_0
    //   22: getfield 187	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   25: invokevirtual 348	android/media/MediaCodec:release	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 187	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   33: getstatic 73	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   36: ldc_w 350
    //   39: invokestatic 296	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   42: aload_0
    //   43: getfield 194	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +38 -> 86
    //   51: aload_0
    //   52: getfield 352	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncodeThread	Ljava/lang/Thread;
    //   55: invokevirtual 355	java/lang/Thread:join	()V
    //   58: aload_0
    //   59: getfield 194	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   62: invokevirtual 346	android/media/MediaCodec:stop	()V
    //   65: aload_0
    //   66: getfield 194	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   69: invokevirtual 348	android/media/MediaCodec:release	()V
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 194	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   77: getstatic 73	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   80: ldc_w 357
    //   83: invokestatic 296	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload_0
    //   87: getfield 326	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +36 -> 128
    //   95: aload_0
    //   96: getfield 326	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   99: invokevirtual 358	android/media/MediaMuxer:stop	()V
    //   102: aload_0
    //   103: getfield 326	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   106: invokevirtual 359	android/media/MediaMuxer:release	()V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 326	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 89	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:isMediaMuxerStarted	Z
    //   119: getstatic 73	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   122: ldc_w 361
    //   125: invokestatic 296	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   128: aload_1
    //   129: monitorexit
    //   130: return
    //   131: astore_2
    //   132: getstatic 73	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   135: aload_2
    //   136: invokevirtual 241	java/lang/InterruptedException:getLocalizedMessage	()Ljava/lang/String;
    //   139: invokestatic 247	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: goto -84 -> 58
    //   145: astore_2
    //   146: aload_1
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    //   150: astore_2
    //   151: getstatic 73	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   154: new 309	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 363
    //   164: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 364	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   171: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 247	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -78 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	YtVideoEncoder
    //   4	143	1	localObject1	Object
    //   46	46	2	localObject2	Object
    //   131	5	2	localInterruptedException	InterruptedException
    //   145	4	2	localObject3	Object
    //   150	18	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   51	58	131	java/lang/InterruptedException
    //   7	42	145	finally
    //   42	47	145	finally
    //   51	58	145	finally
    //   58	86	145	finally
    //   86	91	145	finally
    //   95	102	145	finally
    //   102	128	145	finally
    //   128	130	145	finally
    //   132	142	145	finally
    //   146	148	145	finally
    //   151	180	145	finally
    //   95	102	150	java/lang/Exception
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
    }
    return null;
  }
  
  private static int selectColorFormat(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    int k = 0;
    paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramMediaCodecInfo.colorFormats.length)
      {
        j = paramMediaCodecInfo.colorFormats[i];
        YtLogger.d(TAG, "found colorformat: " + j);
        if (!isRecognizedFormat(j)) {}
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  private void startAudioEncoding(int paramInt1, int paramInt2)
  {
    if (!this.mNeedWork) {
      return;
    }
    this.needAudio = true;
    try
    {
      this.audioEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt2, 1);
      localMediaFormat.setInteger("aac-profile", 2);
      localMediaFormat.setInteger("bitrate", paramInt1);
      localMediaFormat.setInteger("max-input-size", 16384);
      this.audioSampleRate = paramInt2;
      this.audioEncoder.configure(localMediaFormat, null, null, 1);
      this.isEncodingStarted = true;
      startAudioRecord();
      this.audioEncodeThread = new Thread(new YtVideoEncoder.1(this));
      this.audioEncodeThread.start();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void startAudioRecord()
  {
    new Thread(new YtVideoEncoder.2(this)).start();
  }
  
  private void startMediaMuxer(YtVideoEncoder.MediaType paramMediaType, MediaFormat paramMediaFormat)
  {
    for (;;)
    {
      synchronized (this.mediaMuxerSync)
      {
        if (this.isMediaMuxerStarted) {
          return;
        }
        if (paramMediaType == YtVideoEncoder.MediaType.VideoType)
        {
          this.videoTrackIndex = this.mediaMuxer.addTrack(paramMediaFormat);
          this.addedTrackCount += 1;
        }
        if (paramMediaType == YtVideoEncoder.MediaType.AudioType)
        {
          this.audioTrackIndex = this.mediaMuxer.addTrack(paramMediaFormat);
          this.addedTrackCount += 1;
        }
        if (((this.needAudio) && (this.addedTrackCount >= 2)) || ((!this.needAudio) && (this.addedTrackCount >= 1)))
        {
          YtLogger.d(TAG, "Media muxer is starting...");
          this.mediaMuxer.start();
          this.isMediaMuxerStarted = true;
          this.mediaMuxerSync.notifyAll();
          return;
        }
      }
      boolean bool = this.needAudio;
      if (bool) {
        try
        {
          this.mediaMuxerSync.wait();
        }
        catch (InterruptedException paramMediaType) {}
      }
    }
  }
  
  public void abortEncoding()
  {
    this.isEncodingStarted = false;
    if (this.mOutputFile != null)
    {
      YtLogger.d(TAG, "Clean up record file");
      this.mOutputFile.delete();
      this.mOutputFile = null;
    }
    if (!this.mNeedWork) {
      return;
    }
    if ((this.videoEncoder == null) || (this.mediaMuxer == null))
    {
      YtLogger.i(TAG, "Failed to abort encoding since it never started");
      return;
    }
    YtLogger.i(TAG, "Aborting encoding");
    release();
    this.mNoMoreFrames = true;
    this.mAbort = true;
    this.vidoeEncodeQueue = new ConcurrentLinkedQueue();
    this.audioEncodeQueue = new ConcurrentLinkedQueue();
    synchronized (this.mFrameSync)
    {
      if ((this.mNewFrameLatch != null) && (this.mNewFrameLatch.getCount() > 0L)) {
        this.mNewFrameLatch.countDown();
      }
      return;
    }
  }
  
  public void encode()
  {
    if (!this.mNeedWork) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (!this.isEncodingStarted) {
        continue;
      }
      YtLogger.d(TAG, "Encoder started");
      if ((this.mNoMoreFrames) && (this.vidoeEncodeQueue.size() == 0)) {
        break;
      }
      Object localObject2 = (YuvImage)this.vidoeEncodeQueue.poll();
      ??? = localObject2;
      if (localObject2 == null) {
        synchronized (this.mFrameSync)
        {
          this.mNewFrameLatch = new CountDownLatch(1);
        }
      }
      try
      {
        this.mNewFrameLatch.await();
        label93:
        ??? = (YuvImage)this.vidoeEncodeQueue.poll();
        if (??? == null) {
          continue;
        }
        ??? = convertYUV(mWidth, mHeight, (YuvImage)???);
        int i = this.videoEncoder.dequeueInputBuffer(200000L);
        long l = computePresentationTime(this.videoGenerateIndex, 30);
        if (i >= 0)
        {
          localObject2 = getInputBuffer(YtVideoEncoder.MediaType.VideoType, i);
          ((ByteBuffer)localObject2).clear();
          ((ByteBuffer)localObject2).put((byte[])???);
          this.videoEncoder.queueInputBuffer(i, 0, ???.length, l, 0);
          this.videoGenerateIndex += 1;
        }
        localObject2 = new MediaCodec.BufferInfo();
        i = this.videoEncoder.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject2, 200000L);
        if (i == -1)
        {
          YtLogger.e(TAG, "No output from encoder available");
          return;
          localBufferInfo = finally;
          throw localBufferInfo;
        }
        if (i == -2)
        {
          ??? = this.videoEncoder.getOutputFormat();
          startMediaMuxer(YtVideoEncoder.MediaType.VideoType, (MediaFormat)???);
          return;
        }
        if (i < 0)
        {
          YtLogger.e(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + i);
          return;
        }
        if (localBufferInfo.size == 0) {
          continue;
        }
        ByteBuffer localByteBuffer = getOutputBuffer(YtVideoEncoder.MediaType.VideoType, i);
        if (localByteBuffer == null)
        {
          YtLogger.e(TAG, "encoderOutputBuffer " + i + " was null");
          return;
        }
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        YtLogger.d(TAG, "media muxer write video data outputindex " + this.videoGenerateIndex);
        synchronized (this.mediaMuxer)
        {
          this.mediaMuxer.writeSampleData(this.videoTrackIndex, localByteBuffer, localBufferInfo);
          this.videoEncoder.releaseOutputBuffer(i, false);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label93;
      }
    }
  }
  
  public void encodeAudioData(byte[] paramArrayOfByte)
  {
    this.audioEncodeQueue.add(paramArrayOfByte);
  }
  
  public int getColorFormat()
  {
    return this.realColorFormat;
  }
  
  public int getYUVImageSize()
  {
    return this.vidoeEncodeQueue.size();
  }
  
  public boolean isEncodingStarted()
  {
    return this.isEncodingStarted;
  }
  
  public void queueFrame(YuvImage arg1)
  {
    if (!this.mNeedWork) {
      return;
    }
    if ((this.videoEncoder == null) || (this.mediaMuxer == null))
    {
      Log.d(TAG, "Failed to queue frame. Encoding not started");
      return;
    }
    YtLogger.d(TAG, "Queueing frame");
    this.vidoeEncodeQueue.add(???);
    synchronized (this.mFrameSync)
    {
      if ((this.mNewFrameLatch != null) && (this.mNewFrameLatch.getCount() > 0L)) {
        this.mNewFrameLatch.countDown();
      }
      return;
    }
  }
  
  public void startAudioVideoEncoding(int paramInt1, int paramInt2, File paramFile, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    try
    {
      paramFile.delete();
      String str = paramFile.getCanonicalPath();
      if (this.mediaMuxer == null) {
        this.mediaMuxer = new MediaMuxer(str, 0);
      }
      startAudioEncoding(paramInt7, paramInt6);
      startEncoding(paramInt1, paramInt2, paramFile, paramInt3, paramInt4, paramInt5);
      long l = paramInt8;
      return;
    }
    catch (IOException localIOException)
    {
      try
      {
        Thread.sleep(l);
        return;
      }
      catch (InterruptedException paramFile)
      {
        paramFile.printStackTrace();
      }
      localIOException = localIOException;
      YtLogger.e(TAG, "Unable to get path for " + paramFile);
      return;
    }
  }
  
  public void startEncoding(int paramInt1, int paramInt2, File paramFile, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.mNeedWork) {
      return;
    }
    mWidth = paramInt1;
    mHeight = paramInt2;
    this.mOutputFile = paramFile;
    try
    {
      String str = paramFile.getCanonicalPath();
      if (this.mediaMuxer == null) {
        this.mediaMuxer = new MediaMuxer(str, 0);
      }
      paramFile = selectCodec("video/avc");
      if (paramFile == null)
      {
        YtLogger.e(TAG, "Unable to find an appropriate codec for video/avc");
        return;
      }
    }
    catch (IOException localIOException)
    {
      YtLogger.e(TAG, "Unable to get path for " + paramFile);
      return;
    }
    YtLogger.i(TAG, "found codec: " + paramFile.getName());
    this.colorFormat = 21;
    try
    {
      paramInt1 = selectColorFormat(paramFile, "video/avc");
      this.colorFormat = paramInt1;
      this.realColorFormat = paramInt1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.videoEncoder = MediaCodec.createByCodecName(paramFile.getName());
          YtLogger.d(TAG, "Create videoEncoder createByCodecName");
          paramFile = MediaFormat.createVideoFormat("video/avc", mWidth, mHeight);
          paramFile.setInteger("bitrate", paramInt3);
          paramFile.setInteger("frame-rate", paramInt4);
          paramFile.setInteger("color-format", this.colorFormat);
          paramFile.setInteger("i-frame-interval", paramInt5);
          this.videoEncoder.configure(paramFile, null, null, 1);
          this.videoEncoder.start();
          YtLogger.i(TAG, "Initialization complete. Starting encoder...");
          this.isEncodingStarted = true;
          return;
        }
        catch (Exception paramFile)
        {
          YtLogger.e(TAG, "Unable to create MediaCodec " + paramFile.getMessage());
        }
        localException = localException;
        YtLogger.e(TAG, "Unable to find color format use default");
        this.colorFormat = 21;
      }
    }
  }
  
  public void stopEncoding()
  {
    this.isEncodingStarted = false;
    if (!this.mNeedWork) {
      return;
    }
    if ((this.videoEncoder == null) || (this.mediaMuxer == null))
    {
      Log.i(TAG, "Failed to stop encoding since it never started");
      return;
    }
    YtLogger.i(TAG, "Stopping encoding");
    this.mNoMoreFrames = true;
    synchronized (this.mFrameSync)
    {
      if ((this.mNewFrameLatch != null) && (this.mNewFrameLatch.getCount() > 0L)) {
        this.mNewFrameLatch.countDown();
      }
      release();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder
 * JD-Core Version:    0.7.0.1
 */