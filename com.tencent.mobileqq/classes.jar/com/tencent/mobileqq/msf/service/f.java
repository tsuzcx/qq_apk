package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import java.util.HashMap;

public class f
{
  private static final int a = 0;
  private static final int b = 1;
  
  public static f a()
  {
    return f.a.a();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (MsfService.getCore().getStatReporter() != null) {
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 0;; i = 1)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("resultCode", String.valueOf(i));
      localHashMap.put("failReason", paramString);
      MsfService.getCore().getStatReporter().a("EvtIPCTransport", true, 0L, 0L, localHashMap, false, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.f
 * JD-Core Version:    0.7.0.1
 */