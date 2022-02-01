package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;

class TextLayer$TextItem$4
  extends AnimatorListenerAdapter
{
  TextLayer$TextItem$4(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem.4
 * JD-Core Version:    0.7.0.1
 */