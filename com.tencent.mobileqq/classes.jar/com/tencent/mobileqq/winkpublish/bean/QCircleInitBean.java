package com.tencent.mobileqq.winkpublish.bean;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCircleInitBean
  implements Serializable
{
  private static final long serialVersionUID = 1521697368712552843L;
  private boolean enableMemoryCache = true;
  private boolean enableSplash = false;
  private boolean isSingleFeed;
  private QCircleInitBean.QCircleActionBean mActionBean;
  private byte[] mBusiInfoDataByteArray;
  private String mCategory;
  public int mDataPosInList;
  private long mEnterTime;
  private ExtraTypeInfo mExtraTypeInfo;
  private byte[] mFeedByteArray;
  private byte[] mFeedListBusiReqByteArray;
  private QCircleReportBean mFromReportBean;
  public String mInviteUin;
  private String mLaunchFrom;
  private String mLaunchId;
  private int mLaunchTo;
  private boolean mOpenPymk = false;
  private byte[] mPoiInfoByteArray;
  private byte[] mPolyLikeByteArray;
  private int mPolymerizationType;
  private int mPymkJumpType;
  private String mPymkTranferData = null;
  protected HashMap<String, String> mSchemeAttrs;
  private byte[] mSimulateDataByteArray;
  private byte[] mTagInfoByteArray;
  private byte[] mUserByteArray;
  public long mVideoCurrentPosition;
  private boolean needShowGoHomeButton;
  
  public QCircleInitBean.QCircleActionBean getActionBean()
  {
    return this.mActionBean;
  }
  
  public byte[] getBusiInfoData()
  {
    return this.mBusiInfoDataByteArray;
  }
  
  public int getDataPosInList()
  {
    return this.mDataPosInList;
  }
  
  public long getEnterTime()
  {
    return this.mEnterTime;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    if (this.mExtraTypeInfo == null) {
      this.mExtraTypeInfo = new ExtraTypeInfo();
    }
    return this.mExtraTypeInfo;
  }
  
  public FeedCloudMeta.StFeed getFeed()
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    try
    {
      localStFeed.mergeFrom(this.mFeedByteArray);
      return localStFeed;
    }
    catch (Exception localException) {}
    return localStFeed;
  }
  
  public byte[] getFeedByteArray()
  {
    return this.mFeedByteArray;
  }
  
  public QQCircleFeedBase.StFeedListBusiReqData getFeedListBusiReq()
  {
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    byte[] arrayOfByte = this.mFeedListBusiReqByteArray;
    if (arrayOfByte != null) {
      try
      {
        localStFeedListBusiReqData.mergeFrom(arrayOfByte);
        return localStFeedListBusiReqData;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    return localStFeedListBusiReqData;
  }
  
  public byte[] getFeedListBusiReqByteArray()
  {
    return this.mFeedListBusiReqByteArray;
  }
  
  public QCircleReportBean getFromReportBean()
  {
    return this.mFromReportBean;
  }
  
  public String getLaunchFrom()
  {
    return this.mLaunchFrom;
  }
  
  public String getLaunchId()
  {
    return this.mLaunchId;
  }
  
  public int getLaunchTo()
  {
    return this.mLaunchTo;
  }
  
  public boolean getOpenPymk()
  {
    return this.mOpenPymk;
  }
  
  public FeedCloudMeta.StPoiInfoV2 getPoiInfo()
  {
    FeedCloudMeta.StPoiInfoV2 localStPoiInfoV2 = new FeedCloudMeta.StPoiInfoV2();
    try
    {
      if (this.mPoiInfoByteArray != null)
      {
        localStPoiInfoV2.mergeFrom(this.mPoiInfoByteArray);
        return localStPoiInfoV2;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleInitBean", 1, localException, new Object[0]);
    }
    return localStPoiInfoV2;
  }
  
  public byte[] getPoiInfoByteArray()
  {
    return this.mPoiInfoByteArray;
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
  
  public int getPolymerizationType()
  {
    return this.mPolymerizationType;
  }
  
  public int getPymkJumpType()
  {
    return this.mPymkJumpType;
  }
  
  public String getPymkTranferData()
  {
    return this.mPymkTranferData;
  }
  
  public HashMap<String, String> getSchemeAttrs()
  {
    return this.mSchemeAttrs;
  }
  
  public QQCircleFeedBase.StSimulateData getSimulateData()
  {
    QQCircleFeedBase.StSimulateData localStSimulateData = new QQCircleFeedBase.StSimulateData();
    try
    {
      localStSimulateData.mergeFrom(this.mSimulateDataByteArray);
      return localStSimulateData;
    }
    catch (Exception localException) {}
    return localStSimulateData;
  }
  
  public byte[] getSimulateDataByteArray()
  {
    return this.mSimulateDataByteArray;
  }
  
  public FeedCloudMeta.StTagInfo getTagInfo()
  {
    FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
    try
    {
      localStTagInfo.mergeFrom(this.mTagInfoByteArray);
      return localStTagInfo;
    }
    catch (Exception localException) {}
    return localStTagInfo;
  }
  
  public byte[] getTagInfoByteArray()
  {
    return this.mTagInfoByteArray;
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
  
  public long getVideoCurrentPosition()
  {
    return this.mVideoCurrentPosition;
  }
  
  public String getmCategory()
  {
    return this.mCategory;
  }
  
  public boolean isEnableMemoryCache()
  {
    return this.enableMemoryCache;
  }
  
  public boolean isEnableSplash()
  {
    return this.enableSplash;
  }
  
  public boolean isNeedShowGoHomeButton()
  {
    return this.needShowGoHomeButton;
  }
  
  public boolean isSingleFeed()
  {
    return this.isSingleFeed;
  }
  
  public void setActionBean(QCircleInitBean.QCircleActionBean paramQCircleActionBean)
  {
    this.mActionBean = paramQCircleActionBean;
  }
  
  public void setBusiInfoData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      this.mBusiInfoDataByteArray = paramArrayOfByte;
    }
  }
  
  public void setDataPosInList(int paramInt)
  {
    this.mDataPosInList = paramInt;
  }
  
  public void setEnableMemoryCache(boolean paramBoolean)
  {
    this.enableMemoryCache = paramBoolean;
  }
  
  public void setEnableSplash(boolean paramBoolean)
  {
    this.enableSplash = paramBoolean;
  }
  
  public void setEnterTime(long paramLong)
  {
    this.mEnterTime = paramLong;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.mFeedByteArray = paramStFeed.toByteArray();
    }
  }
  
  public void setFeedListBusiReqData(QQCircleFeedBase.StFeedListBusiReqData paramStFeedListBusiReqData)
  {
    if (paramStFeedListBusiReqData != null) {
      this.mFeedListBusiReqByteArray = paramStFeedListBusiReqData.toByteArray();
    }
  }
  
  public void setFromReportBean(QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null) {
      this.mFromReportBean = paramQCircleReportBean.clone();
    }
  }
  
  public void setLaunchFrom(String paramString)
  {
    this.mLaunchFrom = paramString;
  }
  
  public void setLaunchId(String paramString)
  {
    this.mLaunchId = paramString;
  }
  
  public void setLaunchTo(int paramInt)
  {
    this.mLaunchTo = paramInt;
  }
  
  public void setNeedShowGoHomeButton(boolean paramBoolean)
  {
    this.needShowGoHomeButton = paramBoolean;
  }
  
  public void setOpenPymk(boolean paramBoolean)
  {
    this.mOpenPymk = paramBoolean;
  }
  
  public void setPoiInfo(FeedCloudMeta.StPoiInfoV2 paramStPoiInfoV2)
  {
    if (paramStPoiInfoV2 != null) {
      this.mPoiInfoByteArray = paramStPoiInfoV2.toByteArray();
    }
  }
  
  public void setPolyLike(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    if (paramStPolyLike != null) {
      this.mPolyLikeByteArray = paramStPolyLike.toByteArray();
    }
  }
  
  public void setPolymerizationType(int paramInt)
  {
    this.mPolymerizationType = paramInt;
  }
  
  public void setPymkJumpType(int paramInt)
  {
    this.mPymkJumpType = paramInt;
  }
  
  public void setPymkTranferData(String paramString)
  {
    this.mPymkTranferData = paramString;
  }
  
  public void setSchemeAttrs(HashMap<String, String> paramHashMap)
  {
    this.mSchemeAttrs = paramHashMap;
  }
  
  public void setSimulateData(QQCircleFeedBase.StSimulateData paramStSimulateData)
  {
    if (paramStSimulateData != null) {
      this.mSimulateDataByteArray = paramStSimulateData.toByteArray();
    }
  }
  
  public void setSingleFeed(boolean paramBoolean)
  {
    this.isSingleFeed = paramBoolean;
  }
  
  public void setSourceType(int paramInt)
  {
    if (this.mExtraTypeInfo == null) {
      this.mExtraTypeInfo = new ExtraTypeInfo();
    }
    this.mExtraTypeInfo.sourceType = paramInt;
  }
  
  public void setTagInfo(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (paramStTagInfo != null) {
      this.mTagInfoByteArray = paramStTagInfo.toByteArray();
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
  
  public void setVideoCurrentPosition(long paramLong)
  {
    this.mVideoCurrentPosition = paramLong;
  }
  
  public void setmCategory(String paramString)
  {
    this.mCategory = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.bean.QCircleInitBean
 * JD-Core Version:    0.7.0.1
 */