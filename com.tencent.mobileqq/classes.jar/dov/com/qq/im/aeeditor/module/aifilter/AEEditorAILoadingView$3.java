package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class AEEditorAILoadingView$3
  implements Animator.AnimatorListener
{
  AEEditorAILoadingView$3(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.a).setVisibility(8);
    AEEditorAILoadingView.b(this.a).setVisibility(0);
    AEEditorAILoadingView.b(this.a).playAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorAILoadingView.b(this.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.3
 * JD-Core Version:    0.7.0.1
 */