package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bfpc;
import bfpl;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(bfpc parambfpc) {}
  
  public void run()
  {
    if (bfpc.a(this.this$0) != null) {
      bfpc.a(this.this$0).a();
    }
    bfpc.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bfpc.a(this.this$0).getHeight(), 0.0F));
    bfpc.a(this.this$0).setFillEnabled(true);
    bfpc.a(this.this$0).setStartTime(300L);
    bfpc.a(this.this$0).setDuration(bfpc.a(this.this$0));
    bfpc.a(this.this$0, true);
    bfpc.a(this.this$0).startAnimation(bfpc.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */