package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class AEEditorApplyAllLoadingView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorApplyAllLoadingView$1(AEEditorApplyAllLoadingView paramAEEditorApplyAllLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(AEEditorAILoadingView.a(1000.0F, paramValueAnimator.getAnimatedFraction(), 0.0F, 1.0F) * -90.0F + 90.0F);
    AEEditorApplyAllLoadingView.a(this.a).setPadding(0, i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView.1
 * JD-Core Version:    0.7.0.1
 */