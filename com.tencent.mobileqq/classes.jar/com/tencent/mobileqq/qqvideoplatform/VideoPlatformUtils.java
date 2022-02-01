package com.tencent.mobileqq.qqvideoplatform;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VideoPlatformUtils
{
  public static boolean a(int paramInt, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramInt == 11022003) && (paramVideoPlayParam.mIsLocal) && (!TextUtils.isEmpty(paramVideoPlayParam.mVideoPath)))
    {
      Object localObject = (AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean)QConfigManager.a().a(537);
      if ((localObject != null) && (((AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean)localObject).e)) {
        try
        {
          localObject = new File(paramVideoPlayParam.mVideoPath);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("autoDelBadCache, delete file , path = ");
              ((StringBuilder)localObject).append(paramVideoPlayParam.mVideoPath);
              QLog.d("VideoPlatformUtils", 2, ((StringBuilder)localObject).toString());
            }
            return true;
          }
        }
        catch (Exception paramVideoPlayParam)
        {
          QLog.e("VideoPlatformUtils", 1, "autoDelBadCache error.", paramVideoPlayParam);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.VideoPlatformUtils
 * JD-Core Version:    0.7.0.1
 */