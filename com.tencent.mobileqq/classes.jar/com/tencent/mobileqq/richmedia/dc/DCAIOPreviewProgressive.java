package com.tencent.mobileqq.richmedia.dc;

import agzi;
import agzx;
import android.content.Context;
import android.os.SystemClock;

public class DCAIOPreviewProgressive
  extends DataCollector
  implements ReportEvent
{
  private agzi a;
  private boolean b;
  
  public DCAIOPreviewProgressive(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if ((this.a != null) && (!this.b))
    {
      agzx localagzx = new agzx("Pic.AioPreview.Progressive", this.a.a("Pic.AioPreview.Progressive"));
      DataReport.a().a(localagzx);
      this.b = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a == null) && (!this.b))
    {
      agzi localagzi = new agzi(null);
      agzi.a(localagzi, paramBoolean);
      agzi.a(localagzi, SystemClock.uptimeMillis());
      this.a = localagzi;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      agzi.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      agzi.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      agzi.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive
 * JD-Core Version:    0.7.0.1
 */