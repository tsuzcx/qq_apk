package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.SystemClock;

public class DCAIOPreviewProgressive
  extends DataCollector
  implements ReportEvent
{
  private DCAIOPreviewProgressive.ProgressiveData d;
  private boolean e;
  
  public DCAIOPreviewProgressive(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!this.e))
    {
      localObject = new DataReport.ReportTask("Pic.AioPreview.Progressive", ((DCAIOPreviewProgressive.ProgressiveData)localObject).a("Pic.AioPreview.Progressive"));
      DataReport.a().a((DataReport.ReportTask)localObject);
      this.e = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.d == null) && (!this.e))
    {
      DCAIOPreviewProgressive.ProgressiveData localProgressiveData = new DCAIOPreviewProgressive.ProgressiveData(null);
      DCAIOPreviewProgressive.ProgressiveData.a(localProgressiveData, paramBoolean);
      DCAIOPreviewProgressive.ProgressiveData.a(localProgressiveData, SystemClock.uptimeMillis());
      this.d = localProgressiveData;
    }
  }
  
  public void b()
  {
    DCAIOPreviewProgressive.ProgressiveData localProgressiveData = this.d;
    if ((localProgressiveData != null) && (!this.e)) {
      DCAIOPreviewProgressive.ProgressiveData.b(localProgressiveData, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    DCAIOPreviewProgressive.ProgressiveData localProgressiveData = this.d;
    if ((localProgressiveData != null) && (!this.e)) {
      DCAIOPreviewProgressive.ProgressiveData.c(localProgressiveData, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    DCAIOPreviewProgressive.ProgressiveData localProgressiveData = this.d;
    if ((localProgressiveData != null) && (!this.e)) {
      DCAIOPreviewProgressive.ProgressiveData.b(localProgressiveData, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive
 * JD-Core Version:    0.7.0.1
 */