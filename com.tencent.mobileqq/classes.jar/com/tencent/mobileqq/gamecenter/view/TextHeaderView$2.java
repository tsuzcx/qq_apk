package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextHeaderView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView)))
    {
      Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 0);
      localObject = QQGameConstant.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 0);
      GameCenterUtils.a(CmGameUtil.a(), "769", "205019", (String)localObject, "76901", "1", "160", new String[] { QQGameConstant.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "", "20" });
      ((IApolloExtensionHandler)CmGameUtil.a().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("pa_msgId"), TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView.2
 * JD-Core Version:    0.7.0.1
 */