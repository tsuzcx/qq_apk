package com.tencent.mtt.supportui.utils;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class ViewCompatTool
{
  public static final int FAKE_FRAME_TIME = 16;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;
  public static int sdkVersion = Build.VERSION.SDK_INT;
  
  @TargetApi(16)
  public static int getMinimumHeight(View paramView)
  {
    if (sdkVersion >= 16) {
      return paramView.getMinimumHeight();
    }
    return 0;
  }
  
  @TargetApi(16)
  public static int getMinimumWidth(View paramView)
  {
    if (sdkVersion >= 16) {
      return paramView.getMinimumWidth();
    }
    return 0;
  }
  
  @TargetApi(16)
  public static void postInvalidateOnAnimation(View paramView)
  {
    if (sdkVersion >= 16)
    {
      paramView.postInvalidateOnAnimation();
      return;
    }
    paramView.postInvalidateDelayed(16L);
  }
  
  @TargetApi(16)
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    if (sdkVersion >= 16)
    {
      paramView.postOnAnimation(paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
  
  public static void setDefaultLayotuDirection(View paramView)
  {
    setLayoutDirection(paramView, 0);
  }
  
  @TargetApi(17)
  public static void setLayoutDirection(View paramView, int paramInt)
  {
    if (sdkVersion >= 17) {
      paramView.setLayoutDirection(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.ViewCompatTool
 * JD-Core Version:    0.7.0.1
 */