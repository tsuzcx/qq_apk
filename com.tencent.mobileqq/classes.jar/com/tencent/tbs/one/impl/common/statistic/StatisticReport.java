package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.log.TBSLog;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.d.a;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class StatisticReport
{
  private static String a = "https://tbsone.imtt.qq.com";
  private static WeakReference<Context> b;
  private static String c = "log.lock";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  
  private StatisticReport(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = String.valueOf(paramInt);
  }
  
  private static int a()
  {
    Object localObject = new File(TBSLog.getLogPath(), c);
    if (((File)localObject).exists()) {
      try
      {
        localObject = com.tencent.tbs.one.impl.a.c.a(new FileInputStream((File)localObject), "utf-8");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return -1;
        }
        int j = Integer.parseInt((String)localObject);
        return j;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  public static StatisticReport create(String paramString, int paramInt)
  {
    return new StatisticReport(paramString, paramInt);
  }
  
  public static void initialize(Context paramContext)
  {
    b = new WeakReference(paramContext);
  }
  
  public static void reportLog()
  {
    for (;;)
    {
      try
      {
        Context localContext1 = (Context)b.get();
        if (localContext1 == null)
        {
          f.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Object[] { new Throwable("Null context!") });
          return;
        }
        int j = a();
        if ((j > 0) && (j == c.c(localContext1)))
        {
          f.a("Detected logs have been uploaded in this version, log report ignored.", new Object[0]);
          continue;
        }
        b.a();
      }
      finally {}
      b.a(new StatisticReport.1(localContext2));
    }
  }
  
  public static void shiftRepService(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "https://tbsone.sparta.html5.qq.com";; str = "https://tbsone.imtt.qq.com")
    {
      a = str;
      new StringBuilder("Shifting to report server: ").append(a);
      return;
    }
  }
  
  public void report()
  {
    Context localContext = (Context)b.get();
    if (localContext == null)
    {
      f.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Object[] { new Throwable("Null context!") });
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PROTV", Integer.valueOf(1));
    localHashMap.put("FUNC", Integer.valueOf(2));
    localHashMap.put("EVENT", this.d);
    localHashMap.put("CODE", this.e);
    if (!TextUtils.isEmpty(this.f)) {}
    for (Object localObject = this.f.replaceAll("\r\n|\r|\n", "");; localObject = "")
    {
      localHashMap.put("DESCRIPTION", localObject);
      localHashMap.put("IMEI", c.e(localContext));
      localHashMap.put("DEVMODEL", c.b());
      localHashMap.put("CPUABI", c.a());
      localHashMap.put("APPVERCODE", c.c(localContext));
      localHashMap.put("APPVERNAME", c.b(localContext));
      localHashMap.put("APPPKG", localContext.getPackageName());
      localHashMap.put("CREATETIME", System.currentTimeMillis());
      localHashMap.put("APNTYPE", c.a(localContext));
      localHashMap.put("ANDROIDID", c.f(localContext));
      localHashMap.put("ONECODE", "1");
      localHashMap.put("ONENAME", "1.0.0");
      localHashMap.put("COMPNAME", this.g);
      localHashMap.put("COMPCODE", this.h);
      localHashMap.put("DEPSCODE", this.i);
      localHashMap.put("SDKCODE", c.c());
      localHashMap.put("MODEL", Build.MODEL);
      localHashMap.put("ADV", Build.VERSION.RELEASE);
      localObject = new JSONObject(localHashMap).toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = new a(localContext, a, "POST", null, ((String)localObject).getBytes());
      ((a)localObject).f = new StatisticReport.2(this);
      ((a)localObject).a(new StatisticReport.3(this));
      return;
    }
  }
  
  public StatisticReport setComponent(String paramString, int paramInt)
  {
    this.g = paramString;
    this.h = String.valueOf(paramInt);
    return this;
  }
  
  public StatisticReport setDEPSCode(int paramInt)
  {
    this.i = String.valueOf(paramInt);
    return this;
  }
  
  public StatisticReport setDescription(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public StatisticReport setDescription(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("@");
    if (paramThrowable != null) {}
    for (paramString = Log.getStackTraceString(paramThrowable);; paramString = "")
    {
      this.f = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport
 * JD-Core Version:    0.7.0.1
 */