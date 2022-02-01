package com.tencent.tencentmap.mapsdk.maps.model;

public class IndoorInfo
{
  private String a;
  private String b;
  
  public IndoorInfo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getBuildingId()
  {
    return this.a;
  }
  
  public String getFloorName()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo
 * JD-Core Version:    0.7.0.1
 */