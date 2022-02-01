package com.tencent.qqmini.sdk.widget.actionsheet;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

class ActionSheet$4
  implements Runnable
{
  ActionSheet$4(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    if (ActionSheet.access$800(this.this$0) != null) {
      ActionSheet.access$800(this.this$0).a();
    }
    ActionSheet localActionSheet = this.this$0;
    ActionSheet.access$902(localActionSheet, new TranslateAnimation(0.0F, 0.0F, ActionSheet.access$1000(localActionSheet).getHeight(), 0.0F));
    ActionSheet.access$900(this.this$0).setFillEnabled(true);
    ActionSheet.access$900(this.this$0).setStartTime(300L);
    ActionSheet.access$900(this.this$0).setDuration(ActionSheet.access$1100(this.this$0));
    ActionSheet.access$1202(this.this$0, true);
    ActionSheet.access$1000(this.this$0).startAnimation(ActionSheet.access$900(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.4
 * JD-Core Version:    0.7.0.1
 */