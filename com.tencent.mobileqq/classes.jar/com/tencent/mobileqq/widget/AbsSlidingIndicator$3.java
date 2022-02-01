package com.tencent.mobileqq.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class AbsSlidingIndicator$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AbsSlidingIndicator$3(AbsSlidingIndicator paramAbsSlidingIndicator) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    } else {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    Object localObject = this.a;
    ((AbsSlidingIndicator)localObject).setChooseTabViewTextColor(((AbsSlidingIndicator)localObject).h);
    localObject = this.a;
    ((AbsSlidingIndicator)localObject).b(((AbsSlidingIndicator)localObject).h);
    localObject = this.a.g.getChildAt(this.a.h);
    if (localObject != null)
    {
      if (this.a.t)
      {
        QLog.i("SimpleSlidingIndicator", 2, "onGlobalLayout is anim");
      }
      else
      {
        AbsSlidingIndicator localAbsSlidingIndicator = this.a;
        localAbsSlidingIndicator.z = localAbsSlidingIndicator.getAniStartX();
      }
      if (((View)localObject).getMeasuredWidth() == 0)
      {
        localObject = this.a;
        ((AbsSlidingIndicator)localObject).z = ((AbsSlidingIndicator)localObject).getInitAniStartX();
      }
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AbsSlidingIndicator.3
 * JD-Core Version:    0.7.0.1
 */