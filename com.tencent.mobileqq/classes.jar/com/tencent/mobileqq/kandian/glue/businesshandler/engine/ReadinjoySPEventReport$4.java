package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.report.task.TaskManager;
import com.tencent.mobileqq.utils.NetworkUtil;

final class ReadinjoySPEventReport$4
  implements Runnable
{
  public void run()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    if ((i != 2) && (i != 3) && (i != 4))
    {
      if (i == 1) {
        str = "WIFI";
      } else {
        str = "NONE";
      }
    }
    else {
      str = "WWAN";
    }
    String str = TaskManager.a(str);
    TaskManager.a().a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.4
 * JD-Core Version:    0.7.0.1
 */