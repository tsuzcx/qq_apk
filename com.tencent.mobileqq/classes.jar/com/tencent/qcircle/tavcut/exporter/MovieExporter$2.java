package com.tencent.qcircle.tavcut.exporter;

import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;

class MovieExporter$2
  implements AssetExportSession.ExportCallbackHandler
{
  MovieExporter$2(MovieExporter paramMovieExporter, String paramString) {}
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    int i = MovieExporter.3.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[paramAssetExportSession.getStatus().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 5) {
            return;
          }
          Logger.i("MovieExporter", "export cancel");
          if ((MovieExporter.access$300(this.this$0) != null) && (MovieExporter.access$500(this.this$0)))
          {
            MovieExporter.access$502(this.this$0, false);
            MovieExporter.access$300(this.this$0).onExportCancel();
          }
          MovieExporter.access$402(this.this$0, false);
          return;
        }
        Logger.i("MovieExporter", "export error");
        if (MovieExporter.access$300(this.this$0) != null) {
          MovieExporter.access$300(this.this$0).onExportError(paramAssetExportSession);
        }
        MovieExporter.access$402(this.this$0, false);
        return;
      }
      Logger.i("MovieExporter", "export progress finished");
      if (MovieExporter.access$300(this.this$0) != null) {
        MovieExporter.access$300(this.this$0).onExportCompleted(this.val$outputPath);
      }
      MovieExporter.access$402(this.this$0, false);
      return;
    }
    if (MovieExporter.access$300(this.this$0) != null)
    {
      if (!MovieExporter.access$400(this.this$0)) {
        MovieExporter.access$300(this.this$0).onExportStart();
      }
      MovieExporter.access$300(this.this$0).onExporting(paramAssetExportSession.getProgress());
    }
    MovieExporter.access$402(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.MovieExporter.2
 * JD-Core Version:    0.7.0.1
 */