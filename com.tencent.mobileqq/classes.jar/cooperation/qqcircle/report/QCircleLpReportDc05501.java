package cooperation.qqcircle.report;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleLpReportDc05501
{
  public static final String KEY_ACTIONTYPE = "actiontype";
  public static final String KEY_ACTTIME = "acttime";
  public static final String KEY_AUTHOR_UIN = "author_uin";
  public static final String KEY_CONTAINERSEQ = "containerseq";
  public static final String KEY_EXT_1 = "ext1";
  public static final String KEY_EXT_2 = "ext2";
  public static final String KEY_EXT_3 = "ext3";
  public static final String KEY_EXT_4 = "ext4";
  public static final String KEY_EXT_5 = "ext5";
  public static final String KEY_EXT_6 = "ext6";
  public static final String KEY_EXT_7 = "ext7";
  public static final String KEY_EXT_8 = "ext8";
  public static final String KEY_FEEDID = "feedid";
  public static final String KEY_FEEDTYPE1 = "feedtype1";
  public static final String KEY_FEEDTYPE2 = "feedtype2";
  public static final String KEY_FEEDTYPE3 = "feedtype3";
  public static final String KEY_FEED_TAG = "feed_tag";
  public static final String KEY_FFPAGE_ID = "ffpage_id";
  public static final String KEY_FPAGE_ID = "fpage_id";
  public static final String KEY_INDEX = "index";
  public static final String KEY_ISREADED = "isreaded";
  public static final String KEY_PAGE_ID = "page_id";
  public static final String KEY_REQUESTID = "requestid";
  public static final String KEY_RULE_ID = "rule_id";
  public static final String KEY_SUBACTIONTYPE = "subactiontype";
  public static final String KEY_TOUIN = "touin";
  private static final String TAG = "QCircleLpReportDc05501";
  
  private static int getDcId()
  {
    return 5501;
  }
  
  private static boolean needReportNow(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2) {
        return true;
      }
      if ((paramInt1 == 3) && (paramInt2 == 1)) {
        return true;
      }
      return (paramInt1 == 65) && (paramInt2 < 6);
    }
    return true;
  }
  
  public static void report(QCircleLpReportDc05501.DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null)
    {
      RFLog.e("QCircleLpReportDc05501", RFLog.USR, "DataBuilder == null");
      return;
    }
    if (QCircleLpReportDc05501.DataBuilder.access$000(paramDataBuilder) <= 0)
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report invalid pageId,");
      localStringBuilder.append(QCircleLpReportDc05501.DataBuilder.access$000(paramDataBuilder));
      localStringBuilder.append(",actionType:");
      localStringBuilder.append(QCircleLpReportDc05501.DataBuilder.access$100(paramDataBuilder));
      localStringBuilder.append(",subActionType:");
      localStringBuilder.append(QCircleLpReportDc05501.DataBuilder.access$200(paramDataBuilder));
      RFLog.e("QCircleReportBean_QCircleLpReportDc05501", i, localStringBuilder.toString());
      showErrorToast(QCircleLpReportDc05501.DataBuilder.access$100(paramDataBuilder), QCircleLpReportDc05501.DataBuilder.access$200(paramDataBuilder));
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05501.1(paramDataBuilder));
  }
  
  private static void showErrorToast(int paramInt1, int paramInt2)
  {
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      RFThreadManager.getUIHandler().post(new QCircleLpReportDc05501.2(paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05501
 * JD-Core Version:    0.7.0.1
 */