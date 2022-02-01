package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoUtils$ShortVideoPlayConfig
{
  private static final String TAG = "ShortVideo.ShortVideoPlayConfig";
  public static boolean sAutoPlayInAIO = true;
  public static boolean sReadFromDPC;
  public static int sRequestedFPS = 18;
  
  public static void initConfig()
  {
    Object localObject;
    if (!sReadFromDPC)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.ShortVideoPlayInAIO.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initConfig(), videoPlayConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 2))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            sAutoPlayInAIO = localObject[0].equals("1");
          }
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      sRequestedFPS = Integer.parseInt(localObject[1]);
      sReadFromDPC = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initVideoPlayConfig(), sReadFromDPC=" + sReadFromDPC + ", sAutoPlayInAIO:" + sAutoPlayInAIO + ", sRequestedFPS:" + sRequestedFPS);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        sRequestedFPS = 18;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig
 * JD-Core Version:    0.7.0.1
 */