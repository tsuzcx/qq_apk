package com.tencent.tavcut.render.exporter;

import com.tencent.tavcut.render.builder.IMediaBuilderListener;
import com.tencent.tavcut.render.builder.MediaBuilderOutput;
import com.tencent.tavkit.composition.TAVComposition;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/exporter/MovieExporter$export$1", "Lcom/tencent/tavcut/render/builder/IMediaBuilderListener;", "buildCompleted", "", "errorCode", "", "output", "Lcom/tencent/tavcut/render/builder/MediaBuilderOutput;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MovieExporter$export$1
  implements IMediaBuilderListener
{
  MovieExporter$export$1(ExportOutput paramExportOutput, String paramString) {}
  
  public void a(int paramInt, @Nullable MediaBuilderOutput paramMediaBuilderOutput)
  {
    if (paramMediaBuilderOutput != null)
    {
      TAVComposition localTAVComposition = paramMediaBuilderOutput.c();
      if (localTAVComposition != null)
      {
        localTAVComposition.setRenderSize(this.b.b());
        MovieExporter.a(this.a, localTAVComposition, this.c, this.b.a());
      }
    }
    if (paramMediaBuilderOutput != null)
    {
      paramMediaBuilderOutput = paramMediaBuilderOutput.a();
      if (paramMediaBuilderOutput != null) {
        MovieExporter.a(this.a, paramMediaBuilderOutput);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.exporter.MovieExporter.export.1
 * JD-Core Version:    0.7.0.1
 */