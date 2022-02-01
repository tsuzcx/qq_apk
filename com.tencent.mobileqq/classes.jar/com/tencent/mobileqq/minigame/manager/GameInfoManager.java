package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
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
  private final String TAG = toString();
  private GameInfoManager.LaunchOptions launchOptions;
  private MiniGamePkg miniGamePkg;
  
  public String getAppId()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    if ((localMiniGamePkg != null) && (localMiniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null)) {
      return this.miniGamePkg.appConfig.config.appId;
    }
    QZLog.e(this.TAG, "getAppId() error");
    return null;
  }
  
  public String getAppName()
  {
    Object localObject = this.miniGamePkg;
    if ((localObject != null) && (((MiniGamePkg)localObject).appConfig != null) && (this.miniGamePkg.appConfig.config != null))
    {
      if (QZLog.isColorLevel())
      {
        localObject = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAppId() = ");
        localStringBuilder.append(this.miniGamePkg.appConfig.config.appId);
        QZLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return this.miniGamePkg.appConfig.config.name;
    }
    QZLog.e(this.TAG, "getAppId() error");
    return null;
  }
  
  public String getEntryDataHash()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    if ((localMiniGamePkg != null) && (localMiniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null) && (this.miniGamePkg.appConfig.launchParam.entryModel != null)) {
      return this.miniGamePkg.appConfig.launchParam.entryModel.getEntryHash();
    }
    return null;
  }
  
  public String getExtendData()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (localMiniGamePkg != null)
    {
      localObject = localStringBuilder;
      if (localMiniGamePkg.appConfig != null)
      {
        localObject = localStringBuilder;
        if (this.miniGamePkg.appConfig.config != null)
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getExtendData = ");
          localStringBuilder.append(this.miniGamePkg.appConfig.config.extendData);
          QLog.i((String)localObject, 1, localStringBuilder.toString());
          if (TextUtils.isEmpty(this.miniGamePkg.appConfig.config.extendData)) {
            return null;
          }
          localObject = this.miniGamePkg.appConfig.config.extendData;
        }
      }
    }
    return localObject;
  }
  
  public String getFromMiniAppId()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (localMiniGamePkg != null)
    {
      localObject = localStringBuilder;
      if (localMiniGamePkg.appConfig != null)
      {
        localObject = localStringBuilder;
        if (this.miniGamePkg.appConfig.launchParam != null)
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFromMiniAppId = ");
          localStringBuilder.append(this.miniGamePkg.appConfig.launchParam.fromMiniAppId);
          QZLog.i((String)localObject, 1, localStringBuilder.toString());
          if (TextUtils.isEmpty(this.miniGamePkg.appConfig.launchParam.fromMiniAppId)) {
            return null;
          }
          localObject = this.miniGamePkg.appConfig.launchParam.fromMiniAppId;
        }
      }
    }
    return localObject;
  }
  
  public String getGroupIdFromReportData()
  {
    Object localObject = this.miniGamePkg;
    if ((localObject != null) && (((MiniGamePkg)localObject).appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null))
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGroupIdFromReportData = ");
      localStringBuilder.append(this.miniGamePkg.appConfig.launchParam.reportData);
      QZLog.i((String)localObject, 1, localStringBuilder.toString());
      localObject = this.miniGamePkg.appConfig.launchParam.reportData;
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
  
  public MiniAppConfig getMiniAppConfig()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    if (localMiniGamePkg != null) {
      return localMiniGamePkg.appConfig;
    }
    return null;
  }
  
  public String getMiniAppSimpleInfo()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    if ((localMiniGamePkg != null) && (localMiniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null)) {
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
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (localMiniGamePkg != null)
    {
      localObject = localStringBuilder;
      if (localMiniGamePkg.appConfig != null)
      {
        localObject = localStringBuilder;
        if (this.miniGamePkg.appConfig.launchParam != null)
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getNavigateExtData = ");
          localStringBuilder.append(this.miniGamePkg.appConfig.launchParam.navigateExtData);
          QLog.i((String)localObject, 1, localStringBuilder.toString());
          if (TextUtils.isEmpty(this.miniGamePkg.appConfig.launchParam.navigateExtData)) {
            return null;
          }
          localObject = this.miniGamePkg.appConfig.launchParam.navigateExtData;
        }
      }
    }
    return localObject;
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
    Object localObject3 = getShareTicket();
    localObject2 = getFromMiniAppId();
    String str = getNavigateExtData();
    Object localObject4 = getEntryDataHash();
    Object localObject5;
    StringBuilder localStringBuilder;
    try
    {
      new JSONObject();
      localJSONObject2.put("query", localObject1);
      localJSONObject2.put("entryDataHash", localObject4);
    }
    catch (Exception localException1)
    {
      localObject4 = GameLog.getInstance();
      localObject5 = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onForeground exception put query string :");
      localStringBuilder.append(localException1);
      ((GameLog)localObject4).e((String)localObject5, localStringBuilder.toString());
    }
    try
    {
      localJSONObject2.put("scene", AppBrandUtil.getWikiScene(i));
    }
    catch (Exception localException2)
    {
      localObject4 = GameLog.getInstance();
      localObject5 = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onForeground exception put scene string :");
      localStringBuilder.append(localException2);
      ((GameLog)localObject4).e((String)localObject5, localStringBuilder.toString());
    }
    try
    {
      localJSONObject2.put("shareTicket", localObject3);
    }
    catch (Exception localException3)
    {
      localObject3 = GameLog.getInstance();
      localObject4 = this.TAG;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("onForeground exception put shareTicket string :");
      ((StringBuilder)localObject5).append(localException3);
      ((GameLog)localObject3).e((String)localObject4, ((StringBuilder)localObject5).toString());
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("appId", localObject2);
      localJSONObject1.put("extraData", str);
      localJSONObject2.put("referrerInfo", localJSONObject1);
      return localJSONObject2;
    }
    catch (Exception localException4)
    {
      localObject2 = GameLog.getInstance();
      str = this.TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onForeground exception put referrerInfo string :");
      ((StringBuilder)localObject3).append(localException4);
      ((GameLog)localObject2).e(str, ((StringBuilder)localObject3).toString());
    }
    return localJSONObject2;
  }
  
  public JSONObject getQueryPath()
  {
    Object localObject = this.miniGamePkg;
    if ((localObject != null) && (((MiniGamePkg)localObject).appConfig != null) && (this.miniGamePkg.appConfig.config != null) && (this.miniGamePkg.appConfig.config.firstPage != null))
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQueryPath = ");
      localStringBuilder.append(this.miniGamePkg.appConfig.config.firstPage.pagePath);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      if ("miniGamePath".equals(this.miniGamePkg.appConfig.config.firstPage.pagePath)) {
        return new JSONObject();
      }
      return PathUtil.getJSONQueryString(this.miniGamePkg.appConfig.config.firstPage.pagePath);
    }
    return new JSONObject();
  }
  
  public int getScene()
  {
    Object localObject = this.miniGamePkg;
    if ((localObject != null) && (((MiniGamePkg)localObject).appConfig != null) && (this.miniGamePkg.appConfig.launchParam != null))
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getScene = ");
      localStringBuilder.append(this.miniGamePkg.appConfig.launchParam.scene);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      return this.miniGamePkg.appConfig.launchParam.scene;
    }
    return 1001;
  }
  
  public String getShareTicket()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (localMiniGamePkg != null)
    {
      localObject = localStringBuilder;
      if (localMiniGamePkg.appConfig != null)
      {
        localObject = localStringBuilder;
        if (this.miniGamePkg.appConfig.launchParam != null)
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getShareTicket = ");
          localStringBuilder.append(this.miniGamePkg.appConfig.launchParam.shareTicket);
          QLog.i((String)localObject, 1, localStringBuilder.toString());
          if (TextUtils.isEmpty(this.miniGamePkg.appConfig.launchParam.shareTicket)) {
            return null;
          }
          localObject = this.miniGamePkg.appConfig.launchParam.shareTicket;
        }
      }
    }
    return localObject;
  }
  
  public void resetQuery()
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    if ((localMiniGamePkg != null) && (localMiniGamePkg.appConfig != null) && (this.miniGamePkg.appConfig.config != null) && (this.miniGamePkg.appConfig.config.firstPage != null)) {
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
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    if (localMiniGamePkg != null)
    {
      localMiniGamePkg.appConfig = paramMiniAppConfig;
      setLaunchOptions();
    }
  }
  
  public void setMiniGamePkg(MiniGamePkg paramMiniGamePkg)
  {
    this.miniGamePkg = paramMiniGamePkg;
  }
  
  public void updateMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    MiniGamePkg localMiniGamePkg = this.miniGamePkg;
    if (localMiniGamePkg != null) {
      localMiniGamePkg.appConfig = paramMiniAppConfig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameInfoManager
 * JD-Core Version:    0.7.0.1
 */