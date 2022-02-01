package com.tencent.mobileqq.qqlive.utils;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.UUID;

public class MachineUtil
{
  public static String a()
  {
    Object localObject1 = "";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("35");
    ((StringBuilder)localObject2).append(Build.BOARD.length() % 10);
    ((StringBuilder)localObject2).append(Build.BRAND.length() % 10);
    ((StringBuilder)localObject2).append(Build.CPU_ABI.length() % 10);
    ((StringBuilder)localObject2).append(Build.DEVICE.length() % 10);
    ((StringBuilder)localObject2).append(Build.DISPLAY.length() % 10);
    ((StringBuilder)localObject2).append(Build.HOST.length() % 10);
    ((StringBuilder)localObject2).append(Build.ID.length() % 10);
    ((StringBuilder)localObject2).append(Build.MANUFACTURER.length() % 10);
    ((StringBuilder)localObject2).append(Build.MODEL.length() % 10);
    ((StringBuilder)localObject2).append(Build.PRODUCT.length() % 10);
    ((StringBuilder)localObject2).append(Build.TAGS.length() % 10);
    ((StringBuilder)localObject2).append(Build.TYPE.length() % 10);
    ((StringBuilder)localObject2).append(Build.USER.length() % 10);
    String str = ((StringBuilder)localObject2).toString();
    try
    {
      localObject2 = Build.class.getField("SERIAL").get(null).toString();
      localObject1 = localObject2;
      localObject2 = new UUID(str.hashCode(), ((String)localObject2).hashCode()).toString();
      return localObject2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MachineUtil", 1, "makeDeviceId error, ", localException);
      }
    }
    return new UUID(str.hashCode(), ((String)localObject1).hashCode()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.MachineUtil
 * JD-Core Version:    0.7.0.1
 */