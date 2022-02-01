package com.tencent.mobileqq.richmedia.dc;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class DCShortVideo$2
  implements Runnable
{
  DCShortVideo$2(DCShortVideo paramDCShortVideo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new DCShortVideo.DCShortVideoPreviewData();
    this.this$0.a(this.a, this.b, this.c, this.d, (DCShortVideo.DCShortVideoReportData)localObject);
    ((DCShortVideo.DCShortVideoPreviewData)localObject).a = this.e;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reportPreview]shortVideoType=");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).g);
      localStringBuilder.append(",uinType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).c);
      localStringBuilder.append(",groupMemCount = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).d);
      localStringBuilder.append(",age = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).e);
      localStringBuilder.append(",gender = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).f);
      localStringBuilder.append(",reprotHour = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).h);
      localStringBuilder.append(",netType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).i);
      localStringBuilder.append(",playAction = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).a);
      QLog.d("DCShortVideo", 4, localStringBuilder.toString());
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((DCShortVideo.DCShortVideoPreviewData)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */