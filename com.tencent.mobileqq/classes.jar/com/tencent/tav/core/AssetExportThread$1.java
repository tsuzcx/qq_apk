package com.tencent.tav.core;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import com.tencent.tav.decoder.logger.Logger;

class AssetExportThread$1
  implements Runnable
{
  AssetExportThread$1(AssetExportThread paramAssetExportThread) {}
  
  public void run()
  {
    if (AssetExportThread.access$000(this.this$0) != null)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        AssetExportThread.access$000(this.this$0).quitSafely();
      } else {
        AssetExportThread.access$000(this.this$0).quit();
      }
      AssetExportThread.access$002(this.this$0, null);
    }
    if (AssetExportThread.access$100(this.this$0) != null)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        AssetExportThread.access$100(this.this$0).quitSafely();
      } else {
        AssetExportThread.access$100(this.this$0).quit();
      }
      AssetExportThread.access$102(this.this$0, null);
    }
    if (AssetExportThread.access$200(this.this$0) != null)
    {
      AssetExportThread.access$200(this.this$0).cancelReading();
      AssetExportThread.access$202(this.this$0, null);
    }
    int i = 0;
    int j = 0;
    if (AssetExportThread.access$300(this.this$0) != null)
    {
      try
      {
        AssetExportThread.access$300(this.this$0).finishWriting();
        i = 1;
      }
      catch (Exception localException)
      {
        Logger.e("AssetExportSession", "code = -10 run: finishWriting error", localException);
        if ((localException instanceof ExportRuntimeException))
        {
          AssetExportThread.access$400(this.this$0, ((ExportRuntimeException)localException).getErrorStatus());
          i = j;
        }
        else
        {
          AssetExportThread.access$500(this.this$0, -10, localException);
          i = j;
        }
      }
      AssetExportThread.access$302(this.this$0, null);
    }
    if (AssetExportThread.access$600(this.this$0) != null) {
      AssetExportThread.access$600(this.this$0).close();
    }
    if (AssetExportThread.access$700(this.this$0) != null) {
      AssetExportThread.access$700(this.this$0).close();
    }
    if ((AssetExportThread.access$800(this.this$0)) && (AssetExportThread.access$900(this.this$0)) && (i != 0) && (!AssetExportThread.access$1000(this.this$0))) {
      AssetExportThread.access$1100(this.this$0);
    }
    if (Build.VERSION.SDK_INT >= 18) {
      this.this$0.quitSafely();
    } else {
      this.this$0.quit();
    }
    if (AssetExportThread.access$1200(this.this$0) != null) {
      AssetExportThread.access$1200(this.this$0).release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.1
 * JD-Core Version:    0.7.0.1
 */