package com.tencent.youtu.sdkkitframework.common;

import android.graphics.Bitmap;
import android.graphics.YuvImage;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class YtVideoEncoder
{
  private static final int BIT_RATE = 16000000;
  private static final int FRAME_RATE = 30;
  private static final int I_FRAME_INTERVAL = 1;
  private static final String MIME_TYPE = "video/avc";
  private static final String TAG = YtVideoEncoder.class.getSimpleName();
  private static int mHeight;
  private static int mWidth;
  private boolean mAbort = false;
  private YtVideoEncoder.IYUVToVideoEncoderCallback mCallback;
  private ConcurrentLinkedQueue<YuvImage> mEncodeQueue = new ConcurrentLinkedQueue();
  private Object mFrameSync = new Object();
  private int mGenerateIndex = 0;
  private boolean mNeedWork = false;
  private CountDownLatch mNewFrameLatch;
  private boolean mNoMoreFrames = false;
  private File mOutputFile;
  private int mTrackIndex;
  private MediaCodec mediaCodec;
  private MediaMuxer mediaMuxer;
  private byte[] yuvnv12;
  
  public YtVideoEncoder(YtVideoEncoder.IYUVToVideoEncoderCallback paramIYUVToVideoEncoderCallback, boolean paramBoolean)
  {
    this.mCallback = paramIYUVToVideoEncoderCallback;
    this.mNeedWork = paramBoolean;
  }
  
  private byte[] NV12ToNV21(int paramInt1, int paramInt2, YuvImage paramYuvImage)
  {
    if (this.yuvnv12 == null) {
      this.yuvnv12 = new byte[paramInt1 * paramInt2 * 3 / 2];
    }
    paramYuvImage = paramYuvImage.getYuvData();
    paramInt2 = paramInt1 * paramInt2;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      this.yuvnv12[paramInt1] = paramYuvImage[paramInt1];
      paramInt1 += 1;
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
        int i5 = (paramArrayOfInt[j] & 0xFF) >> 0;
        i4 = (m * 66 + i2 * 129 + i5 * 25 + 128 >> 8) + 16;
        i3 = (m * -38 - i2 * 74 + i5 * 112 + 128 >> 8) + 128;
        i2 = (m * 112 - i2 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i4 < 0)
        {
          m = 0;
          label171:
          paramArrayOfByte[i] = ((byte)m);
          if ((n % 2 != 0) || (j % 2 != 0)) {
            break label331;
          }
          i4 = k + 1;
          if (i3 >= 0) {
            break label275;
          }
          m = 0;
          label206:
          paramArrayOfByte[k] = ((byte)m);
          if (i2 >= 0) {
            break label298;
          }
          k = 0;
          label221:
          paramArrayOfByte[i4] = ((byte)k);
          k = i4 + 1;
        }
      }
    }
    label275:
    label298:
    label331:
    for (;;)
    {
      i1 += 1;
      j += 1;
      i += 1;
      break label25;
      m = i4;
      if (i4 <= 255) {
        break label171;
      }
      m = 255;
      break label171;
      if (i3 > 255)
      {
        m = 255;
        break label206;
      }
      m = i3;
      break label206;
      if (i2 > 255)
      {
        k = 255;
        break label221;
      }
      k = i2;
      break label221;
      n += 1;
      break;
      return;
    }
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
  
  private static boolean isRecognizedFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void release()
  {
    if (this.mediaCodec != null)
    {
      this.mediaCodec.stop();
      this.mediaCodec.release();
      this.mediaCodec = null;
      YtLogger.d(TAG, "RELEASE CODEC");
    }
    if (this.mediaMuxer != null)
    {
      this.mediaMuxer.stop();
      this.mediaMuxer.release();
      this.mediaMuxer = null;
      YtLogger.d(TAG, "RELEASE MUXER");
    }
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
        if (!isRecognizedFormat(j)) {}
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  public void abortEncoding()
  {
    if (this.mOutputFile != null)
    {
      YtLogger.d(TAG, "Clean up record file");
      this.mOutputFile.delete();
    }
    if (!this.mNeedWork) {
      return;
    }
    if ((this.mediaCodec == null) || (this.mediaMuxer == null))
    {
      YtLogger.d(TAG, "Failed to abort encoding since it never started");
      return;
    }
    YtLogger.d(TAG, "Aborting encoding");
    this.mNoMoreFrames = true;
    this.mAbort = true;
    this.mEncodeQueue = new ConcurrentLinkedQueue();
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
    if (!this.mNeedWork) {}
    for (;;)
    {
      return;
      YtLogger.d(TAG, "Encoder started");
      if ((this.mNoMoreFrames) && (this.mEncodeQueue.size() == 0)) {
        continue;
      }
      Object localObject2 = (YuvImage)this.mEncodeQueue.poll();
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
        label85:
        ??? = (YuvImage)this.mEncodeQueue.poll();
        if (??? == null) {
          continue;
        }
        ??? = NV12ToNV21(mWidth, mHeight, (YuvImage)???);
        int i = this.mediaCodec.dequeueInputBuffer(200000L);
        long l = computePresentationTime(this.mGenerateIndex, 30);
        if (i >= 0)
        {
          localObject2 = this.mediaCodec.getInputBuffer(i);
          ((ByteBuffer)localObject2).clear();
          ((ByteBuffer)localObject2).put((byte[])???);
          this.mediaCodec.queueInputBuffer(i, 0, ???.length, l, 0);
          this.mGenerateIndex += 1;
        }
        ??? = new MediaCodec.BufferInfo();
        i = this.mediaCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)???, 200000L);
        if (i == -1)
        {
          YtLogger.e(TAG, "No output from encoder available");
          return;
          localObject3 = finally;
          throw localObject3;
        }
        if (i == -2)
        {
          ??? = this.mediaCodec.getOutputFormat();
          this.mTrackIndex = this.mediaMuxer.addTrack((MediaFormat)???);
          this.mediaMuxer.start();
          return;
        }
        if (i < 0)
        {
          YtLogger.e(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + i);
          return;
        }
        if (((MediaCodec.BufferInfo)???).size == 0) {
          continue;
        }
        ByteBuffer localByteBuffer = this.mediaCodec.getOutputBuffer(i);
        if (localByteBuffer == null)
        {
          YtLogger.e(TAG, "encoderOutputBuffer " + i + " was null");
          return;
        }
        localByteBuffer.position(((MediaCodec.BufferInfo)???).offset);
        localByteBuffer.limit(((MediaCodec.BufferInfo)???).offset + ((MediaCodec.BufferInfo)???).size);
        this.mediaMuxer.writeSampleData(this.mTrackIndex, localByteBuffer, (MediaCodec.BufferInfo)???);
        this.mediaCodec.releaseOutputBuffer(i, false);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label85;
      }
    }
  }
  
  public int getYUVImageSize()
  {
    return this.mEncodeQueue.size();
  }
  
  public boolean isEncodingStarted()
  {
    return (this.mNeedWork) && (this.mediaCodec != null) && (this.mediaMuxer != null) && (!this.mNoMoreFrames) && (!this.mAbort);
  }
  
  public void queueFrame(YuvImage arg1)
  {
    if (!this.mNeedWork) {
      return;
    }
    if ((this.mediaCodec == null) || (this.mediaMuxer == null))
    {
      Log.d(TAG, "Failed to queue frame. Encoding not started");
      return;
    }
    YtLogger.d(TAG, "Queueing frame");
    this.mEncodeQueue.add(???);
    synchronized (this.mFrameSync)
    {
      if ((this.mNewFrameLatch != null) && (this.mNewFrameLatch.getCount() > 0L)) {
        this.mNewFrameLatch.countDown();
      }
      return;
    }
  }
  
  /* Error */
  public void startEncoding(int paramInt1, int paramInt2, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mNeedWork	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: iload_1
    //   9: putstatic 221	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mWidth	I
    //   12: iload_2
    //   13: putstatic 223	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mHeight	I
    //   16: aload_0
    //   17: aload_3
    //   18: putfield 179	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mOutputFile	Ljava/io/File;
    //   21: aload_3
    //   22: invokevirtual 345	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   25: astore 4
    //   27: ldc 15
    //   29: invokestatic 347	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:selectCodec	(Ljava/lang/String;)Landroid/media/MediaCodecInfo;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnonnull +42 -> 76
    //   37: getstatic 51	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   40: ldc_w 349
    //   43: invokestatic 264	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: return
    //   47: astore 4
    //   49: getstatic 51	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   52: new 279	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 351
    //   62: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_3
    //   66: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 264	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: return
    //   76: getstatic 51	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   79: new 279	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 356
    //   89: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_3
    //   93: invokevirtual 359	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   96: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 126	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   105: aload_3
    //   106: ldc 15
    //   108: invokestatic 361	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:selectColorFormat	(Landroid/media/MediaCodecInfo;Ljava/lang/String;)I
    //   111: pop
    //   112: aload_0
    //   113: aload_3
    //   114: invokevirtual 359	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   117: invokestatic 365	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   120: putfield 111	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaCodec	Landroid/media/MediaCodec;
    //   123: ldc 15
    //   125: getstatic 221	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mWidth	I
    //   128: getstatic 223	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mHeight	I
    //   131: invokestatic 371	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   134: astore_3
    //   135: aload_3
    //   136: ldc_w 373
    //   139: ldc 7
    //   141: invokevirtual 377	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   144: aload_3
    //   145: ldc_w 379
    //   148: bipush 30
    //   150: invokevirtual 377	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   153: aload_3
    //   154: ldc_w 381
    //   157: bipush 21
    //   159: invokevirtual 377	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   162: aload_3
    //   163: ldc_w 383
    //   166: iconst_1
    //   167: invokevirtual 377	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   170: aload_0
    //   171: getfield 111	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaCodec	Landroid/media/MediaCodec;
    //   174: aload_3
    //   175: aconst_null
    //   176: aconst_null
    //   177: iconst_1
    //   178: invokevirtual 387	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   181: aload_0
    //   182: getfield 111	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaCodec	Landroid/media/MediaCodec;
    //   185: invokevirtual 388	android/media/MediaCodec:start	()V
    //   188: aload_0
    //   189: new 130	android/media/MediaMuxer
    //   192: dup
    //   193: aload 4
    //   195: iconst_0
    //   196: invokespecial 390	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   199: putfield 128	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   202: getstatic 51	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   205: ldc_w 392
    //   208: invokestatic 126	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   211: return
    //   212: astore_3
    //   213: getstatic 51	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   216: new 279	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 394
    //   226: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_3
    //   230: invokevirtual 397	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 264	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: return
    //   243: astore_3
    //   244: getstatic 51	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   247: new 279	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 399
    //   257: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_3
    //   261: invokevirtual 397	java/io/IOException:getMessage	()Ljava/lang/String;
    //   264: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 264	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: return
    //   274: astore 5
    //   276: goto -164 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	YtVideoEncoder
    //   0	279	1	paramInt1	int
    //   0	279	2	paramInt2	int
    //   0	279	3	paramFile	File
    //   25	1	4	str	String
    //   47	147	4	localIOException	java.io.IOException
    //   274	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	27	47	java/io/IOException
    //   112	123	212	java/io/IOException
    //   188	202	243	java/io/IOException
    //   105	112	274	java/lang/Exception
  }
  
  public void stopEncoding()
  {
    if (!this.mNeedWork) {
      return;
    }
    if ((this.mediaCodec == null) || (this.mediaMuxer == null))
    {
      Log.d(TAG, "Failed to stop encoding since it never started");
      return;
    }
    YtLogger.d(TAG, "Stopping encoding");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder
 * JD-Core Version:    0.7.0.1
 */