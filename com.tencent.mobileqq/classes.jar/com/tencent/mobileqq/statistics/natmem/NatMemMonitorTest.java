package com.tencent.mobileqq.statistics.natmem;

public class NatMemMonitorTest
{
  boolean a = false;
  
  private NatMemMonitorTest()
  {
    if (!this.a) {
      a();
    }
  }
  
  public void a()
  {
    System.loadLibrary("monitortest");
    this.a = true;
  }
  
  public native int accessMemory(long paramLong);
  
  public native int findInMaps(int paramInt, long paramLong);
  
  public native int findTarget(int paramInt, long paramLong);
  
  public native int getRegInThread(int paramInt);
  
  public native void printMainThreadStat(int paramInt);
  
  public native int printMaps(int paramInt);
  
  public native void printProcessStat(int paramInt);
  
  public native int printsMaps(int paramInt);
  
  public native int startTestThread();
  
  public native int testMalloc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NatMemMonitorTest
 * JD-Core Version:    0.7.0.1
 */