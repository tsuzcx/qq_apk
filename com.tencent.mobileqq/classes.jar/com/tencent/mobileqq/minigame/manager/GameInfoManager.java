package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import bhel;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;

public class GameInfoManager
{
  public static final String EVENT_APP_ENTER_BACKGROUND = "onAppEnterBackground";
  public static final String EVENT_APP_ENTER_FOREGROUND = "onAppEnterForeground";
  public static final String GAME_STOP = "onAppStop";
  private static final String TAG = "GameInfoManager";
  private static GameInfoManager instance;
  private GameInfoManager.LaunchOptions launchOptions;
  private MiniGamePkg miniGamePkg;
  
  public static GameInfoManager g()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new GameInfoManager();
      }
      return instance;
    }
    finally {}
  }
  
  public String getAppId()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null)) {
      return this.miniGamePkg.appConfig.config.appId;
    }
    QZLog.e("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String getAppName()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null))
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("GameInfoManager", 2, "getAppId() = " + this.miniGamePkg.appConfig.config.appId);
      }
      return this.miniGamePkg.appConfig.config.name;
    }
    QZLog.e("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String getEntryDataHash()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null) && (this.miniGamePkg.appConfig.launchParam.entryModel != null)) {
      return this.miniGamePkg.appConfig.launchParam.entryModel.getEntryHash();
    }
    return null;
  }
  
  public String getExtendData()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null))
    {
      QLog.i("GameInfoManager", 1, "getExtendData = " + this.miniGamePkg.appConfig.config.extendData);
      if (!TextUtils.isEmpty(this.miniGamePkg.appConfig.config.extendData)) {}
    }
    else
    {
      return null;
    }
    return this.miniGamePkg.appConfig.config.extendData;
  }
  
  public String getFromMiniAppId()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null))
    {
      QZLog.i("GameInfoManager", 1, "getFromMiniAppId = " + this.miniGamePkg.appConfig.launchParam.fromMiniAppId);
      if (!TextUtils.isEmpty(this.miniGamePkg.appConfig.launchParam.fromMiniAppId)) {}
    }
    else
    {
      return null;
    }
    return this.miniGamePkg.appConfig.launchParam.fromMiniAppId;
  }
  
  public GameInfoManager.LaunchOptions getLaunchOptions()
  {
    if (this.launchOptions == null) {
      return new GameInfoManager.LaunchOptions(this);
    }
    return this.launchOptions;
  }
  
  public MiniAppConfig getMiniAppConfig()
  {
    if (this.miniGamePkg != null) {
      return this.miniGamePkg.appConfig;
    }
    return null;
  }
  
  public String getMiniAppSimpleInfo()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null)) {
      return this.miniGamePkg.appConfig.config.simpleInfo();
    }
    return "";
  }
  
  public MiniGamePkg getMiniGamePkg()
  {
    return this.miniGamePkg;
  }
  
  public String getNavigateExtData()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null))
    {
      QLog.i("GameInfoManager", 1, "getNavigateExtData = " + this.miniGamePkg.appConfig.launchParam.navigateExtData);
      if (!TextUtils.isEmpty(this.miniGamePkg.appConfig.launchParam.navigateExtData)) {}
    }
    else
    {
      return null;
    }
    return this.miniGamePkg.appConfig.launchParam.navigateExtData;
  }
  
  public JSONObject getOnShowParam()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = g().getQueryPath();
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
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null) && (this.miniGamePkg.appConfig.config.firstPage != null))
    {
      QLog.i("GameInfoManager", 1, "getQueryPath = " + this.miniGamePkg.appConfig.config.firstPage.pagePath);
      if ("miniGamePath".equals(this.miniGamePkg.appConfig.config.firstPage.pagePath)) {
        return new JSONObject();
      }
      return PathUtil.getJSONQueryString(this.miniGamePkg.appConfig.config.firstPage.pagePath);
    }
    return new JSONObject();
  }
  
  public int getScene()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null))
    {
      QLog.i("GameInfoManager", 1, "getScene = " + this.miniGamePkg.appConfig.launchParam.scene);
      return this.miniGamePkg.appConfig.launchParam.scene;
    }
    return 1001;
  }
  
  public String getShareTicket()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null))
    {
      QLog.i("GameInfoManager", 1, "getShareTicket = " + this.miniGamePkg.appConfig.launchParam.shareTicket);
      if (!TextUtils.isEmpty(this.miniGamePkg.appConfig.launchParam.shareTicket)) {}
    }
    else
    {
      return null;
    }
    return this.miniGamePkg.appConfig.launchParam.shareTicket;
  }
  
  public void resetQuery()
  {
    if ((this.miniGamePkg != null) && (this.miniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null) && (this.miniGamePkg.appConfig.config.firstPage != null)) {
      this.miniGamePkg.appConfig.config.firstPage.setPagePath(null);
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
  
  public void setMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    if (this.miniGamePkg != null)
    {
      this.miniGamePkg.appConfig = paramMiniAppConfig;
      setLaunchOptions();
    }
  }
  
  public void setMiniGamePkg(MiniGamePkg paramMiniGamePkg)
  {
    this.miniGamePkg = paramMiniGamePkg;
    try
    {
      bhel.a(getMiniAppSimpleInfo());
      return;
    }
    catch (Throwable paramMiniGamePkg)
    {
      QZLog.e("GameInfoManager", "MiniAppInfoReportManager.setMiniAppInfo() error", paramMiniGamePkg);
    }
  }
  
  public void updateMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    if (this.miniGamePkg != null) {
      this.miniGamePkg.appConfig = paramMiniAppConfig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameInfoManager
 * JD-Core Version:    0.7.0.1
 */