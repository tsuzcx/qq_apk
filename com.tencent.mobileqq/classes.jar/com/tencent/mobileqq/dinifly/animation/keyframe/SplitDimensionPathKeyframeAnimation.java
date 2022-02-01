package com.tencent.mobileqq.dinifly.animation.keyframe;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.Collections;
import java.util.List;

public class SplitDimensionPathKeyframeAnimation
  extends BaseKeyframeAnimation<PointF, PointF>
{
  private final PointF point = new PointF();
  private final PointF pointWithCallbackValues = new PointF();
  private final BaseKeyframeAnimation<Float, Float> xAnimation;
  @Nullable
  protected LottieValueCallback<Float> xValueCallback;
  private final BaseKeyframeAnimation<Float, Float> yAnimation;
  @Nullable
  protected LottieValueCallback<Float> yValueCallback;
  
  public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> paramBaseKeyframeAnimation1, BaseKeyframeAnimation<Float, Float> paramBaseKeyframeAnimation2)
  {
    super(Collections.emptyList());
    this.xAnimation = paramBaseKeyframeAnimation1;
    this.yAnimation = paramBaseKeyframeAnimation2;
    setProgress(getProgress());
  }
  
  public PointF getValue()
  {
    return getValue(null, 0.0F);
  }
  
  PointF getValue(Keyframe<PointF> paramKeyframe, float paramFloat)
  {
    paramKeyframe = this.xValueCallback;
    LottieValueCallback localLottieValueCallback = null;
    float f2;
    Object localObject2;
    float f3;
    float f1;
    if (paramKeyframe != null)
    {
      paramKeyframe = this.xAnimation.getCurrentKeyframe();
      if (paramKeyframe != null)
      {
        f2 = this.xAnimation.getInterpolatedCurrentKeyframeProgress();
        localObject1 = paramKeyframe.endFrame;
        localObject2 = this.xValueCallback;
        f3 = paramKeyframe.startFrame;
        if (localObject1 == null) {
          f1 = paramKeyframe.startFrame;
        } else {
          f1 = ((Float)localObject1).floatValue();
        }
        paramKeyframe = (Float)((LottieValueCallback)localObject2).getValueInternal(f3, f1, paramKeyframe.startValue, paramKeyframe.endValue, paramFloat, paramFloat, f2);
        break label99;
      }
    }
    paramKeyframe = null;
    label99:
    Object localObject1 = localLottieValueCallback;
    if (this.yValueCallback != null)
    {
      localObject2 = this.yAnimation.getCurrentKeyframe();
      localObject1 = localLottieValueCallback;
      if (localObject2 != null)
      {
        f2 = this.yAnimation.getInterpolatedCurrentKeyframeProgress();
        localObject1 = ((Keyframe)localObject2).endFrame;
        localLottieValueCallback = this.yValueCallback;
        f3 = ((Keyframe)localObject2).startFrame;
        if (localObject1 == null) {
          f1 = ((Keyframe)localObject2).startFrame;
        } else {
          f1 = ((Float)localObject1).floatValue();
        }
        localObject1 = (Float)localLottieValueCallback.getValueInternal(f3, f1, ((Keyframe)localObject2).startValue, ((Keyframe)localObject2).endValue, paramFloat, paramFloat, f2);
      }
    }
    if (paramKeyframe == null) {
      this.pointWithCallbackValues.set(this.point.x, 0.0F);
    } else {
      this.pointWithCallbackValues.set(paramKeyframe.floatValue(), 0.0F);
    }
    if (localObject1 == null)
    {
      paramKeyframe = this.pointWithCallbackValues;
      paramKeyframe.set(paramKeyframe.x, this.point.y);
    }
    else
    {
      paramKeyframe = this.pointWithCallbackValues;
      paramKeyframe.set(paramKeyframe.x, ((Float)localObject1).floatValue());
    }
    return this.pointWithCallbackValues;
  }
  
  public void setProgress(float paramFloat)
  {
    this.xAnimation.setProgress(paramFloat);
    this.yAnimation.setProgress(paramFloat);
    this.point.set(((Float)this.xAnimation.getValue()).floatValue(), ((Float)this.yAnimation.getValue()).floatValue());
    int i = 0;
    while (i < this.listeners.size())
    {
      ((BaseKeyframeAnimation.AnimationListener)this.listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
  
  public void setXValueCallback(@Nullable LottieValueCallback<Float> paramLottieValueCallback)
  {
    LottieValueCallback localLottieValueCallback = this.xValueCallback;
    if (localLottieValueCallback != null) {
      localLottieValueCallback.setAnimation(null);
    }
    this.xValueCallback = paramLottieValueCallback;
    if (paramLottieValueCallback != null) {
      paramLottieValueCallback.setAnimation(this);
    }
  }
  
  public void setYValueCallback(@Nullable LottieValueCallback<Float> paramLottieValueCallback)
  {
    LottieValueCallback localLottieValueCallback = this.yValueCallback;
    if (localLottieValueCallback != null) {
      localLottieValueCallback.setAnimation(null);
    }
    this.yValueCallback = paramLottieValueCallback;
    if (paramLottieValueCallback != null) {
      paramLottieValueCallback.setAnimation(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.SplitDimensionPathKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */