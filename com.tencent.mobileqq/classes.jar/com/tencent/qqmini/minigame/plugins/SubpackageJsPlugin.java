package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.annotation.Restriction;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(restriction=Restriction.RESTRICT_TO_MINI_GAME)
public class SubpackageJsPlugin
  extends BaseJsPlugin
{
  public static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
  public static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
  private static final String TAG = "SubpackageJsPlugin";
  private AtomicInteger subpackageTaskId = new AtomicInteger(0);
  
  private void callbackLoadSubPackageFinish(RequestEvent paramRequestEvent, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (paramRequestEvent != null) {
      localJSONObject = new JSONObject();
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
      paramRequestEvent.jsService.evaluateSubscribeJS("onLoadSubPackageTaskStateChange", localJSONObject.toString(), -1);
      return;
      str = "fail";
    }
  }
  
  private void downloadSubpackageAndLoad(RequestEvent paramRequestEvent, int paramInt1, String paramString, MiniGamePkg paramMiniGamePkg, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramRequestEvent == null) || (paramMiniGamePkg == null)) {
      return;
    }
    int i = GameWnsUtils.retryLoadSubpackageOnCompileCount();
    if (paramInt2 > i)
    {
      GameLog.getInstance().i("SubpackageJsPlugin", "loadSubPackage:" + paramString + ", reach maxTryCount:" + i);
      callbackLoadSubPackageFinish(paramRequestEvent, paramInt1, false);
      return;
    }
    GameLog.getInstance().i("SubpackageJsPlugin", "start loadSubPackage:" + paramString + ", gameId:" + paramMiniGamePkg.appId + ", gameName:" + paramMiniGamePkg.apkgName);
    paramMiniGamePkg.downloadSubPack(this.mMiniAppInfo, paramString, new SubpackageJsPlugin.2(this, paramString, paramRequestEvent, paramInt1, paramMiniGamePkg, paramInt2));
  }
  
  @JsEvent({"createLoadSubPackageTask"})
  public String createLoadSubPackageTask(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      i = this.subpackageTaskId.getAndIncrement();
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).optString("name", null);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label103;
        }
        localObject1 = new JSONObject();
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      JSONObject localJSONObject;
      try
      {
        for (;;)
        {
          Object localObject1;
          ((JSONObject)localObject1).put("loadTaskId", i);
          ((JSONObject)localObject1).put("state", "fail");
          return ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1).toString();
          localThrowable = localThrowable;
          localJSONObject = new JSONObject();
        }
        localJSONObject = null;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
      label103:
      Object localObject2 = GetGameInfoManager.obtain(this.mMiniAppContext);
      if (localObject2 != null) {
        localObject2 = ((GameInfoManager)localObject2).getMiniGamePkg();
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          ThreadManager.executeOnNetworkIOThreadPool(new SubpackageJsPlugin.1(this, paramRequestEvent, i, localJSONObject, (MiniGamePkg)localObject2));
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("loadTaskId", i);
            return ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
            localObject2 = null;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              localJSONException2.printStackTrace();
            }
          }
        }
      }
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "found no miniGamePkg error").toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */