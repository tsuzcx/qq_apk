package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract interface FutureListener<Progress, Result>
{
  public abstract void onFutureCanceled();
  
  public abstract void onFutureDone(@Nullable Result paramResult);
  
  public abstract void onFutureProgress(@NonNull Progress paramProgress);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.async.FutureListener
 * JD-Core Version:    0.7.0.1
 */