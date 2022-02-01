package com.tencent.mobileqq.msf.core.d;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.service.MsfService;
import java.util.HashMap;

public class j$a
{
  HashMap n = null;
  
  public void a(String paramString1, String paramString2)
  {
    if (this.n == null) {
      this.n = new HashMap();
    }
    this.n.put(paramString1, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (MsfService.getCore().getStatReporter() != null)
    {
      MsfService.getCore().getStatReporter().a(paramString, paramBoolean, paramLong1, paramLong2, this.n, false, false);
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (MsfService.getCore().getStatReporter() != null)
    {
      MsfService.getCore().getStatReporter().a(paramString, paramBoolean1, paramLong1, paramLong2, this.n, paramBoolean2, paramBoolean3);
      return;
    }
  }
  
  public void h()
  {
    HashMap localHashMap = this.n;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.j.a
 * JD-Core Version:    0.7.0.1
 */