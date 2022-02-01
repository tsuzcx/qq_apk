package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.v;

class d$36
  implements View.OnClickListener
{
  d$36(d paramd) {}
  
  public void onClick(View paramView)
  {
    boolean bool = v.a().h() ^ true;
    v.a().g(bool);
    if (bool)
    {
      d.j(this.a);
      this.a.e.setVisibility(0);
    }
    else if (this.a.e != null)
    {
      this.a.e.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.36
 * JD-Core Version:    0.7.0.1
 */