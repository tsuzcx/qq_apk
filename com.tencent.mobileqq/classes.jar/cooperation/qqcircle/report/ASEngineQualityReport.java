package cooperation.qqcircle.report;

import android.os.Build;
import android.os.Handler;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ASEngineQualityReport
{
  public static final int DEFAULT_FAILED = -1;
  public static final String EVENT_ENTER_PLUGIN = "autoshadow_plugin_enter";
  public static final String EVENT_PLUGIN_CMD_REQ = "autoshadow_plugin_cmd_req";
  public static final String EVENT_PLUGIN_CMD_RSP = "autoshadow_plugin_cmd_rsp";
  public static final String EVENT_PLUGIN_DOWNLOAD = "autoshadow_plugin_download";
  public static final String EVENT_PLUGIN_GET = "autoshadow_plugin_get";
  public static final String EVENT_PLUGIN_LOAD = "autoshadow_plugin_load_result";
  public static final String EVENT_PLUGIN_LOAD_PLUGIN_LOADER = "autoshadow_load_plugin_loader";
  public static final String EVENT_PLUGIN_LOAD_RUNTIME = "autoshadow_load_runtime";
  public static final String EVENT_PLUGIN_ODEX_INSTALL = "autoshadow_odex_install";
  public static final String EVENT_PLUGIN_ON_CREATE = "autoshadow_on_create";
  public static final String EVENT_PLUGIN_SET_PLUGIN_INVALID = "autoshadow_plugin_set_plugin_invalid";
  public static final String EVENT_PLUGIN_WAIT_FOR_SERVICE = "autoshadow_wait_service_connect";
  private static final String KEY_DEVICE_INFO = "device_info";
  private static final String KEY_EVENT_ID = "event_id";
  private static final String KEY_EX1 = "ext1";
  private static final String KEY_EX2 = "ext2";
  private static final String KEY_NETWORK_TYPE = "network_type";
  private static final String KEY_PLUGIN_TYPE = "plugintype";
  private static final String KEY_PLUGIN_VERSION = "pluginVersion";
  private static final String KEY_QUA = "qua";
  private static final String KEY_RET_CODE = "retcode";
  private static final String KEY_UIN = "uin";
  public static final int LOAD_CRASH_INVALID = 6;
  public static final int LOAD_EXCEPTION_FAILED = 5;
  public static final int LOAD_FILE_DELETE = 2;
  public static final int LOAD_NOT_SUPPORT = 1;
  public static final int LOAD_NOT_SUPPORT_VERSION = 4;
  public static final int LOAD_PARAMS_ERROR = 3;
  public static final int LOAD_SUCCESS = 0;
  private static final String kEY_TIME_COST = "timecost";
  
  private static Collection<FeedCloudCommon.Entry> createEntries(ASEngineQualityReport.ReportData paramReportData)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("uin", QCircleHostStubUtil.getCurrentAccount()), QCircleReportHelper.newEntry("qua", paramReportData.getQua()), QCircleReportHelper.newEntry("network_type", paramReportData.getNetWorkTyp()), QCircleReportHelper.newEntry("event_id", paramReportData.getEventId()), QCircleReportHelper.newEntry("retcode", String.valueOf(paramReportData.getRetCode())), QCircleReportHelper.newEntry("pluginVersion", String.valueOf(paramReportData.getPluginVersion())), QCircleReportHelper.newEntry("plugintype", paramReportData.getPluginType()), QCircleReportHelper.newEntry("ext1", paramReportData.getExt1()), QCircleReportHelper.newEntry("ext2", paramReportData.getExt2()), QCircleReportHelper.newEntry("timecost", paramReportData.getTimeCost()), QCircleReportHelper.newEntry("device_info", Build.DEVICE) }));
  }
  
  public static void report(ASEngineQualityReport.ReportData paramReportData)
  {
    if (paramReportData != null) {
      QCircleReporter.getInstance().getReportHandler().post(new ASEngineQualityReport.1(paramReportData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.ASEngineQualityReport
 * JD-Core Version:    0.7.0.1
 */