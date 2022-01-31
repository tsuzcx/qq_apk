package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import begr;
import begt;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(begr parambegr) {}
  
  public void run()
  {
    begr.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, begr.a(this.this$0).getHeight()));
    begr.a(this.this$0).setDuration(200L);
    begr.a(this.this$0).setFillAfter(true);
    begr.a(this.this$0).startAnimation(begr.a(this.this$0));
    begr.a(this.this$0).setAnimationListener(new begt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */