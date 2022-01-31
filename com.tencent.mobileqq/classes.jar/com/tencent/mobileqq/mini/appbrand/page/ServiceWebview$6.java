package com.tencent.mobileqq.mini.appbrand.page;

import android.util.Log;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceWebview$6
  implements Runnable
{
  ServiceWebview$6(ServiceWebview paramServiceWebview, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (this.this$0.mJsContext != null)
    {
      this.this$0.mJsContext.evaluateJavascript(this.val$js, this.val$valueCallback);
      return;
    }
    Log.e("miniapp-start", " mJsContext === null  ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.6
 * JD-Core Version:    0.7.0.1
 */