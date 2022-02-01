package com.tencent.mobileqq.qmethodmonitor.monitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InvokeMonitor$InvokeConfig
{
  public String a;
  public List<InvokeMonitor.InvokeRecord> b = Collections.synchronizedList(new ArrayList());
  public int c;
  public int d = 0;
  public int e;
  
  public InvokeMonitor$InvokeConfig(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.c = paramInt1;
    this.e = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.InvokeMonitor.InvokeConfig
 * JD-Core Version:    0.7.0.1
 */