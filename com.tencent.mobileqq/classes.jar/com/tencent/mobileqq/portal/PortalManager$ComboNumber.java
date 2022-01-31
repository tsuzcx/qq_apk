package com.tencent.mobileqq.portal;

import java.io.Serializable;

public class PortalManager$ComboNumber
  implements Serializable
{
  public String flowerImage2MD5;
  public String flowerImage2Url;
  public String flowerImageMD5;
  public String flowerImageUrl;
  public int number;
  public String numberImageMD5;
  public String numberImageUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("number=").append(this.number).append(", numUrl=").append(this.numberImageUrl).append(", numMd5=").append(this.numberImageMD5).append(", floUrl=").append(this.flowerImageUrl).append(", floMd5=").append(this.flowerImageMD5).append(", flo2Url=").append(this.flowerImage2Url).append(", flo2Md5=").append(this.flowerImage2MD5);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.ComboNumber
 * JD-Core Version:    0.7.0.1
 */