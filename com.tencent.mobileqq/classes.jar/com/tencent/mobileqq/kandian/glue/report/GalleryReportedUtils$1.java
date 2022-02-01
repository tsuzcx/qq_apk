package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

final class GalleryReportedUtils$1
  extends SosoInterfaceOnLocationListener
{
  GalleryReportedUtils$1(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    GalleryReportedUtils.a(false);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get Location: info = ");
      localStringBuilder.append(paramSosoLbsInfo.toString());
      QLog.d("GalleryReportedUtils", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils.1
 * JD-Core Version:    0.7.0.1
 */