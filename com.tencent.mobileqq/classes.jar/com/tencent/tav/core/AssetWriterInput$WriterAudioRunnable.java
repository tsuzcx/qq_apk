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
    if (AssetWriterInput.access$500(this.this$0) == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.isEndBuffer) {
          continue;
        }
        AssetWriterInput.access$300(this.this$0).endWriteAudioSample();
        l = -1L;
      }
      catch (Throwable localThrowable)
      {
        if (!(localThrowable instanceof ExportRuntimeException)) {
          continue;
        }
        ExportErrorStatus localExportErrorStatus = ((ExportRuntimeException)localThrowable).getErrorStatus();
        if (AssetWriterInput.access$400(this.this$0) == null) {
          continue;
        }
        AssetWriterInput.access$400(this.this$0).onError(localExportErrorStatus);
        return;
        localExportErrorStatus = new ExportErrorStatus(-122, localExportErrorStatus);
        continue;
        long l = -1L;
        continue;
      }
      if (AssetWriterInput.access$400(this.this$0) == null) {
        break;
      }
      AssetWriterInput.access$400(this.this$0).onProgressChanged(this.this$0, l);
      return;
      AssetWriterInput.access$300(this.this$0).writeAudioSample(this.sampleBuffer.getTime().getTimeUs(), this.sampleBuffer.getSampleByteBuffer());
      l = AssetWriterInput.access$300(this.this$0).getAudioPresentationTimeUs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterAudioRunnable
 * JD-Core Version:    0.7.0.1
 */