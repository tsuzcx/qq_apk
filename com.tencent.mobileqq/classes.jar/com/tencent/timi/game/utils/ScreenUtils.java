package com.tencent.timi.game.utils;

import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.BaseApplication;

public final class ScreenUtils
{
  private ScreenUtils()
  {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }
  
  public static int a()
  {
    WindowManager localWindowManager = (WindowManager)BaseApplication.getContext().getSystemService("window");
    if (localWindowManager == null) {
      return -1;
    }
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
    } else {
      localWindowManager.getDefaultDisplay().getSize(localPoint);
    }
    return localPoint.x;
  }
  
  public static int b()
  {
    WindowManager localWindowManager = (WindowManager)BaseApplication.getContext().getSystemService("window");
    if (localWindowManager == null) {
      return -1;
    }
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
    } else {
      localWindowManager.getDefaultDisplay().getSize(localPoint);
    }
    return localPoint.y;
  }
  
  public static int c()
  {
    WindowManager localWindowManager = (WindowManager)BaseApplication.getContext().getSystemService("window");
    if (localWindowManager == null) {
      return -1;
    }
    Point localPoint = new Point();
    localWindowManager.getDefaultDisplay().getSize(localPoint);
    return localPoint.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.ScreenUtils
 * JD-Core Version:    0.7.0.1
 */