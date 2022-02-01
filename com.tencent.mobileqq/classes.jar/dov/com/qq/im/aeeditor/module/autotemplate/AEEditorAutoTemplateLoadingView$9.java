package dov.com.qq.im.aeeditor.module.autotemplate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEEditorAutoTemplateLoadingView$9
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorAutoTemplateLoadingView$9(AEEditorAutoTemplateLoadingView paramAEEditorAutoTemplateLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView.9
 * JD-Core Version:    0.7.0.1
 */