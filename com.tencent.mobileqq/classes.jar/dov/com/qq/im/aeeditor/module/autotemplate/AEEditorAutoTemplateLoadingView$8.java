package dov.com.qq.im.aeeditor.module.autotemplate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class AEEditorAutoTemplateLoadingView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorAutoTemplateLoadingView$8(AEEditorAutoTemplateLoadingView paramAEEditorAutoTemplateLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(AEEditorAutoTemplateLoadingView.a(1000.0F, paramValueAnimator.getAnimatedFraction(), 0.0F, 1.0F) * 75.0F - 75.0F);
    AEEditorAutoTemplateLoadingView.b(this.a).setPadding(0, i, 0, 0);
    AEEditorAutoTemplateLoadingView.c(this.a).setPadding(0, i, 0, 0);
    paramValueAnimator = (ViewGroup.MarginLayoutParams)AEEditorAutoTemplateLoadingView.b(this.a).getLayoutParams();
    paramValueAnimator.topMargin = (i + AEEditorAutoTemplateLoadingView.b(this.a));
    AEEditorAutoTemplateLoadingView.b(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView.8
 * JD-Core Version:    0.7.0.1
 */