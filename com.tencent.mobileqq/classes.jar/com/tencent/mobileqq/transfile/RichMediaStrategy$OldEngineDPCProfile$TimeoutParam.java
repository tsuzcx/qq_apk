package com.tencent.mobileqq.transfile;

public class RichMediaStrategy$OldEngineDPCProfile$TimeoutParam
{
  int a = 40000;
  int b = 30000;
  int c = 20000;
  int d = 20000;
  int e = 15000;
  int f = 10000;
  private int g;
  
  public RichMediaStrategy$OldEngineDPCProfile$TimeoutParam() {}
  
  private RichMediaStrategy$OldEngineDPCProfile$TimeoutParam(TimeoutParam paramTimeoutParam)
  {
    this.a = paramTimeoutParam.a;
    this.b = paramTimeoutParam.b;
    this.c = paramTimeoutParam.c;
    this.d = paramTimeoutParam.d;
    this.e = paramTimeoutParam.e;
    this.f = paramTimeoutParam.f;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.a;
    case 1: 
    case 4: 
    case 5: 
      return this.c;
    }
    return this.b;
  }
  
  public TimeoutParam a()
  {
    return new TimeoutParam(this);
  }
  
  public void a(int paramInt)
  {
    this.g = (paramInt * 2000);
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.d + this.g;
    case 1: 
    case 4: 
    case 5: 
      return this.f + this.g;
    }
    return this.e + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile.TimeoutParam
 * JD-Core Version:    0.7.0.1
 */