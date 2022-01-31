package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import benh;
import benq;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(benh parambenh) {}
  
  public void run()
  {
    if (benh.a(this.this$0) != null) {
      benh.a(this.this$0).a();
    }
    benh.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, benh.a(this.this$0).getHeight(), 0.0F));
    benh.a(this.this$0).setFillEnabled(true);
    benh.a(this.this$0).setStartTime(300L);
    benh.a(this.this$0).setDuration(benh.a(this.this$0));
    benh.a(this.this$0, true);
    benh.a(this.this$0).startAnimation(benh.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */