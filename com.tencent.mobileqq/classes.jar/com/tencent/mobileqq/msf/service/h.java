package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import java.util.HashMap;

public class h
{
  private static final int a = 0;
  private static final int b = 1;
  private int c = f.a().b() / 1024;
  
  public static h a()
  {
    return h.a.a();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if (MsfService.getCore().getStatReporter() != null) {
      if (!paramBoolean) {
        break label140;
      }
    }
    label140:
    for (int i = 0;; i = 1)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("resultCode", String.valueOf(i));
      localHashMap.put("failReason", paramString1);
      localHashMap.put("fromMsgLen", String.valueOf(paramInt2 / 1024));
      localHashMap.put("totalLen", String.valueOf((paramInt1 + paramInt2) / 1024));
      localHashMap.put("packageLen", String.valueOf(this.c));
      localHashMap.put("cmd", paramString2);
      localHashMap.put("sleepByIPCBlockTime", String.valueOf(paramLong));
      MsfService.getCore().getStatReporter().a("EvtIPCTransport", paramBoolean, 0L, 0L, localHashMap, false, false);
      return;
    }
  }
  
  public void b()
  {
    if (MsfService.getCore().getStatReporter() != null)
    {
      HashMap localHashMap = new HashMap();
      MsfService.getCore().getStatReporter().a("EvtIPC", true, 0L, 0L, localHashMap, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.h
 * JD-Core Version:    0.7.0.1
 */