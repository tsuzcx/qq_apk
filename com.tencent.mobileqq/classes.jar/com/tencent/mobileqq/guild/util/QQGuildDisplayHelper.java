package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;

public class QQGuildDisplayHelper
{
  public static int a(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int b(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext == null) {
      return -1;
    }
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getDefaultDisplay().getRealSize(localPoint);
    } else {
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    return localPoint.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildDisplayHelper
 * JD-Core Version:    0.7.0.1
 */