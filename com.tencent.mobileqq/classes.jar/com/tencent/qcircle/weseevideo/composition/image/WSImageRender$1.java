package com.tencent.qcircle.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.tav.coremedia.CMTime;
import java.util.List;

class WSImageRender$1
  implements AssetImageGenerator.ImageGeneratorListener
{
  WSImageRender$1(WSImageRender paramWSImageRender, WSImageRender.ImageRenderCallback paramImageRenderCallback) {}
  
  public void onCompletion(@NonNull CMTime paramCMTime1, @Nullable Bitmap paramBitmap, @Nullable List<PointF> paramList, @Nullable CMTime paramCMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult)
  {
    DurationUtil.end("image render");
    this.val$callback.onCompletion(paramBitmap, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.image.WSImageRender.1
 * JD-Core Version:    0.7.0.1
 */