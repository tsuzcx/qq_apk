package com.tencent.tav.core;

import android.os.Handler;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.VideoDecoder;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.ExportReportSession;

class AssetExportThread$VideoRequestMediaDataCallback
  implements Runnable
{
  private AssetExportThread$VideoRequestMediaDataCallback(AssetExportThread paramAssetExportThread) {}
  
  private void onRequestMediaData()
  {
    while ((!AssetExportThread.access$700(this.this$0)) && (!AssetExportThread.access$900(this.this$0))) {
      if ((AssetExportThread.access$2300(this.this$0) != null) && (AssetExportThread.access$500(this.this$0).isReadyForMoreMediaData()))
      {
        long l = System.nanoTime();
        localObject = AssetExportThread.access$2300(this.this$0).copyNextSampleBuffer();
        if (((CMSampleBuffer)localObject).getTime().getTimeUs() >= 0L)
        {
          localObject = AssetExportThread.access$500(this.this$0).appendSampleBuffer((CMSampleBuffer)localObject);
          if (localObject != null) {
            AssetExportThread.access$2200(this.this$0, (ExportErrorStatus)localObject);
          }
          if (AssetExportThread.access$2400(this.this$0) != null) {
            AssetExportThread.access$2400(this.this$0).tickExport(System.nanoTime() - l);
          }
        }
        else
        {
          if (((CMSampleBuffer)localObject).getTime() != VideoDecoder.SAMPLE_TIME_FINISH) {
            break label241;
          }
          AssetExportThread.access$500(this.this$0).markAsFinished();
        }
      }
    }
    label149:
    if (AssetExportThread.access$500(this.this$0).matrixFilter != null) {
      AssetExportThread.access$500(this.this$0).matrixFilter.release();
    }
    if (AssetExportThread.access$1100(this.this$0).videoCompositing != null) {
      AssetExportThread.access$1100(this.this$0).videoCompositing.release();
    }
    Object localObject = this.this$0;
    if (!AssetExportThread.access$900(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      AssetExportThread.access$2602((AssetExportThread)localObject, bool);
      AssetExportThread.access$1900(this.this$0).sendEmptyMessage(1);
      return;
      label241:
      if (((CMSampleBuffer)localObject).getTime() == VideoDecoder.SAMPLE_TIME_TIMEOUT) {
        break;
      }
      AssetExportThread.access$2500(this.this$0, (int)((CMSampleBuffer)localObject).getTime().getValue());
      break label149;
    }
  }
  
  public void run()
  {
    try
    {
      onRequestMediaData();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AssetExportThread", "VideoRequestMediaDateCallback run: ", localThrowable);
      AssetExportThread.access$400(this.this$0, -14, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.VideoRequestMediaDataCallback
 * JD-Core Version:    0.7.0.1
 */