package com.tencent.mobileqq.mini.app;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.NavigatorBarForMiniGame;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.os.MqqHandler;

public class MiniAppClientQIPCModule
  extends QIPCModule
{
  public static final String KEY_MINI_REPORT_EVENT_ACTION_TYPE = "key_mini_report_event_action_type";
  public static final String KEY_MINI_REPORT_EVENT_RESERVES = "key_mini_report_event_reserves";
  public static final String KEY_MINI_REPORT_EVENT_RESERVES2 = "key_mini_report_event_reserves2";
  public static final String KEY_MINI_REPORT_EVENT_SUB_ACTION_TYPE = "key_mini_report_event_sub_action_type";
  public static final String MODULE_NAME = "mini_app_client_module";
  public static final String TAG = "MiniAppClientQIPCModule";
  private String appId;
  private GameBrandRuntime gameBrandRuntime;
  private GameJsPluginEngine gameJsPluginEngine;
  private boolean isMiniGame;
  private int verType;
  
  public MiniAppClientQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static MiniAppClientQIPCModule getQIPCModule()
  {
    return MiniAppClientQIPCModule.MiniAppClientClass.access$000();
  }
  
  public static void registerModule()
  {
    MiniAppClientQIPCModule localMiniAppClientQIPCModule = getQIPCModule();
    try
    {
      QIPCClientHelper.getInstance().register(localMiniAppClientQIPCModule);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppClientQIPCModule", 1, "register ipc module error.", localException);
    }
  }
  
  private void sendDirectShareArkMsg(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    MiniAppCmdUtil.getInstance().sendArkMsg(null, paramString2, paramString3, paramString4, new MiniAppClientQIPCModule.6(this, paramString1, paramInt));
  }
  
  public static void unRegisterModule()
  {
    QIPCClientHelper.getInstance().getClient().unRegisterModule(getQIPCModule());
  }
  
  public void attachData(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.verType = paramInt;
  }
  
  public void attachGameJsPluginEngine(GameJsPluginEngine paramGameJsPluginEngine)
  {
    this.isMiniGame = true;
    if (paramGameJsPluginEngine != null)
    {
      this.gameJsPluginEngine = paramGameJsPluginEngine;
      this.gameBrandRuntime = ((GameBrandRuntime)paramGameJsPluginEngine.appBrandRuntime);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = -1;
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppClientQIPCModule", 2, "onCall main server action=" + paramString);
    }
    if ("action_sync_unreadcount".equals(paramString)) {
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt("param_proc_badge_count");
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppClientQIPCModule", 2, "count is " + paramInt);
        }
        if (!this.isMiniGame) {
          break label187;
        }
        if ((this.gameBrandRuntime != null) && ((this.gameBrandRuntime.activity instanceof GameActivity)))
        {
          paramString = (GameActivity)this.gameBrandRuntime.activity;
          if ((paramString.getNavBar() != null) && (paramString.getNavBar().getCapsuleButton() != null))
          {
            QLog.e("MiniAppClientQIPCModule", 1, BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + paramInt);
            paramString.getNavBar().getCapsuleButton().setUnReadCount(paramInt, true);
          }
        }
      }
    }
    label1037:
    label1040:
    for (;;)
    {
      return null;
      label187:
      paramString = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
      if ((paramString != null) && (paramString.pageContainer != null))
      {
        paramString = paramString.pageContainer.getCurrentPage();
        if ((paramString != null) && (paramString.getNavBar() != null))
        {
          QLog.e("MiniAppClientQIPCModule", 1, BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + paramInt);
          paramString.getNavBar().getCapsuleButton().setUnReadCount(paramInt, true);
          return null;
          Object localObject;
          int i;
          if ("actionMiniShareSucCallback".equals(paramString))
          {
            paramString = "";
            localObject = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
            if (this.isMiniGame)
            {
              if (this.gameBrandRuntime != null)
              {
                paramString = this.gameBrandRuntime.shareEvent;
                paramInt = this.gameBrandRuntime.shareCallbackId;
              }
              if (this.gameJsPluginEngine != null)
              {
                this.gameJsPluginEngine.callbackJsEventOK(this.gameJsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
                ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.1(this));
                return null;
              }
            }
            else
            {
              i = paramInt;
              paramBundle = paramString;
              if (localObject != null)
              {
                i = paramInt;
                paramBundle = paramString;
                if (((AppBrandRuntime)localObject).getPageWebView() != null)
                {
                  paramBundle = ((AppBrandRuntime)localObject).getPageWebView().shareEvent;
                  i = ((AppBrandRuntime)localObject).getPageWebView().shareCallbackId;
                }
              }
              if (localObject != null)
              {
                ((AppBrandRuntime)localObject).jsPluginEngine.callbackJsEventOK(((AppBrandRuntime)localObject).serviceRuntime, paramBundle, null, i);
                ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.2(this, (AppBrandRuntime)localObject));
                return null;
              }
            }
          }
          else if ("actionMiniShareFailCallback".equals(paramString))
          {
            paramString = "";
            localObject = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
            if (this.isMiniGame)
            {
              if (this.gameBrandRuntime != null)
              {
                paramString = this.gameBrandRuntime.shareEvent;
                paramInt = this.gameBrandRuntime.shareCallbackId;
              }
              if (this.gameJsPluginEngine != null)
              {
                this.gameJsPluginEngine.callbackJsEventFail(this.gameJsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
                ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.3(this));
                return null;
              }
            }
            else
            {
              i = paramInt;
              paramBundle = paramString;
              if (localObject != null)
              {
                i = paramInt;
                paramBundle = paramString;
                if (((AppBrandRuntime)localObject).getPageWebView() != null)
                {
                  paramBundle = ((AppBrandRuntime)localObject).getPageWebView().shareEvent;
                  i = ((AppBrandRuntime)localObject).getPageWebView().shareCallbackId;
                }
              }
              if (localObject != null)
              {
                ((AppBrandRuntime)localObject).jsPluginEngine.callbackJsEventFail(((AppBrandRuntime)localObject).serviceRuntime, paramBundle, null, i);
                ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.4(this, (AppBrandRuntime)localObject));
                return null;
              }
            }
          }
          else
          {
            String str;
            if ("actionMiniDirectShareSucCallback".equals(paramString))
            {
              paramString = "";
              localObject = "";
              paramBundle = "";
              str = "";
              if (!this.isMiniGame) {
                continue;
              }
              if (this.gameBrandRuntime == null) {
                break label1037;
              }
              paramString = this.gameBrandRuntime.shareEvent;
              paramInt = this.gameBrandRuntime.shareCallbackId;
              paramBundle = this.gameBrandRuntime.shareAppid;
              localObject = this.gameBrandRuntime.shareOpenid;
              str = this.gameBrandRuntime.shareJson;
            }
            for (;;)
            {
              if ((!paramString.equals("shareMessageToFriend")) && (!paramString.equals("modifyFriendInteractiveStorage"))) {
                break label1040;
              }
              sendDirectShareArkMsg(paramString, paramInt, paramBundle, (String)localObject, str);
              return null;
              if ("actionMiniDirectShareFailCallback".equals(paramString))
              {
                paramString = "";
                if (!this.isMiniGame) {
                  break;
                }
                if (this.gameBrandRuntime != null)
                {
                  paramString = this.gameBrandRuntime.shareEvent;
                  paramInt = this.gameBrandRuntime.shareCallbackId;
                }
                if (this.gameJsPluginEngine == null) {
                  break;
                }
                this.gameJsPluginEngine.callbackJsEventFail(this.gameJsPluginEngine.getGameJsRuntime(2), paramString, null, paramInt);
                ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.5(this));
                return null;
              }
              if ((!"actionMiniReportEvent".equals(paramString)) || (paramBundle == null)) {
                break;
              }
              paramString = paramBundle.getString("key_mini_report_event_action_type");
              localObject = paramBundle.getString("key_mini_report_event_action_type");
              str = paramBundle.getString("key_mini_report_event_reserves");
              paramBundle = paramBundle.getString("key_mini_report_event_reserves2");
              AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
              if (QLog.isColorLevel()) {
                QLog.d("MiniAppClientQIPCModule", 2, "ACTION_MINI_REPORT_EVENT_miniAppReport_actionType:" + paramString + ";subActionType:" + (String)localObject + ";reserves:" + str + ";reserves2:" + paramBundle);
              }
              if (this.isMiniGame)
              {
                if (this.gameJsPluginEngine == null) {
                  break;
                }
                MiniProgramLpReportDC04239.reportMiniAppEvent(this.gameJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, "1", null, paramString, (String)localObject, str, paramBundle);
                return null;
              }
              if (localAppBrandRuntime == null) {
                break;
              }
              MiniProgramLpReportDC04239.reportMiniAppEvent(localAppBrandRuntime.getApkgInfo().appConfig, "0", null, paramString, (String)localObject, str, paramBundle);
              return null;
              paramInt = -1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */