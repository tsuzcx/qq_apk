package org.xwalk.core.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddress
{
  static final int MATCH_GROUP_AUTHORITY = 2;
  static final int MATCH_GROUP_HOST = 3;
  static final int MATCH_GROUP_PATH = 5;
  static final int MATCH_GROUP_PORT = 4;
  static final int MATCH_GROUP_SCHEME = 1;
  static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
  private String mAuthInfo;
  private String mHost;
  private String mPath;
  private int mPort;
  private String mScheme;
  
  public WebAddress(String paramString)
  {
    Object localObject;
    if (paramString != null)
    {
      this.mScheme = "";
      this.mHost = "";
      this.mPort = -1;
      this.mPath = "/";
      this.mAuthInfo = "";
      paramString = sAddressPattern.matcher(paramString);
      if (paramString.matches())
      {
        localObject = paramString.group(1);
        if (localObject != null) {
          this.mScheme = ((String)localObject).toLowerCase(Locale.ROOT);
        }
        localObject = paramString.group(2);
        if (localObject != null) {
          this.mAuthInfo = ((String)localObject);
        }
        localObject = paramString.group(3);
        if (localObject != null) {
          this.mHost = ((String)localObject);
        }
        localObject = paramString.group(4);
        if ((localObject == null) || (((String)localObject).length() <= 0)) {}
      }
    }
    try
    {
      this.mPort = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException paramString)
    {
      label131:
      break label131;
    }
    throw new WebAddress.ParseException("Bad port");
    paramString = paramString.group(5);
    if ((paramString != null) && (paramString.length() > 0)) {
      if (paramString.charAt(0) == '/')
      {
        this.mPath = paramString;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(paramString);
        this.mPath = ((StringBuilder)localObject).toString();
      }
    }
    if ((this.mPort == 443) && (this.mScheme.equals(""))) {
      this.mScheme = "https";
    } else if (this.mPort == -1) {
      if (this.mScheme.equals("https")) {
        this.mPort = 443;
      } else {
        this.mPort = 80;
      }
    }
    if (this.mScheme.equals("")) {
      this.mScheme = "http";
    }
    return;
    throw new WebAddress.ParseException("Bad address");
    throw new NullPointerException();
  }
  
  public String getAuthInfo()
  {
    return this.mAuthInfo;
  }
  
  public String getHost()
  {
    return this.mHost;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public int getPort()
  {
    return this.mPort;
  }
  
  public String getScheme()
  {
    return this.mScheme;
  }
  
  public void setAuthInfo(String paramString)
  {
    this.mAuthInfo = paramString;
  }
  
  public void setHost(String paramString)
  {
    this.mHost = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.mPort = paramInt;
  }
  
  public void setScheme(String paramString)
  {
    this.mScheme = paramString;
  }
  
  public String toString()
  {
    int i = this.mPort;
    Object localObject2 = "";
    Object localObject1;
    if (((i != 443) && (this.mScheme.equals("https"))) || ((this.mPort != 80) && (this.mScheme.equals("http"))))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(Integer.toString(this.mPort));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    if (this.mAuthInfo.length() > 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mAuthInfo);
      ((StringBuilder)localObject2).append("@");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mScheme);
    localStringBuilder.append("://");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(this.mHost);
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(this.mPath);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.util.WebAddress
 * JD-Core Version:    0.7.0.1
 */