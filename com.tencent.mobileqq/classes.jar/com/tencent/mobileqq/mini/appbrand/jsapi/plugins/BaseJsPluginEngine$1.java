package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class BaseJsPluginEngine$1
{
  BaseJsPluginEngine$1(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("BaseJsPluginEngine", 1, "CheckPermission user denied");
    this.this$0.callbackJsEventFail(this.val$webview, this.val$eventName, null, "system permission denied", this.val$callbackId);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("BaseJsPluginEngine", 1, "CheckPermission user grant");
    this.this$0.authorizeCenter.setAuthorize(AuthorizeCenter.getScopeName(this.val$eventName, this.val$jsonParams), true);
    BaseJsPluginEngine.access$000(this.this$0, this.val$eventName, this.val$jsonParams, this.val$webview, this.val$callbackId);
    this.this$0.uiHandler.obtainMessage(4).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */