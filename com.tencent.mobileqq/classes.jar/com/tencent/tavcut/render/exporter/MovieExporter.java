package com.tencent.tavcut.render.exporter;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus;
import com.tencent.tav.core.AssetExportSession.ErrorInterceptor;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.render.RenderConfig;
import com.tencent.tavcut.render.builder.IMediaBuilder;
import com.tencent.tavcut.render.builder.IMediaBuilderListener;
import com.tencent.tavcut.render.builder.MediaBuildFactory;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/exporter/MovieExporter;", "Lcom/tencent/tavcut/render/exporter/IExporter;", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "(Lcom/tencent/tavcut/rendermodel/RenderModel;)V", "canceled", "", "errorInterceptor", "Lcom/tencent/tavcut/render/exporter/IExporter$ExportErrorInterceptor;", "exportListener", "Lcom/tencent/tavcut/render/exporter/IExporter$ExportListener;", "exportRenderChainManager", "Lcom/tencent/tavcut/render/IRenderChainManager;", "exportSession", "Lcom/tencent/tav/core/AssetExportSession;", "exporting", "cancelExport", "", "export", "exportOutput", "Lcom/tencent/tavcut/render/exporter/ExportOutput;", "destPath", "", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "destFile", "Ljava/io/File;", "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "export$lib_tavcut_release", "handleExportSessionStatus", "assetExportSession", "handleExportSessionStatus$lib_tavcut_release", "isCanceled", "isExporting", "newOutputFile", "outputPath", "release", "setErrorInterceptor", "setExportListener", "listener", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MovieExporter
  implements IExporter
{
  public static final MovieExporter.Companion a = new MovieExporter.Companion(null);
  private IExporter.ExportErrorInterceptor b;
  private IExporter.ExportListener c;
  private AssetExportSession d;
  private boolean e;
  private boolean f;
  private IRenderChainManager g;
  private final RenderModel h;
  
  public MovieExporter(@NotNull RenderModel paramRenderModel)
  {
    this.h = paramRenderModel;
  }
  
  private final File a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (Exception paramString)
    {
      TavLogger.a("MovieExporter", "export: ", (Throwable)paramString);
    }
    return null;
  }
  
  private final void a(ExportOutput paramExportOutput, RenderModel paramRenderModel, String paramString)
  {
    if (paramRenderModel.getRoot() == null)
    {
      paramExportOutput = this.c;
      if (paramExportOutput != null) {
        paramExportOutput.a(-1, (Throwable)new IllegalArgumentException("RenderModel not complete"));
      }
      return;
    }
    IRenderChainManager localIRenderChainManager = this.g;
    if (localIRenderChainManager != null) {
      localIRenderChainManager.a();
    }
    MediaBuildFactory.a.a(RenderConfig.a.b()).a("/", RenderModel.copy$default(paramRenderModel, RenderScene.EXPORTER, null, null, null, null, false, 0, null, null, null, 0L, 0, null, 8190, null), (IMediaBuilderListener)new MovieExporter.export.1(this, paramExportOutput, paramString));
  }
  
  private final void a(TAVComposition paramTAVComposition, String paramString, ExportConfig paramExportConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("export: ");
    localStringBuilder.append(paramTAVComposition.getDuration());
    TavLogger.b("MovieExporter", localStringBuilder.toString());
    paramString = a(paramString);
    if (paramString == null)
    {
      paramTAVComposition = this.c;
      if (paramTAVComposition != null) {
        paramTAVComposition.a(-103, (Throwable)new RuntimeException("Failed to create output file"));
      }
      return;
    }
    a(paramTAVComposition, paramString, paramExportConfig);
  }
  
  private final boolean d()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    if (!c()) {
      return;
    }
    try
    {
      this.e = true;
      Object localObject1 = this.d;
      if (localObject1 != null) {
        ((AssetExportSession)localObject1).cancelExport();
      }
      this.f = false;
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  public final void a(@NotNull AssetExportSession paramAssetExportSession, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAssetExportSession, "assetExportSession");
    Intrinsics.checkParameterIsNotNull(paramString, "destPath");
    AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = paramAssetExportSession.getStatus();
    if (localAssetExportSessionStatus == null) {
      return;
    }
    int i = MovieExporter.WhenMappings.$EnumSwitchMapping$0[localAssetExportSessionStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 5) {
            return;
          }
          TavLogger.c("MovieExporter", "export cancel");
          if (d()) {}
          try
          {
            this.e = false;
            paramAssetExportSession = Unit.INSTANCE;
            paramAssetExportSession = this.c;
            if (paramAssetExportSession != null) {
              paramAssetExportSession.b();
            }
          }
          finally {}
          try
          {
            this.f = false;
            paramAssetExportSession = Unit.INSTANCE;
            b();
            return;
          }
          finally {}
        }
        TavLogger.c("MovieExporter", "export error");
        paramString = this.c;
        if (paramString != null) {
          paramString.a(paramAssetExportSession.getErrCode(), paramAssetExportSession.getThrowable());
        }
        try
        {
          this.f = false;
          paramAssetExportSession = Unit.INSTANCE;
          b();
          return;
        }
        finally {}
      }
      TavLogger.c("MovieExporter", "export progress finished");
      paramAssetExportSession = this.c;
      if (paramAssetExportSession != null) {
        paramAssetExportSession.a(paramString);
      }
      try
      {
        this.f = false;
        paramAssetExportSession = Unit.INSTANCE;
        b();
        return;
      }
      finally {}
    }
    if (!c())
    {
      paramString = this.c;
      if (paramString != null) {
        paramString.a();
      }
    }
    paramString = this.c;
    if (paramString != null) {
      paramString.a(paramAssetExportSession.getProgress());
    }
    try
    {
      this.f = true;
      paramAssetExportSession = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramAssetExportSession = finally;
      throw paramAssetExportSession;
    }
  }
  
  public void a(@NotNull ExportOutput paramExportOutput, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramExportOutput, "exportOutput");
    Intrinsics.checkParameterIsNotNull(paramString, "destPath");
    a(paramExportOutput, this.h, paramString);
  }
  
  public void a(@Nullable IExporter.ExportListener paramExportListener)
  {
    this.c = paramExportListener;
  }
  
  public final void a(@NotNull TAVComposition paramTAVComposition, @NotNull File paramFile, @NotNull ExportConfig paramExportConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVComposition, "composition");
    Intrinsics.checkParameterIsNotNull(paramFile, "destFile");
    Intrinsics.checkParameterIsNotNull(paramExportConfig, "exportConfig");
    Object localObject = this.d;
    if (localObject != null) {
      ((AssetExportSession)localObject).cancelExport();
    }
    this.d = ((AssetExportSession)null);
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(false);
    paramTAVComposition = paramTAVComposition.buildSource();
    Intrinsics.checkExpressionValueIsNotNull(paramTAVComposition, "source");
    this.d = new AssetExportSession(paramTAVComposition.getAsset(), paramExportConfig);
    paramExportConfig = this.d;
    if (paramExportConfig != null)
    {
      localObject = CMTime.CMTimeZero;
      Asset localAsset = paramTAVComposition.getAsset();
      Intrinsics.checkExpressionValueIsNotNull(localAsset, "source.asset");
      paramExportConfig.setTimeRange(new CMTimeRange((CMTime)localObject, localAsset.getDuration()));
    }
    paramExportConfig = this.d;
    if (paramExportConfig != null) {
      paramExportConfig.setAudioMix(paramTAVComposition.getAudioMix());
    }
    paramExportConfig = this.d;
    if (paramExportConfig != null) {
      paramExportConfig.setOutputFilePath(paramFile.getAbsolutePath());
    }
    paramExportConfig = this.d;
    if (paramExportConfig != null) {
      paramExportConfig.setOutputFileType("MP4");
    }
    paramExportConfig = this.d;
    if (paramExportConfig != null) {
      paramExportConfig.setVideoComposition(paramTAVComposition.getVideoComposition());
    }
    paramTAVComposition = this.d;
    if (paramTAVComposition != null) {
      paramTAVComposition.setErrorInterceptor((AssetExportSession.ErrorInterceptor)new MovieExporter.export.2(this));
    }
    paramTAVComposition = this.d;
    if (paramTAVComposition != null) {
      paramTAVComposition.exportAsynchronouslyWithCompletionHandler((AssetExportSession.ExportCallbackHandler)new MovieExporter.export.3(this, paramFile));
    }
  }
  
  public void b()
  {
    try
    {
      Object localObject1 = this.g;
      if (localObject1 != null) {
        ((IRenderChainManager)localObject1).a();
      }
      this.g = ((IRenderChainManager)null);
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.exporter.MovieExporter
 * JD-Core Version:    0.7.0.1
 */