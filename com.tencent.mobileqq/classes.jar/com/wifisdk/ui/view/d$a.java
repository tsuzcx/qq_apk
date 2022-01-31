package com.wifisdk.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.wifisdk.TMSDKFreeWifiInfo;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.wifisdk.ui.api.RProxy.color;
import com.wifisdk.ui.api.RProxy.dimen;
import com.wifisdk.ui.api.RProxy.drawable;
import com.wifisdk.ui.api.RProxy.id;

class d$a
  implements Handler.Callback
{
  private d$a(d paramd) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1: 
        if ((d.b(this.vI) != null) && (d.c(this.vI) != null))
        {
          d.b(this.vI).removeHeaderView(d.c(this.vI));
          return false;
        }
        break;
      case 2: 
        if (!TMSDKWifiManager.isWiFiManagerExist())
        {
          this.vI.fS();
          return false;
        }
        paramMessage = (TMSDKFreeWifiInfo)paramMessage.obj;
        if ((d.b(this.vI) != null) && (paramMessage != null))
        {
          d.d(this.vI);
          d.e(this.vI).setBackgroundResource(RProxy.drawable.tmsdk_wifi_tick_icon);
          d.e(this.vI).clearAnimation();
          d.f(this.vI).setText(paramMessage.ssid);
          d.h(this.vI).setText(d.g(this.vI));
          d.h(this.vI).setTextColor(d.i(this.vI).getResources().getColor(RProxy.color.tmsdk_wifi_gray));
          int i = d.i(this.vI).getResources().getDimensionPixelSize(RProxy.dimen.tmsdk_wifi_item_des_padding);
          d.h(this.vI).setPadding(i, 0, i, 0);
          if (TextUtils.isEmpty(paramMessage.poi))
          {
            d.j(this.vI).setVisibility(8);
            return false;
          }
          d.j(this.vI).setVisibility(0);
          d.j(this.vI).setText(paramMessage.poi);
          paramMessage = (RelativeLayout.LayoutParams)d.j(this.vI).getLayoutParams();
          paramMessage.addRule(3, RProxy.id.tmsdk_wifi_description);
          d.j(this.vI).setLayoutParams(paramMessage);
          return false;
        }
        break;
      case 4: 
        this.vI.fS();
        return false;
      }
      return false;
    }
    catch (Exception paramMessage) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.wifisdk.ui.view.d.a
 * JD-Core Version:    0.7.0.1
 */