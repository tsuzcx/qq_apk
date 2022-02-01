package org.light.device;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.light.utils.LightLogUtil;

final class LightDeviceUtils$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
      String str = ((BufferedReader)localObject).readLine();
      ((BufferedReader)localObject).close();
      localObject = str.split(" ");
      StringBuilder localStringBuilder;
      try
      {
        long l1 = Long.parseLong(localObject[2]) + Long.parseLong(localObject[3]) + Long.parseLong(localObject[4]) + Long.parseLong(localObject[6]) + Long.parseLong(localObject[5]) + Long.parseLong(localObject[7]) + Long.parseLong(localObject[8]);
        long l2 = Long.parseLong(localObject[5]);
        if ((LightDeviceUtils.access$100() > 0L) && (LightDeviceUtils.access$200() > 0L) && (l1 != LightDeviceUtils.access$200())) {
          LightDeviceUtils.access$302(1.0F - (float)(l2 - LightDeviceUtils.access$100()) * 1.0F / (float)(l1 - LightDeviceUtils.access$200()));
        }
        LightDeviceUtils.access$102(l2);
        LightDeviceUtils.access$202(l1);
        LightDeviceUtils.access$402(1);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        str = LightDeviceUtils.access$000();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ArrayIndexOutOfBoundsException");
        localStringBuilder.append(localArrayIndexOutOfBoundsException.toString());
        LightLogUtil.e(str, localStringBuilder.toString());
        return;
      }
      return;
    }
    catch (IOException localIOException)
    {
      str = LightDeviceUtils.access$000();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IOException");
      localStringBuilder.append(localIOException.toString());
      LightLogUtil.e(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.LightDeviceUtils.1
 * JD-Core Version:    0.7.0.1
 */