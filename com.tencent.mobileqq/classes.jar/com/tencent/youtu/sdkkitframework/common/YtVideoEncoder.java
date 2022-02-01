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
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.io.IOException;
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
  private int colorFormat = 21;
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
  private int realColorFormat = 0;
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
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      this.yuvnv12[paramInt2] = paramYuvImage[paramInt2];
      paramInt2 += 1;
    }
    int j = paramInt1 / 4 + paramInt1;
    paramInt2 = paramInt1;
    int i = paramInt1;
    while (i < paramInt1 * 3 / 2)
    {
      this.yuvnv12[j] = paramYuvImage[(i + 1)];
      this.yuvnv12[paramInt2] = paramYuvImage[i];
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
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mediaCodec.getInputBuffer(paramInt);
    }
    return this.mediaCodec.getInputBuffers()[paramInt];
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
  
  private ByteBuffer getOutputBuffer(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mediaCodec.getOutputBuffer(paramInt);
    }
    return this.mediaCodec.getOutputBuffers()[paramInt];
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
        ??? = convertYUV(mWidth, mHeight, (YuvImage)???);
        int i = this.mediaCodec.dequeueInputBuffer(200000L);
        long l = computePresentationTime(this.mGenerateIndex, 30);
        if (i >= 0)
        {
          localObject2 = getInputBuffer(i);
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
        ByteBuffer localByteBuffer = getOutputBuffer(i);
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
  
  public int getColorFormat()
  {
    return this.realColorFormat;
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
  
  public void startEncoding(int paramInt1, int paramInt2, File paramFile)
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
    YtLogger.d(TAG, "found codec: " + paramFile.getName());
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
          this.mediaCodec = MediaCodec.createByCodecName(paramFile.getName());
          paramFile = MediaFormat.createVideoFormat("video/avc", mWidth, mHeight);
          paramFile.setInteger("bitrate", 16000000);
          paramFile.setInteger("frame-rate", 30);
          paramFile.setInteger("color-format", this.colorFormat);
          paramFile.setInteger("i-frame-interval", 1);
          this.mediaCodec.configure(paramFile, null, null, 1);
          this.mediaCodec.start();
        }
        catch (IOException paramFile)
        {
          YtLogger.e(TAG, "Unable to create MediaCodec " + paramFile.getMessage());
          return;
        }
        try
        {
          this.mediaMuxer = new MediaMuxer(localIOException, 0);
          YtLogger.d(TAG, "Initialization complete. Starting encoder...");
          return;
        }
        catch (IOException paramFile)
        {
          YtLogger.e(TAG, "MediaMuxer creation failed. " + paramFile.getMessage());
        }
        localException = localException;
        this.colorFormat = 21;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder
 * JD-Core Version:    0.7.0.1
 */