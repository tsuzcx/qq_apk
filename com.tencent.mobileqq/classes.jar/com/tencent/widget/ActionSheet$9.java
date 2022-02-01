package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActionSheet$9
  implements View.OnClickListener
{
  ActionSheet$9(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    if (ActionSheet.access$1500(this.this$0) != null) {
      ActionSheet.access$1500(this.this$0).onDismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.9
 * JD-Core Version:    0.7.0.1
 */