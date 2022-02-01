package com.tencent.open.business.viareport;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.MobileInfoUtil;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TimeZone;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportManager
{
  protected static ReportManager a;
  protected String b = "";
  protected ArrayList<BatchReportInfo> c = new ArrayList();
  protected ArrayList<BatchReportInfo> d = new ArrayList();
  protected volatile boolean e = false;
  
  public static ReportManager a()
  {
    try
    {
      if (a == null) {
        a = new ReportManager();
      }
      ReportManager localReportManager = a;
      return localReportManager;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    i10 = ReportConfig.f();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("<Viareport> doUploadItems requestRetryCount=");
    ((StringBuilder)localObject1).append(i10);
    LogUtility.b("viareport", ((StringBuilder)localObject1).toString());
    long l2 = SystemClock.elapsedRealtime();
    i = 0;
    int k = 0;
    int i11 = 0;
    long l1 = 0L;
    label208:
    long l3;
    for (long l4 = 0L;; l4 = l3)
    {
      int m = i + 1;
      int i4 = k;
      int i6 = m;
      int n = k;
      int i5 = m;
      int i3 = k;
      int i9 = m;
      int i1 = k;
      int i7 = m;
      int i2 = k;
      int i8 = m;
      try
      {
        try
        {
          localObject1 = HttpBaseUtil.a(paramString1, paramString2, paramBundle);
          i4 = k;
          i6 = m;
          n = k;
          i5 = m;
          i3 = k;
          i9 = m;
          i1 = k;
          i7 = m;
          i2 = k;
          i8 = m;
          localObject2 = HttpBaseUtil.a(((HttpBaseUtil.Statistic)localObject1).a);
          i4 = k;
          i6 = m;
          n = k;
          i5 = m;
          i1 = k;
          i7 = m;
          i2 = k;
          i8 = m;
        }
        catch (Exception localException2)
        {
          k = i4;
          if ((localException2 instanceof HttpBaseUtil.NetworkUnavailableException))
          {
            paramString1 = new StringBuilder();
            paramString1.append("<Viareport> doUploadItems error : ");
            paramString1.append(localException2.toString());
            LogUtility.e("viareport", paramString1.toString());
            this.e = false;
            return;
          }
          if ((localException2 instanceof HttpBaseUtil.HttpStatusException)) {}
          try
          {
            i = Integer.parseInt(localException2.getMessage().replace("http status code error:", ""));
            if (!a(i)) {
              break label561;
            }
            com.tencent.open.business.cgireport.ReportManager.a().a("mapp_apptrace", l2, l1, l4, i, CommonDataAdapter.a().c(), "1000002", null, paramBoolean2);
          }
          catch (Exception paramString1)
          {
            break label527;
          }
          paramString1 = new StringBuilder();
          paramString1.append("<Viareport> doUploadItems error : ");
          paramString1.append(localException2.toString());
          LogUtility.e("viareport", paramString1.toString());
          paramString1 = new StringBuilder();
          paramString1.append("<Viareport> doUploadItems error : ");
          paramString1.append(localException2.toString());
          LogUtility.e("viareport", paramString1.toString());
          this.e = false;
          return;
          if ((localException2 instanceof IOException))
          {
            i = HttpCgiAsyncTask.a((IOException)localException2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<Viareport> doUploadItems error : ");
            ((StringBuilder)localObject2).append(localException2.toString());
            LogUtility.e("viareport", ((StringBuilder)localObject2).toString());
            j = k;
            k = i;
            i5 = i6;
          }
          else
          {
            m = -6;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<Viareport> doUploadItems error : ");
            ((StringBuilder)localObject2).append(localException2.toString());
            LogUtility.e("viareport", ((StringBuilder)localObject2).toString());
            i = i10;
            j = k;
            k = m;
            l1 = l2;
          }
        }
        catch (IOException localIOException)
        {
          k = HttpCgiAsyncTask.a(localIOException);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<Viareport> doUploadItems error : ");
          ((StringBuilder)localObject2).append(localIOException.toString());
          LogUtility.e("viareport", ((StringBuilder)localObject2).toString());
          j = n;
          i = i5;
          l1 = l2;
        }
        catch (HttpBaseUtil.HttpStatusException paramString1) {}
      }
      catch (HttpBaseUtil.NetworkUnavailableException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("<Viareport> doUploadItems error : ");
        paramString2.append(paramString1.toString());
        LogUtility.e("viareport", paramString2.toString());
        this.e = false;
        return;
      }
      catch (JSONException localJSONException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<Viareport> doUploadItems error : ");
        ((StringBuilder)localObject2).append(localJSONException1.toString());
        LogUtility.e("viareport", ((StringBuilder)localObject2).toString());
        i = i9;
        k = -4;
        j = i3;
        l1 = l2;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        l1 = SystemClock.elapsedRealtime();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<Viareport> doUploadItems error : ");
        ((StringBuilder)localObject2).append(localSocketTimeoutException.toString());
        LogUtility.e("viareport", ((StringBuilder)localObject2).toString());
        i = i7;
        k = -8;
        j = i1;
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        l1 = SystemClock.elapsedRealtime();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<Viareport> doUploadItems error : ");
        ((StringBuilder)localObject2).append(localConnectTimeoutException.toString());
        LogUtility.e("viareport", ((StringBuilder)localObject2).toString());
        i = i8;
        k = -7;
        j = i2;
      }
      try
      {
        i = ((JSONObject)localObject2).getInt("ret");
      }
      catch (JSONException localJSONException2)
      {
        break label208;
        j = i10;
        i = 1;
        break label279;
      }
      i = -4;
      if (i == 0) {
        break label1384;
      }
      i = k;
      j = m;
      i4 = k;
      i6 = m;
      n = k;
      i5 = m;
      i3 = k;
      i9 = m;
      i1 = k;
      i7 = m;
      i2 = k;
      i8 = m;
      if (!TextUtils.isEmpty(((HttpBaseUtil.Statistic)localObject1).a)) {
        break label1384;
      }
      label279:
      i4 = i;
      i6 = j;
      n = i;
      i5 = j;
      i3 = i;
      i9 = j;
      i1 = i;
      i7 = j;
      i2 = i;
      i8 = j;
      l3 = ((HttpBaseUtil.Statistic)localObject1).b;
      n = i;
      i5 = j;
      i3 = i;
      i9 = j;
      i1 = i;
      i7 = j;
      i2 = i;
      i8 = j;
      try
      {
        long l5 = ((HttpBaseUtil.Statistic)localObject1).c;
        k = j;
        j = i;
        l1 = l3;
        l3 = l5;
      }
      catch (Exception localException1)
      {
        k = i;
        l1 = l3;
        i6 = j;
      }
      catch (HttpBaseUtil.HttpStatusException paramString1)
      {
        l1 = l3;
      }
      try
      {
        label527:
        label561:
        i = Integer.parseInt(paramString1.getMessage().replace("http status code error:", ""));
        if (!a(i)) {
          break label884;
        }
        com.tencent.open.business.cgireport.ReportManager.a().a("mapp_apptrace", l2, l1, l4, i, CommonDataAdapter.a().c(), "1000002", null, paramBoolean2);
      }
      catch (Exception paramString2)
      {
        label851:
        break label851;
      }
      paramString2 = new StringBuilder();
      paramString2.append("<Viareport> doUploadItems error : ");
      paramString2.append(paramString1.toString());
      LogUtility.e("viareport", paramString2.toString());
      label884:
      paramString2 = new StringBuilder();
      paramString2.append("<Viareport> doUploadItems error : ");
      paramString2.append(paramString1.toString());
      LogUtility.e("viareport", paramString2.toString());
      this.e = false;
      return;
      l4 = 0L;
      l3 = 0L;
      l2 = l1;
      l1 = l4;
      i11 = k;
      k = i;
      if (k >= i10)
      {
        paramString1 = new StringBuilder();
        paramString1.append("mapp_apptrace | ");
        paramString1.append(l2);
        paramString1.append(" | ");
        paramString1.append(l1);
        paramString1.append(" | ");
        paramString1.append(l3);
        paramString1.append(" | ");
        paramString1.append(i11);
        LogUtility.c("viareport", paramString1.toString());
        if (a(i11)) {
          com.tencent.open.business.cgireport.ReportManager.a().a("mapp_apptrace", l2, l1, l3, i11, CommonDataAdapter.a().c(), "1000002", null, paramBoolean2);
        }
        if (j == 1)
        {
          LogUtility.b("business_report_debug", "ReportManager doUploadItems Thread request success");
        }
        else
        {
          LogUtility.b("business_report_debug", "ReportManager doUploadItems Thread request failed");
          if (paramBoolean1)
          {
            ReportDbHelper.a().a(this.d);
            ReportDbHelper.a().a(this.c);
          }
        }
        if (paramBoolean1)
        {
          LogUtility.b("viareport", " set isUploading = false");
          this.e = false;
          if (j != 0) {
            a(paramBoolean2);
          }
        }
        return;
      }
      i = k;
      k = j;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    String str = String.valueOf(CommonDataAdapter.a().c());
    if (a(str)) {
      ThreadManager.executeOnNetWorkThread(new ReportManager.2(this, str, paramBoolean));
    }
  }
  
  protected String a(ArrayList<BatchReportInfo> paramArrayList1, ArrayList<BatchReportInfo> paramArrayList2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        localObject = (BatchReportInfo)paramArrayList1.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((BatchReportInfo)localObject).a);
        localStringBuilder2.append("_");
        localStringBuilder2.append(((BatchReportInfo)localObject).b);
        localStringBuilder2.append("_");
        localStringBuilder2.append(((BatchReportInfo)localObject).c);
        localStringBuilder2.append("_");
        localStringBuilder2.append(((BatchReportInfo)localObject).a());
        localStringBuilder2.append("_");
        localStringBuilder2.append(((BatchReportInfo)localObject).g);
        localStringBuilder1.append(localStringBuilder2.toString());
        if (!TextUtils.isEmpty(((BatchReportInfo)localObject).h))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("_");
          localStringBuilder2.append(((BatchReportInfo)localObject).h);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        if (!TextUtils.isEmpty(((BatchReportInfo)localObject).i))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("_");
          localStringBuilder2.append(((BatchReportInfo)localObject).i);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        if (!TextUtils.isEmpty(((BatchReportInfo)localObject).j))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("_");
          localStringBuilder2.append(((BatchReportInfo)localObject).j);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        if (!TextUtils.isEmpty(((BatchReportInfo)localObject).k))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("_");
          localStringBuilder2.append(((BatchReportInfo)localObject).k);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        if (!TextUtils.isEmpty(((BatchReportInfo)localObject).l))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("_");
          localStringBuilder2.append(((BatchReportInfo)localObject).l);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        localStringBuilder1.append(",");
      }
    }
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (BatchReportInfo)paramArrayList1.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramArrayList2.a);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramArrayList2.b);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramArrayList2.c);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramArrayList2.a());
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramArrayList2.g);
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        if (!TextUtils.isEmpty(paramArrayList2.h))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramArrayList2.h);
          localStringBuilder1.append(((StringBuilder)localObject).toString());
        }
        if (!TextUtils.isEmpty(paramArrayList2.i))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramArrayList2.i);
          localStringBuilder1.append(((StringBuilder)localObject).toString());
        }
        if (!TextUtils.isEmpty(paramArrayList2.j))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramArrayList2.j);
          localStringBuilder1.append(((StringBuilder)localObject).toString());
        }
        if (!TextUtils.isEmpty(paramArrayList2.k))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramArrayList2.k);
          localStringBuilder1.append(((StringBuilder)localObject).toString());
        }
        if (!TextUtils.isEmpty(paramArrayList2.l))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramArrayList2.l);
          localStringBuilder1.append(((StringBuilder)localObject).toString());
        }
        localStringBuilder1.append(",");
      }
    }
    paramArrayList2 = localStringBuilder1.toString();
    paramArrayList1 = paramArrayList2;
    if (paramArrayList2.endsWith(",")) {
      paramArrayList1 = paramArrayList2.substring(0, paramArrayList2.length() - 1);
    }
    return paramArrayList1;
  }
  
  protected void a(String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean1)
    {
      if (!a(paramString, localBundle))
      {
        LogUtility.b("viareport", "database empty");
        return;
      }
      this.e = true;
    }
    localBundle.putString("uin", paramString);
    localBundle.putString("platform", CommonDataAdapter.a().m());
    localBundle.putString("action", "100");
    String str = "";
    if (paramBoolean2) {
      paramString = "";
    } else {
      paramString = MobileInfoUtil.getImei();
    }
    localBundle.putString("imei", paramString);
    localBundle.putString("resolution", MobileInfoUtil.getResolution());
    localBundle.putString("network", APNUtil.a(CommonDataAdapter.a().b()));
    localBundle.putString("wifimac", MobileInfoUtil.getLocalMacAddress());
    localBundle.putString("mobile_pf", "1");
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("lang", MobileInfoUtil.getLanguage());
    localBundle.putString("device", Build.DEVICE);
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("sdk_ver", "1.5");
    localBundle.putString("timezone", TimeZone.getDefault().getID());
    localBundle.putString("city", MobileInfoUtil.getCity());
    if (paramBoolean2) {
      paramString = str;
    } else {
      paramString = MobileInfoUtil.getLocation();
    }
    localBundle.putString("longitude", paramString);
    localBundle.putString("ret_code", "0");
    localBundle.putString("qua", CommonDataAdapter.a().l());
    localBundle.putString("qz_ver", CommonDataAdapter.a().g());
    localBundle.putString("ext", CommonDataAdapter.a().n());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    if (paramBoolean1) {
      paramString = "POST";
    } else {
      paramString = "GET";
    }
    a(b(), paramString, localBundle, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.executeOnNetWorkThread(new ReportManager.1(this, paramBoolean1, paramBatchReportInfo, paramBundle, paramString, paramBoolean2));
  }
  
  protected boolean a(int paramInt)
  {
    try
    {
      paramInt = ReportConfig.a(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Via success ratio sampling frequency = ");
      localStringBuilder.append(paramInt);
      LogUtility.b("viareport", localStringBuilder.toString());
      if (new Random().nextInt(100) < paramInt)
      {
        LogUtility.b("report_debug", "ReportManager Via success ratio sampling frequency avaliable = ture");
        return true;
      }
      LogUtility.b("report_debug", "ReportManager Via success ratio sampling frequency avaliable = false");
      return false;
    }
    finally {}
  }
  
  protected boolean a(String paramString)
  {
    try
    {
      int i = ReportConfig.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("maxCount=");
      localStringBuilder.append(i);
      LogUtility.b("viareport", localStringBuilder.toString());
      if (ReportDbHelper.a().c(paramString) >= i)
      {
        LogUtility.b("business_report_debug", "ReportManager availableForCount = ture");
        return true;
      }
      LogUtility.b("business_report_debug", "ReportManager availableForCount = false");
      return false;
    }
    finally {}
  }
  
  protected boolean a(String paramString, Bundle paramBundle)
  {
    try
    {
      this.c = ReportDbHelper.a().a(paramString);
      ReportDbHelper.a().b("table_new_data", paramString);
      this.d = ReportDbHelper.a().b(paramString);
      ReportDbHelper.a().b("table_old_data", paramString);
      paramString = a(this.c, this.d);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>>batchInfo:");
      localStringBuilder.append(paramString);
      LogUtility.b("viareport", localStringBuilder.toString());
      paramBundle.putString("appid_via_act_net_time", paramString);
      boolean bool = TextUtils.isEmpty(paramString);
      return !bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected String b()
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = "https://analy.qq.com/cgi-bin/mapp_apptrace";
    }
    return this.b;
  }
  
  protected boolean b(String paramString)
  {
    try
    {
      int i = ReportConfig.b(paramString);
      paramString = new StringBuilder();
      paramString.append("frequency=");
      paramString.append(i);
      LogUtility.b("viareport", paramString.toString());
      if (new Random().nextInt(100) < i)
      {
        LogUtility.b("report_debug", "ReportManager availableForFrequency = ture");
        return true;
      }
      LogUtility.b("report_debug", "ReportManager availableForFrequency = false");
      return false;
    }
    finally {}
  }
  
  protected boolean c()
  {
    try
    {
      long l1 = ReportConfig.c();
      long l2 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lastReportTime=");
      localStringBuilder.append(l1);
      localStringBuilder.append(" currentTime=");
      localStringBuilder.append(l2);
      LogUtility.b("viareport", localStringBuilder.toString());
      long l3 = ReportConfig.e();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportTimeInterval=");
      localStringBuilder.append(l3);
      LogUtility.b("viareport", localStringBuilder.toString());
      if (l2 - l1 < l3 * 1000L)
      {
        LogUtility.b("business_report_debug", "ReportManager availableForTime = false");
        return false;
      }
      ReportConfig.a(l2);
      LogUtility.b("business_report_debug", "ReportManager availableForTime = ture");
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager
 * JD-Core Version:    0.7.0.1
 */