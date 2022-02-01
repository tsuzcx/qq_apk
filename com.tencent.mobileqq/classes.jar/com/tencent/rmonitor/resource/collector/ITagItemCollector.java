package com.tencent.rmonitor.resource.collector;

import com.tencent.rmonitor.resource.meta.PerfItem;
import com.tencent.rmonitor.resource.meta.TagItem;
import java.util.Vector;

public abstract interface ITagItemCollector
{
  public abstract String a();
  
  public abstract void a(ITagItemCollectorListener paramITagItemCollectorListener);
  
  public abstract void a(PerfItem paramPerfItem);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract String b();
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract int c();
  
  public abstract Vector<TagItem> d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.ITagItemCollector
 * JD-Core Version:    0.7.0.1
 */