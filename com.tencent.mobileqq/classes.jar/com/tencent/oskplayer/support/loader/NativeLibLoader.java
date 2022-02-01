package com.tencent.oskplayer.support.loader;

public abstract interface NativeLibLoader
{
  public abstract NativeLibLoader.State isLibReadyToLoad(String paramString);
  
  public abstract void loadLibrary(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.support.loader.NativeLibLoader
 * JD-Core Version:    0.7.0.1
 */