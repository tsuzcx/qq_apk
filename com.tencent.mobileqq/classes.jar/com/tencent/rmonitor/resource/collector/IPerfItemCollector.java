package com.tencent.rmonitor.resource.collector;

import com.tencent.rmonitor.resource.meta.PerfItem;
import java.util.Vector;

public abstract interface IPerfItemCollector
{
  public abstract void a(IPerfItemCollectorListener paramIPerfItemCollectorListener);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract int e();
  
  public abstract Vector<PerfItem> f();
  
  public abstract Vector<PerfItem> g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.IPerfItemCollector
 * JD-Core Version:    0.7.0.1
 */