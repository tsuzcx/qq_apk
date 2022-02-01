package com.tencent.mobileqq.qqvideoplatform.api;

import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.imp.QQLoadSoImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQLogImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQRegisterTVideoImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQReportImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQThreadMgrImp;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQVideoPlaySDKManager
{
  private static int jdField_a_of_type_Int = 1;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static int b = 12;
  
  static
  {
    a();
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return "";
    }
    return localAppRuntime.getAccount();
  }
  
  public static void a()
  {
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        LogUtil.setLogImp(new QQLogImp());
        ThreadUtil.setThreadImp(new QQThreadMgrImp());
        LoadSoUtil.setLoadSoImp(new QQLoadSoImp());
        ReportUtil.setReportImp(new QQReportImp());
        RegisterTVideoUtil.setRegisterTVideoImp(new QQRegisterTVideoImp());
        jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext, SDKInitListener paramSDKInitListener)
  {
    boolean bool2 = true;
    SuperPlayerSdkOption localSuperPlayerSdkOption = SuperPlayerSdkOption.option();
    localSuperPlayerSdkOption.deviceId = UserAction.getQIMEI();
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localSuperPlayerSdkOption.uid = a();
      if (CUKingCardHelper.a() != 1) {
        break label237;
      }
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      if (i != 0) {
        localObject = "true";
      }
      try
      {
        for (;;)
        {
          SuperPlayerSDKMgr.setUpcInfo((String)localObject, 1);
          try
          {
            if (Aladdin.getConfig(422).getIntegerFromString("server_config_enable", jdField_a_of_type_Int) != jdField_a_of_type_Int) {
              break label264;
            }
            bool1 = true;
            localSuperPlayerSdkOption.serverConfigEnable = bool1;
            localSuperPlayerSdkOption.configRequestIntervalInHour = Aladdin.getConfig(422).getIntegerFromString("request_interval_inhour", b);
            localObject = new JSONObject(localSuperPlayerSdkOption.proxyConfigStr);
            AladdinConfig localAladdinConfig = Aladdin.getConfig(392);
            if (localAladdinConfig.getIntegerFromString("enable_xg_p2p", 0) != 1) {
              break label269;
            }
            bool1 = true;
            ((JSONObject)localObject).put("EnableCarrierP2PDownload", bool1);
            if (localAladdinConfig.getIntegerFromString("enable_xg_pcdn", 0) != 1) {
              break label274;
            }
            bool1 = true;
            ((JSONObject)localObject).put("PCDN4gEnable", bool1);
            if (localAladdinConfig.getIntegerFromString("enable_preplay_pcdn", 0) != 1) {
              break label279;
            }
            bool1 = true;
            ((JSONObject)localObject).put("PrePlayDownloadGoPcdn", bool1);
            if (localAladdinConfig.getIntegerFromString("enable_predownload_pcdn", 0) != 1) {
              break label284;
            }
            bool1 = bool2;
            ((JSONObject)localObject).put("PrepareDownloadGoPcdn", bool1);
            localSuperPlayerSdkOption.proxyConfigStr = ((JSONObject)localObject).toString();
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              boolean bool1;
              if (LogUtil.isColorLevel()) {
                LogUtil.e("[VideoPlatform]QQVideoPlaySDKManager", 2, "initSDKAsync", localThrowable2);
              }
            }
          }
          VideoPlaySDKManager.getInstance().initSDKAsync(paramContext, localSuperPlayerSdkOption, paramSDKInitListener);
          return;
          label237:
          i = 0;
          break;
          localObject = "";
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          LogUtil.e("[VideoPlatform]QQVideoPlaySDKManager", 2, "initSDKAsync setUpcInfo() ", localThrowable1);
          continue;
          label264:
          bool1 = false;
          continue;
          label269:
          bool1 = false;
          continue;
          label274:
          bool1 = false;
          continue;
          label279:
          bool1 = false;
          continue;
          label284:
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean a()
  {
    return VideoPlaySDKManager.getInstance().isSDKReady();
  }
  
  public static boolean b()
  {
    return VideoPlaySDKManager.getInstance().isSoLoadSuc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager
 * JD-Core Version:    0.7.0.1
 */