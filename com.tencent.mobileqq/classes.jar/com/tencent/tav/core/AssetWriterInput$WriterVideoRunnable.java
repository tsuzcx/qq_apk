package com.tencent.tav.core;

import android.support.annotation.RequiresApi;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.decoder.EncoderWriter;

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
    for (;;)
    {
      try
      {
        AssetWriterInput.access$300(this.this$0).writeVideoSample();
        if (this.sampleBuffer != null) {
          if (this.sampleBuffer.getState().stateMatchingTo(new long[] { -1L })) {
            AssetWriterInput.access$300(this.this$0).endWriteVideoSample();
          }
        }
        if (AssetWriterInput.access$400(this.this$0) != null) {
          AssetWriterInput.access$400(this.this$0).onProgressChanged(this.this$0, AssetWriterInput.access$300(this.this$0).getVideoPresentationTimeUs());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        if (!(localThrowable instanceof ExportRuntimeException)) {}
      }
      for (ExportErrorStatus localExportErrorStatus = ((ExportRuntimeException)localThrowable).getErrorStatus(); AssetWriterInput.access$400(this.this$0) != null; localExportErrorStatus = new ExportErrorStatus(-121, localExportErrorStatus))
      {
        AssetWriterInput.access$400(this.this$0).onError(localExportErrorStatus);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterVideoRunnable
 * JD-Core Version:    0.7.0.1
 */