package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class UpdateAppJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "UpdateAppJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public UpdateAppJsPlugin()
  {
    this.eventMap.add("updateQQApp");
  }
  
  private void getAppUpdate(UpdateAppJsPlugin.IAppUpdateListener paramIAppUpdateListener)
  {
    MiniAppController.getInstance().setActivityResultListener(new UpdateAppJsPlugin.2(this, paramIAppUpdateListener));
    paramIAppUpdateListener = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
    paramIAppUpdateListener.putExtra("activity_type", 4096);
    this.jsPluginEngine.appBrandRuntime.activity.startActivityForResult(paramIAppUpdateListener, 1003);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpdateAppJsPlugin", 2, "[handleNativeRequest] event=" + paramString1 + ", jsonParams=" + paramString2 + ", callbackId=" + paramInt);
    }
    if ("updateQQApp".equals(paramString1)) {}
    try
    {
      getAppUpdate(new UpdateAppJsPlugin.1(this, paramJsRuntime, paramString1, paramInt));
      return "";
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("UpdateAppJsPlugin", 1, "Failed to updateQQApp");
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UpdateAppJsPlugin
 * JD-Core Version:    0.7.0.1
 */