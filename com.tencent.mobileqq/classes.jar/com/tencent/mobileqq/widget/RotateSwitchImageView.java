package com.tencent.mobileqq.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RotateSwitchImageView
  extends ImageView
{
  private ObjectAnimator a;
  
  public RotateSwitchImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RotateSwitchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RotateSwitchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    this.a = ObjectAnimator.ofFloat(this, "rotation", new float[] { 0.0F, -90.0F }).setDuration(250L);
  }
  
  public void a()
  {
    if (this.a == null) {
      c();
    }
    this.a.reverse();
  }
  
  public void b()
  {
    if (this.a == null) {
      c();
    }
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateSwitchImageView
 * JD-Core Version:    0.7.0.1
 */