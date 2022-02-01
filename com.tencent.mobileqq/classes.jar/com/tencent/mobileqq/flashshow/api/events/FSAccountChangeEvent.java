package com.tencent.mobileqq.flashshow.api.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSAccountChangeEvent
  extends SimpleBaseEvent
{
  private final boolean mIsSwitchAccount;
  
  public FSAccountChangeEvent(boolean paramBoolean)
  {
    this.mIsSwitchAccount = paramBoolean;
  }
  
  public boolean hasSwitchAccount()
  {
    return this.mIsSwitchAccount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.events.FSAccountChangeEvent
 * JD-Core Version:    0.7.0.1
 */