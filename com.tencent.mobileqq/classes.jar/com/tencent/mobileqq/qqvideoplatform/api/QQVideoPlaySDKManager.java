package com.tencent.mobileqq.qqvideoplatform.api;

import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqvideoplatform.imp.QQLoadSoImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQLogImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQRegisterTVideoImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQReportImp;
import com.tencent.mobileqq.qqvideoplatform.imp.QQThreadMgrImp;
import com.tencent.mobileqq.utils.CUKingCardUtilsTmp;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QQVideoPlaySDKManager
{
  private static int jdField_a_of_type_Int = 1;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static int b = 12;
  private static int c = 1000;
  
  static {}
  
  public static String a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      return localAppRuntime.getAccount();
    }
    return "";
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
    SuperPlayerSdkOption localSuperPlayerSdkOption = SuperPlayerSdkOption.option();
    localSuperPlayerSdkOption.deviceId = UserAction.getQIMEI();
    if (MobileQQ.sProcessId == 1)
    {
      localSuperPlayerSdkOption.uid = a();
      int i;
      if (CUKingCardUtilsTmp.a() == 1) {
        i = 1;
      } else {
        i = 0;
      }
      String str;
      if (i != 0) {
        str = "true";
      } else {
        str = "";
      }
      SuperPlayerSDKMgr.setUpcInfo(str, 1);
    }
    try
    {
      a(localSuperPlayerSdkOption);
    }
    catch (Throwable localThrowable)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.e("[VideoPlatform]QQVideoPlaySDKManager", 2, "initSDKAsync", localThrowable);
      }
    }
    VideoPlaySDKManager.getInstance().initSDKAsync(paramContext, localSuperPlayerSdkOption, paramSDKInitListener);
  }
  
  private static void a(SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    Object localObject1 = Aladdin.getConfig(422);
    boolean bool;
    if (((AladdinConfig)localObject1).getIntegerFromString("server_config_enable", jdField_a_of_type_Int) == jdField_a_of_type_Int) {
      bool = true;
    } else {
      bool = false;
    }
    paramSuperPlayerSdkOption.serverConfigEnable = bool;
    paramSuperPlayerSdkOption.configRequestIntervalInHour = ((AladdinConfig)localObject1).getIntegerFromString("request_interval_inhour", b);
    SuperPlayerSDKMgr.setUpdatePlayerInfoInterval(((AladdinConfig)localObject1).getIntegerFromString("update_player_info_interval", c));
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = Aladdin.getConfig(392);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_xg_p2p", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localJSONObject.put("EnableCarrierP2PDownload", bool);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_xg_pcdn", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localJSONObject.put("PCDN4gEnable", bool);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_preplay_pcdn", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localJSONObject.put("PrePlayDownloadGoPcdn", bool);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_predownload_pcdn", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localJSONObject.put("PrepareDownloadGoPcdn", bool);
    localObject1 = ((AladdinConfig)localObject1).getAll();
    localObject2 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      Object localObject3 = ((Map)localObject1).get(str);
      if (localObject3 != null) {
        if (Boolean.TRUE.toString().equals(localObject3)) {
          localJSONObject.put(str, true);
        } else if (Boolean.FALSE.toString().equals(localObject3)) {
          localJSONObject.put(str, false);
        }
      }
      try
      {
        localJSONObject.put(str, Integer.parseInt((String)localObject3));
      }
      catch (Exception localException)
      {
        label309:
        break label309;
      }
      localJSONObject.put(str, localObject3);
    }
    paramSuperPlayerSdkOption.userConfig = localJSONObject.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager
 * JD-Core Version:    0.7.0.1
 */