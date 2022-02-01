package cooperation.qqcircle.report;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public class QCircleLpReportDc05504
{
  public static final String KEY_ACTIONTYPE = "actiontype";
  public static final String KEY_EXT_1 = "ext1";
  public static final String KEY_EXT_2 = "ext2";
  public static final String KEY_EXT_3 = "ext3";
  public static final String KEY_EXT_5 = "ext5";
  public static final String KEY_EXT_6 = "ext6";
  public static final String KEY_EXT_7 = "ext7";
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
  
  public static void report(String paramString, int paramInt1, int paramInt2)
  {
    report(paramString, paramInt1, paramInt2, 0, "", "", "", "", "");
  }
  
  public static void report(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    report(paramString, paramInt1, paramInt2, paramInt3, "", "", "", "", "", null, -1, -1);
  }
  
  public static void report(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    report(paramString, paramInt1, paramInt2, paramInt3, "", "", "", "", "", null, paramInt4, -1);
  }
  
  public static void report(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    report(paramString1, paramInt1, paramInt2, paramInt3, "", "", "", "", paramString2, null, -1, -1);
  }
  
  public static void report(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    report(paramString1, paramInt1, paramInt2, paramInt3, "", "", "", "", paramString2, null, paramInt4, -1);
  }
  
  public static void report(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    report(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramString5, paramString6, null, -1, -1);
  }
  
  public static void report(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4)
  {
    report(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramString5, paramString6, null, paramInt4, -1);
  }
  
  public static void report(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, byte[] paramArrayOfByte, int paramInt4, int paramInt5)
  {
    if (paramInt4 == 0)
    {
      QLog.e("QCircleReportBean_QCircleLpReportDc05504", 1, "report invalid pageId," + paramInt4 + ",actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      showErrorToast(paramInt1, paramInt2);
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05504.2(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt4, paramInt5, paramArrayOfByte));
  }
  
  public static void report(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5)
  {
    report(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, "", paramString4, paramString5, paramString6, paramArrayOfByte, paramInt4, paramInt5);
  }
  
  public static void report(String paramString, int paramInt1, int paramInt2, int paramInt3, List<FeedCloudCommon.Entry> paramList, byte[] paramArrayOfByte, int paramInt4)
  {
    if (paramInt4 == 0)
    {
      QLog.e("QCircleReportBean_QCircleLpReportDc05504", 1, "report invalid pageId," + paramInt4 + ",actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      showErrorToast(paramInt1, paramInt2);
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05504.1(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramList, paramArrayOfByte));
  }
  
  private static boolean reportWithoutSessionCheck(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
  
  private static void showErrorToast(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504
 * JD-Core Version:    0.7.0.1
 */