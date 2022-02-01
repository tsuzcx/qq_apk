package cooperation.qzone.report.lp;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.MobileQQ;

public class LpReportUtils
{
  public static final String ALL_REPORT = HardCodeUtil.a(2131904321);
  public static final String CLICK_MESSAGE = HardCodeUtil.a(2131904323);
  public static final String NOT_HIT = HardCodeUtil.a(2131904320);
  public static final String SAMPLE_REPORT = HardCodeUtil.a(2131904322);
  private static final String TAG = "LpReport.LpReportUtils";
  private static boolean isSampled = false;
  private static long sampleValidEndTime;
  private static long sampleValidStartTime;
  
  public static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3)
  {
    return getBeijingTimeInMillis(0, 0, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0))
    {
      localCalendar.set(1, paramInt1);
      localCalendar.set(2, paramInt2);
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static int getDaysSince1970()
  {
    return (int)((System.currentTimeMillis() - getBeijingTimeInMillis(1970, 0, 1, 0, 0, 0)) / 1000L / 60L / 60L / 24L);
  }
  
  public static String getMobileType()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.BRAND);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.DEVICE);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.DISPLAY);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.HARDWARE);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.PRODUCT);
    return localStringBuilder.toString();
  }
  
  public static boolean isNeedReport()
  {
    if (!isTodayTime(System.currentTimeMillis())) {
      userSample();
    }
    return isSampled;
  }
  
  private static boolean isTodayTime(long paramLong)
  {
    long l1 = sampleValidStartTime;
    if (l1 != 0L)
    {
      long l2 = sampleValidEndTime;
      if ((l2 != 0L) && (paramLong >= l1) && (paramLong < l2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean meetCondition(LpReportInfos paramLpReportInfos, long paramLong)
  {
    if ((MobileQQ.sProcessId == 1) && (((ILpReportUtils)QRoute.api(ILpReportUtils.class)).isBackgroundPause())) {
      return true;
    }
    long l = SystemClock.uptimeMillis();
    int i = QzoneConfig.getInstance().getConfig("ClientReport", "TraceReportInterval", 600);
    int j = QzoneConfig.getInstance().getConfig("ClientReport", "TraceReportCount", 50);
    if (paramLpReportInfos.size() < j) {
      return (l - paramLong >= i * 1000) && (paramLpReportInfos.size() > 0);
    }
    return true;
  }
  
  public static void safePut(Map<String, String> paramMap, String paramString, int paramInt)
  {
    if (paramMap == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      paramMap.put(paramString, String.valueOf(paramInt));
    }
  }
  
  public static void safePut(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static void showToast(LpReportInfo paramLpReportInfo, boolean paramBoolean) {}
  
  public static String transMapToString(Map paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      localStringBuffer.append(paramMap.getKey().toString());
      localStringBuffer.append(":");
      if (paramMap.getValue() == null) {
        paramMap = "";
      } else {
        paramMap = paramMap.getValue().toString();
      }
      localStringBuffer.append(paramMap);
      if (localIterator.hasNext()) {
        paramMap = ", ";
      } else {
        paramMap = "";
      }
      localStringBuffer.append(paramMap);
    }
    return localStringBuffer.toString();
  }
  
  private static void userSample()
  {
    int i = QzoneConfig.getInstance().getConfig("ClientReport", "TraceReportSamples", 100);
    long l2 = getDaysSince1970();
    boolean bool = true;
    long l1;
    try
    {
      l1 = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getLongAccountUin();
    }
    catch (Exception localException)
    {
      QLog.e("LpReport.LpReportUtils", 1, localException, new Object[0]);
      l1 = 0L;
    }
    if (l1 == 0L) {
      return;
    }
    if (i == 0)
    {
      isSampled = false;
    }
    else
    {
      long l3 = i;
      i = (int)(l2 % l3);
      if (i != l1 % l3) {
        bool = false;
      }
      isSampled = bool;
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("抽中的尾数： ");
        localStringBuilder.append(i);
        QLog.d("LpReport.LpReportUtils", 4, localStringBuilder.toString());
      }
    }
    sampleValidStartTime = getBeijingTimeInMillis(0, 0, 0);
    sampleValidEndTime = getBeijingTimeInMillis(24, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportUtils
 * JD-Core Version:    0.7.0.1
 */