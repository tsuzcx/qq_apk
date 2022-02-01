package com.tencent.mobileqq.troop.selecttroopmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectTroopMemberFragment$3
  implements View.OnClickListener
{
  SelectTroopMemberFragment$3(SelectTroopMemberFragment paramSelectTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    SelectTroopMemberFragment.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */