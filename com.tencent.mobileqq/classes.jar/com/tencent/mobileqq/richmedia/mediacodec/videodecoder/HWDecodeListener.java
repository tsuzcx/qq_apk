package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

public abstract interface HWDecodeListener
{
  public static final int DECODE_CONFIG_ERROR = 1;
  public static final int DECODE_FRAME_ERROR = 3;
  public static final int DECODE_START_ERROR = 2;
  
  public abstract void onDecodeCancel();
  
  public abstract void onDecodeError(int paramInt, Throwable paramThrowable);
  
  public abstract void onDecodeFinish();
  
  public abstract void onDecodeFrame(long paramLong1, long paramLong2);
  
  public abstract void onDecodeRepeat();
  
  public abstract void onDecodeSeekTo(long paramLong);
  
  public abstract void onDecodeStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
 * JD-Core Version:    0.7.0.1
 */