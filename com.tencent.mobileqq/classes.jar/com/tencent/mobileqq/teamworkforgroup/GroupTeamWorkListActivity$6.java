package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupTeamWorkListActivity$6
  implements View.OnClickListener
{
  GroupTeamWorkListActivity$6(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).notifyDataSetChanged();
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getCurrentUin(), 1, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.6
 * JD-Core Version:    0.7.0.1
 */