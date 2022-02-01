package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import java.util.List;

public class FSGetCommentEvent
  extends SimpleBaseEvent
{
  private boolean isLoadSuccess;
  private List<FeedCloudMeta.StComment> mCommentList;
  private String mErrMsg;
  private String mFeedId;
  private long mRetCode;
  private int mTotal;
  
  public static FSGetCommentEvent build()
  {
    return new FSGetCommentEvent();
  }
  
  public List<FeedCloudMeta.StComment> getCommentList()
  {
    return this.mCommentList;
  }
  
  public String getErrMsg()
  {
    return this.mErrMsg;
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public long getRetCode()
  {
    return this.mRetCode;
  }
  
  public int getTotal()
  {
    return this.mTotal;
  }
  
  public boolean isLoadSuccess()
  {
    return this.isLoadSuccess;
  }
  
  public FSGetCommentEvent setCommentList(List<FeedCloudMeta.StComment> paramList)
  {
    this.mCommentList = paramList;
    return this;
  }
  
  public FSGetCommentEvent setErrMsg(String paramString)
  {
    this.mErrMsg = paramString;
    return this;
  }
  
  public FSGetCommentEvent setFeedId(String paramString)
  {
    this.mFeedId = paramString;
    return this;
  }
  
  public FSGetCommentEvent setLoadSuccess(boolean paramBoolean)
  {
    this.isLoadSuccess = paramBoolean;
    return this;
  }
  
  public FSGetCommentEvent setRetCode(long paramLong)
  {
    this.mRetCode = paramLong;
    return this;
  }
  
  public FSGetCommentEvent setTotal(int paramInt)
  {
    this.mTotal = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSGetCommentEvent
 * JD-Core Version:    0.7.0.1
 */