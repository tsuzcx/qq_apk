package com.tencent.mobileqq.troop.selecttroopmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectTroopMemberFragment$2
  implements View.OnClickListener
{
  SelectTroopMemberFragment$2(SelectTroopMemberFragment paramSelectTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    new ReportTask(this.a.a).a("dc00899").b("Grp_mber").c("del_mber").d("del_return").a(this.a.c).a(new String[] { this.a.d }).a();
    this.a.getBaseActivity().doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */