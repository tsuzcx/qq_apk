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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.fullUrl = paramString;
    Object localObject1 = paramString;
    if (paramString.contains("://")) {
      localObject1 = paramString.replaceFirst("^.*://", "");
    }
    if (!((String)localObject1).contains("?"))
    {
      this.path = ((String)localObject1);
      return;
    }
    paramString = ((String)localObject1).split("\\?");
    this.path = paramString[0];
    this.query = paramString[1];
    localObject1 = this.query.split("&");
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      paramString = localObject1[i];
      if (paramString.contains("="))
      {
        paramString = paramString.split("=");
        Object localObject2 = paramString[0];
        if (paramString.length > 1) {
          paramString = paramString[1];
        } else {
          paramString = "";
        }
        this.queryParam.put(localObject2, paramString);
      }
      i += 1;
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.query);
        localStringBuilder.append(str);
        localStringBuilder.append("=");
        localStringBuilder.append((String)paramMap.get(str));
        localStringBuilder.append("&");
        this.query = localStringBuilder.toString();
      }
    }
    this.fullUrl = paramString;
    if (!TextUtils.isEmpty(this.query))
    {
      paramMap = this.query;
      this.query = paramMap.substring(0, paramMap.length() - 1);
      paramMap = new StringBuilder();
      paramMap.append(paramString);
      paramMap.append("?");
      paramMap.append(this.query);
      this.fullUrl = paramMap.toString();
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
    String str1 = "";
    String str2 = str1;
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        str2 = str1;
        if (!localIterator.hasNext()) {
          break;
        }
        str2 = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        localStringBuilder.append("=");
        localStringBuilder.append((String)paramMap.get(str2));
        localStringBuilder.append("&");
        str1 = localStringBuilder.toString();
      }
    }
    this.query = str2;
    if (!TextUtils.isEmpty(this.query))
    {
      paramMap = this.query;
      this.query = paramMap.substring(0, paramMap.length() - 1);
      paramMap = new StringBuilder();
      paramMap.append(this.path);
      paramMap.append("?");
      paramMap.append(this.query);
      this.fullUrl = paramMap.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.URL
 * JD-Core Version:    0.7.0.1
 */