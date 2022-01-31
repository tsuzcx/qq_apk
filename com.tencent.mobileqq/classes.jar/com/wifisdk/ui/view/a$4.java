package com.wifisdk.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifisdk.ui.api.RProxy.drawable;
import com.wifisdk.ui.api.RProxy.string;
import wf7.fq;
import wf7.hk;
import wf7.hl;

class a$4
  implements Runnable
{
  a$4(a parama, int paramInt) {}
  
  public void run()
  {
    fq.H(false);
    int i1;
    int n;
    int i;
    int k;
    int j;
    int m;
    switch (this.uX)
    {
    default: 
      i1 = RProxy.string.tmsdk_wifi_no_wifi_title;
      n = RProxy.string.tmsdk_wifi_no_wifi_des;
      if (hl.fp())
      {
        i = RProxy.string.tmsdk_wifi_see_more_wifi;
        k = RProxy.drawable.tmsdk_wifi_icon_no_wifi;
        j = 500763;
        int i2 = 3;
        m = i;
        i = i2;
        label76:
        if (i != 3) {
          break label349;
        }
        a.i(this.uU).setVisibility(0);
        a.a(this.uU, a.i(this.uU));
        a.m(this.uU).setImageDrawable(a.l(this.uU).getResources().getDrawable(k));
        a.n(this.uU).setText(i1);
        a.o(this.uU).setText(n);
        a.p(this.uU).setText(m);
        a.p(this.uU).setOnClickListener(new a.4.1(this));
        a.h(this.uU).setVisibility(8);
        a.g(this.uU).setVisibility(8);
        a.j(this.uU).setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      if (j > 0) {
        hk.az(j);
      }
      a.a(this.uU, this.uX);
      if (a.q(this.uU).getVisibility() == 0) {
        a.q(this.uU).setVisibility(8);
      }
      return;
      j = 500760;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i = 2;
      break label76;
      j = 500762;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i = 2;
      break label76;
      j = 500761;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i = 2;
      break label76;
      i = 1;
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      break label76;
      i = RProxy.string.tmsdk_wifi_no_wifi_btn;
      break;
      label349:
      if (i == 2)
      {
        if (a.j(this.uU).getVisibility() != 0)
        {
          a.j(this.uU).setVisibility(0);
          a.j(this.uU).fR();
          a.h(this.uU).setVisibility(8);
          a.g(this.uU).setVisibility(8);
          a.i(this.uU).setVisibility(8);
        }
        a.a(this.uU, a.j(this.uU));
      }
      else
      {
        a.h(this.uU).setText(a.l(this.uU).getApplicationContext().getResources().getString(RProxy.string.tmsdk_wifi_updating_list));
        a.h(this.uU).setVisibility(0);
        a.a(this.uU, a.h(this.uU));
        a.g(this.uU).setVisibility(8);
        a.i(this.uU).setVisibility(8);
        a.j(this.uU).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.wifisdk.ui.view.a.4
 * JD-Core Version:    0.7.0.1
 */