package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.io.Serializable;

public class PositionData
  implements Serializable
{
  public String city = "";
  public String cityCode = "";
  public String cityGPS = "";
  public String country = "";
  public String province = "";
  
  public PositionData() {}
  
  public PositionData(SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return;
    }
    this.country = paramSosoLocation.nation;
    this.province = paramSosoLocation.province;
    if ((paramSosoLocation.city != null) && (paramSosoLocation.city.endsWith("市"))) {
      this.city = paramSosoLocation.city.substring(0, paramSosoLocation.city.length() - 1);
    } else {
      this.city = paramSosoLocation.city;
    }
    if ((paramSosoLocation.cityCode != null) && (paramSosoLocation.cityCode.length() > 2)) {
      if (paramSosoLocation.cityCode.startsWith("11"))
      {
        this.cityCode = "110000";
      }
      else if (paramSosoLocation.cityCode.startsWith("12"))
      {
        this.cityCode = "120000";
      }
      else if (paramSosoLocation.cityCode.startsWith("31"))
      {
        this.cityCode = "310000";
      }
      else if (paramSosoLocation.cityCode.startsWith("50"))
      {
        this.cityCode = "500000";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramSosoLocation.cityCode.substring(0, paramSosoLocation.cityCode.length() - 2));
        localStringBuilder.append("00");
        this.cityCode = localStringBuilder.toString();
      }
    }
    this.cityGPS = paramSosoLocation.city;
  }
  
  public PositionData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.country = paramString1;
    this.province = paramString2;
    this.city = paramString3;
    this.cityCode = paramString4;
    this.cityGPS = paramString3;
  }
  
  public void copy(PositionData paramPositionData)
  {
    this.country = paramPositionData.country;
    this.province = paramPositionData.province;
    this.city = paramPositionData.city;
    this.cityCode = paramPositionData.cityCode;
    this.cityGPS = paramPositionData.cityGPS;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PositionData)))
    {
      paramObject = (PositionData)paramObject;
      return this.cityCode.equals(paramObject.cityCode);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("country = ");
    localStringBuilder.append(this.country);
    localStringBuilder.append(" province = ");
    localStringBuilder.append(this.province);
    localStringBuilder.append(" city = ");
    localStringBuilder.append(this.city);
    localStringBuilder.append(" citycode = ");
    localStringBuilder.append(this.cityCode);
    localStringBuilder.append(" cityGPS = ");
    localStringBuilder.append(this.cityGPS);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData
 * JD-Core Version:    0.7.0.1
 */