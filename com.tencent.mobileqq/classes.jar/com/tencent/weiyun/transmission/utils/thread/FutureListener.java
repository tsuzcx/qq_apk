package com.tencent.weiyun.transmission.utils.thread;

public abstract interface FutureListener<T>
{
  public abstract void onFutureBegin(Future<T> paramFuture);
  
  public abstract void onFutureDone(Future<T> paramFuture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.thread.FutureListener
 * JD-Core Version:    0.7.0.1
 */