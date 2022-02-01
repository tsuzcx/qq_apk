package com.tencent.rmonitor.resource;

import com.tencent.rmonitor.resource.collector.IPerfItemCollectorListener;
import com.tencent.rmonitor.resource.collector.ITagItemCollector;
import com.tencent.rmonitor.resource.meta.PerfItem;
import org.jetbrains.annotations.NotNull;

class ResourceMonitor$2
  implements IPerfItemCollectorListener
{
  ResourceMonitor$2(ResourceMonitor paramResourceMonitor) {}
  
  public void a(@NotNull PerfItem paramPerfItem)
  {
    paramPerfItem.stage = ResourceMonitor.b(this.a).a();
    paramPerfItem.extraInfo = ResourceMonitor.b(this.a).b();
  }
  
  public void b()
  {
    ResourceMonitor.a(this.a, false);
  }
  
  public void b(@NotNull PerfItem paramPerfItem)
  {
    ResourceMonitor.b(this.a).a(paramPerfItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.ResourceMonitor.2
 * JD-Core Version:    0.7.0.1
 */