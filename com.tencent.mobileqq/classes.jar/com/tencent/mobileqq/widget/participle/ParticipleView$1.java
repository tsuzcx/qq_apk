package com.tencent.mobileqq.widget.participle;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ParticipleView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ParticipleView$1(ParticipleView paramParticipleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    long l = System.currentTimeMillis();
    paramValueAnimator = ParticipleView.a(this.a).iterator();
    int i = 1;
    while (paramValueAnimator.hasNext())
    {
      ParticipleView.ParticipleEntity localParticipleEntity = (ParticipleView.ParticipleEntity)paramValueAnimator.next();
      float f = Math.min((float)(l - ParticipleView.ParticipleEntity.e(localParticipleEntity)) / ParticipleView.b(this.a), 1.0F);
      ParticipleView.ParticipleEntity.a(localParticipleEntity, f);
      if (f < 1.0F) {
        i = 0;
      } else {
        paramValueAnimator.remove();
      }
    }
    if (i != 0)
    {
      ParticipleView.c(this.a).cancel();
      ParticipleView.a(this.a, null);
      ParticipleView.a(this.a).clear();
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "selectedAnimation end cancel");
      }
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.participle.ParticipleView.1
 * JD-Core Version:    0.7.0.1
 */