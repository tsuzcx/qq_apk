package com.tencent.qqmini.sdk.core.widget;

import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import bgqs;
import bgqt;

public class ActionSheetDialog$3
  implements Runnable
{
  public ActionSheetDialog$3(bgqs parambgqs) {}
  
  public void run()
  {
    bgqs.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bgqs.a(this.this$0).getHeight()));
    bgqs.a(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(bgqs.a(this.this$0), 17432582));
    bgqs.a(this.this$0).setDuration(200L);
    bgqs.a(this.this$0).setFillAfter(true);
    bgqs.a(this.this$0).startAnimation(bgqs.a(this.this$0));
    bgqs.a(this.this$0).setAnimationListener(new bgqt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */