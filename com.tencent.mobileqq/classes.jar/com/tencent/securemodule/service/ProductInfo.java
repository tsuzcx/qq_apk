package com.tencent.securemodule.service;

public class ProductInfo
{
  public int buildNo;
  public String channelId;
  public int productId;
  public String qq;
  public int subPlatformId;
  public String version;
  
  public ProductInfo()
  {
    this.subPlatformId = 201;
  }
  
  public ProductInfo(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    this.productId = paramInt1;
    this.version = paramString1;
    this.buildNo = paramInt2;
    this.subPlatformId = paramInt3;
    this.channelId = paramString2;
    this.qq = paramString3;
  }
  
  public int getBuildNo()
  {
    return this.buildNo;
  }
  
  public String getChannelId()
  {
    return this.channelId;
  }
  
  public int getProductId()
  {
    return this.productId;
  }
  
  public String getQq()
  {
    return this.qq;
  }
  
  public int getSubPlatformId()
  {
    return this.subPlatformId;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setBuildNo(int paramInt)
  {
    this.buildNo = paramInt;
  }
  
  public void setChannelId(String paramString)
  {
    this.channelId = paramString;
  }
  
  public void setProductId(int paramInt)
  {
    this.productId = paramInt;
  }
  
  public void setQq(String paramString)
  {
    this.qq = paramString;
  }
  
  public void setSubPlatformId(int paramInt)
  {
    this.subPlatformId = paramInt;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.service.ProductInfo
 * JD-Core Version:    0.7.0.1
 */