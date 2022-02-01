package com.tencent.mobileqq.troop.troopnotification;

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
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter != null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.b = true;
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
    }
    TroopNotificationFragment.k(this.this$0);
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.b(this.a);
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
        this.this$0.c = this.a;
      }
      if (!this.this$0.jdField_a_of_type_Boolean)
      {
        TroopReportor.a("Grp_contacts_news", "notice", "enter_recom", 1, 0, new String[0]);
        this.this$0.jdField_a_of_type_Boolean = true;
      }
    }
    else if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter != null)
    {
      localObject = new ArrayList();
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.b((List)localObject);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
      this.this$0.c = ((List)localObject);
    }
    if (!this.this$0.d)
    {
      this.this$0.f();
      this.this$0.d = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.23
 * JD-Core Version:    0.7.0.1
 */