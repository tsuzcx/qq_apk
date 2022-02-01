package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter;
import com.tencent.mobileqq.utils.TroopReportor;
import java.util.ArrayList;
import java.util.List;

class TroopNotificationFragment$23
  implements Runnable
{
  TroopNotificationFragment$23(TroopNotificationFragment paramTroopNotificationFragment, List paramList) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.j = true;
      this.this$0.a.notifyDataSetChanged();
    }
    TroopNotificationFragment.q(this.this$0);
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (this.this$0.a != null)
      {
        this.this$0.a.b(this.a);
        this.this$0.a.notifyDataSetChanged();
        this.this$0.f = this.a;
      }
      if (!this.this$0.h)
      {
        TroopReportor.a("Grp_contacts_news", "notice", "enter_recom", 1, 0, new String[0]);
        this.this$0.h = true;
      }
    }
    else if (this.this$0.a != null)
    {
      localObject = new ArrayList();
      this.this$0.a.b((List)localObject);
      this.this$0.a.notifyDataSetChanged();
      this.this$0.f = ((List)localObject);
    }
    if (!this.this$0.G)
    {
      this.this$0.g();
      this.this$0.G = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.23
 * JD-Core Version:    0.7.0.1
 */