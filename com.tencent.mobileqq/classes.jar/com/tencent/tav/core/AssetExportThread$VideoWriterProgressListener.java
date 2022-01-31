package com.tencent.tav.core;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;

class AssetExportThread$VideoWriterProgressListener
  implements AssetWriterInput.WriterProgressListener
{
  private AssetExportThread$VideoWriterProgressListener(AssetExportThread paramAssetExportThread) {}
  
  public void onError(@NonNull ExportErrorStatus paramExportErrorStatus)
  {
    Logger.e("AssetExportThread", "VideoWriterProgressListener onError: ", paramExportErrorStatus.throwable);
    AssetExportThread.access$2200(this.this$0, paramExportErrorStatus);
  }
  
  public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
  {
    Logger.e("AssetExportSession", "onProgressChanged: videoWriter " + paramLong + "  / " + AssetExportThread.access$1700(this.this$0));
    if (paramLong == -1L)
    {
      AssetExportThread.access$1802(this.this$0, AssetExportThread.access$1100(this.this$0).timeRange.getDuration().getTimeUs());
      AssetExportThread.access$702(this.this$0, true);
      AssetExportThread.access$1900(this.this$0).sendEmptyMessage(1);
    }
    do
    {
      return;
      AssetExportThread.access$1802(this.this$0, paramLong);
      paramLong = AssetExportThread.access$1700(this.this$0);
      if (paramLong != 0L) {
        AssetExportThread.access$1100(this.this$0).progress = ((float)(AssetExportThread.access$1800(this.this$0) + AssetExportThread.access$2000(this.this$0)) * 1.0F / (float)paramLong);
      }
    } while (AssetExportThread.access$2100(this.this$0) == null);
    AssetExportThread.access$2100(this.this$0).handlerCallback(AssetExportThread.access$1100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.VideoWriterProgressListener
 * JD-Core Version:    0.7.0.1
 */