package com.tencent.mobileqq.richmedia.dc;

import com.tencent.qphone.base.util.QLog;

class DCShortVideo$6
  implements Runnable
{
  DCShortVideo$6(DCShortVideo paramDCShortVideo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    DCShortVideo.ProgressivePlayData localProgressivePlayData = new DCShortVideo.ProgressivePlayData();
    localProgressivePlayData.a = this.a;
    localProgressivePlayData.b = this.b;
    localProgressivePlayData.c = this.c;
    localProgressivePlayData.d = this.d;
    localProgressivePlayData.e = this.e;
    localProgressivePlayData.f = this.f;
    localProgressivePlayData.g = this.g;
    localProgressivePlayData.h = this.h;
    localProgressivePlayData.i = this.i;
    Object localObject = new DataReport.ReportTask("actStreamingVideoPlay", localProgressivePlayData.a("actStreamingVideoPlay"));
    DataReport.a().a((DataReport.ReportTask)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportProgressivePlayData():");
      ((StringBuilder)localObject).append(localProgressivePlayData.toString());
      QLog.d("DCShortVideo", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */