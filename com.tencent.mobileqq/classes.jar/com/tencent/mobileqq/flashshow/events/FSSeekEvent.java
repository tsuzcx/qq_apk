package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSSeekEvent
  extends SimpleBaseEvent
{
  public String mFeedId;
  public boolean mIsOnSeek;
  
  public FSSeekEvent(String paramString, boolean paramBoolean)
  {
    this.mIsOnSeek = paramBoolean;
    this.mFeedId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSSeekEvent
 * JD-Core Version:    0.7.0.1
 */