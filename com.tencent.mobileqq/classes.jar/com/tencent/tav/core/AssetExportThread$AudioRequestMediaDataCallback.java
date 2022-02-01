package com.tencent.tav.core;

import android.os.Handler;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;

class AssetExportThread$AudioRequestMediaDataCallback
  implements Runnable
{
  private AssetExportThread$AudioRequestMediaDataCallback(AssetExportThread paramAssetExportThread) {}
  
  private void onAudioRequestMediaData()
  {
    while ((!AssetExportThread.access$900(this.this$0)) && (!AssetExportThread.access$1000(this.this$0))) {
      if ((AssetExportThread.access$2600(this.this$0) != null) && (AssetExportThread.access$700(this.this$0).isReadyForMoreMediaData()))
      {
        AssetExportThread.access$2600(this.this$0).duration();
        localObject1 = AssetExportThread.access$2600(this.this$0).copyNextSampleBuffer();
        Object localObject2 = ((CMSampleBuffer)localObject1).getState();
        if (((CMSampleState)localObject2).getStateCode() >= 0L)
        {
          localObject2 = AssetExportThread.access$700(this.this$0).appendSampleBuffer((CMSampleBuffer)localObject1);
          if (localObject2 != null) {
            AssetExportThread.access$400(this.this$0, (ExportErrorStatus)localObject2);
          }
          if (((CMSampleBuffer)localObject1).getTime().getTimeUs() >= AssetExportThread.access$1200(this.this$0).timeRange.getEnd().getTimeUs()) {
            AssetExportThread.access$700(this.this$0).markAsFinished();
          }
        }
        else if (((CMSampleState)localObject2).getStateCode() == -1L)
        {
          AssetExportThread.access$700(this.this$0).markAsFinished();
        }
        else if (((CMSampleState)localObject2).getStateCode() != -4L)
        {
          AssetExportThread.access$400(this.this$0, new ExportErrorStatus((CMSampleState)localObject2));
        }
      }
    }
    Object localObject1 = this.this$0;
    AssetExportThread.access$2702((AssetExportThread)localObject1, AssetExportThread.access$1000((AssetExportThread)localObject1) ^ true);
    AssetExportThread.access$2000(this.this$0).sendEmptyMessage(2);
  }
  
  public void run()
  {
    try
    {
      onAudioRequestMediaData();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AssetExportThread", "AudioRequestMediaDateCallback run: ", localThrowable);
      AssetExportThread.access$500(this.this$0, -15, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.AudioRequestMediaDataCallback
 * JD-Core Version:    0.7.0.1
 */