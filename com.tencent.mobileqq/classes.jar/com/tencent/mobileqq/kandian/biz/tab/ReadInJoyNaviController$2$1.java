package com.tencent.mobileqq.kandian.biz.tab;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ReadInJoyNaviController$2$1
  implements Animation.AnimationListener
{
  ReadInJoyNaviController$2$1(ReadInJoyNaviController.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.a.this$0, true);
    ReadInJoyNaviController.a(this.a.this$0).setAlpha(0.0F);
    ReadInJoyNaviController.a(this.a.this$0).removeView(ReadInJoyNaviController.a(this.a.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController.2.1
 * JD-Core Version:    0.7.0.1
 */