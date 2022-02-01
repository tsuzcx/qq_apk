package com.tencent.mtt.hippy.adapter.http;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HippyHttpRequest
{
  public static final int DEFAULT_TIMEOUT_MS = 3000;
  private static String USER_AGENT = null;
  private String mBody;
  private int mConnectTimeout = 3000;
  private Map<String, Object> mHeaderMap = new HashMap();
  private boolean mInstanceFollowRedirects = false;
  private String mMethod = "GET";
  private int mReadTimeout = 3000;
  private String mUrl;
  private boolean mUseCaches = true;
  
  public HippyHttpRequest()
  {
    initUserAgent();
    if (USER_AGENT != null)
    {
      addHeader("User-Agent", USER_AGENT);
      return;
    }
    System.err.println("user_agent is null!");
  }
  
  private void initUserAgent()
  {
    Object localObject;
    StringBuffer localStringBuffer;
    if (USER_AGENT == null)
    {
      localObject = Locale.getDefault();
      localStringBuffer = new StringBuffer();
      String str = Build.VERSION.RELEASE;
      if (str.length() <= 0) {
        break label168;
      }
      localStringBuffer.append(str);
      localStringBuffer.append("; ");
      str = ((Locale)localObject).getLanguage();
      if (str == null) {
        break label178;
      }
      localStringBuffer.append(str.toLowerCase());
      localObject = ((Locale)localObject).getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(((String)localObject).toLowerCase());
      }
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT > 3) && ("REL".equals(Build.VERSION.CODENAME)))
      {
        localObject = Build.MODEL;
        if (((String)localObject).length() > 0)
        {
          localStringBuffer.append("; ");
          localStringBuffer.append((String)localObject);
        }
      }
      localObject = Build.ID;
      if (((String)localObject).length() > 0)
      {
        localStringBuffer.append(" Build/");
        localStringBuffer.append((String)localObject);
      }
      USER_AGENT = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Mobile Safari/533.1", new Object[] { localStringBuffer });
      return;
      label168:
      localStringBuffer.append("1.0");
      break;
      label178:
      localStringBuffer.append("en");
    }
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.mHeaderMap.put(paramString1, paramString2);
  }
  
  public void addHeader(String paramString, List<String> paramList)
  {
    this.mHeaderMap.put(paramString, paramList);
  }
  
  public String getBody()
  {
    return this.mBody;
  }
  
  public int getConnectTimeout()
  {
    return this.mConnectTimeout;
  }
  
  public Map<String, Object> getHeaders()
  {
    return this.mHeaderMap;
  }
  
  public String getMethod()
  {
    return this.mMethod;
  }
  
  public int getReadTimeout()
  {
    return this.mReadTimeout;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean isInstanceFollowRedirects()
  {
    return this.mInstanceFollowRedirects;
  }
  
  public boolean isUseCaches()
  {
    return this.mUseCaches;
  }
  
  public void setBody(String paramString)
  {
    this.mBody = paramString;
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.mConnectTimeout = paramInt;
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.mInstanceFollowRedirects = paramBoolean;
  }
  
  public void setMethod(String paramString)
  {
    this.mMethod = paramString;
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.mReadTimeout = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.mUseCaches = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.http.HippyHttpRequest
 * JD-Core Version:    0.7.0.1
 */