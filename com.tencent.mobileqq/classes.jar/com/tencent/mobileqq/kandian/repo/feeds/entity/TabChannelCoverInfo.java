package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.persistence.notColumn;

public class TabChannelCoverInfo
  extends ChannelCoverInfo
{
  public static int TYPE_CHANNEL_MY_CONFIG = 700;
  public static int TYPE_CHANNEL_RECOMMEND_CONFIG = 701;
  public static int TYPE_CHANNEL_XTAB_FRIEND_CONFIG = 41655;
  public static int TYPE_CHANNEL_XTAB_KD_COMMUNITY_CONFIG = 41729;
  public long bid = 0L;
  public int boldFont;
  public long channelConfigType;
  public int dynamicSort;
  public long endTimestamp;
  public int fontsColor;
  public int frameColor;
  public boolean isImmersive = false;
  public boolean isXTabMode = false;
  @notColumn
  public boolean needBadgeGuide = false;
  public int onlyCover = 0;
  public String proxy;
  public int reason;
  public TabChannelCoverInfo.RedPoint redPoint;
  public String redPointJson;
  public long sectionId;
  public int seq;
  public int showCover;
  public int showIcon;
  public long startTimestamp;
  public String webUrl;
  
  public TabChannelCoverInfo() {}
  
  public TabChannelCoverInfo(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.channelConfigType = paramInt1;
    this.mChannelCoverId = paramInt2;
    this.mChannelCoverName = paramString1;
    this.reason = paramInt3;
    this.mChannelCoverIcon = paramString2;
  }
  
  public TabChannelCoverInfo(int paramInt, String paramString)
  {
    this.mChannelCoverId = paramInt;
    this.mChannelCoverName = paramString;
    this.reason = 1;
  }
  
  public TabChannelCoverInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.mChannelCoverId = paramInt1;
    this.mChannelCoverName = paramString;
    this.reason = paramInt2;
  }
  
  public TabChannelCoverInfo clone()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)super.clone();
    if (this.redPoint != null)
    {
      localTabChannelCoverInfo.redPoint = new TabChannelCoverInfo.RedPoint();
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = this.redPoint.jdField_a_of_type_Boolean;
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Long = this.redPoint.jdField_b_of_type_Long;
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Long = this.redPoint.jdField_a_of_type_Long;
      localTabChannelCoverInfo.redPoint.jdField_c_of_type_Long = this.redPoint.jdField_c_of_type_Long;
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Int = this.redPoint.jdField_a_of_type_Int;
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_JavaLangString = this.redPoint.jdField_a_of_type_JavaLangString;
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Int = this.redPoint.jdField_b_of_type_Int;
      localTabChannelCoverInfo.redPoint.jdField_c_of_type_Int = this.redPoint.jdField_c_of_type_Int;
    }
    return localTabChannelCoverInfo;
  }
  
  public String shortLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TabChannelCoverInfo {channelConfigType = ");
    localStringBuilder.append(this.channelConfigType);
    localStringBuilder.append("mChannelCoverId = ");
    localStringBuilder.append(this.mChannelCoverId);
    localStringBuilder.append(", mChannelCoverName = ");
    localStringBuilder.append(this.mChannelCoverName);
    localStringBuilder.append(", reason = ");
    localStringBuilder.append(this.reason);
    localStringBuilder.append(", seq = ");
    localStringBuilder.append(this.seq);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TabChannelCoverInfo{redPoint=");
    Object localObject = this.redPoint;
    if (localObject != null) {
      localObject = ((TabChannelCoverInfo.RedPoint)localObject).toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", startTimestamp=");
    localStringBuilder.append(this.startTimestamp);
    localStringBuilder.append(", endTimestamp=");
    localStringBuilder.append(this.endTimestamp);
    localStringBuilder.append(", reason=");
    localStringBuilder.append(this.reason);
    localStringBuilder.append(", bold_font=");
    localStringBuilder.append(this.boldFont);
    localStringBuilder.append(", show_icon=");
    localStringBuilder.append(this.showIcon);
    localStringBuilder.append(", show_cover=");
    localStringBuilder.append(this.showCover);
    localStringBuilder.append(", frame_color=");
    localStringBuilder.append(this.frameColor);
    localStringBuilder.append(", fonts_color=");
    localStringBuilder.append(this.fontsColor);
    localStringBuilder.append(", web_url='");
    localStringBuilder.append(this.webUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", proxy='");
    localStringBuilder.append(this.proxy);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelConfigType=");
    localStringBuilder.append(this.channelConfigType);
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.seq);
    localStringBuilder.append(", mChannelId=");
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
    localStringBuilder.append(", sectionId=");
    localStringBuilder.append(this.sectionId);
    localStringBuilder.append(", bid=");
    localStringBuilder.append(this.bid);
    localStringBuilder.append(", mChannelCoverIcon=");
    localStringBuilder.append(this.mChannelCoverIcon);
    localStringBuilder.append(", mChannelVersion=");
    localStringBuilder.append(this.mChannelVersion);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo
 * JD-Core Version:    0.7.0.1
 */