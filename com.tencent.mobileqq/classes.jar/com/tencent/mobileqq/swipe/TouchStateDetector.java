package com.tencent.mobileqq.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public class TouchStateDetector
{
  private static double a = 0.25D;
  private static double b = 0.5D;
  private static float c;
  private static float d;
  private static float e;
  private int f;
  private int g;
  
  public TouchStateDetector(Context paramContext)
  {
    a(paramContext);
    paramContext = paramContext.getResources();
    c = paramContext.getDimensionPixelSize(2131298244);
    d = paramContext.getDimensionPixelSize(2131298245);
    e = paramContext.getDimensionPixelSize(2131298243);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      this.f = paramContext.getDefaultDisplay().getWidth();
      this.g = paramContext.getDefaultDisplay().getHeight();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("TouchStateDetector", 1, paramContext, new Object[0]);
    }
  }
  
  public double a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    paramMotionEvent.getRawY();
    double d1 = f1;
    double d2 = a;
    int i = this.f;
    double d3 = i;
    Double.isNaN(d3);
    if (d1 <= d3 * d2) {
      return 0.0D;
    }
    d3 = b;
    double d4 = i;
    Double.isNaN(d4);
    if (d1 >= d4 * d3) {
      return 1.0D;
    }
    d4 = i;
    Double.isNaN(d4);
    Double.isNaN(d1);
    double d5 = i;
    Double.isNaN(d5);
    return (d1 - d4 * d2) / ((d3 - d2) * d5);
  }
  
  public boolean a(MotionEvent paramMotionEvent, Context paramContext)
  {
    return (a(paramMotionEvent) + 1.0E-008D > 1.0D) && (paramMotionEvent.getRawX() > this.f - d) && (paramMotionEvent.getRawY() > this.g - c - e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.swipe.TouchStateDetector
 * JD-Core Version:    0.7.0.1
 */