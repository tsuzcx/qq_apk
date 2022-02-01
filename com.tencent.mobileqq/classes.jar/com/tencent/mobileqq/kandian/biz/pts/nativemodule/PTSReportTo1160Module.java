package com.tencent.mobileqq.kandian.biz.pts.nativemodule;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport.R5Builder;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry.IPTSReportTo1160;
import com.tencent.qphone.base.util.QLog;

public class PTSReportTo1160Module
  implements PTSNativeModuleRegistry.IPTSReportTo1160
{
  public void reportTo1160(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportTo1160], event = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", toUin = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", r2 = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", r3 = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", r4 = ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(", r5 = ");
    localStringBuilder.append(paramString4);
    QLog.i("PTSReportTo1160Module", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(paramLong);
      paramString2 = paramString2.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      PTSReport.a(paramString1, paramString2, localStringBuilder.toString(), paramString3, new PTSReport.R5Builder(paramString4).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSReportTo1160Module
 * JD-Core Version:    0.7.0.1
 */