package com.tencent.qapmsdk.resource.reflect;

import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Method;

public class ReflectIoModule
{
  private static final String TAG = "QAPM_resource_ReflectIoModule";
  private boolean canReflect = false;
  private Method getIoStatus = null;
  private Class ioCanaryCore = null;
  private int reflectCount = 0;
  
  public long[] getIoStatusProxy()
  {
    try
    {
      if ((!this.canReflect) && (this.reflectCount < 2))
      {
        this.reflectCount += 1;
        if (this.ioCanaryCore == null) {
          this.ioCanaryCore = Class.forName("com.tencent.qapmsdk.io.IOCanaryCore");
        }
        if (this.getIoStatus == null) {
          this.getIoStatus = this.ioCanaryCore.getDeclaredMethod("getIOStatus", new Class[0]);
        }
        this.canReflect = true;
      }
      if (this.canReflect)
      {
        long[] arrayOfLong = (long[])this.getIoStatus.invoke(null, new Object[0]);
        return arrayOfLong;
      }
    }
    catch (Exception localException)
    {
      this.canReflect = false;
      Logger.INSTANCE.d(new String[] { "QAPM_resource_ReflectIoModule", localException.toString(), ": can not reflect Io Module." });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.reflect.ReflectIoModule
 * JD-Core Version:    0.7.0.1
 */