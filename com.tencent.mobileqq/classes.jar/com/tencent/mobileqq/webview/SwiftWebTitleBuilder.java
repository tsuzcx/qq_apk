package com.tencent.mobileqq.webview;

import android.content.Intent;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleTitleBarView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwitchFragmentTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import cooperation.comic.ui.QQComicTitleBarView;
import cooperation.qqreader.utils.Log;
import cooperation.qqreader.view.ReaderTitleBarView;

public class SwiftWebTitleBuilder
{
  public static SwiftIphoneTitleBarUI a(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    int j = 0;
    int i = j;
    if (paramSwiftBrowserUIStyleHandler.a != null)
    {
      i = j;
      if (paramSwiftBrowserUIStyleHandler.a.getIntent() != null) {
        i = paramSwiftBrowserUIStyleHandler.a.getIntent().getIntExtra("titleBarStyle", 0);
      }
    }
    Log.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new QQComicTitleBarView(paramSwiftBrowserUIStyleHandler);
    }
    if (i == 2) {
      return new SwitchFragmentTitleBarUI(paramSwiftBrowserUIStyleHandler);
    }
    if (i == 3) {
      return new ReaderTitleBarView(paramSwiftBrowserUIStyleHandler);
    }
    if (i == 4) {
      return new QCircleTitleBarView(paramSwiftBrowserUIStyleHandler);
    }
    return new SwiftIphoneTitleBarUI(paramSwiftBrowserUIStyleHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.SwiftWebTitleBuilder
 * JD-Core Version:    0.7.0.1
 */