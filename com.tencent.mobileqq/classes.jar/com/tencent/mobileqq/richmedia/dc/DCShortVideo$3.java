package com.tencent.mobileqq.richmedia.dc;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class DCShortVideo$3
  implements Runnable
{
  DCShortVideo$3(DCShortVideo paramDCShortVideo, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong) {}
  
  public void run()
  {
    Object localObject = new DCShortVideo.DCShortVideoFullscreenPreviewData();
    this.this$0.a(this.a, this.b, this.c, this.d, (DCShortVideo.DCShortVideoReportData)localObject);
    ((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).a = this.e;
    ((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).b = this.f;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reportFullscreenPreview]shortVideoType=");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).g);
      localStringBuilder.append(", duration=");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).a);
      localStringBuilder.append(",uinType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).c);
      localStringBuilder.append(",groupMemCount = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).d);
      localStringBuilder.append(",age = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).e);
      localStringBuilder.append(",gender = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).f);
      localStringBuilder.append(",reprotHour = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).h);
      localStringBuilder.append(",netType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).i);
      localStringBuilder.append(",playTimeCost = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).b);
      QLog.d("DCShortVideo", 4, localStringBuilder.toString());
    }
    localObject = new DataReport.ReportTask("ShortVideo.FullscreenPreview", ((DCShortVideo.DCShortVideoFullscreenPreviewData)localObject).a("ShortVideo.FullscreenPreview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.3
 * JD-Core Version:    0.7.0.1
 */