package com.tencent.superplayer.api;

public abstract interface ISPlayerImageGenerator
{
  public abstract void generateImageAsyncAtTime(long paramLong, ISPlayerImageGenerator.ImageGeneratorParams paramImageGeneratorParams, ISPlayerImageGenerator.Listener paramListener);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerImageGenerator
 * JD-Core Version:    0.7.0.1
 */