package com.tencent.mobileqq.jsp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class UiApiPlugin$ReduceAnimation
  extends Animation
{
  View a;
  int b;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.a.getLayoutParams();
    paramTransformation.height = ((int)(this.b * (1.0F - paramFloat)));
    this.a.setLayoutParams(paramTransformation);
    if (paramFloat == 1.0F)
    {
      this.a.setVisibility(8);
      paramTransformation.height = this.b;
      this.a.setLayoutParams(paramTransformation);
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.ReduceAnimation
 * JD-Core Version:    0.7.0.1
 */