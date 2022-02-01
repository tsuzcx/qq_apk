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
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
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
  private static String DC_TABLE_VALUE_QUA = ;
  private static String DC_TABLE_VALUE_START_TIME = currentTimeString();
  private static String DC_TABLE_VALUE_TEXTURE_OFFLINE;
  private static final int FRAME_TIME_COUNT = 3;
  private static final long JANK_TIME = 83333332L;
  private static final String KEY_APP_ID = "appId";
  private static final String KEY_AVG_CPU = "avgCpu";
  private static final String KEY_AVG_FPS = "avgFps";
  private static final String KEY_AVG_MEM = "avgMem";
  private static final String KEY_BASE_LIB_VERSION = "baseLibVersion";
  private static final String KEY_BIG_JANK = "bigJank";
  private static final String KEY_IS_SDK = "isSdk";
  private static final String KEY_JANK = "jank";
  private static final String KEY_LEVEL = "level";
  private static final String KEY_OS_VERSION = "osVersion";
  private static final String KEY_PHONE_MODEL = "phoneModel";
  private static final String KEY_QUA = "qua";
  private static final String KEY_TRITON_VERSION = "tritonVersion";
  public static String PERF_LEVEL;
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
    } else if (paramLong <= 33L) {
      DC_TABLE_VALUE_F_33 += paramLong;
    } else if (paramLong <= 50L) {
      DC_TABLE_VALUE_F_50 += paramLong;
    } else if (paramLong <= 100L) {
      DC_TABLE_VALUE_F_100 += paramLong;
    } else {
      DC_TABLE_VALUE_F_LONG += paramLong;
    }
    if (paramLong > DC_TABLE_VALUE_F_MAX)
    {
      DC_TABLE_VALUE_F_MAX = paramLong;
      DC_TABLE_VALUE_F_MAX_TIME_MILLIS = System.currentTimeMillis();
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
    double d1 = lastFrameUpdateTime - startFrameTime;
    Double.isNaN(d1);
    double d3 = d1 / 1000000.0D / 1000.0D / 60.0D;
    int i;
    if (d3 < 0.01D) {
      i = 1;
    } else {
      i = 0;
    }
    double d2 = 0.0D;
    if (i != 0)
    {
      d1 = 0.0D;
    }
    else
    {
      d1 = jankCount;
      Double.isNaN(d1);
      d1 /= d3;
    }
    if (i == 0)
    {
      d2 = bigJankCount;
      Double.isNaN(d2);
      d2 /= d3;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reportGameEnd: minuteFromStart=");
    ((StringBuilder)localObject1).append(d3);
    ((StringBuilder)localObject1).append(" jankCount=");
    ((StringBuilder)localObject1).append(jankCount);
    ((StringBuilder)localObject1).append(" bigJankCount=");
    ((StringBuilder)localObject1).append(bigJankCount);
    QMLog.d("MiniProgramLpReportDC04902", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_APPID);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_QUA);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_START_TIME);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_END_TIME);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_F_20);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_F_33);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_F_50);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_F_100);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_F_LONG);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_AVG_MEM);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_MAX_MEM);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_AVG_CPU);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_MAX_CPU);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_ATTACH_INFO);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_F_MAX_TIME_MILLIS);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_F_MAX);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append((int)paramFloat2);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append((int)paramFloat1);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_TEXTURE_OFFLINE);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(MiniProgramReportHelper.getNetworkType());
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_NETWORK_GATEWAY_IP);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(NetworkUtil.getCurrentWifiSSID(AppLoaderFactory.g().getContext()));
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(DC_TABLE_VALUE_PLATFORM);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(d1);
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(d2);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (!QUAUtil.isQQApp())
    {
      localObject1 = QUAUtil.getQUA();
      localObject3 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
      String str1 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
      String str2 = QUAUtil.getLoginType();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append('|');
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append('|');
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append('|');
      localStringBuilder.append(str1);
      localStringBuilder.append('|');
      localStringBuilder.append(str2);
      localObject1 = localStringBuilder.toString();
    }
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putStringArray("data", new String[] { localObject1 });
    if (QUAUtil.isQQApp()) {
      localObject2 = "dc04902";
    } else {
      localObject2 = "dc05389";
    }
    ((Bundle)localObject3).putString("log_key", (String)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reportGameEnd ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QMLog.d("MiniProgramLpReportDC04902", ((StringBuilder)localObject2).toString());
    AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", (Bundle)localObject3, null);
    hasReportStart = false;
    if (PERF_LEVEL == null) {
      PERF_LEVEL = String.valueOf(DeviceInfoUtil.getPerfLevel());
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("appId", DC_TABLE_VALUE_APPID);
    ((HashMap)localObject1).put("qua", DC_TABLE_VALUE_QUA);
    ((HashMap)localObject1).put("osVersion", Build.VERSION.RELEASE);
    ((HashMap)localObject1).put("baseLibVersion", paramString1);
    ((HashMap)localObject1).put("tritonVersion", paramString2);
    ((HashMap)localObject1).put("isSdk", String.valueOf(1));
    ((HashMap)localObject1).put("jank", String.valueOf(d1));
    ((HashMap)localObject1).put("bigJank", String.valueOf(d2));
    ((HashMap)localObject1).put("level", PERF_LEVEL);
    ((HashMap)localObject1).put("avgFps", String.valueOf(paramFloat1));
    ((HashMap)localObject1).put("avgMem", String.valueOf(DC_TABLE_VALUE_AVG_MEM));
    ((HashMap)localObject1).put("avgCpu", String.valueOf(DC_TABLE_VALUE_AVG_CPU));
    report("mini_game_jank", (Map)localObject1);
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
    }
    else
    {
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
          if (l2 > 124999998L) {
            bigJankCount += 1;
          } else {
            jankCount += 1;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("jankCount=");
          localStringBuilder.append(jankCount);
          localStringBuilder.append(" bigJankCount=");
          localStringBuilder.append(bigJankCount);
          localStringBuilder.append(" time=");
          localStringBuilder.append((paramLong - startFrameTime) / 1000000L);
          QMLog.d("MiniProgramLpReportDC04902", localStringBuilder.toString());
        }
      }
      i = totalFrameCount;
      frameTimes[(i % 3)] = l2;
      totalFrameCount = i + 1;
    }
    lastFrameUpdateTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902
 * JD-Core Version:    0.7.0.1
 */