package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class ReadInJoyNaviController$1$1
  extends AnimateUtils.AnimationAdapter
{
  ReadInJoyNaviController$1$1(ReadInJoyNaviController.1 param1, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(0.0F, 0.0F, ReadInJoyNaviController.e, 0.0F);
    paramAnimation.setDuration(30L);
    paramAnimation.setAnimationListener(new ReadInJoyNaviController.1.1.1(this));
    this.a.startAnimation(paramAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.b.this$0).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController.1.1
 * JD-Core Version:    0.7.0.1
 */