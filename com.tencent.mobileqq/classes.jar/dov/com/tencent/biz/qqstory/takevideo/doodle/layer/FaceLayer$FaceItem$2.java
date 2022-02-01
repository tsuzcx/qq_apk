package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;

class FaceLayer$FaceItem$2
  extends AnimatorListenerAdapter
{
  FaceLayer$FaceItem$2(FaceLayer.FaceItem paramFaceItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SLog.b(FaceLayer.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b(FaceLayer.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b(FaceLayer.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem.2
 * JD-Core Version:    0.7.0.1
 */