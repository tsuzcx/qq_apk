package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import bhlq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class BaseJsPluginEngine$1
{
  BaseJsPluginEngine$1(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, String paramString3, BaseActivity paramBaseActivity) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("BaseJsPluginEngine", 1, "CheckPermission user denied");
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool = StorageUtil.getPreference().getBoolean(str + "_" + this.this$0.getAppInfo().appId, false);
    if ((BaseJsPluginEngine.access$100(this.this$0)) && (!bool) && ("android.permission.WRITE_EXTERNAL_STORAGE".equals(this.val$permissionName)))
    {
      bhlq.b(this.val$act);
      StorageUtil.getPreference().edit().putBoolean(str + "_" + this.this$0.getAppInfo().appId, true).commit();
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */