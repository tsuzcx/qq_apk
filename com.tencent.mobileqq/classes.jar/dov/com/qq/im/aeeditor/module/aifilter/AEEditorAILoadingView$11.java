package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEEditorAILoadingView$11
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorAILoadingView$11(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.11
 * JD-Core Version:    0.7.0.1
 */