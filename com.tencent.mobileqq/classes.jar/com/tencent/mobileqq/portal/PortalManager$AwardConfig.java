package com.tencent.mobileqq.portal;

import java.io.Serializable;

public class PortalManager$AwardConfig
  implements Serializable
{
  public String addMsg;
  public int awardId;
  public String awardImg;
  public String awardMd5;
  public String awardMsg;
  public String awardTitle = "";
  public int awardType;
  public String ctfBgImg;
  public String ctfBgMd5;
  public int logoId;
  public String publicId;
  public String publicWording;
  public int showPublic;
  public String starImg;
  public String starMd5;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("awardId=");
    localStringBuilder.append(this.awardId);
    localStringBuilder.append(", logoId=");
    localStringBuilder.append(this.logoId);
    localStringBuilder.append(", awardImg=");
    localStringBuilder.append(this.awardImg);
    localStringBuilder.append(", awardMd5=");
    localStringBuilder.append(this.awardMd5);
    localStringBuilder.append(", starImg=");
    localStringBuilder.append(this.starImg);
    localStringBuilder.append(", starMD5=");
    localStringBuilder.append(this.starMd5);
    localStringBuilder.append(", ctfBgImg=");
    localStringBuilder.append(this.ctfBgImg);
    localStringBuilder.append(", ctfBgMd5=");
    localStringBuilder.append(this.ctfBgMd5);
    localStringBuilder.append(", showPublic=");
    localStringBuilder.append(this.showPublic);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.AwardConfig
 * JD-Core Version:    0.7.0.1
 */