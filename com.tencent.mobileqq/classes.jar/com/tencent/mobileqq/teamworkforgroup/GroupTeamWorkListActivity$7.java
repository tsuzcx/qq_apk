package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class GroupTeamWorkListActivity$7
  implements PopupMenuDialog.OnClickActionListener
{
  GroupTeamWorkListActivity$7(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i;
    switch (paramMenuItem.id)
    {
    case 2131364739: 
    default: 
      i = 0;
      break;
    case 2131364741: 
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.a.app, "0X800993C");
      paramMenuItem = (ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class);
      localObject1 = this.a.app;
      localObject2 = this.a;
      paramMenuItem.openTroopTemplatePreviewUrlWithCheck((AppInterface)localObject1, (Activity)localObject2, 2, "group_online_doc", ((GroupTeamWorkListActivity)localObject2).a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      i = 2;
      break;
    case 2131364740: 
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.a.app, "0X800993B");
      paramMenuItem = (ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class);
      localObject1 = this.a.app;
      localObject2 = this.a;
      paramMenuItem.openTroopTemplatePreviewUrlWithCheck((AppInterface)localObject1, (Activity)localObject2, 1, "group_online_doc", ((GroupTeamWorkListActivity)localObject2).a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      i = 1;
      break;
    case 2131364738: 
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.a.app, "0X800993C");
      paramMenuItem = (ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class);
      localObject1 = this.a.app;
      localObject2 = this.a;
      paramMenuItem.openTroopTemplatePreviewUrlWithCheck((AppInterface)localObject1, (Activity)localObject2, 3, "group_online_doc", ((GroupTeamWorkListActivity)localObject2).a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      i = 3;
    }
    paramMenuItem = this.a.app;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(GroupTeamWorkListActivity.a(this.a));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(i);
    ReportController.b(paramMenuItem, "dc00898", "", "", "0X8009C65", "0X8009C65", 0, 0, "", "", (String)localObject1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.7
 * JD-Core Version:    0.7.0.1
 */