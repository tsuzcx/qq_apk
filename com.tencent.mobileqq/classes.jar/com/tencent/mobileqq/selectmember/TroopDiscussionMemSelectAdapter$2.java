package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopDiscussionMemSelectAdapter$2
  implements View.OnClickListener
{
  TroopDiscussionMemSelectAdapter$2(TroopDiscussionMemSelectAdapter paramTroopDiscussionMemSelectAdapter) {}
  
  public void onClick(View paramView)
  {
    TroopDiscussionMemSelectAdapter.a(this.a).onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionMemSelectAdapter.2
 * JD-Core Version:    0.7.0.1
 */