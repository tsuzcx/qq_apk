package com.tencent.tav.core;

import android.support.annotation.RequiresApi;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.EncoderWriter;

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
    long l1 = -1L;
    if (AssetWriterInput.access$500(this.this$0) == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.isEndBuffer) {
          AssetWriterInput.access$300(this.this$0).endWriteAudioSample();
        }
        while (AssetWriterInput.access$400(this.this$0) != null)
        {
          AssetWriterInput.access$400(this.this$0).onProgressChanged(this.this$0, l1);
          return;
          AssetWriterInput.access$300(this.this$0).writeAudioSample(this.sampleBuffer.getTime().getTimeUs(), this.sampleBuffer.getSampleByteBuffer());
          long l2 = AssetWriterInput.access$300(this.this$0).getAudioPresentationTimeUs();
          l1 = l2;
        }
      }
      catch (Throwable localThrowable)
      {
        while (AssetWriterInput.access$400(this.this$0) == null) {}
        AssetWriterInput.access$400(this.this$0).onError(new ExportErrorStatus(-122, localThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterAudioRunnable
 * JD-Core Version:    0.7.0.1
 */