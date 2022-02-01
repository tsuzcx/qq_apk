package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.app.PreCacheManager.PreCacheDescData;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.Set;
import org.json.JSONObject;

public class PreCacheJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_GET_FETCH_DATA = "getBackgroundFetchData";
  private static final String EVENT_GET_FETCH_TOKEN = "getBackgroundFetchToken";
  private static final String EVENT_SET_FETCH_TOKEN = "setBackgroundFetchToken";
  private static final Set<String> S_EVENT_MAP = new PreCacheJsPlugin.1();
  private static final String TAG = "PreCacheJsPlugin";
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("PreCacheJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("setBackgroundFetchToken".equals(paramString1)) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        String str = new JSONObject(paramString2).optString("token");
        if (!TextUtils.isEmpty(str))
        {
          localObject3 = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
          PreCacheManager.g().setBackgroundFetchToken(((ApkgInfo)localObject3).appConfig, str);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, null).toString());
          return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        }
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        continue;
      }
      catch (Throwable localThrowable1)
      {
        QZLog.e("PreCacheJsPlugin", 1, localThrowable1, new Object[0]);
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        continue;
      }
      if ("getBackgroundFetchToken".equals(paramString1))
      {
        try
        {
          Object localObject1 = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
          localObject1 = PreCacheManager.g().getBackgroundFetchToken(((ApkgInfo)localObject1).appConfig);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label302;
          }
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("token", localObject1);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, (JSONObject)localObject3).toString());
        }
        catch (Throwable localThrowable2)
        {
          QZLog.e("PreCacheJsPlugin", 1, localThrowable2, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        }
        continue;
        label302:
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
      }
      else if ("getBackgroundFetchData".equals(paramString1))
      {
        try
        {
          Object localObject2 = new JSONObject(paramString2).optString("fetchType");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label564;
          }
          localObject3 = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
          localObject2 = PreCacheManager.g().getPreFetchAppCacheData(((ApkgInfo)localObject3).appConfig, (String)localObject2);
          if ((localObject2 == null) || (((PreCacheManager.PreCacheDescData)localObject2).data == null) || (((PreCacheManager.PreCacheDescData)localObject2).data.length <= 0)) {
            break label543;
          }
          localObject3 = new String(((PreCacheManager.PreCacheDescData)localObject2).data);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("fetchedData", localObject3);
          localJSONObject.put("timeStamp", ((PreCacheManager.PreCacheDescData)localObject2).timeStamp);
          localJSONObject.put("path", ((PreCacheManager.PreCacheDescData)localObject2).path);
          localJSONObject.put("scene", AppBrandUtil.getWikiScene(((PreCacheManager.PreCacheDescData)localObject2).scene));
          localJSONObject.put("query", ((PreCacheManager.PreCacheDescData)localObject2).getQuery());
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, localJSONObject).toString());
        }
        catch (Throwable localThrowable3)
        {
          QZLog.e("PreCacheJsPlugin", 1, localThrowable3, new Object[0]);
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        }
        continue;
        label543:
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null, "缓存数据不存在").toString());
        continue;
        label564:
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PreCacheJsPlugin
 * JD-Core Version:    0.7.0.1
 */