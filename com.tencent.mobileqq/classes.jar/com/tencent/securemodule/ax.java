package com.tencent.securemodule;

import android.util.Log;

public final class ax
{
  private static boolean a = true;
  private static aw b = new bc();
  
  public static void a(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      Log.e(paramString, "log message is null");
      return;
    }
    if ((paramObject instanceof Exception))
    {
      ((Exception)paramObject).printStackTrace();
      return;
    }
    b.b(paramString, paramObject.toString());
  }
  
  public static void b(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      Log.e(paramString, "log message is null");
      return;
    }
    b.a(paramString, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.ax
 * JD-Core Version:    0.7.0.1
 */