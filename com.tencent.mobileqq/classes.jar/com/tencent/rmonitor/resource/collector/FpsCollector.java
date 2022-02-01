package com.tencent.rmonitor.resource.collector;

import android.text.TextUtils;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.resource.collector.frame.FrameManager;
import com.tencent.rmonitor.resource.collector.frame.IFrame;
import com.tencent.rmonitor.resource.meta.FpsMeta;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FpsCollector
  implements IFrame
{
  private static volatile FpsCollector a;
  private static boolean b = false;
  private final ConcurrentHashMap<String, FpsMeta> c = new ConcurrentHashMap();
  
  private FpsCollector()
  {
    if (!AndroidVersion.a())
    {
      Logger.b.d(new String[] { "RMonitor_resource_FpsMonitor", "build version is low" });
      return;
    }
    FrameManager.a.a(this);
  }
  
  public static FpsCollector a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FpsCollector();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(long paramLong)
  {
    if (this.c.size() <= 0) {
      return;
    }
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (FpsMeta)this.c.get(localObject);
      if (localObject != null) {
        ((FpsMeta)localObject).refresh += 1L;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!AndroidVersion.a()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.c.containsKey(paramString)) {
      return;
    }
    this.c.put(paramString, new FpsMeta());
    if (!b)
    {
      FrameManager.a.a();
      b = true;
    }
  }
  
  public long b(String paramString)
  {
    if (!this.c.containsKey(paramString)) {
      return 0L;
    }
    FpsMeta localFpsMeta = (FpsMeta)this.c.get(paramString);
    this.c.remove(paramString);
    if (this.c.size() == 0) {
      b = false;
    }
    if (localFpsMeta == null) {
      return 0L;
    }
    long l = System.nanoTime();
    double d1 = localFpsMeta.refresh;
    Double.isNaN(d1);
    double d2 = l - localFpsMeta.beginStamp;
    Double.isNaN(d2);
    return Math.round(d1 * 1.0D / (d2 / 1000000000.0D));
  }
  
  public boolean b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.FpsCollector
 * JD-Core Version:    0.7.0.1
 */