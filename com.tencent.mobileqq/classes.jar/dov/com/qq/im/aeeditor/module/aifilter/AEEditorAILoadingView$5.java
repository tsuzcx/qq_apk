package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AEEditorAILoadingView$5
  implements Animator.AnimatorListener
{
  AEEditorAILoadingView$5(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, AEEditorAILoadingView.a(this.a) + 1);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.5
 * JD-Core Version:    0.7.0.1
 */