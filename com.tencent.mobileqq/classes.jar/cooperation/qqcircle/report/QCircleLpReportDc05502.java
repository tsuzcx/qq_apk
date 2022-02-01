package cooperation.qqcircle.report;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;

public class QCircleLpReportDc05502
{
  public static final String KEY_AUTHOR_UIN = "author_uin";
  public static final String KEY_BEGIN_TIME = "begin_time";
  public static final String KEY_CONTAINERSEQ = "containerseq";
  public static final String KEY_END_TIME = "end_time";
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
  public static final String KEY_LUOMA_TRANSFER = "luoma_transfe";
  public static final String KEY_PAGE_ID = "page_id";
  public static final String KEY_REQUESTID = "requestid";
  public static final String KEY_RULE_ID = "rule_id";
  public static final String KEY_STAY_TIME = "stay_time";
  public static final String KEY_TIANJI_TRANSFER = "tianji_transfer";
  public static final String KEY_TOUIN = "touin";
  private static final String TAG = "QCircleLpReportDc05502";
  
  private static int getDcId()
  {
    return 5502;
  }
  
  public static void report(QCircleLpReportDc05502.DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null)
    {
      RFLog.e("QCircleReportBean_QCircleLpReportDc05502", RFLog.USR, "report invalid builder is null!");
      return;
    }
    if (QCircleLpReportDc05502.DataBuilder.access$000(paramDataBuilder) <= 0)
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report invalid pageId,");
      localStringBuilder.append(QCircleLpReportDc05502.DataBuilder.access$000(paramDataBuilder));
      localStringBuilder.append(",fpageId:");
      localStringBuilder.append(QCircleLpReportDc05502.DataBuilder.access$100(paramDataBuilder));
      RFLog.e("QCircleReportBean_QCircleLpReportDc05502", i, localStringBuilder.toString());
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleLpReportDc05502.1(paramDataBuilder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05502
 * JD-Core Version:    0.7.0.1
 */