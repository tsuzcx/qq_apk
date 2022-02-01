package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class SubpackageJsPlugin
  extends BaseJsPlugin
{
  public static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
  public static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
  private static final Set<String> S_EVENT_MAP = new SubpackageJsPlugin.1();
  private static final String TAG = "SubpackageJsPlugin";
  private AtomicInteger subpackageTaskId = new AtomicInteger(0);
  
  private void callbackLoadSubPackageFinish(WeakReference<JsRuntime> paramWeakReference, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (paramWeakReference != null)
    {
      paramWeakReference = (JsRuntime)paramWeakReference.get();
      if (paramWeakReference != null) {
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("taskId", paramInt);
        if (!paramBoolean) {
          continue;
        }
        str = "success";
        localJSONObject.put("state", str);
      }
      catch (JSONException localJSONException)
      {
        String str;
        localJSONException.printStackTrace();
        continue;
      }
      paramWeakReference.evaluateSubcribeJS("onLoadSubPackageTaskStateChange", localJSONObject.toString(), -1);
      return;
      paramWeakReference = null;
      break;
      str = "fail";
    }
  }
  
  private String doCreateLoadSubpackageTask4MiniApp(String paramString, JSONObject paramJSONObject, WeakReference<JsRuntime> paramWeakReference, int paramInt)
  {
    String str = paramJSONObject.optString("moduleName");
    paramInt = this.subpackageTaskId.getAndIncrement();
    paramJSONObject = new JSONObject();
    try
    {
      this.jsPluginEngine.appBrandRuntime.getApkgInfo().downloadSubPack(str, new SubpackageJsPlugin.2(this, paramWeakReference, paramInt, str));
      paramJSONObject.put("loadTaskId", paramInt);
      paramWeakReference = ApiUtil.wrapCallbackOk(paramString, paramJSONObject).toString();
      return paramWeakReference;
    }
    catch (Throwable paramWeakReference)
    {
      paramWeakReference.printStackTrace();
    }
    return ApiUtil.wrapCallbackFail(paramString, paramJSONObject).toString();
  }
  
  private String doCreateLoadSubpackageTask4MiniGame(String paramString, JSONObject paramJSONObject, WeakReference<JsRuntime> paramWeakReference, int paramInt)
  {
    paramInt = this.subpackageTaskId.getAndIncrement();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("name", null);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = new JSONObject();
        try
        {
          paramJSONObject.put("loadTaskId", paramInt);
          paramJSONObject.put("state", "fail");
          return ApiUtil.wrapCallbackFail(paramString, paramJSONObject).toString();
          paramJSONObject = null;
        }
        catch (JSONException paramWeakReference)
        {
          for (;;)
          {
            paramWeakReference.printStackTrace();
          }
        }
      }
    }
    GameRuntimeLoader localGameRuntimeLoader = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
    MiniGamePkg localMiniGamePkg;
    if (localGameRuntimeLoader != null) {
      localMiniGamePkg = localGameRuntimeLoader.getGameInfoManager().getMiniGamePkg();
    }
    for (;;)
    {
      if (localMiniGamePkg != null)
      {
        ThreadManagerV2.excute(new SubpackageJsPlugin.3(this, paramWeakReference, paramInt, paramJSONObject, localGameRuntimeLoader, localMiniGamePkg), 16, null, false);
        paramJSONObject = new JSONObject();
        try
        {
          paramJSONObject.put("loadTaskId", paramInt);
          return ApiUtil.wrapCallbackOk(paramString, paramJSONObject).toString();
          localMiniGamePkg = null;
        }
        catch (JSONException paramWeakReference)
        {
          for (;;)
          {
            paramWeakReference.printStackTrace();
          }
        }
      }
    }
    return ApiUtil.wrapCallbackFail(paramString, null, "found no miniGamePkg error").toString();
  }
  
  private void downloadSubpackageAndLoad(WeakReference<JsRuntime> paramWeakReference, int paramInt1, String paramString, GameRuntimeLoader paramGameRuntimeLoader, MiniGamePkg paramMiniGamePkg, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramGameRuntimeLoader == null) || (paramMiniGamePkg == null)) {
      return;
    }
    int i = GameWnsUtils.retryLoadSubpackageOnCompileCount();
    if (paramInt2 > i)
    {
      GameLog.getInstance().i("SubpackageJsPlugin", "loadSubPackage:" + paramString + ", reach maxTryCount:" + i);
      callbackLoadSubPackageFinish(paramWeakReference, paramInt1, false);
      return;
    }
    GameLog.getInstance().i("SubpackageJsPlugin", "start loadSubPackage:" + paramString + ", gameId:" + paramMiniGamePkg.appId + ", gameName:" + paramMiniGamePkg.apkgName + ", tryCount:" + paramInt2);
    paramMiniGamePkg.downloadSubPack(paramString, new SubpackageJsPlugin.4(this, paramString, paramWeakReference, paramInt1, paramGameRuntimeLoader, paramMiniGamePkg, paramInt2));
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("SubpackageJsPlugin", 1, "handleScriptRequest() called with: eventName = [" + paramString1 + "], jsonParams = [" + paramString2 + "], callbackId = [" + paramInt + "], jsRuntime = [" + paramJsRuntime + "]");
    WeakReference localWeakReference = new WeakReference(paramJsRuntime);
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString2);
      if ("createLoadSubPackageTask".equals(paramString1)) {
        if (this.isGameRuntime) {
          return doCreateLoadSubpackageTask4MiniGame(paramString1, localJSONObject1, localWeakReference, paramInt);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      JSONObject localJSONObject2;
      for (;;)
      {
        localJSONObject2 = new JSONObject();
      }
      return doCreateLoadSubpackageTask4MiniApp(paramString1, localJSONObject2, localWeakReference, paramInt);
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */