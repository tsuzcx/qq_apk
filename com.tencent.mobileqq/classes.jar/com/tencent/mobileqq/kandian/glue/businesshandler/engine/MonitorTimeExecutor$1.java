package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class MonitorTimeExecutor$1
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[rejectedExecution] r: ");
    localStringBuilder.append(paramRunnable);
    localStringBuilder.append(" executor: ");
    localStringBuilder.append(paramThreadPoolExecutor);
    QLog.e("MonitorTimeExecutor", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor.1
 * JD-Core Version:    0.7.0.1
 */