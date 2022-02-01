package com.tencent.rmonitor;

import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.RMonitorUtil;
import com.tencent.rmonitor.manager.RMonitorLauncher;
import com.tencent.rmonitor.sla.SLAHelper;
import java.util.Locale;

public class Magnifier
{
  private static volatile boolean a = false;
  
  protected static void a()
  {
    if (RMonitorUtil.a())
    {
      a(3, 0);
      return;
    }
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("abolish fail, app: ");
    localStringBuilder.append(BaseInfo.app);
    localStringBuilder.append(", userMeta: ");
    localStringBuilder.append(BaseInfo.userMeta);
    localLogger.e(new String[] { "RMonitor_Magnifier", localStringBuilder.toString() });
  }
  
  protected static void a(int paramInt)
  {
    if (RMonitorUtil.a())
    {
      if ((PluginController.a & paramInt) != 0) {
        a(2, paramInt);
      }
    }
    else
    {
      Logger localLogger = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopMonitors fail, userMode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", app: ");
      localStringBuilder.append(BaseInfo.app);
      localStringBuilder.append(", userMeta: ");
      localStringBuilder.append(BaseInfo.userMeta);
      localLogger.e(new String[] { "RMonitor_Magnifier", localStringBuilder.toString() });
    }
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    RMonitorUtil.a(new Magnifier.1(paramInt1, paramInt2));
  }
  
  protected static void a(int paramInt, boolean paramBoolean)
  {
    if (RMonitorUtil.a()) {
      try
      {
        if ((a) && (!paramBoolean) && ((PluginController.a & paramInt) == paramInt))
        {
          Logger localLogger = Logger.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startMonitors, userMode: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" has started yet.");
          localLogger.i(new String[] { "RMonitor_Magnifier", localStringBuilder.toString() });
        }
        else
        {
          if (!a) {
            a = true;
          }
          a(1, paramInt);
        }
        return;
      }
      finally {}
    }
    String str = String.format(Locale.getDefault(), "startMonitors fail, app: %s, userMeta: %s", new Object[] { BaseInfo.app, BaseInfo.userMeta });
    Logger.b.e(new String[] { "RMonitor_Magnifier", str });
  }
  
  protected static QAPMMonitorPlugin b(int paramInt)
  {
    SLAHelper.a().c();
    QAPMMonitorPlugin localQAPMMonitorPlugin = RMonitorLauncher.a.c(paramInt);
    SLAHelper.a().d();
    return localQAPMMonitorPlugin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.Magnifier
 * JD-Core Version:    0.7.0.1
 */