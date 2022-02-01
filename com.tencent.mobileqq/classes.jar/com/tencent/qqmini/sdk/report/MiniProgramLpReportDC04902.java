package com.tencent.qqmini.sdk.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MiniProgramLpReportDC04902
{
  private static final String BEACON_EVENT_CODE = "mini_game_jank";
  private static final long BIG_JANK_TIME = 124999998L;
  private static String DC_TABLE_VALUE_APPID = "appid";
  private static String DC_TABLE_VALUE_ATTACH_INFO;
  private static long DC_TABLE_VALUE_AVG_CPU = 0L;
  private static long DC_TABLE_VALUE_AVG_MEM = 0L;
  private static String DC_TABLE_VALUE_END_TIME;
  private static long DC_TABLE_VALUE_F_100 = 0L;
  private static long DC_TABLE_VALUE_F_20 = 0L;
  private static long DC_TABLE_VALUE_F_33 = 0L;
  private static long DC_TABLE_VALUE_F_50 = 0L;
  private static long DC_TABLE_VALUE_F_LONG = 0L;
  private static long DC_TABLE_VALUE_F_MAX = 0L;
  private static long DC_TABLE_VALUE_F_MAX_TIME_MILLIS = 0L;
  private static long DC_TABLE_VALUE_MAX_CPU = 0L;
  private static long DC_TABLE_VALUE_MAX_MEM = 0L;
  private static String DC_TABLE_VALUE_NETWORK_GATEWAY_IP = null;
  private static String DC_TABLE_VALUE_PLATFORM = "android";
  private static String DC_TABLE_VALUE_QUA = QUAUtil.getPlatformQUA();
  private static String DC_TABLE_VALUE_START_TIME = currentTimeString();
  private static String DC_TABLE_VALUE_TEXTURE_OFFLINE;
  private static final int FRAME_TIME_COUNT = 3;
  private static final long JANK_TIME = 83333332L;
  private static final String KEY_APP_ID = "appId";
  private static final String KEY_BASE_LIB_VERSION = "baseLibVersion";
  private static final String KEY_BIG_JANK = "bigJank";
  private static final String KEY_IS_SDK = "isSdk";
  private static final String KEY_JANK = "jank";
  private static final String KEY_OS_VERSION = "osVersion";
  private static final String KEY_PHONE_MODEL = "phoneModel";
  private static final String KEY_QUA = "qua";
  private static final String KEY_TRITON_VERSION = "tritonVersion";
  private static final Runnable PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE;
  private static final String TAG = "MiniProgramLpReportDC04902";
  private static int bigJankCount;
  private static long[] frameTimes;
  private static boolean hasReportStart = false;
  private static int jankCount;
  private static long lastFrameUpdateTime;
  private static long startFrameTime;
  private static int totalFrameCount;
  
  static
  {
    DC_TABLE_VALUE_END_TIME = currentTimeString();
    DC_TABLE_VALUE_F_20 = 0L;
    DC_TABLE_VALUE_F_33 = 0L;
    DC_TABLE_VALUE_F_50 = 0L;
    DC_TABLE_VALUE_F_100 = 0L;
    DC_TABLE_VALUE_F_LONG = 0L;
    DC_TABLE_VALUE_AVG_MEM = 0L;
    DC_TABLE_VALUE_MAX_MEM = 0L;
    DC_TABLE_VALUE_AVG_CPU = 0L;
    DC_TABLE_VALUE_MAX_CPU = 0L;
    PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE = new MiniProgramLpReportDC04902.1();
    DC_TABLE_VALUE_ATTACH_INFO = null;
    DC_TABLE_VALUE_F_MAX_TIME_MILLIS = 0L;
    DC_TABLE_VALUE_F_MAX = 0L;
    DC_TABLE_VALUE_TEXTURE_OFFLINE = null;
  }
  
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
  
  private static void report(String paramString, Map<String, String> paramMap)
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null) {
      localChannelProxy.reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, paramString, paramMap);
    }
  }
  
  public static void reportGameEnd(float paramFloat1, float paramFloat2, String paramString1, String paramString2)
  {
    DC_TABLE_VALUE_END_TIME = currentTimeString();
    ThreadManager.getSubThreadHandler().removeCallbacks(PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE);
    double d3 = (lastFrameUpdateTime - startFrameTime) / 1000000.0D / 1000.0D / 60.0D;
    int i;
    double d1;
    label57:
    double d2;
    label65:
    Object localObject1;
    String str1;
    Object localObject2;
    if (d3 < 0.01D)
    {
      i = 1;
      if (i == 0) {
        break label721;
      }
      d1 = 0.0D;
      if (i == 0) {
        break label733;
      }
      d2 = 0.0D;
      QMLog.d("MiniProgramLpReportDC04902", "reportGameEnd: minuteFromStart=" + d3 + " jankCount=" + jankCount + " bigJankCount=" + bigJankCount);
      localObject1 = DC_TABLE_VALUE_APPID + '|' + DC_TABLE_VALUE_QUA + '|' + DC_TABLE_VALUE_START_TIME + '|' + DC_TABLE_VALUE_END_TIME + '|' + DC_TABLE_VALUE_F_20 + '|' + DC_TABLE_VALUE_F_33 + '|' + DC_TABLE_VALUE_F_50 + '|' + DC_TABLE_VALUE_F_100 + '|' + DC_TABLE_VALUE_F_LONG + '|' + DC_TABLE_VALUE_AVG_MEM + '|' + DC_TABLE_VALUE_MAX_MEM + '|' + DC_TABLE_VALUE_AVG_CPU + '|' + DC_TABLE_VALUE_MAX_CPU + '|' + DC_TABLE_VALUE_ATTACH_INFO + '|' + DC_TABLE_VALUE_F_MAX_TIME_MILLIS + '|' + DC_TABLE_VALUE_F_MAX + '|' + (int)paramFloat2 + '|' + (int)paramFloat1 + '|' + DC_TABLE_VALUE_TEXTURE_OFFLINE + '|' + MiniProgramReportHelper.getNetworkType() + '|' + DC_TABLE_VALUE_NETWORK_GATEWAY_IP + '|' + NetworkUtil.getCurrentWifiSSID(AppLoaderFactory.g().getContext()) + '|' + DC_TABLE_VALUE_PLATFORM + '|' + Build.MODEL + '|' + Build.VERSION.RELEASE + '|' + d1 + '|' + d2;
      if (QUAUtil.isQQApp()) {
        break label753;
      }
      str1 = QUAUtil.getQUA();
      localObject2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
      String str2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
      String str3 = QUAUtil.getLoginType();
      localObject1 = (String)localObject1 + '|' + str1 + '|' + (String)localObject2 + '|' + str2 + '|' + str3;
    }
    label721:
    label733:
    label753:
    for (;;)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putStringArray("data", new String[] { localObject1 });
      if (QUAUtil.isQQApp()) {}
      for (str1 = "dc04902";; str1 = "dc05389")
      {
        ((Bundle)localObject2).putString("log_key", str1);
        QMLog.d("MiniProgramLpReportDC04902", "reportGameEnd " + (String)localObject1);
        AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", (Bundle)localObject2, null);
        hasReportStart = false;
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("appId", DC_TABLE_VALUE_APPID);
        ((HashMap)localObject1).put("qua", DC_TABLE_VALUE_QUA);
        ((HashMap)localObject1).put("osVersion", Build.VERSION.RELEASE);
        ((HashMap)localObject1).put("baseLibVersion", paramString1);
        ((HashMap)localObject1).put("tritonVersion", paramString2);
        ((HashMap)localObject1).put("isSdk", String.valueOf(1));
        ((HashMap)localObject1).put("jank", String.valueOf(d1));
        ((HashMap)localObject1).put("bigJank", String.valueOf(d2));
        report("mini_game_jank", (Map)localObject1);
        return;
        i = 0;
        break;
        d1 = jankCount / d3;
        break label57;
        d2 = bigJankCount / d3;
        break label65;
      }
    }
  }
  
  public static void reportGameStart(String paramString)
  {
    if (!hasReportStart)
    {
      hasReportStart = true;
      DC_TABLE_VALUE_APPID = paramString;
      DC_TABLE_VALUE_START_TIME = currentTimeString();
      ThreadManager.getSubThreadHandler().postDelayed(PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE, 1000L);
    }
  }
  
  public static void reportToServer(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data"))) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).httpReport(paramBundle);
    }
  }
  
  public static void updateDisplayFrameTime(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      frameTimes = new long[3];
      totalFrameCount = 0;
      startFrameTime = paramLong;
      jankCount = 0;
      bigJankCount = 0;
      lastFrameUpdateTime = paramLong;
      return;
    }
    long l2 = paramLong - lastFrameUpdateTime;
    if ((totalFrameCount >= 3) && (l2 > 83333332L))
    {
      long l1 = 0L;
      while (i < 3)
      {
        l1 += frameTimes[i];
        i += 1;
      }
      if (l2 > l1 / 3L * 2L)
      {
        if (l2 <= 124999998L) {
          break label195;
        }
        bigJankCount += 1;
      }
    }
    for (;;)
    {
      QMLog.d("MiniProgramLpReportDC04902", "jankCount=" + jankCount + " bigJankCount=" + bigJankCount + " time=" + (paramLong - startFrameTime) / 1000000L);
      i = totalFrameCount;
      frameTimes[(i % 3)] = l2;
      totalFrameCount += 1;
      break;
      label195:
      jankCount += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902
 * JD-Core Version:    0.7.0.1
 */