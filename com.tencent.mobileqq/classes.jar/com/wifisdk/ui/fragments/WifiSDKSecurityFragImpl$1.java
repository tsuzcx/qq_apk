package com.wifisdk.ui.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.wifisdk.ui.WifiSDKUIApi;
import com.wifisdk.ui.api.BaseFragImplManager;

class WifiSDKSecurityFragImpl$1
  implements View.OnClickListener
{
  WifiSDKSecurityFragImpl$1(WifiSDKSecurityFragImpl paramWifiSDKSecurityFragImpl) {}
  
  public void onClick(View paramView)
  {
    WifiSDKUIApi.getFragImplManager().finishFragImpl(this.ty);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.wifisdk.ui.fragments.WifiSDKSecurityFragImpl.1
 * JD-Core Version:    0.7.0.1
 */