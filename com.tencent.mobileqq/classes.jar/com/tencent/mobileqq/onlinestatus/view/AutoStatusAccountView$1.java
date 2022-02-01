package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class AutoStatusAccountView$1
{
  AutoStatusAccountView$1(AutoStatusAccountView paramAutoStatusAccountView, boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusAccountView.a, 2131698419, 2131698420);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusAccountView.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusAccountView.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAutoStatusAccountView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusAccountView.1
 * JD-Core Version:    0.7.0.1
 */