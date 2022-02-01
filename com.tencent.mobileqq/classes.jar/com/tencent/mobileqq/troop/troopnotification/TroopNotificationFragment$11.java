package com.tencent.mobileqq.troop.troopnotification;

import android.app.Activity;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class TroopNotificationFragment$11
  implements Runnable
{
  TroopNotificationFragment$11(TroopNotificationFragment paramTroopNotificationFragment, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    TroopNotificationFragment.k(this.this$0);
    if (((Activity)this.this$0.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      return;
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter != null) && (this.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopNotificationFragment", 2, "onGetSystemMsgFin.success");
      }
      if (TroopNotificationFragment.a(this.this$0) == null) {
        return;
      }
      ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)TroopNotificationFragment.a(this.this$0).getRuntimeService(ITroopNotificationService.class, "");
      if (localITroopNotificationService == null) {
        return;
      }
      List localList1 = localITroopNotificationService.getDataListFromClassificationCache(2);
      List localList2 = localITroopNotificationService.getDataListFromClassificationCache(1);
      Object localObject = localITroopNotificationService.getDataListFromClassificationCache(0);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationFragment", 2, new Object[] { "dataListWithOutExit Size =", Integer.valueOf(((List)localObject).size()), "exitDataList Size =", Integer.valueOf(localList1.size()), "undealDataList Size=", Integer.valueOf(localList2.size()) });
        }
        if ((this.this$0.b == 1) && (localList2 != null) && (localList2.size() > 0)) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(localList2);
        } else if ((this.this$0.b == 2) && (localList1 != null) && (localList1.size() > 0)) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(localList1);
        } else if ((this.this$0.b == 0) && (localObject != null) && (((List)localObject).size() > 0)) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a((List)localObject);
        }
      }
      if (this.this$0.b != 0) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a = 0;
      } else {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a = GroupSystemMsgController.a().a(TroopNotificationFragment.a(this.this$0));
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
      localObject = (IRecommendTroopService)TroopNotificationFragment.a(this.this$0).getRuntimeService(IRecommendTroopService.class, "");
      if (localObject != null) {
        ((IRecommendTroopService)localObject).setUnreadNum(GroupSystemMsgController.a().a(TroopNotificationFragment.a(this.this$0)));
      }
      GroupSystemMsgController.a().a(TroopNotificationFragment.a(this.this$0), 0);
      this.this$0.b(localList2);
      this.this$0.c(localList1);
      if (localITroopNotificationService.hasUnreadUndealMsg()) {
        this.this$0.a(true, 1);
      } else {
        this.this$0.a(false, 1);
      }
      TroopNotificationFragment.j(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.11
 * JD-Core Version:    0.7.0.1
 */