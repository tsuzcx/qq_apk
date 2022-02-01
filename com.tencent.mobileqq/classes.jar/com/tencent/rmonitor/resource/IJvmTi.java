package com.tencent.rmonitor.resource;

public abstract interface IJvmTi
{
  public abstract boolean canUseJvmTi();
  
  public abstract long[] getGcInfo();
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.IJvmTi
 * JD-Core Version:    0.7.0.1
 */