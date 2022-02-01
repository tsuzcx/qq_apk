package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;

public class ChannelCoverInfo
  extends Entity
  implements Cloneable
{
  public static final String FILTER_COLOR = "filterColor";
  public static final String TABLE_NAME = "ChannelCoverInfo";
  public static final String TAG = "ChannelCoverInfo";
  public String externalExposureBackgroundUrl = "";
  public int filterColor;
  public boolean hasFilterColor = false;
  @notColumn
  public boolean isCurrent;
  public boolean isExternalExposure = false;
  public boolean isExternalExposurePersist = false;
  public boolean isReport = false;
  @notColumn
  public boolean isSelected = false;
  public long mArticleId = -1L;
  public String mChannelCoverIcon = "";
  public int mChannelCoverId = -1;
  public String mChannelCoverName = "";
  public String mChannelCoverPicUrl = "";
  public String mChannelCoverSpec = "";
  public int mChannelCoverStyle;
  public String mChannelCoverSummary = "";
  public int mChannelId = -1;
  public String mChannelJumpUrl = "";
  public int mChannelType = -1;
  public String mChannelVersion = "0";
  public int mColumnType = -1;
  public int mFollowType = -1;
  public int mFontColor = -1291845632;
  public int mFrameColor = -3355444;
  public String mIconUrl = "";
  public boolean mIsTopic;
  public long mPreUpdateTime = -1L;
  public String mTipsText = "";
  public int mTipsType = -1;
  public long mUpdateTime = 0L;
  @notColumn
  public int position;
  
  public ChannelCoverInfo clone()
  {
    try
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)super.clone();
      return localChannelCoverInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clone error,mes:");
      localStringBuilder.append(localCloneNotSupportedException.toString());
      QLog.e("ChannelCoverInfo", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelCoverInfo{mChannelId=");
    localStringBuilder.append(this.mChannelId);
    localStringBuilder.append(", mChannelCoverId=");
    localStringBuilder.append(this.mChannelCoverId);
    localStringBuilder.append(", mChannelCoverName='");
    localStringBuilder.append(this.mChannelCoverName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mChannelCoverStyle=");
    localStringBuilder.append(this.mChannelCoverStyle);
    localStringBuilder.append(", mChannelCoverSummary='");
    localStringBuilder.append(this.mChannelCoverSummary);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mChannelCoverPicUrl='");
    localStringBuilder.append(this.mChannelCoverPicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mChannelJumpUrl='");
    localStringBuilder.append(this.mChannelJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticleId=");
    localStringBuilder.append(this.mArticleId);
    localStringBuilder.append(", mChannelType=");
    localStringBuilder.append(this.mChannelType);
    localStringBuilder.append(", mChannelCoverSpec='");
    localStringBuilder.append(this.mChannelCoverSpec);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFollowType=");
    localStringBuilder.append(this.mFollowType);
    localStringBuilder.append(", mColumnType=");
    localStringBuilder.append(this.mColumnType);
    localStringBuilder.append(", mTipsType=");
    localStringBuilder.append(this.mTipsType);
    localStringBuilder.append(", mTipsText='");
    localStringBuilder.append(this.mTipsText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPreUpdateTime=");
    localStringBuilder.append(this.mPreUpdateTime);
    localStringBuilder.append(", mUpdateTime=");
    localStringBuilder.append(this.mUpdateTime);
    localStringBuilder.append(", isReport=");
    localStringBuilder.append(this.isReport);
    localStringBuilder.append(", mIconUrl='");
    localStringBuilder.append(this.mIconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFontColor=");
    localStringBuilder.append(this.mFontColor);
    localStringBuilder.append(", mFrameColor=");
    localStringBuilder.append(this.mFrameColor);
    localStringBuilder.append(", isExternalExposure=");
    localStringBuilder.append(this.isExternalExposure);
    localStringBuilder.append(", externalExposureBackgroundUrl='");
    localStringBuilder.append(this.externalExposureBackgroundUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isExternalExposurePersist=");
    localStringBuilder.append(this.isExternalExposurePersist);
    localStringBuilder.append(", hasFilterColor=");
    localStringBuilder.append(this.hasFilterColor);
    localStringBuilder.append(", filterColor=");
    localStringBuilder.append(this.filterColor);
    localStringBuilder.append(", mIsTopic=");
    localStringBuilder.append(this.mIsTopic);
    localStringBuilder.append(", isSelected=");
    localStringBuilder.append(this.isSelected);
    localStringBuilder.append(", mChannelCoverIcon=");
    localStringBuilder.append(this.mChannelCoverIcon);
    localStringBuilder.append(", mChannelVersion=");
    localStringBuilder.append(this.mChannelVersion);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo
 * JD-Core Version:    0.7.0.1
 */