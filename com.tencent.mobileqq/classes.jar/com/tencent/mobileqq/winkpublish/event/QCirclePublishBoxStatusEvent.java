package com.tencent.mobileqq.winkpublish.event;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePublishBoxStatusEvent
  extends SimpleBaseEvent
{
  public boolean hasFinishTask;
  public boolean hasOfflineWaitingTask;
  public boolean hasRunningTask;
  public int taskCount;
  
  public QCirclePublishBoxStatusEvent(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.taskCount = paramInt;
    this.hasRunningTask = paramBoolean1;
    this.hasOfflineWaitingTask = paramBoolean2;
  }
  
  public QCirclePublishBoxStatusEvent(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.taskCount = paramInt;
    this.hasRunningTask = paramBoolean1;
    this.hasOfflineWaitingTask = paramBoolean2;
    this.hasFinishTask = paramBoolean3;
  }
  
  public QCirclePublishBoxStatusEvent(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.taskCount = paramBundle.getInt("taskCount", 0);
      this.hasRunningTask = paramBundle.getBoolean("hasRunningTask", false);
      this.hasOfflineWaitingTask = paramBundle.getBoolean("hasOfflineWaitingTask", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent
 * JD-Core Version:    0.7.0.1
 */