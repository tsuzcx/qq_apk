package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class PublishKeyboardEvent
  extends SimpleBaseEvent
{
  public boolean showKeyboard;
  
  public PublishKeyboardEvent(boolean paramBoolean)
  {
    this.showKeyboard = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.PublishKeyboardEvent
 * JD-Core Version:    0.7.0.1
 */