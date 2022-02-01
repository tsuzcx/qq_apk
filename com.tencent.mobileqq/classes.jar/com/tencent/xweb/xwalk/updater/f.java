package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public class f
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  public static boolean d = true;
  private static boolean e = false;
  private static f f;
  XWalkInitializer a;
  XWalkUpdater b;
  Context c;
  
  public f(Context paramContext)
  {
    this.c = paramContext;
    this.a = new XWalkInitializer(this, paramContext);
    this.b = new XWalkUpdater(this, paramContext);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = e;
    if (bool) {
      return bool;
    }
    e = true;
    f = new f(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode()) {
      return f.b();
    }
    return false;
  }
  
  public static boolean c()
  {
    if (e)
    {
      f localf = f;
      if (localf != null) {
        return localf.a().isXWalkReady();
      }
    }
    return false;
  }
  
  public XWalkInitializer a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    if (!d)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("UpdaterCheckType", "0");
      new g(this.b, localHashMap).execute(new String[0]);
    }
    return this.a.tryInitSync();
  }
  
  public void onXWalkInitCancelled() {}
  
  public void onXWalkInitCompleted() {}
  
  public void onXWalkInitFailed() {}
  
  public void onXWalkInitStarted() {}
  
  public void onXWalkUpdateCancelled() {}
  
  public void onXWalkUpdateCompleted(Scheduler paramScheduler)
  {
    g.a(paramScheduler);
  }
  
  public void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler)
  {
    g.a(paramInt, paramScheduler);
  }
  
  public void onXWalkUpdateProgress(int paramInt) {}
  
  public void onXWalkUpdateStarted()
  {
    g.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.f
 * JD-Core Version:    0.7.0.1
 */