package cooperation.qqcircle.report;

import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.open.adapter.CommonDataAdapter;
import feedcloud.FeedCloudCommon.Entry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class QCirclePublishQualityReporter
{
  public static final String APPID = "appid";
  public static final String ATTACH_INFO = "attach_info";
  public static final String CLIENT_TIME = "client_time";
  public static final String DESC = "desc";
  public static final String DEVICE_MODEL = "device_model";
  public static final String DEVICE_OS_VER = "device_os_ver";
  public static final String EXT1 = "ext1";
  public static final String EXT2 = "ext2";
  public static final String EXT3 = "ext3";
  public static final String EXT4 = "ext4";
  public static final String EXT5 = "ext5";
  public static final String EXT6 = "ext6";
  public static String E_PICKER_ENTER;
  public static String E_PICKER_EXIT_CANCEL;
  public static String E_PICKER_EXIT_NORMAL;
  public static String E_PUBLIC_ENTER;
  public static String E_PUBLIC_EXIT_CANCEL;
  public static String E_PUBLIC_EXIT_NORMAL;
  public static String E_PUBLIC_START = "E_PUBLIC_START";
  public static String E_PUBLISH_FEEDS_RESULT = "E_PUBLISH_FEEDS_RESULT";
  public static String E_PUBLISH_FEEDS_START;
  public static String E_UPLOAD_RESULT;
  public static String E_UPLOAD_START;
  public static String E_VIDEO_EXPORT_RESULT;
  public static String E_VIDEO_EXPORT_START;
  public static final String INDEX = "index";
  public static final String KEY_EVENT_ID = "event_id";
  public static final String KEY_HOST_UIN = "host_uin";
  public static final String KEY_PEAK = "Peak";
  public static final String KEY_QQ = "QQ";
  public static final String KEY_QUA = "qua";
  public static final String KEY_RET_CODE = "ret_code";
  public static final String NETWORK_TYPE = "network_type";
  private static final String TAG = "[QcirclePublish]QCirclePublishQualityReporter";
  public static final String TRACEID = "traceid";
  private static final String VALUE_APPID = "100036";
  
  static
  {
    E_PUBLIC_ENTER = "E_PUBLIC_ENTER";
    E_PUBLIC_EXIT_CANCEL = "E_PUBLIC_EXIT_CANCEL";
    E_PUBLIC_EXIT_NORMAL = "E_PUBLIC_EXIT_NORMAL";
    E_PICKER_ENTER = "E_PICKER_ENTER";
    E_PICKER_EXIT_CANCEL = "E_PICKER_EXIT_CANCEL";
    E_PICKER_EXIT_NORMAL = "E_PICKER_EXIT_NORMAL";
    E_VIDEO_EXPORT_START = "E_VIDEO_EXPORT_START";
    E_VIDEO_EXPORT_RESULT = "E_VIDEO_EXPORT_RESULT";
    E_UPLOAD_START = "E_UPLOAD_START";
    E_UPLOAD_RESULT = "E_UPLOAD_RESULT";
    E_PUBLISH_FEEDS_START = "E_PUBLISH_FEEDS_START";
  }
  
  public static String getTraceId()
  {
    String str = new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    str = CommonDataAdapter.a().a() + "_" + str + "_" + UUID.randomUUID();
    RFLog.d("[QcirclePublish]QCirclePublishQualityReporter", RFLog.USR, "traceId:" + str);
    return str;
  }
  
  public static void report(String paramString, List<FeedCloudCommon.Entry> paramList)
  {
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
    paramList = new ArrayList(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramList.get(i);
      RFLog.d("[QcirclePublish]QCirclePublishQualityReporter", RFLog.USR, new Object[] { paramString + " key:", localEntry.key.get(), " value:", localEntry.value.get() });
      i += 1;
    }
    paramList.add(QCircleReportHelper.newEntry("host_uin", String.valueOf(CommonDataAdapter.a().a())));
    paramList.add(QCircleReportHelper.newEntry("qua", QCircleServiceImpl.getQZoneService().getQUA3()));
    paramList.add(QCircleReportHelper.newEntry("client_time", str));
    paramList.add(QCircleReportHelper.newEntry("device_model", QCircleServiceImpl.getQZoneService().getDeviceName()));
    paramList.add(QCircleReportHelper.newEntry("device_os_ver", String.valueOf(Build.VERSION.SDK_INT)));
    paramList.add(QCircleReportHelper.newEntry("event_id", paramString));
    paramList.add(QCircleReportHelper.newEntry("network_type", QCircleServiceImpl.getQZoneService().getNetworkTypeString()));
    paramList.add(QCircleReportHelper.newEntry("appid", "100036"));
    reportQualityEvent(10008, paramList);
  }
  
  public static void report(String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    QCircleQualityReporter.reportQualityEvent(10008, paramString, paramList, paramBoolean);
  }
  
  public static void reportQualityEvent(int paramInt, List<FeedCloudCommon.Entry> paramList)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCirclePublishQualityReporter.1(paramInt, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCirclePublishQualityReporter
 * JD-Core Version:    0.7.0.1
 */