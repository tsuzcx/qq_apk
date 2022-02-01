package com.tencent.qqmusic.mediaplayer.upstream;

import androidx.annotation.NonNull;

public abstract interface Loader
{
  public abstract void cancelLoading();
  
  public abstract long getUpstreamSize();
  
  public abstract boolean isLoading();
  
  public abstract void prepare();
  
  public abstract void shutdown();
  
  public abstract void startLoading(@NonNull Chunk paramChunk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.Loader
 * JD-Core Version:    0.7.0.1
 */