package cooperation.qqcircle.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.QCircleConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleQualityReporter
{
  public static final String KEY_ATTACH_INFO = "attach_info";
  public static final String KEY_CLIENT_TIME = "client_time";
  public static final String KEY_COUNT = "count";
  public static final String KEY_EVENT_ID = "event_id";
  public static final String KEY_EVENT_ID_IMAGE_DECODE = "image_decode_ret";
  public static final String KEY_EVENT_ID_IMAGE_DOWNLOAD = "image_download_ret";
  public static final String KEY_EVENT_ID_IMAGE_DOWNLOAD_SPEED = "net_work_speed";
  public static final String KEY_EVENT_ID_IMAGE_GREY = "imgae_show_grey";
  public static final String KEY_EVENT_ID_IMAGE_LOAD = "image_load_ret";
  public static final String KEY_HOST_UIN = "host_uin";
  public static final String KEY_ID = "identify";
  public static final String KEY_IMAGE_PUBLISH_FULL_LINK = "image_publish_full_link";
  public static final String KEY_MOBILE_TYPE = "mobile_type";
  public static final String KEY_NETWORK_TYPE = "network_type";
  public static final String KEY_OBJ_ID = "obj_id";
  public static final String KEY_OUTBOX_TASK_RESEND_EVENT = "outbox_task_resend_event";
  public static final String KEY_OUTBOX_TASK_RESEND_EVENT_FINAL = "outbox_task_resend_event_final";
  public static final String KEY_PLATFORM = "platform";
  public static final String KEY_QUA = "qua";
  public static final String KEY_RATE = "rate";
  public static final String KEY_REFER = "refer";
  public static final String KEY_RET_CODE = "ret_code";
  public static final String KEY_SKIN_PACKAGE_DOWNLOAD_EVENT = "skin_package_download_event";
  public static final String KEY_SKIN_PACKAGE_LOAD_EVENT = "skin_package_load_event";
  public static final String KEY_TIME_COST = "time_cost";
  public static final String KEY_TRACE_ID = "trace_id";
  public static final String KEY_TYPE = "type";
  public static final String KEY_UNIQUE_ID = "unique_id";
  public static final String KEY_URL = "url";
  public static final String KEY_VERSION = "version";
  public static final String KEY_VIDEO_PUBLISH_FULL_LINK = "video_publish_full_link";
  private static String PERF_LEVEL = null;
  private static final String TAG = "QCircleQualityReporter";
  private static long sFinalUniqueId = 0L;
  private static boolean sIsSampled = true;
  
  private static void checkIsSampled()
  {
    long l1 = getDaysSince1970();
    long l2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    if (l2 == 0L) {
      return;
    }
    int i = (int)(l1 % 100);
    if (i == l2 % 100) {}
    for (boolean bool = true;; bool = false)
    {
      sIsSampled = bool;
      if (RFLog.isDevelopLevel()) {
        RFLog.d("QCircleQualityReporter", RFLog.DEV, "抽中的尾数： " + i);
      }
      RFLog.d("QCircleQualityReporter", RFLog.USR, "checkIsSampled:" + sIsSampled);
      return;
    }
  }
  
  public static List<FeedCloudCommon.Entry> createBaseEntries(String paramString)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("host_uin", String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin())), QCircleReportHelper.newEntry("qua", QCircleServiceImpl.getQZoneService().getQUA3()), QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType()), QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("event_id", paramString), QCircleReportHelper.newEntry("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), QCircleReportHelper.newEntry("version", ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName()), QCircleReportHelper.newEntry("platform", "AND"), QCircleReportHelper.newEntry("unique_id", String.valueOf(obtainUniqueId())) }));
  }
  
  private static void generateUniqueId()
  {
    sFinalUniqueId = System.currentTimeMillis() / 1000L << 32 | MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
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
  
  public static void reportImageQualityEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, List<FeedCloudCommon.Entry>... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleReportHelper.newEntry("time_cost", paramString2));
    localArrayList.add(QCircleReportHelper.newEntry("ret_code", paramString3));
    localArrayList.add(QCircleReportHelper.newEntry("url", paramString4));
    localArrayList.add(QCircleReportHelper.newEntry("type", paramInt + ""));
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramInt = 0;
      while (paramInt < paramVarArgs.length)
      {
        localArrayList.addAll(paramVarArgs[paramInt]);
        paramInt += 1;
      }
    }
    reportQualityEvent(paramString1, localArrayList, true);
  }
  
  public static void reportQualityEvent(int paramInt, String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    if ((paramBoolean) && (!sIsSampled) && (!RFLog.isColorLevel()) && (QCircleConfig.getQQCircleQualitySampleSwitchOpen()))
    {
      RFLog.d("QCircleQualityReporter", RFLog.DEV, "reportQualityEvent miss hit Sample,direct return!");
      return;
    }
    QCircleReporter.getInstance().getReportHandler().post(new QCircleQualityReporter.1(paramInt, paramString, paramList));
  }
  
  public static void reportQualityEvent(String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    reportQualityEvent(5531, paramString, paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleQualityReporter
 * JD-Core Version:    0.7.0.1
 */