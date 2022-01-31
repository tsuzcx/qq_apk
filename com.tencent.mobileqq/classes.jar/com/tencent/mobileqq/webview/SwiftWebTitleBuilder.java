package com.tencent.mobileqq.webview;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwitchFragmentTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import cooperation.comic.ui.QQComicTitleBarView;

public class SwiftWebTitleBuilder
{
  public static SwiftIphoneTitleBarUI a(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    int j = 0;
    int i = j;
    if (paramSwiftBrowserUIStyleHandler.a != null)
    {
      i = j;
      if (paramSwiftBrowserUIStyleHandler.a.a() != null) {
        i = paramSwiftBrowserUIStyleHandler.a.a().getIntExtra("titleBarStyle", 0);
      }
    }
    if (i == 1) {
      return new QQComicTitleBarView(paramSwiftBrowserUIStyleHandler);
    }
    if (i == 2) {
      return new SwitchFragmentTitleBarUI(paramSwiftBrowserUIStyleHandler);
    }
    return new SwiftIphoneTitleBarUI(paramSwiftBrowserUIStyleHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.SwiftWebTitleBuilder
 * JD-Core Version:    0.7.0.1
 */