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
    try
    {
      Context localContext = (Context)b.get();
      if (localContext == null)
      {
        f.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Object[] { new Throwable("Null context!") });
        return;
      }
      int j = a();
      if ((j > 0) && (j == c.c(localContext)))
      {
        f.a("Detected logs have been uploaded in this version, log report ignored.", new Object[0]);
        return;
      }
      b.a();
      b.a(new StatisticReport.1(localContext));
      return;
    }
    finally {}
  }
  
  public static void shiftRepService(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "https://tbsone.sparta.html5.qq.com";
    } else {
      str = "https://tbsone.imtt.qq.com";
    }
    a = str;
    new StringBuilder("Shifting to report server: ").append(a);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.e);
    localHashMap.put("CODE", ((StringBuilder)localObject).toString());
    boolean bool = TextUtils.isEmpty(this.f);
    localObject = "";
    if (!bool) {
      localObject = this.f.replaceAll("\r\n|\r|\n", "");
    }
    localHashMap.put("DESCRIPTION", localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e(localContext));
    localHashMap.put("IMEI", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.b());
    localHashMap.put("DEVMODEL", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.a());
    localHashMap.put("CPUABI", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.c(localContext));
    localHashMap.put("APPVERCODE", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.b(localContext));
    localHashMap.put("APPVERNAME", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localContext.getPackageName());
    localHashMap.put("APPPKG", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localHashMap.put("CREATETIME", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.a(localContext));
    localHashMap.put("APNTYPE", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.f(localContext));
    localHashMap.put("ANDROIDID", ((StringBuilder)localObject).toString());
    localHashMap.put("ONECODE", "1");
    localHashMap.put("ONENAME", "1.0.0");
    localHashMap.put("COMPNAME", this.g);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.h);
    localHashMap.put("COMPCODE", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i);
    localHashMap.put("DEPSCODE", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.c());
    localHashMap.put("SDKCODE", ((StringBuilder)localObject).toString());
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("ADV", Build.VERSION.RELEASE);
    localObject = new JSONObject(localHashMap).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = new a(localContext, a, "POST", null, ((String)localObject).getBytes());
    ((a)localObject).f = new StatisticReport.2(this);
    ((a)localObject).a(new StatisticReport.3(this));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("@");
    if (paramThrowable != null) {
      paramString = Log.getStackTraceString(paramThrowable);
    } else {
      paramString = "";
    }
    localStringBuilder.append(paramString);
    this.f = localStringBuilder.toString();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport
 * JD-Core Version:    0.7.0.1
 */