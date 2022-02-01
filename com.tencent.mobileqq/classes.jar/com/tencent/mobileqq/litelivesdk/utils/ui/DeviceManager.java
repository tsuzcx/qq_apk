package com.tencent.mobileqq.litelivesdk.utils.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public final class DeviceManager
{
  private static float a;
  
  public static int a(@NonNull Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId()))) && (localViewGroup.getChildAt(i).getVisibility() == 0)) {
          return localViewGroup.getChildAt(i).getLayoutParams().height;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    double d1 = paramContext.getResources().getDisplayMetrics().density;
    double d2 = paramFloat;
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d2 * d1 + 0.5D);
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (a == 0.0F)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      if (paramContext != null) {
        a = paramContext.density;
      }
    }
    return (int)(paramInt / a + 0.5F);
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ui.DeviceManager
 * JD-Core Version:    0.7.0.1
 */