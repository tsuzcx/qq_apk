package com.tencent.mobileqq.troop.logic;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class HomeworkTroopController$1
  implements Runnable
{
  HomeworkTroopController$1(HomeworkTroopController paramHomeworkTroopController) {}
  
  public void run()
  {
    Object localObject = (TroopManager)HomeworkTroopController.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localObject != null) && (HomeworkTroopController.b(this.this$0) != null))
    {
      localObject = ((TroopManager)localObject).g(HomeworkTroopController.c(this.this$0).b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController.1
 * JD-Core Version:    0.7.0.1
 */