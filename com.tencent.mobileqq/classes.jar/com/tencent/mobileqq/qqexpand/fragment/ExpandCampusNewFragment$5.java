package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

class ExpandCampusNewFragment$5
  implements View.OnClickListener
{
  ExpandCampusNewFragment$5(ExpandCampusNewFragment paramExpandCampusNewFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("com.tencent.mobileqq.action.publishmood");
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramView.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    paramView.putExtra("uin", localUserInfo.qzone_uin);
    paramView.putExtra("key_from_kuolie", true);
    QZoneHelper.forwardToPublishMood(ExpandCampusNewFragment.c(this.a), localUserInfo, paramView, 0);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#feeds_page#publish_entrance", true, -1L, -1L, null, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment.5
 * JD-Core Version:    0.7.0.1
 */