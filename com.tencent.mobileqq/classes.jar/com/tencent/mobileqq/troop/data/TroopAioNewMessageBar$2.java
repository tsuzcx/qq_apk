package com.tencent.mobileqq.troop.data;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 2);
    if (this.a.k == TroopAioNewMessageBar.d) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_newmsgcue", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.k == TroopAioNewMessageBar.e) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_backbase", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNewMessageBar.2
 * JD-Core Version:    0.7.0.1
 */