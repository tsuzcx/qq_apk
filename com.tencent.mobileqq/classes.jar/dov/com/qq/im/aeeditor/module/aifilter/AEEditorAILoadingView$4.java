package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class AEEditorAILoadingView$4
  implements Animator.AnimatorListener
{
  AEEditorAILoadingView$4(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.c(this.a).setVisibility(8);
    AEEditorAILoadingView.d(this.a).playAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.4
 * JD-Core Version:    0.7.0.1
 */