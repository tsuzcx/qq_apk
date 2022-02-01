package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;

final class TabDragAnimationView$ScaleAnimUpdateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  boolean a = false;
  boolean b = false;
  float c = 1.0F;
  private final TabDragAnimationView d;
  
  TabDragAnimationView$ScaleAnimUpdateListener(TabDragAnimationView paramTabDragAnimationView)
  {
    this.d = paramTabDragAnimationView;
  }
  
  void a()
  {
    this.a = false;
    this.b = false;
    this.c = 1.0F;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f - this.c > 0.0F) {
      this.a = true;
    }
    if ((this.a) && (f > 0.8F)) {
      this.b = false;
    }
    this.c = f;
    this.d.c();
    if (QLog.isColorLevel())
    {
      paramValueAnimator = TabDragAnimationView.class.getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("do mScale animation, percent=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",reversed=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",doAnim=");
      localStringBuilder.append(this.b);
      QLog.d(paramValueAnimator, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView.ScaleAnimUpdateListener
 * JD-Core Version:    0.7.0.1
 */