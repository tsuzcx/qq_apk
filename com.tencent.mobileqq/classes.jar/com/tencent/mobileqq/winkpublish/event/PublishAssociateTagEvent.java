package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class PublishAssociateTagEvent
  extends SimpleBaseEvent
{
  public String tag;
  
  public PublishAssociateTagEvent(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.PublishAssociateTagEvent
 * JD-Core Version:    0.7.0.1
 */