package com.tencent.mobileqq.wifi;

import MWIFI.SCGet3rdCloudCheck;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.WifiSdkObserver;
import com.tencent.mobileqq.app.WifiSdkObserver.IWifiSdkListener;

final class FreeWifiHelper$10
  implements WifiSdkObserver.IWifiSdkListener
{
  FreeWifiHelper$10(QQAppInterface paramQQAppInterface, WifiSdkObserver paramWifiSdkObserver) {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppWifiSdkObserver);
    }
  }
  
  public void a(SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.10
 * JD-Core Version:    0.7.0.1
 */