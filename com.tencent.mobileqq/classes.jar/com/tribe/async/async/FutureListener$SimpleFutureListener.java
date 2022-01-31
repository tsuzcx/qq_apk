package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class FutureListener$SimpleFutureListener<Progress, Result>
  implements FutureListener<Progress, Result>
{
  public void onFutureCanceled() {}
  
  public void onFutureDone(@Nullable Result paramResult) {}
  
  public void onFutureProgress(@NonNull Progress paramProgress) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.async.FutureListener.SimpleFutureListener
 * JD-Core Version:    0.7.0.1
 */