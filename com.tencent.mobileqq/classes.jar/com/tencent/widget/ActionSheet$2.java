package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bfol;
import bfou;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(bfol parambfol) {}
  
  public void run()
  {
    if (bfol.a(this.this$0) != null) {
      bfol.a(this.this$0).a();
    }
    bfol.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bfol.a(this.this$0).getHeight(), 0.0F));
    bfol.a(this.this$0).setFillEnabled(true);
    bfol.a(this.this$0).setStartTime(300L);
    bfol.a(this.this$0).setDuration(bfol.a(this.this$0));
    bfol.a(this.this$0, true);
    bfol.a(this.this$0).startAnimation(bfol.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */