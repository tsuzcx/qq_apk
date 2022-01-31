package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import java.util.List;

public abstract class KeyframeAnimation<T>
  extends BaseKeyframeAnimation<T, T>
{
  KeyframeAnimation(List<? extends Keyframe<T>> paramList)
  {
    super(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.KeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */