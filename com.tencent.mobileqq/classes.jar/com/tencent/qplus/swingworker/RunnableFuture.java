package com.tencent.qplus.swingworker;

import java.util.concurrent.Future;

public abstract interface RunnableFuture<V>
  extends Runnable, Future<V>
{
  public abstract void run();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.swingworker.RunnableFuture
 * JD-Core Version:    0.7.0.1
 */