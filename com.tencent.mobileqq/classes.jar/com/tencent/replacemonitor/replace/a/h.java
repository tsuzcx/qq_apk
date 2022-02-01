package com.tencent.replacemonitor.replace.a;

import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.tmassistantbase.util.ab;

public class h
  implements i
{
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    ab.c("WashMonitor", "ModifyTimeMonitorAction>>" + paramMonitorTask.appName + "开始通过ModifyTime比较检测洗包,暂时不支持，直接放过 step = " + paramMonitorStep);
    return new MonitorResult(paramMonitorStep, 0, "暂不执行ModifyTimeMonitorAction", a());
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_MODIFY_TIME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.h
 * JD-Core Version:    0.7.0.1
 */