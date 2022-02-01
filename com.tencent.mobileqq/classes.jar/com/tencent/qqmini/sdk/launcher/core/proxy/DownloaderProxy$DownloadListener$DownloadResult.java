package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.support.annotation.NonNull;
import java.util.List;
import java.util.Map;

public class DownloaderProxy$DownloadListener$DownloadResult
{
  public long connectionTimeMs;
  public final long contentLength;
  public long dnsTimeMs;
  @NonNull
  public final Map<String, List<String>> headers;
  public long httpStatusCode;
  public boolean isFromReusedConnection;
  public String message;
  public long queueTimeMs;
  public long receiveTimeMs;
  public boolean success;
  public final long totalTimeMs;
  public String url;
  
  public DownloaderProxy$DownloadListener$DownloadResult(String paramString1, long paramLong1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, @NonNull Map<String, List<String>> paramMap)
  {
    this.url = paramString1;
    this.httpStatusCode = paramLong1;
    this.success = paramBoolean1;
    this.message = paramString2;
    this.isFromReusedConnection = paramBoolean2;
    this.queueTimeMs = paramLong2;
    this.dnsTimeMs = paramLong3;
    this.connectionTimeMs = paramLong4;
    this.receiveTimeMs = paramLong5;
    this.totalTimeMs = paramLong6;
    this.contentLength = paramLong7;
    this.headers = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult
 * JD-Core Version:    0.7.0.1
 */