package com.tencent.mobileqq.data;

import android.text.TextUtils;
import atmo;
import atoc;

public class PrecoverRetryInfo
  extends atmo
{
  public String businessId;
  public int itemRetryCount;
  public String md5;
  @atoc
  public String pk;
  public long retryUpdateTime;
  public int totalRetryCount;
  
  public PrecoverRetryInfo() {}
  
  public PrecoverRetryInfo(String paramString1, String paramString2)
  {
    this.businessId = paramString1;
    this.md5 = paramString2;
    this.itemRetryCount = 0;
    this.totalRetryCount = 0;
    this.retryUpdateTime = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.pk = (paramString1 + "_" + paramString2);
      return;
    }
    this.pk = null;
  }
  
  public void postRead()
  {
    super.postRead();
  }
  
  public void postwrite()
  {
    super.postwrite();
  }
  
  public void prewrite()
  {
    super.prewrite();
    if ((!TextUtils.isEmpty(this.businessId)) && (!TextUtils.isEmpty(this.md5)))
    {
      this.pk = (this.businessId + "_" + this.md5);
      return;
    }
    this.pk = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrecoverRetryInfo:md5=").append(this.md5);
    localStringBuilder.append(",businessId=").append(this.businessId);
    localStringBuilder.append(",itemRetryCount=").append(this.itemRetryCount);
    localStringBuilder.append(",totalRetryCount=").append(this.totalRetryCount);
    localStringBuilder.append(",retryUpdateTime=").append(this.retryUpdateTime);
    localStringBuilder.append(", pk=").append(this.pk);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.PrecoverRetryInfo
 * JD-Core Version:    0.7.0.1
 */