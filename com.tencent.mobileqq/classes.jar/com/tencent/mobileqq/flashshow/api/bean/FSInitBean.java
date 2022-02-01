package com.tencent.mobileqq.flashshow.api.bean;

import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import qqcircle.QQCircleFeedBase.StPolyLike;

public abstract class FSInitBean
  implements Serializable
{
  private static final long serialVersionUID = 1521697368712552843L;
  private byte[] mBusiInfoDataByteArray;
  private final FSReportBean mFromReportBean;
  private String mGlobalViewModelKey;
  private byte[] mPolyLikeByteArray;
  private byte[] mUserByteArray;
  
  public FSInitBean(FSReportBean paramFSReportBean)
  {
    this.mFromReportBean = paramFSReportBean;
  }
  
  public byte[] getBusiInfoData()
  {
    return this.mBusiInfoDataByteArray;
  }
  
  public FSReportBean getFromReportBean()
  {
    return this.mFromReportBean;
  }
  
  public String getGlobalViewModelKey()
  {
    return this.mGlobalViewModelKey;
  }
  
  public QQCircleFeedBase.StPolyLike getPolyLike()
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = new QQCircleFeedBase.StPolyLike();
    try
    {
      localStPolyLike.mergeFrom(this.mPolyLikeByteArray);
      return localStPolyLike;
    }
    catch (Exception localException) {}
    return localStPolyLike;
  }
  
  public String getUin()
  {
    FeedCloudMeta.StUser localStUser = getUser();
    if (localStUser != null) {
      return localStUser.id.get();
    }
    return null;
  }
  
  public FeedCloudMeta.StUser getUser()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    try
    {
      localStUser.mergeFrom(this.mUserByteArray);
      return localStUser;
    }
    catch (Exception localException) {}
    return localStUser;
  }
  
  public void setBusiInfoData(byte[] paramArrayOfByte)
  {
    this.mBusiInfoDataByteArray = paramArrayOfByte;
  }
  
  public void setGlobalViewModelKey(String paramString)
  {
    this.mGlobalViewModelKey = paramString;
  }
  
  public void setPolyLike(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    if (paramStPolyLike != null) {
      this.mPolyLikeByteArray = paramStPolyLike.toByteArray();
    }
  }
  
  public void setUin(String paramString)
  {
    if (paramString != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramString);
      this.mUserByteArray = localStUser.toByteArray();
    }
  }
  
  public void setUser(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null) {
      this.mUserByteArray = paramStUser.toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.bean.FSInitBean
 * JD-Core Version:    0.7.0.1
 */