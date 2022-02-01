package com.tencent.mtt.hippy.adapter.http;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class HippyHttpResponse
{
  public static final Integer UNKNOWN_STATUS = new Integer(-1);
  private InputStream mErrorStream;
  private InputStream mInputStream;
  private String mResponseMessage;
  private Map<String, List<String>> mRspHeaderMap = null;
  private Integer mStatusCode = UNKNOWN_STATUS;
  
  public void close()
  {
    InputStream localInputStream1 = this.mInputStream;
    if (localInputStream1 != null) {
      try
      {
        localInputStream1.close();
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    InputStream localInputStream2 = this.mErrorStream;
    if (localInputStream2 != null) {
      try
      {
        localInputStream2.close();
        return;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  public InputStream getErrorStream()
  {
    return this.mErrorStream;
  }
  
  public String getHeaderField(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = this.mRspHeaderMap;
      if (localObject1 == null) {
        return null;
      }
      paramString = (List)((Map)localObject1).get(paramString);
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (paramString.size() > 0) {
          localObject1 = (String)paramString.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public List<String> getHeaderFields(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Map localMap = this.mRspHeaderMap;
      if (localMap != null) {
        return (List)localMap.get(paramString);
      }
    }
    return null;
  }
  
  public InputStream getInputStream()
  {
    return this.mInputStream;
  }
  
  public String getResponseMessage()
  {
    return this.mResponseMessage;
  }
  
  public Map<String, List<String>> getRspHeaderMaps()
  {
    return this.mRspHeaderMap;
  }
  
  public Integer getStatusCode()
  {
    Integer localInteger = this.mStatusCode;
    if (localInteger != null) {
      return localInteger;
    }
    return UNKNOWN_STATUS;
  }
  
  public void setErrorStream(InputStream paramInputStream)
  {
    this.mErrorStream = paramInputStream;
  }
  
  public void setInputStream(InputStream paramInputStream)
  {
    this.mInputStream = paramInputStream;
  }
  
  public void setResponseMessage(String paramString)
  {
    this.mResponseMessage = paramString;
  }
  
  public void setRspHeaderMap(Map<String, List<String>> paramMap)
  {
    this.mRspHeaderMap = paramMap;
  }
  
  public void setStatusCode(Integer paramInteger)
  {
    this.mStatusCode = paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.http.HippyHttpResponse
 * JD-Core Version:    0.7.0.1
 */