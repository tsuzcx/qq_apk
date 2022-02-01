package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class StructMsgItemLayout31$1
  implements AdExposureChecker.ExposureCallback
{
  StructMsgItemLayout31$1(StructMsgItemLayout31 paramStructMsgItemLayout31, QWalletGdtAdManager paramQWalletGdtAdManager, Context paramContext, GdtAd paramGdtAd) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletGdtAdManager_StructMsgItemLayout31", 2, "reportImpression...");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager.a(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForImpression());
    QWalletGdtAdManager.a("public.tailplace.show", "", "", "1", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout31.1
 * JD-Core Version:    0.7.0.1
 */