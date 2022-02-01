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
  private static float a = 0.0F;
  
  public static int a(@NonNull Activity paramActivity)
  {
    int k = 0;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    int j = k;
    int i;
    if (localViewGroup != null) {
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < localViewGroup.getChildCount())
      {
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId()))) && (localViewGroup.getChildAt(i).getVisibility() == 0)) {
          j = localViewGroup.getChildAt(i).getLayoutParams().height;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5D);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ui.DeviceManager
 * JD-Core Version:    0.7.0.1
 */