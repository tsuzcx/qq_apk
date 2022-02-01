package com.tencent.mobileqq.dinifly.animation.content;

import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath;
import com.tencent.mobileqq.dinifly.model.content.ShapeTrimPath.Type;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent
  implements Content, BaseKeyframeAnimation.AnimationListener
{
  private final BaseKeyframeAnimation<?, Float> endAnimation;
  private final boolean hidden;
  private final List<BaseKeyframeAnimation.AnimationListener> listeners = new ArrayList();
  private final String name;
  private final BaseKeyframeAnimation<?, Float> offsetAnimation;
  private final BaseKeyframeAnimation<?, Float> startAnimation;
  private final ShapeTrimPath.Type type;
  
  public TrimPathContent(BaseLayer paramBaseLayer, ShapeTrimPath paramShapeTrimPath)
  {
    this.name = paramShapeTrimPath.getName();
    this.hidden = paramShapeTrimPath.isHidden();
    this.type = paramShapeTrimPath.getType();
    this.startAnimation = paramShapeTrimPath.getStart().createAnimation();
    this.endAnimation = paramShapeTrimPath.getEnd().createAnimation();
    this.offsetAnimation = paramShapeTrimPath.getOffset().createAnimation();
    paramBaseLayer.addAnimation(this.startAnimation);
    paramBaseLayer.addAnimation(this.endAnimation);
    paramBaseLayer.addAnimation(this.offsetAnimation);
    this.startAnimation.addUpdateListener(this);
    this.endAnimation.addUpdateListener(this);
    this.offsetAnimation.addUpdateListener(this);
  }
  
  void addListener(BaseKeyframeAnimation.AnimationListener paramAnimationListener)
  {
    this.listeners.add(paramAnimationListener);
  }
  
  public BaseKeyframeAnimation<?, Float> getEnd()
  {
    return this.endAnimation;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public BaseKeyframeAnimation<?, Float> getOffset()
  {
    return this.offsetAnimation;
  }
  
  public BaseKeyframeAnimation<?, Float> getStart()
  {
    return this.startAnimation;
  }
  
  ShapeTrimPath.Type getType()
  {
    return this.type;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public void onValueChanged()
  {
    int i = 0;
    while (i < this.listeners.size())
    {
      ((BaseKeyframeAnimation.AnimationListener)this.listeners.get(i)).onValueChanged();
      i += 1;
    }
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.TrimPathContent
 * JD-Core Version:    0.7.0.1
 */