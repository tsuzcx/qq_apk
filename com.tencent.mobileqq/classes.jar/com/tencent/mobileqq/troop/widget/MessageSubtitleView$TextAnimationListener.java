package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.Queue;

class MessageSubtitleView$TextAnimationListener
  extends D8SafeAnimatorListener
{
  boolean a = false;
  int b;
  
  public MessageSubtitleView$TextAnimationListener(MessageSubtitleView paramMessageSubtitleView, boolean paramBoolean, int paramInt)
  {
    this.a = paramBoolean;
    this.b = paramInt;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a)
    {
      if (this.b == MessageSubtitleView.e) {
        this.c.b();
      }
      if (!this.c.c.isEmpty()) {
        MessageSubtitleView.a(this.c);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MessageSubtitleView.TextAnimationListener
 * JD-Core Version:    0.7.0.1
 */