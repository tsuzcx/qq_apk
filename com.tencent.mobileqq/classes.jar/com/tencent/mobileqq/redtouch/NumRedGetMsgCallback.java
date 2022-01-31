package com.tencent.mobileqq.redtouch;

import java.util.List;

public abstract class NumRedGetMsgCallback
{
  private static int b;
  public int a;
  
  public NumRedGetMsgCallback()
  {
    int i = b;
    b = i + 1;
    this.a = i;
  }
  
  public abstract void a(String paramString, List paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedGetMsgCallback
 * JD-Core Version:    0.7.0.1
 */