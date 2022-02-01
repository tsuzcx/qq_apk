package com.tencent.qqmini.miniapp.core.page;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;

class PageWebviewContainer$4
  implements Animator.AnimatorListener
{
  PageWebviewContainer$4(PageWebviewContainer paramPageWebviewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$req.fail();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$req.ok();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.4
 * JD-Core Version:    0.7.0.1
 */