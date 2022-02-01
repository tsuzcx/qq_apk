package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager.PreCacheDescData;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import org.json.JSONObject;

@JsPlugin
public class PreCacheJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_GET_FETCH_DATA = "getBackgroundFetchData";
  private static final String EVENT_GET_FETCH_TOKEN = "getBackgroundFetchToken";
  private static final String EVENT_SET_FETCH_TOKEN = "setBackgroundFetchToken";
  private static final String TAG = "PreCacheJsPlugin";
  
  @JsEvent({"getBackgroundFetchData"})
  public void getBackgroundFetchData(RequestEvent paramRequestEvent)
  {
    QMLog.d("PreCacheJsPlugin", "call getBackgroundFetchData callbackId:" + paramRequestEvent.callbackId + " PackageToolVersion:" + this.mApkgInfo.mAppConfigInfo.packageToolVersion);
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams).optString("fetchType");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PreCacheManager.g().getPreFetchAppCacheData(this.mApkgInfo.mMiniAppInfo, (String)localObject);
        if ((localObject != null) && (((PreCacheManager.PreCacheDescData)localObject).data != null) && (((PreCacheManager.PreCacheDescData)localObject).data.length > 0))
        {
          String str = new String(((PreCacheManager.PreCacheDescData)localObject).data);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("fetchedData", str);
          localJSONObject.put("timeStamp", ((PreCacheManager.PreCacheDescData)localObject).timeStamp);
          localJSONObject.put("path", ((PreCacheManager.PreCacheDescData)localObject).path);
          localJSONObject.put("scene", AppBrandUtil.getWikiScene(((PreCacheManager.PreCacheDescData)localObject).scene));
          localJSONObject.put("query", ((PreCacheManager.PreCacheDescData)localObject).getQuery());
          paramRequestEvent.ok(localJSONObject);
          return;
        }
        paramRequestEvent.fail("缓存数据不存在");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("PreCacheJsPlugin", "", localThrowable);
      paramRequestEvent.fail("");
      return;
    }
    paramRequestEvent.fail("");
  }
  
  @JsEvent({"getBackgroundFetchToken"})
  public void getBackgroundFetchToken(RequestEvent paramRequestEvent)
  {
    QMLog.d("PreCacheJsPlugin", "call getBackgroundFetchToken callbackId:" + paramRequestEvent.callbackId);
    try
    {
      String str = PreCacheManager.g().getBackgroundFetchToken(this.mApkgInfo.mMiniAppInfo);
      if (!TextUtils.isEmpty(str))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", str);
        paramRequestEvent.ok(localJSONObject);
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("PreCacheJsPlugin", "", localThrowable);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"setBackgroundFetchToken"})
  public void setBackgroundFetchToken(RequestEvent paramRequestEvent)
  {
    QMLog.d("PreCacheJsPlugin", "call setBackgroundFetchToken callbackId:" + paramRequestEvent.callbackId);
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("token");
      if (!TextUtils.isEmpty(str))
      {
        PreCacheManager.g().setBackgroundFetchToken(this.mApkgInfo.mMiniAppInfo, str);
        paramRequestEvent.ok();
        return;
      }
      paramRequestEvent.fail("token is empty!");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("PreCacheJsPlugin", "", localThrowable);
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PreCacheJsPlugin
 * JD-Core Version:    0.7.0.1
 */