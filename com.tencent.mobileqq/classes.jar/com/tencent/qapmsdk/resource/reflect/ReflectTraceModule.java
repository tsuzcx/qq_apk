package com.tencent.qapmsdk.resource.reflect;

import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Method;

public class ReflectTraceModule
{
  private static final String TAG = "QAPM_resource_ReflectTraceModule";
  private Method end = null;
  private Method getInstance = null;
  private boolean hasReflectEnd = false;
  private boolean hasReflectPop = false;
  private boolean hasReflectPush = false;
  private Method pop = null;
  private int popReflectCount = 0;
  private Method push = null;
  private int pushReflectCount = 0;
  private Class<?> qapmMonitorThreadLocal = null;
  
  public void endProxy()
  {
    try
    {
      if ((!this.hasReflectEnd) && (this.popReflectCount < 2))
      {
        this.popReflectCount += 1;
        if (this.qapmMonitorThreadLocal == null) {
          this.qapmMonitorThreadLocal = Class.forName("com.tencent.qapmsdk.impl.appstate.QAPMMonitorThreadLocal");
        }
        if (this.getInstance == null) {
          this.getInstance = this.qapmMonitorThreadLocal.getDeclaredMethod("getInstance", new Class[0]);
        }
        if (this.end == null) {
          this.end = this.qapmMonitorThreadLocal.getDeclaredMethod("end", new Class[0]);
        }
        this.hasReflectEnd = true;
      }
      if (this.hasReflectEnd) {
        this.end.invoke(this.getInstance.invoke(null, new Object[0]), new Object[0]);
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_resource_ReflectTraceModule", localException.toString(), ": can not reflect invoke end." });
    }
  }
  
  public void popProxy()
  {
    try
    {
      if ((!this.hasReflectPop) && (this.popReflectCount < 2))
      {
        this.popReflectCount += 1;
        if (this.qapmMonitorThreadLocal == null) {
          this.qapmMonitorThreadLocal = Class.forName("com.tencent.qapmsdk.impl.appstate.QAPMMonitorThreadLocal");
        }
        if (this.getInstance == null) {
          this.getInstance = this.qapmMonitorThreadLocal.getDeclaredMethod("getInstance", new Class[0]);
        }
        if (this.pop == null) {
          this.pop = this.qapmMonitorThreadLocal.getDeclaredMethod("pop", new Class[] { Boolean.TYPE });
        }
        this.hasReflectPop = true;
      }
      if (this.hasReflectPop) {
        this.pop.invoke(this.getInstance.invoke(null, new Object[0]), new Object[] { Boolean.valueOf(true) });
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_resource_ReflectTraceModule", localException.toString(), ": can not reflect invoke pop." });
    }
  }
  
  public void pushProxy(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      if ((!this.hasReflectPush) && (this.pushReflectCount < 2))
      {
        this.pushReflectCount += 1;
        if (this.qapmMonitorThreadLocal == null) {
          this.qapmMonitorThreadLocal = Class.forName("com.tencent.qapmsdk.impl.appstate.QAPMMonitorThreadLocal");
        }
        if (this.getInstance == null) {
          this.getInstance = this.qapmMonitorThreadLocal.getDeclaredMethod("getInstance", new Class[0]);
        }
        if (this.push == null) {
          this.push = this.qapmMonitorThreadLocal.getDeclaredMethod("push", new Class[] { String.class, String.class, Long.TYPE });
        }
        this.hasReflectPush = true;
      }
      if (this.hasReflectPush) {
        this.push.invoke(this.getInstance.invoke(null, new Object[0]), new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
      }
      return;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_resource_ReflectTraceModule", paramString1.toString(), ": can not reflect invoke push." });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.reflect.ReflectTraceModule
 * JD-Core Version:    0.7.0.1
 */