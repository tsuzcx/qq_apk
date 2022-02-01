package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePathValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableScaleValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableValue;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import com.tencent.mobileqq.dinifly.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation
{
  @NonNull
  private BaseKeyframeAnimation<PointF, PointF> anchorPoint;
  @Nullable
  private BaseKeyframeAnimation<?, Float> endOpacity;
  private final Matrix matrix = new Matrix();
  @NonNull
  private BaseKeyframeAnimation<Integer, Integer> opacity;
  @NonNull
  private BaseKeyframeAnimation<?, PointF> position;
  @NonNull
  private BaseKeyframeAnimation<Float, Float> rotation;
  @NonNull
  private BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
  @Nullable
  private FloatKeyframeAnimation skew;
  @Nullable
  private FloatKeyframeAnimation skewAngle;
  private final Matrix skewMatrix1;
  private final Matrix skewMatrix2;
  private final Matrix skewMatrix3;
  private final float[] skewValues;
  @Nullable
  private BaseKeyframeAnimation<?, Float> startOpacity;
  
  public TransformKeyframeAnimation(AnimatableTransform paramAnimatableTransform)
  {
    Object localObject;
    if (paramAnimatableTransform.getAnchorPoint() == null) {
      localObject = null;
    } else {
      localObject = paramAnimatableTransform.getAnchorPoint().createAnimation();
    }
    this.anchorPoint = ((BaseKeyframeAnimation)localObject);
    if (paramAnimatableTransform.getPosition() == null) {
      localObject = null;
    } else {
      localObject = paramAnimatableTransform.getPosition().createAnimation();
    }
    this.position = ((BaseKeyframeAnimation)localObject);
    if (paramAnimatableTransform.getScale() == null) {
      localObject = null;
    } else {
      localObject = paramAnimatableTransform.getScale().createAnimation();
    }
    this.scale = ((BaseKeyframeAnimation)localObject);
    if (paramAnimatableTransform.getRotation() == null) {
      localObject = null;
    } else {
      localObject = paramAnimatableTransform.getRotation().createAnimation();
    }
    this.rotation = ((BaseKeyframeAnimation)localObject);
    if (paramAnimatableTransform.getSkew() == null) {
      localObject = null;
    } else {
      localObject = (FloatKeyframeAnimation)paramAnimatableTransform.getSkew().createAnimation();
    }
    this.skew = ((FloatKeyframeAnimation)localObject);
    if (this.skew != null)
    {
      this.skewMatrix1 = new Matrix();
      this.skewMatrix2 = new Matrix();
      this.skewMatrix3 = new Matrix();
      this.skewValues = new float[9];
    }
    else
    {
      this.skewMatrix1 = null;
      this.skewMatrix2 = null;
      this.skewMatrix3 = null;
      this.skewValues = null;
    }
    if (paramAnimatableTransform.getSkewAngle() == null) {
      localObject = null;
    } else {
      localObject = (FloatKeyframeAnimation)paramAnimatableTransform.getSkewAngle().createAnimation();
    }
    this.skewAngle = ((FloatKeyframeAnimation)localObject);
    if (paramAnimatableTransform.getOpacity() != null) {
      this.opacity = paramAnimatableTransform.getOpacity().createAnimation();
    }
    if (paramAnimatableTransform.getStartOpacity() != null) {
      this.startOpacity = paramAnimatableTransform.getStartOpacity().createAnimation();
    } else {
      this.startOpacity = null;
    }
    if (paramAnimatableTransform.getEndOpacity() != null)
    {
      this.endOpacity = paramAnimatableTransform.getEndOpacity().createAnimation();
      return;
    }
    this.endOpacity = null;
  }
  
  private void clearSkewValues()
  {
    int i = 0;
    while (i < 9)
    {
      this.skewValues[i] = 0.0F;
      i += 1;
    }
  }
  
  public void addAnimationsToLayer(BaseLayer paramBaseLayer)
  {
    paramBaseLayer.addAnimation(this.opacity);
    paramBaseLayer.addAnimation(this.startOpacity);
    paramBaseLayer.addAnimation(this.endOpacity);
    paramBaseLayer.addAnimation(this.anchorPoint);
    paramBaseLayer.addAnimation(this.position);
    paramBaseLayer.addAnimation(this.scale);
    paramBaseLayer.addAnimation(this.rotation);
    paramBaseLayer.addAnimation(this.skew);
    paramBaseLayer.addAnimation(this.skewAngle);
  }
  
  public void addListener(BaseKeyframeAnimation.AnimationListener paramAnimationListener)
  {
    Object localObject = this.opacity;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.startOpacity;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.endOpacity;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.anchorPoint;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.position;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.scale;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.rotation;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.skew;
    if (localObject != null) {
      ((FloatKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
    localObject = this.skewAngle;
    if (localObject != null) {
      ((FloatKeyframeAnimation)localObject).addUpdateListener(paramAnimationListener);
    }
  }
  
  public <T> boolean applyValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.TRANSFORM_ANCHOR_POINT)
    {
      paramT = this.anchorPoint;
      if (paramT == null) {
        this.anchorPoint = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, new PointF());
      } else {
        paramT.setValueCallback(paramLottieValueCallback);
      }
    }
    else if (paramT == LottieProperty.TRANSFORM_POSITION)
    {
      paramT = this.position;
      if (paramT == null) {
        this.position = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, new PointF());
      } else {
        paramT.setValueCallback(paramLottieValueCallback);
      }
    }
    else if (paramT == LottieProperty.TRANSFORM_SCALE)
    {
      paramT = this.scale;
      if (paramT == null) {
        this.scale = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, new ScaleXY());
      } else {
        paramT.setValueCallback(paramLottieValueCallback);
      }
    }
    else if (paramT == LottieProperty.TRANSFORM_ROTATION)
    {
      paramT = this.rotation;
      if (paramT == null) {
        this.rotation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Float.valueOf(0.0F));
      } else {
        paramT.setValueCallback(paramLottieValueCallback);
      }
    }
    else if (paramT == LottieProperty.TRANSFORM_OPACITY)
    {
      paramT = this.opacity;
      if (paramT == null) {
        this.opacity = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Integer.valueOf(100));
      } else {
        paramT.setValueCallback(paramLottieValueCallback);
      }
    }
    else
    {
      Object localObject;
      if (paramT == LottieProperty.TRANSFORM_START_OPACITY)
      {
        localObject = this.startOpacity;
        if (localObject != null)
        {
          if (localObject == null)
          {
            this.startOpacity = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Integer.valueOf(100));
            break label430;
          }
          ((BaseKeyframeAnimation)localObject).setValueCallback(paramLottieValueCallback);
          break label430;
        }
      }
      if (paramT == LottieProperty.TRANSFORM_END_OPACITY)
      {
        localObject = this.endOpacity;
        if (localObject != null)
        {
          if (localObject == null)
          {
            this.endOpacity = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Integer.valueOf(100));
            break label430;
          }
          ((BaseKeyframeAnimation)localObject).setValueCallback(paramLottieValueCallback);
          break label430;
        }
      }
      if (paramT == LottieProperty.TRANSFORM_SKEW)
      {
        localObject = this.skew;
        if (localObject != null)
        {
          if (localObject == null) {
            this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0F))));
          }
          this.skew.setValueCallback(paramLottieValueCallback);
          break label430;
        }
      }
      if (paramT != LottieProperty.TRANSFORM_SKEW_ANGLE) {
        break label432;
      }
      paramT = this.skewAngle;
      if (paramT == null) {
        break label432;
      }
      if (paramT == null) {
        this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0F))));
      }
      this.skewAngle.setValueCallback(paramLottieValueCallback);
    }
    label430:
    return true;
    label432:
    return false;
  }
  
  @Nullable
  public BaseKeyframeAnimation<?, Float> getEndOpacity()
  {
    return this.endOpacity;
  }
  
  public Matrix getMatrix()
  {
    this.matrix.reset();
    Object localObject = this.position;
    if (localObject != null)
    {
      localObject = (PointF)((BaseKeyframeAnimation)localObject).getValue();
      if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
        this.matrix.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
      }
    }
    localObject = this.rotation;
    float f1;
    if (localObject != null)
    {
      if ((localObject instanceof ValueCallbackKeyframeAnimation)) {
        f1 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();
      } else {
        f1 = ((FloatKeyframeAnimation)localObject).getFloatValue();
      }
      if (f1 != 0.0F) {
        this.matrix.preRotate(f1);
      }
    }
    if (this.skew != null)
    {
      localObject = this.skewAngle;
      if (localObject == null) {
        f1 = 0.0F;
      } else {
        f1 = (float)Math.cos(Math.toRadians(-((FloatKeyframeAnimation)localObject).getFloatValue() + 90.0F));
      }
      localObject = this.skewAngle;
      float f2;
      if (localObject == null) {
        f2 = 1.0F;
      } else {
        f2 = (float)Math.sin(Math.toRadians(-((FloatKeyframeAnimation)localObject).getFloatValue() + 90.0F));
      }
      float f3 = (float)Math.tan(Math.toRadians(this.skew.getFloatValue()));
      clearSkewValues();
      localObject = this.skewValues;
      localObject[0] = f1;
      localObject[1] = f2;
      float f4 = -f2;
      localObject[3] = f4;
      localObject[4] = f1;
      localObject[8] = 1.0F;
      this.skewMatrix1.setValues((float[])localObject);
      clearSkewValues();
      localObject = this.skewValues;
      localObject[0] = 1.0F;
      localObject[3] = f3;
      localObject[4] = 1.0F;
      localObject[8] = 1.0F;
      this.skewMatrix2.setValues((float[])localObject);
      clearSkewValues();
      localObject = this.skewValues;
      localObject[0] = f1;
      localObject[1] = f4;
      localObject[3] = f2;
      localObject[4] = f1;
      localObject[8] = 1.0F;
      this.skewMatrix3.setValues((float[])localObject);
      this.skewMatrix2.preConcat(this.skewMatrix1);
      this.skewMatrix3.preConcat(this.skewMatrix2);
      this.matrix.preConcat(this.skewMatrix3);
    }
    localObject = this.scale;
    if (localObject != null)
    {
      localObject = (ScaleXY)((BaseKeyframeAnimation)localObject).getValue();
      if ((((ScaleXY)localObject).getScaleX() != 1.0F) || (((ScaleXY)localObject).getScaleY() != 1.0F)) {
        this.matrix.preScale(((ScaleXY)localObject).getScaleX(), ((ScaleXY)localObject).getScaleY());
      }
    }
    localObject = this.anchorPoint;
    if (localObject != null)
    {
      localObject = (PointF)((BaseKeyframeAnimation)localObject).getValue();
      if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
        this.matrix.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
      }
    }
    return this.matrix;
  }
  
  public Matrix getMatrixForRepeater(float paramFloat)
  {
    Object localObject1 = this.position;
    Object localObject3 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (PointF)((BaseKeyframeAnimation)localObject1).getValue();
    }
    Object localObject2 = this.scale;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = (ScaleXY)((BaseKeyframeAnimation)localObject2).getValue();
    }
    this.matrix.reset();
    if (localObject1 != null) {
      this.matrix.preTranslate(((PointF)localObject1).x * paramFloat, ((PointF)localObject1).y * paramFloat);
    }
    if (localObject2 != null)
    {
      localObject1 = this.matrix;
      double d1 = ((ScaleXY)localObject2).getScaleX();
      double d2 = paramFloat;
      ((Matrix)localObject1).preScale((float)Math.pow(d1, d2), (float)Math.pow(((ScaleXY)localObject2).getScaleY(), d2));
    }
    localObject1 = this.rotation;
    if (localObject1 != null)
    {
      float f3 = ((Float)((BaseKeyframeAnimation)localObject1).getValue()).floatValue();
      localObject1 = this.anchorPoint;
      if (localObject1 == null) {
        localObject1 = localObject3;
      } else {
        localObject1 = (PointF)((BaseKeyframeAnimation)localObject1).getValue();
      }
      localObject2 = this.matrix;
      float f2 = 0.0F;
      float f1;
      if (localObject1 == null) {
        f1 = 0.0F;
      } else {
        f1 = ((PointF)localObject1).x;
      }
      if (localObject1 != null) {
        f2 = ((PointF)localObject1).y;
      }
      ((Matrix)localObject2).preRotate(f3 * paramFloat, f1, f2);
    }
    return this.matrix;
  }
  
  @Nullable
  public BaseKeyframeAnimation<?, Integer> getOpacity()
  {
    return this.opacity;
  }
  
  @Nullable
  public BaseKeyframeAnimation<?, Float> getStartOpacity()
  {
    return this.startOpacity;
  }
  
  public void setProgress(float paramFloat)
  {
    Object localObject = this.opacity;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.startOpacity;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.endOpacity;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.anchorPoint;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.position;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.scale;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.rotation;
    if (localObject != null) {
      ((BaseKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.skew;
    if (localObject != null) {
      ((FloatKeyframeAnimation)localObject).setProgress(paramFloat);
    }
    localObject = this.skewAngle;
    if (localObject != null) {
      ((FloatKeyframeAnimation)localObject).setProgress(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */