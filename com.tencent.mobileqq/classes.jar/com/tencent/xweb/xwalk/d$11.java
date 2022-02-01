package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$11
  implements View.OnClickListener
{
  d$11(d paramd, LinearLayout paramLinearLayout) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getVisibility() == 8)
    {
      this.a.setVisibility(0);
      ((Button)paramView).setText("隐藏插件设置");
    }
    else
    {
      this.a.setVisibility(8);
      ((Button)paramView).setText("插件设置");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.11
 * JD-Core Version:    0.7.0.1
 */