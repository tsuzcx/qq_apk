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
      int j;
      try
      {
        Object localObject1 = new Bundle();
        Object localObject3 = APNUtil.a(CommonDataAdapter.a().a());
        ((Bundle)localObject1).putString("apn", (String)localObject3);
        ((Bundle)localObject1).putString("appid", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putString("commandid", this.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putString("detail", this.jdField_c_of_type_JavaLangString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("network=");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append('&');
        localStringBuilder.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          i = 1;
          localStringBuilder.append(i);
          localStringBuilder.append('&');
          localStringBuilder.append("wifi=");
          localStringBuilder.append(APNUtil.e(CommonDataAdapter.a().a()));
          ((Bundle)localObject1).putString("deviceInfo", localStringBuilder.toString());
          j = 100 / this.this$0.a(this.jdField_a_of_type_Int);
          if (j > 0) {
            break label645;
          }
          i = 1;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("frequency", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("reqSize", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("resultCode", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_b_of_type_Long);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("rspSize", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("timeCost", ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.d);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("uin", ((StringBuilder)localObject3).toString());
          ((Bundle)localObject1).putString("from_opensdk", Boolean.toString(this.jdField_a_of_type_Boolean));
          localObject1 = new BaseData((Bundle)localObject1);
          try
          {
            this.this$0.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            int k = this.this$0.jdField_a_of_type_JavaUtilArrayList.size();
            int m = ReportDatabaseHelper.a().a("report_cgi");
            j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Agent_ReportTimeInterval");
            i = j;
            if (j == 0) {
              i = 10000;
            }
            if ((!this.this$0.a("report_cgi", k + m)) && (!this.jdField_b_of_type_Boolean))
            {
              if (!this.this$0.jdField_a_of_type_AndroidOsHandler.hasMessages(1000))
              {
                localObject1 = Message.obtain();
                ((Message)localObject1).what = 1000;
                ((Message)localObject1).obj = "yingyongbao";
                this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, i);
              }
            }
            else
            {
              this.this$0.a("yingyongbao");
              this.this$0.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
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
      int i = 0;
      continue;
      label645:
      i = j;
      if (j > 100) {
        i = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.3
 * JD-Core Version:    0.7.0.1
 */