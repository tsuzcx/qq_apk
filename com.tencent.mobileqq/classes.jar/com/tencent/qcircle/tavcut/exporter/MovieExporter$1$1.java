package com.tencent.qcircle.tavcut.exporter;

import com.tencent.tav.core.AssetExportSession;

class MovieExporter$1$1
  implements Runnable
{
  MovieExporter$1$1(MovieExporter.1 param1, AssetExportSession paramAssetExportSession) {}
  
  public void run()
  {
    if (this.this$1.val$compressListener != null)
    {
      if (!MovieExporter.access$000(this.this$1.this$0)) {
        this.this$1.val$compressListener.onCompressStart();
      }
      this.this$1.val$compressListener.onCompressing(this.val$assetExportSession.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.MovieExporter.1.1
 * JD-Core Version:    0.7.0.1
 */