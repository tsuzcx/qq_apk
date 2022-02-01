package com.tencent.mobileqq.teamworkforgroup;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupTeamWorkListActivity$1
  implements View.OnClickListener
{
  GroupTeamWorkListActivity$1(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportClickWithTroopType(this.a.app, "0X800993E", String.valueOf(this.a.a));
    PadInfo localPadInfo = (PadInfo)((CloudFileItemBuilder.CloudFileHolder)paramView.getTag()).a;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", HtmlOffline.a(localPadInfo.pad_url, "_bid=2517"));
    localBundle.putInt("key_team_work_edit_type", localPadInfo.type);
    localBundle.putString("key_team_work_title", localPadInfo.title);
    localBundle.putString("key_team_work_rul", localPadInfo.pad_url);
    localBundle.putInt("key_team_work_pad_list_type", localPadInfo.type_list);
    localBundle.putString("tdsourcetag", "s_qq_grpfile");
    TeamWorkDocEditBrowserActivity.a(this.a, localBundle, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.1
 * JD-Core Version:    0.7.0.1
 */