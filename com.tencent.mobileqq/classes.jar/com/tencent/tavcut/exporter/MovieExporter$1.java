package com.tencent.tavcut.exporter;

import android.os.Handler;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tavcut.util.Logger;

class MovieExporter$1
  implements AssetExportSession.ExportCallbackHandler
{
  MovieExporter$1(MovieExporter paramMovieExporter, MovieExporter.VideoCompressListener paramVideoCompressListener, String paramString) {}
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    switch (MovieExporter.3.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[paramAssetExportSession.getStatus().ordinal()])
    {
    default: 
      return;
    case 1: 
      MovieExporter.access$100(this.this$0).post(new MovieExporter.1.1(this, paramAssetExportSession));
      MovieExporter.access$002(this.this$0, true);
      return;
    case 2: 
      Logger.i("MovieExporter", "export progress finished");
      MovieExporter.access$100(this.this$0).post(new MovieExporter.1.2(this));
      MovieExporter.access$002(this.this$0, false);
      return;
    case 3: 
    case 4: 
      Logger.i("MovieExporter", "export error");
      MovieExporter.access$100(this.this$0).post(new MovieExporter.1.3(this, paramAssetExportSession));
      MovieExporter.access$002(this.this$0, false);
      return;
    }
    MovieExporter.access$202(this.this$0, false);
    MovieExporter.access$100(this.this$0).post(new MovieExporter.1.4(this));
    MovieExporter.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.exporter.MovieExporter.1
 * JD-Core Version:    0.7.0.1
 */