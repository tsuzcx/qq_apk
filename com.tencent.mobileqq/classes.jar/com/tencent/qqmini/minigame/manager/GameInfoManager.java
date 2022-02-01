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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppId() = ");
      localStringBuilder.append(localMiniAppInfo.appId);
      QMLog.i("GameInfoManager", localStringBuilder.toString());
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
    Object localObject = null;
    if (localMiniAppInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getExtendData = ");
      ((StringBuilder)localObject).append(localMiniAppInfo.extendData);
      QMLog.i("GameInfoManager", ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(localMiniAppInfo.extendData)) {
        return null;
      }
      localObject = localMiniAppInfo.extendData;
    }
    return localObject;
  }
  
  public String getFromMiniAppId()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (localMiniAppInfo.launchParam != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFromMiniAppId = ");
        ((StringBuilder)localObject1).append(localMiniAppInfo.launchParam.fromMiniAppId);
        QMLog.i("GameInfoManager", ((StringBuilder)localObject1).toString());
        if (TextUtils.isEmpty(localMiniAppInfo.launchParam.fromMiniAppId)) {
          return null;
        }
        localObject1 = localMiniAppInfo.launchParam.fromMiniAppId;
      }
    }
    return localObject1;
  }
  
  public String getGroupIdFromReportData()
  {
    Object localObject = getMiniAppInfo();
    if ((localObject != null) && (((MiniAppInfo)localObject).launchParam != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGroupIdFromReportData = ");
      localStringBuilder.append(((MiniAppInfo)localObject).launchParam.reportData);
      QMLog.i("GameInfoManager", localStringBuilder.toString());
      localObject = ((MiniAppInfo)localObject).launchParam.reportData;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return PathUtil.getJSONQueryString((String)localObject).optString("groupid", "");
      }
    }
    return "";
  }
  
  public GameInfoManager.LaunchOptions getLaunchOptions()
  {
    GameInfoManager.LaunchOptions localLaunchOptions2 = this.launchOptions;
    GameInfoManager.LaunchOptions localLaunchOptions1 = localLaunchOptions2;
    if (localLaunchOptions2 == null) {
      localLaunchOptions1 = new GameInfoManager.LaunchOptions(this);
    }
    return localLaunchOptions1;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (localMiniAppInfo.launchParam != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getNavigateExtData = ");
        ((StringBuilder)localObject1).append(localMiniAppInfo.launchParam.navigateExtData);
        QMLog.i("GameInfoManager", ((StringBuilder)localObject1).toString());
        if (TextUtils.isEmpty(localMiniAppInfo.launchParam.navigateExtData)) {
          return null;
        }
        localObject1 = localMiniAppInfo.launchParam.navigateExtData;
      }
    }
    return localObject1;
  }
  
  public JSONObject getOnShowParam()
  {
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject2 = getQueryPath();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    int i = getScene();
    Object localObject4 = getShareTicket();
    localObject2 = getFromMiniAppId();
    Object localObject3 = getNavigateExtData();
    Object localObject5 = getEntryDataHash();
    StringBuilder localStringBuilder;
    try
    {
      new JSONObject();
      localJSONObject2.put("query", localObject1);
      localJSONObject2.put("entryDataHash", localObject5);
    }
    catch (Exception localException1)
    {
      localObject5 = GameLog.getInstance();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onForeground exception put query string :");
      localStringBuilder.append(localException1);
      ((GameLog)localObject5).e("GameInfoManager", localStringBuilder.toString());
    }
    try
    {
      localJSONObject2.put("scene", AppBrandUtil.getWikiScene(i));
    }
    catch (Exception localException2)
    {
      localObject5 = GameLog.getInstance();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onForeground exception put scene string :");
      localStringBuilder.append(localException2);
      ((GameLog)localObject5).e("GameInfoManager", localStringBuilder.toString());
    }
    try
    {
      localJSONObject2.put("shareTicket", localObject4);
    }
    catch (Exception localException3)
    {
      localObject4 = GameLog.getInstance();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("onForeground exception put shareTicket string :");
      ((StringBuilder)localObject5).append(localException3);
      ((GameLog)localObject4).e("GameInfoManager", ((StringBuilder)localObject5).toString());
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("appId", localObject2);
      localJSONObject1.put("extraData", localObject3);
      localJSONObject2.put("referrerInfo", localJSONObject1);
      return localJSONObject2;
    }
    catch (Exception localException4)
    {
      localObject2 = GameLog.getInstance();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onForeground exception put referrerInfo string :");
      ((StringBuilder)localObject3).append(localException4);
      ((GameLog)localObject2).e("GameInfoManager", ((StringBuilder)localObject3).toString());
    }
    return localJSONObject2;
  }
  
  public JSONObject getQueryPath()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.firstPage != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQueryPath = ");
      localStringBuilder.append(localMiniAppInfo.firstPage.pagePath);
      QMLog.i("GameInfoManager", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getScene = ");
      localStringBuilder.append(localMiniAppInfo.launchParam.scene);
      QMLog.i("GameInfoManager", localStringBuilder.toString());
      return localMiniAppInfo.launchParam.scene;
    }
    return 1001;
  }
  
  public String getShareTicket()
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (localMiniAppInfo.launchParam != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getShareTicket = ");
        ((StringBuilder)localObject1).append(localMiniAppInfo.launchParam.shareTicket);
        QMLog.i("GameInfoManager", ((StringBuilder)localObject1).toString());
        if (TextUtils.isEmpty(localMiniAppInfo.launchParam.shareTicket)) {
          return null;
        }
        localObject1 = localMiniAppInfo.launchParam.shareTicket;
      }
    }
    return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameInfoManager
 * JD-Core Version:    0.7.0.1
 */