package com.tencent.mobileqq.shortvideo.resource;

public abstract interface GestureResource
{
  public abstract String getGestureGapFrame();
  
  public abstract String getGestureGapTime();
  
  public abstract boolean getGestureShouldUpload();
  
  public abstract String getGestureThreadColdTime();
  
  public abstract String getModelPath();
  
  public abstract String getSoPathDir();
  
  public abstract boolean isGestureEnable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.resource.GestureResource
 * JD-Core Version:    0.7.0.1
 */