package com.tencent.widget;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

class ActionSheet$6
  implements Runnable
{
  ActionSheet$6(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    if (ActionSheet.access$200(this.this$0) != null) {
      ActionSheet.access$200(this.this$0).onPreShow();
    }
    ActionSheet.access$300(this.this$0).setVisibility(0);
    ActionSheet localActionSheet = this.this$0;
    ActionSheet.access$402(localActionSheet, new TranslateAnimation(0.0F, 0.0F, ActionSheet.access$500(localActionSheet).getHeight(), 0.0F));
    ActionSheet.access$400(this.this$0).setFillEnabled(true);
    ActionSheet.access$400(this.this$0).setStartTime(300L);
    ActionSheet.access$400(this.this$0).setDuration(ActionSheet.access$600(this.this$0));
    ActionSheet.access$702(this.this$0, true);
    ActionSheet.access$500(this.this$0).startAnimation(ActionSheet.access$400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.6
 * JD-Core Version:    0.7.0.1
 */