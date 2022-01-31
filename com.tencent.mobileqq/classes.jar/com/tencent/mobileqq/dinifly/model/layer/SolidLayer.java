package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;

public class SolidLayer
  extends BaseLayer
{
  private final Layer layerModel;
  private final Paint paint = new Paint();
  private final RectF rect = new RectF();
  
  SolidLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    super(paramLottieDrawable, paramLayer);
    this.layerModel = paramLayer;
    this.paint.setAlpha(0);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setColor(paramLayer.getSolidColor());
  }
  
  private void updateRect(Matrix paramMatrix)
  {
    this.rect.set(0.0F, 0.0F, this.layerModel.getSolidWidth(), this.layerModel.getSolidHeight());
    paramMatrix.mapRect(this.rect);
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int i = Color.alpha(this.layerModel.getSolidColor());
    if (i == 0) {}
    do
    {
      return;
      float f1 = paramInt / 255.0F;
      float f2 = i / 255.0F;
      paramInt = (int)(((Integer)this.transform.getOpacity().getValue()).intValue() * f2 / 100.0F * f1 * 255.0F);
      this.paint.setAlpha(paramInt);
    } while (paramInt <= 0);
    updateRect(paramMatrix);
    paramCanvas.drawRect(this.rect, this.paint);
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    super.getBounds(paramRectF, paramMatrix);
    updateRect(this.boundsMatrix);
    paramRectF.set(this.rect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.SolidLayer
 * JD-Core Version:    0.7.0.1
 */