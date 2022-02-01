package com.tencent.mobileqq.ocr.view.gesture.utils;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.state.State;

public class GravityUtils
{
  private static final Matrix a = new Matrix();
  private static final RectF b = new RectF();
  private static final Rect c = new Rect();
  private static final Rect d = new Rect();
  
  public static void a(Matrix paramMatrix, Settings paramSettings, Rect paramRect)
  {
    b.set(0.0F, 0.0F, paramSettings.g(), paramSettings.h());
    paramMatrix.mapRect(b);
    int i = Math.round(b.width());
    int j = Math.round(b.height());
    c.set(0, 0, paramSettings.c(), paramSettings.d());
    Gravity.apply(paramSettings.p(), i, j, c, paramRect);
  }
  
  public static void a(Settings paramSettings, Point paramPoint)
  {
    a(paramSettings, d);
    Gravity.apply(paramSettings.p(), 0, 0, d, c);
    paramPoint.set(c.left, c.top);
  }
  
  public static void a(Settings paramSettings, Rect paramRect)
  {
    c.set(0, 0, paramSettings.c(), paramSettings.d());
    Gravity.apply(paramSettings.p(), paramSettings.e(), paramSettings.f(), c, paramRect);
  }
  
  public static void a(State paramState, Settings paramSettings, Rect paramRect)
  {
    paramState.a(a);
    a(a, paramSettings, paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.utils.GravityUtils
 * JD-Core Version:    0.7.0.1
 */