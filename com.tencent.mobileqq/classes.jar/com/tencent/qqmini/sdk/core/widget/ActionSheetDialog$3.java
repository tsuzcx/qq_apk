package com.tencent.qqmini.sdk.core.widget;

import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import bdib;
import bdic;

public class ActionSheetDialog$3
  implements Runnable
{
  public ActionSheetDialog$3(bdib parambdib) {}
  
  public void run()
  {
    bdib.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bdib.a(this.this$0).getHeight()));
    bdib.a(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(bdib.a(this.this$0), 17432582));
    bdib.a(this.this$0).setDuration(200L);
    bdib.a(this.this$0).setFillAfter(true);
    bdib.a(this.this$0).startAnimation(bdib.a(this.this$0));
    bdib.a(this.this$0).setAnimationListener(new bdic(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */