package com.tencent.qqlive.module.videoreport.utils;

import android.app.Activity;

public class ActivityCompat
{
  private static volatile boolean sCanGetResumeField = true;
  
  public static boolean isResumed(Activity paramActivity)
  {
    if (!sCanGetResumeField) {
      return false;
    }
    try
    {
      paramActivity = ReflectUtils.getFieldWithException(Activity.class, "mResumed", paramActivity);
      if ((paramActivity instanceof Boolean))
      {
        bool = ((Boolean)paramActivity).booleanValue();
        if (!bool) {}
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramActivity)
    {
      sCanGetResumeField = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ActivityCompat
 * JD-Core Version:    0.7.0.1
 */