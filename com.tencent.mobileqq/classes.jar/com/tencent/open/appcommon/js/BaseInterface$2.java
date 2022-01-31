package com.tencent.open.appcommon.js;

import bflp;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

class BaseInterface$2
  implements Runnable
{
  BaseInterface$2(BaseInterface paramBaseInterface, long paramLong, List paramList, WebView paramWebView) {}
  
  public void run()
  {
    String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{'guid':" + this.jdField_a_of_type_Long + ",'r':0,'data':" + this.jdField_a_of_type_JavaUtilList.toString() + "})};";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(str);
      label58:
      bflp.b("BaseInterface", "Response<callBatch> AsyncInterface result : " + str);
      return;
      bflp.e("BaseInterface", "Response<callBatch> AsyncInterface result : webview is null !!!");
      return;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface.2
 * JD-Core Version:    0.7.0.1
 */