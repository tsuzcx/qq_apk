package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.module.QQGameApIProvider;
import com.tencent.mobileqq.qqgamepub.hippy.view.QQGameHippyViewCreator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.qphone.base.util.QLog;

public class QQGameHippyApiImpl
  implements IQQGameHippyApi
{
  private static final String TAG = "QQGamePub_QQGameHippyApiImpl";
  public static volatile boolean isGetHippysManagerConfig = false;
  public static volatile boolean isPreloadHippy = false;
  public static volatile boolean isReadyToPreloadHippy = false;
  
  private void fillMsgInfo1(HippyMap paramHippyMap, QQGameMsgInfo paramQQGameMsgInfo)
  {
    if (paramHippyMap.containsKey("msgid")) {
      paramQQGameMsgInfo.paMsgid = paramHippyMap.getString("msgid");
    }
    if (paramHippyMap.containsKey("msgType")) {
      paramQQGameMsgInfo.msgType = paramHippyMap.getInt("msgType");
    }
    if (paramHippyMap.containsKey("gameAppId")) {
      paramQQGameMsgInfo.gameAppId = paramHippyMap.getString("gameAppId");
    }
    if (paramHippyMap.containsKey("msgTime")) {
      paramQQGameMsgInfo.msgTime = paramHippyMap.getLong("msgTime");
    }
    if (paramHippyMap.containsKey(" sorted_configs")) {
      paramQQGameMsgInfo.sortedConfigs = paramHippyMap.getString(" sorted_configs");
    }
    if (paramHippyMap.containsKey("extJson")) {
      paramQQGameMsgInfo.extJson = paramHippyMap.getString("extJson");
    }
    if (paramHippyMap.containsKey("icon")) {
      paramQQGameMsgInfo.icon = paramHippyMap.getString("icon");
    }
    if (paramHippyMap.containsKey("desc")) {
      paramQQGameMsgInfo.desc = paramHippyMap.getString("desc");
    }
    if (paramHippyMap.containsKey("frienduin")) {
      paramQQGameMsgInfo.frienduin = paramHippyMap.getString("frienduin");
    }
    if (paramHippyMap.containsKey("uniseq")) {
      paramQQGameMsgInfo.uniseq = paramHippyMap.getLong("uniseq");
    }
    if (paramHippyMap.containsKey("advId")) {
      paramQQGameMsgInfo.advId = paramHippyMap.getString("advId");
    }
    if (paramHippyMap.containsKey("triggerInfo")) {
      paramQQGameMsgInfo.triggerInfo = paramHippyMap.getString("triggerInfo");
    }
  }
  
  private void fillMsgInfo2(HippyMap paramHippyMap, QQGameMsgInfo paramQQGameMsgInfo)
  {
    if (paramHippyMap.containsKey("appName")) {
      paramQQGameMsgInfo.arkAppName = paramHippyMap.getString("appName");
    }
    if (paramHippyMap.containsKey("appView")) {
      paramQQGameMsgInfo.arkAppView = paramHippyMap.getString("appView");
    }
    if (paramHippyMap.containsKey("appMinVersion")) {
      paramQQGameMsgInfo.arkAppMinVersion = paramHippyMap.getString("appMinVersion");
    }
    if (paramHippyMap.containsKey("appMetaList")) {
      paramQQGameMsgInfo.arkMetaList = paramHippyMap.getString("appMetaList");
    }
    if (paramHippyMap.containsKey("appConfig")) {
      paramQQGameMsgInfo.arkAppConfig = paramHippyMap.getString("appConfig");
    }
    if (paramHippyMap.containsKey("width")) {
      paramQQGameMsgInfo.arkWidth = paramHippyMap.getInt("width");
    }
    if (paramHippyMap.containsKey("height")) {
      paramQQGameMsgInfo.arkHeight = paramHippyMap.getInt("height");
    }
    if (paramHippyMap.containsKey("coverUrl")) {
      paramQQGameMsgInfo.coverUrl = paramHippyMap.getString("coverUrl");
    }
    if (paramHippyMap.containsKey("url")) {
      paramQQGameMsgInfo.url = paramHippyMap.getString("url");
    }
    if (paramHippyMap.containsKey("title")) {
      paramQQGameMsgInfo.title = paramHippyMap.getString("title");
    }
    if (paramHippyMap.containsKey("dateTitle")) {
      paramQQGameMsgInfo.dateTitle = paramHippyMap.getString("dateTitle");
    }
    if (paramHippyMap.containsKey("contentText")) {
      paramQQGameMsgInfo.contentText = paramHippyMap.getString("contentText");
    }
    if (paramHippyMap.containsKey("limitText")) {
      paramQQGameMsgInfo.limitText = paramHippyMap.getString("limitText");
    }
  }
  
  private void onUpdateGameCenterFinished()
  {
    Object localObject1 = ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).getHippyConfig();
    boolean bool;
    if ((((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySwitch()) && ((((HippyConfig)localObject1).isGameCenterPreloadHippy()) || (((HippyConfig)localObject1).isGameCenterPredrawHippy()))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGameCenterUpdateFinished isCanPreload:");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("QQGamePub_QQGameHippyApiImpl", 2, ((StringBuilder)localObject2).toString());
    }
    if (!bool) {
      return;
    }
    Object localObject2 = new OpenHippyInfo();
    ((OpenHippyInfo)localObject2).bundleName = "QQGameCenter";
    ((OpenHippyInfo)localObject2).isPreload = ((HippyConfig)localObject1).isGameCenterPreloadHippy();
    ((OpenHippyInfo)localObject2).isPredraw = ((HippyConfig)localObject1).isGameCenterPredrawHippy();
    if (((HippyConfig)localObject1).isGameCenterLoadHippyInToolProcess()) {
      localObject1 = "tool";
    } else {
      localObject1 = "main";
    }
    ((OpenHippyInfo)localObject2).processName = ((String)localObject1);
    ((OpenHippyInfo)localObject2).from = "gameDongTai";
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage((OpenHippyInfo)localObject2);
  }
  
  public int canOpenHippyByModuleName(String paramString)
  {
    StringBuilder localStringBuilder;
    if ("SGameOfficial".equals(paramString))
    {
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippySwitch())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("canOpenHippyByModuleName ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" not allow");
          QLog.d("QQGamePub_QQGameHippyApiImpl", 2, localStringBuilder.toString());
        }
        return -1;
      }
    }
    else
    {
      if (!"SGameOfficialV2".equals(paramString)) {
        break label257;
      }
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippyV2Switch())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("canOpenHippyByModuleName ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" not allow");
          QLog.d("QQGamePub_QQGameHippyApiImpl", 2, localStringBuilder.toString());
        }
        return -1;
      }
    }
    if (((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString) <= 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("canOpenHippyByModuleName ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" js bundle not exist");
      QLog.d("QQGamePub_QQGameHippyApiImpl", 1, localStringBuilder.toString());
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(paramString, "gamePub", null);
      return -2;
    }
    if (!((IHippyLibrary)QRoute.api(IHippyLibrary.class)).isLibrayExists())
    {
      QLog.d("QQGamePub_QQGameHippyApiImpl", 1, "canOpenHippyByModuleName so not exist");
      return -3;
    }
    return 0;
    label257:
    if ("QQGameCenter".equals(paramString))
    {
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySwitch())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("canOpenHippyByModuleName ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" not allow");
          QLog.d("QQGamePub_QQGameHippyApiImpl", 2, localStringBuilder.toString());
        }
        return -1;
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("canOpenHippyByModuleName ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" invalid");
      QLog.d("QQGamePub_QQGameHippyApiImpl", 2, localStringBuilder.toString());
    }
    return -4;
  }
  
  public String getGamePaHippyModuleName()
  {
    if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippyV2Switch()) {
      return "SGameOfficialV2";
    }
    if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippySwitch()) {
      return "SGameOfficial";
    }
    return "";
  }
  
  public QQGameMsgInfo getMsgInfoByHippyMap(HippyMap paramHippyMap)
  {
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    if (paramHippyMap != null)
    {
      fillMsgInfo1(paramHippyMap, localQQGameMsgInfo);
      fillMsgInfo2(paramHippyMap, localQQGameMsgInfo);
    }
    return localQQGameMsgInfo;
  }
  
  public int getMsgPosByHippyMap(HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("pos"))) {
      return paramHippyMap.getInt("pos");
    }
    return 0;
  }
  
  public HippyAPIProvider getQQGameHippyAPIProvider()
  {
    return new QQGameApIProvider();
  }
  
  public HippyCustomViewCreator getQQGameHippyViewCreator()
  {
    return new QQGameHippyViewCreator();
  }
  
  public boolean isQQGamePubHippyV2(String paramString)
  {
    return TextUtils.equals(paramString, "SGameOfficialV2");
  }
  
  public void openQQGameCenterByHippy(Context paramContext, String paramString1, String paramString2)
  {
    String str;
    if (paramString1 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      str = "?";
      if (paramString1.contains("?")) {
        str = "&";
      }
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("forceHtml=true");
      str = ((StringBuilder)localObject).toString();
    }
    else
    {
      str = null;
    }
    Object localObject = ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).getHippyConfig();
    OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
    localOpenHippyInfo.bundleName = "QQGameCenter";
    localOpenHippyInfo.url = paramString1;
    localOpenHippyInfo.errorUrl = str;
    localOpenHippyInfo.isAnimated = true;
    localOpenHippyInfo.isStatusBarDarkFont = true;
    localOpenHippyInfo.isEnbaleRightFling = false;
    localOpenHippyInfo.from = paramString2;
    localOpenHippyInfo.updateJsBundleType = 1;
    if (((HippyConfig)localObject).isGameCenterLoadHippyInToolProcess()) {
      paramString1 = "tool";
    } else {
      paramString1 = "main";
    }
    localOpenHippyInfo.processName = paramString1;
    localOpenHippyInfo.isPreloadWhenClosed = ((HippyConfig)localObject).isGameCenterPreloadHippy();
    localOpenHippyInfo.isPredrawWhenClosed = ((HippyConfig)localObject).isGameCenterPredrawHippy();
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).openHippyPage(paramContext, localOpenHippyInfo);
  }
  
  public void preloadNewQQGamePaHippy()
  {
    QLog.i("QQGamePub_QQGameHippyApiImpl", 2, "<<<<<<<<<<<<<<preloadNewQQGamePaHippy<<<<<<<<<<<<<<<<");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGetHippysManagerConfig=");
      localStringBuilder.append(isGetHippysManagerConfig);
      localStringBuilder.append(" isReadyToPreloadHippy=");
      localStringBuilder.append(isReadyToPreloadHippy);
      localStringBuilder.append(" isPreloadHippy=");
      localStringBuilder.append(isPreloadHippy);
      QLog.d("QQGamePub_QQGameHippyApiImpl", 1, localStringBuilder.toString());
    }
    if (Build.VERSION.SDK_INT < 26) {
      return;
    }
    if (isGetHippysManagerConfig)
    {
      if (!isReadyToPreloadHippy) {
        return;
      }
      if ((!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippySwitch()) && (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippyV2Switch()))
      {
        QLog.i("QQGamePub_QQGameHippyApiImpl", 2, "can not preload hippy engine because hippy switch is close");
        return;
      }
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isPreloadSwitch())
      {
        QLog.i("QQGamePub_QQGameHippyApiImpl", 2, "can not preload hippy engine because preload switch is close");
        return;
      }
      if (isPreloadHippy) {
        return;
      }
      isPreloadHippy = true;
      ThreadManagerV2.excute(new QQGameHippyApiImpl.1(this), 64, null, true);
    }
  }
  
  public void preloadQQGameCenterByHippy()
  {
    boolean bool1 = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySwitch();
    boolean bool2 = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isGameCenterPreloadByTab();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadQQGameCenterByHippy isHippySwitchOpened:");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" isPreloadByTab:");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("QQGamePub_QQGameHippyApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (bool1)
    {
      if (bool2) {
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("reportFrom", "gameDongTai");
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).updateJsBundle("QQGameCenter", ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 3, (Bundle)localObject, new QQGameHippyApiImpl.2(this));
    }
  }
  
  public void setGetHippysManagerConfig(boolean paramBoolean)
  {
    isGetHippysManagerConfig = paramBoolean;
  }
  
  public void setReadyToPreloadHippy(boolean paramBoolean)
  {
    isReadyToPreloadHippy = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHippyApiImpl
 * JD-Core Version:    0.7.0.1
 */