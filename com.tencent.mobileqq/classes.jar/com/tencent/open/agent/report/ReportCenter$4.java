package com.tencent.open.agent.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;

class ReportCenter$4
  implements Runnable
{
  ReportCenter$4(ReportCenter paramReportCenter, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      int m;
      try
      {
        try
        {
          Bundle localBundle = this.this$0.a();
          j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_HttpRetryCount");
          i = j;
          if (j == 0) {
            i = 3;
          }
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("-->doReportCgi, retryCount: ");
            ((StringBuilder)localObject2).append(i);
            QLog.d("ReportCenter", 2, ((StringBuilder)localObject2).toString());
          }
          k = 0;
          j = 0;
          m = j + 1;
          try
          {
            localObject2 = HttpBaseUtil.a(null, "https://wspeed.qq.com/w.cgi");
            HttpPost localHttpPost = new HttpPost("https://wspeed.qq.com/w.cgi");
            localHttpPost.addHeader("Accept-Encoding", "gzip");
            localHttpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            if ((!TextUtils.isEmpty(this.a)) && (localBundle != null)) {
              localBundle.putString("mType", this.a);
            }
            localHttpPost.setEntity(new ByteArrayEntity(HttpBaseUtil.a(localBundle).getBytes()));
            int n = ((HttpClient)localObject2).execute(localHttpPost).getStatusLine().getStatusCode();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("-->doReportCgi, statusCode: ");
              ((StringBuilder)localObject2).append(n);
              QLog.d("ReportCenter", 2, ((StringBuilder)localObject2).toString());
            }
            j = k;
            if (n != 200) {
              continue;
            }
            ReportDatabaseHelper.a().a("report_cgi");
            j = 1;
          }
          catch (Error localError)
          {
            QLog.d("ReportCenter", 1, "-->doReportCgi, doupload exception", localError);
            break label414;
          }
          catch (Exception localException1)
          {
            j = k;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReportCenter", 2, "-->doReportCgi, doupload exception", localException1);
            j = k;
          }
          catch (SocketTimeoutException localSocketTimeoutException)
          {
            if (!QLog.isColorLevel()) {
              break label414;
            }
            QLog.d("ReportCenter", 2, "-->doReportCgi, doupload exception", localSocketTimeoutException);
            break label414;
          }
          catch (ConnectTimeoutException localConnectTimeoutException)
          {
            if (!QLog.isColorLevel()) {
              break label414;
            }
          }
          QLog.d("ReportCenter", 2, "-->doReportCgi, doupload exception", localConnectTimeoutException);
        }
        finally {}
        if (j == 0) {
          ReportDatabaseHelper.a().a("report_cgi", this.this$0.a);
        }
        synchronized (this.this$0)
        {
          this.this$0.a.clear();
          return;
        }
        j = m;
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->doReportCgi, exception in serial executor.", localException2);
        }
        return;
      }
      label414:
      if (m >= i) {
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.4
 * JD-Core Version:    0.7.0.1
 */