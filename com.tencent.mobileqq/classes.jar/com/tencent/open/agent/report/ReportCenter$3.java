package com.tencent.open.agent.report;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ReportCenter$3
  implements Runnable
{
  ReportCenter$3(ReportCenter paramReportCenter, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    for (;;)
    {
      int m;
      try
      {
        Object localObject1 = new Bundle();
        Object localObject3 = APNUtil.a(CommonDataAdapter.a().b());
        ((Bundle)localObject1).putString("apn", (String)localObject3);
        ((Bundle)localObject1).putString("appid", this.a);
        ((Bundle)localObject1).putString("commandid", this.b);
        ((Bundle)localObject1).putString("detail", this.c);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("network=");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append('&');
        localStringBuilder.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          k = 1;
          localStringBuilder.append(k);
          localStringBuilder.append('&');
          localStringBuilder.append("wifi=");
          localStringBuilder.append(APNUtil.h(CommonDataAdapter.a().b()));
          ((Bundle)localObject1).putString("deviceInfo", localStringBuilder.toString());
          m = 100 / this.this$0.a(this.d);
          if (m > 0) {
            break label645;
          }
          k = 1;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(k);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("frequency", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.e);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("reqSize", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.d);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("resultCode", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.f);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("rspSize", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.g);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("timeCost", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.h);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("uin", ((StringBuilder)localObject3).toString());
          ((Bundle)localObject1).putString("from_opensdk", Boolean.toString(this.i));
          localObject1 = new BaseData((Bundle)localObject1);
          try
          {
            this.this$0.c.add(localObject1);
            int n = this.this$0.c.size();
            int i1 = ReportDatabaseHelper.a().b("report_cgi");
            m = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Agent_ReportTimeInterval");
            k = m;
            if (m == 0) {
              k = 10000;
            }
            if ((!this.this$0.a("report_cgi", n + i1)) && (!this.j))
            {
              if (!this.this$0.h.hasMessages(1000))
              {
                localObject1 = Message.obtain();
                ((Message)localObject1).what = 1000;
                ((Message)localObject1).obj = "yingyongbao";
                this.this$0.h.sendMessageDelayed((Message)localObject1, k);
              }
            }
            else
            {
              this.this$0.a("yingyongbao");
              this.this$0.h.removeMessages(1000);
              return;
            }
          }
          finally {}
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->reportCgi, exception in sub thread.", localException);
        }
      }
      int k = 0;
      continue;
      label645:
      k = m;
      if (m > 100) {
        k = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.3
 * JD-Core Version:    0.7.0.1
 */