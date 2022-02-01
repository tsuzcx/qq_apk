package com.tencent.rmonitor.bigbitmap;

import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.bigbitmap.checker.DefaultBitmapSizeChecker;
import com.tencent.rmonitor.bigbitmap.provider.BitmapDrawableSizeProvider;
import com.tencent.rmonitor.bigbitmap.provider.RootDrawableSizeProvider;
import com.tencent.rmonitor.bigbitmap.provider.StateListDrawableSizeProvider;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class BigBitmapMonitor
  extends QAPMMonitorPlugin
{
  private static volatile BigBitmapMonitor a;
  private final BigBitmapMonitor.BitmapMonitorLifecycleCallbacks b = new BigBitmapMonitor.BitmapMonitorLifecycleCallbacks(this);
  private final BigBitmapDetector c = new BigBitmapDetector(new DefaultBitmapSizeChecker());
  private final Set<String> d = new HashSet();
  private final AtomicBoolean e = new AtomicBoolean(false);
  
  private boolean a(String paramString)
  {
    return this.d.contains(paramString);
  }
  
  private void b()
  {
    if (this.e.compareAndSet(false, true))
    {
      this.c.a(new BitmapDrawableSizeProvider());
      this.c.a(new StateListDrawableSizeProvider());
      this.c.a(new RootDrawableSizeProvider());
    }
  }
  
  public static BigBitmapMonitor getInstance()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new BigBitmapMonitor();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void start()
  {
    b();
    stop();
    LifecycleCallback.a(this.b);
  }
  
  public void stop()
  {
    LifecycleCallback.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.BigBitmapMonitor
 * JD-Core Version:    0.7.0.1
 */