package com.tencent.ttpic.baseutils.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;

public class StatusBarUtil
{
  private static int sStatusBarHeight;
  
  public static int getStatusBarHeight()
  {
    if (sStatusBarHeight == 0) {
      sStatusBarHeight = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }
    return sStatusBarHeight;
  }
  
  public static boolean translucentStatusBar(Activity paramActivity)
  {
    return (paramActivity != null) && (translucentStatusBar(paramActivity.getWindow()));
  }
  
  public static boolean translucentStatusBar(Dialog paramDialog)
  {
    return (paramDialog != null) && (translucentStatusBar(paramDialog.getWindow()));
  }
  
  public static boolean translucentStatusBar(Window paramWindow)
  {
    if (paramWindow == null) {}
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 19);
      if (Build.VERSION.SDK_INT < 21) {
        break;
      }
    } while (paramWindow.getDecorView() == null);
    paramWindow.clearFlags(67108864);
    paramWindow.getDecorView().setSystemUiVisibility(1280);
    paramWindow.addFlags(-2147483648);
    paramWindow.setStatusBarColor(0);
    return true;
    paramWindow.addFlags(67108864);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.view.StatusBarUtil
 * JD-Core Version:    0.7.0.1
 */