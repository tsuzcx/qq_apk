package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$35
  implements View.OnClickListener
{
  d$35(d paramd) {}
  
  public void onClick(View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)d.d(this.a).findViewById(2131431214);
    if (localLinearLayout.getVisibility() == 8)
    {
      localLinearLayout.setVisibility(0);
      ((Button)paramView).setText("隐藏高级设置");
    }
    else
    {
      localLinearLayout.setVisibility(8);
      ((Button)paramView).setText("高级设置");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.35
 * JD-Core Version:    0.7.0.1
 */