package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import benh;
import benj;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(benh parambenh) {}
  
  public void run()
  {
    benh.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, benh.a(this.this$0).getHeight()));
    benh.a(this.this$0).setDuration(200L);
    benh.a(this.this$0).setFillAfter(true);
    benh.a(this.this$0).startAnimation(benh.a(this.this$0));
    benh.a(this.this$0).setAnimationListener(new benj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */