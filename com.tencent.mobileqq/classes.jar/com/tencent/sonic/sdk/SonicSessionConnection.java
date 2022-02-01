package com.tencent.sonic.sdk;

import android.content.Intent;
import java.io.BufferedInputStream;
import java.util.List;
import java.util.Map;

public abstract class SonicSessionConnection
{
  public static final String CUSTOM_HEAD_FILED_ACCEPT_DIFF = "accept-diff";
  public static final String CUSTOM_HEAD_FILED_CACHE_OFFLINE = "cache-offline";
  public static final String CUSTOM_HEAD_FILED_DNS_PREFETCH = "sonic-dns-prefetch";
  public static final String CUSTOM_HEAD_FILED_ETAG = "eTag";
  public static final String CUSTOM_HEAD_FILED_HTML_SHA1 = "sonic-html-sha1";
  public static final String CUSTOM_HEAD_FILED_LINK = "sonic-link";
  public static final String CUSTOM_HEAD_FILED_SDK_VERSION = "sonic-sdk-version";
  public static final String CUSTOM_HEAD_FILED_SONIC_DATA_CHUNK = "X-sonic-chunk";
  public static final String CUSTOM_HEAD_FILED_TEMPLATE_CHANGE = "template-change";
  public static final String CUSTOM_HEAD_FILED_TEMPLATE_TAG = "template-tag";
  public static final String DNS_PREFETCH_ADDRESS = "dns-prefetch-address";
  public static final String HTTP_HEAD_CSP = "Content-Security-Policy";
  public static final String HTTP_HEAD_CSP_REPORT_ONLY = "Content-Security-Policy-Report-Only";
  public static final String HTTP_HEAD_FIELD_CACHE_CONTROL = "Cache-Control";
  public static final String HTTP_HEAD_FIELD_CONTENT_LENGTH = "Content-Length";
  public static final String HTTP_HEAD_FIELD_CONTENT_TYPE = "Content-Type";
  public static final String HTTP_HEAD_FIELD_COOKIE = "Cookie";
  public static final String HTTP_HEAD_FIELD_EXPIRES = "Expires";
  public static final String HTTP_HEAD_FIELD_PRAGMA = "Pragma";
  public static final String HTTP_HEAD_FILED_IF_NOT_MATCH = "If-None-Match";
  public static final String HTTP_HEAD_FILED_SET_COOKIE = "Set-Cookie";
  public static final String HTTP_HEAD_FILED_USER_AGENT = "User-Agent";
  private static final String TAG = "SonicSdk_SonicSessionConnection";
  protected final Intent intent;
  protected BufferedInputStream responseStream;
  protected final SonicSession session;
  
  public SonicSessionConnection(SonicSession paramSonicSession, Intent paramIntent)
  {
    this.session = paramSonicSession;
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    this.intent = paramIntent;
  }
  
  public int connect()
  {
    try
    {
      int i = internalConnect();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void disconnect();
  
  public abstract int getResponseCode();
  
  public abstract String getResponseHeaderField(String paramString);
  
  public abstract Map<String, List<String>> getResponseHeaderFields();
  
  public BufferedInputStream getResponseStream()
  {
    try
    {
      if (this.responseStream == null) {
        this.responseStream = internalGetResponseStream();
      }
      BufferedInputStream localBufferedInputStream = this.responseStream;
      return localBufferedInputStream;
    }
    finally {}
  }
  
  protected abstract int internalConnect();
  
  protected abstract BufferedInputStream internalGetResponseStream();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection
 * JD-Core Version:    0.7.0.1
 */