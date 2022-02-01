package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HomeworkGuideFragment$1
  implements View.OnClickListener
{
  HomeworkGuideFragment$1(HomeworkGuideFragment paramHomeworkGuideFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().setResult(1000);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment.1
 * JD-Core Version:    0.7.0.1
 */