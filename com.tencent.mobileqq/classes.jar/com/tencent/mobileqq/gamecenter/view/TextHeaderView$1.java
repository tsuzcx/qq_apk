package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextHeaderView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView)))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 0);
      QQGameConstant.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 0);
      ((IApolloExtensionHandler)CmGameUtil.a().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("pa_msgId"), TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView.1
 * JD-Core Version:    0.7.0.1
 */