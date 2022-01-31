package cooperation.qzone;

import bjdn;
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
  private static String TAG = QZoneClickReport.class.getSimpleName();
  public static boolean isShowToast;
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
      QLog.e(TAG, 2, "long string(" + paramString + ") is ill-format, return default value " + paramLong);
    }
    return paramLong;
  }
  
  public static void report(String paramString, bjdn parambjdn, boolean paramBoolean)
  {
    if (parambjdn == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new LpReportInfo_pf00064();
        paramString.extraInfo = parambjdn.a().toString();
        parambjdn = LpReportManager.getInstance();
        if (!paramBoolean)
        {
          paramBoolean = true;
          parambjdn.reportToPF00064(paramString, paramBoolean, false);
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
    bjdn localbjdn = new bjdn();
    localbjdn.a = getLong(paramString1, 0L);
    localbjdn.c = paramString2;
    localbjdn.d = paramString3;
    localbjdn.e = paramString4;
    localbjdn.f = paramString5;
    report(paramString1, localbjdn, paramBoolean);
  }
  
  public static void startReportImediately(String paramString, bjdn parambjdn)
  {
    if ((getLong(paramString, 0L) <= 0L) || (parambjdn == null)) {
      return;
    }
    try
    {
      paramString = new LpReportInfo_pf00064();
      paramString.extraInfo = parambjdn.a().toString();
      LpReportManager.getInstance().reportToPF00064(paramString, false, true);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneClickReport", 1, paramString, new Object[0]);
    }
  }
  
  public static void startReportImediately(String paramString1, String paramString2, String paramString3)
  {
    long l = getLong(paramString1, 0L);
    if (l > 0L)
    {
      bjdn localbjdn = new bjdn();
      localbjdn.a(paramString2);
      localbjdn.a(l);
      localbjdn.b(paramString3);
      startReportImediately(paramString1, localbjdn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QZoneClickReport
 * JD-Core Version:    0.7.0.1
 */