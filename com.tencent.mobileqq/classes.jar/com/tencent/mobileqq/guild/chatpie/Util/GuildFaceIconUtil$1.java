package com.tencent.mobileqq.guild.chatpie.Util;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

final class GuildFaceIconUtil$1
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
    }
    if (paramBitmap == null) {
      return null;
    }
    paramDownloadParams = paramDownloadParams.tag;
    if ((paramDownloadParams instanceof int[]))
    {
      paramDownloadParams = (int[])paramDownloadParams;
      if (paramDownloadParams.length == 2) {
        return BaseImageUtil.a(paramBitmap, 0.0F, paramDownloadParams[0], paramDownloadParams[1]);
      }
    }
    return BaseImageUtil.c(paramBitmap, 50, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.Util.GuildFaceIconUtil.1
 * JD-Core Version:    0.7.0.1
 */