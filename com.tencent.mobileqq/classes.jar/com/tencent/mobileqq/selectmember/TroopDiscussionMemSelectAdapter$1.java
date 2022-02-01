package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopDiscussionMemSelectAdapter$1
  implements View.OnClickListener
{
  TroopDiscussionMemSelectAdapter$1(TroopDiscussionMemSelectAdapter paramTroopDiscussionMemSelectAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    TroopDiscussionMemSelectAdapter.a(this.a, (GroupTag)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionMemSelectAdapter.1
 * JD-Core Version:    0.7.0.1
 */