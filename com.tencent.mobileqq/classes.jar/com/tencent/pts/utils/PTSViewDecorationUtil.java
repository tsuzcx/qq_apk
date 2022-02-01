package com.tencent.pts.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public final class PTSViewDecorationUtil
{
  private static final String TAG = "PTSViewDecorationUtil";
  private static RectF oval = new RectF();
  
  public static void drawBorderImp(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((paramCanvas == null) || (paramPaint == null)) {
      return;
    }
    paramFloat1 = Math.max(0.0F, paramFloat1);
    float f1 = Math.max(0.0F, paramFloat2);
    float f2 = Math.max(0.0F, paramFloat3);
    paramFloat4 = Math.max(0.0F, paramFloat4);
    paramFloat5 = Math.max(0.0F, paramFloat5);
    float f3 = paramFloat1 / 2.0F;
    if (f1 > 0.0F)
    {
      paramFloat2 = f1 + f3;
      label69:
      if (paramFloat5 <= 0.0F) {
        break label485;
      }
      paramFloat3 = paramInt2 - paramFloat5 - f3;
      label86:
      paramCanvas.drawLine(f3, Math.max(0.0F, paramFloat2), f3, Math.max(0.0F, paramFloat3), paramPaint);
      if (f1 <= 0.0F) {
        break label492;
      }
      paramFloat2 = f1 + f3;
      label121:
      if (f2 <= 0.0F) {
        break label499;
      }
      paramFloat3 = paramInt1 - f2 - f3;
      label138:
      paramCanvas.drawLine(Math.max(0.0F, paramFloat2), f3, Math.max(0.0F, paramFloat3), f3, paramPaint);
      if (f2 <= 0.0F) {
        break label509;
      }
      paramFloat2 = f2 + f3;
      label173:
      if (paramFloat4 <= 0.0F) {
        break label515;
      }
      paramFloat3 = paramInt2 - paramFloat4 - f3;
      label190:
      paramCanvas.drawLine(paramInt1 - f3, Math.max(0.0F, paramFloat2), paramInt1 - f3, Math.max(0.0F, paramFloat3), paramPaint);
      if (paramFloat5 <= 0.0F) {
        break label522;
      }
      paramFloat2 = paramFloat5 + f3;
      label231:
      if (paramFloat4 <= 0.0F) {
        break label529;
      }
    }
    label515:
    label522:
    label529:
    for (paramFloat1 = paramInt1 - paramFloat4 - f3;; paramFloat1 = paramInt1 - paramFloat1)
    {
      paramCanvas.drawLine(Math.max(0.0F, paramFloat2), paramInt2 - f3, Math.max(0.0F, paramFloat1), paramInt2 - f3, paramPaint);
      if (f1 > 0.0F)
      {
        oval.set(0.0F, 0.0F, 2.0F * f1, 2.0F * f1);
        oval.offset(f3, f3);
        paramCanvas.drawArc(oval, 180.0F, 90.0F, false, paramPaint);
      }
      if (f2 > 0.0F)
      {
        oval.set(paramInt1 - 2.0F * f2, 0.0F, paramInt1, 2.0F * f2);
        oval.offset(-f3, f3);
        paramCanvas.drawArc(oval, 270.0F, 90.0F, false, paramPaint);
      }
      if (paramFloat4 > 0.0F)
      {
        oval.set(paramInt1 - 2.0F * paramFloat4, paramInt2 - 2.0F * paramFloat4, paramInt1, paramInt2);
        oval.offset(-f3, -f3);
        paramCanvas.drawArc(oval, 0.0F, 90.0F, false, paramPaint);
      }
      if (paramFloat5 <= 0.0F) {
        break;
      }
      oval.set(0.0F, paramInt2 - 2.0F * paramFloat5, 2.0F * paramFloat5, paramInt2);
      oval.offset(f3, -f3);
      paramCanvas.drawArc(oval, 90.0F, 90.0F, false, paramPaint);
      return;
      paramFloat2 = 0.0F;
      break label69;
      label485:
      paramFloat3 = paramInt2;
      break label86;
      label492:
      paramFloat2 = paramFloat1;
      break label121;
      label499:
      paramFloat3 = paramInt1 - paramFloat1;
      break label138;
      label509:
      paramFloat2 = 0.0F;
      break label173;
      paramFloat3 = paramInt2;
      break label190;
      paramFloat2 = paramFloat1;
      break label231;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSViewDecorationUtil
 * JD-Core Version:    0.7.0.1
 */