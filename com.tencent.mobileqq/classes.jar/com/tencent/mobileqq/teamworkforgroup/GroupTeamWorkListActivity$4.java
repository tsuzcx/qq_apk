package com.tencent.mobileqq.teamworkforgroup;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;

class GroupTeamWorkListActivity$4
  implements View.OnFocusChangeListener
{
  GroupTeamWorkListActivity$4(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TeamWorkUtils.a(this.a.app, "0X800993D");
      paramView.clearFocus();
      if (this.a.jdField_a_of_type_AndroidAppDialog == null) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_AndroidAppDialog = new TroopTeamWorkFileSearchDialog(this.a, GroupTeamWorkListActivity.a(this.a), this.a.app, this.a.jdField_a_of_type_Long);
    this.a.jdField_a_of_type_AndroidAppDialog.setTitle(HardCodeUtil.a(2131705415));
    this.a.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.a.jdField_a_of_type_AndroidAppDialog.show();
    this.a.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new GroupTeamWorkListActivity.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.4
 * JD-Core Version:    0.7.0.1
 */