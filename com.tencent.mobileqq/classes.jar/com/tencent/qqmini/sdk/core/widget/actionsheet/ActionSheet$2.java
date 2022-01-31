package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bdje;
import bdjn;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(bdje parambdje) {}
  
  public void run()
  {
    if (bdje.a(this.this$0) != null) {
      bdje.a(this.this$0).a();
    }
    bdje.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bdje.a(this.this$0).getHeight(), 0.0F));
    bdje.a(this.this$0).setFillEnabled(true);
    bdje.a(this.this$0).setStartTime(300L);
    bdje.a(this.this$0).setDuration(bdje.a(this.this$0));
    bdje.a(this.this$0, true);
    bdje.a(this.this$0).startAnimation(bdje.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */