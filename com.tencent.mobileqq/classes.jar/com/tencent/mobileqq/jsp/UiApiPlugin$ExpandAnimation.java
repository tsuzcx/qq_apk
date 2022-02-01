package com.tencent.mobileqq.jsp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class UiApiPlugin$ExpandAnimation
  extends Animation
{
  View a;
  int b;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.a.getLayoutParams();
    paramTransformation.height = ((int)(this.b * paramFloat));
    this.a.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.ExpandAnimation
 * JD-Core Version:    0.7.0.1
 */