package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectTroopMemberFragment$5
  implements View.OnClickListener
{
  SelectTroopMemberFragment$5(SelectTroopMemberFragment paramSelectTroopMemberFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.a.dismiss();
    }
    new ReportTask(this.b.a).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_cel").a(this.b.c).a(new String[] { this.b.d }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.5
 * JD-Core Version:    0.7.0.1
 */