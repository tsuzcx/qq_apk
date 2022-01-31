package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.animation.TranslateAnimation;
import avyo;

public class AccountPanel$1
  implements Runnable
{
  public AccountPanel$1(avyo paramavyo) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, avyo.a(this.this$0).getHeight(), 0.0F);
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setStartTime(300L);
    localTranslateAnimation.setDuration(300L);
    avyo.a(this.this$0).startAnimation(localTranslateAnimation);
    avyo.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.1
 * JD-Core Version:    0.7.0.1
 */