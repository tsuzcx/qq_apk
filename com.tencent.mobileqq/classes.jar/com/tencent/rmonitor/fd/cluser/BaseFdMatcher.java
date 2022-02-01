package com.tencent.rmonitor.fd.cluser;

abstract class BaseFdMatcher
  implements IFdMatcher
{
  private final int a;
  
  BaseFdMatcher(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.cluser.BaseFdMatcher
 * JD-Core Version:    0.7.0.1
 */