package com.tencent.qqmini.sdk.core.widget;

import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import bemv;
import bemw;

public class ActionSheetDialog$3
  implements Runnable
{
  public ActionSheetDialog$3(bemv parambemv) {}
  
  public void run()
  {
    bemv.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bemv.a(this.this$0).getHeight()));
    bemv.a(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(bemv.a(this.this$0), 17432582));
    bemv.a(this.this$0).setDuration(200L);
    bemv.a(this.this$0).setFillAfter(true);
    bemv.a(this.this$0).startAnimation(bemv.a(this.this$0));
    bemv.a(this.this$0).setAnimationListener(new bemw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */