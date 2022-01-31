package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.animation.TranslateAnimation;
import awcx;
import awdg;

public class AccountPanel$3
  implements Runnable
{
  public AccountPanel$3(awcx paramawcx) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, awcx.a(this.this$0).getHeight());
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    awcx.a(this.this$0).startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new awdg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.3
 * JD-Core Version:    0.7.0.1
 */