package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.statistics.ReportController;

class SelectMemberBuddyListAdapter$4
  implements View.OnClickListener
{
  SelectMemberBuddyListAdapter$4(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)this.a.a);
    ReportController.b(SelectMemberBuddyListAdapter.b(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.SelectMemberBuddyListAdapter.4
 * JD-Core Version:    0.7.0.1
 */