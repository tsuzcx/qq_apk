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
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      Long localLong = (Long)paramMap.get(localObject);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          localObject = URLEncoder.encode(localObject + "", "UTF-8");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("=");
          if (localLong == null) {
            break label165;
          }
          localObject = URLEncoder.encode(localLong + "", "UTF-8");
          localStringBuilder.append((String)localObject);
        }
        catch (UnsupportedEncodingException paramMap)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
        }
        localObject = "";
        continue;
        label165:
        localObject = "";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String covetMapToH5Param(Map<Integer, Long> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(",");
      }
      Long localLong = (Long)paramMap.get(localObject);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          localObject = URLEncoder.encode(localObject + "", "UTF-8");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("_");
          if (localLong == null) {
            break label165;
          }
          localObject = URLEncoder.encode(localLong + "", "UTF-8");
          localStringBuilder.append((String)localObject);
        }
        catch (UnsupportedEncodingException paramMap)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
        }
        localObject = "";
        continue;
        label165:
        localObject = "";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String mapToString(Map<Integer, Long> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      Long localLong = (Long)paramMap.get(localObject);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          localObject = URLEncoder.encode(localObject + "", "UTF-8");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("=");
          if (localLong == null) {
            break label165;
          }
          localObject = URLEncoder.encode(localLong + "", "UTF-8");
          localStringBuilder.append((String)localObject);
        }
        catch (UnsupportedEncodingException paramMap)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
        }
        localObject = "";
        continue;
        label165:
        localObject = "";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void printMap(Map<Integer, Long> paramMap)
  {
    mapToString(paramMap);
  }
  
  public static Map<Integer, Long> stringToMap(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length != 2) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), Long.valueOf(URLDecoder.decode(arrayOfString[1], "UTF-8")));
        }
        catch (UnsupportedEncodingException paramString)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramString);
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.MapUtil
 * JD-Core Version:    0.7.0.1
 */