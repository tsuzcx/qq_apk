package com.tencent.mobileqq.statistics;

import android.database.sqlite.SQLiteException;
import com.tencent.hippy.qq.exception.QQHippyException;
import com.tencent.mobileqq.bgprobe.BackgroundException;
import com.tencent.mobileqq.config.QConfigureException;
import cooperation.plugin.PluginCrashException;
import java.util.HashSet;

final class CaughtExceptionReport$2
  extends HashSet<Class>
{
  CaughtExceptionReport$2(int paramInt)
  {
    super(paramInt);
    add(CaughtQZonePluginException.class);
    add(PluginCrashException.class);
    add(BackgroundException.class);
    add(QConfigureException.class);
    add(QQHippyException.class);
    add(SQLiteException.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CaughtExceptionReport.2
 * JD-Core Version:    0.7.0.1
 */