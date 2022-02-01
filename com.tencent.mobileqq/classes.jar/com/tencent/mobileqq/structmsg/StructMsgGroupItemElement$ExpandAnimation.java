package com.tencent.mobileqq.structmsg;

import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class StructMsgGroupItemElement$ExpandAnimation
  extends Animation
{
  ViewGroup a;
  int b;
  
  public StructMsgGroupItemElement$ExpandAnimation(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.a.measure(i, j);
    this.b = this.a.getMeasuredHeight();
    paramViewGroup = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    paramViewGroup.height = 0;
    this.a.setLayoutParams(paramViewGroup);
    this.a.setVisibility(0);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    paramTransformation.height = ((int)(this.b * paramFloat));
    this.a.setLayoutParams(paramTransformation);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupItemElement.ExpandAnimation
 * JD-Core Version:    0.7.0.1
 */