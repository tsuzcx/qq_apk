package com.tencent.mobileqq.webview.swift.utils;

import android.os.SystemClock;

public class SwiftOfflineDataUtils$OfflineData
{
  public final String a;
  public final String b;
  public final String c;
  final long d;
  
  SwiftOfflineDataUtils$OfflineData(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = SystemClock.elapsedRealtime();
  }
  
  boolean a()
  {
    return SystemClock.elapsedRealtime() - this.d > 300000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData
 * JD-Core Version:    0.7.0.1
 */