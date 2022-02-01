package com.tribe.async.reactive;

import android.support.annotation.NonNull;

public class SimpleObserver<T>
  implements Observer<T>
{
  public void onCancel() {}
  
  public void onComplete() {}
  
  public void onError(@NonNull Error paramError) {}
  
  public void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.reactive.SimpleObserver
 * JD-Core Version:    0.7.0.1
 */