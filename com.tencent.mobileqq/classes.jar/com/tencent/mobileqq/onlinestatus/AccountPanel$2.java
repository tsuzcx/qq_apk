package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.animation.TranslateAnimation;
import atjj;

public class AccountPanel$2
  implements Runnable
{
  public AccountPanel$2(atjj paramatjj) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, atjj.a(this.this$0).getHeight(), 0.0F);
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setStartTime(300L);
    localTranslateAnimation.setDuration(300L);
    atjj.a(this.this$0).startAnimation(localTranslateAnimation);
    atjj.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.2
 * JD-Core Version:    0.7.0.1
 */