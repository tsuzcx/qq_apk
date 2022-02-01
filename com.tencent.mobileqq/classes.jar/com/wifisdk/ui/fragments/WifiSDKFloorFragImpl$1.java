package com.wifisdk.ui.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.wifisdk.ui.WifiSDKUIApi;
import com.wifisdk.ui.api.BaseFragImplManager;
import com.wifisdk.ui.view.WifiCommonView;
import wf7.hk;

class WifiSDKFloorFragImpl$1
  implements View.OnClickListener
{
  WifiSDKFloorFragImpl$1(WifiSDKFloorFragImpl paramWifiSDKFloorFragImpl) {}
  
  public void onClick(View paramView)
  {
    WifiSDKUIApi.getFragImplManager().finishFragImpl(this.tr);
    if (!WifiSDKFloorFragImpl.a(this.tr).fQ()) {
      hk.az(500178);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.wifisdk.ui.fragments.WifiSDKFloorFragImpl.1
 * JD-Core Version:    0.7.0.1
 */