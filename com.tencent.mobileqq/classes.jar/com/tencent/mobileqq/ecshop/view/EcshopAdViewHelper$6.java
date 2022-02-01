package com.tencent.mobileqq.ecshop.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class EcshopAdViewHelper$6
  implements View.OnClickListener
{
  EcshopAdViewHelper$6(EcshopAdViewHelper paramEcshopAdViewHelper, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener, MessageRecord paramMessageRecord, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    QLog.d("Ecshop_EcshopAdViewHelper", 1, "filter_ad");
    EcshopAdViewHelper.DeleteMsgListener localDeleteMsgListener = this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopAdViewHelper$DeleteMsgListener;
    if (localDeleteMsgListener != null) {
      localDeleteMsgListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    } else {
      ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).startDelAnimAndDelMsg((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    ((EcshopAdHandler)((BaseQQAppInterface)AppUtils.a()).getBusinessHandler(EcshopAdHandler.class.getName())).a(7, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    QQToast.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131692247), 1).a();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.6
 * JD-Core Version:    0.7.0.1
 */