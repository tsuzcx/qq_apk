package com.tencent.mobileqq.webview;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.temp.api.IWebViewOpenSdkApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

class AbsWebView$2
  implements DownloadListener
{
  AbsWebView$2(AbsWebView paramAbsWebView) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "start UniformDownloadActivity");
    }
    String str = this.a.mWebview.getUrl();
    ((IWebViewOpenSdkApi)QRoute.api(IWebViewOpenSdkApi.class)).downloadUrlByUniformDownload(paramString1, paramString2, paramString3, paramString4, paramLong, this.a.mInActivity, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.2
 * JD-Core Version:    0.7.0.1
 */