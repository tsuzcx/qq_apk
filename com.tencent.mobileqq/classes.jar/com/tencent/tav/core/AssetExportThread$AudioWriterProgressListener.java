package com.tencent.tav.core;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;

class AssetExportThread$AudioWriterProgressListener
  implements AssetWriterInput.WriterProgressListener
{
  private AssetExportThread$AudioWriterProgressListener(AssetExportThread paramAssetExportThread) {}
  
  public void onError(@NonNull ExportErrorStatus paramExportErrorStatus)
  {
    Logger.e("AssetExportThread", "AudioWriterProgressListener onError: ", paramExportErrorStatus.throwable);
    AssetExportThread.access$400(this.this$0, paramExportErrorStatus);
  }
  
  public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
  {
    paramAssetWriterInput = new StringBuilder();
    paramAssetWriterInput.append("onProgressChanged: audioWriter ");
    paramAssetWriterInput.append(paramLong);
    paramAssetWriterInput.append("  / ");
    paramAssetWriterInput.append(AssetExportThread.access$1800(this.this$0));
    Logger.i("AssetExportSession", paramAssetWriterInput.toString());
    if (paramLong == -1L)
    {
      paramAssetWriterInput = this.this$0;
      AssetExportThread.access$2502(paramAssetWriterInput, AssetExportThread.access$1200(paramAssetWriterInput).timeRange.getDuration().getTimeUs());
      AssetExportThread.access$902(this.this$0, true);
      AssetExportThread.access$2000(this.this$0).sendEmptyMessage(2);
      return;
    }
    AssetExportThread.access$2502(this.this$0, paramLong);
    AssetExportThread.access$2100(this.this$0);
    if (((AssetExportThread.access$2500(this.this$0) > AssetExportThread.access$1900(this.this$0)) && (AssetExportThread.access$800(this.this$0))) || (AssetExportThread.access$2500(this.this$0) >= AssetExportThread.access$1200(this.this$0).timeRange.getEnd().getTimeUs()))
    {
      paramAssetWriterInput = this.this$0;
      AssetExportThread.access$2502(paramAssetWriterInput, AssetExportThread.access$1200(paramAssetWriterInput).timeRange.getDuration().getTimeUs());
      AssetExportThread.access$902(this.this$0, true);
      AssetExportThread.access$2000(this.this$0).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.AudioWriterProgressListener
 * JD-Core Version:    0.7.0.1
 */