package com.tencent.qapmsdk.impl.socket;

public class UrlBuilder
{
  private boolean directConnect = false;
  private String hostAddress;
  private int hostPort = -1;
  private String hostname;
  private String httpPath = "/";
  private UrlBuilder.Scheme scheme = null;
  
  private String getHostNameWithDefault()
  {
    String str = "unknown-host";
    if (this.hostname != null) {
      str = this.hostname;
    }
    return str;
  }
  
  private String getUrl(String paramString, int paramInt)
  {
    String str1 = paramString;
    if (paramInt > 0)
    {
      String str2 = ":" + paramInt;
      str1 = paramString;
      if (!paramString.endsWith(str2)) {
        str1 = paramString + str2;
      }
    }
    return str1;
  }
  
  public boolean checkScheme(String paramString)
  {
    return (paramString != null) && ((paramString.regionMatches(true, 0, "http:", 0, 5)) || (paramString.regionMatches(true, 0, "https:", 0, 6)));
  }
  
  public String getHostAddress()
  {
    return this.hostAddress;
  }
  
  public int getHostPort()
  {
    return this.hostPort;
  }
  
  public String getHostname()
  {
    return this.hostname;
  }
  
  public String getHttpPath()
  {
    return this.httpPath;
  }
  
  public UrlBuilder.Scheme getScheme()
  {
    return this.scheme;
  }
  
  public String getUrl()
  {
    String str3 = getHostNameWithDefault();
    if (this.directConnect) {
      return getUrl(str3, this.hostPort);
    }
    String str4 = this.httpPath;
    Object localObject = "";
    if (checkScheme(str4)) {
      return str4;
    }
    if (this.scheme != null) {
      localObject = "" + UrlBuilder.Scheme.access$000(this.scheme) + ":";
    }
    if (str4.startsWith("//")) {
      return (String)localObject + str4;
    }
    String str5 = (String)localObject + "//";
    if (str4.startsWith(str3)) {
      return str5 + str4;
    }
    String str1 = "";
    localObject = str1;
    if (this.hostPort > 0) {
      if (this.scheme != null)
      {
        localObject = str1;
        if (UrlBuilder.Scheme.access$100(this.scheme) == this.hostPort) {}
      }
      else
      {
        String str2 = ":" + this.hostPort;
        localObject = str1;
        if (!str3.endsWith(str2)) {
          localObject = str2;
        }
      }
    }
    return str5 + str3 + (String)localObject + str4;
  }
  
  public void setDirectConnect(boolean paramBoolean)
  {
    this.directConnect = paramBoolean;
  }
  
  public void setHostAddress(String paramString)
  {
    this.hostAddress = paramString;
  }
  
  public void setHostPort(int paramInt)
  {
    if (paramInt > 0) {
      this.hostPort = paramInt;
    }
  }
  
  public void setHostname(String paramString)
  {
    this.hostname = paramString;
  }
  
  public void setHttpPath(String paramString)
  {
    if (paramString != null) {
      this.httpPath = paramString;
    }
  }
  
  public void setScheme(UrlBuilder.Scheme paramScheme)
  {
    this.scheme = paramScheme;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hostAddress: " + this.hostAddress);
    localStringBuilder.append("hostname: " + this.hostname);
    localStringBuilder.append("httpPath: " + this.httpPath);
    localStringBuilder.append("scheme: " + this.scheme);
    localStringBuilder.append("hostPort: " + this.hostPort);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.socket.UrlBuilder
 * JD-Core Version:    0.7.0.1
 */