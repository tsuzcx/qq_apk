package com.tencent.mobileqq.webview;

import android.content.Intent;
import bieo;
import biey;
import blsc;
import bmgm;
import bmgx;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import cooperation.qqcircle.hybird.QCircleTitleBarView;

public class SwiftWebTitleBuilder
{
  public static final String KEY_TITLE_BAR_STYLE = "titleBarStyle";
  private static final String TAG = "SwiftWebTitleBuilder";
  public static final int TITLE_BAR_STYLE_COMIC = 1;
  public static final int TITLE_BAR_STYLE_DEFAULT = 0;
  public static final int TITLE_BAR_STYLE_QQ_CIRCLE = 4;
  public static final int TITLE_BAR_STYLE_READER = 3;
  public static final int TITLE_BAR_STYLE_SWITCH_FRAGMENT = 2;
  
  public static bieo createTitleBar(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    int j = 0;
    int i = j;
    if (paramSwiftBrowserUIStyleHandler.mHostFragment != null)
    {
      i = j;
      if (paramSwiftBrowserUIStyleHandler.mHostFragment.getIntent() != null) {
        i = paramSwiftBrowserUIStyleHandler.mHostFragment.getIntent().getIntExtra("titleBarStyle", 0);
      }
    }
    bmgm.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new blsc(paramSwiftBrowserUIStyleHandler);
    }
    if (i == 2) {
      return new biey(paramSwiftBrowserUIStyleHandler);
    }
    if (i == 3) {
      return new bmgx(paramSwiftBrowserUIStyleHandler);
    }
    if (i == 4) {
      return new QCircleTitleBarView(paramSwiftBrowserUIStyleHandler);
    }
    return new bieo(paramSwiftBrowserUIStyleHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.SwiftWebTitleBuilder
 * JD-Core Version:    0.7.0.1
 */