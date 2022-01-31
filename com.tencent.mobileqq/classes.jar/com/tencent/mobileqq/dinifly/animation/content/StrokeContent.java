package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ColorKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;

public class StrokeContent
  extends BaseStrokeContent
{
  private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  @Nullable
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
  private final boolean hidden;
  private final BaseLayer layer;
  private final String name;
  
  public StrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeStroke paramShapeStroke)
  {
    super(paramLottieDrawable, paramBaseLayer, paramShapeStroke.getCapType().toPaintCap(), paramShapeStroke.getJoinType().toPaintJoin(), paramShapeStroke.getMiterLimit(), paramShapeStroke.getOpacity(), paramShapeStroke.getWidth(), paramShapeStroke.getLineDashPattern(), paramShapeStroke.getDashOffset());
    this.layer = paramBaseLayer;
    this.name = paramShapeStroke.getName();
    this.hidden = paramShapeStroke.isHidden();
    this.colorAnimation = paramShapeStroke.getColor().createAnimation();
    this.colorAnimation.addUpdateListener(this);
    paramBaseLayer.addAnimation(this.colorAnimation);
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    super.addValueCallback(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.STROKE_COLOR) {
      this.colorAnimation.setValueCallback(paramLottieValueCallback);
    }
    while (paramT != LottieProperty.COLOR_FILTER) {
      return;
    }
    if (paramLottieValueCallback == null)
    {
      this.colorFilterAnimation = null;
      return;
    }
    this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
    this.colorFilterAnimation.addUpdateListener(this);
    this.layer.addAnimation(this.colorAnimation);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (this.hidden) {
      return;
    }
    this.paint.setColor(((ColorKeyframeAnimation)this.colorAnimation).getIntValue());
    if (this.colorFilterAnimation != null) {
      this.paint.setColorFilter((ColorFilter)this.colorFilterAnimation.getValue());
    }
    super.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.StrokeContent
 * JD-Core Version:    0.7.0.1
 */