package com.tencent.mobileqq.troop.activity;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;

public class TroopCreateMapViewSupportActivity$TroopCreateMapViewAnimation
  extends Animation
{
  private final int b;
  private final int c;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.a.d.getLayoutParams();
    paramTransformation.height = ((int)(this.b + this.c * paramFloat));
    this.a.d.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation
 * JD-Core Version:    0.7.0.1
 */