package com.tencent.ttpic.video;

public abstract interface AEEncoder
{
  public abstract void release();
  
  public abstract int writeFrame(int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.video.AEEncoder
 * JD-Core Version:    0.7.0.1
 */