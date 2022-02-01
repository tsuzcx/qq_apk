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
      if (this.a.j != null) {
        return;
      }
      paramView = this.a;
      ITeamWorkFacadeCreator localITeamWorkFacadeCreator = (ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class);
      GroupTeamWorkListActivity localGroupTeamWorkListActivity = this.a;
      paramView.j = localITeamWorkFacadeCreator.getTroopTeamWorkFileSearchDialog(localGroupTeamWorkListActivity, GroupTeamWorkListActivity.b(localGroupTeamWorkListActivity), this.a.app, this.a.m);
      this.a.j.setTitle(HardCodeUtil.a(2131903376));
      this.a.j.setCanceledOnTouchOutside(true);
      this.a.j.show();
      this.a.j.setOnDismissListener(new GroupTeamWorkListActivity.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.4
 * JD-Core Version:    0.7.0.1
 */