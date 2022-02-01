package com.tencent.mobileqq.nearby.guide;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyGuideActivity$10
  implements View.OnClickListener
{
  NearbyGuideActivity$10(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      this.a.d(HardCodeUtil.a(2131707193));
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(NearbyPeopleProfileActivity.c, 5);
      this.a.e("0X8005909");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.10
 * JD-Core Version:    0.7.0.1
 */