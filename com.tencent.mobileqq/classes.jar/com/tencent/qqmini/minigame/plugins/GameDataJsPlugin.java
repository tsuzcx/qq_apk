package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameInfoManager.LaunchOptions;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class GameDataJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "GameDataJsPlugin";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  private boolean checkNavigationAppIdListForMiniGame(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = GetGameInfoManager.obtain(this.mMiniAppContext).getMiniGamePkg();
      if (localObject == null) {
        continue;
      }
      try
      {
        localObject = ((MiniGamePkg)localObject).mGameConfigJson.optJSONArray("navigateToMiniProgramAppIdList");
        int i = 0;
        while ((localObject != null) && (i < paramString.length()))
        {
          boolean bool = paramString.equals(((JSONArray)localObject).getString(i));
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  @JsEvent({"getLaunchOptionsSync"})
  public String getLaunchOptionsSync(RequestEvent paramRequestEvent)
  {
    Object localObject2 = null;
    GameInfoManager localGameInfoManager = GetGameInfoManager.obtain(this.mMiniAppContext);
    GameInfoManager.LaunchOptions localLaunchOptions = localGameInfoManager.getLaunchOptions();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(localLaunchOptions.fromMiniAppId))
      {
        localObject1 = null;
        localJSONObject2.put("appId", localObject1);
        if (!TextUtils.isEmpty(localLaunchOptions.navigateExtData)) {
          break label182;
        }
        localObject1 = null;
        label71:
        localJSONObject2.put("extraData", localObject1);
        localJSONObject1.put("scene", AppBrandUtil.getWikiScene(localLaunchOptions.scene));
        localJSONObject1.put("query", localLaunchOptions.query);
        if (!TextUtils.isEmpty(localLaunchOptions.shareTicket)) {
          break label191;
        }
      }
      label182:
      label191:
      for (Object localObject1 = localObject2;; localObject1 = localLaunchOptions.shareTicket)
      {
        localJSONObject1.put("shareTicket", localObject1);
        localJSONObject1.put("referrerInfo", localJSONObject2);
        localJSONObject1.put("extendData", localGameInfoManager.getExtendData());
        localJSONObject1.put("entryDataHash", localLaunchOptions.entryDataHash);
        return localJSONObject1.toString();
        localObject1 = localLaunchOptions.fromMiniAppId;
        break;
        localObject1 = localLaunchOptions.navigateExtData;
        break label71;
      }
      return paramRequestEvent.fail();
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("GameDataJsPlugin", "API_GET_LAUNCH_OPTIONS_SYNC exception: ", localJSONException);
    }
  }
  
  @JsEvent({"getOpenDataUserInfo"})
  public void getOpenDataUserInfo(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("openIdList");
      localObject = ((JSONObject)localObject).optString("lang", "en");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = localJSONArray.getString(i);
          i += 1;
        }
        this.mChannelProxy.getUserInfoOpenData(this.mMiniAppInfo.appId, (String)localObject, arrayOfString, new GameDataJsPlugin.1(this, paramRequestEvent));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      paramRequestEvent.fail();
      QMLog.e("GameDataJsPlugin", "handle event:" + paramRequestEvent.event + " error , ", localJSONException);
    }
  }
  
  @JsEvent({"navigateToMiniProgramConfig"})
  public String navigateToMiniProgramConfig(RequestEvent paramRequestEvent)
  {
    try
    {
      boolean bool = checkNavigationAppIdListForMiniGame(new JSONObject(paramRequestEvent.jsonParams).optString("appId"));
      paramRequestEvent = new JSONObject();
      try
      {
        paramRequestEvent.put("inList", bool);
        QMLog.d("GameDataJsPlugin", "navigateToMiniProgramConfig, callJs jsonObject = " + paramRequestEvent);
        return paramRequestEvent.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QMLog.e("GameDataJsPlugin", localJSONException.getMessage(), localJSONException);
          localJSONException.printStackTrace();
        }
      }
      return "";
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("GameDataJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      paramRequestEvent.printStackTrace();
    }
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    if (!this.mIsMiniGame) {
      return true;
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"recordOffLineResourceState"})
  public void recordOffLineResourceState(RequestEvent paramRequestEvent)
  {
    try
    {
      boolean bool = new JSONObject(paramRequestEvent.jsonParams).optBoolean("isComplete", false);
      GpkgManager.setOfflineResourceContent(this.mMiniAppInfo, bool);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("GameDataJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */