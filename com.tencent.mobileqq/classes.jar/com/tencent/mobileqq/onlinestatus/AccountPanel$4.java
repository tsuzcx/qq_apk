package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.animation.TranslateAnimation;
import atjj;
import atjt;

public class AccountPanel$4
  implements Runnable
{
  public AccountPanel$4(atjj paramatjj) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, atjj.a(this.this$0).getHeight());
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    atjj.a(this.this$0).startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new atjt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.4
 * JD-Core Version:    0.7.0.1
 */