package com.tencent.mobileqq.onlinestatus.view;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class DoubleTapEffect
{
  private ImageView a;
  
  public DoubleTapEffect(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private void a(View paramView)
  {
    paramView.setPivotX(paramView.getWidth() * 0.5F);
    paramView.setPivotY(paramView.getHeight() * 1.0F);
    Property localProperty = View.ROTATION;
    float f1 = -10;
    float f2 = 10;
    paramView = ObjectAnimator.ofFloat(paramView, localProperty, new float[] { 0.0F, f1, 0.0F, f2, 0.0F, f1, 0.0F, f2, 0.0F });
    paramView.setDuration(300L);
    paramView.start();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "start() called");
    }
    a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.DoubleTapEffect
 * JD-Core Version:    0.7.0.1
 */