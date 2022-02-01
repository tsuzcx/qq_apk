package com.tencent.mobileqq.kandian.glue.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ReadInJoyGlobalReporter
{
  private static volatile ReadInJoyGlobalReporter a;
  public static String b = "readinjoy_report";
  public static String c = "readinjoy_entertime";
  public static String d = "readinjoy_folderstatus";
  public static String e = "readinjoy_kandianmode";
  public static String f = "readinjoy_hearttime";
  private static volatile int u;
  final Object g = new Object();
  public int h = 0;
  public long i = 0L;
  ReadInJoyGlobalReporter.ScreenBroadcastReceiver j = null;
  Timer k = null;
  TimerTask l = null;
  private long m = -1L;
  private int n = 0;
  private int o = 2;
  private long p = 0L;
  private int q = 0;
  private int r = 0;
  private boolean s = false;
  private boolean t;
  private int v = 0;
  
  public static void c(int paramInt)
  {
    u = paramInt;
  }
  
  public static ReadInJoyGlobalReporter e()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ReadInJoyGlobalReporter();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static boolean f()
  {
    return a != null;
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramQQAppInterface);
    paramQQAppInterface = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
    long l1 = -1L;
    if (paramQQAppInterface != null) {
      l1 = paramQQAppInterface.getLong(f, -1L);
    }
    return l1;
  }
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report time is =");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(",isWeishi:");
      ((StringBuilder)localObject).append(this.t);
      QLog.i("ReadInJoyGlobalReporter", 2, ((StringBuilder)localObject).toString());
    }
    if (NetConnInfoCenter.getServerTimeMillis() - this.i < 3000L)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "too often");
      return;
    }
    if (this.s)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, "has report");
      return;
    }
    this.s = true;
    this.i = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      localObject = h();
      long l1;
      long l2;
      double d1;
      if (this.t)
      {
        l1 = NetConnInfoCenter.getServerTimeMillis();
        l2 = this.m;
        d1 = l1 - l2;
        Double.isNaN(d1);
        d1 /= 1000.0D;
        PublicAccountReportUtils.a(null, "", "0X8009296", "0X8009296", 0, 0, String.valueOf(d1), "", "", ((JSONObject)localObject).toString(), false);
      }
      else
      {
        l1 = NetConnInfoCenter.getServerTimeMillis();
        l2 = this.m;
        d1 = l1 - l2;
        Double.isNaN(d1);
        d1 /= 1000.0D;
        PublicAccountReportUtils.a(null, "", "0X80089D1", "0X80089D1", 0, 0, String.valueOf(d1), "", "", ((JSONObject)localObject).toString(), false);
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, localException.getMessage());
    }
    ArticleInfoModule.a(false);
    ArticleInfoModule.d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEnterTime(QQAppInterface app , long time) , time =");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",isWeishi:");
      localStringBuilder.append(this.t);
      QLog.i("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
    }
    this.m = paramLong;
    this.s = false;
    c(paramQQAppInterface, paramLong, this.h, this.n);
    c(paramQQAppInterface);
    l();
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
      paramQQAppInterface.append(this.t);
      QLog.i("ReadInJoyGlobalReporter", 2, paramQQAppInterface.toString());
    }
    this.m = paramLong;
    this.n = paramInt2;
    this.h = paramInt1;
    this.s = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(paramQQAppInterface);
      paramQQAppInterface = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      paramQQAppInterface.putLong(f, paramLong);
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
    if (b(paramQQAppInterface))
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
        localStringBuilder.append(this.m);
        QLog.i("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
      }
      if ((paramLong != -1L) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - paramLong) < 15000L))
      {
        this.m = this.p;
        this.n = this.r;
        this.h = this.q;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("quite error,set enter time =");
          localStringBuilder.append(this.m);
          QLog.i("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("ReadInJoyGlobalReporter", 2, "report error , time is out ");
      }
    }
    this.s = false;
    c(paramQQAppInterface);
    c(paramQQAppInterface, this.m, paramInt1, paramInt2);
    l();
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getSharedPreferences(str, 0);
    if (paramQQAppInterface != null)
    {
      this.p = paramQQAppInterface.getLong(c, -1L);
      this.q = paramQQAppInterface.getInt(e, -1);
      this.r = paramQQAppInterface.getInt(d, -1);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("Load report time from sharedpreferences, time =");
      paramQQAppInterface.append(this.p);
      QLog.i("ReadInJoyGlobalReporter", 2, paramQQAppInterface.toString());
    }
    if (this.p != -1L) {
      bool = true;
    }
    return bool;
  }
  
  protected void c(QQAppInterface arg1)
  {
    k();
    synchronized (this.g)
    {
      if (this.l == null) {
        this.l = new ReadInJoyGlobalReporter.1(this);
      }
      if (this.k == null)
      {
        this.k = new Timer();
        this.k.schedule(this.l, 1000L, 10000L);
      }
      return;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramQQAppInterface);
    paramQQAppInterface = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramQQAppInterface.putLong(c, paramLong);
    paramQQAppInterface.putInt(d, paramInt2);
    paramQQAppInterface.putInt(e, paramInt1);
    paramQQAppInterface.commit();
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    j();
    c(paramQQAppInterface, -1L, -1, -1);
    b(paramQQAppInterface, -1L);
    a = null;
    this.t = false;
  }
  
  public long g()
  {
    return this.m;
  }
  
  @NotNull
  protected JSONObject h()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected String i()
  {
    double d1 = NetConnInfoCenter.getServerTimeMillis() - this.m;
    Double.isNaN(d1);
    return String.valueOf(d1 / 1000.0D);
  }
  
  public void j()
  {
    k();
    m();
  }
  
  public void k()
  {
    synchronized (this.g)
    {
      if (this.l != null)
      {
        this.l.cancel();
        this.l = null;
      }
      if (this.k != null)
      {
        this.k.cancel();
        this.k = null;
      }
      return;
    }
  }
  
  public void l()
  {
    if (this.j == null) {
      this.j = new ReadInJoyGlobalReporter.ScreenBroadcastReceiver(this, null);
    }
    ReadInJoyGlobalReporter.2 local2 = new ReadInJoyGlobalReporter.2(this);
    if (AppSetting.g)
    {
      ThreadManager.executeOnSubThread(local2, true);
      return;
    }
    local2.run();
  }
  
  public void m()
  {
    ReadInJoyGlobalReporter.3 local3 = new ReadInJoyGlobalReporter.3(this);
    if (AppSetting.g)
    {
      ThreadManager.executeOnSubThread(local3, true);
      return;
    }
    local3.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter
 * JD-Core Version:    0.7.0.1
 */