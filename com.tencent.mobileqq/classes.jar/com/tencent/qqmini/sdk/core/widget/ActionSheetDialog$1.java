package com.tencent.qqmini.sdk.core.widget;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import bgml;

public class ActionSheetDialog$1
  implements Runnable
{
  public ActionSheetDialog$1(bgml parambgml) {}
  
  public void run()
  {
    bgml.a(this.this$0).setVisibility(0);
    bgml.a(this.this$0).setVisibility(0);
    bgml.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bgml.a(this.this$0).getHeight(), 0.0F));
    bgml.a(this.this$0).setFillEnabled(true);
    bgml.a(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(bgml.a(this.this$0), 17432582));
    bgml.a(this.this$0).setDuration(400L);
    bgml.a(this.this$0).startAnimation(bgml.a(this.this$0));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setDuration(200L);
    bgml.a(this.this$0).startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */