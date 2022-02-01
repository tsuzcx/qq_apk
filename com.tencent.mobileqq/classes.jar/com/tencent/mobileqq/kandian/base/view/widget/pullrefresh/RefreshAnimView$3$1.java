package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;

class RefreshAnimView$3$1
  implements Runnable
{
  RefreshAnimView$3$1(RefreshAnimView.3 param3) {}
  
  public void run()
  {
    RefreshAnimView.a(this.a.c).setText(this.a.a);
    if (this.a.b) {
      RefreshAnimView.a(this.a.c).setCompoundDrawablesWithIntrinsicBounds(2130851444, 0, 0, 0);
    } else {
      RefreshAnimView.a(this.a.c).setCompoundDrawablesWithIntrinsicBounds(2130851445, 0, 0, 0);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(100L);
    localAlphaAnimation.setFillAfter(true);
    RefreshAnimView.a(this.a.c).startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView.3.1
 * JD-Core Version:    0.7.0.1
 */