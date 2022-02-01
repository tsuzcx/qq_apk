package cooperation.qzone.report.retention;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReport_Retention_dc03208;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

public class RetentionReport
{
  public static final String CMD = "qzone_retention_";
  public static final String FUNCTIONID = "function_id";
  public static final int REPORT_LP = 1;
  public static final int REPORT_MTA = 2;
  public static final String TAG = "Retention.Report";
  public static final int WNS_DEFAULTVALUE = 0;
  public static final String WNS_MAINKEY = "ClientReport";
  public static final String WNS_SECONDARYKEY_BLACKLIST = "retention_report_blacklist";
  public static final String WNS_SECONDARYKEY_CHANNEL = "retention_report";
  public static final Set<String> blackCache = new HashSet();
  
  public static boolean meetConditon(String paramString)
  {
    if (blackCache.size() == 0)
    {
      Object localObject = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report_blacklist", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject[i];
          if (!TextUtils.isEmpty(localCharSequence)) {
            try
            {
              blackCache.add(localCharSequence);
            }
            catch (Exception localException)
            {
              QZLog.e("Retention.Report", "meetConditon error", localException);
            }
          }
          i += 1;
        }
      }
    }
    return (blackCache.size() <= 0) || (!blackCache.contains(paramString));
  }
  
  public static void mtaReport(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {}
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("function_id", paramString);
      paramHashMap = StatisticCollector.getInstance(MobileQQ.sMobileQQ);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qzone_retention_");
      localStringBuilder.append(paramString);
      paramHashMap.collectPerformance(null, localStringBuilder.toString(), true, 0L, 0L, (HashMap)localObject, null);
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("Retention.Report", "统计率上报失败", paramString);
    }
  }
  
  public static void report(int paramInt)
  {
    report(String.valueOf(paramInt), null);
  }
  
  public static void report(String paramString)
  {
    report(paramString, null);
  }
  
  public static void report(String paramString, HashMap<String, String> paramHashMap)
  {
    if (meetConditon(paramString))
    {
      int i = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report", 0);
      if ((i == 0) || (i == 2)) {
        mtaReport(paramString, paramHashMap);
      }
      if ((i == 0) || (i == 1)) {
        LpReport_Retention_dc03208.report(paramString, paramHashMap);
      }
      if (QZLog.isColorLevel()) {
        QZLog.i("Retention.Report", 2, new Object[] { "RetentionReport, functionid:", paramString });
      }
    }
    else if (QZLog.isColorLevel())
    {
      QZLog.i("Retention.Report", 2, new Object[] { "not meet condition, functionid:", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.retention.RetentionReport
 * JD-Core Version:    0.7.0.1
 */