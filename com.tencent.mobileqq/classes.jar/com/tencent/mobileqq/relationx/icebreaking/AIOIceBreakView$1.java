package com.tencent.mobileqq.relationx.icebreaking;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOIceBreakView$1
  implements View.OnClickListener
{
  AIOIceBreakView$1(AIOIceBreakView paramAIOIceBreakView) {}
  
  public void onClick(View paramView)
  {
    AIOIceBreakView.a(this.a).j(24);
    paramView.postDelayed(new AIOIceBreakView.1.1(this), 500L);
    if (UinTypeUtil.a(AIOIceBreakView.a(this.a).a.a) != 1044)
    {
      int i;
      if (AIOIceBreakView.a(this.a).a.a == 0) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(AIOIceBreakView.a(this.a), "CliOper", "", "", "0X800A4CC", "0X800A4CC", i, 0, "", "", "", "");
      ReportController.b(AIOIceBreakView.a(this.a), "CliOper", "", "", "0X800A4CD", "0X800A4CD", i, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.1
 * JD-Core Version:    0.7.0.1
 */