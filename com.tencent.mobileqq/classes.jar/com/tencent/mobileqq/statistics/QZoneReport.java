package com.tencent.mobileqq.statistics;

import aikp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.servlet.QzonePublicMsgServlet;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneReport
{
  public static int a;
  private static long jdField_a_of_type_Long;
  private static aikp jdField_a_of_type_Aikp = new aikp();
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public static boolean a;
  private static int b = 2;
  private static int c;
  private static int d;
  private static int e;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
    jdField_a_of_type_Int = 3;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong();
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  }
  
  public static int a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    String str = ((AppRuntime)localObject).getAccount();
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "qzone report with empty account");
      }
      return -1;
    }
    if (!((PublicAccountDataManager)((AppRuntime)localObject).getManager(55)).a(Long.valueOf(Long.parseLong("2290230341"))))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "haven't yet follow qzone");
      }
      return -1;
    }
    long l = NetConnInfoCenter.getServerTime();
    if (jdField_a_of_type_Long == 0L)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime().getPreferences();
      b = ((SharedPreferences)localObject).getInt(str + "_" + "qzone_xp_max_req", 2);
      jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong(str + "_" + "qzone_xp_first_req", l);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(((SharedPreferences)localObject).getInt(str + "_" + "qzone_xp_req_left", b));
      jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt(str + "_" + "qzone_xp_req_gap", 3);
      jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(jdField_a_of_type_Long * 1000L);
      d = jdField_a_of_type_JavaUtilCalendar.get(5);
      e = 0;
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if ((e >= 5) || (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "retry: " + e + ", sending: " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return -1;
    }
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(l * 1000L);
    if (jdField_a_of_type_JavaUtilCalendar.get(5) != d)
    {
      jdField_a_of_type_Long = l;
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(b);
      BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(str + "_" + "qzone_xp_req_left", b).putLong(str + "_" + "qzone_xp_first_req", jdField_a_of_type_Long).apply();
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "left: 0");
      }
      jdField_a_of_type_JavaUtilCalendar.set(5, jdField_a_of_type_JavaUtilCalendar.get(5) + 1);
      jdField_a_of_type_JavaUtilCalendar.set(11, 0);
      jdField_a_of_type_JavaUtilCalendar.set(12, 0);
      jdField_a_of_type_JavaUtilCalendar.set(13, 0);
      return (int)((jdField_a_of_type_JavaUtilCalendar.getTimeInMillis() - l * 1000L) / 1000L);
    }
    return Math.max(0, (int)(c - l));
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
    if (QLog.isColorLevel()) {
      QLog.i("QZoneReport", 2, "sending");
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(NetConnInfoCenter.getServerTime());
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), QzonePublicMsgServlet.class);
    localNewIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    BaseApplicationImpl.getApplication().getRuntime().registObserver(jdField_a_of_type_Aikp);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800915C", "0X800915C", 0, 0, "", "", "", "");
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
      if (!TextUtils.isEmpty(paramConfig)) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneReport", 2, "receiveAllConfigs|type: " + paramInt + ",content: " + paramConfig + ",version: " + i);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          paramInt = Math.max(0, b - jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          paramConfig = new JSONObject(paramConfig);
          b = paramConfig.optInt("maxReq", 2);
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(Math.max(0, b - paramInt));
          jdField_a_of_type_Int = paramConfig.optInt("reqGap", 3);
          BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(paramString + "_" + "qzone_xp_max_req", b).putInt(paramString + "_" + "qzone_xp_req_gap", jdField_a_of_type_Int).putInt(paramString + "_" + "qzone_xp_req_left", jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()).apply();
          SharedPreUtils.a(paramQQAppInterface.getApp(), "qzone_xp_config_version", paramString, i);
          return;
        }
        catch (JSONException paramConfig)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              paramConfig.printStackTrace();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.i("QZoneReport", 2, "config is null");
      return;
    }
    QLog.i("QZoneReport", 2, "config version not updated, nothing to do");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QZoneReport
 * JD-Core Version:    0.7.0.1
 */