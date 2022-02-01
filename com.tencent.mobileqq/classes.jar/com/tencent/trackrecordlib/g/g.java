package com.tencent.trackrecordlib.g;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class g
{
  private static final String a = "g";
  private static int b = -1;
  
  public static int a(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    if (b == -1)
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext != null)
      {
        paramContext = paramContext.getDefaultDisplay();
        Point localPoint = new Point();
        paramContext.getSize(localPoint);
        b = localPoint.y;
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.g
 * JD-Core Version:    0.7.0.1
 */