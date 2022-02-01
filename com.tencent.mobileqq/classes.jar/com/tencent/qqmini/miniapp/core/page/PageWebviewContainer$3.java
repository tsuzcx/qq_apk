package com.tencent.qqmini.miniapp.core.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class PageWebviewContainer$3
  implements ValueAnimator.AnimatorUpdateListener
{
  PageWebviewContainer$3(PageWebviewContainer paramPageWebviewContainer, PageWebview paramPageWebview) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ThreadManager.getUIHandler().post(new PageWebviewContainer.3.1(this, paramValueAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.3
 * JD-Core Version:    0.7.0.1
 */