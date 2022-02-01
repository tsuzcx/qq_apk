package com.tencent.mobileqq.troop.troopnotification.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.qphone.base.util.BaseApplication;

class TroopRequestActivity$12$1
  implements Runnable
{
  TroopRequestActivity$12$1(TroopRequestActivity.12 param12, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(BaseApplication.getContext()).a(this.b.a, Long.toString(this.a.dwGroupClassExt));
    if (localGroupCatalogBean != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localGroupCatalogBean.a();
      this.b.a.ax.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.12.1
 * JD-Core Version:    0.7.0.1
 */