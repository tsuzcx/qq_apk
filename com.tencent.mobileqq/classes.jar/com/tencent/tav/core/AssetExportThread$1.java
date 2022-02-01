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
      if (Build.VERSION.SDK_INT >= 18)
      {
        AssetExportThread.access$000(this.this$0).quitSafely();
        AssetExportThread.access$002(this.this$0, null);
      }
    }
    else if (AssetExportThread.access$100(this.this$0) != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label273;
      }
      AssetExportThread.access$100(this.this$0).quitSafely();
    }
    for (;;)
    {
      AssetExportThread.access$102(this.this$0, null);
      if (AssetExportThread.access$200(this.this$0) != null)
      {
        AssetExportThread.access$200(this.this$0).cancelReading();
        AssetExportThread.access$202(this.this$0, null);
      }
      i = 0;
      j = 0;
      if (AssetExportThread.access$300(this.this$0) != null) {}
      try
      {
        AssetExportThread.access$300(this.this$0).finishWriting();
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e("AssetExportSession", "code = -10 run: finishWriting error", localException);
          AssetExportThread.access$400(this.this$0, -10, localException);
          i = j;
          continue;
          this.this$0.quit();
        }
      }
      AssetExportThread.access$302(this.this$0, null);
      if (AssetExportThread.access$500(this.this$0) != null) {
        AssetExportThread.access$500(this.this$0).close();
      }
      if (AssetExportThread.access$600(this.this$0) != null) {
        AssetExportThread.access$600(this.this$0).close();
      }
      if ((AssetExportThread.access$700(this.this$0)) && (AssetExportThread.access$800(this.this$0)) && (i != 0) && (!AssetExportThread.access$900(this.this$0))) {
        AssetExportThread.access$1000(this.this$0);
      }
      if (Build.VERSION.SDK_INT < 18) {
        break label311;
      }
      this.this$0.quitSafely();
      if (AssetExportThread.access$1100(this.this$0) != null) {
        AssetExportThread.access$1100(this.this$0).release();
      }
      return;
      AssetExportThread.access$000(this.this$0).quit();
      break;
      label273:
      AssetExportThread.access$100(this.this$0).quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread.1
 * JD-Core Version:    0.7.0.1
 */