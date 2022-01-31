package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bdje;
import bdjg;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(bdje parambdje) {}
  
  public void run()
  {
    bdje.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bdje.a(this.this$0).getHeight()));
    bdje.a(this.this$0).setDuration(200L);
    bdje.a(this.this$0).setFillAfter(true);
    bdje.a(this.this$0).startAnimation(bdje.a(this.this$0));
    bdje.a(this.this$0).setAnimationListener(new bdjg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */