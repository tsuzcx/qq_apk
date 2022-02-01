package com.tencent.qqmusic.mediaplayer.upstream;

import java.util.concurrent.TimeUnit;

public abstract interface UriLoader
{
  public abstract void cancelLoading();
  
  public abstract boolean isLoading();
  
  public abstract void startLoading(int paramInt, TimeUnit paramTimeUnit, UriLoader.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.UriLoader
 * JD-Core Version:    0.7.0.1
 */