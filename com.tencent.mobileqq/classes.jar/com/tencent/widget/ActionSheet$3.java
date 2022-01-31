package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bfol;
import bfon;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(bfol parambfol) {}
  
  public void run()
  {
    bfol.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bfol.a(this.this$0).getHeight()));
    bfol.a(this.this$0).setDuration(200L);
    bfol.a(this.this$0).setFillAfter(true);
    bfol.a(this.this$0).startAnimation(bfol.a(this.this$0));
    bfol.a(this.this$0).setAnimationListener(new bfon(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */