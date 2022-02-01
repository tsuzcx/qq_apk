package com.tencent.mobileqq.richmedia.dc;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class DCShortVideo$4
  implements Runnable
{
  DCShortVideo$4(DCShortVideo paramDCShortVideo, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new DCShortVideo.DCShortVideoSaveData();
    this.this$0.a(this.a, this.b, this.c, this.d, (DCShortVideo.DCShortVideoReportData)localObject);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reportSave]shortVideoType=");
      localStringBuilder.append(((DCShortVideo.DCShortVideoSaveData)localObject).g);
      localStringBuilder.append(",uinType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoSaveData)localObject).c);
      localStringBuilder.append(",groupMemCount = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoSaveData)localObject).d);
      localStringBuilder.append(",age = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoSaveData)localObject).e);
      localStringBuilder.append(",gender = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoSaveData)localObject).f);
      localStringBuilder.append(",reprotHour = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoSaveData)localObject).h);
      localStringBuilder.append(",netType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoSaveData)localObject).i);
      QLog.d("DCShortVideo", 4, localStringBuilder.toString());
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((DCShortVideo.DCShortVideoSaveData)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */