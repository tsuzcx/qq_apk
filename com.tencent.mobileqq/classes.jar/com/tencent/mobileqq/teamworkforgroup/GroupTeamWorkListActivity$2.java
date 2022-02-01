package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class GroupTeamWorkListActivity$2
  implements View.OnClickListener
{
  GroupTeamWorkListActivity$2(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (GroupPadTemplateAdapter.GroupPadTemplateItemHolder)paramView.getTag();
    Object localObject2;
    Object localObject3;
    if (((GroupPadTemplateAdapter.GroupPadTemplateItemHolder)localObject1).e == GroupPadTemplateAdapter.e)
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.a.app, "0X8009938");
      localObject1 = (ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class);
      localObject2 = this.a.app;
      localObject3 = this.a;
      ((ITeamWorkUtilsTemp)localObject1).openTroopTemplatePreviewUrlWithCheck((AppInterface)localObject2, (Activity)localObject3, 2, "group_online_doc_more_temp", ((GroupTeamWorkListActivity)localObject3).m, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      localObject1 = this.a.app;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(GroupTeamWorkListActivity.a(this.a));
      ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", ((StringBuilder)localObject2).toString(), "");
    }
    else
    {
      localObject2 = QFileUtils.a(this.a.app, this.a.m, this.a.app.getLongAccountUin());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        QQToast.makeText(this.a, (CharSequence)localObject2, 0).show();
      }
      else
      {
        ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.a.app, "0X8009937");
        localObject2 = (ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class);
        localObject3 = this.a.app;
        GroupTeamWorkListActivity localGroupTeamWorkListActivity = this.a;
        ((ITeamWorkUtils)localObject2).openGroupPadTemplatePreviewUrl((AppInterface)localObject3, localGroupTeamWorkListActivity, "group_online_doc_temp", GroupTeamWorkListActivity.a(localGroupTeamWorkListActivity), ((GroupPadTemplateAdapter.GroupPadTemplateItemHolder)localObject1).a);
        localObject1 = this.a.app;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(GroupTeamWorkListActivity.a(this.a));
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", ((StringBuilder)localObject2).toString(), "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.2
 * JD-Core Version:    0.7.0.1
 */