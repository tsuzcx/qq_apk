package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import mqq.os.MqqHandler;

public class RIJImageOptMonitor
{
  public static void a(ImageRequest paramImageRequest)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new RIJImageOptMonitor.1(paramImageRequest), RIJImageOptConfig.INSTANCE.getMonitorTime());
  }
  
  public static String[] a(String paramString)
  {
    Object localObject = null;
    try
    {
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
      paramString = localObject;
      if (arrayOfInetAddress != null)
      {
        paramString = localObject;
        if (arrayOfInetAddress.length > 0)
        {
          paramString = new String[arrayOfInetAddress.length];
          int i = 0;
          while (i < arrayOfInetAddress.length)
          {
            paramString[i] = arrayOfInetAddress[i].getHostAddress();
            i += 1;
          }
        }
      }
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      QLog.e("RIJImageOptMonitor", 1, paramString.getMessage());
    }
    return null;
  }
  
  public static void b(ImageRequest paramImageRequest)
  {
    ThreadManager.post(new RIJImageOptMonitor.2(paramImageRequest), 2, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJImageOptMonitor
 * JD-Core Version:    0.7.0.1
 */