package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import beny;
import beoa;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(beny parambeny) {}
  
  public void run()
  {
    beny.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, beny.a(this.this$0).getHeight()));
    beny.a(this.this$0).setDuration(200L);
    beny.a(this.this$0).setFillAfter(true);
    beny.a(this.this$0).startAnimation(beny.a(this.this$0));
    beny.a(this.this$0).setAnimationListener(new beoa(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */