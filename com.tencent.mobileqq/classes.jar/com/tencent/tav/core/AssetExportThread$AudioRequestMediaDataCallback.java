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
    Object localObject2;
    while ((!AssetExportThread.access$800(this.this$0)) && (!AssetExportThread.access$900(this.this$0))) {
      if ((AssetExportThread.access$2600(this.this$0) != null) && (AssetExportThread.access$600(this.this$0).isReadyForMoreMediaData()))
      {
        AssetExportThread.access$2600(this.this$0).duration();
        localObject1 = AssetExportThread.access$2600(this.this$0).copyNextSampleBuffer();
        localObject2 = ((CMSampleBuffer)localObject1).getState();
        if (((CMSampleState)localObject2).getStateCode() < 0L) {
          break label176;
        }
        localObject2 = AssetExportThread.access$600(this.this$0).appendSampleBuffer((CMSampleBuffer)localObject1);
        if (localObject2 != null) {
          AssetExportThread.access$2200(this.this$0, (ExportErrorStatus)localObject2);
        }
        if (((CMSampleBuffer)localObject1).getTime().getTimeUs() >= AssetExportThread.access$1100(this.this$0).timeRange.getDuration().getTimeUs()) {
          AssetExportThread.access$600(this.this$0).markAsFinished();
        }
      }
    }
    label140:
    Object localObject1 = this.this$0;
    if (!AssetExportThread.access$900(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      AssetExportThread.access$2702((AssetExportThread)localObject1, bool);
      AssetExportThread.access$1900(this.this$0).sendEmptyMessage(2);
      return;
      label176:
      if (((CMSampleState)localObject2).getStateCode() == -1L)
      {
        AssetExportThread.access$600(this.this$0).markAsFinished();
        break label140;
      }
      if (((CMSampleState)localObject2).getStateCode() == -4L) {
        break;
      }
      AssetExportThread.access$2200(this.this$0, new ExportErrorStatus((CMSampleState)localObject2));
      break label140;
    }
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
      AssetExportThread.access$400(this.this$0, -15, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.AudioRequestMediaDataCallback
 * JD-Core Version:    0.7.0.1
 */