package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;

public class SolidLayer
  extends BaseLayer
{
  @Nullable
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
  private final Layer layerModel;
  private final Paint paint = new LPaint();
  private final Path path = new Path();
  private final float[] points = new float[8];
  private final RectF rect = new RectF();
  
  SolidLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    super(paramLottieDrawable, paramLayer);
    this.layerModel = paramLayer;
    this.paint.setAlpha(0);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setColor(paramLayer.getSolidColor());
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    super.addValueCallback(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.COLOR_FILTER)
    {
      if (paramLottieValueCallback == null)
      {
        this.colorFilterAnimation = null;
        return;
      }
      this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
    }
  }
  
  public void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int j = Color.alpha(this.layerModel.getSolidColor());
    if (j == 0) {
      return;
    }
    int i;
    if (this.transform.getOpacity() == null) {
      i = 100;
    } else {
      i = ((Integer)this.transform.getOpacity().getValue()).intValue();
    }
    paramInt = (int)(paramInt / 255.0F * (j / 255.0F * i / 100.0F) * 255.0F);
    this.paint.setAlpha(paramInt);
    Object localObject = this.colorFilterAnimation;
    if (localObject != null) {
      this.paint.setColorFilter((ColorFilter)((BaseKeyframeAnimation)localObject).getValue());
    }
    if (paramInt > 0)
    {
      localObject = this.points;
      localObject[0] = 0.0F;
      localObject[1] = 0.0F;
      localObject[2] = this.layerModel.getSolidWidth();
      localObject = this.points;
      localObject[3] = 0.0F;
      localObject[4] = this.layerModel.getSolidWidth();
      this.points[5] = this.layerModel.getSolidHeight();
      localObject = this.points;
      localObject[6] = 0.0F;
      localObject[7] = this.layerModel.getSolidHeight();
      paramMatrix.mapPoints(this.points);
      this.path.reset();
      paramMatrix = this.path;
      localObject = this.points;
      paramMatrix.moveTo(localObject[0], localObject[1]);
      paramMatrix = this.path;
      localObject = this.points;
      paramMatrix.lineTo(localObject[2], localObject[3]);
      paramMatrix = this.path;
      localObject = this.points;
      paramMatrix.lineTo(localObject[4], localObject[5]);
      paramMatrix = this.path;
      localObject = this.points;
      paramMatrix.lineTo(localObject[6], localObject[7]);
      paramMatrix = this.path;
      localObject = this.points;
      paramMatrix.lineTo(localObject[0], localObject[1]);
      this.path.close();
      paramCanvas.drawPath(this.path, this.paint);
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    this.rect.set(0.0F, 0.0F, this.layerModel.getSolidWidth(), this.layerModel.getSolidHeight());
    this.boundsMatrix.mapRect(this.rect);
    paramRectF.set(this.rect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.SolidLayer
 * JD-Core Version:    0.7.0.1
 */