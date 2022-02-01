package com.tencent.mtt.hippy.common;

public class HippyJsException
  extends Exception
{
  private final String mStack;
  private String[] mStackTrace;
  
  public HippyJsException(String paramString1, String paramString2)
  {
    super(paramString1);
    this.mStack = paramString2;
  }
  
  public String getStack()
  {
    return this.mStack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyJsException
 * JD-Core Version:    0.7.0.1
 */