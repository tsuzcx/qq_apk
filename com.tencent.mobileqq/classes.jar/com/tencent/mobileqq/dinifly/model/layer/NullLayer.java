package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class NullLayer
  extends BaseLayer
{
  NullLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    super(paramLottieDrawable, paramLayer);
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {}
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.NullLayer
 * JD-Core Version:    0.7.0.1
 */