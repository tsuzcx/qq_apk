package com.tencent.xweb.xwalk.updater;

import com.tencent.xweb.a;
import com.tencent.xweb.ae;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class XWebCoreScheduler
  extends Scheduler
{
  static XWebCoreScheduler f;
  
  public static XWebCoreScheduler z()
  {
    if (f == null) {
      f = new XWebCoreScheduler();
    }
    return f;
  }
  
  public c a(a.b paramb)
  {
    if (paramb == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfigDownLoaded get config ,config version is ");
    localStringBuilder.append(paramb.c);
    Log.i("Scheduler", localStringBuilder.toString());
    h.f(paramb.c, true);
    if ((ae.b()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkInitializer.addXWalkInitializeLog(this.b, "it's gp version , dont down load any runtime version");
      return null;
    }
    r();
    return a(d.a(paramb, XWalkEnvironment.getRuntimeAbi()));
  }
  
  public String a()
  {
    return "XWebCore";
  }
  
  protected String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a.a("UPDATE_SPEED_CONFIG", "tools");
    }
    return a.a("UPDATE_FORWARD_SPEED_CONFIG", "tools");
  }
  
  public XWalkUpdater.UpdateConfig c(c paramc)
  {
    try
    {
      boolean bool = paramc.f;
      XWalkUpdater.UpdateConfig localUpdateConfig;
      if (!bool)
      {
        if ((paramc.d != null) && (!paramc.d.isEmpty())) {
          localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.d, false, null, paramc.h, paramc.l, paramc.t, paramc.g);
        } else if (g) {
          localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.h, false, paramc.l, paramc.t, paramc.g);
        } else {
          throw new AssertionError("royle:no md5 info, maybe something wrong");
        }
      }
      else if ((paramc.d != null) && (!paramc.d.isEmpty()) && (paramc.m != null) && (!paramc.m.isEmpty()))
      {
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.m, true, paramc.d, paramc.h, paramc.l, paramc.t, paramc.g);
      }
      else
      {
        if (!g) {
          break label241;
        }
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.h, true, paramc.l, paramc.t, paramc.g);
      }
      localUpdateConfig.versionDetail = paramc.n;
      localUpdateConfig.bUseCdn = paramc.r;
      localUpdateConfig.bTryUseSharedCore = paramc.s;
      localUpdateConfig.scheduler = this;
      return localUpdateConfig;
      label241:
      throw new AssertionError("royle:no md5 info, maybe something wrong");
    }
    catch (Exception paramc)
    {
      label251:
      break label251;
    }
    XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
    return null;
  }
  
  public boolean h()
  {
    try
    {
      boolean bool = super.h();
      if (!bool) {
        return false;
      }
      int i = r().l;
      int j = XWalkEnvironment.getInstalledNewstVersion(r().t);
      return i > j;
    }
    finally {}
  }
  
  protected boolean i()
  {
    if (!XWalkEnvironment.hasInstalledAvailableVersion())
    {
      if (!"true".equalsIgnoreCase(a.a("dis_update_immediately_when_no_xweb", "tools")))
      {
        if (r().o > 0)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.b, " failed update before , do not force update ");
          if (!"true".equalsIgnoreCase(a.a("allow_failed_schedule_force_update", "tools"))) {
            return false;
          }
        }
        XWalkEnvironment.addXWalkInitializeLog(this.b, "isTimeToUpdate no availableversion installed, do start download ");
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.b, " no availableversion but dis_update_immediately_when_no_xweb == true");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.XWebCoreScheduler
 * JD-Core Version:    0.7.0.1
 */