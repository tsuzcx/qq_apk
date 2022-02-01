package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.aj;
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
    return BaseApplication.getContext().getSharedPreferences("sp_report_login", 4).getLong("key_report_login_time_millis_today_zero_" + paramString, 0L);
  }
  
  private static void a(long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("sp_boot_msf", 0).edit().putLong("SP_MSF_ALIVE_TODAY_ZERO_TIME", paramLong).apply();
  }
  
  public static void a(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      SimpleAccount localSimpleAccount;
      try
      {
        if (paramHandler.hasMessages(10500)) {
          paramHandler.removeMessages(10500);
        }
        long l1 = System.currentTimeMillis();
        long l2 = ((TimeZone.getDefault().getRawOffset() + l1) / 86400000L + 1L) * 86400000L - TimeZone.getDefault().getRawOffset() + new Random().nextInt(3600000) + 1800000L;
        paramHandler.sendEmptyMessageDelayed(10500, l2 - l1);
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "timeZone=" + TimeZone.getDefault().getRawOffset() + ",nextTime=" + l2 + ",nowTime=" + l1);
        }
        if ((MsfCore.sCore == null) || (!MsfService.core.sender.b.l().c())) {
          break label386;
        }
        a("SP_MSF_ALIVE_TODAY_ZERO_TIME", 0);
        if ((MsfSdkUtils.getLoginedAccountList() == null) || (MsfSdkUtils.getLoginedAccountList().size() <= 0)) {
          break;
        }
        paramHandler = MsfSdkUtils.getLoginedAccountList().iterator();
        if (!paramHandler.hasNext()) {
          break label381;
        }
        localSimpleAccount = (SimpleAccount)paramHandler.next();
        if (localSimpleAccount.getUin().equals(MsfCore.sCore.getAccountCenter().i()))
        {
          a(localSimpleAccount.getUin() + "_Background", 2);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(b, 2, "MAIN UIN=" + localSimpleAccount.getUin() + " status=" + localSimpleAccount.isLogined());
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (Exception paramHandler)
      {
        paramHandler.printStackTrace();
        return;
      }
      QLog.d(b, 2, "UIN=" + localSimpleAccount.getUin() + " status=" + localSimpleAccount.isLogined());
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "no login account list");
    }
    label381:
    a = false;
    return;
    label386:
    a = true;
  }
  
  private static void a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (!d.containsKey(paramString)) {}
    switch (paramInt)
    {
    case 1: 
    default: 
      if (l1 - ((Long)d.get(paramString)).longValue() >= 86400000L) {
        break;
      }
    }
    for (;;)
    {
      return;
      d.put(paramString, Long.valueOf(a()));
      break;
      d.put(paramString, Long.valueOf(a(paramString)));
      break;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l1 / 1000L * 1000L);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      long l2 = localCalendar.getTimeInMillis();
      d.put(paramString, Long.valueOf(l2));
      switch (paramInt)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.d(b, 2, "Daily Report info key=" + paramString + " timeMillisInTodayZero=" + l2 + " nowTime=" + l1 + "sNeedReportMSFAlive=" + a);
        return;
        a(l2);
        a.a(MsfCore.sCore, "start_up", "backstage", "device_cnt", "", 1, "");
        continue;
        a(paramString, l2);
        a.a(MsfCore.sCore, "login", "msf", "login", "", 1, "");
      }
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("sp_report_login", 4).edit().putLong("key_report_login_time_millis_today_zero_" + paramString, paramLong).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.l
 * JD-Core Version:    0.7.0.1
 */