package dov.com.qq.im.aeeditor.module.autotemplate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEEditorAutoTemplateLoadingView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorAutoTemplateLoadingView$4(AEEditorAutoTemplateLoadingView paramAEEditorAutoTemplateLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((AEEditorAutoTemplateLoadingView.a(this.a) >= 2) && (AEEditorAutoTemplateLoadingView.a(this.a)))
    {
      AEEditorAutoTemplateLoadingView.a(this.a, false);
      AEEditorAutoTemplateLoadingView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView.4
 * JD-Core Version:    0.7.0.1
 */