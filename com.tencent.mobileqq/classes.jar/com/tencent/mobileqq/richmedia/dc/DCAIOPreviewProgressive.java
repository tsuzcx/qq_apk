package com.tencent.mobileqq.richmedia.dc;

import ahnk;
import ahnz;
import android.content.Context;
import android.os.SystemClock;

public class DCAIOPreviewProgressive
  extends DataCollector
  implements ReportEvent
{
  private ahnk a;
  private boolean b;
  
  public DCAIOPreviewProgressive(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if ((this.a != null) && (!this.b))
    {
      ahnz localahnz = new ahnz("Pic.AioPreview.Progressive", this.a.a("Pic.AioPreview.Progressive"));
      DataReport.a().a(localahnz);
      this.b = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a == null) && (!this.b))
    {
      ahnk localahnk = new ahnk(null);
      ahnk.a(localahnk, paramBoolean);
      ahnk.a(localahnk, SystemClock.uptimeMillis());
      this.a = localahnk;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      ahnk.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      ahnk.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      ahnk.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive
 * JD-Core Version:    0.7.0.1
 */