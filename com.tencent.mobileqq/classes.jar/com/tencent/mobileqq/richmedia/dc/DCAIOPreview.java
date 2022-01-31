package com.tencent.mobileqq.richmedia.dc;

import ahrz;
import ahsa;
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
  private Handler jdField_b_of_type_AndroidOsHandler = new ahrz(this, a());
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
  
  private ahsa a(int paramInt)
  {
    ahsa localahsa2 = (ahsa)this.a.get(paramInt);
    ahsa localahsa1 = localahsa2;
    if (localahsa2 == null)
    {
      localahsa1 = new ahsa(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localahsa1);
    }
    return localahsa1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    ahsa.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    ahsa localahsa = (ahsa)this.a.get(paramInt);
    String str;
    if (localahsa != null)
    {
      paramInt = PhotoUtils.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      ahsa.b(localahsa, str);
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
    ahsa localahsa = (ahsa)this.a.get(paramInt);
    if (localahsa != null) {
      ahsa.d(localahsa, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ahsa localahsa = (ahsa)this.a.get(paramInt);
    if (localahsa != null) {
      ahsa.a(localahsa, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    ahsa localahsa = (ahsa)this.a.get(paramInt);
    if ((localahsa != null) && (ahsa.a(localahsa))) {
      ahsa.b(localahsa);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    ahsa localahsa = (ahsa)this.a.get(paramInt);
    if (localahsa != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      ahsa.c(localahsa, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    ahsa localahsa = (ahsa)this.a.get(paramInt);
    if ((localahsa != null) && (ahsa.a(localahsa))) {
      ahsa.c(localahsa);
    }
  }
  
  public void d(int paramInt)
  {
    ahsa localahsa = (ahsa)this.a.get(paramInt);
    if ((localahsa != null) && (ahsa.a(localahsa))) {
      ahsa.a(localahsa, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview
 * JD-Core Version:    0.7.0.1
 */