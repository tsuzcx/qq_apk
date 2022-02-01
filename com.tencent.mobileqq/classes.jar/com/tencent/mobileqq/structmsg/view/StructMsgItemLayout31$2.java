package com.tencent.mobileqq.structmsg.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager;
import com.tencent.mobileqq.activity.qwallet.fragment.QwalletGdtCanvasFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class StructMsgItemLayout31$2
  implements View.OnClickListener
{
  StructMsgItemLayout31$2(StructMsgItemLayout31 paramStructMsgItemLayout31, Context paramContext, GdtAd paramGdtAd, QWalletGdtAdManager paramQWalletGdtAdManager) {}
  
  public void onClick(View paramView)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)this.jdField_a_of_type_AndroidContentContext);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = false;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletGdtAdManager.a(this.jdField_a_of_type_AndroidContentContext));
    localParams.jdField_b_of_type_JavaLangClass = QwalletGdtCanvasFragment.class;
    if (localParams.jdField_a_of_type_AndroidOsBundle == null) {
      localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout31.ab));
    GdtHandler.a(localParams);
    AdExposureChecker.onClick(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(StructMsgItemLayout31.a));
    QWalletGdtAdManager.a("public.tailplace.click", "", "", "1", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout31.2
 * JD-Core Version:    0.7.0.1
 */