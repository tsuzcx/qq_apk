package com.tencent.qcircle.tavcut.exporter;

import com.tencent.tav.core.AssetExportSession;

class MovieExporter$1$3
  implements Runnable
{
  MovieExporter$1$3(MovieExporter.1 param1, AssetExportSession paramAssetExportSession) {}
  
  public void run()
  {
    if (this.this$1.val$compressListener != null) {
      this.this$1.val$compressListener.onCompressError(this.val$assetExportSession);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.MovieExporter.1.3
 * JD-Core Version:    0.7.0.1
 */