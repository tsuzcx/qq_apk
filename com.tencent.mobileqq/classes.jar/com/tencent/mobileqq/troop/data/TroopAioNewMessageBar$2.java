package com.tencent.mobileqq.troop.data;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAioNewMessageBar$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    TroopAioNewMessageBar.a(this.a);
    this.a.L.b(this.a.J.getCount() - 1, 2);
    if (this.a.p == TroopAioNewMessageBar.d) {
      ReportController.b(this.a.D, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_newmsgcue", 0, 0, this.a.F.b, "", "", "");
    } else if (this.a.p == TroopAioNewMessageBar.e) {
      ReportController.b(this.a.D, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_backbase", 0, 0, this.a.F.b, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNewMessageBar.2
 * JD-Core Version:    0.7.0.1
 */