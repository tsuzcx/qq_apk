package com.tribe.async.reactive;

import android.support.annotation.NonNull;

public abstract interface Observer<T>
{
  public abstract void onCancel();
  
  public abstract void onComplete();
  
  public abstract void onError(@NonNull Error paramError);
  
  public abstract void onNext(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.reactive.Observer
 * JD-Core Version:    0.7.0.1
 */