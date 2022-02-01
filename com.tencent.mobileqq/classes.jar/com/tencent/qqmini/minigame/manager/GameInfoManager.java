package com.tencent.qqmini.minigame.manager;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.utils.PathUtil;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class GameInfoManager
{
  public static final String EVENT_APP_ENTER_BACKGROUND = "onAppEnterBackground";
  public static final String EVENT_APP_ENTER_FOREGROUND = "onAppEnterForeground";
  public static final String GAME_STOP = "onAppStop";
  private static final String TAG = "GameInfoManager";
  private GameRuntimeLoader gameRuntimeLoader;
  private GameInfoManager.LaunchOptions launchOptions;
  
  public GameInfoManager(GameRuntimeLoader paramGameRuntimeLoader)
  {
    this.gameRuntimeLoader = paramGameRuntimeLoader;
  }
  
  public String getAppId()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.appId;
    }
    QMLog.e("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String getAppName()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if (localMiniAppInfo != null)
    {
      QMLog.i("GameInfoManager", "getAppId() = " + localMiniAppInfo.appId);
      return localMiniAppInfo.name;
    }
    QMLog.e("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String getEntryDataHash()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam.entryModel != null)) {
      return localMiniAppInfo.launchParam.entryModel.getEntryHash();
    }
    return null;
  }
  
  public String getExtendData()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if (localMiniAppInfo != null)
    {
      QMLog.i("GameInfoManager", "getExtendData = " + localMiniAppInfo.extendData);
      if (!TextUtils.isEmpty(localMiniAppInfo.extendData)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.extendData;
  }
  
  public String getFromMiniAppId()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getFromMiniAppId = " + localMiniAppInfo.launchParam.fromMiniAppId);
      if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.fromMiniAppId)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.launchParam.fromMiniAppId;
  }
  
  public String getGroupIdFromReportData()
  {
    Object localObject = getMiniAppInfo();
    if ((localObject != null) && (((MiniAppInfo)localObject).launchParam != null))
    {
      QMLog.i("GameInfoManager", "getGroupIdFromReportData = " + ((MiniAppInfo)localObject).launchParam.reportData);
      localObject = ((MiniAppInfo)localObject).launchParam.reportData;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return PathUtil.getJSONQueryString((String)localObject).optString("groupid", "");
      }
    }
    return "";
  }
  
  public GameInfoManager.LaunchOptions getLaunchOptions()
  {
    if (this.launchOptions == null) {
      return new GameInfoManager.LaunchOptions(this);
    }
    return this.launchOptions;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.gameRuntimeLoader.getMiniAppInfo();
  }
  
  public MiniGamePkg getMiniGamePkg()
  {
    return this.gameRuntimeLoader.getMiniGamePkg();
  }
  
  public String getNavigateExtData()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getNavigateExtData = " + localMiniAppInfo.launchParam.navigateExtData);
      if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.navigateExtData)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.launchParam.navigateExtData;
  }
  
  public JSONObject getOnShowParam()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = getQueryPath();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    int i = getScene();
    String str2 = getShareTicket();
    localObject2 = getFromMiniAppId();
    String str1 = getNavigateExtData();
    String str3 = getEntryDataHash();
    try
    {
      new JSONObject();
      localJSONObject.put("query", localObject1);
      localJSONObject.put("entryDataHash", str3);
    }
    catch (Exception localException2)
    {
      try
      {
        localJSONObject.put("scene", AppBrandUtil.getWikiScene(i));
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localJSONObject.put("shareTicket", str2);
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("appId", localObject2);
              ((JSONObject)localObject1).put("extraData", str1);
              localJSONObject.put("referrerInfo", localObject1);
              return localJSONObject;
            }
            catch (Exception localException4)
            {
              GameLog.getInstance().e("GameInfoManager", "onForeground exception put referrerInfo string :" + localException4);
            }
            localException1 = localException1;
            GameLog.getInstance().e("GameInfoManager", "onForeground exception put query string :" + localException1);
            continue;
            localException2 = localException2;
            GameLog.getInstance().e("GameInfoManager", "onForeground exception put scene string :" + localException2);
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            GameLog.getInstance().e("GameInfoManager", "onForeground exception put shareTicket string :" + localException3);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public JSONObject getQueryPath()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.firstPage != null))
    {
      QMLog.i("GameInfoManager", "getQueryPath = " + localMiniAppInfo.firstPage.pagePath);
      if ("miniGamePath".equals(localMiniAppInfo.firstPage.pagePath)) {
        return new JSONObject();
      }
      return PathUtil.getJSONQueryString(localMiniAppInfo.firstPage.pagePath);
    }
    return new JSONObject();
  }
  
  public int getScene()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getScene = " + localMiniAppInfo.launchParam.scene);
      return localMiniAppInfo.launchParam.scene;
    }
    return 1001;
  }
  
  public String getShareTicket()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getShareTicket = " + localMiniAppInfo.launchParam.shareTicket);
      if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.shareTicket)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.launchParam.shareTicket;
  }
  
  public void resetQuery()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.firstPage != null)) {
      localMiniAppInfo.firstPage.setPagePath(null);
    }
  }
  
  public void setLaunchOptions()
  {
    this.launchOptions = new GameInfoManager.LaunchOptions(this);
    this.launchOptions.scene = getScene();
    this.launchOptions.query = getQueryPath();
    this.launchOptions.shareTicket = getShareTicket();
    this.launchOptions.navigateExtData = getNavigateExtData();
    this.launchOptions.fromMiniAppId = getFromMiniAppId();
    this.launchOptions.entryDataHash = getEntryDataHash();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameInfoManager
 * JD-Core Version:    0.7.0.1
 */