package com.tencent.mobileqq.soload.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.config.SoConfigManager;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoCrashInfo
{
  public String a;
  public int b;
  public long c;
  public List<Long> d = new LinkedList();
  public long e;
  public int f;
  
  SoCrashInfo() {}
  
  SoCrashInfo(String paramString)
  {
    this.a = paramString;
  }
  
  private static int a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return paramInt;
    return paramInt;
  }
  
  private static long a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString) {}
    return paramLong;
    return paramLong;
  }
  
  public static SoCrashInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      SoCrashInfo localSoCrashInfo = new SoCrashInfo();
      paramString = Uri.parse(paramString);
      localSoCrashInfo.a = paramString.getQueryParameter("ver");
      localSoCrashInfo.b = a(paramString.getQueryParameter("loadCTs"), 0);
      localSoCrashInfo.c = a(paramString.getQueryParameter("lastLCT"), 0L);
      localSoCrashInfo.d = a(paramString.getQueryParameters("prc"));
      localSoCrashInfo.e = a(paramString.getQueryParameter("runCPT"), 0L);
      localSoCrashInfo.f = a(paramString.getQueryParameter("runCTs"), 0);
      return localSoCrashInfo;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoCrashInfo", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private static List<Long> a(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        long l = a((String)paramList.next(), 0L);
        if (l > 0L) {
          localLinkedList.add(Long.valueOf(l));
        }
      }
    }
    if (localLinkedList.size() > 1) {
      Collections.sort(localLinkedList);
    }
    return localLinkedList;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    SoCrashInfo localSoCrashInfo2 = SoLoadUtils.a(paramString1, paramString2);
    SoCrashInfo localSoCrashInfo1 = localSoCrashInfo2;
    if (localSoCrashInfo2 == null) {
      localSoCrashInfo1 = new SoCrashInfo(paramString2);
    }
    if (paramInt == 1)
    {
      localSoCrashInfo1.f += 1;
      if (localSoCrashInfo1.f >= 999) {
        localSoCrashInfo1.f = 0;
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      localSoCrashInfo1.d.add(Long.valueOf(l));
      if (localSoCrashInfo1.d.size() >= 3) {
        if (Math.abs(l - ((Long)localSoCrashInfo1.d.get(0)).longValue()) <= 1800000L) {
          localSoCrashInfo1.e = l;
        } else {
          while (localSoCrashInfo1.d.size() >= 3) {
            localSoCrashInfo1.d.remove(0);
          }
        }
      }
      SoLoadUtils.a(localSoCrashInfo1, paramString1);
      return;
    }
    if (paramInt == 0)
    {
      localSoCrashInfo1.b += 1;
      paramInt = localSoCrashInfo1.b;
      if (paramInt > 2)
      {
        SoConfigManager.a().a(paramString1, paramString2);
        SoLoadUtils.e(paramString1);
        SoLoadUtils.c(paramString1);
        return;
      }
      if (paramInt == 1) {
        localSoCrashInfo1.c = NetConnInfoCenter.getServerTimeMillis();
      }
      SoLoadUtils.a(localSoCrashInfo1, paramString1);
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?");
    localStringBuilder.append("ver=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("&loadCTs=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("&lastLCT=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("&runCTs=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("&runCPT=");
    localStringBuilder.append(this.e);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      localStringBuilder.append("&prc=");
      localStringBuilder.append(l);
    }
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    return this.e > 0L;
  }
  
  public boolean c()
  {
    return (b()) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.e) <= 7200000L);
  }
  
  public boolean d()
  {
    return (this.b >= 2) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.c) < 21600000L);
  }
  
  public boolean e()
  {
    return (this.b >= 2) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.c) >= 21600000L);
  }
  
  public boolean f()
  {
    int i = this.f;
    return (i > 0) && (i % 3 == 0);
  }
  
  public boolean g()
  {
    if (e()) {
      return true;
    }
    if (!b()) {
      return f();
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SoCrashInfo{mSoVer='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLoadCrashTimes=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mFirstLoadCrashTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mRunCrashProtectTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mPreRunCrashTimes=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mRunCrashTimes=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.entity.SoCrashInfo
 * JD-Core Version:    0.7.0.1
 */