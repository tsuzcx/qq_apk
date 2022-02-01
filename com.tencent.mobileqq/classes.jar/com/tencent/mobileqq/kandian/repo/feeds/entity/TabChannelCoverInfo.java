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
  @notColumn
  public String defaultIcon;
  public int dynamicSort;
  public long endTimestamp;
  public int fontsColor;
  public int frameColor;
  @notColumn
  public String iconUrl;
  @notColumn
  public boolean isIconTab = false;
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
      localTabChannelCoverInfo.redPoint.a = this.redPoint.a;
      localTabChannelCoverInfo.redPoint.c = this.redPoint.c;
      localTabChannelCoverInfo.redPoint.b = this.redPoint.b;
      localTabChannelCoverInfo.redPoint.d = this.redPoint.d;
      localTabChannelCoverInfo.redPoint.e = this.redPoint.e;
      localTabChannelCoverInfo.redPoint.f = this.redPoint.f;
      localTabChannelCoverInfo.redPoint.g = this.redPoint.g;
      localTabChannelCoverInfo.redPoint.h = this.redPoint.h;
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
    localStringBuilder.append(this.redPoint);
    localStringBuilder.append(", startTimestamp=");
    localStringBuilder.append(this.startTimestamp);
    localStringBuilder.append(", endTimestamp=");
    localStringBuilder.append(this.endTimestamp);
    localStringBuilder.append(", reason=");
    localStringBuilder.append(this.reason);
    localStringBuilder.append(", boldFont=");
    localStringBuilder.append(this.boldFont);
    localStringBuilder.append(", showIcon=");
    localStringBuilder.append(this.showIcon);
    localStringBuilder.append(", showCover=");
    localStringBuilder.append(this.showCover);
    localStringBuilder.append(", frameColor=");
    localStringBuilder.append(this.frameColor);
    localStringBuilder.append(", fontsColor=");
    localStringBuilder.append(this.fontsColor);
    localStringBuilder.append(", webUrl='");
    localStringBuilder.append(this.webUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", proxy='");
    localStringBuilder.append(this.proxy);
    localStringBuilder.append('\'');
    localStringBuilder.append(", channelConfigType=");
    localStringBuilder.append(this.channelConfigType);
    localStringBuilder.append(", onlyCover=");
    localStringBuilder.append(this.onlyCover);
    localStringBuilder.append(", bid=");
    localStringBuilder.append(this.bid);
    localStringBuilder.append(", dynamicSort=");
    localStringBuilder.append(this.dynamicSort);
    localStringBuilder.append(", sectionId=");
    localStringBuilder.append(this.sectionId);
    localStringBuilder.append(", isImmersive=");
    localStringBuilder.append(this.isImmersive);
    localStringBuilder.append(", isXTabMode=");
    localStringBuilder.append(this.isXTabMode);
    localStringBuilder.append(", isIconTab=");
    localStringBuilder.append(this.isIconTab);
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", defaultIcon='");
    localStringBuilder.append(this.defaultIcon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needBadgeGuide=");
    localStringBuilder.append(this.needBadgeGuide);
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.seq);
    localStringBuilder.append(", redPointJson='");
    localStringBuilder.append(this.redPointJson);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo
 * JD-Core Version:    0.7.0.1
 */