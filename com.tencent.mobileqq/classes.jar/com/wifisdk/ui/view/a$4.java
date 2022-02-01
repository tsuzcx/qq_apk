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
    int i = this.uX;
    int j = 1;
    int k;
    int m;
    int n;
    int i1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            j = RProxy.string.tmsdk_wifi_no_wifi_title;
            k = RProxy.string.tmsdk_wifi_no_wifi_des;
            if (hl.fp()) {
              i = RProxy.string.tmsdk_wifi_see_more_wifi;
            } else {
              i = RProxy.string.tmsdk_wifi_no_wifi_btn;
            }
            m = RProxy.drawable.tmsdk_wifi_icon_no_wifi;
            n = i;
            i1 = 500763;
            int i2 = 3;
            i = j;
            j = i2;
          }
          else
          {
            i = 0;
            k = 0;
            m = 0;
            n = 0;
            i1 = 0;
          }
        }
        else
        {
          i = 0;
          j = 2;
          k = 0;
          m = 0;
          n = 0;
          i1 = 500761;
        }
      }
      else
      {
        i = 0;
        j = 2;
        k = 0;
        m = 0;
        n = 0;
        i1 = 500762;
      }
    }
    else
    {
      i = 0;
      j = 2;
      k = 0;
      m = 0;
      n = 0;
      i1 = 500760;
    }
    a locala;
    if (j == 3)
    {
      a.i(this.uU).setVisibility(0);
      locala = this.uU;
      a.a(locala, a.i(locala));
      a.m(this.uU).setImageDrawable(a.l(this.uU).getResources().getDrawable(m));
      a.n(this.uU).setText(i);
      a.o(this.uU).setText(k);
      a.p(this.uU).setText(n);
      a.p(this.uU).setOnClickListener(new a.4.1(this));
      a.h(this.uU).setVisibility(8);
      a.g(this.uU).setVisibility(8);
      a.j(this.uU).setVisibility(8);
    }
    else if (j == 2)
    {
      if (a.j(this.uU).getVisibility() != 0)
      {
        a.j(this.uU).setVisibility(0);
        a.j(this.uU).fR();
        a.h(this.uU).setVisibility(8);
        a.g(this.uU).setVisibility(8);
        a.i(this.uU).setVisibility(8);
      }
      locala = this.uU;
      a.a(locala, a.j(locala));
    }
    else
    {
      a.h(this.uU).setText(a.l(this.uU).getApplicationContext().getResources().getString(RProxy.string.tmsdk_wifi_updating_list));
      a.h(this.uU).setVisibility(0);
      locala = this.uU;
      a.a(locala, a.h(locala));
      a.g(this.uU).setVisibility(8);
      a.i(this.uU).setVisibility(8);
      a.j(this.uU).setVisibility(8);
    }
    if (i1 > 0) {
      hk.az(i1);
    }
    a.a(this.uU, this.uX);
    if (a.q(this.uU).getVisibility() == 0) {
      a.q(this.uU).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.wifisdk.ui.view.a.4
 * JD-Core Version:    0.7.0.1
 */