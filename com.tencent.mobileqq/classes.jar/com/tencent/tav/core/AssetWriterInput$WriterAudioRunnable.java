package com.tencent.tav.core;

import android.support.annotation.RequiresApi;
import com.tencent.tav.coremedia.CMSampleBuffer;

class AssetWriterInput$WriterAudioRunnable
  implements Runnable
{
  private final boolean isEndBuffer;
  private final CMSampleBuffer sampleBuffer;
  
  private AssetWriterInput$WriterAudioRunnable(AssetWriterInput paramAssetWriterInput, CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    this.sampleBuffer = paramCMSampleBuffer;
    this.isEndBuffer = paramBoolean;
  }
  
  @RequiresApi(api=18)
  public void run()
  {
    AssetWriterInput.access$400(this.this$0, this.sampleBuffer, this.isEndBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterAudioRunnable
 * JD-Core Version:    0.7.0.1
 */