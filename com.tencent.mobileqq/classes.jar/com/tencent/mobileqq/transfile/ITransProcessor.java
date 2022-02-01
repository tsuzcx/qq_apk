package com.tencent.mobileqq.transfile;

public abstract interface ITransProcessor
{
  public abstract int cancel();
  
  public abstract int checkParam();
  
  public abstract void pause();
  
  public abstract int resume();
  
  public abstract void retry();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ITransProcessor
 * JD-Core Version:    0.7.0.1
 */