package com.tencent.mobileqq.portal;

class PortalManager$BannerConfig
  extends PortalManager.TimerConfig
{
  public String bannarMd5;
  public String bannerImg;
  public int id;
  public String jumpUrl;
  public int useFlag;
  
  private PortalManager$BannerConfig()
  {
    super(null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(this.id);
    localStringBuilder.append(", bannerImg=").append(this.bannerImg);
    localStringBuilder.append(", bannarMd5=").append(this.bannarMd5);
    localStringBuilder.append(", jumpUrl=").append(this.jumpUrl);
    localStringBuilder.append(", useFlag=").append(this.useFlag);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.BannerConfig
 * JD-Core Version:    0.7.0.1
 */