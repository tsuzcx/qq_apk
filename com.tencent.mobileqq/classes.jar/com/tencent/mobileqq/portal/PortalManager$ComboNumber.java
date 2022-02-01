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
  
  public String getCowJumpAnimFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.number);
    localStringBuilder.append("_anim.png");
    return localStringBuilder.toString();
  }
  
  public String getFlowerImage1FileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.number);
    localStringBuilder.append("_flower1.png");
    return localStringBuilder.toString();
  }
  
  public String getFlowerImage2FileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.number);
    localStringBuilder.append("_flower2.png");
    return localStringBuilder.toString();
  }
  
  public String getNumberImageFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.number);
    localStringBuilder.append("_number.png");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("number=");
    localStringBuilder.append(this.number);
    localStringBuilder.append(", numUrl=");
    localStringBuilder.append(this.numberImageUrl);
    localStringBuilder.append(", numMd5=");
    localStringBuilder.append(this.numberImageMD5);
    localStringBuilder.append(", floUrl=");
    localStringBuilder.append(this.flowerImageUrl);
    localStringBuilder.append(", floMd5=");
    localStringBuilder.append(this.flowerImageMD5);
    localStringBuilder.append(", flo2Url=");
    localStringBuilder.append(this.flowerImage2Url);
    localStringBuilder.append(", flo2Md5=");
    localStringBuilder.append(this.flowerImage2MD5);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.ComboNumber
 * JD-Core Version:    0.7.0.1
 */