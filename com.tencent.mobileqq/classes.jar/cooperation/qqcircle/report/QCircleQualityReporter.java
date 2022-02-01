package cooperation.qqcircle.report;

import NS_COMM.COMM.Entry;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import bhpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import mqq.app.AppRuntime;

public class QCircleQualityReporter
{
  public static final String KEY_ATTACH_INFO = "attach_info";
  public static final String KEY_CLIENT_TIME = "client_time";
  public static final String KEY_COUNT = "count";
  public static final String KEY_EVENT_ID = "event_id";
  public static final String KEY_EVENT_ID_IMAGE_DECODE = "image_decode_ret";
  public static final String KEY_EVENT_ID_IMAGE_DOWNLOAD = "image_download_ret";
  public static final String KEY_EVENT_ID_IMAGE_LOAD = "image_load_ret";
  public static final String KEY_EVENT_ID_OPEN_HIPPY_PAGE = "key_open_hippy_page";
  public static final String KEY_HOST_UIN = "host_uin";
  public static final String KEY_ID = "identify";
  public static final String KEY_IMAGE_PUBLISH_FULL_LINK = "image_publish_full_link";
  public static final String KEY_MOBILE_TYPE = "mobile_type";
  public static final String KEY_NETWORK_TYPE = "network_type";
  public static final String KEY_OBJ_ID = "obj_id";
  public static final String KEY_PLATFORM = "platform";
  public static final String KEY_QUA = "qua";
  public static final String KEY_REFER = "refer";
  public static final String KEY_RET_CODE = "ret_code";
  public static final String KEY_TIME_COST = "time_cost";
  public static final String KEY_TRACE_ID = "trace_id";
  public static final String KEY_TYPE = "type";
  public static final String KEY_UNIQUE_ID = "unique_id";
  public static final String KEY_URL = "url";
  public static final String KEY_VERSION = "version";
  public static final String KEY_VIDEO_PUBLISH_FULL_LINK = "video_publish_full_link";
  private static String PERF_LEVEL;
  private static final String TAG = "QCircleQualityReporter";
  private static long sFinalUniqueId;
  private static boolean sIsSampled = true;
  
  private static void checkIsSampled()
  {
    long l1 = getDaysSince1970();
    long l2 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (l2 == 0L) {
      return;
    }
    int i = (int)(l1 % 100);
    if (i == l2 % 100) {}
    for (boolean bool = true;; bool = false)
    {
      sIsSampled = bool;
      if (QLog.isDevelopLevel()) {
        QLog.d("QCircleQualityReporter", 4, "抽中的尾数： " + i);
      }
      QLog.d("QCircleQualityReporter", 1, "checkIsSampled:" + sIsSampled);
      return;
    }
  }
  
  public static List<FeedCloudCommon.Entry> createBaseEntries(String paramString)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("host_uin", String.valueOf(bhpc.a().a())), QCircleReportHelper.newEntry("qua", QUA.getQUA3()), QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType()), QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("event_id", paramString), QCircleReportHelper.newEntry("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), QCircleReportHelper.newEntry("version", "8.4.8.4810"), QCircleReportHelper.newEntry("platform", "AND"), QCircleReportHelper.newEntry("unique_id", String.valueOf(obtainUniqueId())) }));
  }
  
  private static void generateUniqueId()
  {
    sFinalUniqueId = System.currentTimeMillis() / 1000L << 32 | BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0))
    {
      localCalendar.set(1, paramInt1);
      localCalendar.set(2, paramInt2);
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private static int getDaysSince1970()
  {
    return (int)((System.currentTimeMillis() - getBeijingTimeInMillis(1970, 0, 1, 0, 0, 0)) / 1000L / 60L / 60L / 24L);
  }
  
  private static long obtainUniqueId()
  {
    if (sFinalUniqueId == 0L)
    {
      generateUniqueId();
      checkIsSampled();
    }
    return sFinalUniqueId;
  }
  
  public static void reportCommandQuality(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    if ("MobileQQReport.mini_app_report_transfer.DataReport".equalsIgnoreCase(paramString1)) {}
    while ((!QLog.isColorLevel()) && (!sIsSampled)) {
      return;
    }
    if (PERF_LEVEL == null) {
      PERF_LEVEL = String.valueOf(DeviceInfoUtil.getPerfLevel());
    }
    paramString1 = MiniProgramReportHelper.newSingleReportData(16, new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("uid", String.valueOf(bhpc.a().a())), MiniProgramReportHelper.newEntry("event", MiniReportManager.getEventName(paramInt1)), MiniProgramReportHelper.newEntry("timestamp", String.valueOf(System.currentTimeMillis())), MiniProgramReportHelper.newEntry("appversion", "8.4.8.4810"), MiniProgramReportHelper.newEntry("qua", QUA.getQUA3()), MiniProgramReportHelper.newEntry("cmd", paramString1), MiniProgramReportHelper.newEntry("retcode", String.valueOf(paramInt2)), MiniProgramReportHelper.newEntry("time_cost", String.valueOf(paramLong)), MiniProgramReportHelper.newEntry("network_type", MiniProgramReportHelper.getNetworkType()), MiniProgramReportHelper.newEntry("busiType", PERF_LEVEL), MiniProgramReportHelper.newEntry("trace_id", paramString2) })), null);
    QCircleReporter.getInstance().addCommandReportData(paramString1);
  }
  
  public static void reportImageQualityEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleReportHelper.newEntry("time_cost", paramString2));
    localArrayList.add(QCircleReportHelper.newEntry("ret_code", paramString3));
    localArrayList.add(QCircleReportHelper.newEntry("url", paramString4));
    localArrayList.add(QCircleReportHelper.newEntry("refer", paramInt + ""));
    reportQualityEvent(paramString1, localArrayList, true);
  }
  
  public static void reportQualityEvent(int paramInt, String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    if ((paramBoolean) && (!sIsSampled) && (!QLog.isColorLevel()) && (QzoneConfig.getQQCircleQualitySampleSwitchOpen()))
    {
      QLog.d("QCircleQualityReporter", 4, "reportQualityEvent miss hit Sample,direct return!");
      return;
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleQualityReporter.1(paramInt, paramString, paramList));
  }
  
  public static void reportQualityEvent(String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    reportQualityEvent(5531, paramString, paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleQualityReporter
 * JD-Core Version:    0.7.0.1
 */