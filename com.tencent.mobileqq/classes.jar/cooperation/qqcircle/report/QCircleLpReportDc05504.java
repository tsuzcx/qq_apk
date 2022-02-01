package cooperation.qqcircle.report;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import mqq.app.MobileQQ;

public class QCircleLpReportDc05504
{
  public static final String KEY_ACTIONTYPE = "actiontype";
  public static final String KEY_EXT_1 = "ext1";
  public static final String KEY_EXT_10 = "ext10";
  public static final String KEY_EXT_11 = "ext11";
  public static final String KEY_EXT_12 = "ext12";
  public static final String KEY_EXT_13 = "ext13";
  public static final String KEY_EXT_14 = "ext14";
  public static final String KEY_EXT_15 = "ext15";
  public static final String KEY_EXT_16 = "ext16";
  public static final String KEY_EXT_17 = "ext17";
  public static final String KEY_EXT_18 = "ext18";
  public static final String KEY_EXT_2 = "ext2";
  public static final String KEY_EXT_3 = "ext3";
  public static final String KEY_EXT_4 = "ext4";
  public static final String KEY_EXT_5 = "ext5";
  public static final String KEY_EXT_6 = "ext6";
  public static final String KEY_EXT_7 = "ext7";
  public static final String KEY_EXT_8 = "ext8";
  public static final String KEY_EXT_9 = "ext9";
  public static final String KEY_FFPAGE_ID = "ffpage_id";
  public static final String KEY_FPAGE_ID = "fpage_id";
  public static final String KEY_PAGE_ID = "page_id";
  public static final String KEY_SUBACTIONTYPE = "subactiontype";
  public static final String KEY_THR_ACTION = "thr_action";
  public static final String KEY_TOUIN = "touin";
  public static final String KEY_VID = "vid";
  private static final String TAG = "QCircleLpReportDc05504";
  
  private static int getDcId()
  {
    return 5504;
  }
  
  public static void report(QCircleLpReportDc05504.DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null)
    {
      RFLog.e("QCircleLpReportDc05504", RFLog.USR, "DataBuilder == null");
      return;
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05504.1(paramDataBuilder));
  }
  
  private static boolean reportWithoutSessionCheck(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt == 3) {
        return true;
      }
      return MobileQQ.sProcessId == 9;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504
 * JD-Core Version:    0.7.0.1
 */