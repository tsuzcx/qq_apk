package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class AEEditorAILoadingView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorAILoadingView$8(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(AEEditorAILoadingView.a(1000.0F, paramValueAnimator.getAnimatedFraction(), 0.0F, 1.0F) * -90.0F + 90.0F);
    AEEditorAILoadingView.a(this.a).setPadding(0, i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.8
 * JD-Core Version:    0.7.0.1
 */