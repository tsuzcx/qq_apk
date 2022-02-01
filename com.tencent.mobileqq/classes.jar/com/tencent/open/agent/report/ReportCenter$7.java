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

class ReportCenter$7
  implements Runnable
{
  ReportCenter$7(ReportCenter paramReportCenter, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean) {}
  
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("appid", localStringBuilder.toString());
        ((Bundle)localObject1).putString("commandid", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putString("detail", this.jdField_b_of_type_JavaLangString);
        localStringBuilder = new StringBuilder();
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
          j = 100 / this.jdField_b_of_type_Int;
          if (j > 0) {
            break label492;
          }
          i = 1;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(i);
          ((Bundle)localObject1).putString("frequency", ((StringBuilder)localObject3).toString());
          ((Bundle)localObject1).putString("reqSize", "0");
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_c_of_type_Int);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("resultCode", ((StringBuilder)localObject3).toString());
          ((Bundle)localObject1).putString("rspSize", "0");
          ((Bundle)localObject1).putString("timeCost", "0");
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject3).append("");
          ((Bundle)localObject1).putString("uin", ((StringBuilder)localObject3).toString());
          localObject1 = new BaseData((Bundle)localObject1);
          try
          {
            this.this$0.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Agent_ReportTimeInterval");
            i = j;
            if (j == 0) {
              i = 10000;
            }
            if (this.jdField_a_of_type_Boolean)
            {
              this.this$0.a(null);
              this.this$0.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
              return;
            }
            if (!this.this$0.jdField_a_of_type_AndroidOsHandler.hasMessages(1000))
            {
              localObject1 = Message.obtain();
              ((Message)localObject1).what = 1000;
              this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, i);
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
      label492:
      i = j;
      if (j > 100) {
        i = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.7
 * JD-Core Version:    0.7.0.1
 */