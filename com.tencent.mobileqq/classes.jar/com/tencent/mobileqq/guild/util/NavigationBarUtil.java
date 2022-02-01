package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class NavigationBarUtil
{
  public static int a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return 0;
    }
    Object localObject = paramActivity.getWindow().getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      ((Display)localObject).getRealSize(localPoint);
    } else {
      ((Display)localObject).getSize(localPoint);
    }
    localObject = paramActivity.getWindow().getDecorView();
    if (2 == paramActivity.getResources().getConfiguration().orientation)
    {
      paramActivity = ((View)localObject).findViewById(16908290);
      return Math.abs(localPoint.x - paramActivity.getWidth());
    }
    paramActivity = new Rect();
    ((View)localObject).getWindowVisibleDisplayFrame(paramActivity);
    return Math.abs(paramActivity.bottom - localPoint.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.NavigationBarUtil
 * JD-Core Version:    0.7.0.1
 */