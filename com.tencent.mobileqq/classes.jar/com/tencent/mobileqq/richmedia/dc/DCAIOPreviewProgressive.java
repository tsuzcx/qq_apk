package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.SystemClock;

public class DCAIOPreviewProgressive
  extends DataCollector
  implements ReportEvent
{
  private DCAIOPreviewProgressive.ProgressiveData a;
  private boolean b;
  
  public DCAIOPreviewProgressive(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if ((this.a != null) && (!this.b))
    {
      DataReport.ReportTask localReportTask = new DataReport.ReportTask("Pic.AioPreview.Progressive", this.a.a("Pic.AioPreview.Progressive"));
      DataReport.a().a(localReportTask);
      this.b = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a == null) && (!this.b))
    {
      DCAIOPreviewProgressive.ProgressiveData localProgressiveData = new DCAIOPreviewProgressive.ProgressiveData(null);
      DCAIOPreviewProgressive.ProgressiveData.a(localProgressiveData, paramBoolean);
      DCAIOPreviewProgressive.ProgressiveData.a(localProgressiveData, SystemClock.uptimeMillis());
      this.a = localProgressiveData;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      DCAIOPreviewProgressive.ProgressiveData.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      DCAIOPreviewProgressive.ProgressiveData.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      DCAIOPreviewProgressive.ProgressiveData.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive
 * JD-Core Version:    0.7.0.1
 */