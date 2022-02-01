package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bkho;
import bkht;

public class ActionSheet$7
  implements Runnable
{
  public ActionSheet$7(bkho parambkho) {}
  
  public void run()
  {
    bkho.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bkho.a(this.this$0).getHeight()));
    bkho.a(this.this$0).setDuration(200L);
    bkho.a(this.this$0).setFillAfter(true);
    bkho.a(this.this$0).startAnimation(bkho.a(this.this$0));
    bkho.a(this.this$0).setAnimationListener(new bkht(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.7
 * JD-Core Version:    0.7.0.1
 */