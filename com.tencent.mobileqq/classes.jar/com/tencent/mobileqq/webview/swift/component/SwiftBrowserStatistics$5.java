package com.tencent.mobileqq.webview.swift.component;

import beiy;
import bekk;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import ndd;

public class SwiftBrowserStatistics$5
  implements Runnable
{
  public SwiftBrowserStatistics$5(beiy parambeiy, TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String[] paramArrayOfString) {}
  
  public void run()
  {
    int k = 1;
    int i;
    int m;
    int n;
    int j;
    label38:
    label48:
    String str;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null)
    {
      i = 1;
      m = QbSdk.getTbsVersion(BaseApplicationImpl.getContext());
      n = WebView.getTbsSDKVersion(BaseApplicationImpl.getContext());
      if (!WebProcessManager.b()) {
        break label138;
      }
      j = 1;
      if (!this.this$0.w) {
        break label143;
      }
      switch (ndd.a())
      {
      case 0: 
      default: 
        str = "";
      }
    }
    for (;;)
    {
      bekk.a(i, m, n, j, k, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.d, this.e, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
      i = 0;
      break;
      label138:
      j = 0;
      break label38;
      label143:
      k = 0;
      break label48;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.5
 * JD-Core Version:    0.7.0.1
 */