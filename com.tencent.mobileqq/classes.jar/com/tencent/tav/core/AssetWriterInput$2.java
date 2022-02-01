package com.tencent.tav.core;

import android.support.annotation.RequiresApi;
import com.tencent.tav.decoder.EncoderWriter;

class AssetWriterInput$2
  implements Runnable
{
  AssetWriterInput$2(AssetWriterInput paramAssetWriterInput) {}
  
  @RequiresApi(api=18)
  public void run()
  {
    if (AssetWriterInput.access$200(this.this$0) == 1)
    {
      try
      {
        this.this$0.writer.endWriteVideoSample(null, null);
      }
      catch (Throwable localThrowable1)
      {
        if (AssetWriterInput.access$300(this.this$0) != null)
        {
          AssetWriterInput.access$300(this.this$0).onError(new ExportErrorStatus(-123, localThrowable1));
          return;
        }
      }
      if (AssetWriterInput.access$300(this.this$0) != null) {
        AssetWriterInput.access$300(this.this$0).onProgressChanged(this.this$0, -1L);
      }
    }
    else
    {
      try
      {
        this.this$0.writer.endWriteAudioSample();
      }
      catch (Throwable localThrowable2)
      {
        if (AssetWriterInput.access$300(this.this$0) != null)
        {
          AssetWriterInput.access$300(this.this$0).onError(new ExportErrorStatus(-124, localThrowable2));
          return;
        }
      }
      if (AssetWriterInput.access$300(this.this$0) != null) {
        AssetWriterInput.access$300(this.this$0).onProgressChanged(this.this$0, -1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.2
 * JD-Core Version:    0.7.0.1
 */