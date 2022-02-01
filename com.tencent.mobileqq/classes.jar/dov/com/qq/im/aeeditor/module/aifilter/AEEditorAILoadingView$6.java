package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEEditorAILoadingView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorAILoadingView$6(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((AEEditorAILoadingView.a(this.a) >= 2) && (AEEditorAILoadingView.a(this.a)))
    {
      AEEditorAILoadingView.a(this.a, false);
      AEEditorAILoadingView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.6
 * JD-Core Version:    0.7.0.1
 */