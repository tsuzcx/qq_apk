package com.tencent.mobileqq.mini.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import anue;
import bgnt;
import biip;
import blru;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniProgramLpReportDC04902
{
  private static final String BEACON_APP_KEY = "00000ARN3S3S9UE8";
  private static final String BEACON_EVENT_CODE = "mini_game_jank";
  private static final long BIG_JANK_TIME = 124999998L;
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
  private static String DC_TABLE_VALUE_PLATFORM = "android";
  private static String DC_TABLE_VALUE_QUA = blru.a();
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
  private static final Runnable PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE = new MiniProgramLpReportDC04902.1();
  private static final String TAG = "MiniProgramLpReportDC04902";
  private static int bigJankCount;
  private static long[] frameTimes;
  private static boolean hasReportStart;
  private static int jankCount;
  private static long lastFrameUpdateTime;
  private static long startFrameTime;
  private static int totalFrameCount;
  
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
  
  public static void reportGameEnd(float paramFloat1, float paramFloat2, float paramFloat3, String paramString1, String paramString2)
  {
    DC_TABLE_VALUE_END_TIME = currentTimeString();
    ThreadManager.getSubThreadHandler().removeCallbacks(PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE);
    try
    {
      DC_TABLE_VALUE_ATTACH_INFO = String.valueOf(paramFloat3);
      d3 = (lastFrameUpdateTime - startFrameTime) / 1000000.0D / 1000.0D / 60.0D;
      if (d3 < 0.01D)
      {
        i = 1;
        if (i == 0) {
          break label646;
        }
        d1 = 0.0D;
        if (i == 0) {
          break label658;
        }
        d2 = 0.0D;
        QLog.d("MiniProgramLpReportDC04902", 1, "reportGameEnd: minuteFromStart=" + d3 + " jankCount=" + jankCount + " bigJankCount=" + bigJankCount);
        Object localObject = DC_TABLE_VALUE_APPID + '|' + DC_TABLE_VALUE_QUA + '|' + DC_TABLE_VALUE_START_TIME + '|' + DC_TABLE_VALUE_END_TIME + '|' + DC_TABLE_VALUE_F_20 + '|' + DC_TABLE_VALUE_F_33 + '|' + DC_TABLE_VALUE_F_50 + '|' + DC_TABLE_VALUE_F_100 + '|' + DC_TABLE_VALUE_F_LONG + '|' + DC_TABLE_VALUE_AVG_MEM + '|' + DC_TABLE_VALUE_MAX_MEM + '|' + DC_TABLE_VALUE_AVG_CPU + '|' + DC_TABLE_VALUE_MAX_CPU + '|' + DC_TABLE_VALUE_ATTACH_INFO + '|' + DC_TABLE_VALUE_F_MAX_TIME_MILLIS + '|' + DC_TABLE_VALUE_F_MAX + '|' + (int)paramFloat2 + '|' + (int)paramFloat1 + '|' + DC_TABLE_VALUE_TEXTURE_OFFLINE + '|' + MiniProgramReportHelper.getNetworkType() + '|' + DC_TABLE_VALUE_NETWORK_GATEWAY_IP + '|' + bgnt.b(biip.a().a()) + '|' + DC_TABLE_VALUE_PLATFORM + '|' + Build.MODEL + '|' + Build.VERSION.RELEASE + '|' + d1 + '|' + d2;
        Bundle localBundle = new Bundle();
        localBundle.putStringArray("data", new String[] { localObject });
        localBundle.putString("log_key", "dc04902");
        QLog.d("MiniProgramLpReportDC04902", 1, new Object[] { "reportGameEnd ", localObject });
        AppBrandProxy.g().sendCmd("cmd_dc_report_log_key_data", localBundle, null);
        hasReportStart = false;
        UserAction.setLogAble(false, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("appId", DC_TABLE_VALUE_APPID);
        ((HashMap)localObject).put("qua", DC_TABLE_VALUE_QUA);
        ((HashMap)localObject).put("osVersion", Build.VERSION.RELEASE);
        ((HashMap)localObject).put("baseLibVersion", paramString1);
        ((HashMap)localObject).put("tritonVersion", paramString2);
        ((HashMap)localObject).put("isSdk", String.valueOf(0));
        ((HashMap)localObject).put("jank", String.valueOf(d1));
        ((HashMap)localObject).put("bigJank", String.valueOf(d2));
        UserAction.onUserActionToTunnel("00000ARN3S3S9UE8", "mini_game_jank", true, -1L, -1L, (Map)localObject, true, true);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        double d3;
        QLog.e("MiniProgramLpReportDC04902", 1, "reportGameEnd ", localThrowable);
        continue;
        int i = 0;
        continue;
        label646:
        double d1 = jankCount / d3;
        continue;
        label658:
        double d2 = bigJankCount / d3;
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
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (anue)((QQAppInterface)localObject).a(5);
        if (localObject != null) {
          ((anue)localObject).a(paramBundle);
        }
      }
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
      QLog.e("MiniProgramLpReportDC04902", 1, "jankCount=" + jankCount + " bigJankCount=" + bigJankCount + " time=" + (paramLong - startFrameTime) / 1000000L);
      i = totalFrameCount;
      frameTimes[(i % 3)] = l2;
      totalFrameCount += 1;
      break;
      label195:
      jankCount += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04902
 * JD-Core Version:    0.7.0.1
 */