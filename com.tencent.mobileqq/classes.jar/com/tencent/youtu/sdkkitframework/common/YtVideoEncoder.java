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
  private static final String TAG = "YtVideoEncoder";
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
    int j = paramInt1 * paramInt2;
    if (j >= 0) {
      System.arraycopy(paramYuvImage, 0, this.yuvnv12, 0, j);
    }
    paramInt2 = j / 4;
    paramInt1 = j;
    int i = paramInt2 + j;
    paramInt2 = paramInt1;
    while (paramInt2 < j * 3 / 2)
    {
      byte[] arrayOfByte = this.yuvnv12;
      arrayOfByte[i] = paramYuvImage[paramInt2];
      arrayOfByte[paramInt1] = paramYuvImage[(paramInt2 + 1)];
      i += 1;
      paramInt1 += 1;
      paramInt2 += 2;
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
    int i;
    for (paramInt1 = paramInt2; paramInt1 < paramInt2 * 3 / 2; paramInt1 = i)
    {
      i = paramInt1 + 1;
      if (i % 2 == 0)
      {
        byte[] arrayOfByte = this.yuvnv12;
        int j = paramInt1 - 1;
        arrayOfByte[paramInt1] = paramYuvImage[j];
        arrayOfByte[j] = paramYuvImage[paramInt1];
      }
    }
    return this.yuvnv12;
  }
  
  private long computePresentationTime(long paramLong, int paramInt)
  {
    return paramLong * 1000000L / paramInt + 132L;
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
    int j = paramInt1 * paramInt2;
    int m = 0;
    int i = 0;
    int n = 0;
    while (m < paramInt2)
    {
      int i1 = 0;
      while (i1 < paramInt1)
      {
        int k = paramArrayOfInt[n];
        k = (paramArrayOfInt[n] & 0xFF0000) >> 16;
        int i4 = (paramArrayOfInt[n] & 0xFF00) >> 8;
        int i3 = paramArrayOfInt[n];
        int i2 = 255;
        int i6 = i3 & 0xFF;
        int i5 = (k * 66 + i4 * 129 + i6 * 25 + 128 >> 8) + 16;
        i3 = (k * -38 - i4 * 74 + i6 * 112 + 128 >> 8) + 128;
        i4 = (k * 112 - i4 * 94 - i6 * 18 + 128 >> 8) + 128;
        if (i5 < 0)
        {
          k = 0;
        }
        else
        {
          k = i5;
          if (i5 > 255) {
            k = 255;
          }
        }
        paramArrayOfByte[i] = ((byte)k);
        k = j;
        if (m % 2 == 0)
        {
          k = j;
          if (n % 2 == 0)
          {
            i5 = j + 1;
            if (i3 < 0)
            {
              k = 0;
            }
            else
            {
              k = i3;
              if (i3 > 255) {
                k = 255;
              }
            }
            paramArrayOfByte[j] = ((byte)k);
            k = i5 + 1;
            if (i4 < 0) {
              j = 0;
            } else if (i4 > 255) {
              j = i2;
            } else {
              j = i4;
            }
            paramArrayOfByte[i5] = ((byte)j);
          }
        }
        n += 1;
        i1 += 1;
        i += 1;
        j = k;
      }
      m += 1;
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
    int i = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[i];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[i * 3 / 2];
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
    if ((paramInt != 39) && (paramInt != 2130706688)) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  private void onAudioStart()
  {
    this.audioEncoder.start();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    this.audioEncodeFinished = false;
    long l3 = 0L;
    long l1 = 0L;
    while (!this.audioEncodeFinished)
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
        int i = this.audioEncoder.dequeueInputBuffer(10000L);
        long l4 = l3;
        long l2 = l1;
        if (i >= 0)
        {
          ??? = getInputBuffer(YtVideoEncoder.MediaType.AudioType, i);
          ((ByteBuffer)???).clear();
          ((ByteBuffer)???).limit(localInterruptedException.length);
          ((ByteBuffer)???).put(localInterruptedException);
          l4 = l3 + localInterruptedException.length;
          if (this.isEncodingStarted)
          {
            this.audioEncoder.queueInputBuffer(i, 0, localInterruptedException.length, l1, 0);
          }
          else
          {
            YtLogger.d(TAG, "End of audio stream");
            this.audioEncodeFinished = true;
            this.audioEncoder.queueInputBuffer(i, 0, localInterruptedException.length, l1, 4);
          }
          l2 = l4 / 1L * 1000000L / this.audioSampleRate / 2L;
          this.audioGenerateIndex += 1;
        }
        i = this.audioEncoder.dequeueOutputBuffer(localBufferInfo, 10000L);
        Object localObject2;
        if (i == -2)
        {
          localObject2 = this.audioEncoder.getOutputFormat();
          startMediaMuxer(YtVideoEncoder.MediaType.AudioType, (MediaFormat)localObject2);
          l3 = l4;
          l1 = l2;
        }
        else if (i == -1)
        {
          l3 = l4;
          l1 = l2;
        }
        else if (i < 0)
        {
          l3 = l4;
          l1 = l2;
        }
        else
        {
          l3 = l4;
          l1 = l2;
          if (localBufferInfo.size != 0)
          {
            localObject2 = getOutputBuffer(YtVideoEncoder.MediaType.AudioType, i);
            l3 = l4;
            l1 = l2;
            if (localObject2 != null)
            {
              ((ByteBuffer)localObject2).position(localBufferInfo.offset);
              ((ByteBuffer)localObject2).limit(localBufferInfo.offset + localBufferInfo.size);
              ??? = TAG;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("media muxer write audio data outputindex ");
              localStringBuilder.append(this.audioGenerateIndex);
              localStringBuilder.append(" buff size:");
              localStringBuilder.append(localBufferInfo.size);
              YtLogger.d((String)???, localStringBuilder.toString());
              synchronized (this.mediaMuxer)
              {
                this.mediaMuxer.writeSampleData(this.audioTrackIndex, (ByteBuffer)localObject2, localBufferInfo);
                this.audioEncoder.releaseOutputBuffer(i, false);
                l3 = l4;
                l1 = l2;
              }
            }
          }
        }
      }
    }
    YtLogger.d(TAG, "Audio encoder stop");
  }
  
  private void release()
  {
    synchronized (this.mediaMuxerSync)
    {
      if (this.videoEncoder != null)
      {
        this.videoEncoder.stop();
        this.videoEncoder.release();
        this.videoEncoder = null;
        YtLogger.d(TAG, "RELEASE Video CODEC");
      }
      MediaCodec localMediaCodec = this.audioEncoder;
      if (localMediaCodec != null)
      {
        try
        {
          this.audioEncodeThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          YtLogger.e(TAG, localInterruptedException.getLocalizedMessage());
        }
        this.audioEncoder.stop();
        this.audioEncoder.release();
        this.audioEncoder = null;
        YtLogger.d(TAG, "RELEASE Audio CODEC");
      }
      MediaMuxer localMediaMuxer = this.mediaMuxer;
      if (localMediaMuxer != null)
      {
        try
        {
          this.mediaMuxer.stop();
        }
        catch (Exception localException)
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("media muxer stop failed:");
          localStringBuilder.append(localException.getLocalizedMessage());
          YtLogger.e(str, localStringBuilder.toString());
        }
        this.mediaMuxer.release();
        this.mediaMuxer = null;
        this.isMediaMuxerStarted = false;
        YtLogger.d(TAG, "RELEASE MUXER");
      }
      return;
    }
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
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
      i += 1;
    }
    return null;
  }
  
  private static int selectColorFormat(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    int i = 0;
    while (i < paramMediaCodecInfo.colorFormats.length)
    {
      int j = paramMediaCodecInfo.colorFormats[i];
      paramString = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("found colorformat: ");
      localStringBuilder.append(j);
      YtLogger.d(paramString, localStringBuilder.toString());
      if (isRecognizedFormat(j)) {
        return j;
      }
      i += 1;
    }
    return 0;
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
      }
      else
      {
        boolean bool = this.needAudio;
        if (!bool) {}
      }
    }
    try
    {
      this.mediaMuxerSync.wait();
      label155:
      return;
      paramMediaType = finally;
      throw paramMediaType;
    }
    catch (InterruptedException paramMediaType)
    {
      break label155;
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
    if ((this.videoEncoder != null) && (this.mediaMuxer != null))
    {
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
    YtLogger.i(TAG, "Failed to abort encoding since it never started");
  }
  
  public void encode()
  {
    if (!this.mNeedWork) {
      return;
    }
    if (!this.isEncodingStarted) {
      return;
    }
    YtLogger.d(TAG, "Encoder started");
    if ((this.mNoMoreFrames) && (this.vidoeEncodeQueue.size() == 0)) {
      return;
    }
    YuvImage localYuvImage = (YuvImage)this.vidoeEncodeQueue.poll();
    ??? = localYuvImage;
    if (localYuvImage == null) {
      synchronized (this.mFrameSync)
      {
        this.mNewFrameLatch = new CountDownLatch(1);
      }
    }
    try
    {
      this.mNewFrameLatch.await();
      label95:
      ??? = (YuvImage)this.vidoeEncodeQueue.poll();
      break label118;
      localObject3 = finally;
      throw localObject3;
      label118:
      if (??? == null) {
        return;
      }
      ??? = convertYUV(mWidth, mHeight, (YuvImage)???);
      int i = this.videoEncoder.dequeueInputBuffer(200000L);
      long l = computePresentationTime(this.videoGenerateIndex, 30);
      Object localObject4;
      if (i >= 0)
      {
        localObject4 = getInputBuffer(YtVideoEncoder.MediaType.VideoType, i);
        ((ByteBuffer)localObject4).clear();
        ((ByteBuffer)localObject4).put((byte[])???);
        this.videoEncoder.queueInputBuffer(i, 0, ???.length, l, 0);
        this.videoGenerateIndex += 1;
      }
      ??? = new MediaCodec.BufferInfo();
      i = this.videoEncoder.dequeueOutputBuffer((MediaCodec.BufferInfo)???, 200000L);
      if (i == -1)
      {
        YtLogger.e(TAG, "No output from encoder available");
        return;
      }
      if (i == -2)
      {
        ??? = this.videoEncoder.getOutputFormat();
        startMediaMuxer(YtVideoEncoder.MediaType.VideoType, (MediaFormat)???);
        return;
      }
      if (i < 0)
      {
        ??? = TAG;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("unexpected result from encoder.dequeueOutputBuffer: ");
        ((StringBuilder)localObject4).append(i);
        YtLogger.e((String)???, ((StringBuilder)localObject4).toString());
        return;
      }
      if (((MediaCodec.BufferInfo)???).size != 0)
      {
        localObject4 = getOutputBuffer(YtVideoEncoder.MediaType.VideoType, i);
        if (localObject4 == null)
        {
          ??? = TAG;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("encoderOutputBuffer ");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append(" was null");
          YtLogger.e((String)???, ((StringBuilder)localObject4).toString());
          return;
        }
        ((ByteBuffer)localObject4).position(((MediaCodec.BufferInfo)???).offset);
        ((ByteBuffer)localObject4).limit(((MediaCodec.BufferInfo)???).offset + ((MediaCodec.BufferInfo)???).size);
        ??? = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("media muxer write video data outputindex ");
        localStringBuilder.append(this.videoGenerateIndex);
        YtLogger.d((String)???, localStringBuilder.toString());
        synchronized (this.mediaMuxer)
        {
          this.mediaMuxer.writeSampleData(this.videoTrackIndex, (ByteBuffer)localObject4, (MediaCodec.BufferInfo)???);
          this.videoEncoder.releaseOutputBuffer(i, false);
          return;
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label95;
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
    if ((this.videoEncoder != null) && (this.mediaMuxer != null))
    {
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
    Log.d(TAG, "Failed to queue frame. Encoding not started");
  }
  
  public void startAudioVideoEncoding(int paramInt1, int paramInt2, File paramFile, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    try
    {
      paramFile.delete();
      str = paramFile.getCanonicalPath();
      if (this.mediaMuxer == null) {
        this.mediaMuxer = new MediaMuxer(str, 0);
      }
      startAudioEncoding(paramInt7, paramInt6);
      startEncoding(paramInt1, paramInt2, paramFile, paramInt3, paramInt4, paramInt5);
      long l = paramInt8;
      try
      {
        Thread.sleep(l);
        return;
      }
      catch (InterruptedException paramFile)
      {
        paramFile.printStackTrace();
        return;
      }
    }
    catch (IOException localIOException)
    {
      String str;
      label70:
      StringBuilder localStringBuilder;
      break label70;
    }
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to get path for ");
    localStringBuilder.append(paramFile);
    YtLogger.e(str, localStringBuilder.toString());
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
      str = paramFile.getCanonicalPath();
      if (this.mediaMuxer == null) {
        this.mediaMuxer = new MediaMuxer(str, 0);
      }
      paramFile = selectCodec("video/avc");
      if (paramFile == null)
      {
        YtLogger.e(TAG, "Unable to find an appropriate codec for video/avc");
        return;
      }
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("found codec: ");
      localStringBuilder.append(paramFile.getName());
      YtLogger.i(str, localStringBuilder.toString());
      this.colorFormat = 21;
    }
    catch (IOException localIOException)
    {
      String str;
      StringBuilder localStringBuilder;
      label137:
      break label300;
    }
    try
    {
      paramInt1 = selectColorFormat(paramFile, "video/avc");
      this.colorFormat = paramInt1;
      this.realColorFormat = paramInt1;
    }
    catch (Exception localException)
    {
      break label137;
    }
    YtLogger.e(TAG, "Unable to find color format use default");
    this.colorFormat = 21;
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
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to create MediaCodec ");
      localStringBuilder.append(paramFile.getMessage());
      YtLogger.e(str, localStringBuilder.toString());
      return;
    }
    label300:
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to get path for ");
    localStringBuilder.append(paramFile);
    YtLogger.e(str, localStringBuilder.toString());
  }
  
  public void stopEncoding()
  {
    this.isEncodingStarted = false;
    if (!this.mNeedWork) {
      return;
    }
    if ((this.videoEncoder != null) && (this.mediaMuxer != null))
    {
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
    Log.i(TAG, "Failed to stop encoding since it never started");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder
 * JD-Core Version:    0.7.0.1
 */