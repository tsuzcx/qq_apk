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

class EcshopAdViewHelper$5
  implements View.OnClickListener
{
  EcshopAdViewHelper$5(EcshopAdViewHelper paramEcshopAdViewHelper, PopupWindow paramPopupWindow, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    QLog.d("Ecshop_EcshopAdViewHelper", 1, "delete_ad");
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    EcshopAdViewHelper.DeleteMsgListener localDeleteMsgListener = this.b;
    if (localDeleteMsgListener != null) {
      localDeleteMsgListener.a(this.c);
    } else {
      ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).startDelAnimAndDelMsg((ChatMessage)this.c);
    }
    ((EcshopAdHandler)((BaseQQAppInterface)AppUtils.a()).getBusinessHandler(EcshopAdHandler.class.getName())).a(8, this.c);
    QQToast.makeText(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131889234), 1).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.5
 * JD-Core Version:    0.7.0.1
 */