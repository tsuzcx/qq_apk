package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bgsi;
import bgsk;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(bgsi parambgsi) {}
  
  public void run()
  {
    bgsi.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bgsi.a(this.this$0).getHeight()));
    bgsi.a(this.this$0).setDuration(200L);
    bgsi.a(this.this$0).setFillAfter(true);
    bgsi.a(this.this$0).startAnimation(bgsi.a(this.this$0));
    bgsi.a(this.this$0).setAnimationListener(new bgsk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */