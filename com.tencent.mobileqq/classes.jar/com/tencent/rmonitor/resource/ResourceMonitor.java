package com.tencent.rmonitor.resource;

import android.app.Application;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.QAPMScenePlugin;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.resource.collector.DataCollector;
import com.tencent.rmonitor.resource.collector.IPerfItemCollector;
import com.tencent.rmonitor.resource.collector.IPerfItemCollectorListener;
import com.tencent.rmonitor.resource.collector.ITagItemCollector;
import com.tencent.rmonitor.resource.collector.ITagItemCollectorListener;
import com.tencent.rmonitor.resource.collector.PerfItemCollector;
import com.tencent.rmonitor.resource.collector.TagItemCollector;
import com.tencent.rmonitor.resource.collector.TemperatureCollector;
import com.tencent.rmonitor.resource.reflect.ReflectIoModule;
import com.tencent.rmonitor.resource.runnable.DumpSampleFileRunnable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

public class ResourceMonitor
  extends QAPMScenePlugin
{
  @Nullable
  private static volatile ResourceMonitor a;
  private volatile boolean b = false;
  private final ReflectIoModule c = new ReflectIoModule();
  private final DataCollector d = new DataCollector();
  private final ITagItemCollectorListener e = new ResourceMonitor.1(this);
  private final IPerfItemCollectorListener f = new ResourceMonitor.2(this);
  @NotNull
  private ITagItemCollector g = new TagItemCollector(this.c, this.d);
  @NotNull
  private IPerfItemCollector h = new PerfItemCollector(this.c, this.d);
  
  private ResourceMonitor()
  {
    this.g.a(this.e);
    this.h.a(this.f);
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    Handler localHandler = new Handler(ThreadManager.e());
    DumpSampleFileRunnable localDumpSampleFileRunnable = DumpSampleFileRunnable.a();
    if (paramBoolean) {
      localDumpSampleFileRunnable.a(true);
    }
    localHandler.post(localDumpSampleFileRunnable);
  }
  
  private void d()
  {
    LifecycleCallback.a(new ResourceMonitor.3(this));
  }
  
  public static ResourceMonitor getInstance()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ResourceMonitor();
        }
      }
      finally {}
    }
    return a;
  }
  
  @NotNull
  public ITagItemCollector b()
  {
    return this.g;
  }
  
  public void beginScene(String paramString1, String paramString2)
  {
    this.g.a(paramString1, paramString2);
  }
  
  @NotNull
  public IPerfItemCollector c()
  {
    return this.h;
  }
  
  public void endScene(String paramString1, String paramString2)
  {
    this.g.b(paramString1, paramString2);
  }
  
  public JSONArray getResourceInfo()
  {
    return DumpSampleFileRunnable.a().a(this.h.g());
  }
  
  public void start()
  {
    if (!this.b)
    {
      if (BaseInfo.app != null) {
        BaseInfo.app.registerReceiver(new TemperatureCollector(), TemperatureCollector.b());
      }
      this.b = true;
    }
    if ((!this.h.a()) && (RunTimeEnv.c()))
    {
      Logger.b.i(new String[] { "RMonitor_resource_ResourceMonitor", "SAMPLE: start global monitor to collect resource" });
      this.h.b();
    }
  }
  
  public void stop()
  {
    if (this.h.a())
    {
      Logger.b.i(new String[] { "RMonitor_resource_ResourceMonitor", "SAMPLE: stop global monitor to collect resource" });
      this.h.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.ResourceMonitor
 * JD-Core Version:    0.7.0.1
 */