package com.tencent.util;

public class StringBuilderUtils
{
  private static ThreadLocal<StringBuilder> a = new ThreadLocal();
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = (StringBuilder)a.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder();
      a.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.setLength(0);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.StringBuilderUtils
 * JD-Core Version:    0.7.0.1
 */