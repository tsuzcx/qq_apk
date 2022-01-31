package com.tencent.qqmini.sdk.core.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import beny;
import beoh;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(beny parambeny) {}
  
  public void run()
  {
    if (beny.a(this.this$0) != null) {
      beny.a(this.this$0).a();
    }
    beny.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, beny.a(this.this$0).getHeight(), 0.0F));
    beny.a(this.this$0).setFillEnabled(true);
    beny.a(this.this$0).setStartTime(300L);
    beny.a(this.this$0).setDuration(beny.a(this.this$0));
    beny.a(this.this$0, true);
    beny.a(this.this$0).startAnimation(beny.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.actionsheet.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */