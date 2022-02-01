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
    return "DesktopSpringEntryInfo{bannerInfo=" + this.bannerInfo + ", tips='" + this.tips + '\'' + ", bannerWidth=" + this.bannerWidth + ", bannerHeight=" + this.bannerHeight + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopSpringEntryInfo
 * JD-Core Version:    0.7.0.1
 */