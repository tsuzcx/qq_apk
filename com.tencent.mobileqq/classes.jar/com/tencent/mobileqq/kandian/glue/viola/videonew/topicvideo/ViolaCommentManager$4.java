package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;

class ViolaCommentManager$4
  extends AnimatorListenerAdapter
{
  ViolaCommentManager$4(ViolaCommentManager paramViolaCommentManager, VVideoView paramVVideoView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ViolaCommentManager.a(this.c, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.4
 * JD-Core Version:    0.7.0.1
 */