package com.wifisdk.ui.view;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import wf7.fq;
import wf7.hk;

class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public void run()
  {
    if (a.f(this.uU) != a.g(this.uU))
    {
      fq.H(true);
      hk.az(500622);
      a.g(this.uU).setVisibility(0);
      a.h(this.uU).setVisibility(8);
      a.i(this.uU).setVisibility(8);
      a.j(this.uU).setVisibility(8);
      a.a(this.uU, a.g(this.uU));
    }
    a.k(this.uU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.wifisdk.ui.view.a.3
 * JD-Core Version:    0.7.0.1
 */