package com.tencent.mobileqq.wifi;

import MWIFI.SCGet3rdCloudCheck;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.WifiSdkObserver;
import com.tencent.mobileqq.app.WifiSdkObserver.IWifiSdkListener;

final class FreeWifiHelper$11
  implements WifiSdkObserver.IWifiSdkListener
{
  FreeWifiHelper$11(QQAppInterface paramQQAppInterface, WifiSdkObserver paramWifiSdkObserver) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 3)
    {
      QQAppInterface localQQAppInterface = this.a;
      if (localQQAppInterface != null) {
        localQQAppInterface.removeObserver(this.b);
      }
    }
  }
  
  public void a(SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.11
 * JD-Core Version:    0.7.0.1
 */