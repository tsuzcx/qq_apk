package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.utils.WebViewReportUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

class SwiftBrowserStatistics$5
  implements Runnable
{
  SwiftBrowserStatistics$5(SwiftBrowserStatistics paramSwiftBrowserStatistics, TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String[] paramArrayOfString) {}
  
  public void run()
  {
    int k = 1;
    int i;
    int m;
    int n;
    int j;
    label48:
    label58:
    String str;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null)
    {
      i = 1;
      m = QbSdk.getTbsVersion(BaseApplicationImpl.getContext());
      n = WebView.getTbsSDKVersion(BaseApplicationImpl.getContext());
      if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess()) {
        break label150;
      }
      j = 1;
      if (!this.this$0.w) {
        break label155;
      }
      switch (HttpUtil.getNetWorkType())
      {
      case 0: 
      default: 
        str = "";
      }
    }
    for (;;)
    {
      WebViewReportUtils.a(i, m, n, j, k, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.d, this.e, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
      i = 0;
      break;
      label150:
      j = 0;
      break label48;
      label155:
      k = 0;
      break label58;
      str = " UNKNOWN";
      continue;
      str = "WIFI";
      continue;
      str = "2G";
      continue;
      str = "3G";
      continue;
      str = "4G";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.5
 * JD-Core Version:    0.7.0.1
 */