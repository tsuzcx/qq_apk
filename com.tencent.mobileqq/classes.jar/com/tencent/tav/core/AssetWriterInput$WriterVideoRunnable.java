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
    if (AssetWriterInput.access$500(this.this$0) != null)
    {
      Object localObject;
      try
      {
        AssetWriterInput.access$300(this.this$0).writeVideoSample();
        if (this.sampleBuffer != null) {
          if (this.sampleBuffer.getState().stateMatchingTo(new long[] { -1L })) {
            AssetWriterInput.access$300(this.this$0).endWriteVideoSample();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        if ((localThrowable instanceof ExportRuntimeException)) {
          localObject = ((ExportRuntimeException)localThrowable).getErrorStatus();
        } else {
          localObject = new ExportErrorStatus(-121, (Throwable)localObject);
        }
        if (AssetWriterInput.access$400(this.this$0) != null)
        {
          AssetWriterInput.access$400(this.this$0).onError((ExportErrorStatus)localObject);
          return;
        }
      }
      if (AssetWriterInput.access$400(this.this$0) != null)
      {
        localObject = AssetWriterInput.access$400(this.this$0);
        AssetWriterInput localAssetWriterInput = this.this$0;
        ((AssetWriterInput.WriterProgressListener)localObject).onProgressChanged(localAssetWriterInput, AssetWriterInput.access$300(localAssetWriterInput).getVideoPresentationTimeUs());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterVideoRunnable
 * JD-Core Version:    0.7.0.1
 */