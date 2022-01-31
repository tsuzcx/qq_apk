package com.tencent.qqmini.sdk.core.widget;

import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import bgml;
import bgmm;

public class ActionSheetDialog$3
  implements Runnable
{
  public ActionSheetDialog$3(bgml parambgml) {}
  
  public void run()
  {
    bgml.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bgml.a(this.this$0).getHeight()));
    bgml.a(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(bgml.a(this.this$0), 17432582));
    bgml.a(this.this$0).setDuration(200L);
    bgml.a(this.this$0).setFillAfter(true);
    bgml.a(this.this$0).startAnimation(bgml.a(this.this$0));
    bgml.a(this.this$0).setAnimationListener(new bgmm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */