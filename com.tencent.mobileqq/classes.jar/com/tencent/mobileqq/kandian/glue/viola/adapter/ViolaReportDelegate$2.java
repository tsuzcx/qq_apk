package com.tencent.mobileqq.kandian.glue.viola.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ViolaReportDelegate$2
  implements Runnable
{
  ViolaReportDelegate$2(ViolaReportDelegate paramViolaReportDelegate) {}
  
  public void run()
  {
    try
    {
      String str1 = ReadInJoyHelper.N();
      if (!TextUtils.isEmpty(str1))
      {
        new JSONObject(str1);
        ReadInJoyHelper.i("");
        ReadInJoyHelper.e(false);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        String str2 = ViolaReportDelegate.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearCachePageOpenData Exception:");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str2, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate.2
 * JD-Core Version:    0.7.0.1
 */