package com.tencent.tavcut.session;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.AssetImageGeneratorResult;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavkit.component.TAVSourceImageGenerator;

class TAVCutVideoSession$16
  implements AssetImageGenerator.ImageGeneratorListener
{
  TAVCutVideoSession$16(TAVCutVideoSession paramTAVCutVideoSession, int paramInt, TAVSourceImageGenerator paramTAVSourceImageGenerator, FrameExtractCallback paramFrameExtractCallback) {}
  
  public void onCompletion(@NonNull CMTime paramCMTime1, @Nullable Bitmap paramBitmap, @Nullable CMTime paramCMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult)
  {
    if (paramAssetImageGeneratorResult == AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded)
    {
      paramCMTime1 = BitmapUtil.scaleBitmap(paramBitmap, this.val$maxSize);
      this.val$imageGenerator.getAssetImageGenerator().release();
      this.val$callback.onFrameExtracted(paramCMTime1);
      return;
    }
    if (paramAssetImageGeneratorResult == AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorCancelled)
    {
      this.val$callback.onExtractCanceled();
      return;
    }
    this.val$callback.onExtractFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.16
 * JD-Core Version:    0.7.0.1
 */