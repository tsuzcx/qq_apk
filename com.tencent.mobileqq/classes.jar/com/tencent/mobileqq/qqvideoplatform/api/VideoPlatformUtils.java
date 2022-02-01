package com.tencent.mobileqq.qqvideoplatform.api;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
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
            if (QLog.isColorLevel()) {
              QLog.d("VideoPlatformUtils", 0, "autoDelBadCache, delete file , path = " + paramVideoPlayParam.mVideoPath);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.VideoPlatformUtils
 * JD-Core Version:    0.7.0.1
 */