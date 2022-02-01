package com.tencent.mobileqq.kandian.biz.skin;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class SlideActiveAnimController$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SlideActiveAnimController$2(SlideActiveAnimController paramSlideActiveAnimController, Runnable paramRunnable) {}
  
  public void onGlobalLayout()
  {
    this.b.a();
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController.2
 * JD-Core Version:    0.7.0.1
 */