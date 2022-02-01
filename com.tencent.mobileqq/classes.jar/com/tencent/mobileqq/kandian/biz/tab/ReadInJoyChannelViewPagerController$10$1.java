package com.tencent.mobileqq.kandian.biz.tab;

import android.animation.Animator;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ReadInJoyChannelViewPagerController$10$1
  extends D8SafeAnimatorListener
{
  ReadInJoyChannelViewPagerController$10$1(ReadInJoyChannelViewPagerController.10 param10) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyChannelViewPagerController.b(this.a.this$0, false);
    ReadInJoyChannelViewPagerController.a(this.a.this$0, ReadInJoyChannelViewPagerController.c, 0.0F, 0);
    ReadInJoyChannelViewPagerController.g(this.a.this$0).postDelayed(new ReadInJoyChannelViewPagerController.10.1.1(this), 0L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.10.1
 * JD-Core Version:    0.7.0.1
 */