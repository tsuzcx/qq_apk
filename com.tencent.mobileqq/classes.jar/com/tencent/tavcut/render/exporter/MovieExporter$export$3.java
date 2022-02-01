package com.tencent.tavcut.render.exporter;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"}, k=3, mv={1, 1, 16})
final class MovieExporter$export$3
  implements AssetExportSession.ExportCallbackHandler
{
  MovieExporter$export$3(MovieExporter paramMovieExporter, File paramFile) {}
  
  public final void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    MovieExporter localMovieExporter = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramAssetExportSession, "assetExportSession");
    String str = this.b.getAbsolutePath();
    Intrinsics.checkExpressionValueIsNotNull(str, "destFile.absolutePath");
    localMovieExporter.a(paramAssetExportSession, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.exporter.MovieExporter.export.3
 * JD-Core Version:    0.7.0.1
 */