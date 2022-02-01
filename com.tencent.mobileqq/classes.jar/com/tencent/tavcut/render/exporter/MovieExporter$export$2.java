package com.tencent.tavcut.render.exporter;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ErrorInterceptor;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "index", "", "needRetry"}, k=3, mv={1, 1, 16})
final class MovieExporter$export$2
  implements AssetExportSession.ErrorInterceptor
{
  MovieExporter$export$2(MovieExporter paramMovieExporter) {}
  
  public final boolean needRetry(AssetExportSession paramAssetExportSession, int paramInt)
  {
    paramAssetExportSession = MovieExporter.a(this.a);
    return (paramAssetExportSession != null) && (paramAssetExportSession.a(paramInt) == true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.exporter.MovieExporter.export.2
 * JD-Core Version:    0.7.0.1
 */