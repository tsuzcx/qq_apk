package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSPublishBoxStatusEvent
  extends SimpleBaseEvent
{
  public static final int STATUS_FAIL = 3;
  public static final int STATUS_NONE = 0;
  public static final int STATUS_RUNNING = 1;
  public static final int STATUS_SUCCESS = 2;
  public String mCoverUrl;
  public String mFeedId;
  public int mProgress;
  public int mStatus;
  
  public FSPublishBoxStatusEvent(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mStatus = paramInt1;
    this.mProgress = paramInt2;
    this.mCoverUrl = paramString1;
    this.mFeedId = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSPublishBoxStatusEvent
 * JD-Core Version:    0.7.0.1
 */