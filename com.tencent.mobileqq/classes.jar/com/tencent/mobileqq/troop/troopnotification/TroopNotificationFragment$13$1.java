package com.tencent.mobileqq.troop.troopnotification;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;
import com.tencent.mobileqq.troop.widget.SlideAndOverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.util.List;
import mqq.app.AppRuntime;

class TroopNotificationFragment$13$1
  implements Runnable
{
  TroopNotificationFragment$13$1(TroopNotificationFragment.13 param13) {}
  
  public void run()
  {
    if ((this.a.this$0.b == null) || (this.a.this$0.b.isEmpty()))
    {
      TroopNotificationFragment.a(this.a.this$0).a();
      TroopNotificationFragment.a(this.a.this$0).setVisibility(8);
      this.a.this$0.a.setVisibility(0);
      this.a.this$0.a(0);
    }
    if ((this.a.this$0.b != null) && (this.a.this$0.b.size() > 0))
    {
      if (TroopNotificationFragment.a(this.a.this$0).getVisibility() == 8) {
        ReportController.b(TroopNotificationFragment.a(this.a.this$0), "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotificationFragment.a(this.a.this$0).setVisibility(0);
      if (!(this.a.this$0.b.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationFragment", 2, "initListData error");
        }
        ITroopSysMsgDependApiService localITroopSysMsgDependApiService = (ITroopSysMsgDependApiService)TroopNotificationFragment.a(this.a.this$0).getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localITroopSysMsgDependApiService != null) {
          localITroopSysMsgDependApiService.clearGroupSystemMsgHistory();
        }
        TroopNotificationFragment.a(this.a.this$0).a(null);
      }
    }
    else
    {
      TroopNotificationFragment.a(this.a.this$0).setVisibility(8);
    }
    TroopNotificationFragment.a(this.a.this$0).a();
    TroopNotificationFragment.a(this.a.this$0).a(this.a.this$0.b);
    TroopNotificationFragment.a(this.a.this$0).notifyDataSetChanged();
    TroopNotificationFragment.j(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.13.1
 * JD-Core Version:    0.7.0.1
 */