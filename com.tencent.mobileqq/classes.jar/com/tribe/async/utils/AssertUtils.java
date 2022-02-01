package com.tribe.async.utils;

public class AssertUtils
{
  private static final boolean DEBUG = true;
  
  public static void assertTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError();
  }
  
  public static void assertTrue(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError(paramString);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
  
  public static void fail(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      paramString = String.format(paramString, paramVarArgs);
    }
    throw new AssertionError(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.utils.AssertUtils
 * JD-Core Version:    0.7.0.1
 */