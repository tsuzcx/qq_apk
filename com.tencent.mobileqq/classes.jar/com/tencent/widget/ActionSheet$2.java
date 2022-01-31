package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import begr;
import beha;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(begr parambegr) {}
  
  public void run()
  {
    if (begr.a(this.this$0) != null) {
      begr.a(this.this$0).a();
    }
    begr.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, begr.a(this.this$0).getHeight(), 0.0F));
    begr.a(this.this$0).setFillEnabled(true);
    begr.a(this.this$0).setStartTime(300L);
    begr.a(this.this$0).setDuration(begr.a(this.this$0));
    begr.a(this.this$0, true);
    begr.a(this.this$0).startAnimation(begr.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */