package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bgsi;
import bgsr;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(bgsi parambgsi) {}
  
  public void run()
  {
    if (bgsi.a(this.this$0) != null) {
      bgsi.a(this.this$0).a();
    }
    bgsi.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bgsi.a(this.this$0).getHeight(), 0.0F));
    bgsi.a(this.this$0).setFillEnabled(true);
    bgsi.a(this.this$0).setStartTime(300L);
    bgsi.a(this.this$0).setDuration(bgsi.a(this.this$0));
    bgsi.a(this.this$0, true);
    bgsi.a(this.this$0).startAnimation(bgsi.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */