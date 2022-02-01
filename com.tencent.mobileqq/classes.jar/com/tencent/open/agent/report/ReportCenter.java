package com.tencent.open.agent.report;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportComm;
import com.tencent.open.business.viareport.ReportConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportCenter
{
  protected static ReportCenter a;
  protected Handler a;
  protected ArrayList<Serializable> a;
  protected Random a;
  protected Executor a;
  protected ArrayList<Serializable> b;
  protected Executor b;
  protected Executor c = ThreadManager.newSerialExecutor();
  
  protected ReportCenter()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ReportCenter.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newSerialExecutor();
    this.jdField_b_of_type_JavaUtilConcurrentExecutor = ThreadManager.newSerialExecutor();
  }
  
  public static ReportCenter a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentReportReportCenter == null) {
        jdField_a_of_type_ComTencentOpenAgentReportReportCenter = new ReportCenter();
      }
      ReportCenter localReportCenter = jdField_a_of_type_ComTencentOpenAgentReportReportCenter;
      return localReportCenter;
    }
    finally {}
  }
  
  protected int a(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_CGIReportFrequencySuccess");
      paramInt = i;
      if (i == 0) {
        return 10;
      }
    }
    else
    {
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_CGIReportFrequencyFailed");
      paramInt = i;
      if (i == 0) {
        paramInt = 100;
      }
    }
    return paramInt;
  }
  
  protected Bundle a()
  {
    localObject1 = ReportDatabaseHelper.a().a("report_cgi");
    if (localObject1 != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("-->prepareCgiData, itemList size: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("ReportCenter", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return null;
    }
    localObject1 = new Bundle();
    try
    {
      ((Bundle)localObject1).putString("releaseversion", CommonDataAdapter.a().f());
      ((Bundle)localObject1).putString("device", Build.DEVICE);
      ((Bundle)localObject1).putString("qua", ReportComm.b);
      ((Bundle)localObject1).putString("key", "appid,apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject2 = (BaseData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_1");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("appid"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_2");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("apn"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_3");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("frequency"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_4");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("commandid"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_5");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("resultCode"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_6");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("timeCost"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_7");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("reqSize"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_8");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("rspSize"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_9");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("detail"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_10");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)((BaseData)localObject2).attrs.get("uin"));
        boolean bool = Boolean.toString(true).equals(((BaseData)localObject2).attrs.get("from_opensdk"));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(MobileInfoUtil.getDeviceinfoForCgiReport(bool));
        localStringBuilder2.append("&");
        localStringBuilder2.append((String)((BaseData)localObject2).attrs.get("deviceInfo"));
        localObject2 = localStringBuilder2.toString();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(i);
        localStringBuilder2.append("_11");
        ((Bundle)localObject1).putString(localStringBuilder2.toString(), (String)localObject2);
        i += 1;
      }
      StringBuilder localStringBuilder1;
      return localObject1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReportCenter", 2, "-->prepareCgiData, exception.", localException);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("-->prepareCgiData, end. params: ");
        localStringBuilder1.append(((Bundle)localObject1).toString());
        QLog.d("ReportCenter", 2, localStringBuilder1.toString());
      }
    }
  }
  
  public void a(Bundle paramBundle, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramBundle, paramString1, paramString2, paramBoolean, false);
  }
  
  public void a(Bundle paramBundle, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBundle == null) {
      return;
    }
    try
    {
      CommonDataAdapter.a().a(Long.valueOf(paramString2).longValue());
    }
    catch (Exception localException)
    {
      label21:
      StringBuilder localStringBuilder;
      break label21;
    }
    CommonDataAdapter.a().a(0L);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->reportVia, bundle: ");
      localStringBuilder.append(paramBundle.toString());
      QLog.d("ReportCenter", 2, localStringBuilder.toString());
    }
    if ((!a("report_via", paramString1)) && (!paramBoolean1)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentExecutor.execute(new ReportCenter.2(this, paramString2, paramBoolean2, paramBundle, paramBoolean1));
  }
  
  protected void a(String paramString)
  {
    this.c.execute(new ReportCenter.4(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->reportCgi, command: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" | responseCode: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" | uin: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" | detail: ");
      localStringBuilder.append(paramString3);
      QLog.d("ReportCenter", 2, localStringBuilder.toString());
    }
    this.c.execute(new ReportCenter.7(this, paramInt3, paramString1, paramString3, paramInt1, paramInt2, paramString2, paramBoolean));
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3, paramBoolean, false);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->reportCgi, command: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" | startTime: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" | reqSize:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" | rspSize: ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(" | responseCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" | uin: ");
      localStringBuilder.append(paramLong4);
      localStringBuilder.append(" | appid: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" | detail: ");
      localStringBuilder.append(paramString3);
      QLog.d("ReportCenter", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    if ((!a("report_cgi", localStringBuilder.toString())) && (!paramBoolean1)) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.c.execute(new ReportCenter.3(this, paramString2, paramString1, paramString3, paramInt, paramLong2, paramLong3, l - paramLong1, paramLong4, paramBoolean2, paramBoolean1));
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new ReportCenter.6(this, paramBundle, paramString1, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramBoolean, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      a(AuthorityUtil.a(paramString1, paramString2, paramString4, paramString5, paramString3, paramString6, paramString7, "", "", paramString8, paramString9), paramString3, paramString1, paramBoolean1, paramBoolean2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->reportVia 2 exception", paramString1);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramBoolean, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      a(AuthorityUtil.a(paramString1, paramString2, paramString4, paramString5, paramString3, paramString6, paramString5, "", "", "", ""), paramString3, paramString1, paramBoolean1, paramBoolean2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->reportVia 1 exception", paramString1);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilConcurrentExecutor.execute(new ReportCenter.5(this, paramBoolean));
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    int j;
    int i;
    if (paramString.equals("report_cgi"))
    {
      j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_CGIReportMaxcount");
      i = j;
      if (j != 0) {}
    }
    else
    {
      for (;;)
      {
        i = 5;
        break label81;
        if (!paramString.equals("report_via")) {
          break;
        }
        j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Agent_ReportBatchCount");
        i = j;
        if (j != 0) {
          break label81;
        }
      }
      i = 0;
    }
    label81:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->availableCount, report: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | dataSize: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" | maxcount: ");
      localStringBuilder.append(i);
      QLog.d("ReportCenter", 2, localStringBuilder.toString());
    }
    return paramInt >= i;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->availableFrequency, report: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" | ext: ");
      localStringBuilder.append(paramString2);
      QLog.d("ReportCenter", 2, localStringBuilder.toString());
    }
    boolean bool2 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramString1.equals("report_cgi")) {}
    try
    {
      int i = Integer.parseInt(paramString2);
      int j = a(i);
      i = j;
      if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < j)
      {
        i = j;
        if (paramString1.equals("report_via"))
        {
          j = ReportConfig.a(paramString2);
          i = j;
          if (new Random().nextInt(100) < j)
          {
            i = j;
            bool1 = true;
          }
        }
        else
        {
          i = 100;
        }
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("-->availableFrequency, result: ");
        paramString1.append(bool1);
        paramString1.append(" | frequency: ");
        paramString1.append(i);
        QLog.d("ReportCenter", 2, paramString1.toString());
      }
      return bool1;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  protected Bundle b()
  {
    try
    {
      Object localObject1 = ReportDatabaseHelper.a().a("report_via");
      if (localObject1 != null) {
        this.jdField_b_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("-->prepareViaData, itemList size: ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaUtilArrayList.size());
        QLog.d("ReportCenter", 2, ((StringBuilder)localObject1).toString());
      }
      int i = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (i == 0) {
        return null;
      }
      localObject1 = new JSONArray();
      Object localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (Serializable)((Iterator)localObject3).next();
        localJSONObject = new JSONObject();
        localObject4 = (BaseData)localObject4;
        Iterator localIterator = ((BaseData)localObject4).attrs.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            localJSONObject.put(str, ((BaseData)localObject4).attrs.get(str));
          }
          catch (JSONException localJSONException2) {}
          if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", localJSONException2);
          }
        }
        ((JSONArray)localObject1).put(localJSONObject);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("-->prepareViaData, JSONArray array: ");
        ((StringBuilder)localObject3).append(((JSONArray)localObject1).toString());
        QLog.d("ReportCenter", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("data", localObject1);
        ((Bundle)localObject3).putString("data", localJSONObject.toString());
        return localObject3;
      }
      catch (JSONException localJSONException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", localJSONException1);
        }
        return localObject3;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter
 * JD-Core Version:    0.7.0.1
 */