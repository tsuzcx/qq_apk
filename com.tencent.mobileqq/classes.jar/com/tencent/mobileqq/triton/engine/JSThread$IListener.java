package com.tencent.mobileqq.triton.engine;

public abstract interface JSThread$IListener
{
  public abstract void onExit();
  
  public abstract boolean onPrepare();
  
  public abstract boolean onVSync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread.IListener
 * JD-Core Version:    0.7.0.1
 */