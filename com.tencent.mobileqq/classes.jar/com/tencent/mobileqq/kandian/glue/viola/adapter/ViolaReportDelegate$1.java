package com.tencent.mobileqq.kandian.glue.viola.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ViolaReportDelegate$1
  implements Runnable
{
  ViolaReportDelegate$1(ViolaReportDelegate paramViolaReportDelegate, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = ReadInJoyHelper.N();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = new JSONObject((String)localObject1);
      } else {
        localObject1 = new JSONObject();
      }
      localObject2 = ViolaReportDelegate.a(this.this$0, this.a);
      if (localObject2 != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.b);
        ((JSONObject)localObject1).put(localStringBuilder.toString(), localObject2);
        ReadInJoyHelper.i(((JSONObject)localObject1).toString());
        ReadInJoyHelper.e(true);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localObject2 = ViolaReportDelegate.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cachePageOpenData Exception:");
        localStringBuilder.append(localException.getMessage());
        QLog.e((String)localObject2, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate.1
 * JD-Core Version:    0.7.0.1
 */