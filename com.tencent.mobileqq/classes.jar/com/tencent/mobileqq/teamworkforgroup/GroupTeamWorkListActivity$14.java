package com.tencent.mobileqq.teamworkforgroup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class GroupTeamWorkListActivity$14
  implements DialogInterface.OnClickListener
{
  GroupTeamWorkListActivity$14(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, PadInfo paramPadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131692257), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkHandler == null) {
      return;
    }
    paramDialogInterface = TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.domainId, this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.padId);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkHandler.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Long, paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.pad_url, true);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.14
 * JD-Core Version:    0.7.0.1
 */