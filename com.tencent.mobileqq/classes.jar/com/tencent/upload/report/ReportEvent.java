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
    long l1 = 0L;
    Object localObject = this.reports.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Report localReport = (Report)((Iterator)localObject).next();
      localReport.endTime = (localReport.startTime + l3);
      l1 += localReport.fileSize;
    }
    float f = (float)l1 * 1.0F * 1000.0F / (float)(l2 * 1024L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[speed]");
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append("kb/s");
    UploadLog.d("ReportEvent", ((StringBuilder)localObject).toString());
  }
  
  public boolean add(Report paramReport)
  {
    int i;
    if (paramReport.uploadType.serverRouteTable.supportFileType == Const.FileType.Photo) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != this.isPhotoType) {
      return false;
    }
    if ((paramReport.startTime > 0L) && (paramReport.endTime >= paramReport.startTime))
    {
      if (paramReport.endTime - paramReport.startTime > 900000L) {
        return false;
      }
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
      if ((this.startTime < paramReport.endTime) && (this.endTime >= paramReport.endTime))
      {
        this.startTime = Math.min(this.startTime, paramReport.startTime);
        this.reports.add(paramReport);
        return true;
      }
    }
    return false;
  }
  
  public void report()
  {
    calculateAvgSpeed();
    Iterator localIterator = this.reports.iterator();
    while (localIterator.hasNext())
    {
      Report localReport = (Report)localIterator.next();
      UploadGlobalConfig.getUploadReport().onUploadReport(localReport);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report id :");
      localStringBuilder.append(localReport.flowId);
      UploadLog.d("ReportEvent", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.report.ReportEvent
 * JD-Core Version:    0.7.0.1
 */