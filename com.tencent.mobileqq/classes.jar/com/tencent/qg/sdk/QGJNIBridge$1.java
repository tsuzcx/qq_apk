package com.tencent.qg.sdk;

import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import org.json.JSONObject;

class QGJNIBridge$1
  implements Runnable
{
  QGJNIBridge$1(QGJNIBridge paramQGJNIBridge, BaseJsModule paramBaseJsModule, String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback) {}
  
  public void run()
  {
    if (!this.val$jsModule.handleJsRequest(this.val$method, this.val$paramObj, this.val$callback)) {
      this.val$callback.exec(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJNIBridge.1
 * JD-Core Version:    0.7.0.1
 */