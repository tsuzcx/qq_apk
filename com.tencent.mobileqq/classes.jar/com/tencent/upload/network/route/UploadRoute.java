package com.tencent.upload.network.route;

import java.io.Serializable;

public final class UploadRoute
  implements Serializable
{
  private static final long serialVersionUID = 100L;
  private String mIp;
  private int mPort;
  private IUploadRouteStrategy.RouteCategoryType mRouteCategory;
  
  public UploadRoute(String paramString, int paramInt, IUploadRouteStrategy.RouteCategoryType paramRouteCategoryType)
  {
    this.mIp = paramString;
    this.mPort = paramInt;
    this.mRouteCategory = paramRouteCategoryType;
  }
  
  public UploadRoute clone()
  {
    return new UploadRoute(this.mIp, this.mPort, this.mRouteCategory);
  }
  
  public String getIp()
  {
    return this.mIp;
  }
  
  public int getPort()
  {
    return this.mPort;
  }
  
  public IUploadRouteStrategy.RouteCategoryType getRouteCategory()
  {
    return this.mRouteCategory;
  }
  
  public boolean isDuplicate(UploadRoute paramUploadRoute)
  {
    if (paramUploadRoute == null) {
      return false;
    }
    if (this.mIp.equals(paramUploadRoute.getIp())) {
      return this.mPort == paramUploadRoute.getPort();
    }
    return false;
  }
  
  public void setIp(String paramString)
  {
    this.mIp = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.mPort = paramInt;
  }
  
  public void setRouteCategory(IUploadRouteStrategy.RouteCategoryType paramRouteCategoryType)
  {
    this.mRouteCategory = paramRouteCategoryType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(ip:");
    String str2 = this.mIp;
    String str1 = "null";
    Object localObject = str2;
    if (str2 == null) {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", port:");
    localStringBuilder.append(this.mPort);
    localStringBuilder.append(", ");
    localObject = this.mRouteCategory;
    if (localObject == null) {
      localObject = str1;
    } else {
      localObject = ((IUploadRouteStrategy.RouteCategoryType)localObject).getDesc();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.UploadRoute
 * JD-Core Version:    0.7.0.1
 */