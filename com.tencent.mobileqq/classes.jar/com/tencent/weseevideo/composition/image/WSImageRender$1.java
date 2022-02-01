package com.tencent.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.util.DurationUtil;

class WSImageRender$1
  implements AssetImageGenerator.ImageGeneratorListener
{
  WSImageRender$1(WSImageRender paramWSImageRender, WSImageRender.ImageRenderCallback paramImageRenderCallback) {}
  
  public void onCompletion(@NonNull CMTime paramCMTime1, @Nullable Bitmap paramBitmap, @Nullable CMTime paramCMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult)
  {
    DurationUtil.end("image render");
    if (paramBitmap != null) {
      this.val$callback.onCompletion(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.WSImageRender.1
 * JD-Core Version:    0.7.0.1
 */