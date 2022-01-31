package com.tencent.upload.report;

import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReportEvent
{
  private static final String TAG = "ReportEvent";
  public long endTime = 0L;
  private boolean isPhotoType;
  public List<Report> reports = new ArrayList();
  public long startTime = 0L;
  
  public ReportEvent(boolean paramBoolean)
  {
    this.isPhotoType = paramBoolean;
  }
  
  private void calculateAvgSpeed()
  {
    if (this.reports.size() == 0) {
      return;
    }
    long l2 = this.endTime - this.startTime;
    long l3 = l2 / this.reports.size();
    Iterator localIterator = this.reports.iterator();
    Report localReport;
    for (long l1 = 0L; localIterator.hasNext(); l1 = localReport.fileSize + l1)
    {
      localReport = (Report)localIterator.next();
      localReport.endTime = (localReport.startTime + l3);
    }
    float f = (float)l1 * 1.0F * 1000.0F / (float)(1024L * l2);
    UploadLog.d("ReportEvent", "[speed]" + f + "kb/s");
  }
  
  public boolean add(Report paramReport)
  {
    int i;
    if (paramReport.uploadType.serverRouteTable.supportFileType == Const.FileType.Photo)
    {
      i = 1;
      if (i == this.isPhotoType) {
        break label33;
      }
    }
    label33:
    do
    {
      do
      {
        return false;
        i = 0;
        break;
      } while ((paramReport.startTime <= 0L) || (paramReport.endTime < paramReport.startTime) || (paramReport.endTime - paramReport.startTime > 900000L));
      if ((this.startTime == 0L) && (this.endTime == 0L))
      {
        this.startTime = paramReport.startTime;
        this.endTime = paramReport.endTime;
        this.reports.add(paramReport);
        return true;
      }
      if ((this.startTime <= paramReport.startTime) && (this.endTime >= paramReport.startTime))
      {
        this.endTime = Math.max(this.endTime, paramReport.endTime);
        this.reports.add(paramReport);
        return true;
      }
    } while ((this.startTime >= paramReport.endTime) || (this.endTime < paramReport.endTime));
    this.startTime = Math.min(this.startTime, paramReport.startTime);
    this.reports.add(paramReport);
    return true;
  }
  
  public void report()
  {
    calculateAvgSpeed();
    Iterator localIterator = this.reports.iterator();
    while (localIterator.hasNext())
    {
      Report localReport = (Report)localIterator.next();
      UploadGlobalConfig.getUploadReport().onUploadReport(localReport);
      UploadLog.d("ReportEvent", "report id :" + localReport.flowId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.report.ReportEvent
 * JD-Core Version:    0.7.0.1
 */