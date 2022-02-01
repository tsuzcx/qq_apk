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
  
  private DCAIOPreview.AIOPreviewData a(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData2 = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    DCAIOPreview.AIOPreviewData localAIOPreviewData1 = localAIOPreviewData2;
    if (localAIOPreviewData2 == null)
    {
      localAIOPreviewData1 = new DCAIOPreview.AIOPreviewData(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localAIOPreviewData1);
    }
    return localAIOPreviewData1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    DCAIOPreview.AIOPreviewData.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    String str;
    if (localAIOPreviewData != null)
    {
      paramInt = PhotoUtils.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      DCAIOPreview.AIOPreviewData.b(localAIOPreviewData, str);
      return;
      str = "long";
      continue;
      str = "small";
      continue;
      str = "mid";
      continue;
      str = "large";
      continue;
      str = "extra";
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if (localAIOPreviewData != null) {
      DCAIOPreview.AIOPreviewData.d(localAIOPreviewData, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if (localAIOPreviewData != null) {
      DCAIOPreview.AIOPreviewData.a(localAIOPreviewData, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if ((localAIOPreviewData != null) && (DCAIOPreview.AIOPreviewData.a(localAIOPreviewData))) {
      DCAIOPreview.AIOPreviewData.b(localAIOPreviewData);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if (localAIOPreviewData != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      DCAIOPreview.AIOPreviewData.c(localAIOPreviewData, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if ((localAIOPreviewData != null) && (DCAIOPreview.AIOPreviewData.a(localAIOPreviewData))) {
      DCAIOPreview.AIOPreviewData.c(localAIOPreviewData);
    }
  }
  
  public void d(int paramInt)
  {
    DCAIOPreview.AIOPreviewData localAIOPreviewData = (DCAIOPreview.AIOPreviewData)this.a.get(paramInt);
    if ((localAIOPreviewData != null) && (DCAIOPreview.AIOPreviewData.a(localAIOPreviewData))) {
      DCAIOPreview.AIOPreviewData.a(localAIOPreviewData, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview
 * JD-Core Version:    0.7.0.1
 */