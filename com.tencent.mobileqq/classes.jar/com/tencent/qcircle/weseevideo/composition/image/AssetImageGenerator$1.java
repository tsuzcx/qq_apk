package com.tencent.qcircle.weseevideo.composition.image;

import android.graphics.Bitmap;
import com.tencent.qcircle.weseevideo.composition.TAVAutomaticTransRenderContext;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AssetImageGenerator$1
  implements Runnable
{
  AssetImageGenerator$1(AssetImageGenerator paramAssetImageGenerator, List paramList, RenderContext paramRenderContext, AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener) {}
  
  public void run()
  {
    Iterator localIterator = this.val$requestedTimes.iterator();
    while (localIterator.hasNext())
    {
      CMTime localCMTime = (CMTime)localIterator.next();
      Object localObject = null;
      try
      {
        Bitmap localBitmap = this.this$0.copyCGImageAtTimeAndActualTime(localCMTime, null, this.val$renderContext);
        localObject = localBitmap;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Logger.e(AssetImageGenerator.access$000(this.this$0), "generate bitmap failed", localException);
      }
      if (this.val$listener != null)
      {
        ArrayList localArrayList = new ArrayList();
        if (AssetImageGenerator.access$100(this.this$0) != null) {
          localArrayList = new ArrayList(AssetImageGenerator.access$100(this.this$0).getImgInScrPoints());
        }
        AssetImageGenerator.ImageGeneratorListener localImageGeneratorListener = this.val$listener;
        AssetImageGenerator.AssetImageGeneratorResult localAssetImageGeneratorResult;
        if (localObject != null) {
          localAssetImageGeneratorResult = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded;
        } else {
          localAssetImageGeneratorResult = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorFailed;
        }
        localImageGeneratorListener.onCompletion(localCMTime, localObject, localArrayList, null, localAssetImageGeneratorResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator.1
 * JD-Core Version:    0.7.0.1
 */