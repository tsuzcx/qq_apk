package com.tencent.mobileqq.troop.troopnotification.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

class TroopRequestActivity$4
  implements Runnable
{
  TroopRequestActivity$4(TroopRequestActivity paramTroopRequestActivity, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(BaseApplication.getContext()).a(this.this$0, Long.toString(this.a.dwGroupClassExt));
    if (localGroupCatalogBean != null)
    {
      this.this$0.j = localGroupCatalogBean.a();
      ThreadManager.getUIHandler().post(new TroopRequestActivity.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.4
 * JD-Core Version:    0.7.0.1
 */