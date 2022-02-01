package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AioFriendTitleHelper$3
  implements View.OnClickListener
{
  AioFriendTitleHelper$3(AioFriendTitleHelper paramAioFriendTitleHelper) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(AioFriendTitleHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", AioFriendTitleHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localIntent.putExtra("key_uin_name", AioFriendTitleHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("key_open_via", "history-liaotian");
    PublicFragmentActivity.Launcher.a(AioFriendTitleHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    ReportController.b(AioFriendTitleHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A66B", "0X800A66B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.3
 * JD-Core Version:    0.7.0.1
 */