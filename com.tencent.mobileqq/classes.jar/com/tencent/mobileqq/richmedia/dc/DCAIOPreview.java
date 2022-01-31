package com.tencent.mobileqq.richmedia.dc;

import ahnh;
import ahni;
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
  private SparseArray a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new ahnh(this, a());
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
  
  private ahni a(int paramInt)
  {
    ahni localahni2 = (ahni)this.a.get(paramInt);
    ahni localahni1 = localahni2;
    if (localahni2 == null)
    {
      localahni1 = new ahni(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localahni1);
    }
    return localahni1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    ahni.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    ahni localahni = (ahni)this.a.get(paramInt);
    String str;
    if (localahni != null)
    {
      paramInt = PhotoUtils.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      ahni.b(localahni, str);
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
    ahni localahni = (ahni)this.a.get(paramInt);
    if (localahni != null) {
      ahni.d(localahni, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ahni localahni = (ahni)this.a.get(paramInt);
    if (localahni != null) {
      ahni.a(localahni, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    ahni localahni = (ahni)this.a.get(paramInt);
    if ((localahni != null) && (ahni.a(localahni))) {
      ahni.b(localahni);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    ahni localahni = (ahni)this.a.get(paramInt);
    if (localahni != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      ahni.c(localahni, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    ahni localahni = (ahni)this.a.get(paramInt);
    if ((localahni != null) && (ahni.a(localahni))) {
      ahni.c(localahni);
    }
  }
  
  public void d(int paramInt)
  {
    ahni localahni = (ahni)this.a.get(paramInt);
    if ((localahni != null) && (ahni.a(localahni))) {
      ahni.a(localahni, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview
 * JD-Core Version:    0.7.0.1
 */