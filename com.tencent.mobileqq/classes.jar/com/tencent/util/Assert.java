package com.tencent.util;

public class Assert
{
  public static void a(Object paramObject)
  {
    a((String)null, paramObject);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      throw new AssertionError();
    }
    throw new AssertionError(paramString);
  }
  
  public static void a(String paramString, Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramString, bool);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a((String)null, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.Assert
 * JD-Core Version:    0.7.0.1
 */