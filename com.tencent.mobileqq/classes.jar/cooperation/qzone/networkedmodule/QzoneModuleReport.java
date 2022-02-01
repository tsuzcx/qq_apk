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
  private static long sampleValidEndTime;
  private static long sampleValidStartTime;
  
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
    for (;;)
    {
      long l1;
      long l2;
      boolean bool;
      try
      {
        l1 = System.currentTimeMillis();
        if (!isTodayTime(l1))
        {
          i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneModuleReportSample", 100);
          l1 /= 86400000L;
          l2 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
          bool = false;
          if (l2 == 0L) {
            return false;
          }
          if (i == 0)
          {
            sNeedReport = false;
            continue;
            sNeedReport = bool;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("----QzoneModule-sample number： ");
              localStringBuilder.append(i);
              QLog.d("QzoneModuleReport", 4, localStringBuilder.toString());
            }
            sampleValidStartTime = getSpecifiedTimeInMillis(0, 0, 0, 0, 0, 0);
            sampleValidEndTime = getSpecifiedTimeInMillis(0, 0, 0, 24, 0, 0);
          }
        }
        else
        {
          bool = sNeedReport;
          return bool;
        }
      }
      finally {}
      long l3 = i;
      int i = (int)(l1 % l3);
      if (i == l2 % l3) {
        bool = true;
      }
    }
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
  
  public static void reportDownloadRes(QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("module_id", paramQzoneModuleRecord.mModuleId);
    localHashMap.put("module_url", paramQzoneModuleRecord.mUrl);
    localHashMap.put("module_version", String.valueOf(paramQzoneModuleRecord.mVersion));
    localHashMap.put("downloadState", str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(paramQzoneModuleRecord.mVersion);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localHashMap.put("param_FailCode", localStringBuilder.toString());
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQzoneModuleRecord.mModuleId);
    localStringBuilder.append("_downloadRes");
    report(str, localStringBuilder.toString(), paramBoolean, paramLong, 0L, localHashMap, "");
  }
  
  public static void reportLoadRes(QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("module_id", paramQzoneModuleRecord.mModuleId);
    localHashMap.put("module_url", paramQzoneModuleRecord.mUrl);
    localHashMap.put("module_version", String.valueOf(paramQzoneModuleRecord.mVersion));
    localHashMap.put("loadState", str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(paramQzoneModuleRecord.mVersion);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localHashMap.put("param_FailCode", localStringBuilder.toString());
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQzoneModuleRecord.mModuleId);
    localStringBuilder.append("_loadRes");
    report(str, localStringBuilder.toString(), paramBoolean, paramLong, 0L, localHashMap, "");
  }
  
  public static void reportResolveClassRes(QzoneModuleRecord paramQzoneModuleRecord, String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("module_id", paramQzoneModuleRecord.mModuleId);
    localHashMap.put("module_url", paramQzoneModuleRecord.mUrl);
    localHashMap.put("module_version", paramQzoneModuleRecord.mVersion);
    localHashMap.put("resolveClassState", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(paramQzoneModuleRecord.mVersion);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localHashMap.put("param_FailCode", localStringBuilder.toString());
    boolean bool = "1".equalsIgnoreCase(paramString);
    paramString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQzoneModuleRecord.mModuleId);
    localStringBuilder.append("_resolveClassRes");
    report(paramString, localStringBuilder.toString(), bool, paramLong, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleReport
 * JD-Core Version:    0.7.0.1
 */