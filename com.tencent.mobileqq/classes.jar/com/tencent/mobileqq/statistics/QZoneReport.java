package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneReport
{
  public static int a = 0;
  private static long jdField_a_of_type_Long = 0L;
  private static QZoneReport.QzoneGetPublicMsgObserver jdField_a_of_type_ComTencentMobileqqStatisticsQZoneReport$QzoneGetPublicMsgObserver;
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public static boolean a = false;
  private static int b = 2;
  private static int c;
  private static int d;
  private static int e;
  
  static
  {
    jdField_a_of_type_Int = 3;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong();
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    jdField_a_of_type_ComTencentMobileqqStatisticsQZoneReport$QzoneGetPublicMsgObserver = new QZoneReport.QzoneGetPublicMsgObserver();
    jdField_a_of_type_Boolean = false;
  }
  
  public static int a()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = ((AppRuntime)localObject2).getAccount();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "qzone report with empty account");
      }
      return -1;
    }
    if (!((IPublicAccountDataManager)((AppRuntime)localObject2).getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(Long.parseLong("2290230341"))))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "haven't yet follow qzone");
      }
      return -1;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject3;
    if (jdField_a_of_type_Long == 0L)
    {
      localObject2 = BaseApplicationImpl.getApplication().getRuntime().getPreferences();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("qzone_xp_max_req");
      b = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject3).toString(), 2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("qzone_xp_first_req");
      jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject3).toString(), l1);
      localObject3 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_");
      localStringBuilder.append("qzone_xp_req_left");
      ((AtomicInteger)localObject3).set(((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), b));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("qzone_xp_req_gap");
      jdField_a_of_type_Int = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject3).toString(), 3);
      jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(jdField_a_of_type_Long * 1000L);
      d = jdField_a_of_type_JavaUtilCalendar.get(5);
      e = 0;
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if ((e < 5) && (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      localObject2 = jdField_a_of_type_JavaUtilCalendar;
      long l2 = l1 * 1000L;
      ((Calendar)localObject2).setTimeInMillis(l2);
      if (jdField_a_of_type_JavaUtilCalendar.get(5) != d)
      {
        jdField_a_of_type_Long = l1;
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(b);
        localObject2 = BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append("qzone_xp_req_left");
        localObject2 = ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), b);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append("qzone_xp_first_req");
        ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), jdField_a_of_type_Long).apply();
      }
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QZoneReport", 2, "left: 0");
        }
        localObject1 = jdField_a_of_type_JavaUtilCalendar;
        ((Calendar)localObject1).set(5, ((Calendar)localObject1).get(5) + 1);
        jdField_a_of_type_JavaUtilCalendar.set(11, 0);
        jdField_a_of_type_JavaUtilCalendar.set(12, 0);
        jdField_a_of_type_JavaUtilCalendar.set(13, 0);
        return (int)((jdField_a_of_type_JavaUtilCalendar.getTimeInMillis() - l2) / 1000L);
      }
      return Math.max(0, (int)(c - l1));
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("retry: ");
      ((StringBuilder)localObject1).append(e);
      ((StringBuilder)localObject1).append(", sending: ");
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      QLog.w("QZoneReport", 2, ((StringBuilder)localObject1).toString());
    }
    return -1;
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt == 1) && (jdField_a_of_type_Boolean)) {
      return;
    }
    if (paramInt == 1) {
      jdField_a_of_type_Boolean = true;
    }
    LpReportInfo_dc02880 localLpReportInfo_dc02880 = new LpReportInfo_dc02880(6, paramInt);
    LpReportManager.getInstance().reportToDC02880(localLpReportInfo_dc02880, false, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    RemoteHandleManager.getInstance().addWebEventListener(new QZoneReport.1(paramQQAppInterface));
    long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME", 0L);
    QLog.d("[PhotoAlbum]QZoneReport", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME lastUpdateTime:", Long.valueOf(l) });
    RemoteHandleManager.getInstance().getSender().getTravelGroup(l);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt, String paramString)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.a(paramQQAppInterface.getApp(), "qzone_xp_config_version", paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneReport", 2, String.format(Locale.getDefault(), "received qzone xp Config remote version: %d, localVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if (i != j)
    {
      paramConfig = ConfigServlet.b(paramConfig, j, paramInt);
      if (!TextUtils.isEmpty(paramConfig))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs|type: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(",content: ");
          localStringBuilder.append(paramConfig);
          localStringBuilder.append(",version: ");
          localStringBuilder.append(i);
          QLog.i("QZoneReport", 2, localStringBuilder.toString());
        }
        try
        {
          paramInt = Math.max(0, b - jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          paramConfig = new JSONObject(paramConfig);
          b = paramConfig.optInt("maxReq", 2);
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(Math.max(0, b - paramInt));
          jdField_a_of_type_Int = paramConfig.optInt("reqGap", 3);
          paramConfig = BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("_");
          localStringBuilder.append("qzone_xp_max_req");
          paramConfig = paramConfig.putInt(localStringBuilder.toString(), b);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("_");
          localStringBuilder.append("qzone_xp_req_gap");
          paramConfig = paramConfig.putInt(localStringBuilder.toString(), jdField_a_of_type_Int);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("_");
          localStringBuilder.append("qzone_xp_req_left");
          paramConfig.putInt(localStringBuilder.toString(), jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()).apply();
        }
        catch (JSONException paramConfig)
        {
          if (QLog.isDevelopLevel()) {
            paramConfig.printStackTrace();
          }
        }
        SharedPreUtils.a(paramQQAppInterface.getApp(), "qzone_xp_config_version", paramString, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneReport", 2, "config is null");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("QZoneReport", 2, "config version not updated, nothing to do");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneReport", 2, "sending");
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(NetConnInfoCenter.getServerTime());
    IQzoneReq localIQzoneReq = (IQzoneReq)QRoute.api(IQzoneReq.class);
    QZoneReport.QzoneGetPublicMsgObserver localQzoneGetPublicMsgObserver = jdField_a_of_type_ComTencentMobileqqStatisticsQZoneReport$QzoneGetPublicMsgObserver;
    long l = paramQQAppInterface.getLongAccountUin();
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    localIQzoneReq.sentGetPublicMsgServlet(paramQQAppInterface, localQzoneGetPublicMsgObserver, l, str);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800915C", "0X800915C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QZoneReport
 * JD-Core Version:    0.7.0.1
 */