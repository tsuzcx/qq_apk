package com.wifisdk.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.wifisdk.ui.WifiSDKUIApi;
import wf7.hk;

class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public void onClick(View paramView)
  {
    WifiSDKUIApi.gotoWifiListPage(b.a(this.vb), 4);
    hk.az(398683);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.wifisdk.ui.view.b.1
 * JD-Core Version:    0.7.0.1
 */