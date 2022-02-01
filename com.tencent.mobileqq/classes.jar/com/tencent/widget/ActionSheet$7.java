package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

class ActionSheet$7
  implements Runnable
{
  ActionSheet$7(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    ActionSheet localActionSheet = this.this$0;
    ActionSheet.access$402(localActionSheet, new TranslateAnimation(0.0F, 0.0F, 0.0F, ActionSheet.access$500(localActionSheet).getHeight()));
    ActionSheet.access$400(this.this$0).setDuration(200L);
    ActionSheet.access$400(this.this$0).setFillAfter(true);
    ActionSheet.access$500(this.this$0).startAnimation(ActionSheet.access$400(this.this$0));
    ActionSheet.access$400(this.this$0).setAnimationListener(new ActionSheet.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.7
 * JD-Core Version:    0.7.0.1
 */