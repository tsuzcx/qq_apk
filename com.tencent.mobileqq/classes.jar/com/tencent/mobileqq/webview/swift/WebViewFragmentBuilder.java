package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.net.Uri;
import cooperation.comic.ui.QQComicFragment;
import cooperation.qzone.QzoneTranslucentBrowserFragment;

public class WebViewFragmentBuilder
{
  public static WebViewFragment a(SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramWebViewTabBarData.url);
    int i = paramIntent.getIntExtra("fragmentStyle", 0);
    if (i == 2) {
      return QzoneTranslucentBrowserFragment.a(paramIntent);
    }
    if (i == 1) {
      return QQComicFragment.b(paramIntent);
    }
    paramWebViewTabBarData = Uri.parse(paramWebViewTabBarData.url);
    if ((paramWebViewTabBarData.isHierarchical()) && ("4".equals(paramWebViewTabBarData.getQueryParameter("_webviewtype"))))
    {
      paramIntent.putExtra("fragmentStyle", 1);
      paramIntent.putExtra("tabBarStyle", 1);
      paramIntent.putExtra("titleBarStyle", 1);
      paramIntent.putExtra("hide_operation_bar", true);
      paramIntent.putExtra("hide_more_button", true);
      paramIntent.putExtra("isScreenOrientationPortrait", true);
      return QQComicFragment.b(paramIntent);
    }
    if (paramSwiftWebViewFragmentSupporter != null) {
      return paramSwiftWebViewFragmentSupporter.a(paramIntent);
    }
    return WebViewFragment.a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder
 * JD-Core Version:    0.7.0.1
 */