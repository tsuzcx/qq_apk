package com.tencent.open.appcommon.js;

import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

class BaseInterface$2
  implements Runnable
{
  BaseInterface$2(BaseInterface paramBaseInterface, long paramLong, List paramList, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{'guid':");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject1).append(",'r':0,'data':");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.toString());
    ((StringBuilder)localObject1).append("})};");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    if (localObject2 != null) {}
    try
    {
      ((WebView)localObject2).loadUrl((String)localObject1);
      label69:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Response<callBatch> AsyncInterface result : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      LogUtility.b("BaseInterface", ((StringBuilder)localObject2).toString());
      return;
      LogUtility.e("BaseInterface", "Response<callBatch> AsyncInterface result : webview is null !!!");
      return;
    }
    catch (Exception localException)
    {
      break label69;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface.2
 * JD-Core Version:    0.7.0.1
 */