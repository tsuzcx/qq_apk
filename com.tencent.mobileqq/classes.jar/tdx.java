import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.1;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.2;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class tdx
{
  public static String a;
  private static volatile tdx jdField_a_of_type_Tdx;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  private static volatile int f;
  public int a;
  public long a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  Timer jdField_a_of_type_JavaUtilTimer = null;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  public tdy a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long;
  private int d;
  private int e;
  private int g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "readinjoy_report";
    jdField_b_of_type_JavaLangString = "readinjoy_entertime";
    jdField_c_of_type_JavaLangString = "readinjoy_folderstatus";
    jdField_d_of_type_JavaLangString = "readinjoy_kandianmode";
    jdField_e_of_type_JavaLangString = "readinjoy_hearttime";
  }
  
  public tdx()
  {
    this.jdField_a_of_type_Tdy = null;
  }
  
  public static tdx a()
  {
    if (jdField_a_of_type_Tdx == null) {}
    try
    {
      if (jdField_a_of_type_Tdx == null) {
        jdField_a_of_type_Tdx = new tdx();
      }
      return jdField_a_of_type_Tdx;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Tdx != null;
  }
  
  public static void b(int paramInt)
  {
    f = paramInt;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l = -1L;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0);
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getLong(jdField_e_of_type_JavaLangString, -1L);
    }
    return l;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "report time is =" + this.jdField_b_of_type_Long + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    if (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long < 3000L)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "too often");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "has report");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", this.jdField_b_of_type_Int);
      localJSONObject.put("kandian_mode", "" + this.jdField_a_of_type_Int);
      localJSONObject.put("kandian_mode_new", och.a());
      if (!pwb.a()) {
        break label279;
      }
      str = "1";
      localJSONObject.put("is_requesting_articles", str);
      localJSONObject.put("articles_request_type", pwb.a());
      if (!pwb.b()) {
        break label339;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        String str;
        label279:
        QLog.d("ReadInJoyGlobalReporter", 1, localException.getMessage());
        continue;
        int i = 0;
      }
    }
    localJSONObject.put("hit_preload_cache", i);
    localJSONObject.put("os", 1);
    localJSONObject.put("version", och.jdField_a_of_type_JavaLangString);
    localJSONObject.put("channel_id", f);
    if (this.jdField_b_of_type_Boolean) {
      oat.a(null, "", "0X8009296", "0X8009296", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) / 1000.0D), "", "", localJSONObject.toString(), false);
    }
    for (;;)
    {
      pwb.a(false);
      pwb.i();
      return;
      str = "0";
      break;
      oat.a(null, "", "0X80089D1", "0X80089D1", 0, 0, String.valueOf((NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) / 1000.0D), "", "", localJSONObject.toString(), false);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  protected void a(QQAppInterface arg1)
  {
    c();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimerTask == null) {
        this.jdField_a_of_type_JavaUtilTimerTask = new ReadInJoyGlobalReporter.1(this);
      }
      if (this.jdField_a_of_type_JavaUtilTimer == null)
      {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 1000L, 10000L);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "setEnterTime(QQAppInterface app , long time) , time =" + paramLong + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    c(paramQQAppInterface, paramLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    a(paramQQAppInterface);
    d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "setEnterTime(QQAppInterface app , long time , int mode , int status) , time =" + paramLong + "   local time = " + System.currentTimeMillis() + ",isWeishi:" + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0);
    if (paramQQAppInterface != null)
    {
      this.jdField_c_of_type_Long = paramQQAppInterface.getLong(jdField_b_of_type_JavaLangString, -1L);
      this.jdField_d_of_type_Int = paramQQAppInterface.getInt(jdField_d_of_type_JavaLangString, -1);
      this.jdField_e_of_type_Int = paramQQAppInterface.getInt(jdField_c_of_type_JavaLangString, -1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "Load report time from sharedpreferences, time =" + this.jdField_c_of_type_Long);
    }
    if (this.jdField_c_of_type_Long != -1L) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    c();
    e();
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    b();
    c(paramQQAppInterface, -1L, -1, -1);
    b(paramQQAppInterface, -1L);
    jdField_a_of_type_Tdx = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0).edit();
      paramQQAppInterface.putLong(jdField_e_of_type_JavaLangString, paramLong);
      paramQQAppInterface.commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, paramInt1, paramInt2);
    if (a(paramQQAppInterface))
    {
      paramLong = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "Last heart time =" + paramLong + "  currect time=" + NetConnInfoCenter.getServerTimeMillis() + "  last entertime=" + this.jdField_b_of_type_Long);
      }
      if ((paramLong == -1L) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - paramLong) >= 15000L)) {
        break label191;
      }
      this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
      this.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "quite error,set enter time =" + this.jdField_b_of_type_Long);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      a(paramQQAppInterface);
      c(paramQQAppInterface, this.jdField_b_of_type_Long, paramInt1, paramInt2);
      d();
      return;
      label191:
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyGlobalReporter", 2, "report error , time is out ");
      }
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimerTask != null)
      {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences(jdField_a_of_type_JavaLangString + paramQQAppInterface, 0).edit();
    paramQQAppInterface.putLong(jdField_b_of_type_JavaLangString, paramLong);
    paramQQAppInterface.putInt(jdField_c_of_type_JavaLangString, paramInt2);
    paramQQAppInterface.putInt(jdField_d_of_type_JavaLangString, paramInt1);
    paramQQAppInterface.commit();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Tdy == null) {
      this.jdField_a_of_type_Tdy = new tdy(this, null);
    }
    ReadInJoyGlobalReporter.2 local2 = new ReadInJoyGlobalReporter.2(this);
    if (AppSetting.e)
    {
      ThreadManager.executeOnSubThread(local2, true);
      return;
    }
    local2.run();
  }
  
  public void e()
  {
    ReadInJoyGlobalReporter.3 local3 = new ReadInJoyGlobalReporter.3(this);
    if (AppSetting.e)
    {
      ThreadManager.executeOnSubThread(local3, true);
      return;
    }
    local3.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdx
 * JD-Core Version:    0.7.0.1
 */