package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

class ExtendFriendCampusFragment$6
  implements View.OnClickListener
{
  ExtendFriendCampusFragment$6(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (!ExtendFriendSendMsgHelper.a(ExtendFriendCampusFragment.a(this.a)))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      localIntent.putExtra("uin", localUserInfo.qzone_uin);
      localIntent.putExtra("key_from_kuolie", true);
      QZoneHelper.forwardToPublishMood(ExtendFriendCampusFragment.a(this.a), localUserInfo, localIntent, 0);
      ExpandReportUtils.a("click#feeds_page#publish_entrance", true, -1L, -1L, null, true, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment.6
 * JD-Core Version:    0.7.0.1
 */