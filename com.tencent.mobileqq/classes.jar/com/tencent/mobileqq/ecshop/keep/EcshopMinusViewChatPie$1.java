package com.tencent.mobileqq.ecshop.keep;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieDelegate.IRefreshCallback;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;

class EcshopMinusViewChatPie$1
  implements BusinessObserver
{
  EcshopMinusViewChatPie$1(EcshopMinusViewChatPie paramEcshopMinusViewChatPie, IEcshopChatPieDelegate.IRefreshCallback paramIRefreshCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isSuccess: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("EcshopMinusViewChatPie", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt != 1) {
      return;
    }
    Object localObject1 = new qq_ad.QQAdGetRsp();
    try
    {
      ((qq_ad.QQAdGetRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
      if (((qq_ad.QQAdGetRsp)localObject1).qgg_msgs.has())
      {
        paramBundle = ((qq_ad.QQAdGetRsp)localObject1).qgg_msgs.get();
        if ((paramBundle != null) && (!paramBundle.isEmpty()))
        {
          paramInt = 0;
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            Object localObject2 = (String)paramBundle.next();
            localObject2 = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).buildMessageForArkApp((String)localObject2);
            if (((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).isArkAppMessageValid((ChatMessage)localObject2))
            {
              EcshopMinusViewChatPie.a(this.jdField_a_of_type_ComTencentMobileqqEcshopKeepEcshopMinusViewChatPie).add(localObject2);
              ((ChatMessage)localObject2).time = System.currentTimeMillis();
              if (paramInt == 0) {
                ((ChatMessage)localObject2).saveExtInfoToExtStr("add_title", "minus_view_title_second");
              }
            }
            ReportUtil.a().a.add(Long.valueOf(((ChatMessage)localObject2).uniseq));
            paramInt += 1;
          }
        }
      }
      paramBundle = (EcshopAdHandler)((AppInterface)AppUtils.a()).getBusinessHandler(EcshopAdHandler.class.getName());
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EcshopMinusViewChatPie", 2, "-----deleteRiskAd----");
        }
        paramBundle.a((qq_ad.QQAdGetRsp)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate$IRefreshCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate$IRefreshCallback.a(EcshopMinusViewChatPie.a(this.jdField_a_of_type_ComTencentMobileqqEcshopKeepEcshopMinusViewChatPie));
      }
      if ((((qq_ad.QQAdGetRsp)localObject1).qgg_prompt.has()) && (((qq_ad.QQAdGetRsp)localObject1).qgg_prompt_id.has()))
      {
        EcshopUtils.a(((qq_ad.QQAdGetRsp)localObject1).qgg_prompt.get(), ((qq_ad.QQAdGetRsp)localObject1).qgg_prompt_id.get());
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.EcshopMinusViewChatPie.1
 * JD-Core Version:    0.7.0.1
 */