package com.tencent.tgpa.vendorpd.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class h
{
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
    paramString2.setConnectTimeout(10000);
    paramString2.setReadTimeout(10000);
    if (paramString1 != null) {
      paramString2.setRequestMethod(paramString1);
    }
    if (paramMap != null)
    {
      localObject = paramMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        paramString2.addRequestProperty(str, (String)paramMap.get(str));
      }
    }
    if (paramString3 != null)
    {
      paramString2.setDoOutput(true);
      localObject = paramString2.getOutputStream();
      ((OutputStream)localObject).write(paramString3.getBytes());
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
    }
    Object localObject = paramString2.getInputStream();
    String str = a((InputStream)localObject);
    ((InputStream)localObject).close();
    if (paramString2.getResponseCode() == 301) {
      return a(paramString1, paramString2.getHeaderField("Location"), paramString3, paramMap);
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return a("POST", paramString1, paramString2, paramMap);
  }
  
  public static String a(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    Object localObject1 = paramMap2;
    if (paramMap2 == null) {
      localObject1 = new HashMap();
    }
    ((Map)localObject1).put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    paramMap2 = "";
    Object localObject2 = paramMap2;
    if (paramMap1 != null)
    {
      int i = 1;
      Iterator localIterator = paramMap1.keySet().iterator();
      localObject2 = paramMap2;
      if (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          String str = (String)paramMap1.get(localObject2);
          paramMap2 = paramMap2 + URLEncoder.encode((String)localObject2, "UTF-8") + "=";
          paramMap2 = paramMap2 + URLEncoder.encode(str, "UTF-8");
          break;
          paramMap2 = paramMap2 + "&";
        }
      }
    }
    return a(paramString, (String)localObject2, (Map)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.h
 * JD-Core Version:    0.7.0.1
 */