package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bfpc;
import bfpe;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(bfpc parambfpc) {}
  
  public void run()
  {
    bfpc.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bfpc.a(this.this$0).getHeight()));
    bfpc.a(this.this$0).setDuration(200L);
    bfpc.a(this.this$0).setFillAfter(true);
    bfpc.a(this.this$0).startAnimation(bfpc.a(this.this$0));
    bfpc.a(this.this$0).setAnimationListener(new bfpe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */