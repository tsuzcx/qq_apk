package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class StrokeContent
  extends BaseStrokeContent
{
  private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  private final String name;
  
  public StrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeStroke paramShapeStroke)
  {
    super(paramLottieDrawable, paramBaseLayer, paramShapeStroke.getCapType().toPaintCap(), paramShapeStroke.getJoinType().toPaintJoin(), paramShapeStroke.getOpacity(), paramShapeStroke.getWidth(), paramShapeStroke.getLineDashPattern(), paramShapeStroke.getDashOffset());
    this.name = paramShapeStroke.getName();
    this.colorAnimation = paramShapeStroke.getColor().createAnimation();
    this.colorAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.colorAnimation);
  }
  
  public void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.paint.setColor(((Integer)this.colorAnimation.getValue()).intValue());
    super.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.StrokeContent
 * JD-Core Version:    0.7.0.1
 */