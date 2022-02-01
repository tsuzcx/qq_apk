package dov.com.qq.im.ae.play;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;

class EditTextViewer$6
  implements ValueAnimator.AnimatorUpdateListener
{
  EditTextViewer$6(EditTextViewer paramEditTextViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    EditTextViewer.access$1000(this.this$0).setAlpha(i);
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer.6
 * JD-Core Version:    0.7.0.1
 */