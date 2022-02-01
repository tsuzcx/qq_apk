package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TaskOfflineUtils$TaskAsyncBack
  implements AsyncBack
{
  private final TaskOfflineUtils.OfflineCallBack a;
  private final String b;
  private final int c;
  
  public TaskOfflineUtils$TaskAsyncBack(String paramString, int paramInt, TaskOfflineUtils.OfflineCallBack paramOfflineCallBack)
  {
    this.b = paramString;
    this.a = paramOfflineCallBack;
    this.c = paramInt;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new TaskOfflineUtils.TaskAsyncBack.1(this, paramString, paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.TaskAsyncBack
 * JD-Core Version:    0.7.0.1
 */