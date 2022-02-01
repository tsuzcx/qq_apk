package dov.com.qq.im.ae.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FaceImageViewer$2
  extends AnimatorListenerAdapter
{
  FaceImageViewer$2(FaceImageViewer paramFaceImageViewer) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FaceImageViewer.access$102(this.this$0, false);
    this.this$0.invalidate();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FaceImageViewer.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceImageViewer.2
 * JD-Core Version:    0.7.0.1
 */