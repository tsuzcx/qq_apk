package com.tencent.mobileqq.richmedia.dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class DCAIOPreview
  extends DataCollector
  implements ReportEvent
{
  private String d;
  private SparseArray<DCAIOPreview.AIOPreviewData> e = new SparseArray();
  private Handler f = new DCAIOPreview.1(this, e());
  
  public DCAIOPreview(Context paramContext)
  {
    super(paramContext);
    int i = ((Activity)paramContext).getIntent().getIntExtra("forward_source_uin_type", -1);
    if (i == 0)
    {
      this.d = "c2c";
      return;
    }
    if (i == 1)
    {
      this.d = "grp";
      return;
    }
    if (i == 3000)
    {
      this.d = "dis";
      return;
    }
    this.d = "other";
  }
  
  public void a()
  {
    this.f.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.e.get(paramInt);
    if ((localAIOPreviewData != null) && (DCAIOPreview.AIOPreviewData.a(localAIOPreviewData))) {
      DCAIOPreview.AIOPreviewData.b(localAIOPreviewData);
    }
  }
  
  public void b(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.e.get(paramInt);
    if ((localAIOPreviewData != null) && (DCAIOPreview.AIOPreviewData.a(localAIOPreviewData))) {
      DCAIOPreview.AIOPreviewData.c(localAIOPreviewData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview
 * JD-Core Version:    0.7.0.1
 */