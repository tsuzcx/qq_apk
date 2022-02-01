package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class SubmitHomeWorkFragment$7
  implements View.OnClickListener
{
  SubmitHomeWorkFragment$7(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.7
 * JD-Core Version:    0.7.0.1
 */