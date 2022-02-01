package com.tencent.mobileqq.dinifly.model.layer;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;

class BaseLayer$1
  implements BaseKeyframeAnimation.AnimationListener
{
  BaseLayer$1(BaseLayer paramBaseLayer) {}
  
  public void onValueChanged()
  {
    BaseLayer localBaseLayer = this.this$0;
    boolean bool;
    if (BaseLayer.access$000(localBaseLayer).getFloatValue() == 1.0F) {
      bool = true;
    } else {
      bool = false;
    }
    BaseLayer.access$100(localBaseLayer, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.BaseLayer.1
 * JD-Core Version:    0.7.0.1
 */