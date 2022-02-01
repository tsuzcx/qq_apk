package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.luggage.wxa.su.g;
import com.tencent.luggage.wxa.su.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.util.c;

class d$20
  implements View.OnClickListener
{
  d$20(d paramd) {}
  
  public void onClick(View paramView)
  {
    g localg = h.a(d.h(this.a));
    if (localg != null)
    {
      int i = localg.a(true);
      if (i >= 0)
      {
        String str = localg.b(i);
        localg.b(-1, true);
        if ((str != null) && (!str.isEmpty())) {
          c.b(str);
        }
        Toast.makeText(this.a.b(), "清理完成", 0).show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.20
 * JD-Core Version:    0.7.0.1
 */