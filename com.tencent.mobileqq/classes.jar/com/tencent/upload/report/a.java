package com.tencent.upload.report;

import com.tencent.upload.common.Const.b;
import com.tencent.upload.common.b;
import com.tencent.upload.network.route.RouteFactory.ServerCategory;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  public long a = 0L;
  public long b = 0L;
  public List<Report> c = new ArrayList();
  private boolean d;
  
  public a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  private void b()
  {
    if (this.c.size() == 0) {
      return;
    }
    long l2 = this.b - this.a;
    long l3 = l2 / this.c.size();
    Iterator localIterator = this.c.iterator();
    Report localReport;
    for (long l1 = 0L; localIterator.hasNext(); l1 = localReport.fileSize + l1)
    {
      localReport = (Report)localIterator.next();
      localReport.endTime = (localReport.startTime + l3);
    }
    float f = (float)l1 * 1.0F * 1000.0F / (float)(1024L * l2);
    b.b("ReportEvent", "[speed]" + f + "kb/s");
  }
  
  public void a()
  {
    b();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Report localReport = (Report)localIterator.next();
      com.tencent.upload.common.a.c().onUploadReport(localReport);
      b.b("ReportEvent", "report id :" + localReport.flowId);
    }
  }
  
  public boolean a(Report paramReport)
  {
    int i;
    if (paramReport.uploadType.serverCategory.supportFileType == Const.b.b)
    {
      i = 1;
      if (i == this.d) {
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
      if ((this.a == 0L) && (this.b == 0L))
      {
        this.a = paramReport.startTime;
        this.b = paramReport.endTime;
        this.c.add(paramReport);
        return true;
      }
      if ((this.a <= paramReport.startTime) && (this.b >= paramReport.startTime))
      {
        this.b = Math.max(this.b, paramReport.endTime);
        this.c.add(paramReport);
        return true;
      }
    } while ((this.a >= paramReport.endTime) || (this.b < paramReport.endTime));
    this.a = Math.min(this.a, paramReport.startTime);
    this.c.add(paramReport);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.report.a
 * JD-Core Version:    0.7.0.1
 */