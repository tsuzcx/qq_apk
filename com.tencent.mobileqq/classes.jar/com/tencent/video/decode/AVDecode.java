package com.tencent.video.decode;

import android.graphics.Bitmap;

public class AVDecode
  extends AbstractAVDecode
{
  private static final int AUDIO_FRAME_INDEX = 6;
  private static final int CHANNELS = 5;
  private static final int CONST_SIZE = 15;
  private static final int DURATION = 2;
  private static final int ERRCODE = 0;
  private static final int FRAME_COUNT = 6;
  private static final int FRAME_INDEX = 5;
  private static final int FRAME_RATE_DEN = 8;
  private static final int FRAME_RATE_NUM = 7;
  private static final int FRAME_ROTATION = 9;
  private static final int HEIGHT = 4;
  private static final int SAMPLE_NUM = 4;
  private static final int SAMPLE_RATE = 3;
  private static final int STREAM_KIND = 1;
  private static final int WIDTH = 3;
  private static volatile boolean sInitedDecodeEnv = false;
  private static Object sLock = new Object();
  private int audioFormat = 65281;
  private final int[] mAudioMetaData = new int[15];
  private final int[] mVideoMetaData = new int[15];
  private long nativeptr = 0L;
  
  private AVDecode(AVDecodeOption paramAVDecodeOption)
  {
    if (this.nativeptr != 0L)
    {
      this.audioFormat = paramAVDecodeOption.audioFormat;
      convertToAVParam(1447642447);
      convertToAVParam(1096108367);
      return;
    }
    AVDecodeError.throwException(this.mVideoMetaData[0]);
  }
  
  private static native void InitDecodeEnv();
  
  private void convertToAVParam(int paramInt)
  {
    if (paramInt == 1447642447)
    {
      this.videoParam.errcode = this.mVideoMetaData[0];
      this.videoParam.stream_kind = this.mVideoMetaData[1];
      this.videoParam.duration = this.mVideoMetaData[2];
      this.videoParam.width = this.mVideoMetaData[3];
      this.videoParam.height = this.mVideoMetaData[4];
      this.videoParam.frame_index = this.mVideoMetaData[5];
      this.videoParam.frame_count = this.mVideoMetaData[6];
      this.videoParam.fps_num = this.mVideoMetaData[7];
      this.videoParam.fps_den = this.mVideoMetaData[8];
      this.videoParam.rotation = this.mVideoMetaData[9];
      return;
    }
    if (paramInt == 1096108367)
    {
      this.audioParam.errcode = this.mAudioMetaData[0];
      this.audioParam.stream_kind = this.mAudioMetaData[1];
      this.audioParam.duration = this.mAudioMetaData[2];
      this.audioParam.sample_rate = this.mAudioMetaData[3];
      this.audioParam.numsample = this.mAudioMetaData[4];
      this.audioParam.channels = this.mAudioMetaData[5];
      this.audioParam.frameIndex = this.mAudioMetaData[6];
    }
  }
  
  private static void initDecodeGlobalEnv()
  {
    if (!sInitedDecodeEnv) {
      synchronized (sLock)
      {
        if (!sInitedDecodeEnv)
        {
          InitDecodeEnv();
          sInitedDecodeEnv = true;
        }
        return;
      }
    }
  }
  
  private native void nativeFreeFile(long paramLong);
  
  private native long nativeOpenFile(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private native void nativeResetState(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private native Object nativeSeekToNextAudioFrame(long paramLong, int[] paramArrayOfInt);
  
  private native int nativeSeekToNextFrame(long paramLong, Bitmap paramBitmap, int[] paramArrayOfInt);
  
  private native void nativeSetWantedFps(long paramLong, int paramInt, boolean paramBoolean);
  
  public static AVDecode newInstance(AVDecodeOption paramAVDecodeOption)
  {
    Object localObject = null;
    try
    {
      try
      {
        AbstractAVDecode.checkSoLoaded();
        initDecodeGlobalEnv();
        AVDecode localAVDecode = new AVDecode(paramAVDecodeOption);
        localObject = localAVDecode;
      }
      catch (AVideoException localAVideoException)
      {
        localAVideoException.printStackTrace();
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label30:
      break label30;
    }
    if (localObject != null) {
      localObject.setWantedFps((int)paramAVDecodeOption.wantedFps, paramAVDecodeOption.fixDuration);
    }
    return localObject;
  }
  
  public static AVDecode newInstanceUncatched(AVDecodeOption paramAVDecodeOption)
  {
    try
    {
      AbstractAVDecode.checkSoLoaded();
      initDecodeGlobalEnv();
      localAVDecode = new AVDecode(paramAVDecodeOption);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVDecode localAVDecode;
      label18:
      break label18;
    }
    AVDecodeError.throwException(-200);
    localAVDecode = null;
    if (localAVDecode != null) {
      localAVDecode.setWantedFps((int)paramAVDecodeOption.wantedFps, paramAVDecodeOption.fixDuration);
    }
    return localAVDecode;
  }
  
  private Object seekToNextAudioFrame()
  {
    AbstractAVDecode.checkSoLoaded();
    Object localObject1 = null;
    try
    {
      Object localObject2 = nativeSeekToNextAudioFrame(this.nativeptr, this.mAudioMetaData);
      localObject1 = localObject2;
      i = this.mAudioMetaData[0];
      localObject1 = localObject2;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      int i;
      label32:
      break label32;
    }
    i = -200;
    if (i != 0)
    {
      AVDecodeError.throwException(i);
      return localObject1;
    }
    convertToAVParam(1096108367);
    return localObject1;
  }
  
  private void setWantedFps(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (this.nativeptr != 0L) {
        nativeSetWantedFps(this.nativeptr, paramInt, paramBoolean);
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void close()
  {
    try
    {
      if (this.nativeptr != 0L)
      {
        nativeFreeFile(this.nativeptr);
        this.nativeptr = 0L;
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void resetVideoPlayer(AVDecodeOption paramAVDecodeOption)
  {
    try
    {
      nativeResetState(this.nativeptr, paramAVDecodeOption.cycle, paramAVDecodeOption.ignore_audio);
      i = 0;
    }
    catch (UnsatisfiedLinkError paramAVDecodeOption)
    {
      int i;
      label21:
      break label21;
    }
    i = -200;
    if (i != 0) {
      AVDecodeError.throwException(i);
    }
  }
  
  public byte[] seekToNextAudioByteFrame()
  {
    if (this.audioFormat != 65280) {
      AVDecodeError.throwException(-201);
    }
    return (byte[])seekToNextAudioFrame();
  }
  
  public float[] seekToNextAudioFloatFrame()
  {
    if (this.audioFormat != 65282) {
      AVDecodeError.throwException(-201);
    }
    return (float[])seekToNextAudioFrame();
  }
  
  public short[] seekToNextAudioShortFrame()
  {
    if (this.audioFormat != 65281) {
      AVDecodeError.throwException(-201);
    }
    return (short[])seekToNextAudioFrame();
  }
  
  public void seekToNextFrame(Bitmap paramBitmap)
  {
    
    try
    {
      i = nativeSeekToNextFrame(this.nativeptr, paramBitmap, this.mVideoMetaData);
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      int i;
      label20:
      break label20;
    }
    i = -200;
    if (i != 0)
    {
      AVDecodeError.throwException(i);
      return;
    }
    convertToAVParam(1447642447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.video.decode.AVDecode
 * JD-Core Version:    0.7.0.1
 */