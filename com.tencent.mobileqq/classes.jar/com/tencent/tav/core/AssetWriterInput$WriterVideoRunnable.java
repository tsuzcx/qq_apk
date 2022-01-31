package com.tencent.tav.core;

import android.support.annotation.RequiresApi;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.IDecoder;

class AssetWriterInput$WriterVideoRunnable
  implements Runnable
{
  private final CMSampleBuffer sampleBuffer;
  
  private AssetWriterInput$WriterVideoRunnable(AssetWriterInput paramAssetWriterInput, CMSampleBuffer paramCMSampleBuffer)
  {
    this.sampleBuffer = paramCMSampleBuffer;
  }
  
  @RequiresApi(api=18)
  public void run()
  {
    if (AssetWriterInput.access$500(this.this$0) != null) {}
    try
    {
      AssetWriterInput.access$300(this.this$0).writeVideoSample();
      if ((this.sampleBuffer != null) && (this.sampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_FINISH))) {
        AssetWriterInput.access$300(this.this$0).endWriteVideoSample();
      }
      if (AssetWriterInput.access$400(this.this$0) != null) {
        AssetWriterInput.access$400(this.this$0).onProgressChanged(this.this$0, AssetWriterInput.access$300(this.this$0).getVideoPresentationTimeUs());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (AssetWriterInput.access$400(this.this$0) == null) {}
      AssetWriterInput.access$400(this.this$0).onError(new ExportErrorStatus(-121, localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterVideoRunnable
 * JD-Core Version:    0.7.0.1
 */