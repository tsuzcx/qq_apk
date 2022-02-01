package com.tencent.mobileqq.location.ui;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.QQPermissionCallback;

class LocationPickFragment$1
  implements QQPermissionCallback
{
  LocationPickFragment$1(LocationPickFragment paramLocationPickFragment, QBaseActivity paramQBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).setOnDismissListener(new LocationPickFragment.1.1(this));
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
    paramArrayOfString = paramArrayOfInt.getStringExtra("uin");
    paramInt = paramArrayOfInt.getIntExtra("uintype", -1);
    paramArrayOfInt = LocationHandler.a();
    paramArrayOfInt.a(paramInt, paramArrayOfString, paramArrayOfInt.a(), 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.1
 * JD-Core Version:    0.7.0.1
 */