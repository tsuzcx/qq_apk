package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.bgprobe.BackgroundException;
import com.tencent.mobileqq.config.QConfigureException;
import cooperation.plugin.PluginCrashException;
import java.util.HashSet;

public final class CaughtExceptionReport$2
  extends HashSet<Class>
{
  public CaughtExceptionReport$2(int paramInt)
  {
    super(paramInt);
    add(CaughtQZonePluginException.class);
    add(PluginCrashException.class);
    add(BackgroundException.class);
    add(QConfigureException.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CaughtExceptionReport.2
 * JD-Core Version:    0.7.0.1
 */