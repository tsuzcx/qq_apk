package com.tencent.mobileqq.kandian.glue.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ReadInJoyGlobalReporter
{
  private static volatile ReadInJoyGlobalReporter jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter;
  public static String a = "readinjoy_report";
  public static String b = "readinjoy_entertime";
  public static String c = "readinjoy_folderstatus";
  public static String d = "readinjoy_kandianmode";
  public static String e = "readinjoy_hearttime";
  private static volatile int f;
  public int a;
  public long a;
  ReadInJoyGlobalReporter.ScreenBroadcastReceiver jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter$ScreenBroadcastReceiver = null;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  Timer jdField_a_of_type_JavaUtilTimer = null;
  TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long = 0L;
  private int d;
  private int e;
  private int g = 0;
  
  public ReadInJoyGlobalReporter()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
  }
  
  public static ReadInJoyGlobalReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter == null) {
          jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter = new ReadInJoyGlobalReporter();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter != null;
  }
  
  public static void c(int paramInt)
  {
    f = paramInt;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramQQAppInterface);
    paramQQAppInterface = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
    long l = -1L;
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getLong(jdField_e_of_type_JavaLangString, -1L);
    }
    return l;
  }
  
  protected String a()
  {
    double d1 = NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long;
    Double.isNaN(d1);
    return String.valueOf(d1 / 1000.0D);
  }
  
  @NotNull
  protected JSONObject a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report time is =");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append(",isWeishi:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("ReadInJoyGlobalReporter", 2, ((StringBuilder)localObject).toString());
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
      localObject = a();
      IPublicAccountReportUtils localIPublicAccountReportUtils;
      long l1;
      long l2;
      double d1;
      if (this.jdField_b_of_type_Boolean)
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        l1 = NetConnInfoCenter.getServerTimeMillis();
        l2 = this.jdField_b_of_type_Long;
        d1 = l1 - l2;
        Double.isNaN(d1);
        d1 /= 1000.0D;
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8009296", "0X8009296", 0, 0, String.valueOf(d1), "", "", ((JSONObject)localObject).toString(), false);
      }
      else
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        l1 = NetConnInfoCenter.getServerTimeMillis();
        l2 = this.jdField_b_of_type_Long;
        d1 = l1 - l2;
        Double.isNaN(d1);
        d1 /= 1000.0D;
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80089D1", "0X80089D1", 0, 0, String.valueOf(d1), "", "", ((JSONObject)localObject).toString(), false);
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, localException.getMessage());
    }
    ArticleInfoModule.a(false);
    ArticleInfoModule.a();
  }
  
  protected void a(QQAppInterface arg1)
  {
    f();
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEnterTime(QQAppInterface app , long time) , time =");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",isWeishi:");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.i("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    c(paramQQAppInterface, paramLong, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    a(paramQQAppInterface);
    g();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("setEnterTime(QQAppInterface app , long time , int mode , int status) , time =");
      paramQQAppInterface.append(paramLong);
      paramQQAppInterface.append("   local time = ");
      paramQQAppInterface.append(System.currentTimeMillis());
      paramQQAppInterface.append(",isWeishi:");
      paramQQAppInterface.append(this.jdField_b_of_type_Boolean);
      QLog.i("ReadInJoyGlobalReporter", 2, paramQQAppInterface.toString());
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
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getSharedPreferences(str, 0);
    if (paramQQAppInterface != null)
    {
      this.jdField_c_of_type_Long = paramQQAppInterface.getLong(jdField_b_of_type_JavaLangString, -1L);
      this.jdField_d_of_type_Int = paramQQAppInterface.getInt(jdField_d_of_type_JavaLangString, -1);
      this.jdField_e_of_type_Int = paramQQAppInterface.getInt(jdField_c_of_type_JavaLangString, -1);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("Load report time from sharedpreferences, time =");
      paramQQAppInterface.append(this.jdField_c_of_type_Long);
      QLog.i("ReadInJoyGlobalReporter", 2, paramQQAppInterface.toString());
    }
    if (this.jdField_c_of_type_Long != -1L) {
      bool = true;
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    e();
    c(paramQQAppInterface, -1L, -1, -1);
    b(paramQQAppInterface, -1L);
    jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface);
      paramQQAppInterface = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit();
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
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Last heart time =");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("  currect time=");
        localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
        localStringBuilder.append("  last entertime=");
        localStringBuilder.append(this.jdField_b_of_type_Long);
        QLog.i("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
      }
      if ((paramLong != -1L) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - paramLong) < 15000L))
      {
        this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
        this.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("quite error,set enter time =");
          localStringBuilder.append(this.jdField_b_of_type_Long);
          QLog.i("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("ReadInJoyGlobalReporter", 2, "report error , time is out ");
      }
    }
    this.jdField_a_of_type_Boolean = false;
    a(paramQQAppInterface);
    c(paramQQAppInterface, this.jdField_b_of_type_Long, paramInt1, paramInt2);
    g();
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramQQAppInterface);
    paramQQAppInterface = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramQQAppInterface.putLong(jdField_b_of_type_JavaLangString, paramLong);
    paramQQAppInterface.putInt(jdField_c_of_type_JavaLangString, paramInt2);
    paramQQAppInterface.putInt(jdField_d_of_type_JavaLangString, paramInt1);
    paramQQAppInterface.commit();
  }
  
  public void e()
  {
    f();
    h();
  }
  
  public void f()
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
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter$ScreenBroadcastReceiver == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter$ScreenBroadcastReceiver = new ReadInJoyGlobalReporter.ScreenBroadcastReceiver(this, null);
    }
    ReadInJoyGlobalReporter.2 local2 = new ReadInJoyGlobalReporter.2(this);
    if (AppSetting.f)
    {
      ThreadManager.executeOnSubThread(local2, true);
      return;
    }
    local2.run();
  }
  
  public void h()
  {
    ReadInJoyGlobalReporter.3 local3 = new ReadInJoyGlobalReporter.3(this);
    if (AppSetting.f)
    {
      ThreadManager.executeOnSubThread(local3, true);
      return;
    }
    local3.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter
 * JD-Core Version:    0.7.0.1
 */