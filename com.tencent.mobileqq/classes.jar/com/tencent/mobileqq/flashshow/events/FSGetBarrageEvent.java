package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import java.util.List;

public class FSGetBarrageEvent
  extends SimpleBaseEvent
{
  private boolean isLoadMore;
  private boolean isLoadSuccess;
  private List<FeedCloudMeta.StComment> mCommentList;
  private String mErrMsg;
  private String mFeedId;
  private long mRetCode;
  private int mStartIndex;
  private int mTotal;
  
  public static FSGetBarrageEvent build()
  {
    return new FSGetBarrageEvent();
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
  
  public int getStartIndex()
  {
    return this.mStartIndex;
  }
  
  public int getTotal()
  {
    return this.mTotal;
  }
  
  public boolean isLoadMore()
  {
    return this.isLoadMore;
  }
  
  public boolean isLoadSuccess()
  {
    return this.isLoadSuccess;
  }
  
  public FSGetBarrageEvent setCommentList(List<FeedCloudMeta.StComment> paramList)
  {
    this.mCommentList = paramList;
    return this;
  }
  
  public FSGetBarrageEvent setErrMsg(String paramString)
  {
    this.mErrMsg = paramString;
    return this;
  }
  
  public FSGetBarrageEvent setFeedId(String paramString)
  {
    this.mFeedId = paramString;
    return this;
  }
  
  public FSGetBarrageEvent setLoadMore(boolean paramBoolean)
  {
    this.isLoadMore = paramBoolean;
    return this;
  }
  
  public FSGetBarrageEvent setLoadSuccess(boolean paramBoolean)
  {
    this.isLoadSuccess = paramBoolean;
    return this;
  }
  
  public FSGetBarrageEvent setRetCode(long paramLong)
  {
    this.mRetCode = paramLong;
    return this;
  }
  
  public FSGetBarrageEvent setStartIndex(int paramInt)
  {
    this.mStartIndex = paramInt;
    return this;
  }
  
  public FSGetBarrageEvent setTotal(int paramInt)
  {
    this.mTotal = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSGetBarrageEvent
 * JD-Core Version:    0.7.0.1
 */