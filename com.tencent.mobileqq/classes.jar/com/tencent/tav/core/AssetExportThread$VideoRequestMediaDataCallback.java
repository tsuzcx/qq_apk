package com.tencent.tav.core;

import android.os.Handler;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.ExportReportSession;

class AssetExportThread$VideoRequestMediaDataCallback
  implements Runnable
{
  private AssetExportThread$VideoRequestMediaDataCallback(AssetExportThread paramAssetExportThread) {}
  
  private void onRequestMediaData()
  {
    while ((!AssetExportThread.access$800(this.this$0)) && (!AssetExportThread.access$1000(this.this$0))) {
      if ((AssetExportThread.access$2200(this.this$0) != null) && (AssetExportThread.access$600(this.this$0).isReadyForMoreMediaData()))
      {
        long l = System.nanoTime();
        localObject1 = AssetExportThread.access$2200(this.this$0).copyNextSampleBuffer();
        Object localObject2 = ((CMSampleBuffer)localObject1).getState();
        if (((CMSampleState)localObject2).getStateCode() >= 0L)
        {
          localObject2 = AssetExportThread.access$600(this.this$0).appendSampleBuffer((CMSampleBuffer)localObject1);
          if (localObject2 != null) {
            AssetExportThread.access$400(this.this$0, (ExportErrorStatus)localObject2);
          }
          if (AssetExportThread.access$2300(this.this$0) != null) {
            AssetExportThread.access$2300(this.this$0).tickExport(System.nanoTime() - l);
          }
          if (((CMSampleBuffer)localObject1).getTime().getTimeUs() >= AssetExportThread.access$1200(this.this$0).timeRange.getEnd().getTimeUs()) {
            AssetExportThread.access$600(this.this$0).markAsFinished();
          }
        }
        else if (((CMSampleState)localObject2).stateMatchingTo(new long[] { -1L }))
        {
          AssetExportThread.access$600(this.this$0).markAsFinished();
        }
        else if (((CMSampleState)localObject2).getStateCode() != -4L)
        {
          AssetExportThread.access$400(this.this$0, new ExportErrorStatus((CMSampleState)localObject2));
        }
      }
    }
    if (AssetExportThread.access$600(this.this$0).matrixFilter != null) {
      AssetExportThread.access$600(this.this$0).matrixFilter.release();
    }
    if (AssetExportThread.access$1200(this.this$0).videoCompositing != null) {
      AssetExportThread.access$1200(this.this$0).videoCompositing.release();
    }
    Object localObject1 = this.this$0;
    AssetExportThread.access$2402((AssetExportThread)localObject1, AssetExportThread.access$1000((AssetExportThread)localObject1) ^ true);
    AssetExportThread.access$2000(this.this$0).sendEmptyMessage(1);
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
      AssetExportThread.access$500(this.this$0, -14, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.VideoRequestMediaDataCallback
 * JD-Core Version:    0.7.0.1
 */