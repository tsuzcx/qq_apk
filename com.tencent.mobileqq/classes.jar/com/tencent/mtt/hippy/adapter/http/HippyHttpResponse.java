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
    if (this.mInputStream != null) {}
    try
    {
      this.mInputStream.close();
      if (this.mErrorStream == null) {}
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.mErrorStream.close();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
      }
    }
  }
  
  public InputStream getErrorStream()
  {
    return this.mErrorStream;
  }
  
  public String getHeaderField(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mRspHeaderMap == null)) {
      return null;
    }
    paramString = (List)this.mRspHeaderMap.get(paramString);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (String)paramString.get(0);
    }
    return null;
  }
  
  public List<String> getHeaderFields(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mRspHeaderMap == null)) {
      return null;
    }
    return (List)this.mRspHeaderMap.get(paramString);
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
    if (this.mStatusCode != null) {
      return this.mStatusCode;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.http.HippyHttpResponse
 * JD-Core Version:    0.7.0.1
 */