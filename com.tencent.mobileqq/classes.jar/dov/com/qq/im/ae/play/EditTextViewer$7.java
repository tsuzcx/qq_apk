package dov.com.qq.im.ae.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class EditTextViewer$7
  extends AnimatorListenerAdapter
{
  EditTextViewer$7(EditTextViewer paramEditTextViewer) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EditTextViewer.access$1102(this.this$0, false);
    this.this$0.invalidate();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    EditTextViewer.access$1102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer.7
 * JD-Core Version:    0.7.0.1
 */