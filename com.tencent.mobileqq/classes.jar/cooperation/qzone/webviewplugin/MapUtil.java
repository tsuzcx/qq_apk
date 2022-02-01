package cooperation.qzone.webviewplugin;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapUtil
{
  public static String covetH5ParamToMap(Map<Integer, Long> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    Long localLong;
    String str;
    if (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      if (localStringBuilder1.length() > 0) {
        localStringBuilder1.append("&");
      }
      localLong = (Long)paramMap.get(localObject);
      str = "";
      if (localObject == null) {
        break label194;
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
        localObject = str;
        if (localLong != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localLong);
          ((StringBuilder)localObject).append("");
          localObject = URLEncoder.encode(((StringBuilder)localObject).toString(), "UTF-8");
        }
        localStringBuilder1.append((String)localObject);
      }
      catch (UnsupportedEncodingException paramMap)
      {
        continue;
      }
      throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
      return localStringBuilder1.toString();
      label194:
      localObject = "";
    }
  }
  
  public static String covetMapToH5Param(Map<Integer, Long> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    Long localLong;
    String str;
    if (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      if (localStringBuilder1.length() > 0) {
        localStringBuilder1.append(",");
      }
      localLong = (Long)paramMap.get(localObject);
      str = "";
      if (localObject == null) {
        break label194;
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
        localStringBuilder1.append("_");
        localObject = str;
        if (localLong != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localLong);
          ((StringBuilder)localObject).append("");
          localObject = URLEncoder.encode(((StringBuilder)localObject).toString(), "UTF-8");
        }
        localStringBuilder1.append((String)localObject);
      }
      catch (UnsupportedEncodingException paramMap)
      {
        continue;
      }
      throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
      return localStringBuilder1.toString();
      label194:
      localObject = "";
    }
  }
  
  public static String mapToString(Map<Integer, Long> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    Long localLong;
    String str;
    if (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      if (localStringBuilder1.length() > 0) {
        localStringBuilder1.append("&");
      }
      localLong = (Long)paramMap.get(localObject);
      str = "";
      if (localObject == null) {
        break label194;
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
        localObject = str;
        if (localLong != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localLong);
          ((StringBuilder)localObject).append("");
          localObject = URLEncoder.encode(((StringBuilder)localObject).toString(), "UTF-8");
        }
        localStringBuilder1.append((String)localObject);
      }
      catch (UnsupportedEncodingException paramMap)
      {
        continue;
      }
      throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
      return localStringBuilder1.toString();
      label194:
      localObject = "";
    }
  }
  
  public static void printMap(Map<Integer, Long> paramMap)
  {
    mapToString(paramMap);
  }
  
  public static Map<Integer, Long> stringToMap(String paramString)
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
        localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), Long.valueOf(URLDecoder.decode(arrayOfString[1], "UTF-8")));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.MapUtil
 * JD-Core Version:    0.7.0.1
 */