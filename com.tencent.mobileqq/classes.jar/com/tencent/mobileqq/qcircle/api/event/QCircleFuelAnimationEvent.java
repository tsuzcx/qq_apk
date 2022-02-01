package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFuelAnimationEvent
  extends SimpleBaseEvent
{
  private boolean isPublishTask = false;
  
  public QCircleFuelAnimationEvent() {}
  
  public QCircleFuelAnimationEvent(boolean paramBoolean)
  {
    this.isPublishTask = paramBoolean;
  }
  
  public boolean getPublishTask()
  {
    return this.isPublishTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent
 * JD-Core Version:    0.7.0.1
 */