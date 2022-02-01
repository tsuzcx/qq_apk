package com.wifisdk.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifisdk.ui.api.RProxy.color;
import com.wifisdk.ui.api.RProxy.drawable;
import com.wifisdk.ui.api.RProxy.string;
import java.util.List;
import wf7.hk;

class c$1
  extends Handler
{
  c$1(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return;
      int i;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        c.b(this.vr).setBackgroundResource(RProxy.drawable.tmsdk_wifi_title_gradient);
        c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_checking);
        c.d(this.vr).setVisibility(0);
        if (c.e(this.vr) != null) {
          c.d(this.vr).startAnimation(c.e(this.vr));
        }
        c.f(this.vr).setText(RProxy.string.tmsdk_wifi_security_checking);
        return;
      case 2: 
        i = paramMessage.arg1;
        c.b(this.vr).setBackgroundResource(RProxy.drawable.tmsdk_wifi_title_gradient);
        c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_safe);
        c.d(this.vr).clearAnimation();
        c.d(this.vr).setVisibility(8);
        c.f(this.vr).setText(String.format(c.g(this.vr).getString(RProxy.string.tmsdk_wifi_security_result), new Object[] { Integer.valueOf(i) }));
        hk.az(398687);
        return;
      case 3: 
        i = paramMessage.arg1;
        c.b(this.vr).setBackgroundResource(RProxy.color.tmsdk_wifi_security_header_normal);
        c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_risk);
        c.d(this.vr).clearAnimation();
        c.d(this.vr).setVisibility(8);
        c.f(this.vr).setText(String.format(c.g(this.vr).getString(RProxy.string.tmsdk_wifi_security_result), new Object[] { Integer.valueOf(i) }));
        hk.az(398684);
        return;
      case 4: 
        i = paramMessage.arg1;
        c.b(this.vr).setBackgroundResource(RProxy.color.tmsdk_wifi_security_header_high_danger);
        c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_risk);
        c.d(this.vr).clearAnimation();
        c.d(this.vr).setVisibility(8);
        c.f(this.vr).setText(String.format(c.g(this.vr).getString(RProxy.string.tmsdk_wifi_security_result), new Object[] { Integer.valueOf(i) }));
        hk.az(398682);
        return;
      }
      paramMessage = (List)paramMessage.obj;
    } while (paramMessage == null);
    c.h(this.vr).s(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.wifisdk.ui.view.c.1
 * JD-Core Version:    0.7.0.1
 */