package com.tencent.mobileqq.flashshow.api.bean;

public class FSLayerPageInitBean
  extends FSInitBean
{
  public static final int SOURCE_TYPE_MESSAGE_LIST = 1002;
  public static final int SOURCE_TYPE_PERSONAL = 1;
  public static final int SOURCE_TYPE_SHARE = 2;
  private long mCreateTime;
  private String mFeedId;
  private int mFeedPosition;
  private String mPersonFeedType;
  private int mSourceType;
  private String mUserId;
  
  public FSLayerPageInitBean(FSReportBean paramFSReportBean)
  {
    super(paramFSReportBean);
  }
  
  public long getCreateTime()
  {
    return this.mCreateTime;
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public int getFeedPosition()
  {
    return this.mFeedPosition;
  }
  
  public String getPersonFeedType()
  {
    return this.mPersonFeedType;
  }
  
  public int getSourceType()
  {
    return this.mSourceType;
  }
  
  public String getUserId()
  {
    return this.mUserId;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.mCreateTime = paramLong;
  }
  
  public void setFeedId(String paramString)
  {
    this.mFeedId = paramString;
  }
  
  public void setFeedPosition(int paramInt)
  {
    this.mFeedPosition = paramInt;
  }
  
  public void setPersonFeedType(String paramString)
  {
    this.mPersonFeedType = paramString;
  }
  
  public void setSourceType(int paramInt)
  {
    this.mSourceType = paramInt;
  }
  
  public void setUserId(String paramString)
  {
    this.mUserId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean
 * JD-Core Version:    0.7.0.1
 */