package com.tencent.mobileqq.winkpublish.service.video.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import common.config.service.QzoneConfig;

public class PublishVideoCommonUtils
{
  public static PublishVideoCommonUtils.VideoSupport a()
  {
    Object localObject = QzoneConfig.getInstance();
    int i = 1;
    if (((QzoneConfig)localObject).getConfig("MiniVideo", "videoTrimEnableHw", 1) != 1) {
      return PublishVideoCommonUtils.VideoSupport.c;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideoHW", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() severBlackList");
      }
      return PublishVideoCommonUtils.VideoSupport.c;
    }
    int j = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Build.Model=");
      ((StringBuilder)localObject).append(Build.MODEL);
      QLog.d("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((j > 0) && ("GT-N7100|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localBlackList");
      }
      return PublishVideoCommonUtils.VideoSupport.c;
    }
    j = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersionHw", 18);
    int k = Build.VERSION.SDK_INT;
    if (k < j)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTrimHWSupport() localSdkVersion=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" serverSdkVersion=");
        ((StringBuilder)localObject).append(j);
        QLog.i("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
      }
      return PublishVideoCommonUtils.VideoSupport.e;
    }
    j = MediaCodecSupport.checkSupportMediaCodecFeature(HostUIHelper.getInstance().getHostApplicationContext());
    if (((j & 0x1) <= 0) || ((j & 0x2) <= 0)) {
      i = 0;
    }
    if (i == 0) {
      return PublishVideoCommonUtils.VideoSupport.h;
    }
    return PublishVideoCommonUtils.VideoSupport.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.util.PublishVideoCommonUtils
 * JD-Core Version:    0.7.0.1
 */