package com.tencent.qqmini.sdk.core.widget;

import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import beme;
import bemf;

public class ActionSheetDialog$3
  implements Runnable
{
  public ActionSheetDialog$3(beme parambeme) {}
  
  public void run()
  {
    beme.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, beme.a(this.this$0).getHeight()));
    beme.a(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(beme.a(this.this$0), 17432582));
    beme.a(this.this$0).setDuration(200L);
    beme.a(this.this$0).setFillAfter(true);
    beme.a(this.this$0).startAnimation(beme.a(this.this$0));
    beme.a(this.this$0).setAnimationListener(new bemf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */