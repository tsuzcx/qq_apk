package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class WebviewWrapper$1
  implements LiteLiveSdkWebViewBaseBuilder.WebviewStatusListener
{
  WebviewWrapper$1(WebviewWrapper paramWebviewWrapper, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (WebviewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper) == null) {}
    do
    {
      return;
      if (WebviewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper).getVisibility() != 0) {
        WebviewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper).setVisibility(0);
      }
    } while (this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener == null);
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener.onPageFinished();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper.1
 * JD-Core Version:    0.7.0.1
 */