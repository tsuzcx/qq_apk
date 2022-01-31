package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.animation.TranslateAnimation;
import avyo;
import avyx;

public class AccountPanel$3
  implements Runnable
{
  public AccountPanel$3(avyo paramavyo) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, avyo.a(this.this$0).getHeight());
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    avyo.a(this.this$0).startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new avyx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.3
 * JD-Core Version:    0.7.0.1
 */