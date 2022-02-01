package com.tencent.mobileqq.teamwork.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;

class TeamWorkAuthorizeSettingFragment$5$1
  implements DialogInterface.OnClickListener
{
  TeamWorkAuthorizeSettingFragment$5$1(TeamWorkAuthorizeSettingFragment.5 param5, TimDocSSOMsg.UinRightInfo paramUinRightInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.d.l = true;
    this.b.d.j.c(String.valueOf(this.a.uint64_uin.get()));
    this.b.d.j.notifyDataSetChanged();
    if (this.b.d.k == 1) {
      ReportController.b(TeamWorkAuthorizeSettingFragment.b(this.b.d), "dc00898", "", "", "0x8007CFD", "0x8007CFD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment.5.1
 * JD-Core Version:    0.7.0.1
 */