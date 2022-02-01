package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class AutoReplyAdapter$7
  extends Animation
{
  AutoReplyAdapter$7(AutoReplyAdapter paramAutoReplyAdapter, View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat == 1.0F)
    {
      this.a.setVisibility(8);
      return;
    }
    paramTransformation = this.a.getLayoutParams();
    if (paramTransformation != null)
    {
      int i = this.b;
      paramTransformation.height = (i - (int)(i * paramFloat));
      this.a.setLayoutParams(paramTransformation);
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.7
 * JD-Core Version:    0.7.0.1
 */