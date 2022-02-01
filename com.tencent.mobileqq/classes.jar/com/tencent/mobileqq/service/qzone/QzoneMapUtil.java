package com.tencent.mobileqq.service.qzone;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QzoneMapUtil
{
  public static String a(Map<Integer, String> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    String str2;
    String str1;
    if (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      if (localStringBuilder1.length() > 0) {
        localStringBuilder1.append("&");
      }
      str2 = (String)paramMap.get(localObject);
      str1 = "";
      if (localObject == null) {
        break label170;
      }
    }
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localObject);
        localStringBuilder2.append("");
        localObject = URLEncoder.encode(localStringBuilder2.toString(), "UTF-8");
        localStringBuilder1.append((String)localObject);
        localStringBuilder1.append("=");
        localObject = str1;
        if (str2 != null) {
          localObject = URLEncoder.encode(str2, "UTF-8");
        }
        localStringBuilder1.append((String)localObject);
      }
      catch (UnsupportedEncodingException paramMap)
      {
        continue;
      }
      throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
      return localStringBuilder1.toString();
      label170:
      localObject = "";
    }
  }
  
  public static Map<Integer, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {}
      try
      {
        localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), URLDecoder.decode(arrayOfString[1], "UTF-8"));
        i += 1;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new RuntimeException("This method requires UTF-8 encoding support", paramString);
      }
    }
    return localHashMap;
  }
  
  public static Map<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {}
      try
      {
        localHashMap.put(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
        i += 1;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new RuntimeException("This method requires UTF-8 encoding support", paramString);
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QzoneMapUtil
 * JD-Core Version:    0.7.0.1
 */