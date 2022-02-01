package com.tencent.qq.effect.alphavideo.videoplayer.interfaces;

public abstract interface IVideoFileDecoder
{
  public abstract int createDecoder(String paramString, Object paramObject);
  
  public abstract void decode();
  
  public abstract long getCurPresentationTimeUs();
  
  public abstract IVideoFileDecodeListener getDecodeListener();
  
  public abstract void release();
  
  public abstract void setDecodeListener(IVideoFileDecodeListener paramIVideoFileDecodeListener);
  
  public abstract void setLoopState(boolean paramBoolean);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder
 * JD-Core Version:    0.7.0.1
 */