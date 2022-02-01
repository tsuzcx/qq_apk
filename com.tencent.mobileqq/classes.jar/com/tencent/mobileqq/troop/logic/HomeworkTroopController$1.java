package com.tencent.mobileqq.troop.logic;

import bfxr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class HomeworkTroopController$1
  implements Runnable
{
  public HomeworkTroopController$1(bfxr parambfxr) {}
  
  public void run()
  {
    Object localObject = (TroopManager)bfxr.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localObject != null) && (bfxr.a(this.this$0) != null))
    {
      localObject = ((TroopManager)localObject).c(bfxr.b(this.this$0).curFriendUin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HomeworkTroopController", 2, "updateHomeworkListEntry-handleHomeworkListIcon");
        }
        this.this$0.c(((TroopInfo)localObject).isHomeworkTroop());
        this.this$0.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController.1
 * JD-Core Version:    0.7.0.1
 */