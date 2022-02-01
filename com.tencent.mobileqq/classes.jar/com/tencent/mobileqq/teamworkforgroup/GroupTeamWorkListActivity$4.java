package com.tencent.mobileqq.teamworkforgroup;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;

class GroupTeamWorkListActivity$4
  implements View.OnFocusChangeListener
{
  GroupTeamWorkListActivity$4(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.a.app, "0X800993D");
      paramView.clearFocus();
      if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
        return;
      }
      paramView = this.a;
      ITeamWorkFacadeCreator localITeamWorkFacadeCreator = (ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class);
      GroupTeamWorkListActivity localGroupTeamWorkListActivity = this.a;
      paramView.jdField_a_of_type_AndroidAppDialog = localITeamWorkFacadeCreator.getTroopTeamWorkFileSearchDialog(localGroupTeamWorkListActivity, GroupTeamWorkListActivity.a(localGroupTeamWorkListActivity), this.a.app, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_AndroidAppDialog.setTitle(HardCodeUtil.a(2131705488));
      this.a.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.a.jdField_a_of_type_AndroidAppDialog.show();
      this.a.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new GroupTeamWorkListActivity.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.4
 * JD-Core Version:    0.7.0.1
 */