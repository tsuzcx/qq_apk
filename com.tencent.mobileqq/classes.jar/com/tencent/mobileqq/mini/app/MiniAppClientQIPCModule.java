package com.tencent.mobileqq.mini.app;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
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
import org.json.JSONException;
import org.json.JSONObject;

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
  
  private void onShareUpdatableMsgCallback(Bundle paramBundle)
  {
    int i = 0;
    Object localObject = null;
    if (this.isMiniGame) {
      localObject = this.gameJsPluginEngine;
    }
    String str1;
    int j;
    label188:
    do
    {
      break label188;
      boolean bool = paramBundle.getBoolean("miniAppShareIsComplete", false);
      str1 = paramBundle.getString("miniAppShareEvent");
      String str2 = paramBundle.getString("miniAppShareAppid");
      String str3 = paramBundle.getString("miniAppShareTemplateId");
      j = paramBundle.getInt("miniAppShareCallbackId");
      int k = paramBundle.getInt("miniAppShareAppType");
      if (bool)
      {
        int m = paramBundle.getInt("uintype");
        if (m == 1) {}
        for (;;)
        {
          paramBundle = paramBundle.getString("uin");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder("doCreateUpdatableMsgCallback");
            localStringBuilder.append(", appid:").append(str2).append(", templateId:").append(str3).append(", from:").append(k).append(", scene:").append(i).append(", uin:").append(paramBundle);
            QLog.i("MiniAppClientQIPCModule", 2, localStringBuilder.toString());
          }
          sendUpdatableMsg((BaseJsPluginEngine)localObject, str1, str2, str3, k, i, paramBundle, j);
          return;
          if (AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType) == null) {
            break;
          }
          localObject = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType).jsPluginEngine;
          break;
          if (m == 0) {
            i = 1;
          }
        }
      }
    } while (localObject == null);
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("retCode", 1);
      ((BaseJsPluginEngine)localObject).callbackJsEventFail(((BaseJsPluginEngine)localObject).getServiceRuntime(), str1, paramBundle, "用户取消", j);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
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
    MiniAppCmdUtil.getInstance().sendArkMsg(null, paramString2, paramString3, paramString4, new MiniAppClientQIPCModule.7(this, paramString1, paramInt));
  }
  
  private void sendUpdatableMsg(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString2, paramString3, paramInt1, paramInt2, paramString4, new MiniAppClientQIPCModule.8(this, paramBaseJsPluginEngine, paramString1, paramInt3));
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
          break label191;
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
    label191:
    do
    {
      do
      {
        do
        {
          return null;
          paramString = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
        } while ((paramString == null) || (paramString.pageContainer == null));
        paramString = paramString.pageContainer.getCurrentPage();
      } while ((paramString == null) || (paramString.getNavBar() == null));
      QLog.e("MiniAppClientQIPCModule", 1, BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + paramInt);
      paramString.getNavBar().getCapsuleButton().setUnReadCount(paramInt, true);
      return null;
      if (!"actionMiniShareSucCallback".equals(paramString)) {
        break label514;
      }
      paramBundle = "";
      AppBrandRuntime localAppBrandRuntime1 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
      if (!this.isMiniGame) {
        break;
      }
      if (this.gameBrandRuntime != null)
      {
        paramBundle = this.gameBrandRuntime.shareEvent;
        paramInt = this.gameBrandRuntime.shareCallbackId;
      }
    } while (this.gameJsPluginEngine == null);
    if ("requestFriendPayment".equals(paramBundle)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        QLog.e("MiniAppClientQIPCModule", 1, "API_PAY_BY_FRIEND put resultCode error", localJSONException1);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          paramString.put("resultCode", 0);
          this.gameJsPluginEngine.callbackJsEventOK(this.gameJsPluginEngine.getServiceRuntime(), paramBundle, paramString, paramInt);
          ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.1(this));
          return null;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            int i;
            Object localObject;
            String str;
            AppBrandRuntime localAppBrandRuntime2;
            continue;
            paramInt = -1;
          }
        }
        localJSONException1 = localJSONException1;
        paramString = null;
      }
      continue;
      i = paramInt;
      paramString = paramBundle;
      if (localJSONException1 != null)
      {
        i = paramInt;
        paramString = paramBundle;
        if (localJSONException1.getPageWebView() != null)
        {
          paramString = localJSONException1.getPageWebView().shareEvent;
          i = localJSONException1.getPageWebView().shareCallbackId;
        }
      }
      if (localJSONException1 == null) {
        break;
      }
      localJSONException1.jsPluginEngine.callbackJsEventOK(localJSONException1.serviceRuntime, paramString, null, i);
      ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.2(this, localJSONException1));
      return null;
      label514:
      if ("actionMiniShareFailCallback".equals(paramString))
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
          if (this.gameJsPluginEngine == null) {
            break;
          }
          this.gameJsPluginEngine.callbackJsEventFail(this.gameJsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
          ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.3(this));
          return null;
        }
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
        if (localObject == null) {
          break;
        }
        ((AppBrandRuntime)localObject).jsPluginEngine.callbackJsEventFail(((AppBrandRuntime)localObject).serviceRuntime, paramBundle, null, i);
        ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.4(this, (AppBrandRuntime)localObject));
        return null;
      }
      if ("actionMiniDirectShareSucCallback".equals(paramString))
      {
        paramString = "";
        localObject = "";
        paramBundle = "";
        str = "";
        localAppBrandRuntime2 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
        if ((this.isMiniGame) && (this.gameBrandRuntime != null))
        {
          paramString = this.gameBrandRuntime.shareEvent;
          paramInt = this.gameBrandRuntime.shareCallbackId;
          paramBundle = this.gameBrandRuntime.shareAppid;
          localObject = this.gameBrandRuntime.shareOpenid;
        }
        for (str = this.gameBrandRuntime.shareJson; (paramString.equals("shareMessageToFriend")) || (paramString.equals("modifyFriendInteractiveStorage")); str = localAppBrandRuntime2.getPageWebView().shareJson)
        {
          sendDirectShareArkMsg(paramString, paramInt, paramBundle, (String)localObject, str);
          return null;
          if ((localAppBrandRuntime2 == null) || (localAppBrandRuntime2.getPageWebView() == null)) {
            break label1270;
          }
          paramString = localAppBrandRuntime2.getPageWebView().shareEvent;
          paramInt = localAppBrandRuntime2.getPageWebView().shareCallbackId;
          paramBundle = localAppBrandRuntime2.getPageWebView().shareAppid;
          localObject = localAppBrandRuntime2.getPageWebView().shareOpenid;
        }
        break;
      }
      if ("actionMiniDirectShareFailCallback".equals(paramString))
      {
        paramString = "";
        if (this.isMiniGame)
        {
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
        paramString = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
        if ((paramString == null) || (paramString.getPageWebView() == null)) {
          break;
        }
        paramBundle = paramString.getPageWebView().shareEvent;
        paramInt = paramString.getPageWebView().shareCallbackId;
        paramString.jsPluginEngine.callbackJsEventFail(paramString.getPageWebView(), paramBundle, null, paramInt);
        ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.6(this, paramString));
        return null;
      }
      if ("actionMiniReportEvent".equals(paramString))
      {
        if (paramBundle == null) {
          break;
        }
        paramString = paramBundle.getString("key_mini_report_event_action_type");
        localObject = paramBundle.getString("key_mini_report_event_action_type");
        str = paramBundle.getString("key_mini_report_event_reserves");
        paramBundle = paramBundle.getString("key_mini_report_event_reserves2");
        localAppBrandRuntime2 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
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
        if (localAppBrandRuntime2 == null) {
          break;
        }
        MiniProgramLpReportDC04239.reportMiniAppEvent(localAppBrandRuntime2.getApkgInfo().appConfig, "0", null, paramString, (String)localObject, str, paramBundle);
        return null;
      }
      if (!"actionMiniCreateUpdatableMsgCallback".equals(paramString)) {
        break;
      }
      onShareUpdatableMsgCallback(paramBundle);
      return null;
      label1270:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */