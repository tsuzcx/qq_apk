package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bkzi;
import bkzn;

public class ActionSheet$7
  implements Runnable
{
  public ActionSheet$7(bkzi parambkzi) {}
  
  public void run()
  {
    bkzi.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bkzi.a(this.this$0).getHeight()));
    bkzi.a(this.this$0).setDuration(200L);
    bkzi.a(this.this$0).setFillAfter(true);
    bkzi.a(this.this$0).startAnimation(bkzi.a(this.this$0));
    bkzi.a(this.this$0).setAnimationListener(new bkzn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.7
 * JD-Core Version:    0.7.0.1
 */