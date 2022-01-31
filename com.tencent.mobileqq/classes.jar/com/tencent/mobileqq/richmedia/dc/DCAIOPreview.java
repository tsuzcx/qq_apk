package com.tencent.mobileqq.richmedia.dc;

import agzf;
import agzg;
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
  private Handler jdField_b_of_type_AndroidOsHandler = new agzf(this, a());
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
  
  private agzg a(int paramInt)
  {
    agzg localagzg2 = (agzg)this.a.get(paramInt);
    agzg localagzg1 = localagzg2;
    if (localagzg2 == null)
    {
      localagzg1 = new agzg(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localagzg1);
    }
    return localagzg1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    agzg.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    agzg localagzg = (agzg)this.a.get(paramInt);
    String str;
    if (localagzg != null)
    {
      paramInt = PhotoUtils.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      agzg.b(localagzg, str);
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
    agzg localagzg = (agzg)this.a.get(paramInt);
    if (localagzg != null) {
      agzg.d(localagzg, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    agzg localagzg = (agzg)this.a.get(paramInt);
    if (localagzg != null) {
      agzg.a(localagzg, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    agzg localagzg = (agzg)this.a.get(paramInt);
    if ((localagzg != null) && (agzg.a(localagzg))) {
      agzg.b(localagzg);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    agzg localagzg = (agzg)this.a.get(paramInt);
    if (localagzg != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      agzg.c(localagzg, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    agzg localagzg = (agzg)this.a.get(paramInt);
    if ((localagzg != null) && (agzg.a(localagzg))) {
      agzg.c(localagzg);
    }
  }
  
  public void d(int paramInt)
  {
    agzg localagzg = (agzg)this.a.get(paramInt);
    if ((localagzg != null) && (agzg.a(localagzg))) {
      agzg.a(localagzg, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview
 * JD-Core Version:    0.7.0.1
 */