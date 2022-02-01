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
  protected static ReportManager a;
  protected static final String a = "com.tencent.open.business.cgireport.ReportManager";
  protected int a;
  protected long a;
  protected ReportDataModal a;
  protected volatile ArrayList<reportItem> a;
  protected Random a;
  protected boolean a;
  protected volatile ArrayList<reportItem> b = new ArrayList();
  
  public ReportManager()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal = new ReportDataModal();
    this.jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static ReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager == null) {
        jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager = new ReportManager();
      }
      ReportManager localReportManager = jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager;
      return localReportManager;
    }
    finally {}
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 0)
    {
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_CGIReportFrequencySuccess");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("config 4:Common_CGIReportFrequencySuccess     config_value:");
      localStringBuilder.append(i);
      LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
      paramInt = i;
      if (i == 0) {
        paramInt = 10;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("config 4:Common_CGIReportFrequencySuccess     result_value:");
      localStringBuilder.append(paramInt);
      LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
      return paramInt;
    }
    int i = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_CGIReportFrequencyFailed");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 4:Common_CGIReportFrequencyFailed     config_value:");
    localStringBuilder.append(i);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    paramInt = i;
    if (i == 0) {
      paramInt = 100;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 4:Common_CGIReportFrequencyFailed     result_value:");
    localStringBuilder.append(paramInt);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    return paramInt;
  }
  
  protected Bundle a(String paramString, boolean paramBoolean)
  {
    try
    {
      LogUtility.b("cgi_report_debug", "ReportManager prepareData start");
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(paramString);
      this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.b(paramString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
      {
        LogUtility.b("cgi_report_debug", "ReportManager prepareData end  newItems == null");
        return null;
      }
      this.b = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.b(paramString);
      this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(paramString);
      Bundle localBundle = new Bundle();
      try
      {
        localBundle.putString("appid", paramString);
        localBundle.putString("releaseversion", ReportComm.jdField_a_of_type_JavaLangString);
        localBundle.putString("device", Build.DEVICE);
        localBundle.putString("qua", ReportComm.b);
        localBundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
        int i = 0;
        StringBuilder localStringBuilder;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_1");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_2");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_3");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_4");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_5");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).e);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_6");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_7");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).g);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_8");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).j);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_9");
          localBundle.putString(paramString.toString(), ((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).h);
          paramString = new StringBuilder();
          paramString.append(MobileInfoUtil.getDeviceinfoForCgiReport(paramBoolean));
          paramString.append("&");
          paramString.append(((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).i);
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("_10");
          localBundle.putString(localStringBuilder.toString(), paramString);
          i += 1;
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        while (i < this.b.size() + this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          int j = i - this.jdField_a_of_type_JavaUtilArrayList.size();
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_1");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).jdField_a_of_type_JavaLangString);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_2");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).b);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_3");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).c);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_4");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).d);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_5");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).e);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_6");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).f);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_7");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).g);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_8");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).j);
          paramString = new StringBuilder();
          paramString.append(i);
          paramString.append("_9");
          localBundle.putString(paramString.toString(), ((reportItem)this.b.get(j)).h);
          paramString = new StringBuilder();
          paramString.append(MobileInfoUtil.getDeviceinfoForCgiReport(paramBoolean));
          paramString.append("&");
          paramString.append(((reportItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).i);
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("_10");
          localBundle.putString(localStringBuilder.toString(), paramString);
          i += 1;
        }
        LogUtility.b("cgi_report_debug", "ReportManager prepareData end");
        return localBundle;
      }
      catch (Exception paramString)
      {
        LogUtility.a(jdField_a_of_type_JavaLangString, "prepareData>>>", paramString);
        return null;
      }
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  protected String a()
  {
    return AppNetConnInfo.getCurrentAPN();
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
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if ((a()) || (a(paramString2))) {
        a(paramString2, paramBoolean);
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    ThreadManager.executeOnNetWorkThread(new ReportManager.1(this, paramString1, paramBundle));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    LogUtility.b("cgi_report_debug", "ReportManager doUpload start");
    paramString = a(paramString, paramBoolean);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a("https://wspeed.qq.com/w.cgi", "POST", paramString);
  }
  
  protected boolean a()
  {
    long l2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportTimeinterval");
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
    long l3 = this.jdField_a_of_type_Long;
    if ((l3 != 0L) && (l3 + l1 > l2))
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForTime = false");
      return false;
    }
    this.jdField_a_of_type_Long = l2;
    LogUtility.b("cgi_report_debug", "ReportManager availableForTime = ture");
    return true;
  }
  
  protected boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < paramInt)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    int j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_CGIReportMaxcount");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 6:Common_CGIReportMaxcount     config_value:");
    localStringBuilder.append(j);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    int i = j;
    if (j == 0) {
      i = 20;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 6:Common_CGIReportMaxcount     result_value:");
    localStringBuilder.append(i);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(paramString) >= i)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForCount = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForCount = false");
    return false;
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
    int j = a(paramInt);
    int i = 100;
    j = 100 / j;
    if (j <= 0) {
      i = 1;
    } else if (j <= 100) {
      i = j;
    }
    localObject1 = a();
    ReportDataModal localReportDataModal = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.cgireport.ReportManager
 * JD-Core Version:    0.7.0.1
 */