package com.tencent.qqlive.module.videoreport.utils;

import android.app.Activity;

public class ActivityCompat
{
  private static volatile boolean sCanGetResumeField = true;
  
  public static boolean isResumed(Activity paramActivity)
  {
    boolean bool1 = sCanGetResumeField;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    try
    {
      paramActivity = ReflectUtils.getFieldWithException(Activity.class, "mResumed", paramActivity);
      bool1 = bool2;
      if ((paramActivity instanceof Boolean))
      {
        boolean bool3 = ((Boolean)paramActivity).booleanValue();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramActivity)
    {
      label48:
      break label48;
    }
    sCanGetResumeField = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ActivityCompat
 * JD-Core Version:    0.7.0.1
 */