package cooperation.qqcircle.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.open.adapter.CommonDataAdapter;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.QCircleConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class QCircleAlphaUserReporter
{
  public static final String KEY_ATTACH_INFO = "attach_info";
  public static final String KEY_CLIENT_REPORT_CMD_SUCCESS_RATE_EVENT = "client_report_cmd_success_rate_event";
  public static final String KEY_CLIENT_TIME = "client_time";
  public static final String KEY_CMD = "cmd";
  public static final String KEY_COUNT = "count";
  public static final String KEY_EVENT_ID = "event_id";
  public static final String KEY_EXTRA_INFO = "extra_info";
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
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      RFLog.e("QCircleReportHelper_QCircleAlphaUserReporter", RFLog.USR, "convertListFromStr exception:" + paramString.toString());
    }
  }
  
  public static List<FeedCloudCommon.Entry> createBaseEntries(String paramString)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("host_uin", String.valueOf(CommonDataAdapter.a().a())), QCircleReportHelper.newEntry("platfrom", "AND"), QCircleReportHelper.newEntry("version", QCircleHostConstants._AppSetting.reportVersionName()), QCircleReportHelper.newEntry("qua", HostDataTransUtils.getQUA3()), QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType()), QCircleReportHelper.newEntry("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("event_id", paramString) }));
  }
  
  private static int getDcId()
  {
    return 10006;
  }
  
  private static void initNeedClientReportSuccessRateCmdList()
  {
    String str = QCircleConfig.getInstance().getNeedClientReportSuccessRateCmd();
    if (str != null) {
      updateCmdList(convertStrToList(str));
    }
  }
  
  public static void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    if ("FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.DataReport".equalsIgnoreCase(paramQCircleAlphaUserReportDataBuilder.cmd)) {}
    while (!QzoneConfig.getQQCircleIsAlphaUser()) {
      return;
    }
    if (!sCmdLists.contains(paramQCircleAlphaUserReportDataBuilder.cmd))
    {
      RFLog.e("QCircleAlphaUserReporter", RFLog.CLR, "reportCmdSuccessRateEvent cmd miss hit,input cmdName:" + paramQCircleAlphaUserReportDataBuilder.cmd);
      return;
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleAlphaUserReporter.1(paramQCircleAlphaUserReportDataBuilder));
  }
  
  public static void updateCmdList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      sCmdLists.clear();
      sCmdLists.addAll(paramList);
      RFLog.d("QCircleAlphaUserReporter", RFLog.CLR, "updateCmdList->" + sCmdLists.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleAlphaUserReporter
 * JD-Core Version:    0.7.0.1
 */