package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;

@MiniKeep
public class MiniAppLauncher
{
  private static final String TAG = "MiniAppLauncher";
  private static final String URL_PATTERN_OF_AD_SCHEME = "mqqapi://miniapp/adopen(/[0-9]+)?\\?";
  private static final String URL_PREFIX_HTTP_MINIAPP_AD_REAL_HEAD_SCHEME_V3 = "mqqapi://miniapp/adopen";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V1 = "mqqapi://microapp/open?";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V2 = "mqqapi://miniapp/open?";
  private static final String URL_PREFIX_MINIAPP_HTTP = "http://imgcache.qq.com/channel/mini_app/upgrade.html";
  private static final String URL_PREFIX_MINIAPP_HTTPS = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
  private static final String URL_PREFIX_MINIAPP_URL = "https://m.q.qq.com/a/";
  private static final String URL_PREFIX_MINIAPP_URL_HTTP = "http://m.q.qq.com/a/";
  private static final String URL_PREFIX_WX_MINIAPP_HTTPS = "https://mp.weixin.qq.com/a/";
  
  public static boolean isFakeUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("https://m.q.qq.com/a/")) || (paramString.startsWith("http://m.q.qq.com/a/"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isMiniAppADSchemeV3(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://miniapp/adopen");
  }
  
  public static boolean isMiniAppScheme(String paramString)
  {
    return (isMiniAppSchemeV1(paramString)) || (isMiniAppSchemeV2(paramString)) || (isMiniAppADSchemeV3(paramString));
  }
  
  private static boolean isMiniAppSchemeV1(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://microapp/open?");
  }
  
  public static boolean isMiniAppSchemeV2(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://miniapp/open?");
  }
  
  public static boolean isMiniAppUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((isFakeUrl(paramString)) || (isMiniAppScheme(paramString))) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */