package com.tencent.mobileqq.troop.logic;

import bghh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class HomeworkTroopController$1
  implements Runnable
{
  public HomeworkTroopController$1(bghh parambghh) {}
  
  public void run()
  {
    Object localObject = (TroopManager)bghh.a(this.this$0).getManager(52);
    if ((localObject != null) && (bghh.a(this.this$0) != null))
    {
      localObject = ((TroopManager)localObject).c(bghh.b(this.this$0).a);
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