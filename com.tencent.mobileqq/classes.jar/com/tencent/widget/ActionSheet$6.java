package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bkzi;
import bkzv;

public class ActionSheet$6
  implements Runnable
{
  public ActionSheet$6(bkzi parambkzi) {}
  
  public void run()
  {
    if (bkzi.a(this.this$0) != null) {
      bkzi.a(this.this$0).a();
    }
    bkzi.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bkzi.a(this.this$0).getHeight(), 0.0F));
    bkzi.a(this.this$0).setFillEnabled(true);
    bkzi.a(this.this$0).setStartTime(300L);
    bkzi.a(this.this$0).setDuration(bkzi.a(this.this$0));
    bkzi.a(this.this$0, true);
    bkzi.a(this.this$0).startAnimation(bkzi.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.6
 * JD-Core Version:    0.7.0.1
 */