package dov.com.qq.im.aeeditor.module.autotemplate;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AEEditorAutoTemplateLoadingView$3
  implements Animator.AnimatorListener
{
  AEEditorAutoTemplateLoadingView$3(AEEditorAutoTemplateLoadingView paramAEEditorAutoTemplateLoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorAutoTemplateLoadingView.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAutoTemplateLoadingView.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEEditorAutoTemplateLoadingView.a(this.a, AEEditorAutoTemplateLoadingView.a(this.a) + 1);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorAutoTemplateLoadingView.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView.3
 * JD-Core Version:    0.7.0.1
 */