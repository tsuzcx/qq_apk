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
    if (paramUploadRoute == null) {}
    while ((!this.mIp.equals(paramUploadRoute.getIp())) || (this.mPort != paramUploadRoute.getPort())) {
      return false;
    }
    return true;
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
    StringBuilder localStringBuilder = new StringBuilder().append("(ip:");
    if (this.mIp == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append(", port:").append(this.mPort).append(", ");
      if (this.mRouteCategory != null) {
        break label78;
      }
    }
    label78:
    for (String str = "null";; str = this.mRouteCategory.getDesc())
    {
      return str + ")";
      str = this.mIp;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.UploadRoute
 * JD-Core Version:    0.7.0.1
 */