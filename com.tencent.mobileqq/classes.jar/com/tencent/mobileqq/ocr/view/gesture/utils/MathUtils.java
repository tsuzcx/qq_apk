package com.tencent.mobileqq.ocr.view.gesture.utils;

import android.graphics.Matrix;
import com.tencent.mobileqq.ocr.view.gesture.state.State;

public class MathUtils
{
  private static final Matrix a = new Matrix();
  private static final Matrix b = new Matrix();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static void a(State paramState1, State paramState2, float paramFloat1, float paramFloat2, State paramState3, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramState1.a(paramState2);
    if (!State.a(paramState2.c(), paramState3.c())) {
      paramState1.b(b(paramState2.c(), paramState3.c(), paramFloat5), paramFloat1, paramFloat2);
    }
    float f2 = paramState2.d();
    float f3 = paramState3.d();
    float f1;
    if (Math.abs(f2 - f3) <= 180.0F)
    {
      if (State.a(f2, f3)) {
        break label189;
      }
      f1 = b(f2, f3, paramFloat5);
    }
    for (;;)
    {
      if (!Float.isNaN(f1)) {
        paramState1.d(f1, paramFloat1, paramFloat2);
      }
      paramState1.a(b(0.0F, paramFloat3 - paramFloat1, paramFloat5), b(0.0F, paramFloat4 - paramFloat2, paramFloat5));
      return;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = f2 + 360.0F;
      }
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = f3 + 360.0F;
      }
      if (!State.a(f1, f2)) {
        f1 = b(f1, f2, paramFloat5);
      } else {
        label189:
        f1 = (0.0F / 0.0F);
      }
    }
  }
  
  public static void a(State paramState1, State paramState2, State paramState3, float paramFloat)
  {
    a(paramState1, paramState2, paramState2.a(), paramState2.b(), paramState3, paramState3.a(), paramState3.b(), paramFloat);
  }
  
  public static void a(float[] paramArrayOfFloat, State paramState1, State paramState2)
  {
    paramState1.a(a);
    a.invert(b);
    b.mapPoints(paramArrayOfFloat);
    paramState2.a(a);
    a.mapPoints(paramArrayOfFloat);
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.utils.MathUtils
 * JD-Core Version:    0.7.0.1
 */