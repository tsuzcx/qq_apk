package com.tencent.mobileqq.qwallet.impl;

import com.qwallet.temp.IBaseChatPieProxy;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class QWalletGdtAdApiImpl$1
  implements GdtAdLoader.Listener
{
  QWalletGdtAdApiImpl$1(QWalletGdtAdApiImpl paramQWalletGdtAdApiImpl, long paramLong, IBaseChatPieProxy paramIBaseChatPieProxy, QBaseActivity paramQBaseActivity) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    try
    {
      QWalletGdtAdApiImpl.access$002(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl, null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reqAds onResponse :");
        localStringBuilder.append(paramGdtAdLoader);
        localStringBuilder.append(",cost:");
        localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long);
        QLog.i("QWalletGdtAdApi", 2, localStringBuilder.toString());
      }
      if ((paramGdtAdLoader != null) && (paramGdtAdLoader.a() != null) && (paramGdtAdLoader.a().a != null) && (paramGdtAdLoader.a().a.ret.has()) && (paramGdtAdLoader.a().a.ret.get() == 0))
      {
        paramGdtAdLoader = paramGdtAdLoader.a().a;
        if ((paramGdtAdLoader.pos_ads_info.has()) && (paramGdtAdLoader.pos_ads_info.size() > 0) && (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ret.has()) && (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ret.get() == 0) && (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ads_info.has()))
        {
          if ((!QWalletGdtAdApiImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl)) && (QWalletGdtAdApiImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl) == 1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QWalletGdtAdApi", 2, "reqAds onResponse but mPvFlag is 1,will not display ad");
            }
            this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl.checkReportTailPlaceShow();
            return;
          }
          QWalletGdtAdApiImpl.access$402(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl, new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAdLoader.pos_ads_info.get(0)).ads_info.get(0)));
          QWalletGdtAdApiImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl, this.jdField_a_of_type_ComQwalletTempIBaseChatPieProxy);
          if (QWalletGdtAdApiImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl)) {
            ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QWalletGdtAdApiImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl));
          }
          if (QLog.isColorLevel())
          {
            paramGdtAdLoader = new StringBuilder();
            paramGdtAdLoader.append("reqAds onResponse : notifyDataSetChanged,mHasTailMsg:");
            paramGdtAdLoader.append(QWalletGdtAdApiImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl));
            QLog.i("QWalletGdtAdApi", 2, paramGdtAdLoader.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("QWalletGdtAdApi", 2, "reqAds onResponse : getAdInfo is null");
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl.checkReportTailPlaceShow();
        }
      }
      else
      {
        QWalletGdtAdApiImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl, paramGdtAdLoader);
        this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl.checkReportTailPlaceShow();
        return;
      }
    }
    catch (Throwable paramGdtAdLoader)
    {
      QLog.e("QWalletGdtAdApi", 1, paramGdtAdLoader, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletGdtAdApiImpl.1
 * JD-Core Version:    0.7.0.1
 */