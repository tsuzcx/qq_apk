package com.tencent.mobileqq.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;

@Deprecated
public class ReflectionUtil
{
  public static int a(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext)
    {
      label15:
      break label15;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */