package com.tencent.mobileqq.soso.location;

class LbsManagerService$BusinessInfo
{
  public String businessId;
  public boolean canUseGps;
  public int realTimeRequirement;
  public boolean reqGoon;
  public boolean reqLonAndLat;
  public boolean reqRawData;
  public int requestDataLevel;
  
  public LbsManagerService$BusinessInfo(String paramString, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.businessId = paramString;
    this.reqLonAndLat = paramBoolean1;
    this.realTimeRequirement = paramInt1;
    this.requestDataLevel = paramInt2;
    this.reqGoon = paramBoolean2;
    this.canUseGps = paramBoolean3;
    this.reqRawData = paramBoolean4;
  }
  
  public int canUseMaxCacheInterval()
  {
    int i = this.realTimeRequirement;
    if (i == 5) {
      return 0;
    }
    if (i == 4) {
      return 60000;
    }
    if (i == 3) {
      return 180000;
    }
    if (i == 2) {
      return 600000;
    }
    return 1800000;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessId: ");
    localStringBuilder.append(this.businessId);
    localStringBuilder.append(",");
    localStringBuilder.append("reqLonAndLat: ");
    localStringBuilder.append(this.reqLonAndLat);
    localStringBuilder.append(",");
    localStringBuilder.append("realTimeRequirement: ");
    localStringBuilder.append(this.realTimeRequirement);
    localStringBuilder.append(",");
    localStringBuilder.append("requestDataLevel: ");
    localStringBuilder.append(this.requestDataLevel);
    localStringBuilder.append(",");
    localStringBuilder.append("reqGoon: ");
    localStringBuilder.append(this.reqGoon);
    localStringBuilder.append(",");
    localStringBuilder.append("canUseGps: ");
    localStringBuilder.append(this.canUseGps);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.LbsManagerService.BusinessInfo
 * JD-Core Version:    0.7.0.1
 */