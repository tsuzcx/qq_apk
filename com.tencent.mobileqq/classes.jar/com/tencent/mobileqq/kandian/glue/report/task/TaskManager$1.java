package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class TaskManager$1
  implements INetInfoHandler
{
  TaskManager$1(TaskManager paramTaskManager) {}
  
  public void onNetMobile2None()
  {
    this.a.b(TaskManager.a("NONE"));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.b(TaskManager.a("WIFI"));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.a.b(TaskManager.a("WWAN"));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.b(TaskManager.a("WIFI"));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.b(TaskManager.a("WWAN"));
  }
  
  public void onNetWifi2None()
  {
    this.a.b(TaskManager.a("NONE"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.1
 * JD-Core Version:    0.7.0.1
 */