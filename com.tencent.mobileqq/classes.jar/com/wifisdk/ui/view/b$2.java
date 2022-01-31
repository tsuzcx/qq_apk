package com.wifisdk.ui.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.wifisdk.ui.WifiSDKUIApi;
import com.wifisdk.ui.api.RProxy.string;
import wf7.hk;
import wf7.hq;
import wf7.hv;

class b$2
  implements View.OnClickListener
{
  b$2(b paramb, hq paramhq) {}
  
  public void onClick(View paramView)
  {
    if (!hv.fF())
    {
      paramView = b.a(this.vb).getString(RProxy.string.tmsdk_wifi_security_downloading_wifiapp);
      WifiSDKUIApi.showToast(b.a(this.vb), paramView, 0);
    }
    if (this.vc.tH == 1) {
      hk.az(398685);
    }
    for (;;)
    {
      hv.fD().aB(5);
      hv.fD().a(b.a(this.vb), 6);
      return;
      hk.az(398688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.wifisdk.ui.view.b.2
 * JD-Core Version:    0.7.0.1
 */