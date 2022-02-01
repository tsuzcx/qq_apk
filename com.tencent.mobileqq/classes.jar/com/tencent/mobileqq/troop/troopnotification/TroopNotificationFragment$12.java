package com.tencent.mobileqq.troop.troopnotification;

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
    TroopNotificationFragment.l(this.this$0);
    Object localObject;
    if ((!this.jdField_a_of_type_Boolean) && (this.b) && (this.this$0.g))
    {
      localObject = this.this$0.a.getResources().getString(2131720024);
      QQToast.a(this.this$0.a, 1, (CharSequence)localObject, 0).b(this.this$0.a());
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    if (this.this$0.b != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        this.this$0.b.clear();
        localObject = this.this$0;
        ((TroopNotificationFragment)localObject).b = TroopNotificationFragment.a(((TroopNotificationFragment)localObject).b, this.jdField_a_of_type_JavaUtilList);
      }
    }
    GroupSystemMsgController.a().b(TroopNotificationFragment.a(this.this$0), 0);
    if (TroopNotificationFragment.a(this.this$0) != null)
    {
      TroopNotificationFragment.a(this.this$0).a();
      TroopNotificationFragment.a(this.this$0).a(this.this$0.b);
      TroopNotificationFragment.a(this.this$0).notifyDataSetChanged();
      localObject = (IMessageHandler)TroopNotificationFragment.a(this.this$0).getRuntimeService(IMessageHandler.class, "");
      if (localObject != null) {
        ((IMessageHandler)localObject).sendGroupSystemMsgReadedReportInner(true);
      }
      if (TroopNotificationFragment.a(this.this$0).getVisibility() == 8) {
        ReportController.b(TroopNotificationFragment.a(this.this$0), "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotificationFragment.a(this.this$0).setVisibility(0);
    }
    else
    {
      TroopNotificationFragment.a(this.this$0).setVisibility(8);
    }
    TroopNotificationFragment.j(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.12
 * JD-Core Version:    0.7.0.1
 */