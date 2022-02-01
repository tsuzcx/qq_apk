package cooperation.qzone.networkedmodule;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QzoneModuleReport
{
  private static final int DEFAULT_QZONE_MODULE_REPORT_SAMPLE = 100;
  private static final String FAILURE_CODE = "0";
  public static final String QZONE_MODULE_RESOVLE_CLASS_FAILED = "0";
  public static final String QZONE_MODULE_RESOVLE_CLASS_LOAD_SO_FAILED = "-1";
  public static final String QZONE_MODULE_RESOVLE_CLASS_SUCCESS = "1";
  private static final String SUCCESS_CODE = "1";
  private static final String TAG = "QzoneModuleReport";
  private static boolean sNeedReport = false;
  private static long sampleValidEndTime = 0L;
  private static long sampleValidStartTime = 0L;
  
  private static long getSpecifiedTimeInMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramInt1 > 0) {
      localCalendar.set(1, paramInt1);
    }
    if (paramInt2 > 0) {
      localCalendar.set(2, paramInt2);
    }
    if (paramInt3 > 0) {
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private static boolean isNeedReport()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      int i;
      long l2;
      int j;
      try
      {
        long l1 = System.currentTimeMillis();
        if (!isTodayTime(l1))
        {
          i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneModuleReportSample", 100);
          l1 /= 86400000L;
          l2 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
          if (l2 == 0L) {
            return bool1;
          }
          if (i == 0)
          {
            sNeedReport = false;
            sampleValidStartTime = getSpecifiedTimeInMillis(0, 0, 0, 0, 0, 0);
            sampleValidEndTime = getSpecifiedTimeInMillis(0, 0, 0, 24, 0, 0);
          }
        }
        else
        {
          bool1 = sNeedReport;
          continue;
          sNeedReport = bool1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QzoneModuleReport", 4, "----QzoneModule-sample number： " + j);
          continue;
        }
        j = (int)(l1 % i);
      }
      finally {}
      bool1 = bool2;
      if (j == l2 % i) {
        bool1 = true;
      }
    }
  }
  
  private static boolean isTodayTime(long paramLong)
  {
    return (sampleValidStartTime != 0L) && (sampleValidEndTime != 0L) && (paramLong >= sampleValidStartTime) && (paramLong < sampleValidEndTime);
  }
  
  private static void report(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    if (!isNeedReport())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneModuleReport", 1, "needn't report");
      }
      return;
    }
    ThreadManager.post(new QzoneModuleReport.1(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3), 5, null, false);
  }
  
  public static void reportDownloadRes(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("module_id", paramQzoneModuleRecord.mModuleId);
      localHashMap.put("module_url", paramQzoneModuleRecord.mUrl);
      localHashMap.put("module_version", String.valueOf(paramQzoneModuleRecord.mVersion));
      localHashMap.put("downloadState", str);
      localHashMap.put("param_FailCode", "v" + paramQzoneModuleRecord.mVersion + "_" + str);
      report(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQzoneModuleRecord.mModuleId + "_downloadRes", paramBoolean, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  public static void reportLoadRes(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("module_id", paramQzoneModuleRecord.mModuleId);
      localHashMap.put("module_url", paramQzoneModuleRecord.mUrl);
      localHashMap.put("module_version", String.valueOf(paramQzoneModuleRecord.mVersion));
      localHashMap.put("loadState", str);
      localHashMap.put("param_FailCode", "v" + paramQzoneModuleRecord.mVersion + "_" + str);
      report(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQzoneModuleRecord.mModuleId + "_loadRes", paramBoolean, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  public static void reportResolveClassRes(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord, String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("module_id", paramQzoneModuleRecord.mModuleId);
    localHashMap.put("module_url", paramQzoneModuleRecord.mUrl);
    localHashMap.put("module_version", paramQzoneModuleRecord.mVersion);
    localHashMap.put("resolveClassState", paramString);
    localHashMap.put("param_FailCode", "v" + paramQzoneModuleRecord.mVersion + "_" + paramString);
    boolean bool = "1".equalsIgnoreCase(paramString);
    report(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQzoneModuleRecord.mModuleId + "_resolveClassRes", bool, paramLong, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleReport
 * JD-Core Version:    0.7.0.1
 */