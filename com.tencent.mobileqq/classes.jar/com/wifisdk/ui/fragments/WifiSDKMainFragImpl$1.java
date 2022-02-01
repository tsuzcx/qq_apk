package com.wifisdk.ui.fragments;

import com.wifisdk.ui.WifiSDKUIApi;
import com.wifisdk.ui.api.BaseFragImplManager;
import com.wifisdk.ui.view.a.a;
import wf7.hk;

class WifiSDKMainFragImpl$1
  implements a.a
{
  WifiSDKMainFragImpl$1(WifiSDKMainFragImpl paramWifiSDKMainFragImpl) {}
  
  public void M(boolean paramBoolean)
  {
    WifiSDKUIApi.getFragImplManager().finishFragImpl(this.tv);
    if (!paramBoolean) {
      hk.az(500179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.wifisdk.ui.fragments.WifiSDKMainFragImpl.1
 * JD-Core Version:    0.7.0.1
 */