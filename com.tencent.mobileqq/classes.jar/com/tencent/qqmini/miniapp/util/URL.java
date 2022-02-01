package com.tencent.qqmini.miniapp.util;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@MiniKeep
public class URL
{
  private static Pattern schemePattern = Pattern.compile("[\\w\\d+_]+://");
  private String fullUrl;
  private String path;
  private String query;
  private Map<String, String> queryParam = new HashMap();
  
  public URL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.fullUrl = paramString;
      Object localObject = paramString;
      if (paramString.contains("://")) {
        localObject = paramString.replaceFirst("^.*://", "");
      }
      if (!((String)localObject).contains("?"))
      {
        this.path = ((String)localObject);
        return;
      }
      paramString = ((String)localObject).split("\\?");
      this.path = paramString[0];
      this.query = paramString[1];
      localObject = this.query.split("&");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramString = localObject[i];
        if (paramString.contains("="))
        {
          String[] arrayOfString = paramString.split("=");
          String str = arrayOfString[0];
          paramString = "";
          if (arrayOfString.length > 1) {
            paramString = arrayOfString[1];
          }
          this.queryParam.put(str, paramString);
        }
        i += 1;
      }
    }
  }
  
  public URL(String paramString, Map<String, String> paramMap)
  {
    this.path = paramString;
    this.queryParam = paramMap;
    this.query = "";
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.query = (this.query + str + "=" + (String)paramMap.get(str) + "&");
      }
    }
    this.fullUrl = paramString;
    if (!TextUtils.isEmpty(this.query))
    {
      this.query = this.query.substring(0, this.query.length() - 1);
      this.fullUrl = (paramString + "?" + this.query);
    }
  }
  
  public String getFullUrl()
  {
    return this.fullUrl;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getQuery()
  {
    return this.query;
  }
  
  public Map<String, String> getQueryParam()
  {
    return this.queryParam;
  }
  
  public void setQueryParam(Map<String, String> paramMap)
  {
    this.queryParam = paramMap;
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      for (String str1 = "";; str1 = str1 + str2 + "=" + (String)paramMap.get(str2) + "&")
      {
        str2 = str1;
        if (!localIterator.hasNext()) {
          break;
        }
        str2 = (String)localIterator.next();
      }
    }
    String str2 = "";
    this.query = str2;
    if (!TextUtils.isEmpty(this.query))
    {
      this.query = this.query.substring(0, this.query.length() - 1);
      this.fullUrl = (this.path + "?" + this.query);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.URL
 * JD-Core Version:    0.7.0.1
 */