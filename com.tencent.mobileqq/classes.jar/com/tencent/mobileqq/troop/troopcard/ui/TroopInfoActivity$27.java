package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$27
  implements Runnable
{
  TroopInfoActivity$27(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      String str = Long.toString(this.this$0.f.dwGroupClassExt);
      GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a((Context)localObject).d();
      if ((localGroupCatalogBean != null) && (localGroupCatalogBean.c.equals(str)))
      {
        this.this$0.f.troopClass = localGroupCatalogBean.a();
        this.this$0.f.mTroopClassExtText = localGroupCatalogBean.b;
      }
      else
      {
        localObject = GroupCatalogTool.a((Context)localObject).a((Context)localObject, str);
        if (localObject != null)
        {
          this.this$0.f.troopClass = ((GroupCatalogBean)localObject).a();
          this.this$0.f.mTroopClassExtText = ((GroupCatalogBean)localObject).b;
        }
      }
      this.this$0.J.sendEmptyMessage(5);
      this.this$0.J.sendEmptyMessage(6);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.27
 * JD-Core Version:    0.7.0.1
 */