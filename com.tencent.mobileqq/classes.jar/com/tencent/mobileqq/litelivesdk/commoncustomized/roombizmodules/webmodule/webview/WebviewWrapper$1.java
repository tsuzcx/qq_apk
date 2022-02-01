package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class WebviewWrapper$1
  implements LiteLiveSdkWebViewBaseBuilder.WebviewStatusListener
{
  WebviewWrapper$1(WebviewWrapper paramWebviewWrapper, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.a == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.a.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.a.setVisibility(0);
    }
    IWebviewListener localIWebviewListener = this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener;
    if (localIWebviewListener != null) {
      localIWebviewListener.onPageFinished();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    IWebviewListener localIWebviewListener = this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener;
    if (localIWebviewListener != null) {
      localIWebviewListener.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper.1
 * JD-Core Version:    0.7.0.1
 */