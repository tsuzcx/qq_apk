package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class PreloadPackageJsPlugin
  extends BaseJsPlugin
{
  private final Map<RequestEvent, String> a = new ConcurrentHashMap();
  
  private void a(@NonNull RequestEvent paramRequestEvent, @NonNull PreloadPackageJsPlugin.PreloadResult paramPreloadResult)
  {
    a(paramRequestEvent, paramPreloadResult, null);
  }
  
  private void a(@NonNull RequestEvent paramRequestEvent, @NonNull PreloadPackageJsPlugin.PreloadResult paramPreloadResult, String paramString)
  {
    this.a.remove(paramRequestEvent);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramPreloadResult.code);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("preloadMsg", paramString);
      }
    }
    catch (JSONException paramString)
    {
      QMLog.e("PreloadPackageJsPlugin", "create js callback result fail,", paramString);
    }
    int i = PreloadPackageJsPlugin.3.a[paramPreloadResult.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3) && (i != 4))
      {
        paramRequestEvent.fail(localJSONObject, "");
        return;
      }
      paramRequestEvent.cancel(localJSONObject);
      return;
    }
    paramRequestEvent.ok(localJSONObject);
  }
  
  private void a(@NonNull MiniAppInfo paramMiniAppInfo, @NonNull RequestEvent paramRequestEvent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppInfo);
    localBundle.putBoolean("key_run_in_mainprocess", true);
    AppBrandCmdProxy.g().sendCmd("cmd_main_process_load_pkg", localBundle, new PreloadPackageJsPlugin.2(this, paramRequestEvent));
  }
  
  private void a(String paramString1, String paramString2, RequestEvent paramRequestEvent)
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy == null)
    {
      QMLog.w("PreloadPackageJsPlugin", "get proxy ChannelProxy return null");
      a(paramRequestEvent, PreloadPackageJsPlugin.PreloadResult.GET_APP_INFO_FAIL);
      return;
    }
    localChannelProxy.getAppInfoById(paramString1, "", paramString2, new PreloadPackageJsPlugin.1(this, paramRequestEvent, paramString1));
  }
  
  public void onDestroy()
  {
    this.a.clear();
    super.onDestroy();
  }
  
  @JsEvent({"preloadPackage"})
  public void preloadPackage(RequestEvent paramRequestEvent)
  {
    String str = "";
    if (paramRequestEvent == null)
    {
      QMLog.w("PreloadPackageJsPlugin", "RequestEvent is null");
      return;
    }
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("PreloadPackageJsPlugin", "mMiniAppInfo can't be null.");
      a(paramRequestEvent, PreloadPackageJsPlugin.PreloadResult.INTERNAL_ERROR_NULL_APP_INFO);
      return;
    }
    if ((this.mMiniAppInfo.whiteList != null) && (!this.mMiniAppInfo.whiteList.contains("preloadPackage")))
    {
      QMLog.w("PreloadPackageJsPlugin", "current mini app has no preloadPackage api in its whitelist");
      a(paramRequestEvent, PreloadPackageJsPlugin.PreloadResult.PERMISSION_FAIL_WHITELIST);
      return;
    }
    try
    {
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      localObject3 = ((JSONObject)localObject1).getString("appId");
    }
    catch (JSONException localJSONException1)
    {
      Object localObject1;
      label111:
      break label111;
    }
    try
    {
      localObject1 = ((JSONObject)localObject1).optString("envVersion");
    }
    catch (JSONException localJSONException2)
    {
      Object localObject2 = localObject3;
      break label114;
    }
    localObject1 = "";
    label114:
    QMLog.e("PreloadPackageJsPlugin", "fail to get appId from jsonParams");
    localObject3 = localObject1;
    localObject1 = str;
    if ("release".equals(this.mMiniAppInfo.getVerTypeStr())) {
      localObject1 = "release";
    }
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("no appId in jsonParams: ");
      ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
      QMLog.w("PreloadPackageJsPlugin", ((StringBuilder)localObject1).toString());
      a(paramRequestEvent, PreloadPackageJsPlugin.PreloadResult.PARAM_ERROR_NO_APPID);
      return;
    }
    if (this.a.containsValue(localObject3))
    {
      if (QMLog.isColorLevel()) {
        QMLog.i("PreloadPackageJsPlugin", "app id $appId is preloading...");
      }
      a(paramRequestEvent, PreloadPackageJsPlugin.PreloadResult.PRELOAD_IN_PROGRESS);
      return;
    }
    this.a.put(paramRequestEvent, localObject3);
    a((String)localObject3, (String)localObject1, paramRequestEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PreloadPackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */