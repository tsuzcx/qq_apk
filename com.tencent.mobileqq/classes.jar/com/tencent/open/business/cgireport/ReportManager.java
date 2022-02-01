package com.tencent.open.business.cgireport;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import java.util.ArrayList;
import java.util.Random;

public class ReportManager
{
  protected static final String a = "com.tencent.open.business.cgireport.ReportManager";
  protected static ReportManager b;
  protected long c = 0L;
  protected int d = 3;
  protected boolean e = false;
  protected Random f = new Random();
  protected ReportDataModal g = new ReportDataModal();
  protected volatile ArrayList<reportItem> h = new ArrayList();
  protected volatile ArrayList<reportItem> i = new ArrayList();
  
  public static ReportManager a()
  {
    try
    {
      if (b == null) {
        b = new ReportManager();
      }
      ReportManager localReportManager = b;
      return localReportManager;
    }
    finally {}
  }
  
  protected Bundle a(String paramString, boolean paramBoolean)
  {
    try
    {
      LogUtility.b("cgi_report_debug", "ReportManager prepareData start");
      this.h = this.g.c(paramString);
      this.g.b(paramString);
      if (this.h.size() <= 0)
      {
        LogUtility.b("cgi_report_debug", "ReportManager prepareData end  newItems == null");
        return null;
      }
      this.i = this.g.d(paramString);
      this.g.a(paramString);
      Bundle localBundle = new Bundle();
      try
      {
        localBundle.putString("appid", paramString);
        localBundle.putString("releaseversion", ReportComm.a);
        localBundle.putString("device", Build.DEVICE);
        localBundle.putString("qua", ReportComm.b);
        localBundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
        int j = 0;
        StringBuilder localStringBuilder;
        while (j < this.h.size())
        {
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_1");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).a);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_2");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).b);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_3");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).c);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_4");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).d);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_5");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).e);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_6");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).f);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_7");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).g);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_8");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).j);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_9");
          localBundle.putString(paramString.toString(), ((reportItem)this.h.get(j)).h);
          paramString = new StringBuilder();
          paramString.append(MobileInfoUtil.getDeviceinfoForCgiReport(paramBoolean));
          paramString.append("&");
          paramString.append(((reportItem)this.h.get(j)).i);
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(j);
          localStringBuilder.append("_10");
          localBundle.putString(localStringBuilder.toString(), paramString);
          j += 1;
        }
        j = this.h.size();
        while (j < this.i.size() + this.h.size())
        {
          int k = j - this.h.size();
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_1");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).a);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_2");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).b);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_3");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).c);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_4");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).d);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_5");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).e);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_6");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).f);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_7");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).g);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_8");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).j);
          paramString = new StringBuilder();
          paramString.append(j);
          paramString.append("_9");
          localBundle.putString(paramString.toString(), ((reportItem)this.i.get(k)).h);
          paramString = new StringBuilder();
          paramString.append(MobileInfoUtil.getDeviceinfoForCgiReport(paramBoolean));
          paramString.append("&");
          paramString.append(((reportItem)this.h.get(k)).i);
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(j);
          localStringBuilder.append("_10");
          localBundle.putString(localStringBuilder.toString(), paramString);
          j += 1;
        }
        LogUtility.b("cgi_report_debug", "ReportManager prepareData end");
        return localBundle;
      }
      catch (Exception paramString)
      {
        LogUtility.a(a, "prepareData>>>", paramString);
        return null;
      }
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    a(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3, false);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      b(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3);
      if (this.e) {
        return;
      }
      if ((c()) || (a(paramString2))) {
        b(paramString2, paramBoolean);
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    ThreadManager.executeOnNetWorkThread(new ReportManager.1(this, paramString1, paramBundle));
  }
  
  protected boolean a(int paramInt)
  {
    paramInt = b(paramInt);
    if (this.f.nextInt(100) < paramInt)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    int k = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_CGIReportMaxcount");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 6:Common_CGIReportMaxcount     config_value:");
    localStringBuilder.append(k);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    int j = k;
    if (k == 0) {
      j = 20;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 6:Common_CGIReportMaxcount     result_value:");
    localStringBuilder.append(j);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    if (this.g.e(paramString) >= j)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForCount = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForCount = false");
    return false;
  }
  
  protected int b(int paramInt)
  {
    if (paramInt == 0)
    {
      j = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_CGIReportFrequencySuccess");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("config 4:Common_CGIReportFrequencySuccess     config_value:");
      localStringBuilder.append(j);
      LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
      paramInt = j;
      if (j == 0) {
        paramInt = 10;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("config 4:Common_CGIReportFrequencySuccess     result_value:");
      localStringBuilder.append(paramInt);
      LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
      return paramInt;
    }
    int j = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_CGIReportFrequencyFailed");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 4:Common_CGIReportFrequencyFailed     config_value:");
    localStringBuilder.append(j);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    paramInt = j;
    if (j == 0) {
      paramInt = 100;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 4:Common_CGIReportFrequencyFailed     result_value:");
    localStringBuilder.append(paramInt);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    return paramInt;
  }
  
  protected String b()
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  protected void b(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    paramLong1 = SystemClock.elapsedRealtime() - paramLong1;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ReportManager updateDB url=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(",resultCode=");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(",timeCost=");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(",reqSize=");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append(",rspSize=");
    ((StringBuilder)localObject1).append(paramLong3);
    LogUtility.b("cgi_report_debug", ((StringBuilder)localObject1).toString());
    int k = b(paramInt);
    int j = 100;
    k = 100 / k;
    if (k <= 0) {
      j = 1;
    } else if (k <= 100) {
      j = k;
    }
    localObject1 = b();
    ReportDataModal localReportDataModal = this.g;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramInt);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramLong1);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(paramLong2);
    ((StringBuilder)localObject5).append("");
    localObject5 = ((StringBuilder)localObject5).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append(paramLong3);
    ((StringBuilder)localObject6).append("");
    localObject6 = ((StringBuilder)localObject6).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong4);
    localStringBuilder.append("");
    localReportDataModal.a((String)localObject1, (String)localObject2, paramString1, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, localStringBuilder.toString(), paramString3, paramString2);
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    LogUtility.b("cgi_report_debug", "ReportManager doUpload start");
    paramString = a(paramString, paramBoolean);
    if (paramString == null) {
      return;
    }
    this.e = true;
    a("https://wspeed.qq.com/w.cgi", "POST", paramString);
  }
  
  protected boolean c()
  {
    long l2 = OpenConfig.a(CommonDataAdapter.a().b(), null).e("Common_CGIReportTimeinterval");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 5:Common_CGIReportTimeinterval     config_value:");
    localStringBuilder.append(l2);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1200L;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 5:Common_CGIReportTimeinterval     result_value:");
    localStringBuilder.append(l1);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    l2 = System.currentTimeMillis() / 1000L;
    long l3 = this.c;
    if ((l3 != 0L) && (l3 + l1 > l2))
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForTime = false");
      return false;
    }
    this.c = l2;
    LogUtility.b("cgi_report_debug", "ReportManager availableForTime = ture");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.cgireport.ReportManager
 * JD-Core Version:    0.7.0.1
 */