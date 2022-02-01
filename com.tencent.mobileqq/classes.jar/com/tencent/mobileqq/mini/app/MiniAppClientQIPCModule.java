package com.tencent.mobileqq.mini.app;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
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
  
  private void cmdCallBack(String paramString, CmdCallback paramCmdCallback)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("shareJson", paramString);
      paramCmdCallback.onCmdResult(true, localBundle);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static MiniAppClientQIPCModule getQIPCModule()
  {
    return MiniAppClientQIPCModule.MiniAppClientClass.access$000();
  }
  
  private void getReplaceJsonString(String paramString, CmdCallback paramCmdCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      cmdCallBack(paramString, paramCmdCallback);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if ((!localJSONObject.has("metaData")) || (!localJSONObject.optJSONObject("metaData").has("detail")) || (!localJSONObject.optJSONObject("metaData").optJSONObject("detail").has("preview"))) {
        break label159;
      }
      String str = localJSONObject.optJSONObject("metaData").optJSONObject("detail").optString("preview");
      if (!URLUtil.isNetworkUrl(str))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("preview", str);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_upload_image", localBundle, new MiniAppClientQIPCModule.9(this, localJSONObject, paramCmdCallback));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppClientQIPCModule", 1, "getReplaceJsonString error,", localThrowable);
      cmdCallBack(paramString, paramCmdCallback);
      return;
    }
    cmdCallBack(paramString, paramCmdCallback);
    return;
    label159:
    cmdCallBack(paramString, paramCmdCallback);
  }
  
  private void onShareUpdatableMsgCallback(Bundle paramBundle)
  {
    int i = 0;
    Object localObject = null;
    label18:
    String str1;
    int j;
    int m;
    if (this.isMiniGame)
    {
      localObject = this.gameJsPluginEngine;
      break label188;
      boolean bool = paramBundle.getBoolean("miniAppShareIsComplete", false);
      str1 = paramBundle.getString("miniAppShareEvent");
      String str2 = paramBundle.getString("miniAppShareAppid");
      String str3 = paramBundle.getString("miniAppShareTemplateId");
      j = paramBundle.getInt("miniAppShareCallbackId");
      int k = paramBundle.getInt("miniAppShareAppType");
      if (!bool) {
        break label238;
      }
      m = paramBundle.getInt("uintype");
      if (m != 1) {
        break label228;
      }
      label85:
      paramBundle = paramBundle.getString("uin");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("doCreateUpdatableMsgCallback");
        localStringBuilder.append(", appid:").append(str2).append(", templateId:").append(str3).append(", from:").append(k).append(", scene:").append(i).append(", uin:").append(paramBundle);
        QLog.i("MiniAppClientQIPCModule", 2, localStringBuilder.toString());
      }
      sendUpdatableMsg((BaseJsPluginEngine)localObject, str1, str2, str3, k, i, paramBundle, j);
    }
    for (;;)
    {
      label188:
      return;
      if (AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType) == null) {
        break label18;
      }
      localObject = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType).jsPluginEngine;
      break label18;
      label228:
      if (m != 0) {
        break label85;
      }
      i = 1;
      break label85;
      label238:
      if (localObject == null) {
        break;
      }
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("retCode", 1);
        if (this.isMiniGame)
        {
          localObject = (DataJsPlugin)((GameJsPluginEngine)localObject).getPlugin(DataJsPlugin.class);
          if (localObject == null) {
            continue;
          }
          ((DataJsPlugin)localObject).handleCallback(j, ApiUtil.wrapCallbackFail(str1, paramBundle, "用户取消").toString());
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
        ((BaseJsPluginEngine)localObject).callbackJsEventFail(((BaseJsPluginEngine)localObject).getServiceRuntime(), str1, paramBundle, "用户取消", j);
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
  
  private void sendArkMsg(JsRuntime paramJsRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    MiniAppCmdUtil.getInstance().sendArkMsg(null, paramString2, paramString3, paramString4, new MiniAppClientQIPCModule.8(this, paramJsRuntime, paramString1, paramInt));
  }
  
  private void sendDirectShareArkMsg(JsRuntime paramJsRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    getReplaceJsonString(paramString4, new MiniAppClientQIPCModule.7(this, paramJsRuntime, paramString1, paramInt, paramString2, paramString3));
  }
  
  private void sendUpdatableMsg(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString2, paramString3, paramInt1, paramInt2, paramString4, new MiniAppClientQIPCModule.10(this, paramBaseJsPluginEngine, paramInt3, paramString1));
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
          break label192;
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
    label1285:
    label1296:
    label1303:
    label1319:
    label1329:
    for (;;)
    {
      return null;
      label192:
      paramString = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
      if ((paramString != null) && (paramString.pageContainer != null))
      {
        paramString = paramString.pageContainer.getCurrentPage();
        if ((paramString != null) && (paramString.getNavBar() != null))
        {
          QLog.e("MiniAppClientQIPCModule", 1, BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + paramInt);
          paramString.getNavBar().getCapsuleButton().setUnReadCount(paramInt, true);
          return null;
          Object localObject1;
          if ("actionMiniShareSucCallback".equals(paramString))
          {
            paramBundle = "";
            localObject1 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
            if (this.isMiniGame)
            {
              if (this.gameBrandRuntime == null) {
                break label1319;
              }
              localObject1 = this.gameBrandRuntime.shareEvent;
              paramInt = this.gameBrandRuntime.shareCallbackId;
            }
          }
          for (paramBundle = this.gameBrandRuntime.shareJsRuntime;; paramBundle = null)
          {
            if (this.gameJsPluginEngine == null) {
              break label1329;
            }
            if ("requestFriendPayment".equals(localObject1)) {}
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
                  this.gameJsPluginEngine.callbackJsEventOK(paramBundle, (String)localObject1, paramString, paramInt);
                  ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.1(this));
                  return null;
                }
                catch (JSONException localJSONException2)
                {
                  for (;;)
                  {
                    int i;
                    String str;
                    Object localObject2;
                    continue;
                    paramBundle = "";
                    paramInt = -1;
                    paramString = null;
                    continue;
                    paramString = null;
                    paramInt = -1;
                    continue;
                    paramBundle = "";
                    paramInt = -1;
                    paramString = null;
                  }
                }
                localJSONException1 = localJSONException1;
                paramString = null;
              }
              continue;
              i = paramInt;
              paramString = paramBundle;
              if (localObject1 != null)
              {
                i = paramInt;
                paramString = paramBundle;
                if (((AppBrandRuntime)localObject1).getPageWebView() != null)
                {
                  paramString = ((AppBrandRuntime)localObject1).getPageWebView().shareEvent;
                  i = ((AppBrandRuntime)localObject1).getPageWebView().shareCallbackId;
                }
              }
              if (localObject1 == null) {
                break;
              }
              ((AppBrandRuntime)localObject1).jsPluginEngine.callbackJsEventOK(((AppBrandRuntime)localObject1).serviceRuntime, paramString, null, i);
              ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.2(this, (AppBrandRuntime)localObject1));
              return null;
              if ("actionMiniShareFailCallback".equals(paramString))
              {
                paramBundle = "";
                localObject1 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
                if (this.isMiniGame)
                {
                  if (this.gameBrandRuntime == null) {
                    break label1303;
                  }
                  paramBundle = this.gameBrandRuntime.shareEvent;
                  paramInt = this.gameBrandRuntime.shareCallbackId;
                  paramString = this.gameBrandRuntime.shareJsRuntime;
                  if (this.gameJsPluginEngine == null) {
                    break;
                  }
                  this.gameJsPluginEngine.callbackJsEventFail(paramString, paramBundle, null, paramInt);
                  ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.3(this));
                  return null;
                }
                i = paramInt;
                paramString = paramBundle;
                if (localObject1 != null)
                {
                  i = paramInt;
                  paramString = paramBundle;
                  if (((AppBrandRuntime)localObject1).getPageWebView() != null)
                  {
                    paramString = ((AppBrandRuntime)localObject1).getPageWebView().shareEvent;
                    i = ((AppBrandRuntime)localObject1).getPageWebView().shareCallbackId;
                  }
                }
                if (localObject1 == null) {
                  break;
                }
                ((AppBrandRuntime)localObject1).jsPluginEngine.callbackJsEventFail(((AppBrandRuntime)localObject1).serviceRuntime, paramString, null, i);
                ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.4(this, (AppBrandRuntime)localObject1));
                return null;
              }
              if ("actionMiniDirectShareSucCallback".equals(paramString))
              {
                paramBundle = "";
                str = "";
                localObject1 = "";
                localObject2 = "";
                paramString = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
                if ((this.isMiniGame) && (this.gameBrandRuntime != null))
                {
                  paramBundle = this.gameBrandRuntime.shareEvent;
                  paramInt = this.gameBrandRuntime.shareCallbackId;
                  localObject1 = this.gameBrandRuntime.shareAppid;
                  str = this.gameBrandRuntime.shareOpenid;
                  localObject2 = this.gameBrandRuntime.shareJson;
                }
                for (paramString = this.gameBrandRuntime.shareJsRuntime; (paramBundle.equals("shareMessageToFriend")) || (paramBundle.equals("modifyFriendInteractiveStorage")); paramString = paramString.getPageWebView())
                {
                  sendDirectShareArkMsg(paramString, paramBundle, paramInt, (String)localObject1, str, (String)localObject2);
                  return null;
                  if ((paramString == null) || (paramString.getPageWebView() == null)) {
                    break label1296;
                  }
                  paramBundle = paramString.getPageWebView().shareEvent;
                  paramInt = paramString.getPageWebView().shareCallbackId;
                  localObject1 = paramString.getPageWebView().shareAppid;
                  str = paramString.getPageWebView().shareOpenid;
                  localObject2 = paramString.getPageWebView().shareJson;
                }
                break;
              }
              if ("actionMiniDirectShareFailCallback".equals(paramString))
              {
                if (this.isMiniGame)
                {
                  if (this.gameBrandRuntime == null) {
                    break label1285;
                  }
                  paramBundle = this.gameBrandRuntime.shareEvent;
                  paramInt = this.gameBrandRuntime.shareCallbackId;
                  paramString = this.gameBrandRuntime.shareJsRuntime;
                  if (this.gameJsPluginEngine == null) {
                    break;
                  }
                  this.gameJsPluginEngine.callbackJsEventFail(paramString, paramBundle, null, paramInt);
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
                localObject1 = paramBundle.getString("key_mini_report_event_action_type");
                str = paramBundle.getString("key_mini_report_event_reserves");
                paramBundle = paramBundle.getString("key_mini_report_event_reserves2");
                localObject2 = AppBrandRuntimeContainer.g().getAppBrandRunTime(this.appId, this.verType);
                if (QLog.isColorLevel()) {
                  QLog.d("MiniAppClientQIPCModule", 2, "ACTION_MINI_REPORT_EVENT_miniAppReport_actionType:" + paramString + ";subActionType:" + (String)localObject1 + ";reserves:" + str + ";reserves2:" + paramBundle);
                }
                if (this.isMiniGame)
                {
                  if (this.gameJsPluginEngine == null) {
                    break;
                  }
                  MiniProgramLpReportDC04239.reportMiniAppEvent(this.gameJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, "1", null, paramString, (String)localObject1, str, paramBundle);
                  return null;
                }
                if (localObject2 == null) {
                  break;
                }
                MiniProgramLpReportDC04239.reportMiniAppEvent(((AppBrandRuntime)localObject2).getApkgInfo().appConfig, "0", null, paramString, (String)localObject1, str, paramBundle);
                return null;
              }
              if (!"actionMiniCreateUpdatableMsgCallback".equals(paramString)) {
                break;
              }
              onShareUpdatableMsgCallback(paramBundle);
              return null;
              paramString = null;
            }
            localObject1 = "";
            paramInt = -1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */