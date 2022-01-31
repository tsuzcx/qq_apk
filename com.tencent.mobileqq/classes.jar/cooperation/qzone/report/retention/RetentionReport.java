package cooperation.qzone.report.retention;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.MTAReportController;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReport_Retention_dc03208;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class RetentionReport
{
  public static final Set a = new HashSet();
  
  public static void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public static void a(int paramInt, HashMap paramHashMap)
  {
    if (a(paramInt))
    {
      i = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report", 0);
      if ((i == 0) || (i == 2)) {
        b(paramInt, paramHashMap);
      }
      if ((i == 0) || (i == 1)) {
        LpReport_Retention_dc03208.report(paramInt, paramHashMap);
      }
      if (QZLog.isColorLevel()) {
        QZLog.i("Retention.Report", 2, new Object[] { "RetentionReport, functionid:", Integer.valueOf(paramInt) });
      }
    }
    while (!QZLog.isColorLevel())
    {
      int i;
      return;
    }
    QZLog.i("Retention.Report", 2, new Object[] { "not meet condition, functionid:", Integer.valueOf(paramInt) });
  }
  
  public static boolean a(int paramInt)
  {
    if (a.size() == 0)
    {
      Object localObject = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report_blacklist", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if (!TextUtils.isEmpty(localCharSequence)) {}
            try
            {
              int k = Integer.parseInt(localCharSequence);
              a.add(Integer.valueOf(k));
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QZLog.e("Retention.Report", "meetConditon error", localException);
              }
            }
          }
        }
      }
    }
    return (a.size() <= 0) || (!a.contains(new Integer(paramInt)));
  }
  
  public static void b(int paramInt, HashMap paramHashMap)
  {
    HashMap localHashMap = paramHashMap;
    if (paramHashMap == null) {}
    try
    {
      localHashMap = new HashMap();
      localHashMap.put("function_id", String.valueOf(paramInt));
      paramHashMap = new Properties();
      paramHashMap.putAll(localHashMap);
      MTAReportController.a(BaseApplicationImpl.getContext()).reportKVEvent("qzone_retention_" + paramInt, paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      QZLog.e("Retention.Report", "统计率上报失败", paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.retention.RetentionReport
 * JD-Core Version:    0.7.0.1
 */