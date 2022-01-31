package com.tencent.open;

import cooperation.qqfav.util.Logger;

public class OpenLog
{
  private static Logger a;
  
  private static Logger a()
  {
    try
    {
      if (a == null)
      {
        a = new Logger();
        a.a("OpenLog");
        a.a(4);
      }
      Logger localLogger = a;
      return localLogger;
    }
    finally {}
  }
  
  public static Logger a(String paramString1, int paramInt, String paramString2)
  {
    return a().c(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.OpenLog
 * JD-Core Version:    0.7.0.1
 */