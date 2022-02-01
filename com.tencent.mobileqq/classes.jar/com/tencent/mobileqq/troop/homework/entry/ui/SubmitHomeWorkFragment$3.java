package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;

class SubmitHomeWorkFragment$3
  implements View.OnClickListener
{
  SubmitHomeWorkFragment$3(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    InputMethodUtil.b(paramView);
    this.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.3
 * JD-Core Version:    0.7.0.1
 */