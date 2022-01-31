package com.tencent.mobileqq.mini.report;

import ajrf;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import bbtm;
import bfpk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mqq.os.MqqHandler;

public class MiniProgramLpReportDC04902
{
  private static String DC_TABLE_VALUE_APPID = "appid";
  private static String DC_TABLE_VALUE_ATTACH_INFO;
  private static long DC_TABLE_VALUE_AVG_CPU = 0L;
  private static long DC_TABLE_VALUE_AVG_MEM = 0L;
  private static String DC_TABLE_VALUE_END_TIME = currentTimeString();
  private static long DC_TABLE_VALUE_F_100 = 0L;
  private static long DC_TABLE_VALUE_F_20 = 0L;
  private static long DC_TABLE_VALUE_F_33 = 0L;
  private static long DC_TABLE_VALUE_F_50 = 0L;
  private static long DC_TABLE_VALUE_F_LONG = 0L;
  private static long DC_TABLE_VALUE_F_MAX = 0L;
  private static long DC_TABLE_VALUE_F_MAX_TIME_MILLIS = 0L;
  private static long DC_TABLE_VALUE_MAX_CPU = 0L;
  private static long DC_TABLE_VALUE_MAX_MEM = 0L;
  private static String DC_TABLE_VALUE_NETWORK_GATEWAY_IP;
  private static String DC_TABLE_VALUE_PLATFORM = "Android";
  private static String DC_TABLE_VALUE_QUA = bfpk.a();
  private static String DC_TABLE_VALUE_START_TIME = currentTimeString();
  private static String DC_TABLE_VALUE_TEXTURE_OFFLINE;
  private static final Runnable PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE = new MiniProgramLpReportDC04902.1();
  private static final String TAG = "MiniProgramLpReportDC04";
  private static boolean hasReportStart;
  
  public static void accumulateDrawFrameDuration(long paramLong)
  {
    if (paramLong <= 20L) {
      DC_TABLE_VALUE_F_20 += paramLong;
    }
    for (;;)
    {
      if (paramLong > DC_TABLE_VALUE_F_MAX)
      {
        DC_TABLE_VALUE_F_MAX = paramLong;
        DC_TABLE_VALUE_F_MAX_TIME_MILLIS = System.currentTimeMillis();
      }
      return;
      if (paramLong <= 33L) {
        DC_TABLE_VALUE_F_33 += paramLong;
      } else if (paramLong <= 50L) {
        DC_TABLE_VALUE_F_50 += paramLong;
      } else if (paramLong <= 100L) {
        DC_TABLE_VALUE_F_100 += paramLong;
      } else {
        DC_TABLE_VALUE_F_LONG += paramLong;
      }
    }
  }
  
  private static String currentTimeString()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
  }
  
  public static void reportGameEnd(float paramFloat1, float paramFloat2)
  {
    DC_TABLE_VALUE_END_TIME = currentTimeString();
    ThreadManager.getSubThreadHandler().removeCallbacks(PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE);
    try
    {
      DC_TABLE_VALUE_ATTACH_INFO = String.valueOf(GameLoadManager.g().getGameEngine().getTargetFPS());
      String str = DC_TABLE_VALUE_APPID + '|' + DC_TABLE_VALUE_QUA + '|' + DC_TABLE_VALUE_START_TIME + '|' + DC_TABLE_VALUE_END_TIME + '|' + DC_TABLE_VALUE_F_20 + '|' + DC_TABLE_VALUE_F_33 + '|' + DC_TABLE_VALUE_F_50 + '|' + DC_TABLE_VALUE_F_100 + '|' + DC_TABLE_VALUE_F_LONG + '|' + DC_TABLE_VALUE_AVG_MEM + '|' + DC_TABLE_VALUE_MAX_MEM + '|' + DC_TABLE_VALUE_AVG_CPU + '|' + DC_TABLE_VALUE_MAX_CPU + '|' + DC_TABLE_VALUE_ATTACH_INFO + '|' + DC_TABLE_VALUE_F_MAX_TIME_MILLIS + '|' + DC_TABLE_VALUE_F_MAX + '|' + (int)paramFloat2 + '|' + (int)paramFloat1 + '|' + DC_TABLE_VALUE_TEXTURE_OFFLINE + '|' + MiniProgramReportHelper.getNetworkType() + '|' + DC_TABLE_VALUE_NETWORK_GATEWAY_IP + '|' + HwNetworkUtil.getCurrentWifiSSID(bbtm.a().a()) + '|' + DC_TABLE_VALUE_PLATFORM + '|' + Build.MODEL + '|' + Build.VERSION.RELEASE;
      Bundle localBundle = new Bundle();
      localBundle.putStringArray("data", new String[] { str });
      localBundle.putString("log_key", "dc04902");
      QLog.d("MiniProgramLpReportDC04", 1, new Object[] { "reportGameEnd ", str });
      AppBrandProxy.g().sendCmd("cmd_dc_report_log_key_data", localBundle, null);
      hasReportStart = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniProgramLpReportDC04", 1, "reportGameEnd ", localThrowable);
      }
    }
  }
  
  public static void reportGameStart()
  {
    if (!hasReportStart)
    {
      hasReportStart = true;
      DC_TABLE_VALUE_APPID = GameInfoManager.g().getAppId();
      DC_TABLE_VALUE_START_TIME = currentTimeString();
      ThreadManager.getSubThreadHandler().postDelayed(PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE, 1000L);
    }
  }
  
  public static void reportToServer(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (ajrf)((QQAppInterface)localObject).a(5);
        if (localObject != null) {
          ((ajrf)localObject).a(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04902
 * JD-Core Version:    0.7.0.1
 */