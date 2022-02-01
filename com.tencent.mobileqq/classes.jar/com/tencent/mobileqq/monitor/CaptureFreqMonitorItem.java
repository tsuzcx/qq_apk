package com.tencent.mobileqq.monitor;

public class CaptureFreqMonitorItem
{
  volatile boolean a = false;
  public long[] b = new long[4];
  public int c;
  long d;
  long e;
  int f;
  int g;
  int[] h;
  int[] i;
  
  public CaptureFreqMonitorItem() {}
  
  public CaptureFreqMonitorItem(int paramInt)
  {
    this.b = new long[paramInt];
  }
  
  public void a()
  {
    int j = 0;
    this.f = 0;
    this.g = 0;
    for (;;)
    {
      long[] arrayOfLong = this.b;
      if (j >= arrayOfLong.length) {
        break;
      }
      arrayOfLong[j] = 0L;
      j += 1;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.a)
    {
      long[] arrayOfLong = this.b;
      if (arrayOfLong[paramInt] == 0L) {
        arrayOfLong[paramInt] = paramLong;
      }
    }
  }
  
  public void a(Integer... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (this.f >= 400) {
        return;
      }
      if (paramVarArgs.length == 1)
      {
        if (this.h == null) {
          this.h = new int[400];
        }
        this.h[this.f] = paramVarArgs[0].intValue();
      }
      else if (paramVarArgs.length == 2)
      {
        if (this.h == null) {
          this.h = new int[400];
        }
        if (this.i == null) {
          this.i = new int[400];
        }
        this.h[this.f] = paramVarArgs[0].intValue();
        this.i[this.f] = paramVarArgs[1].intValue();
      }
      this.f += 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    return System.currentTimeMillis() - this.d >= paramInt;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public void c()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.d = System.currentTimeMillis();
    a();
  }
  
  public void d()
  {
    this.a = false;
    this.e = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.monitor.CaptureFreqMonitorItem
 * JD-Core Version:    0.7.0.1
 */