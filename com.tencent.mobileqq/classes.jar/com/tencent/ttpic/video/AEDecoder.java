package com.tencent.ttpic.video;

public abstract interface AEDecoder
{
  public abstract int getNextFrameTexture();
  
  public abstract void release();
  
  public abstract void setTexture(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.video.AEDecoder
 * JD-Core Version:    0.7.0.1
 */