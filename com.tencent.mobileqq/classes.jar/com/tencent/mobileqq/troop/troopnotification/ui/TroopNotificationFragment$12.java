package com.tencent.mobileqq.troop.troopnotification.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class TroopNotificationFragment$12
  implements Runnable
{
  TroopNotificationFragment$12(TroopNotificationFragment paramTroopNotificationFragment, boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  public void run()
  {
    TroopNotificationFragment.s(this.this$0);
    Object localObject;
    if ((!this.a) && (this.b) && (this.this$0.M))
    {
      localObject = this.this$0.g.getResources().getString(2131917629);
      QQToast.makeText(this.this$0.g, 1, (CharSequence)localObject, 0).show(this.this$0.b());
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    if (this.this$0.e != null)
    {
      localObject = this.c;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        this.this$0.e.clear();
        localObject = this.this$0;
        ((TroopNotificationFragment)localObject).e = TroopNotificationFragment.a(((TroopNotificationFragment)localObject).e, this.c);
      }
    }
    GroupSystemMsgController.a().b(TroopNotificationFragment.r(this.this$0), 0);
    if (TroopNotificationFragment.k(this.this$0) != null)
    {
      TroopNotificationFragment.k(this.this$0).b();
      TroopNotificationFragment.k(this.this$0).a(this.this$0.e);
      TroopNotificationFragment.k(this.this$0).notifyDataSetChanged();
      localObject = (IMessageHandler)TroopNotificationFragment.f(this.this$0).getRuntimeService(IMessageHandler.class, "");
      if (localObject != null) {
        ((IMessageHandler)localObject).sendGroupSystemMsgReadedReportInner(true);
      }
      if (TroopNotificationFragment.t(this.this$0).getVisibility() == 8) {
        ReportController.b(TroopNotificationFragment.f(this.this$0), "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotificationFragment.t(this.this$0).setVisibility(0);
    }
    else
    {
      TroopNotificationFragment.t(this.this$0).setVisibility(8);
    }
    TroopNotificationFragment.p(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.12
 * JD-Core Version:    0.7.0.1
 */