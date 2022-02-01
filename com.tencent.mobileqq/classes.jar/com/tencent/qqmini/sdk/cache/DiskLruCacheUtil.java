package com.tencent.qqmini.sdk.cache;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;

public final class DiskLruCacheUtil
{
  static final Charset US_ASCII = Charset.forName("US-ASCII");
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static String[] decode(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(":");
      if (i != -1)
      {
        int j = paramString.length();
        int k = i + 1;
        if (j > k) {
          return new String[] { paramString.substring(0, i), paramString.substring(k) };
        }
      }
    }
    return null;
  }
  
  static void deleteContents(File paramFile)
  {
    Object localObject = paramFile.listFiles();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramFile = localObject[i];
        if (paramFile.isDirectory()) {
          deleteContents(paramFile);
        }
        if (paramFile.delete())
        {
          i += 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to delete file: ");
          ((StringBuilder)localObject).append(paramFile);
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not a readable directory: ");
    ((StringBuilder)localObject).append(paramFile);
    paramFile = new IOException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramFile;
    }
  }
  
  public static String dencrypt(String paramString)
  {
    return null;
  }
  
  public static String encode(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String encrypt(String paramString)
  {
    return null;
  }
  
  static String readFully(Reader paramReader)
  {
    try
    {
      Object localObject1 = new StringWriter();
      char[] arrayOfChar = new char[1024];
      for (;;)
      {
        int i = paramReader.read(arrayOfChar);
        if (i == -1) {
          break;
        }
        ((StringWriter)localObject1).write(arrayOfChar, 0, i);
      }
      localObject1 = ((StringWriter)localObject1).toString();
      paramReader.close();
      return localObject1;
    }
    finally
    {
      paramReader.close();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static JSONArray setToJSONArray(Set paramSet)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramSet != null)
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        localJSONArray.put(paramSet.next());
      }
    }
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.DiskLruCacheUtil
 * JD-Core Version:    0.7.0.1
 */