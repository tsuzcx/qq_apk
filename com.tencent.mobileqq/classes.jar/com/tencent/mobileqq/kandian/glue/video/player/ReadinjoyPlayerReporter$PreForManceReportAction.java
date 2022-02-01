package com.tencent.mobileqq.kandian.glue.video.player;

import com.tencent.qphone.base.util.QLog;

public class ReadinjoyPlayerReporter$PreForManceReportAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$PreForManceReportAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = ((String)paramObject).split(":", 2);
      if ((paramObject != null) && (paramObject.length == 2))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("PERFORMANCE_REPORT method:");
          localStringBuilder.append(paramObject[0]);
          localStringBuilder.append("\ntimeJson:");
          localStringBuilder.append(paramObject[1]);
          QLog.d("ReadinjoyPlayerReporter", 2, localStringBuilder.toString());
        }
        if ("prepare".equals(paramObject[0])) {
          this.a.a.m = paramObject[1];
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.PreForManceReportAction
 * JD-Core Version:    0.7.0.1
 */