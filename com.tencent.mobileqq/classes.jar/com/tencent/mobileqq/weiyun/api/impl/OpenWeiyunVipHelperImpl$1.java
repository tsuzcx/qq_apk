package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class OpenWeiyunVipHelperImpl$1
  implements DialogInterface.OnClickListener
{
  OpenWeiyunVipHelperImpl$1(OpenWeiyunVipHelperImpl paramOpenWeiyunVipHelperImpl, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWeiyunApiImplOpenWeiyunVipHelperImpl.isNonVipSpaceOverErrorCode(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqWeiyunApiImplOpenWeiyunVipHelperImpl.startOpenWeiyunVipCompareH5(this.jdField_a_of_type_AndroidAppActivity, null, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiImplOpenWeiyunVipHelperImpl.startOpenQQVipH5(this.jdField_a_of_type_AndroidAppActivity, "mvip.n.a.zcwy_popup", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.OpenWeiyunVipHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */