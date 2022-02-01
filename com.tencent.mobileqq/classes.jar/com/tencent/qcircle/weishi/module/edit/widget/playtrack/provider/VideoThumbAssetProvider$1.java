package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.tav.coremedia.CMTime;

class VideoThumbAssetProvider$1
  implements VideoThumbListener
{
  VideoThumbAssetProvider$1(VideoThumbAssetProvider paramVideoThumbAssetProvider) {}
  
  public void onThumbGenerated(Object paramObject, CMTime paramCMTime, Bitmap paramBitmap)
  {
    HandlerUtils.getMainHandler().post(new VideoThumbAssetProvider.1.1(this, paramCMTime, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbAssetProvider.1
 * JD-Core Version:    0.7.0.1
 */