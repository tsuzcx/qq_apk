package com.tribe.async.dispatch;

import android.support.annotation.NonNull;

public abstract interface HandlerPoster$PosterRunner
{
  public abstract boolean acceptTag(Object paramObject);
  
  public abstract void run(@NonNull String paramString, @NonNull Dispatcher.Dispatchable paramDispatchable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.HandlerPoster.PosterRunner
 * JD-Core Version:    0.7.0.1
 */