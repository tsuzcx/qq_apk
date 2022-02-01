package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.a;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class l
{
  public static volatile boolean a = false;
  private static String b = "MsfExistReporter";
  private static final String c = "SP_MSF_ALIVE_TODAY_ZERO_TIME";
  private static ConcurrentHashMap d = new ConcurrentHashMap();
  private static final int e = 0;
  private static final int f = 1;
  private static final int g = 2;
  private static final String h = "sp_report_login";
  private static final String i = "key_report_login_time_millis_today_zero_";
  
  private static long a()
  {
    return BaseApplication.getContext().getSharedPreferences("sp_boot_msf", 0).getLong("SP_MSF_ALIVE_TODAY_ZERO_TIME", 0L);
  }
  
  private static long a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_report_login", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_report_login_time_millis_today_zero_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  private static void a(long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("sp_boot_msf", 0).edit().putLong("SP_MSF_ALIVE_TODAY_ZERO_TIME", paramLong).apply();
  }
  
  public static void a(Handler paramHandler)
  {
    if (paramHandler != null) {}
    try
    {
      if (paramHandler.hasMessages(10500)) {
        paramHandler.removeMessages(10500);
      }
      long l1 = System.currentTimeMillis();
      long l2 = ((TimeZone.getDefault().getRawOffset() + l1) / 86400000L + 1L) * 86400000L - TimeZone.getDefault().getRawOffset() + new Random().nextInt(3600000) + 1800000L;
      paramHandler.sendEmptyMessageDelayed(10500, l2 - l1);
      Object localObject1;
      if (QLog.isColorLevel())
      {
        paramHandler = b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("timeZone=");
        ((StringBuilder)localObject1).append(TimeZone.getDefault().getRawOffset());
        ((StringBuilder)localObject1).append(",nextTime=");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(",nowTime=");
        ((StringBuilder)localObject1).append(l1);
        QLog.d(paramHandler, 2, ((StringBuilder)localObject1).toString());
      }
      if ((MsfCore.sCore != null) && (MsfService.core.sender.b.l().c()))
      {
        a("SP_MSF_ALIVE_TODAY_ZERO_TIME", 0);
        if ((MsfSdkUtils.getLoginedAccountList() != null) && (MsfSdkUtils.getLoginedAccountList().size() > 0)) {
          paramHandler = MsfSdkUtils.getLoginedAccountList().iterator();
        }
        while (paramHandler.hasNext())
        {
          localObject1 = (SimpleAccount)paramHandler.next();
          boolean bool = ((SimpleAccount)localObject1).getUin().equals(MsfCore.sCore.getAccountCenter().i());
          Object localObject2;
          StringBuilder localStringBuilder;
          if (bool)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((SimpleAccount)localObject1).getUin());
            ((StringBuilder)localObject2).append("_Background");
            a(((StringBuilder)localObject2).toString(), 2);
            if (QLog.isColorLevel())
            {
              localObject2 = b;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("MAIN UIN=");
              localStringBuilder.append(((SimpleAccount)localObject1).getUin());
              localStringBuilder.append(" status=");
              localStringBuilder.append(((SimpleAccount)localObject1).isLogined());
              QLog.d((String)localObject2, 2, localStringBuilder.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject2 = b;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("UIN=");
            localStringBuilder.append(((SimpleAccount)localObject1).getUin());
            localStringBuilder.append(" status=");
            localStringBuilder.append(((SimpleAccount)localObject1).isLogined());
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
            continue;
            if (QLog.isColorLevel()) {
              QLog.d(b, 2, "no login account list");
            }
          }
        }
        a = false;
        return;
      }
      a = true;
      return;
    }
    catch (Exception paramHandler)
    {
      paramHandler.printStackTrace();
    }
  }
  
  private static void a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (!d.containsKey(paramString)) {
      if (paramInt != 0)
      {
        if ((paramInt != 1) && (paramInt == 2)) {
          d.put(paramString, Long.valueOf(a(paramString)));
        }
      }
      else {
        d.put(paramString, Long.valueOf(a()));
      }
    }
    if (l1 - ((Long)d.get(paramString)).longValue() < 86400000L) {
      return;
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l1 / 1000L * 1000L);
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    long l2 = ((Calendar)localObject).getTimeInMillis();
    d.put(paramString, Long.valueOf(l2));
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt == 2))
      {
        a(paramString, l2);
        a.a(MsfCore.sCore, "login", "msf", "login", "", 1, "");
      }
    }
    else
    {
      a(l2);
      a.a(MsfCore.sCore, "start_up", "backstage", "device_cnt", "", 1, "");
    }
    if (QLog.isColorLevel())
    {
      localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Daily Report info key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" timeMillisInTodayZero=");
      localStringBuilder.append(l2);
      localStringBuilder.append(" nowTime=");
      localStringBuilder.append(l1);
      localStringBuilder.append("sNeedReportMSFAlive=");
      localStringBuilder.append(a);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("sp_report_login", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_report_login_time_millis_today_zero_");
    localStringBuilder.append(paramString);
    localEditor.putLong(localStringBuilder.toString(), paramLong).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.l
 * JD-Core Version:    0.7.0.1
 */