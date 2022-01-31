package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bhpy;
import bhqh;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(bhpy parambhpy) {}
  
  public void run()
  {
    if (bhpy.a(this.this$0) != null) {
      bhpy.a(this.this$0).a();
    }
    bhpy.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bhpy.a(this.this$0).getHeight(), 0.0F));
    bhpy.a(this.this$0).setFillEnabled(true);
    bhpy.a(this.this$0).setStartTime(300L);
    bhpy.a(this.this$0).setDuration(bhpy.a(this.this$0));
    bhpy.a(this.this$0, true);
    bhpy.a(this.this$0).startAnimation(bhpy.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */