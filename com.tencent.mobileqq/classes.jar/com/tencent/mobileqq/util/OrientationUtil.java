package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.util.VersionUtils;

public class OrientationUtil
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    int k = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getOrientation();
    int i = paramActivity.getResources().getConfiguration().orientation;
    int j = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        i = j;
      }
      else
      {
        i = j;
        if (k != 0)
        {
          i = j;
          if (k != 1)
          {
            i = j;
            if (VersionUtils.c()) {
              i = 8;
            }
          }
        }
      }
    }
    else if ((k != 0) && (k != 3) && (VersionUtils.c())) {
      i = 9;
    } else {
      i = 1;
    }
    paramActivity.setRequestedOrientation(i);
  }
  
  public static void b(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.OrientationUtil
 * JD-Core Version:    0.7.0.1
 */