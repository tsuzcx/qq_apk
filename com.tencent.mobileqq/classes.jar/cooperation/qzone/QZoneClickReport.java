package cooperation.qzone;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import org.json.JSONObject;

@Deprecated
public class QZoneClickReport
{
  public static final int ACTION_TYPE_LIVE_READ = 8;
  public static final int RESERVE_TYPE_LIVE_NOT_DOWNLOAD_PLUGIN = 3;
  public static final String RESERVE_TYPE_LIVE_NOT_DOWNLOAD_PTU_SO = "1";
  public static final String RESERVE_TYPE_LIVE_NOT_DOWNLOAD_STL_SO = "2";
  public static final int SUB_ACTION_TYPE_LIVE_NOT_DOWNLOAD = 128;
  public static final String SUB_ACTION_TYPE_LIVE_OS_NOT_SUPPORT = "125";
  public static final int SUB_ACTION_TYPE_LIVE_PLUGIN_MANUL_DOWNLOAD = 129;
  public static final String SUB_ACTION_TYPE_LIVE_PLUS_CLICK = "1";
  private static String TAG = "QZoneClickReport";
  public static boolean isShowToast = false;
  public static int reportAmount;
  public static int reportRate;
  
  private static long getLong(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      label7:
      String str;
      StringBuilder localStringBuilder;
      break label7;
    }
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("long string(");
    localStringBuilder.append(paramString);
    localStringBuilder.append(") is ill-format, return default value ");
    localStringBuilder.append(paramLong);
    QLog.e(str, 2, localStringBuilder.toString());
    return paramLong;
  }
  
  public static void report(String paramString, QZoneClickReport.ReportInfo paramReportInfo, boolean paramBoolean)
  {
    if (paramReportInfo == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new LpReportInfo_pf00064();
        paramString.extraInfo = paramReportInfo.toJSON().toString();
        paramReportInfo = LpReportManager.getInstance();
        if (!paramBoolean)
        {
          paramBoolean = true;
          paramReportInfo.reportToPF00064(paramString, paramBoolean, false);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZoneClickReport", 1, paramString, new Object[0]);
        return;
      }
      paramBoolean = false;
    }
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.toUin = getLong(paramString1, 0L);
    localReportInfo.actionType = paramString2;
    localReportInfo.subactionType = paramString3;
    localReportInfo.reserves = paramString4;
    localReportInfo.readSource = paramString5;
    report(paramString1, localReportInfo, paramBoolean);
  }
  
  public static void startReportImediately(String paramString, QZoneClickReport.ReportInfo paramReportInfo)
  {
    if (getLong(paramString, 0L) > 0L)
    {
      if (paramReportInfo == null) {
        return;
      }
      try
      {
        paramString = new LpReportInfo_pf00064();
        paramString.extraInfo = paramReportInfo.toJSON().toString();
        LpReportManager.getInstance().reportToPF00064(paramString, false, true);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QZoneClickReport", 1, paramString, new Object[0]);
      }
    }
  }
  
  public static void startReportImediately(String paramString1, String paramString2, String paramString3)
  {
    long l = getLong(paramString1, 0L);
    if (l > 0L)
    {
      QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
      localReportInfo.setActionType(paramString2);
      localReportInfo.setToUin(l);
      localReportInfo.setSubactionType(paramString3);
      startReportImediately(paramString1, localReportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneClickReport
 * JD-Core Version:    0.7.0.1
 */