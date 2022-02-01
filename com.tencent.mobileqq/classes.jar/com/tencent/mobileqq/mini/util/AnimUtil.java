package com.tencent.mobileqq.mini.util;

import android.app.Activity;

public class AnimUtil
{
  public static void clearAnim(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public static void setCloseAnim(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(2130772010, 2130772015);
    }
  }
  
  public static void setOpenAnim(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      paramActivity.overridePendingTransition(2130772011, 2130772014);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.AnimUtil
 * JD-Core Version:    0.7.0.1
 */