package com.tencent.mobileqq.mini.reuse;

import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import eipc.EIPCResult;
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
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniAppTransferModule("MiniAppTransferModule");
      }
      return sInstance;
    }
    finally {}
  }
  
  private void updateNoDisturbMode(boolean paramBoolean, int paramInt)
  {
    boolean bool = FriendsStatusUtil.a(BaseApplicationImpl.getContext());
    Object localObject;
    if (bool == paramBoolean)
    {
      QLog.d("MiniAppTransferModule", 1, "noDisturbMode : " + bool + "; return.");
      localObject = new Bundle();
      ((Bundle)localObject).putString("errMsg", "same mode");
      callbackResult(paramInt, EIPCResult.createResult(-102, (Bundle)localObject));
    }
    do
    {
      return;
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (localObject == null);
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
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("MiniAppTransferModule", 2, "action = " + paramString + ", params = " + paramBundle.toString());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppTransferModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
    }
    do
    {
      for (;;)
      {
        return null;
        if ("update_entry_list".equals(paramString))
        {
          paramString = paramBundle.getString("data");
          try
          {
            paramString = new JSONObject(paramString);
            paramBundle = paramString.optString("command");
            if (MiniAppConfProcessor.c())
            {
              ((DesktopDataManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).updateEntryList(paramString);
              return null;
            }
          }
          catch (Exception paramString)
          {
            QLog.e("MiniAppTransferModule", 2, "onRemoteInvoke cannot get QQAppInterface");
            return null;
          }
          if ("updateAppList".equals(paramBundle))
          {
            ((MiniAppUserAppInfoListManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER)).sendUserAppListRequest(Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin()), 20L);
            return null;
          }
        }
        else
        {
          int i;
          if ("sync_mini_app_data".equals(paramString))
          {
            paramString = paramBundle.getString("appid");
            i = paramBundle.getInt("topType");
            int j = paramBundle.getInt("verType");
            if (MiniAppConfProcessor.c())
            {
              ThreadManager.getUIHandler().post(new MiniAppTransferModule.1(this, (AppRuntime)localObject, paramString, i, paramInt, j));
              return null;
            }
            paramBundle = (MiniAppUserAppInfoListManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
            if ((paramBundle != null) && (!TextUtils.isEmpty(paramString)))
            {
              if ((i == 1) && (paramBundle.getTopMiniAppNumber() >= 10))
              {
                callbackResult(paramInt, EIPCResult.createResult(-100, null));
                return null;
              }
              paramString = paramBundle.findMiniApp(paramString, j);
              QLog.d("MiniAppTransferModule", 2, "miniappInfo : " + paramString);
              if (paramString != null)
              {
                paramString.topType = i;
                if (paramString.topType == 1) {
                  paramString.updateTimeStamp();
                }
                paramBundle.updateMiniAppTopStatus(paramString);
                callbackResult(paramInt, EIPCResult.createResult(0, null));
                return null;
              }
            }
          }
          else if ("query_mini_app_data".equals(paramString))
          {
            paramString = paramBundle.getString("appid");
            i = paramBundle.getInt("verType");
            if (MiniAppConfProcessor.c())
            {
              paramBundle = (DesktopDataManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
              if ((paramBundle != null) && (!TextUtils.isEmpty(paramString))) {
                for (;;)
                {
                  try
                  {
                    paramBundle = paramBundle.findTopMiniApp(paramString, i);
                    QLog.d("MiniAppTransferModule", 2, "miniappInfo : " + paramBundle);
                    paramString = new Bundle();
                    if (paramBundle != null)
                    {
                      paramString.putParcelable("miniappinfo", paramBundle);
                      paramString.putInt("topType", 1);
                      paramBundle = MiniAppConfProcessor.a().a();
                      if (paramBundle != null) {
                        paramString.putIntegerArrayList("backHomeSceneList", paramBundle);
                      }
                      callbackResult(paramInt, EIPCResult.createResult(0, paramString));
                      return null;
                    }
                  }
                  catch (Throwable paramString)
                  {
                    callbackResult(paramInt, EIPCResult.createResult(-102, null));
                    return null;
                  }
                  paramString.putInt("topType", 0);
                }
              }
            }
            else
            {
              paramBundle = (MiniAppUserAppInfoListManager)((AppRuntime)localObject).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
              if ((paramBundle != null) && (!TextUtils.isEmpty(paramString))) {
                for (;;)
                {
                  try
                  {
                    paramBundle = paramBundle.findTopMiniApp(paramString);
                    QLog.d("MiniAppTransferModule", 2, "miniappInfo : " + paramBundle);
                    paramString = new Bundle();
                    if (paramBundle != null)
                    {
                      paramString.putParcelable("miniappinfo", paramBundle);
                      paramString.putInt("topType", 1);
                      paramBundle = MiniAppConfProcessor.a().a();
                      if (paramBundle != null) {
                        paramString.putIntegerArrayList("backHomeSceneList", paramBundle);
                      }
                      callbackResult(paramInt, EIPCResult.createResult(0, paramString));
                      return null;
                    }
                  }
                  catch (Throwable paramString)
                  {
                    callbackResult(paramInt, EIPCResult.createResult(-102, null));
                    return null;
                  }
                  paramString.putInt("topType", 0);
                }
              }
            }
          }
          else
          {
            if ("upload_user_log".equals(paramString))
            {
              paramString = paramBundle.getString("appid");
              QLog.d("MiniAppTransferModule", 2, " ACTION_UPLOAD_USER_LOG : " + paramString);
              ReportLogUtil.compressAndUploadLog(paramString);
              return null;
            }
            if ("launch_report".equals(paramString))
            {
              paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
              paramString = (MiniAppConfig)paramBundle.getParcelable("app_config");
              localObject = paramBundle.getString("sub_action");
              MiniAppReportManager.reportToDc04239(paramString, paramBundle.getString("path"), "page_view", (String)localObject, paramBundle.getString("reserves"), paramBundle.getString("app_type"), paramBundle.getBoolean("x5_enable"));
              return null;
            }
            String str1;
            if ("launch_report2".equals(paramString))
            {
              paramBundle.setClassLoader(MiniAppReportManager2.class.getClassLoader());
              paramString = (MiniAppConfig)paramBundle.getParcelable("app_config");
              localObject = paramBundle.getString("sub_action");
              str1 = paramBundle.getString("path");
              MiniAppReportManager2.reportPageView((String)localObject, paramBundle.getString("reserves"), str1, paramString);
              return null;
            }
            if ("launch_report_js_error".equals(paramString))
            {
              paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
              MiniAppReportManager.setJsError((MiniAppConfig)paramBundle.getParcelable("app_config"));
              return null;
            }
            if ("launch_report_app_pause".equals(paramString))
            {
              paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
              MiniAppReportManager.setAppPauseTime((MiniAppConfig)paramBundle.getParcelable("app_config"));
              return null;
            }
            if ("launch_report_app_resume".equals(paramString))
            {
              paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
              MiniAppReportManager.clearAppPauseTime((MiniAppConfig)paramBundle.getParcelable("app_config"));
              return null;
            }
            if ("flush_report_data".equals(paramString))
            {
              MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppTransferModule.2(this));
              return null;
            }
            if ("record_duration".equals(paramString))
            {
              paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
              MiniAppReportManager.recordDuration((MiniAppConfig)paramBundle.getParcelable("app_config"), paramBundle.getLong("add_duration_ms"));
              return null;
            }
            if ("launch_report_sdk_4239".equals(paramString)) {
              try
              {
                paramBundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
                com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("app_config");
                paramString = paramBundle.getString("sub_action");
                localObject = paramBundle.getString("path");
                str1 = paramBundle.getString("reserves");
                String str2 = paramBundle.getString("app_type");
                boolean bool = paramBundle.getBoolean("x5_enable");
                paramBundle = MiniSdkUtil.a(localMiniAppInfo);
                if (paramBundle == null) {
                  continue;
                }
                MiniAppReportManager.reportToDc04239(paramBundle, (String)localObject, "page_view", paramString, str1, str2, bool);
                return null;
              }
              catch (Exception paramString)
              {
                return null;
              }
            } else if ("record_duration_sdk_4239".equals(paramString)) {
              try
              {
                paramBundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
                paramString = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("app_config");
                long l = paramBundle.getLong("add_duration_ms");
                paramString = MiniSdkUtil.a(paramString);
                if (paramString != null)
                {
                  MiniAppReportManager.recordDuration(paramString, l);
                  return null;
                }
              }
              catch (Exception paramString)
              {
                return null;
              }
            }
          }
        }
      }
      if ("query_user_troop_info".equals(paramString)) {
        try
        {
          paramString = new Bundle();
          paramString.putBoolean("hasCreateOrManageTroop", TroopUtils.a());
          callbackResult(paramInt, EIPCResult.createResult(0, paramString));
          return null;
        }
        catch (Exception paramString)
        {
          callbackResult(paramInt, EIPCResult.createResult(-102, null));
          return null;
        }
      }
      if ("mini_record_wx_share_miniapp_for_sdk".equals(paramString)) {
        try
        {
          paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
          paramString = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("MiniAppInfoForSDK");
          WXShareHelperFromQQMiniApp.getInstance().recordMiniAppInfoFromSDK(paramString);
          return null;
        }
        catch (Exception paramString)
        {
          QLog.e("MiniAppTransferModule", 1, "ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_SDK get an exception:" + paramString.toString());
          return null;
        }
      }
    } while (!"mini_record_wx_share_miniapp_for_qq".equals(paramString));
    try
    {
      paramBundle.setClassLoader(MiniProgramLpReportDC04239.class.getClassLoader());
      paramString = (com.tencent.mobileqq.mini.apkg.MiniAppInfo)paramBundle.getParcelable("MiniAppInfoForQQ");
      paramBundle = (LaunchParam)paramBundle.getParcelable("MiniAppLaunchParamForQQ");
      WXShareHelperFromQQMiniApp.getInstance().recordMiniAppInfoFromQQ(paramString, paramBundle);
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("MiniAppTransferModule", 1, "ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ get an exception:" + paramString.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppTransferModule
 * JD-Core Version:    0.7.0.1
 */