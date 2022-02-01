package com.tencent.mobileqq.writetogetherui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.Template;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HorizontalAdapter$1
  implements View.OnClickListener
{
  HorizontalAdapter$1(HorizontalAdapter paramHorizontalAdapter, HorizontalAdapter.HorizontalViewHolder paramHorizontalViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.getAdapterPosition();
    if (i != HorizontalAdapter.a(this.b))
    {
      if (this.b.a())
      {
        this.b.a(paramView, i);
      }
      else
      {
        HorizontalAdapter.c(this.b).a(HorizontalAdapter.b(this.b)[i].c);
        HorizontalAdapter.a(this.b, i);
        this.b.notifyDataSetChanged();
      }
      ReportController.b(null, "dc00898", "", "", "0X800B355", "0X800B355", HorizontalAdapter.b(this.b)[i].a, 0, String.valueOf(HorizontalAdapter.d(this.b)), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.HorizontalAdapter.1
 * JD-Core Version:    0.7.0.1
 */