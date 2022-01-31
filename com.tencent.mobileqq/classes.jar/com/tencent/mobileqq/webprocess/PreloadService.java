package com.tencent.mobileqq.webprocess;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import mqq.app.AppRuntime;

public class PreloadService
{
  public static WebViewPluginEngine a;
  public static final Object a = new Object();
  public static volatile boolean a;
  public static WebViewPluginEngine b;
  public static volatile boolean b;
  public static volatile boolean c;
  public static volatile boolean d;
  
  public static void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_accelerator_mode_", 3);
    localBundle.putInt("from", paramInt);
    SwiftWebAccelerator.a().a(localBundle);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("ReaderRuntime");
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("VipComicPluginRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.PreloadService
 * JD-Core Version:    0.7.0.1
 */