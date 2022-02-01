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
    if (paramCanvas != null)
    {
      if (paramPaint == null) {
        return;
      }
      paramFloat1 = Math.max(0.0F, paramFloat1);
      float f1 = Math.max(0.0F, paramFloat2);
      float f2 = Math.max(0.0F, paramFloat3);
      float f3 = Math.max(0.0F, paramFloat4);
      paramFloat5 = Math.max(0.0F, paramFloat5);
      paramFloat4 = paramFloat1 / 2.0F;
      if (f1 > 0.0F) {
        paramFloat2 = f1 + paramFloat4;
      } else {
        paramFloat2 = 0.0F;
      }
      if (paramFloat5 > 0.0F) {
        paramFloat3 = paramInt2 - paramFloat5 - paramFloat4;
      } else {
        paramFloat3 = paramInt2;
      }
      paramCanvas.drawLine(paramFloat4, Math.max(0.0F, paramFloat2), paramFloat4, Math.max(0.0F, paramFloat3), paramPaint);
      if (f1 > 0.0F) {
        paramFloat2 = f1 + paramFloat4;
      } else {
        paramFloat2 = paramFloat1;
      }
      if (f2 > 0.0F) {
        paramFloat3 = paramInt1 - f2 - paramFloat4;
      } else {
        paramFloat3 = paramInt1 - paramFloat1;
      }
      paramCanvas.drawLine(Math.max(0.0F, paramFloat2), paramFloat4, Math.max(0.0F, paramFloat3), paramFloat4, paramPaint);
      if (f2 > 0.0F) {
        paramFloat2 = f2 + paramFloat4;
      } else {
        paramFloat2 = 0.0F;
      }
      if (f3 > 0.0F) {
        paramFloat3 = paramInt2 - f3 - paramFloat4;
      } else {
        paramFloat3 = paramInt2;
      }
      float f4 = paramInt1;
      float f5 = f4 - paramFloat4;
      paramCanvas.drawLine(f5, Math.max(0.0F, paramFloat2), f5, Math.max(0.0F, paramFloat3), paramPaint);
      if (paramFloat5 > 0.0F) {
        paramFloat2 = paramFloat5 + paramFloat4;
      } else {
        paramFloat2 = paramFloat1;
      }
      if (f3 > 0.0F) {
        paramFloat1 = f4 - f3 - paramFloat4;
      } else {
        paramFloat1 = f4 - paramFloat1;
      }
      paramFloat3 = Math.max(0.0F, paramFloat2);
      paramFloat2 = paramInt2;
      f5 = paramFloat2 - paramFloat4;
      paramCanvas.drawLine(paramFloat3, f5, Math.max(0.0F, paramFloat1), f5, paramPaint);
      RectF localRectF;
      if (f1 > 0.0F)
      {
        localRectF = oval;
        paramFloat1 = f1 * 2.0F;
        localRectF.set(0.0F, 0.0F, paramFloat1, paramFloat1);
        oval.offset(paramFloat4, paramFloat4);
        paramCanvas.drawArc(oval, 180.0F, 90.0F, false, paramPaint);
      }
      if (f2 > 0.0F)
      {
        localRectF = oval;
        paramFloat1 = f2 * 2.0F;
        localRectF.set(f4 - paramFloat1, 0.0F, f4, paramFloat1);
        oval.offset(-paramFloat4, paramFloat4);
        paramCanvas.drawArc(oval, 270.0F, 90.0F, false, paramPaint);
      }
      if (f3 > 0.0F)
      {
        localRectF = oval;
        paramFloat1 = f3 * 2.0F;
        localRectF.set(f4 - paramFloat1, paramFloat2 - paramFloat1, f4, paramFloat2);
        localRectF = oval;
        paramFloat1 = -paramFloat4;
        localRectF.offset(paramFloat1, paramFloat1);
        paramCanvas.drawArc(oval, 0.0F, 90.0F, false, paramPaint);
      }
      if (paramFloat5 > 0.0F)
      {
        localRectF = oval;
        paramFloat1 = paramFloat5 * 2.0F;
        localRectF.set(0.0F, paramFloat2 - paramFloat1, paramFloat1, paramFloat2);
        oval.offset(paramFloat4, -paramFloat4);
        paramCanvas.drawArc(oval, 90.0F, 90.0F, false, paramPaint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSViewDecorationUtil
 * JD-Core Version:    0.7.0.1
 */