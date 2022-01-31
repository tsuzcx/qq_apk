package com.tencent.mobileqq.msf.core.c;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class k$a
{
  HashMap n = null;
  
  public void a(String paramString, int paramInt)
  {
    b.a(BaseApplication.getContext()).a(paramString, this.n, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.n == null) {
      this.n = new HashMap();
    }
    this.n.put(paramString1, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a(paramString, paramBoolean, paramLong1, paramLong2, this.n, false, false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a(paramString, paramBoolean1, paramLong1, paramLong2, this.n, paramBoolean2, paramBoolean3);
    }
  }
  
  public void b(String paramString)
  {
    b.a(BaseApplication.getContext()).a(paramString, this.n);
  }
  
  public void h()
  {
    if (this.n != null) {
      this.n.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.k.a
 * JD-Core Version:    0.7.0.1
 */