package com.tribe.async.parallel;

import com.tribe.async.reactive.AsyncFunction;

public abstract class DataPusher
  implements AsyncFunction<Observer>
{
  public abstract void cancel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.parallel.DataPusher
 * JD-Core Version:    0.7.0.1
 */