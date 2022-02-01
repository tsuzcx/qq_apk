package cooperation.ilive.lite;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.time.TimeMonitorData;
import cooperation.ilive.time.TimeMonitorManager;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class IliveLiteMonitorUtil
{
  private static long jdField_a_of_type_Long = 0L;
  private static boolean jdField_a_of_type_Boolean = true;
  private static long jdField_b_of_type_Long = 0L;
  private static boolean jdField_b_of_type_Boolean = true;
  private static boolean c = true;
  private static boolean d = true;
  private static boolean e = true;
  private static boolean f = true;
  private static boolean g = true;
  private static boolean h = true;
  private static boolean i = true;
  private static boolean j = true;
  
  public static long a()
  {
    return jdField_b_of_type_Long;
  }
  
  public static HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu_num", String.valueOf(DeviceInfoUtil.b()));
    localHashMap.put("device_level", String.valueOf(DeviceInfoUtils.a()));
    return localHashMap;
  }
  
  public static void a()
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    a("live_activity_launch");
    a("live_activity_frame");
    jdField_b_of_type_Boolean = false;
  }
  
  public static void a(int paramInt)
  {
    if (!e) {
      return;
    }
    a("live_click_process_state");
    HashMap localHashMap = new HashMap();
    boolean bool = b();
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("tool_exist", str1);
    if (c()) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("service_exist", str1);
    localHashMap.put("from", String.valueOf(paramInt));
    e = false;
    a("live_click_process_state", localHashMap);
  }
  
  public static void a(long paramLong)
  {
    a("live_first_play_error");
    HashMap localHashMap = new HashMap();
    localHashMap.put("room_id", String.valueOf(paramLong));
    a("live_first_play_error", localHashMap);
  }
  
  public static void a(String paramString)
  {
    TimeMonitorManager.a().b(paramString);
  }
  
  public static void a(String paramString, long paramLong)
  {
    TimeMonitorManager.a().a(paramString, paramLong);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TimeMonitorManager.a().a(paramString1)) {
      return;
    }
    TimeMonitorManager.a().a(paramString1).a(paramString2);
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (!TimeMonitorManager.a().a(paramString)) {
      return;
    }
    TimeMonitorManager.a().a(paramString).a(paramString, paramHashMap);
    TimeMonitorManager.a().a(paramString);
  }
  
  public static void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("has_cache", str);
    localHashMap.put("offest_time", String.valueOf(jdField_a_of_type_Long));
    jdField_a_of_type_Boolean = false;
    a("lite_login_auth", localHashMap);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    a("live_enter_with_rtmp");
    HashMap localHashMap = new HashMap();
    String str2 = "1";
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("has_rtmp", str1);
    if (c) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("is_first", str1);
    localHashMap.put("from", String.valueOf(paramInt));
    c = false;
    a("live_enter_with_rtmp", localHashMap);
  }
  
  public static boolean a()
  {
    return (b()) && (c());
  }
  
  public static void b()
  {
    if (!d) {
      return;
    }
    c("live_on_bind");
    a("live_handle_ipc_task");
    d = false;
  }
  
  public static void b(long paramLong)
  {
    if (!f) {
      return;
    }
    TimeMonitorManager.a().a("live_service_consume", paramLong);
    f = false;
    c("live_service_consume");
  }
  
  public static void b(String paramString)
  {
    if (!TimeMonitorManager.a().a(paramString)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    String str;
    if (h) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("is_first", str);
    h = false;
    TimeMonitorManager.a().a(paramString).a(localHashMap);
    TimeMonitorManager.a().a(paramString);
  }
  
  public static boolean b()
  {
    return PreloadProcHitSession.a("com.tencent.mobileqq:tool");
  }
  
  public static void c()
  {
    c("live_handle_ipc_task");
  }
  
  public static void c(String paramString)
  {
    if (!TimeMonitorManager.a().a(paramString)) {
      return;
    }
    TimeMonitorManager.a().a(paramString).b(paramString);
    TimeMonitorManager.a().a(paramString);
  }
  
  public static boolean c()
  {
    return IliveEntranceUtil.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq.activity.PreloadWebService");
  }
  
  public static void d()
  {
    if (!g) {
      return;
    }
    TimeMonitorManager.a().a("live_launch_total_time", a());
    c("live_launch_total_time");
    g = false;
  }
  
  public static void d(String paramString)
  {
    if (jdField_b_of_type_Long != 0L) {
      return;
    }
    try
    {
      jdField_b_of_type_Long = Long.parseLong(paramString);
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      QLog.e("IliveLiteMonitorUtil", 1, " setFirstClickTime exception ", paramString);
    }
  }
  
  private static boolean d()
  {
    BusinessConfig localBusinessConfig = LiteLiveSDKFactory.a().a();
    if (localBusinessConfig == null) {
      return false;
    }
    return "1".equals(localBusinessConfig.a.get("has_preload"));
  }
  
  public static void e()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    a("lite_login_auth");
    jdField_a_of_type_Long = System.currentTimeMillis() - LocalMultiProcConfig.getLong4Uin("key_qq_ilive_connect_auth_time", 0L, IliveAuthManager.getLongUin());
    jdField_a_of_type_Boolean = false;
  }
  
  public static void f()
  {
    if (!j) {
      return;
    }
    a("live_has_init_sdk");
    HashMap localHashMap = new HashMap();
    boolean bool = LiteLiveSDKFactory.a().a();
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("has_init_sdk", str1);
    if (d()) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("has_enter_preload", str1);
    j = false;
    a("live_has_init_sdk", localHashMap);
  }
  
  public static void g()
  {
    if (!i) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new IliveLiteMonitorUtil.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteMonitorUtil
 * JD-Core Version:    0.7.0.1
 */