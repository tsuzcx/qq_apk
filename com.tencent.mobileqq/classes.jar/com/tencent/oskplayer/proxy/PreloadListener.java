package com.tencent.oskplayer.proxy;

public abstract interface PreloadListener
{
  public abstract void onFinish(String paramString);
  
  public abstract void onStart(String paramString);
  
  public abstract void onUpdate(String paramString, long paramLong1, long paramLong2, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.PreloadListener
 * JD-Core Version:    0.7.0.1
 */