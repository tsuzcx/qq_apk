package com.tencent.mobileqq.troop.selecttroopmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectTroopMemberFragment$4
  implements View.OnClickListener
{
  SelectTroopMemberFragment$4(SelectTroopMemberFragment paramSelectTroopMemberFragment, CheckBox paramCheckBox) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isChecked()) {
      new ReportTask(this.b.a).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_nomore").a(this.b.c).a(new String[] { this.b.d }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.4
 * JD-Core Version:    0.7.0.1
 */