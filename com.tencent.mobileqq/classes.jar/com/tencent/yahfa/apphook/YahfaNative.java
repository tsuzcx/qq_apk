package com.tencent.yahfa.apphook;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class YahfaNative
{
  static
  {
    try
    {
      System.loadLibrary("yahfahook");
      return;
    }
    catch (Exception localException)
    {
      YahfaLog.e("loadLibrary error", localException);
    }
  }
  
  public static native void yahfaHook(Member paramMember, Method paramMethod1, Method paramMethod2);
  
  public static native void yahfaInit(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.YahfaNative
 * JD-Core Version:    0.7.0.1
 */