package com.tencent.tav.core;

import android.support.annotation.RequiresApi;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;

class AssetWriterInput$WriterVideoRunnable
  implements Runnable
{
  private final TextureInfo outputTexture;
  private final CMSampleBuffer sampleBuffer;
  
  private AssetWriterInput$WriterVideoRunnable(AssetWriterInput paramAssetWriterInput, CMSampleBuffer paramCMSampleBuffer, TextureInfo paramTextureInfo)
  {
    this.sampleBuffer = paramCMSampleBuffer;
    this.outputTexture = paramTextureInfo;
  }
  
  @RequiresApi(api=18)
  public void run()
  {
    AssetWriterInput.access$500(this.this$0, this.sampleBuffer, this.outputTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterVideoRunnable
 * JD-Core Version:    0.7.0.1
 */