package com.tencent.mtt.hippy.utils;

import android.content.Context;

public class ContextHolder
{
  private static Context appContext;
  
  public static Context getAppContext()
  {
    return appContext;
  }
  
  public static void initAppContext(Context paramContext)
  {
    if ((paramContext != null) && (appContext == null)) {
      appContext = paramContext.getApplicationContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.ContextHolder
 * JD-Core Version:    0.7.0.1
 */