package com.tencent.mobileqq.olympic;

import java.io.Serializable;

public class OlympicActConfig$CityImage
  implements Serializable
{
  public int companyId;
  public String md5;
  public long picId;
  public String starMd5;
  public String starUrl;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("companyId=").append(this.companyId);
    localStringBuilder.append(", url=").append(this.url);
    localStringBuilder.append(", picId=").append(this.picId);
    localStringBuilder.append(", md5=").append(this.md5);
    localStringBuilder.append(", starUrl=").append(this.starUrl);
    localStringBuilder.append(", starMd5=").append(this.starMd5);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicActConfig.CityImage
 * JD-Core Version:    0.7.0.1
 */