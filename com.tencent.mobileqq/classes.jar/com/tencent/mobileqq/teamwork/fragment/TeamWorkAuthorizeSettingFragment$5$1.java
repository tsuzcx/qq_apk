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
    this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment$5.a.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment$5.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.b(String.valueOf(this.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get()));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment$5.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment$5.a.b == 1) {
      ReportController.b(TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment$5.a), "dc00898", "", "", "0x8007CFD", "0x8007CFD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment.5.1
 * JD-Core Version:    0.7.0.1
 */