package com.wifisdk.ui.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.wifisdk.ui.WifiSDKUIApi;
import com.wifisdk.ui.api.RProxy.string;
import wf7.fm;
import wf7.fm.a;
import wf7.hl;
import wf7.hv;

class a$4$1
  implements View.OnClickListener
{
  a$4$1(a.4 param4) {}
  
  public void onClick(View paramView)
  {
    paramView = null;
    a.a(this.uY.uU, true);
    try
    {
      fm.a locala = fm.dL().dO();
      if (locala != null) {
        paramView = locala.qu;
      }
      if (hl.i("com.tencent.wifimanager", paramView) == 1)
      {
        hv.fD().a(null);
        WifiSDKUIApi.showToast(a.l(this.uY.uU), a.l(this.uY.uU).getString(RProxy.string.tmsdk_wifi_download_wifi_manager_tip), 0);
      }
      hv.fD().a(a.l(this.uY.uU), 5);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.wifisdk.ui.view.a.4.1
 * JD-Core Version:    0.7.0.1
 */