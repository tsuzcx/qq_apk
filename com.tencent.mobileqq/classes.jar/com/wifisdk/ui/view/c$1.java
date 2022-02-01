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
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            paramMessage = (List)paramMessage.obj;
            if (paramMessage != null) {
              c.h(this.vr).s(paramMessage);
            }
          }
          else
          {
            i = paramMessage.arg1;
            c.b(this.vr).setBackgroundResource(RProxy.color.tmsdk_wifi_security_header_high_danger);
            c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_risk);
            c.d(this.vr).clearAnimation();
            c.d(this.vr).setVisibility(8);
            c.f(this.vr).setText(String.format(c.g(this.vr).getString(RProxy.string.tmsdk_wifi_security_result), new Object[] { Integer.valueOf(i) }));
            hk.az(398682);
          }
        }
        else
        {
          i = paramMessage.arg1;
          c.b(this.vr).setBackgroundResource(RProxy.color.tmsdk_wifi_security_header_normal);
          c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_risk);
          c.d(this.vr).clearAnimation();
          c.d(this.vr).setVisibility(8);
          c.f(this.vr).setText(String.format(c.g(this.vr).getString(RProxy.string.tmsdk_wifi_security_result), new Object[] { Integer.valueOf(i) }));
          hk.az(398684);
        }
      }
      else
      {
        i = paramMessage.arg1;
        c.b(this.vr).setBackgroundResource(RProxy.drawable.tmsdk_wifi_title_gradient);
        c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_safe);
        c.d(this.vr).clearAnimation();
        c.d(this.vr).setVisibility(8);
        c.f(this.vr).setText(String.format(c.g(this.vr).getString(RProxy.string.tmsdk_wifi_security_result), new Object[] { Integer.valueOf(i) }));
        hk.az(398687);
      }
    }
    else
    {
      c.b(this.vr).setBackgroundResource(RProxy.drawable.tmsdk_wifi_title_gradient);
      c.c(this.vr).setImageResource(RProxy.drawable.tmsdk_wifi_secure_checking);
      c.d(this.vr).setVisibility(0);
      if (c.e(this.vr) != null) {
        c.d(this.vr).startAnimation(c.e(this.vr));
      }
      c.f(this.vr).setText(RProxy.string.tmsdk_wifi_security_checking);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.wifisdk.ui.view.c.1
 * JD-Core Version:    0.7.0.1
 */