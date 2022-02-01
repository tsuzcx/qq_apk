package cooperation.qqcircle.report;

import android.os.Handler;

public class QCircleLpReportDc05503
{
  public static final String KEY_EXT_1 = "ext1";
  public static final String KEY_EXT_2 = "ext2";
  public static final String KEY_EXT_3 = "ext3";
  public static final String KEY_EXT_4 = "ext4";
  public static final String KEY_EXT_5 = "ext5";
  public static final String KEY_EXT_6 = "ext6";
  public static final String KEY_LOGIN_TIME = "login_time";
  public static final String KEY_PAGE_ID = "page_id";
  public static final String KEY_STAY_TIME = "stay_time";
  
  private static int getDcId()
  {
    return 5503;
  }
  
  public static void report(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    report(paramLong1, paramLong2, paramLong3, "", "", "", "", "", "", paramInt);
  }
  
  public static void report(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05503.1(paramLong1, paramLong2, paramLong3, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05503
 * JD-Core Version:    0.7.0.1
 */