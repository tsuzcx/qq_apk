package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class LyricsController$14
  extends D8SafeAnimatorListener
{
  LyricsController$14(LyricsController paramLyricsController, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.e.i.a(this.a, this.b);
    this.e.j.a(this.c, this.d);
    this.e.i.b();
    this.e.j.b();
    this.e.A = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.e.i.a(this.a, this.b);
    this.e.j.a(this.c, this.d);
    this.e.i.b();
    this.e.j.b();
    this.e.A = null;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.14
 * JD-Core Version:    0.7.0.1
 */