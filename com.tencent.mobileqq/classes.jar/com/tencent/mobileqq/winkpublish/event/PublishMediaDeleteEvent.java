package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class PublishMediaDeleteEvent
  extends SimpleBaseEvent
{
  public int position;
  
  public PublishMediaDeleteEvent(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.PublishMediaDeleteEvent
 * JD-Core Version:    0.7.0.1
 */