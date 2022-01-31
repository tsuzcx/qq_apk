package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.animation.TranslateAnimation;
import auhi;
import auhs;

public class AccountPanel$4
  implements Runnable
{
  public AccountPanel$4(auhi paramauhi) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, auhi.a(this.this$0).getHeight());
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    auhi.a(this.this$0).startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new auhs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.4
 * JD-Core Version:    0.7.0.1
 */