package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSUpdateCommentTotalEvent
  extends SimpleBaseEvent
{
  public String mFeedId;
  public int mTotal;
  
  public FSUpdateCommentTotalEvent(String paramString, int paramInt)
  {
    this.mFeedId = paramString;
    this.mTotal = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSUpdateCommentTotalEvent
 * JD-Core Version:    0.7.0.1
 */