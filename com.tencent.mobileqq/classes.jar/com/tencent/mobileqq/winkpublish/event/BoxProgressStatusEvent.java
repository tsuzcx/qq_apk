package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class BoxProgressStatusEvent
  extends SimpleBaseEvent
{
  public static final int CANCEL_UPLOAD = 1;
  public static final int SHOW_CLOSE_BT = 0;
  protected int type;
  
  public BoxProgressStatusEvent(int paramInt)
  {
    this.type = paramInt;
  }
  
  public int getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.BoxProgressStatusEvent
 * JD-Core Version:    0.7.0.1
 */