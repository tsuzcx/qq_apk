package com.tencent.mobileqq.profilecard.processor;

import com.tencent.mobileqq.data.Card;

class DefaultProfileBusinessProcessor$ProfileLocationCodes
{
  public boolean gotHometown = false;
  public boolean gotLocation = false;
  public String homeCityCode = "0";
  public String homeCountryCode = "0";
  public String homeDistrictCode = "0";
  public String homeProvinceCode = "0";
  public String locCityCode = "0";
  public String locCountryCode = "0";
  public String locDistrictCode = "0";
  public String locProvinceCode = "0";
  
  public void getLocationCodes(Card paramCard)
  {
    StringBuilder localStringBuilder;
    if (this.gotLocation)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.locCountryCode).append("-");
      localStringBuilder.append(this.locProvinceCode).append("-");
      localStringBuilder.append(this.locCityCode).append("-");
      localStringBuilder.append(this.locDistrictCode);
      paramCard.strLocationCodes = localStringBuilder.toString();
    }
    if (this.gotHometown)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.homeCountryCode).append("-");
      localStringBuilder.append(this.homeProvinceCode).append("-");
      localStringBuilder.append(this.homeCityCode).append("-");
      localStringBuilder.append(this.homeDistrictCode);
      paramCard.strHometownCodes = localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.DefaultProfileBusinessProcessor.ProfileLocationCodes
 * JD-Core Version:    0.7.0.1
 */