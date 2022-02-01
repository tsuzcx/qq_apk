package com.tencent.mobileqq.fts.operator;

import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class FTSTroopOperator$1$1
  implements Runnable
{
  FTSTroopOperator$1$1(FTSTroopOperator.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "getTroopsMemberList after 24 h");
    }
    ((ITroopManagerService)this.a.this$0.a.getRuntimeService(ITroopManagerService.class, "")).getTroopsMemberList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSTroopOperator.1.1
 * JD-Core Version:    0.7.0.1
 */