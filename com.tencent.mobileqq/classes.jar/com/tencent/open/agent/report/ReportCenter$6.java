package com.tencent.open.agent.report;

import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;

class ReportCenter$6
  implements Runnable
{
  ReportCenter$6(ReportCenter paramReportCenter, Bundle paramBundle, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    int i;
    int k;
    int m;
    int n;
    label392:
    try
    {
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->httpRequest, params is null!");
        }
      }
      else
      {
        i = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_HttpRetryCount");
        k = i;
        if (i == 0) {
          k = 3;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("-->httpRequest, retryCount: ");
          ((StringBuilder)localObject1).append(k);
          QLog.d("ReportCenter", 2, ((StringBuilder)localObject1).toString());
        }
        m = 0;
        i = 0;
        n = m + 1;
      }
    }
    catch (Exception localException3)
    {
      Object localObject1;
      HttpClient localHttpClient;
      Object localObject2;
      label346:
      label369:
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->httpRequest, exception in serial executor.", localException3);
      }
    }
    try
    {
      try
      {
        localHttpClient = HttpBaseUtil.a(null, this.jdField_a_of_type_JavaLangString);
        localObject2 = HttpBaseUtil.a(this.jdField_a_of_type_AndroidOsBundle);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Boolean) {
          localObject1 = URLEncoder.encode((String)localObject2);
        }
        localObject2 = new StringBuffer(this.jdField_a_of_type_JavaLangString);
        ((StringBuffer)localObject2).append((String)localObject1);
        localObject1 = new HttpGet(((StringBuffer)localObject2).toString());
        ((HttpUriRequest)localObject1).addHeader("Accept-Encoding", "gzip");
        ((HttpUriRequest)localObject1).addHeader("Content-Type", "application/x-www-form-urlencoded");
        j = localHttpClient.execute((HttpUriRequest)localObject1).getStatusLine().getStatusCode();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("-->httpRequest, statusCode: ");
          ((StringBuilder)localObject1).append(j);
          QLog.d("ReportCenter", 2, ((StringBuilder)localObject1).toString());
        }
        if (j != 200)
        {
          j = i;
          if (!QLog.isColorLevel()) {
            break label392;
          }
          QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest : HttpStatuscode != 200");
          j = i;
          break label392;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Thread success");
          }
          j = 1;
        }
        catch (Exception localException1)
        {
          i = 1;
        }
        catch (SocketTimeoutException localSocketTimeoutException1)
        {
          i = 1;
          break label346;
        }
        catch (ConnectTimeoutException localConnectTimeoutException1)
        {
          i = 1;
          break label369;
        }
        QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Exception", localException2);
      }
      catch (Exception localException2)
      {
        j = i;
        if (!QLog.isColorLevel()) {
          break label392;
        }
      }
      j = i;
    }
    catch (SocketTimeoutException localSocketTimeoutException2)
    {
      break label346;
    }
    catch (ConnectTimeoutException localConnectTimeoutException2)
    {
      break label369;
      m = n;
      i = j;
    }
    int j = i;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest SocketTimeoutException", localException2);
      j = i;
      break label457;
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest ConnectTimeoutException", localException2);
        j = i;
      }
    }
    for (;;)
    {
      if (j == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Thread request success");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Thread request failed");
        return;
      }
      return;
      return;
      label457:
      if (n < k) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.6
 * JD-Core Version:    0.7.0.1
 */