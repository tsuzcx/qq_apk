package com.tencent.tav.core;

import android.os.Handler;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.VideoDecoder;
import com.tencent.tav.decoder.logger.Logger;

class AssetExportThread$AudioRequestMediaDataCallback
  implements Runnable
{
  private AssetExportThread$AudioRequestMediaDataCallback(AssetExportThread paramAssetExportThread) {}
  
  private void onAudioRequestMediaData()
  {
    while ((!AssetExportThread.access$800(this.this$0)) && (!AssetExportThread.access$900(this.this$0))) {
      if ((AssetExportThread.access$2700(this.this$0) != null) && (AssetExportThread.access$600(this.this$0).isReadyForMoreMediaData()))
      {
        AssetExportThread.access$2700(this.this$0).duration();
        localObject = AssetExportThread.access$2700(this.this$0).copyNextSampleBuffer();
        if (((CMSampleBuffer)localObject).getTime().getTimeUs() < 0L) {
          break label174;
        }
        ExportErrorStatus localExportErrorStatus = AssetExportThread.access$600(this.this$0).appendSampleBuffer((CMSampleBuffer)localObject);
        if (localExportErrorStatus != null) {
          AssetExportThread.access$2200(this.this$0, localExportErrorStatus);
        }
        if (((CMSampleBuffer)localObject).getTime().getTimeUs() >= AssetExportThread.access$1100(this.this$0).timeRange.getDuration().getTimeUs()) {
          AssetExportThread.access$600(this.this$0).markAsFinished();
        }
      }
    }
    label138:
    Object localObject = this.this$0;
    if (!AssetExportThread.access$900(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      AssetExportThread.access$2802((AssetExportThread)localObject, bool);
      AssetExportThread.access$1900(this.this$0).sendEmptyMessage(2);
      return;
      label174:
      if (((CMSampleBuffer)localObject).getTime() == VideoDecoder.SAMPLE_TIME_FINISH)
      {
        AssetExportThread.access$600(this.this$0).markAsFinished();
        break label138;
      }
      if (((CMSampleBuffer)localObject).getTime() == VideoDecoder.SAMPLE_TIME_TIMEOUT) {
        break;
      }
      AssetExportThread.access$2500(this.this$0, (int)((CMSampleBuffer)localObject).getTime().getValue());
      break label138;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.AudioRequestMediaDataCallback
 * JD-Core Version:    0.7.0.1
 */