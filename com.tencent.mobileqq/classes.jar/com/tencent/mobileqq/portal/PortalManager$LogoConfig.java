package com.tencent.mobileqq.portal;

import java.io.Serializable;

public class PortalManager$LogoConfig
  implements Serializable
{
  public String greetImageMD5;
  public String greetImageUrl;
  public int logoId;
  public String logoImageMD5;
  public String logoImageUrl;
  public String nameMD5;
  public String nameUrl;
  public String padantImageMD5;
  public String padantImageUrl;
  public String relationCompanyLogoMD5;
  public String relationCompanyLogoUrl;
  public String relationCompanyNameMD5;
  public String relationCompanyNameUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("logoImageUrl=");
    localStringBuilder.append(this.logoImageUrl);
    localStringBuilder.append(", logoImageMD5=");
    localStringBuilder.append(this.logoImageMD5);
    localStringBuilder.append(", nameUrl=");
    localStringBuilder.append(this.nameUrl);
    localStringBuilder.append(", nameMD5=");
    localStringBuilder.append(this.nameMD5);
    localStringBuilder.append(", greetImageUrl=");
    localStringBuilder.append(this.greetImageUrl);
    localStringBuilder.append(", greetImageMD5=");
    localStringBuilder.append(this.greetImageMD5);
    localStringBuilder.append(", padantImageUrl=");
    localStringBuilder.append(this.padantImageUrl);
    localStringBuilder.append(", padantImageMD5=");
    localStringBuilder.append(this.padantImageMD5);
    localStringBuilder.append(", relationCompanyLogoUrl=");
    localStringBuilder.append(this.relationCompanyLogoUrl);
    localStringBuilder.append(", relationCompanyLogoMD5=");
    localStringBuilder.append(this.relationCompanyLogoMD5);
    localStringBuilder.append(", relationCompanyNameUrl=");
    localStringBuilder.append(this.relationCompanyNameUrl);
    localStringBuilder.append(", relationCompanyNameMD5=");
    localStringBuilder.append(this.relationCompanyNameMD5);
    localStringBuilder.append(", logoId=");
    localStringBuilder.append(this.logoId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.LogoConfig
 * JD-Core Version:    0.7.0.1
 */