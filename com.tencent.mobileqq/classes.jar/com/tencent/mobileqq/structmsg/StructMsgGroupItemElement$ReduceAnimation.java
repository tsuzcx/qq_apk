package com.tencent.mobileqq.structmsg;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class StructMsgGroupItemElement$ReduceAnimation
  extends Animation
{
  ViewGroup a;
  int b;
  
  public StructMsgGroupItemElement$ReduceAnimation(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
    this.b = this.a.getHeight();
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = (LinearLayout.LayoutParams)this.a.getLayoutParams();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgGroupItemElement.ReduceAnimation
 * JD-Core Version:    0.7.0.1
 */