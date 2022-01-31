package com.tencent.upload.network.route;

import java.io.Serializable;

public final class UploadRoute
  implements Serializable
{
  private static final long serialVersionUID = 100L;
  private String mIp;
  private int mPort;
  private String mProxyIp;
  private int mProxyPort;
  private c.a mRouteCategory;
  
  public UploadRoute(String paramString, int paramInt, c.a parama)
  {
    this(paramString, paramInt, null, 0, parama);
  }
  
  public UploadRoute(String paramString1, int paramInt1, String paramString2, int paramInt2, c.a parama)
  {
    this.mIp = paramString1;
    this.mPort = paramInt1;
    this.mProxyIp = paramString2;
    this.mProxyPort = paramInt2;
    this.mRouteCategory = parama;
  }
  
  public void clearProxy()
  {
    this.mProxyIp = null;
    this.mProxyPort = 0;
  }
  
  public UploadRoute clone()
  {
    return new UploadRoute(this.mIp, this.mPort, this.mProxyIp, this.mProxyPort, this.mRouteCategory);
  }
  
  public String getIp()
  {
    return this.mIp;
  }
  
  public int getPort()
  {
    return this.mPort;
  }
  
  public int getPorxyPort()
  {
    return this.mProxyPort;
  }
  
  public String getProxyIp()
  {
    return this.mProxyIp;
  }
  
  public c.a getRouteCategory()
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
  
  public void setPorxyPort(int paramInt)
  {
    this.mProxyPort = paramInt;
  }
  
  public void setProxy(String paramString, int paramInt)
  {
    this.mProxyIp = paramString;
    this.mProxyPort = paramInt;
  }
  
  public void setProxyIp(String paramString)
  {
    this.mProxyIp = paramString;
  }
  
  public void setRouteCategory(c.a parama)
  {
    this.mRouteCategory = parama;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("(ip:");
    if (this.mIp == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append(", port:").append(this.mPort).append(", pIp:");
      if (this.mProxyIp != null) {
        break label111;
      }
      str = "null";
      label56:
      localStringBuilder = localStringBuilder.append(str).append(", pPort:").append(this.mProxyPort).append(", ");
      if (this.mRouteCategory != null) {
        break label119;
      }
    }
    label111:
    label119:
    for (String str = "null";; str = this.mRouteCategory.b())
    {
      return str + ")";
      str = this.mIp;
      break;
      str = this.mProxyIp;
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.route.UploadRoute
 * JD-Core Version:    0.7.0.1
 */