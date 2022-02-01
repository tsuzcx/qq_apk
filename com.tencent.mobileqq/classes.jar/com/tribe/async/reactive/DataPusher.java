package com.tribe.async.reactive;

public abstract class DataPusher<T>
  implements AsyncFunction<Observer<T>>
{
  public abstract void cancel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.reactive.DataPusher
 * JD-Core Version:    0.7.0.1
 */