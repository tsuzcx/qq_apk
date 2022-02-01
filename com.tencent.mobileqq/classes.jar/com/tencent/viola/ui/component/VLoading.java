package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.image.VImage2;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.image.VImageView2;

public class VLoading
  extends VImage2
{
  RotateAnimation mAnimator;
  
  public VLoading(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public VLoading(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer, int paramInt)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer, paramInt);
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mAnimator != null)
    {
      this.mAnimator.cancel();
      this.mAnimator = null;
    }
  }
  
  public VImageView2 initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = super.initComponentHostView(paramContext);
    this.mAnimator = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.mAnimator.setRepeatCount(-1);
    this.mAnimator.setInterpolator(new LinearInterpolator());
    this.mAnimator.setDuration(400L);
    this.mAnimator.setFillAfter(true);
    paramContext.startAnimation(this.mAnimator);
    paramContext.bindComponent(this);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VLoading
 * JD-Core Version:    0.7.0.1
 */