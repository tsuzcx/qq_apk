package dov.com.qq.im.aeeditor.module.autotemplate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class AEEditorAutoTemplateLoadingView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorAutoTemplateLoadingView$6(AEEditorAutoTemplateLoadingView paramAEEditorAutoTemplateLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(AEEditorAutoTemplateLoadingView.a(1000.0F, paramValueAnimator.getAnimatedFraction(), 0.0F, 1.0F) * -90.0F + 90.0F);
    AEEditorAutoTemplateLoadingView.a(this.a).setPadding(0, i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView.6
 * JD-Core Version:    0.7.0.1
 */