package com.tencent.open.appcommon.js;

import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class BaseInterface$3
  implements Runnable
{
  BaseInterface$3(BaseInterface paramBaseInterface, long paramLong, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{guid:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(",'r':-2,'data':['");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("']})};");
    localObject = ((StringBuilder)localObject).toString();
    LogUtility.e("Response<callBatch>", (String)localObject);
    try
    {
      this.c.loadUrl((String)localObject);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface.3
 * JD-Core Version:    0.7.0.1
 */