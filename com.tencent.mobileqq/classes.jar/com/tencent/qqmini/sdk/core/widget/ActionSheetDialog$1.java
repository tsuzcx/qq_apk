package com.tencent.qqmini.sdk.core.widget;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import bgqs;

public class ActionSheetDialog$1
  implements Runnable
{
  public ActionSheetDialog$1(bgqs parambgqs) {}
  
  public void run()
  {
    bgqs.a(this.this$0).setVisibility(0);
    bgqs.a(this.this$0).setVisibility(0);
    bgqs.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bgqs.a(this.this$0).getHeight(), 0.0F));
    bgqs.a(this.this$0).setFillEnabled(true);
    bgqs.a(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(bgqs.a(this.this$0), 17432582));
    bgqs.a(this.this$0).setDuration(400L);
    bgqs.a(this.this$0).startAnimation(bgqs.a(this.this$0));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setDuration(200L);
    bgqs.a(this.this$0).startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */