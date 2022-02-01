package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bkho;
import bkib;

public class ActionSheet$6
  implements Runnable
{
  public ActionSheet$6(bkho parambkho) {}
  
  public void run()
  {
    if (bkho.a(this.this$0) != null) {
      bkho.a(this.this$0).a();
    }
    bkho.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bkho.a(this.this$0).getHeight(), 0.0F));
    bkho.a(this.this$0).setFillEnabled(true);
    bkho.a(this.this$0).setStartTime(300L);
    bkho.a(this.this$0).setDuration(bkho.a(this.this$0));
    bkho.a(this.this$0, true);
    bkho.a(this.this$0).startAnimation(bkho.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.6
 * JD-Core Version:    0.7.0.1
 */