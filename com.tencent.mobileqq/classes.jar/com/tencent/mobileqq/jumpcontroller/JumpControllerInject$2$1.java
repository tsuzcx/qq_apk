package com.tencent.mobileqq.jumpcontroller;

import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.startup.step.CheckPermission.SDCardPermissionCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class JumpControllerInject$2$1
  implements CheckPermission.SDCardPermissionCallback
{
  JumpControllerInject$2$1(JumpControllerInject.2 param2) {}
  
  public void a()
  {
    QLog.i("JumpControllerInject", 1, "system share.doShare show self dialog grant");
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftGrant", true, 0L, 0L, localHashMap, "");
  }
  
  public void b()
  {
    QLog.i("JumpControllerInject", 1, "system share.doShare show self dialog denied");
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShareSelftDeny", true, 0L, 0L, localHashMap, "");
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jumpcontroller.JumpControllerInject.2.1
 * JD-Core Version:    0.7.0.1
 */