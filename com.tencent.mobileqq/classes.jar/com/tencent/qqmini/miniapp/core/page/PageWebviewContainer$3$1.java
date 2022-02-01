package com.tencent.qqmini.miniapp.core.page;

import android.animation.ValueAnimator;
import android.view.View;

class PageWebviewContainer$3$1
  implements Runnable
{
  PageWebviewContainer$3$1(PageWebviewContainer.3 param3, ValueAnimator paramValueAnimator) {}
  
  public void run()
  {
    this.this$1.val$pageWebview.getView().scrollTo(0, ((Integer)this.val$animation.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.3.1
 * JD-Core Version:    0.7.0.1
 */