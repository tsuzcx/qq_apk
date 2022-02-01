package cooperation.qqcircle.report;

import android.os.Build;
import android.os.Handler;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class QCircleFlutterPluginQualityReporter
{
  public static final String EVENT_PLUGIN_FLUTTER_OPEN = "flutter_open";
  public static final String EVENT_PLUGIN_FLUTTER_PRELOAD = "flutter_preload";
  private static final String KEY_ATTACH_INFO = "attach_info";
  private static final String KEY_CHECK_CODE = "check_code";
  private static final String KEY_CLIENT_TIME = "client_time";
  private static final String KEY_COUNT = "count";
  private static final String KEY_DN_VERSION = "dn_version";
  private static final String KEY_ERROR_MSG = "error_msg";
  private static final String KEY_EVENT_ID = "event_id";
  private static final String KEY_EXTINFO = "extinfo";
  private static final String KEY_FPS = "fps";
  private static final String KEY_FTIME = "ftime";
  private static final String KEY_KEY_OS = "key_os";
  private static final String KEY_MD5 = "md5";
  private static final String KEY_MOBILE_TYPE = "mobile_type";
  private static final String KEY_NETWORK_TYPE = "network_type";
  private static final String KEY_PLATFORM = "platform";
  private static final String KEY_QUA = "qua";
  private static final String KEY_RATE = "rate";
  private static final String KEY_REFER = "refer";
  private static final String KEY_RET_CODE = "ret_code";
  private static final String KEY_TYPE = "type";
  private static final String KEY_UIN = "host_uin";
  private static final String KEY_UNIQUE_ID = "unique_id";
  private static final String KEY_URL = "url";
  private static final String KEY_USER_IP = "user_ip";
  private static final String KEY_VERSION = "version";
  private static final String KEY_WIDGET = "widget";
  private static final String kEY_TIME_COST = "time_cost";
  
  private static Collection<FeedCloudCommon.Entry> createEntries(QCircleFlutterPluginQualityReporter.ReportData paramReportData)
  {
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("host_uin", QCircleHostStubUtil.getCurrentAccount());
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("qua", paramReportData.getQua());
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("network_type", paramReportData.getNetWorkTyp());
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("event_id", paramReportData.getEvent_id());
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("ret_code", String.valueOf(paramReportData.getRetCode()));
    FeedCloudCommon.Entry localEntry6 = QCircleReportHelper.newEntry("md5", String.valueOf(paramReportData.getMd5()));
    FeedCloudCommon.Entry localEntry7 = QCircleReportHelper.newEntry("url", paramReportData.getUrl());
    FeedCloudCommon.Entry localEntry8 = QCircleReportHelper.newEntry("check_code", paramReportData.getCheckCode());
    FeedCloudCommon.Entry localEntry9 = QCircleReportHelper.newEntry("version", paramReportData.getQua());
    FeedCloudCommon.Entry localEntry10 = QCircleReportHelper.newEntry("time_cost", paramReportData.getTimeCost());
    paramReportData = QCircleReportHelper.newEntry("dn_version", paramReportData.getFlutterVersion());
    FeedCloudCommon.Entry localEntry11 = QCircleReportHelper.newEntry("mobile_type", Build.DEVICE);
    FeedCloudCommon.Entry localEntry12 = QCircleReportHelper.newEntry("platform", "AND");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, localEntry9, localEntry10, paramReportData, localEntry11, localEntry12, QCircleReportHelper.newEntry("ftime", localStringBuilder.toString()), QCircleReportHelper.newEntry("refer", "1") }));
  }
  
  public static void report(QCircleFlutterPluginQualityReporter.ReportData paramReportData)
  {
    if (paramReportData != null) {
      QCircleReporter.getInstance().getReportHandler().post(new QCircleFlutterPluginQualityReporter.1(paramReportData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter
 * JD-Core Version:    0.7.0.1
 */