package cooperation.qqcircle.report;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;

public class QCircleLpReportDc05493
{
  public static final int ENTRANCE_FROM_INVITE = 10;
  public static final int ENTRANCE_FROM_QQ_AIO = 6;
  public static final int ENTRANCE_FROM_QQ_DYNAMIC_PAGE = 3;
  public static final int ENTRANCE_FROM_QQ_MAIN_TAB = 11;
  public static final int ENTRANCE_FROM_QQ_MESSAGE_PAGE = 4;
  public static final int ENTRANCE_FROM_QQ_PROFILE_CARD = 5;
  public static final int ENTRANCE_FROM_QQ_PUSH = 7;
  public static final int ENTRANCE_FROM_QQ_SETTING = 9;
  public static final int ENTRANCE_FROM_SCHEMA = 8;
  public static final int ENTRANCE_FROM_WX_AIO = 1;
  public static final int ENTRANCE_FROM_WX_CIRCLE = 2;
  public static final String KEY_EXT_1 = "ext1";
  public static final String KEY_EXT_2 = "ext2";
  public static final String KEY_EXT_3 = "ext3";
  public static final String KEY_EXT_4 = "ext4";
  public static final String KEY_EXT_5 = "ext5";
  public static final String KEY_EXT_6 = "ext6";
  public static final String KEY_LOGIN_ENTRANCE = "login_entrance";
  public static final String KEY_LOGIN_SUB_ENTRANCE = "sub_entrance";
  public static final String KEY_LOGIN_THIRD_ENTRANCE = "thr_entrance";
  public static final String KEY_LOGIN_TIME = "login_time";
  public static final String KEY_REPORT_FROM = "report_from";
  public static final String KEY_TOUIN = "touin";
  private static final String TAG = "QCircleLpReportDc05493";
  
  private static int getDcId()
  {
    return 5493;
  }
  
  private static void report(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05493.1(paramString1, paramLong4, paramLong1, paramLong2, paramLong3, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt));
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    report(paramString1, paramString2, paramString3, paramLong, paramInt, "", "");
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5)
  {
    i = 0;
    j = 0;
    l2 = 0L;
    try
    {
      k = Integer.parseInt(paramString2);
      j = k;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        int k;
        l1 = Long.parseLong(paramString3);
        switch (j)
        {
        default: 
          RFLog.e("QCircleReportHelper_QCircleLpReportDc05493", RFLog.USR, "QCircle launch report invalid input fromStr:!" + paramString2);
          k = i;
          if (j != 6) {
            break label190;
          }
          if ((l1 == 1L) || (l1 == 2L)) {
            break label187;
          }
          k = i;
          if (l1 != 3L) {
            break label190;
          }
          k = 3;
          report(paramString1, k, j, l1, paramLong, "", "", paramString4, paramString5, "", "", paramInt);
          return;
          localNumberFormatException = localNumberFormatException;
          RFLog.e("QCircleReportHelper_QCircleLpReportDc05493", RFLog.USR, "QCircle launch report invalid input fromStr:" + paramString2);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          RFLog.e("QCircleReportHelper_QCircleLpReportDc05493", RFLog.USR, "QCircle launch report invalid input pushId:" + paramString3);
          long l1 = l2;
          continue;
          i = 1;
          continue;
          i = 2;
          continue;
          i = 3;
        }
      }
    }
    l1 = l2;
    if (!TextUtils.isEmpty(paramString3))
    {
      l1 = l2;
      if (!TextUtils.isDigitsOnly(paramString3)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05493
 * JD-Core Version:    0.7.0.1
 */