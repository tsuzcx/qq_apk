package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

public class LifeCyclePlugin
  extends BaseJsPlugin
{
  public static final String EVENT_APP_ENTER_BACKGROUND = "onAppEnterBackground";
  public static final String EVENT_APP_ENTER_FOREGROUND = "onAppEnterForeground";
  private static final String TAG = "LifeCyclePlugin";
  public static boolean noNeedToCallback;
  private GameLifecycle mGameLifecycle = new LifeCyclePlugin.1(this);
  
  public String getEntryDataHash()
  {
    return GameInfoManager.g().getEntryDataHash();
  }
  
  public String getFromMiniAppId()
  {
    return GameInfoManager.g().getFromMiniAppId();
  }
  
  public String getNavigateExtData()
  {
    return GameInfoManager.g().getNavigateExtData();
  }
  
  public JSONObject getQuery()
  {
    JSONObject localJSONObject2 = GameInfoManager.g().getQueryPath();
    JSONObject localJSONObject1 = localJSONObject2;
    if (localJSONObject2 == null) {
      localJSONObject1 = new JSONObject();
    }
    return localJSONObject1;
  }
  
  public int getScene()
  {
    return GameInfoManager.g().getScene();
  }
  
  public String getShareTicket()
  {
    return GameInfoManager.g().getShareTicket();
  }
  
  public void onBackground()
  {
    if ((!noNeedToCallback) && ((GameJsPluginEngine)this.jsPluginEngine != null)) {
      this.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onAppEnterBackground", "", -1);
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    paramBaseJsPluginEngine = GameLoadManager.g().getGameEngine();
    if (paramBaseJsPluginEngine != null)
    {
      paramBaseJsPluginEngine.addGameLifeCycle(this.mGameLifecycle);
      return;
    }
    GameLog.getInstance().e("LifeCyclePlugin", "addGameLifeCycle on null GameEngine");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onForeground()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = getQuery();
    int i = getScene();
    Object localObject = getShareTicket();
    String str1 = getFromMiniAppId();
    String str2 = getNavigateExtData();
    String str3 = getEntryDataHash();
    try
    {
      new JSONObject();
      localJSONObject1.put("query", localJSONObject2);
      localJSONObject1.put("entryDataHash", str3);
    }
    catch (Exception localException2)
    {
      try
      {
        localJSONObject1.put("scene", AppBrandUtil.getWikiScene(i));
      }
      catch (Exception localException2)
      {
        try
        {
          localJSONObject1.put("shareTicket", localObject);
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("appId", str1);
              ((JSONObject)localObject).put("extraData", str2);
              localJSONObject1.put("referrerInfo", localObject);
              if ((!noNeedToCallback) && ((GameJsPluginEngine)this.jsPluginEngine != null))
              {
                GameLog.getInstance().i("LifeCyclePlugin", "onshow(" + localJSONObject1.toString() + ")");
                this.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onAppEnterForeground", localJSONObject1.toString(), -1);
              }
              return;
              localException3 = localException3;
              GameLog.getInstance().e("LifeCyclePlugin", "onForeground exception put query string :" + localException3);
              continue;
              localException4 = localException4;
              GameLog.getInstance().e("LifeCyclePlugin", "onForeground exception put scene string :" + localException4);
              continue;
              localException2 = localException2;
              GameLog.getInstance().e("LifeCyclePlugin", "onForeground exception put shareTicket string :" + localException2);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              GameLog.getInstance().e("LifeCyclePlugin", "onForeground exception put referrerInfo string :" + localException1);
            }
          }
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return Collections.emptySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.LifeCyclePlugin
 * JD-Core Version:    0.7.0.1
 */