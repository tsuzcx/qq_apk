package com.tencent.mobileqq.qqvideoplatform.api;

import android.content.Context;
import android.text.TextUtils;
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
  public static final int CONFIG_SP_SDK_CONFIG = 422;
  public static final int CONFIG_VIDEO_P2P = 392;
  public static final int CONFIG_VIOLA_EXPERIMENT = 478;
  private static final int DEAFULT_CONFIG_PROXY_MAX_MEMORY_SIZE = 100;
  private static final int DEFAULT_CONFIG_ENABLE = 1;
  private static final int DEFAULT_CONFIG_REQUEST_INTERVAL_IN_HOUR = 12;
  private static final int DEFAULT_CONFIG_UPDATE_PLAYER_INFO_INTERVAL = 1000;
  public static final String TAG = "[VideoPlatform]QQVideoPlaySDKManager";
  private static volatile boolean hasInitQQImp;
  
  static {}
  
  public static String getUid()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      return localAppRuntime.getAccount();
    }
    return "";
  }
  
  private static void initConfig(SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    Object localObject1 = Aladdin.getConfig(422);
    boolean bool2 = true;
    boolean bool1;
    if (((AladdinConfig)localObject1).getIntegerFromString("server_config_enable", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramSuperPlayerSdkOption.serverConfigEnable = bool1;
    paramSuperPlayerSdkOption.configRequestIntervalInHour = ((AladdinConfig)localObject1).getIntegerFromString("request_interval_inhour", 12);
    SuperPlayerSDKMgr.setUpdatePlayerInfoInterval(((AladdinConfig)localObject1).getIntegerFromString("update_player_info_interval", 1000));
    int i = ((AladdinConfig)localObject1).getIntegerFromString("proxy_max_memory_size", 100);
    if (i != 100) {
      SuperPlayerSDKMgr.setProxyMaxUseMemoryMB(i);
    }
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = Aladdin.getConfig(392);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_xg_p2p", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localJSONObject.put("EnableCarrierP2PDownload", bool1);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_xg_pcdn", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localJSONObject.put("PCDN4gEnable", bool1);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_preplay_pcdn", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localJSONObject.put("PrePlayDownloadGoPcdn", bool1);
    if (((AladdinConfig)localObject2).getIntegerFromString("enable_predownload_pcdn", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localJSONObject.put("PrepareDownloadGoPcdn", bool1);
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
        label342:
        break label342;
      }
      localJSONObject.put(str, localObject3);
    }
    paramSuperPlayerSdkOption.userConfig = localJSONObject.toString();
    if (Aladdin.getConfig(478).getIntegerFromString("bind_data_opm_open", 0) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramSuperPlayerSdkOption.isAsyncInit = bool1;
    paramSuperPlayerSdkOption.isAsyncInit |= false;
  }
  
  public static void initQQImp()
  {
    try
    {
      if (!hasInitQQImp)
      {
        LogUtil.setLogImp(new QQLogImp());
        ThreadUtil.setThreadImp(new QQThreadMgrImp());
        LoadSoUtil.setLoadSoImp(new QQLoadSoImp());
        ReportUtil.setReportImp(new QQReportImp());
        RegisterTVideoUtil.setRegisterTVideoImp(new QQRegisterTVideoImp());
        hasInitQQImp = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void initSDKAsync(Context paramContext, SDKInitListener paramSDKInitListener)
  {
    SuperPlayerSdkOption localSuperPlayerSdkOption = SuperPlayerSdkOption.option();
    localSuperPlayerSdkOption.deviceId = UserAction.getQIMEI();
    if (TextUtils.isEmpty(localSuperPlayerSdkOption.deviceId)) {
      loadQimeiAsync();
    }
    if (MobileQQ.sProcessId == 1)
    {
      localSuperPlayerSdkOption.uid = getUid();
      int i;
      if (CUKingCardUtilsTmp.a() == 1) {
        i = 1;
      } else {
        i = 0;
      }
      String str;
      if (i != 0) {
        str = String.valueOf(true);
      } else {
        str = "";
      }
      SuperPlayerSDKMgr.setUpcInfo(str, 1);
    }
    try
    {
      initConfig(localSuperPlayerSdkOption);
    }
    catch (Throwable localThrowable)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.e("[VideoPlatform]QQVideoPlaySDKManager", 2, "initSDKAsync", localThrowable);
      }
    }
    VideoPlaySDKManager.getInstance().initSDKAsync(paramContext, localSuperPlayerSdkOption, paramSDKInitListener);
  }
  
  public static boolean isSDKReady()
  {
    return VideoPlaySDKManager.getInstance().isSDKReady();
  }
  
  public static boolean isSoLoadSucess()
  {
    return VideoPlaySDKManager.getInstance().isSoLoadSuc();
  }
  
  private static void loadQimeiAsync()
  {
    UserAction.getQimei(new QQVideoPlaySDKManager.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager
 * JD-Core Version:    0.7.0.1
 */