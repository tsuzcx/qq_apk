package cooperation.qqcircle.report;

import android.os.Handler;
import bhpc;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class QCirclePluginQualityReporter
{
  public static final String EVENT_PLUGIN_CMD_REQ = "qcircle_plugin_cmd_req";
  public static final String EVENT_PLUGIN_CMD_RSP = "qcircle_plugin_cmd_rsp";
  public static final String EVENT_PLUGIN_DOWNLOAD = "qcircle_plugin_download";
  public static final String EVENT_PLUGIN_GET = "qcircle_plugin_get";
  public static final String EVENT_PLUGIN_LOAD = "qcircle_plugin_load_result";
  public static final String EVENT_PLUGIN_LOAD_START = "qcircle_plugin_load_start";
  public static final String EVENT_PLUGIN_NET_COMPARE_ASSET = "qcircle_net_compare_asset";
  public static final String EVENT_PLUGIN_NET_COMPARE_MINVERSION = "qcircle_net_compare_minversion";
  public static final String EVENT_PLUGIN_NET_CRASH_MAX = "qcircle_net_crash_max";
  public static final String EVENT_PLUGIN_SET_PLUGIN_INVALID = "qcircle_plugin_set_plugin_invalid";
  public static final String EVENT_PLUGIN_SYS_NOT_SUPPORT = "qcircle_plugin_system_unsupport";
  public static final String EVENT_PLUGIN_WNS_LOAD_ASSET = "qcircle_plugin_wns_load_asset";
  private static final String KEY_EVENT_ID = "event_id";
  private static final String KEY_EX1 = "ext1";
  private static final String KEY_EX2 = "ext2";
  private static final String KEY_NETWORK_TYPE = "network_type";
  private static final String KEY_PLUGIN_TYPE = "plugintype";
  private static final String KEY_PLUGIN_VERSION = "pluginVersion";
  private static final String KEY_QUA = "qua";
  private static final String KEY_RET_CODE = "retcode";
  private static final String KEY_UIN = "uin";
  private static final String kEY_TIME_COST = "timecost";
  
  private static Collection<FeedCloudCommon.Entry> createEntries(QCirclePluginQualityReporter.ReportData paramReportData)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("uin", String.valueOf(bhpc.a().a())), QCircleReportHelper.newEntry("qua", paramReportData.getQua()), QCircleReportHelper.newEntry("network_type", paramReportData.getNetWorkTyp()), QCircleReportHelper.newEntry("event_id", paramReportData.getEvent_id()), QCircleReportHelper.newEntry("retcode", String.valueOf(paramReportData.getRetCode())), QCircleReportHelper.newEntry("pluginVersion", String.valueOf(paramReportData.getPluginVersion())), QCircleReportHelper.newEntry("plugintype", paramReportData.getPluginType()), QCircleReportHelper.newEntry("ext1", paramReportData.getExt1()), QCircleReportHelper.newEntry("ext2", paramReportData.getExt2()), QCircleReportHelper.newEntry("timecost", paramReportData.getTimeCost()) }));
  }
  
  public static void report(QCirclePluginQualityReporter.ReportData paramReportData)
  {
    if (paramReportData != null) {
      QCircleReporter.getInstance().getReportHandler().post(new QCirclePluginQualityReporter.1(paramReportData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCirclePluginQualityReporter
 * JD-Core Version:    0.7.0.1
 */