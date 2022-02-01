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
  private SparseArray<DCAIOPreview.AIOPreviewData> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new DCAIOPreview.1(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public DCAIOPreview(Context paramContext)
  {
    super(paramContext);
    int i = ((Activity)paramContext).getIntent().getIntExtra("forward_source_uin_type", -1);
    if (i == 0)
    {
      this.jdField_b_of_type_JavaLangString = "c2c";
      return;
    }
    if (i == 1)
    {
      this.jdField_b_of_type_JavaLangString = "grp";
      return;
    }
    if (i == 3000)
    {
      this.jdField_b_of_type_JavaLangString = "dis";
      return;
    }
    this.jdField_b_of_type_JavaLangString = "other";
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if ((localAIOPreviewData != null) && (DCAIOPreview.AIOPreviewData.a(localAIOPreviewData))) {
      DCAIOPreview.AIOPreviewData.a(localAIOPreviewData);
    }
  }
  
  public void b(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if ((localAIOPreviewData != null) && (DCAIOPreview.AIOPreviewData.a(localAIOPreviewData))) {
      DCAIOPreview.AIOPreviewData.b(localAIOPreviewData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview
 * JD-Core Version:    0.7.0.1
 */