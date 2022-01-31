package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.model.ScaleXY;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableScaleValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;

public class TransformKeyframeAnimation
{
  private final BaseKeyframeAnimation<PointF, PointF> anchorPoint;
  @Nullable
  private final BaseKeyframeAnimation<?, Float> endOpacity;
  private final Matrix matrix = new Matrix();
  private final BaseKeyframeAnimation<Integer, Integer> opacity;
  private final BaseKeyframeAnimation<?, PointF> position;
  private final BaseKeyframeAnimation<Float, Float> rotation;
  private final BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
  @Nullable
  private final BaseKeyframeAnimation<?, Float> startOpacity;
  
  public TransformKeyframeAnimation(AnimatableTransform paramAnimatableTransform)
  {
    this.anchorPoint = paramAnimatableTransform.getAnchorPoint().createAnimation();
    this.position = paramAnimatableTransform.getPosition().createAnimation();
    this.scale = paramAnimatableTransform.getScale().createAnimation();
    this.rotation = paramAnimatableTransform.getRotation().createAnimation();
    this.opacity = paramAnimatableTransform.getOpacity().createAnimation();
    if (paramAnimatableTransform.getStartOpacity() != null) {}
    for (this.startOpacity = paramAnimatableTransform.getStartOpacity().createAnimation(); paramAnimatableTransform.getEndOpacity() != null; this.startOpacity = null)
    {
      this.endOpacity = paramAnimatableTransform.getEndOpacity().createAnimation();
      return;
    }
    this.endOpacity = null;
  }
  
  public void addAnimationsToLayer(BaseLayer paramBaseLayer)
  {
    paramBaseLayer.addAnimation(this.anchorPoint);
    paramBaseLayer.addAnimation(this.position);
    paramBaseLayer.addAnimation(this.scale);
    paramBaseLayer.addAnimation(this.rotation);
    paramBaseLayer.addAnimation(this.opacity);
    if (this.startOpacity != null) {
      paramBaseLayer.addAnimation(this.startOpacity);
    }
    if (this.endOpacity != null) {
      paramBaseLayer.addAnimation(this.endOpacity);
    }
  }
  
  public void addListener(BaseKeyframeAnimation.AnimationListener paramAnimationListener)
  {
    this.anchorPoint.addUpdateListener(paramAnimationListener);
    this.position.addUpdateListener(paramAnimationListener);
    this.scale.addUpdateListener(paramAnimationListener);
    this.rotation.addUpdateListener(paramAnimationListener);
    this.opacity.addUpdateListener(paramAnimationListener);
    if (this.startOpacity != null) {
      this.startOpacity.addUpdateListener(paramAnimationListener);
    }
    if (this.endOpacity != null) {
      this.endOpacity.addUpdateListener(paramAnimationListener);
    }
  }
  
  @Nullable
  public BaseKeyframeAnimation<?, Float> getEndOpacity()
  {
    return this.endOpacity;
  }
  
  public Matrix getMatrix()
  {
    this.matrix.reset();
    Object localObject = (PointF)this.position.getValue();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.matrix.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    }
    float f = ((Float)this.rotation.getValue()).floatValue();
    if (f != 0.0F) {
      this.matrix.preRotate(f);
    }
    localObject = (ScaleXY)this.scale.getValue();
    if ((((ScaleXY)localObject).getScaleX() != 1.0F) || (((ScaleXY)localObject).getScaleY() != 1.0F)) {
      this.matrix.preScale(((ScaleXY)localObject).getScaleX(), ((ScaleXY)localObject).getScaleY());
    }
    localObject = (PointF)this.anchorPoint.getValue();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.matrix.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.matrix;
  }
  
  public Matrix getMatrixForRepeater(float paramFloat)
  {
    PointF localPointF1 = (PointF)this.position.getValue();
    PointF localPointF2 = (PointF)this.anchorPoint.getValue();
    ScaleXY localScaleXY = (ScaleXY)this.scale.getValue();
    float f = ((Float)this.rotation.getValue()).floatValue();
    this.matrix.reset();
    this.matrix.preTranslate(localPointF1.x * paramFloat, localPointF1.y * paramFloat);
    this.matrix.preScale((float)Math.pow(localScaleXY.getScaleX(), paramFloat), (float)Math.pow(localScaleXY.getScaleY(), paramFloat));
    this.matrix.preRotate(f * paramFloat, localPointF2.x, localPointF2.y);
    return this.matrix;
  }
  
  public BaseKeyframeAnimation<?, Integer> getOpacity()
  {
    return this.opacity;
  }
  
  @Nullable
  public BaseKeyframeAnimation<?, Float> getStartOpacity()
  {
    return this.startOpacity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */