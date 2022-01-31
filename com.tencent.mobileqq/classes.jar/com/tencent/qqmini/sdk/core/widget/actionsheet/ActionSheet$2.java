package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bgob;
import bgok;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(bgob parambgob) {}
  
  public void run()
  {
    if (bgob.a(this.this$0) != null) {
      bgob.a(this.this$0).a();
    }
    bgob.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bgob.a(this.this$0).getHeight(), 0.0F));
    bgob.a(this.this$0).setFillEnabled(true);
    bgob.a(this.this$0).setStartTime(300L);
    bgob.a(this.this$0).setDuration(bgob.a(this.this$0));
    bgob.a(this.this$0, true);
    bgob.a(this.this$0).startAnimation(bgob.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */