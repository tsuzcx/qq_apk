package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoUtils$ShortVideoPlayConfig
{
  private static final String TAG = "ShortVideo.ShortVideoPlayConfig";
  public static boolean sAutoPlayInAIO = true;
  public static boolean sReadFromDPC = false;
  public static int sRequestedFPS = 18;
  
  public static void initConfig()
  {
    Object localObject;
    if (!sReadFromDPC)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.ShortVideoPlayInAIO.name(), null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initConfig(), videoPlayConfig=");
        localStringBuilder.append((String)localObject);
        QLog.d("ShortVideo.ShortVideoPlayConfig", 2, localStringBuilder.toString());
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
    }
    catch (Exception localException)
    {
      label129:
      break label129;
    }
    sRequestedFPS = 18;
    sReadFromDPC = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initVideoPlayConfig(), sReadFromDPC=");
      ((StringBuilder)localObject).append(sReadFromDPC);
      ((StringBuilder)localObject).append(", sAutoPlayInAIO:");
      ((StringBuilder)localObject).append(sAutoPlayInAIO);
      ((StringBuilder)localObject).append(", sRequestedFPS:");
      ((StringBuilder)localObject).append(sRequestedFPS);
      QLog.d("ShortVideo.ShortVideoPlayConfig", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig
 * JD-Core Version:    0.7.0.1
 */