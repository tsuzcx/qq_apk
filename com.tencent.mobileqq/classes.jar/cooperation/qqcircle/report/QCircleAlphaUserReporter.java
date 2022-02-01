package cooperation.qqcircle.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class QCircleAlphaUserReporter
{
  public static final String KEY_ATTACH_INFO = "attachInfo";
  public static final String KEY_CLIENT_REPORT_CMD_SUCCESS_RATE_EVENT = "client_report_cmd_success_rate_event";
  public static final String KEY_CLIENT_REPORT_LAUNCH_PERIOD_DURATION_EVENT = "client_launch_period_duration_event";
  public static final String KEY_CLIENT_REPORT_LOG_EVENT = "key_client_report_log_event";
  public static final String KEY_CLIENT_TIME = "client_time";
  public static final String KEY_CMD = "cmd";
  public static final String KEY_COUNT = "count";
  public static final String KEY_EVENT_ID = "event_id";
  public static final String KEY_EXTRA_INFO = "extraInfo";
  public static final String KEY_FEED_ID = "feed_id";
  public static final String KEY_GW_RP_TRANSFER = "gw_rp_transfer";
  public static final String KEY_HOST_UIN = "host_uin";
  public static final String KEY_INFO = "info";
  public static final String KEY_MOBILE_TYPE = "mobile_type";
  public static final String KEY_MSG = "msg";
  public static final String KEY_NETWORK_TYPE = "network_type";
  public static final String KEY_PLATFORM = "platfrom";
  public static final String KEY_QUA = "qua";
  public static final String KEY_RATE = "rate";
  public static final String KEY_REFER = "refer";
  public static final String KEY_RET_CODE = "ret_code";
  public static final String KEY_STATE = "state";
  public static final String KEY_SVR_RET_CODE = "svr_ret_code";
  public static final String KEY_TIME_COST = "time_cost";
  public static final String KEY_TRACE_ID = "trace_id";
  public static final String KEY_TYPE = "type";
  public static final String KEY_URL = "url";
  public static final String KEY_USER = "user";
  public static final String KEY_VERSION = "version";
  private static final String TAG = "QCircleAlphaUserReporter";
  private static List<String> sCmdLists = new ArrayList();
  
  static
  {
    initNeedClientReportSuccessRateCmdList();
  }
  
  public static String convertListToStr(List<String> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          localJSONArray.put(str);
        }
      }
    }
    return localJSONArray.toString();
  }
  
  public static List<String> convertStrToList(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(paramString.optString(i));
        i += 1;
      }
      StringBuilder localStringBuilder;
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      i = RFLog.USR;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertListFromStr exception:");
      localStringBuilder.append(paramString.toString());
      RFLog.e("QCircleReportHelper_QCircleAlphaUserReporter", i, localStringBuilder.toString());
    }
  }
  
  public static List<FeedCloudCommon.Entry> createBaseEntries(String paramString)
  {
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("host_uin", ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount());
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("platfrom", "AND");
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("version", ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName());
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("qua", QUA.getQUA3());
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.VERSION.RELEASE);
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, QCircleReportHelper.newEntry("mobile_type", localStringBuilder.toString()), QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("event_id", paramString) }));
  }
  
  private static void doClientLogReport(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder, String paramString)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCircleAlphaUserReporter.1(paramString, paramQCircleAlphaUserReportDataBuilder));
  }
  
  private static int getDcId()
  {
    return 10006;
  }
  
  private static void initNeedClientReportSuccessRateCmdList()
  {
    String str = QCircleConfigHelper.a();
    if (!TextUtils.isEmpty(str)) {
      updateCmdList(convertStrToList(str));
    }
  }
  
  public static void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    if ("FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.DataReport".equalsIgnoreCase(paramQCircleAlphaUserReportDataBuilder.cmd)) {
      return;
    }
    if (!QCircleConfigHelper.b()) {
      return;
    }
    if (!sCmdLists.contains(paramQCircleAlphaUserReportDataBuilder.cmd))
    {
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportCmdSuccessRateEvent cmd miss hit,input cmdName:");
      localStringBuilder.append(paramQCircleAlphaUserReportDataBuilder.cmd);
      RFLog.e("QCircleAlphaUserReporter", i, localStringBuilder.toString());
      return;
    }
    doClientLogReport(paramQCircleAlphaUserReportDataBuilder, "client_report_cmd_success_rate_event");
  }
  
  public static void reportLaunchPeriodEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    doClientLogReport(paramQCircleAlphaUserReportDataBuilder, "client_launch_period_duration_event");
  }
  
  public static void reportLog(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    doClientLogReport(paramQCircleAlphaUserReportDataBuilder, "key_client_report_log_event");
  }
  
  public static void reportLog(String paramString, QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    doClientLogReport(paramQCircleAlphaUserReportDataBuilder, paramString);
  }
  
  public static void updateCmdList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      sCmdLists.clear();
      sCmdLists.addAll(paramList);
      int i = RFLog.CLR;
      paramList = new StringBuilder();
      paramList.append("updateCmdList->");
      paramList.append(sCmdLists.toString());
      RFLog.d("QCircleAlphaUserReporter", i, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleAlphaUserReporter
 * JD-Core Version:    0.7.0.1
 */