package com.tencent.mobileqq.mini.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class StringUtil
{
  public static byte[] hexStr2Bytes(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length / 2;
    byte[] arrayOfByte = new byte[m];
    int i = 0;
    while (i < m)
    {
      int j = i * 2;
      int k = Character.digit(paramString[j], 16);
      k = Character.digit(paramString[(j + 1)], 16) | k << 4;
      j = k;
      if (k > 127) {
        j = k - 256;
      }
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String to8BitAsciiString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.appendCodePoint(paramArrayOfByte[i] & 0xFF);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String toJsString(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\f')
      {
        if (c != '\r')
        {
          if ((c != '"') && (c != '/') && (c != '\\')) {}
          switch (c)
          {
          default: 
            if (c <= '\037') {
              localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
            } else {
              localStringBuilder.append(c);
            }
            break;
          case '\n': 
            localStringBuilder.append("\\n");
            break;
          case '\t': 
            localStringBuilder.append("\\t");
            break;
          case '\b': 
            localStringBuilder.append("\\b");
            break;
            localStringBuilder.append('\\');
            localStringBuilder.append(c);
            break;
          }
        }
        else
        {
          localStringBuilder.append("\\r");
        }
      }
      else {
        localStringBuilder.append("\\f");
      }
      i += 1;
    }
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static Map<String, String> toMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */