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
  public int a;
  public long a;
  public String a;
  public List<Long> a;
  public int b;
  public long b;
  
  SoCrashInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  SoCrashInfo(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangString = paramString;
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
      localSoCrashInfo.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("ver");
      localSoCrashInfo.jdField_a_of_type_Int = a(paramString.getQueryParameter("loadCTs"), 0);
      localSoCrashInfo.jdField_a_of_type_Long = a(paramString.getQueryParameter("lastLCT"), 0L);
      localSoCrashInfo.jdField_a_of_type_JavaUtilList = a(paramString.getQueryParameters("prc"));
      localSoCrashInfo.jdField_b_of_type_Long = a(paramString.getQueryParameter("runCPT"), 0L);
      localSoCrashInfo.jdField_b_of_type_Int = a(paramString.getQueryParameter("runCTs"), 0);
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
      localSoCrashInfo1.jdField_b_of_type_Int += 1;
      if (localSoCrashInfo1.jdField_b_of_type_Int >= 999) {
        localSoCrashInfo1.jdField_b_of_type_Int = 0;
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      localSoCrashInfo1.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
      if (localSoCrashInfo1.jdField_a_of_type_JavaUtilList.size() >= 3) {
        if (Math.abs(l - ((Long)localSoCrashInfo1.jdField_a_of_type_JavaUtilList.get(0)).longValue()) <= 1800000L) {
          localSoCrashInfo1.jdField_b_of_type_Long = l;
        } else {
          while (localSoCrashInfo1.jdField_a_of_type_JavaUtilList.size() >= 3) {
            localSoCrashInfo1.jdField_a_of_type_JavaUtilList.remove(0);
          }
        }
      }
      SoLoadUtils.a(localSoCrashInfo1, paramString1);
      return;
    }
    if (paramInt == 0)
    {
      localSoCrashInfo1.jdField_a_of_type_Int += 1;
      paramInt = localSoCrashInfo1.jdField_a_of_type_Int;
      if (paramInt > 2)
      {
        SoConfigManager.a().a(paramString1, paramString2);
        SoLoadUtils.b(paramString1);
        SoLoadUtils.a(paramString1);
        return;
      }
      if (paramInt == 1) {
        localSoCrashInfo1.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      }
      SoLoadUtils.a(localSoCrashInfo1, paramString1);
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?");
    localStringBuilder.append("ver=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&loadCTs=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("&lastLCT=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("&runCTs=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("&runCPT=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      localStringBuilder.append("&prc=");
      localStringBuilder.append(l);
    }
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Long > 0L;
  }
  
  public boolean b()
  {
    return (a()) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_Long) <= 7200000L);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int >= 2) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) < 21600000L);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int >= 2) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) >= 21600000L);
  }
  
  public boolean e()
  {
    int i = this.jdField_b_of_type_Int;
    return (i > 0) && (i % 3 == 0);
  }
  
  public boolean f()
  {
    if (d()) {
      return true;
    }
    if (!a()) {
      return e();
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SoCrashInfo{mSoVer='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLoadCrashTimes=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mFirstLoadCrashTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mRunCrashProtectTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", mPreRunCrashTimes=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", mRunCrashTimes=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.entity.SoCrashInfo
 * JD-Core Version:    0.7.0.1
 */