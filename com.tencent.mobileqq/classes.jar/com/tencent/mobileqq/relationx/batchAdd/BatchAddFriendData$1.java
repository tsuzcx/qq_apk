package com.tencent.mobileqq.relationx.batchAdd;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopAddFrd.Scene;
import mqq.app.AppRuntime;

final class BatchAddFriendData$1
  implements Runnable
{
  BatchAddFriendData$1(int paramInt, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    String str1 = Scene.b(false, this.a);
    Object localObject2 = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = ((TroopManager)localObject2).f(this.c);
    if (localObject1 != null)
    {
      if (this.a == 1)
      {
        ((TroopInfo)localObject1).wClickBAFTipCount += 1;
        ((TroopManager)localObject2).b((TroopInfo)localObject1);
        localObject2 = this.b;
        String str2 = this.c;
        if (((TroopInfo)localObject1).wInsertBAFTipCount == 1) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, str2, (String)localObject1, "", "");
        return;
      }
      ReportController.b(this.b, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, this.c, "0", Integer.toString(((TroopInfo)localObject1).wMemberNum), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData.1
 * JD-Core Version:    0.7.0.1
 */