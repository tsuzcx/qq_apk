package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;

public class DesktopSpringEntryInfo
  extends DesktopItemInfo
{
  private static final String TAG = "springHb_DesktopSpringEntryInfo";
  public int bannerHeight;
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo bannerInfo;
  public int bannerWidth;
  public String tips;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DesktopSpringEntryInfo{bannerInfo=");
    localStringBuilder.append(this.bannerInfo);
    localStringBuilder.append(", tips='");
    localStringBuilder.append(this.tips);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerWidth=");
    localStringBuilder.append(this.bannerWidth);
    localStringBuilder.append(", bannerHeight=");
    localStringBuilder.append(this.bannerHeight);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopSpringEntryInfo
 * JD-Core Version:    0.7.0.1
 */