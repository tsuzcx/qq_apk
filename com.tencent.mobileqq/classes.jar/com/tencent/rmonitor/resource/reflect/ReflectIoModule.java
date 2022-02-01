package com.tencent.rmonitor.resource.reflect;

import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Method;

public class ReflectIoModule
{
  private Class a = null;
  private Method b = null;
  private int c = 0;
  private boolean d = false;
  
  public long[] a()
  {
    try
    {
      if ((!this.d) && (this.c < 2))
      {
        this.c += 1;
        if (this.a == null) {
          this.a = Class.forName("com.tencent.rmonitor.io.IoCanaryCore");
        }
        if (this.b == null) {
          this.b = this.a.getDeclaredMethod("getIoStatus", new Class[0]);
        }
        this.d = true;
      }
      if (this.d)
      {
        long[] arrayOfLong = (long[])this.b.invoke(null, new Object[0]);
        return arrayOfLong;
      }
    }
    catch (Exception localException)
    {
      this.d = false;
      Logger.b.d(new String[] { "RMonitor_resource_ReflectIoModule", localException.toString(), ": can not reflect Io Module." });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.reflect.ReflectIoModule
 * JD-Core Version:    0.7.0.1
 */