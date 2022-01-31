package com.tribe.async.utils;

public class AssertUtils
{
  private static final boolean DEBUG = true;
  
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
  
  public static void assertTrue(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static void fail(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      throw new AssertionError(paramString);
      paramString = String.format(paramString, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.utils.AssertUtils
 * JD-Core Version:    0.7.0.1
 */