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
    if (paramAnimatableTransform.getAnchorPoint() == null)
    {
      localObject = null;
      this.anchorPoint = ((BaseKeyframeAnimation)localObject);
      if (paramAnimatableTransform.getPosition() != null) {
        break label213;
      }
      localObject = null;
      label38:
      this.position = ((BaseKeyframeAnimation)localObject);
      if (paramAnimatableTransform.getScale() != null) {
        break label226;
      }
      localObject = null;
      label52:
      this.scale = ((BaseKeyframeAnimation)localObject);
      if (paramAnimatableTransform.getRotation() != null) {
        break label237;
      }
      localObject = null;
      label66:
      this.rotation = ((BaseKeyframeAnimation)localObject);
      if (paramAnimatableTransform.getSkew() != null) {
        break label248;
      }
      localObject = null;
      label80:
      this.skew = ((FloatKeyframeAnimation)localObject);
      if (this.skew == null) {
        break label262;
      }
      this.skewMatrix1 = new Matrix();
      this.skewMatrix2 = new Matrix();
      this.skewMatrix3 = new Matrix();
      this.skewValues = new float[9];
      label133:
      if (paramAnimatableTransform.getSkewAngle() != null) {
        break label285;
      }
      localObject = null;
      label142:
      this.skewAngle = ((FloatKeyframeAnimation)localObject);
      if (paramAnimatableTransform.getOpacity() != null) {
        this.opacity = paramAnimatableTransform.getOpacity().createAnimation();
      }
      if (paramAnimatableTransform.getStartOpacity() == null) {
        break label299;
      }
    }
    label262:
    label285:
    label299:
    for (this.startOpacity = paramAnimatableTransform.getStartOpacity().createAnimation();; this.startOpacity = null)
    {
      if (paramAnimatableTransform.getEndOpacity() == null) {
        break label307;
      }
      this.endOpacity = paramAnimatableTransform.getEndOpacity().createAnimation();
      return;
      localObject = paramAnimatableTransform.getAnchorPoint().createAnimation();
      break;
      label213:
      localObject = paramAnimatableTransform.getPosition().createAnimation();
      break label38;
      label226:
      localObject = paramAnimatableTransform.getScale().createAnimation();
      break label52;
      label237:
      localObject = paramAnimatableTransform.getRotation().createAnimation();
      break label66;
      label248:
      localObject = (FloatKeyframeAnimation)paramAnimatableTransform.getSkew().createAnimation();
      break label80;
      this.skewMatrix1 = null;
      this.skewMatrix2 = null;
      this.skewMatrix3 = null;
      this.skewValues = null;
      break label133;
      localObject = (FloatKeyframeAnimation)paramAnimatableTransform.getSkewAngle().createAnimation();
      break label142;
    }
    label307:
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
    if (this.opacity != null) {
      this.opacity.addUpdateListener(paramAnimationListener);
    }
    if (this.startOpacity != null) {
      this.startOpacity.addUpdateListener(paramAnimationListener);
    }
    if (this.endOpacity != null) {
      this.endOpacity.addUpdateListener(paramAnimationListener);
    }
    if (this.anchorPoint != null) {
      this.anchorPoint.addUpdateListener(paramAnimationListener);
    }
    if (this.position != null) {
      this.position.addUpdateListener(paramAnimationListener);
    }
    if (this.scale != null) {
      this.scale.addUpdateListener(paramAnimationListener);
    }
    if (this.rotation != null) {
      this.rotation.addUpdateListener(paramAnimationListener);
    }
    if (this.skew != null) {
      this.skew.addUpdateListener(paramAnimationListener);
    }
    if (this.skewAngle != null) {
      this.skewAngle.addUpdateListener(paramAnimationListener);
    }
  }
  
  public <T> boolean applyValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    if (paramT == LottieProperty.TRANSFORM_ANCHOR_POINT) {
      if (this.anchorPoint == null) {
        this.anchorPoint = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, new PointF());
      }
    }
    for (;;)
    {
      return true;
      this.anchorPoint.setValueCallback(paramLottieValueCallback);
      continue;
      if (paramT == LottieProperty.TRANSFORM_POSITION)
      {
        if (this.position == null) {
          this.position = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, new PointF());
        } else {
          this.position.setValueCallback(paramLottieValueCallback);
        }
      }
      else if (paramT == LottieProperty.TRANSFORM_SCALE)
      {
        if (this.scale == null) {
          this.scale = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, new ScaleXY());
        } else {
          this.scale.setValueCallback(paramLottieValueCallback);
        }
      }
      else if (paramT == LottieProperty.TRANSFORM_ROTATION)
      {
        if (this.rotation == null) {
          this.rotation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Float.valueOf(0.0F));
        } else {
          this.rotation.setValueCallback(paramLottieValueCallback);
        }
      }
      else if (paramT == LottieProperty.TRANSFORM_OPACITY)
      {
        if (this.opacity == null) {
          this.opacity = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Integer.valueOf(100));
        } else {
          this.opacity.setValueCallback(paramLottieValueCallback);
        }
      }
      else if ((paramT == LottieProperty.TRANSFORM_START_OPACITY) && (this.startOpacity != null))
      {
        if (this.startOpacity == null) {
          this.startOpacity = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Integer.valueOf(100));
        } else {
          this.startOpacity.setValueCallback(paramLottieValueCallback);
        }
      }
      else if ((paramT == LottieProperty.TRANSFORM_END_OPACITY) && (this.endOpacity != null))
      {
        if (this.endOpacity == null) {
          this.endOpacity = new ValueCallbackKeyframeAnimation(paramLottieValueCallback, Integer.valueOf(100));
        } else {
          this.endOpacity.setValueCallback(paramLottieValueCallback);
        }
      }
      else if ((paramT == LottieProperty.TRANSFORM_SKEW) && (this.skew != null))
      {
        if (this.skew == null) {
          this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0F))));
        }
        this.skew.setValueCallback(paramLottieValueCallback);
      }
      else
      {
        if ((paramT != LottieProperty.TRANSFORM_SKEW_ANGLE) || (this.skewAngle == null)) {
          break;
        }
        if (this.skewAngle == null) {
          this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0F))));
        }
        this.skewAngle.setValueCallback(paramLottieValueCallback);
      }
    }
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
    Object localObject;
    if (this.position != null)
    {
      localObject = (PointF)this.position.getValue();
      if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
        this.matrix.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
      }
    }
    float f1;
    if (this.rotation != null)
    {
      if (!(this.rotation instanceof ValueCallbackKeyframeAnimation)) {
        break label456;
      }
      f1 = ((Float)this.rotation.getValue()).floatValue();
      if (f1 != 0.0F) {
        this.matrix.preRotate(f1);
      }
    }
    if (this.skew != null)
    {
      if (this.skewAngle != null) {
        break label470;
      }
      f1 = 0.0F;
      label126:
      if (this.skewAngle != null) {
        break label494;
      }
    }
    label456:
    label470:
    label494:
    for (float f2 = 1.0F;; f2 = (float)Math.sin(Math.toRadians(-this.skewAngle.getFloatValue() + 90.0F)))
    {
      float f3 = (float)Math.tan(Math.toRadians(this.skew.getFloatValue()));
      clearSkewValues();
      this.skewValues[0] = f1;
      this.skewValues[1] = f2;
      this.skewValues[3] = (-f2);
      this.skewValues[4] = f1;
      this.skewValues[8] = 1.0F;
      this.skewMatrix1.setValues(this.skewValues);
      clearSkewValues();
      this.skewValues[0] = 1.0F;
      this.skewValues[3] = f3;
      this.skewValues[4] = 1.0F;
      this.skewValues[8] = 1.0F;
      this.skewMatrix2.setValues(this.skewValues);
      clearSkewValues();
      this.skewValues[0] = f1;
      this.skewValues[1] = (-f2);
      this.skewValues[3] = f2;
      this.skewValues[4] = f1;
      this.skewValues[8] = 1.0F;
      this.skewMatrix3.setValues(this.skewValues);
      this.skewMatrix2.preConcat(this.skewMatrix1);
      this.skewMatrix3.preConcat(this.skewMatrix2);
      this.matrix.preConcat(this.skewMatrix3);
      if (this.scale != null)
      {
        localObject = (ScaleXY)this.scale.getValue();
        if ((((ScaleXY)localObject).getScaleX() != 1.0F) || (((ScaleXY)localObject).getScaleY() != 1.0F)) {
          this.matrix.preScale(((ScaleXY)localObject).getScaleX(), ((ScaleXY)localObject).getScaleY());
        }
      }
      if (this.anchorPoint != null)
      {
        localObject = (PointF)this.anchorPoint.getValue();
        if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
          this.matrix.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
        }
      }
      return this.matrix;
      f1 = ((FloatKeyframeAnimation)this.rotation).getFloatValue();
      break;
      f1 = (float)Math.cos(Math.toRadians(-this.skewAngle.getFloatValue() + 90.0F));
      break label126;
    }
  }
  
  public Matrix getMatrixForRepeater(float paramFloat)
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    label23:
    float f3;
    label127:
    float f1;
    if (this.position == null)
    {
      localObject1 = null;
      if (this.scale != null) {
        break label179;
      }
      localObject2 = null;
      this.matrix.reset();
      if (localObject1 != null) {
        this.matrix.preTranslate(((PointF)localObject1).x * paramFloat, ((PointF)localObject1).y * paramFloat);
      }
      if (localObject2 != null) {
        this.matrix.preScale((float)Math.pow(((ScaleXY)localObject2).getScaleX(), paramFloat), (float)Math.pow(((ScaleXY)localObject2).getScaleY(), paramFloat));
      }
      if (this.rotation != null)
      {
        f3 = ((Float)this.rotation.getValue()).floatValue();
        if (this.anchorPoint != null) {
          break label194;
        }
        localObject1 = localObject3;
        localObject2 = this.matrix;
        if (localObject1 != null) {
          break label209;
        }
        f1 = 0.0F;
        label140:
        if (localObject1 != null) {
          break label218;
        }
      }
    }
    label179:
    label194:
    label209:
    label218:
    for (float f2 = 0.0F;; f2 = ((PointF)localObject1).y)
    {
      ((Matrix)localObject2).preRotate(f3 * paramFloat, f1, f2);
      return this.matrix;
      localObject1 = (PointF)this.position.getValue();
      break;
      localObject2 = (ScaleXY)this.scale.getValue();
      break label23;
      localObject1 = (PointF)this.anchorPoint.getValue();
      break label127;
      f1 = ((PointF)localObject1).x;
      break label140;
    }
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
    if (this.opacity != null) {
      this.opacity.setProgress(paramFloat);
    }
    if (this.startOpacity != null) {
      this.startOpacity.setProgress(paramFloat);
    }
    if (this.endOpacity != null) {
      this.endOpacity.setProgress(paramFloat);
    }
    if (this.anchorPoint != null) {
      this.anchorPoint.setProgress(paramFloat);
    }
    if (this.position != null) {
      this.position.setProgress(paramFloat);
    }
    if (this.scale != null) {
      this.scale.setProgress(paramFloat);
    }
    if (this.rotation != null) {
      this.rotation.setProgress(paramFloat);
    }
    if (this.skew != null) {
      this.skew.setProgress(paramFloat);
    }
    if (this.skewAngle != null) {
      this.skewAngle.setProgress(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */