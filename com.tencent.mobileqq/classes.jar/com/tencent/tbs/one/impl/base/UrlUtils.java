package com.tencent.tbs.one.impl.base;

import android.text.TextUtils;

public final class UrlUtils
{
  public static final String CONTENT_URL_PREFIX = "content://";
  public static final String FILE_URL_PREFIX = "file://";
  public static final String HTTPS_URL_PREFIX = "https://";
  public static final String HTTP_URL_PREFIX = "http://";
  
  public static boolean isContentScheme(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("content://"));
  }
  
  public static boolean isFileScheme(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("file://"));
  }
  
  public static boolean isHttpOrHttpsScheme(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.UrlUtils
 * JD-Core Version:    0.7.0.1
 */