package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bgob;
import bgod;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(bgob parambgob) {}
  
  public void run()
  {
    bgob.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bgob.a(this.this$0).getHeight()));
    bgob.a(this.this$0).setDuration(200L);
    bgob.a(this.this$0).setFillAfter(true);
    bgob.a(this.this$0).startAnimation(bgob.a(this.this$0));
    bgob.a(this.this$0).setAnimationListener(new bgod(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */