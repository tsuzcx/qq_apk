package com.tencent.mobileqq.mini.reuse;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.share.WXShareHelperFromQQMiniApp;
import com.tencent.mobileqq.mini.utils.ReportLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class MiniAppTransferModule
  extends QIPCModule
{
  public static final String ACTION_FLUSH_REPORT_DATA = "flush_report_data";
  public static final String ACTION_GET_BACK_HOME_SCENE_LIST = "get_back_home_scene_list";
  public static final String ACTION_LAUNCH_REPORT = "launch_report";
  public static final String ACTION_LAUNCH_REPORT2 = "launch_report2";
  public static final String ACTION_LAUNCH_REPORT_APP_PAUSE = "launch_report_app_pause";
  public static final String ACTION_LAUNCH_REPORT_APP_RESUME = "launch_report_app_resume";
  public static final String ACTION_LAUNCH_REPORT_JS_ERROR = "launch_report_js_error";
  public static final String ACTION_LAUNCH_REPORT_SDK_4239 = "launch_report_sdk_4239";
  public static final String ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ = "mini_record_wx_share_miniapp_for_qq";
  public static final String ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_SDK = "mini_record_wx_share_miniapp_for_sdk";
  public static final String ACTION_PA_FOLLOW = "public_account_follow";
  public static final String ACTION_PA_IS_FOLLOW = "public_account_is_follow";
  public static final String ACTION_PRELOAD_LOADING_AD = "preload_loading_ad";
  public static final String ACTION_QUERY_MINI_APP_DATA = "query_mini_app_data";
  public static final String ACTION_QUERY_USER_TROOP_INFO = "query_user_troop_info";
  public static final String ACTION_RECORD_DURATION = "record_duration";
  public static final String ACTION_RECORD_DURATION_SDK_4239 = "record_duration_sdk_4239";
  public static final String ACTION_SYNC_MINI_APP_DATA = "sync_mini_app_data";
  public static final String ACTION_UPDATE_ENTRY_LIST = "update_entry_list";
  public static final String ACTION_UPLOAD_USER_LOG = "upload_user_log";
  public static final String NAME = "MiniAppTransferModule";
  private static final String NOTIFY_NATIVE_UPDATEAPPLIST = "updateAppList";
  public static final int RESULT_CODE_SUCCESS = 0;
  private static final String TAG = "MiniAppTransferModule";
  private static MiniAppTransferModule sInstance;
  private CardObserver cardObserver = new MiniAppTransferModule.3(this);
  private AtomicBoolean mSendingRequest = new AtomicBoolean(false);
  private int noDisturbModeCallbackId = -1;
  
  public MiniAppTransferModule(String paramString)
  {
    super(paramString);
  }
  
  public static MiniAppTransferModule getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MiniAppTransferModule("MiniAppTransferModule");
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private EIPCResult innerOnCall(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    int i = paramString.hashCode();
    if (i != -813183335)
    {
      if ((i == 795053182) && (paramString.equals("public_account_is_follow")))
      {
        i = 0;
        break label56;
      }
    }
    else if (paramString.equals("public_account_follow"))
    {
      i = 1;
      break label56;
    }
    i = -1;
    label56:
    if (i != 0)
    {
      if (i == 1) {
        PublicAccountUtil.followPA(paramQQAppInterface, paramBundle, this, paramInt);
      }
    }
    else {
      PublicAccountUtil.isPAFollow(paramQQAppInterface, paramBundle, this, paramInt);
    }
    return null;
  }
  
  private void updateNoDisturbMode(boolean paramBoolean, int paramInt)
  {
    boolean bool = FriendsStatusUtil.a(BaseApplicationImpl.getContext());
    if (bool == paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("noDisturbMode : ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("; return.");
      QLog.d("MiniAppTransferModule", 1, ((StringBuilder)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putString("errMsg", "same mode");
      callbackResult(paramInt, EIPCResult.createResult(-102, (Bundle)localObject));
      return;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      int j = HttpUtil.getNetWorkType();
      int i = j;
      if (j == -1) {
        i = 2;
      }
      if (i == 0)
      {
        QLog.d("MiniAppTransferModule", 1, "NetType cannot connect, return.");
        localObject = new Bundle();
        ((Bundle)localObject).putString("errMsg", "Network cannot connect");
        callbackResult(paramInt, EIPCResult.createResult(-102, (Bundle)localObject));
        return;
      }
      if (this.mSendingRequest.compareAndSet(true, true))
      {
        QLog.d("MiniAppTransferModule", 1, "Request too frequently, return.");
        localObject = new Bundle();
        ((Bundle)localObject).putString("errMsg", "Request too frequently");
        callbackResult(paramInt, EIPCResult.createResult(-102, (Bundle)localObject));
        return;
      }
      this.mSendingRequest.set(true);
      ((QQAppInterface)localObject).addObserver(this.cardObserver, true);
      this.noDisturbModeCallbackId = paramInt;
      if (paramBoolean)
      {
        long l = NetConnInfoCenter.getServerTime();
        ((CardHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((int)(l + 3600L), "", "not_disturb_from_miniapp");
        return;
      }
      ((CardHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(0, "", "not_disturb_from_miniapp");
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("action = ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", params = ");
    ((StringBuilder)localObject1).append(paramBundle.toString());
    QLog.d("MiniAppTransferModule", 2, ((StringBuilder)localObject1).toString());
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppTransferModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    Object localObject2;
    if ("update_entry_list".equals(paramString)) {
      localObject2 = paramBundle.getString("data");
    }
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject3 = ((JSONObject)localObject2).optString("command");
      if (MiniAppConfProcessor.e()) {
        ((DesktopDataManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).updateEntryList((JSONObject)localObject2);
      } else if ("updateAppList".equals(localObject3)) {
        ((MiniAppUserAppInfoListManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER)).sendUserAppListRequest(Long.parseLong(((QQAppInterface)localObject1).getCurrentAccountUin()), 20L);
      }
    }
    catch (Exception localException3)
    {
      Object localObject3;
      label193:
      int i;
      int j;
      Object localObject4;
      break label193;
    }
    QLog.e("MiniAppTransferModule", 2, "onRemoteInvoke cannot get QQAppInterface");
    break label1596;
    if ("sync_mini_app_data".equals(paramString))
    {
      localObject3 = paramBundle.getString("appid");
      i = paramBundle.getInt("topType");
      j = paramBundle.getInt("verType");
      if (MiniAppConfProcessor.e())
      {
        ThreadManager.getUIHandler().post(new MiniAppTransferModule.1(this, (AppRuntime)localObject1, (String)localObject3, i, paramInt, j));
      }
      else
      {
        localObject2 = (MiniAppUserAppInfoListManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          if ((i == 1) && (((MiniAppUserAppInfoListManager)localObject2).getTopMiniAppNumber() >= 10))
          {
            callbackResult(paramInt, EIPCResult.createResult(-100, null));
            return null;
          }
          localObject3 = ((MiniAppUserAppInfoListManager)localObject2).findMiniApp((String)localObject3, j);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("miniappInfo : ");
          ((StringBuilder)localObject4).append(localObject3);
          QLog.d("MiniAppTransferModule", 2, ((StringBuilder)localObject4).toString());
          if (localObject3 != null)
          {
            ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3).topType = i;
            if (((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3).topType == 1) {
              ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3).updateTimeStamp();
            }
            ((MiniAppUserAppInfoListManager)localObject2).updateMiniAppTopStatus((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3);
            callbackResult(paramInt, EIPCResult.createResult(0, null));
          }
        }
      }
    }
    else if ("query_mini_app_data".equals(paramString))
    {
      localObject2 = paramBundle.getString("appid");
      i = paramBundle.getInt("verType");
      if (MiniAppConfProcessor.e())
      {
        localObject3 = (DesktopDataManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
        if ((localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break label1596;
        }
      }
    }
    label780:
    label1596:
    try
    {
      localObject2 = ((DesktopDataManager)localObject3).findTopMiniApp((String)localObject2, i);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("miniappInfo : ");
      ((StringBuilder)localObject3).append(localObject2);
      QLog.d("MiniAppTransferModule", 2, ((StringBuilder)localObject3).toString());
      localObject3 = new Bundle();
      if (localObject2 != null)
      {
        ((Bundle)localObject3).putParcelable("miniappinfo", (Parcelable)localObject2);
        ((Bundle)localObject3).putInt("topType", 1);
      }
      else
      {
        ((Bundle)localObject3).putInt("topType", 0);
      }
      localObject2 = MiniAppConfProcessor.a().p();
      if (localObject2 != null) {
        ((Bundle)localObject3).putIntegerArrayList("backHomeSceneList", (ArrayList)localObject2);
      }
      callbackResult(paramInt, EIPCResult.createResult(0, (Bundle)localObject3));
    }
    catch (Throwable localThrowable1)
    {
      label612:
      label1397:
      break label612;
    }
    callbackResult(paramInt, EIPCResult.createResult(-102, null));
    break label1596;
    localObject3 = (MiniAppUserAppInfoListManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if ((localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {}
    try
    {
      localObject2 = ((MiniAppUserAppInfoListManager)localObject3).findTopMiniApp((String)localObject2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("miniappInfo : ");
      ((StringBuilder)localObject3).append(localObject2);
      QLog.d("MiniAppTransferModule", 2, ((StringBuilder)localObject3).toString());
      localObject3 = new Bundle();
      if (localObject2 != null)
      {
        ((Bundle)localObject3).putParcelable("miniappinfo", (Parcelable)localObject2);
        ((Bundle)localObject3).putInt("topType", 1);
      }
      else
      {
        ((Bundle)localObject3).putInt("topType", 0);
      }
      localObject2 = MiniAppConfProcessor.a().p();
      if (localObject2 != null) {
        ((Bundle)localObject3).putIntegerArrayList("backHomeSceneList", (ArrayList)localObject2);
      }
      callbackResult(paramInt, EIPCResult.createResult(0, (Bundle)localObject3));
    }
    catch (Throwable localThrowable2)
    {
      break label780;
    }
    callbackResult(paramInt, EIPCResult.createResult(-102, null));
    break label1596;
    if ("upload_user_log".equals(paramString))
    {
      localObject2 = paramBundle.getString("appid");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" ACTION_UPLOAD_USER_LOG : ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("MiniAppTransferModule", 2, ((StringBuilder)localObject3).toString());
      ReportLogUtil.compressAndUploadLog((String)localObject2);
    }
    else if ("launch_report".equals(paramString))
    {
      paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
      localObject2 = (MiniAppConfig)paramBundle.getParcelable("app_config");
      localObject3 = paramBundle.getString("sub_action");
      MiniAppReportManager.reportToDc04239((MiniAppConfig)localObject2, paramBundle.getString("path"), "page_view", (String)localObject3, paramBundle.getString("reserves"), paramBundle.getString("app_type"), paramBundle.getBoolean("x5_enable"));
    }
    else if ("launch_report2".equals(paramString))
    {
      paramBundle.setClassLoader(MiniAppReportManager2.class.getClassLoader());
      localObject2 = (MiniAppConfig)paramBundle.getParcelable("app_config");
      localObject3 = paramBundle.getString("sub_action");
      localObject4 = paramBundle.getString("path");
      MiniAppReportManager2.reportPageView((String)localObject3, paramBundle.getString("reserves"), (String)localObject4, (MiniAppConfig)localObject2);
    }
    else if ("launch_report_js_error".equals(paramString))
    {
      paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
      MiniAppReportManager.setJsError((MiniAppConfig)paramBundle.getParcelable("app_config"));
    }
    else if ("launch_report_app_pause".equals(paramString))
    {
      paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
      MiniAppReportManager.setAppPauseTime((MiniAppConfig)paramBundle.getParcelable("app_config"));
    }
    else if ("launch_report_app_resume".equals(paramString))
    {
      paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
      MiniAppReportManager.clearAppPauseTime((MiniAppConfig)paramBundle.getParcelable("app_config"));
    }
    else if ("flush_report_data".equals(paramString))
    {
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppTransferModule.2(this));
    }
    else if ("record_duration".equals(paramString))
    {
      paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
      MiniAppReportManager.recordDuration((MiniAppConfig)paramBundle.getParcelable("app_config"), paramBundle.getLong("add_duration_ms"));
    }
    else if (!"launch_report_sdk_4239".equals(paramString)) {}
    try
    {
      paramBundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
      Object localObject5 = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("app_config");
      localObject2 = paramBundle.getString("sub_action");
      localObject3 = paramBundle.getString("path");
      localObject4 = paramBundle.getString("reserves");
      String str = paramBundle.getString("app_type");
      boolean bool = paramBundle.getBoolean("x5_enable");
      localObject5 = MiniSdkUtil.b((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject5);
      if (localObject5 == null) {
        break label1596;
      }
      MiniAppReportManager.reportToDc04239((MiniAppConfig)localObject5, (String)localObject3, "page_view", (String)localObject2, (String)localObject4, str, bool);
    }
    catch (Exception localException4)
    {
      long l;
      break label1596;
    }
    if ("record_duration_sdk_4239".equals(paramString))
    {
      paramBundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
      localObject2 = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("app_config");
      l = paramBundle.getLong("add_duration_ms");
      localObject2 = MiniSdkUtil.b((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject2);
      if (localObject2 != null) {
        MiniAppReportManager.recordDuration((MiniAppConfig)localObject2, l);
      }
    }
    else if (!"query_user_troop_info".equals(paramString)) {}
    try
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("hasCreateOrManageTroop", TroopUtils.a());
      callbackResult(paramInt, EIPCResult.createResult(0, (Bundle)localObject2));
    }
    catch (Exception localException5)
    {
      break label1397;
    }
    callbackResult(paramInt, EIPCResult.createResult(-102, null));
    break label1596;
    if ("mini_record_wx_share_miniapp_for_sdk".equals(paramString)) {
      try
      {
        paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("MiniAppInfoForSDK");
        WXShareHelperFromQQMiniApp.getInstance().recordMiniAppInfoFromSDK((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject2);
      }
      catch (Exception localException1)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_SDK get an exception:");
        ((StringBuilder)localObject3).append(localException1.toString());
        QLog.e("MiniAppTransferModule", 1, ((StringBuilder)localObject3).toString());
      }
    } else if ("mini_record_wx_share_miniapp_for_qq".equals(paramString)) {
      try
      {
        paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
        com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = (com.tencent.mobileqq.mini.apkg.MiniAppInfo)paramBundle.getParcelable("MiniAppInfoForQQ");
        localObject3 = (LaunchParam)paramBundle.getParcelable("MiniAppLaunchParamForQQ");
        WXShareHelperFromQQMiniApp.getInstance().recordMiniAppInfoFromQQ(localMiniAppInfo, (LaunchParam)localObject3);
      }
      catch (Exception localException2)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ get an exception:");
        ((StringBuilder)localObject3).append(localException2.toString());
        QLog.e("MiniAppTransferModule", 1, ((StringBuilder)localObject3).toString());
      }
    }
    return innerOnCall((QQAppInterface)localObject1, paramString, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppTransferModule
 * JD-Core Version:    0.7.0.1
 */