package com.tencent.mtt.hippy.utils;

import android.content.Context;

public class ContextHolder
{
  private static Context sAppContext;
  
  public static Context getAppContext()
  {
    return sAppContext;
  }
  
  public static void initAppContext(Context paramContext)
  {
    if (paramContext != null) {
      sAppContext = paramContext.getApplicationContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.ContextHolder
 * JD-Core Version:    0.7.0.1
 */