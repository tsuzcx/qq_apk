package com.tencent.tavcut.render.player;

import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.render.builder.IMediaBuilderListener;
import com.tencent.tavcut.render.builder.MediaBuilderOutput;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderModel.Companion;
import com.tencent.tavkit.composition.TAVComposition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/player/MoviePlayer$updatePlayer$1", "Lcom/tencent/tavcut/render/builder/IMediaBuilderListener;", "buildCompleted", "", "errorCode", "", "output", "Lcom/tencent/tavcut/render/builder/MediaBuilderOutput;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MoviePlayer$updatePlayer$1
  implements IMediaBuilderListener
{
  MoviePlayer$updatePlayer$1(Function2 paramFunction2) {}
  
  public void a(int paramInt, @Nullable MediaBuilderOutput paramMediaBuilderOutput)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("build player complete errorCode is ");
    ((StringBuilder)localObject1).append(paramInt);
    TavLogger.b("TavCut_MoviePlayer", ((StringBuilder)localObject1).toString());
    if (paramMediaBuilderOutput != null)
    {
      Object localObject2 = this.a;
      localObject1 = paramMediaBuilderOutput.b().getPainting().renderSize;
      if (localObject1 == null) {
        localObject1 = RenderModel.Companion.getDEFAULT_SIZE();
      }
      MoviePlayer.a((MoviePlayer)localObject2, (Size)localObject1);
      localObject1 = paramMediaBuilderOutput.c();
      localObject2 = MoviePlayer.f(this.a).width;
      float f2 = 0.0F;
      float f1;
      if (localObject2 != null) {
        f1 = ((Integer)localObject2).intValue();
      } else {
        f1 = 0.0F;
      }
      localObject2 = MoviePlayer.f(this.a).height;
      if (localObject2 != null) {
        f2 = ((Integer)localObject2).intValue();
      }
      ((TAVComposition)localObject1).setRenderSize(new CGSize(f1, f2));
      long l;
      if (MoviePlayer.g(this.a)) {
        l = MoviePlayer.h(this.a);
      } else {
        l = 0L;
      }
      MoviePlayer.c(this.a, paramMediaBuilderOutput.d());
      paramMediaBuilderOutput.c().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
      MoviePlayer.a(this.a, paramMediaBuilderOutput.c());
      MoviePlayer.a(this.a, paramMediaBuilderOutput.c(), l);
      MoviePlayer.a(this.a, paramMediaBuilderOutput.a());
      this.b.invoke(paramMediaBuilderOutput.a(), paramMediaBuilderOutput.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.MoviePlayer.updatePlayer.1
 * JD-Core Version:    0.7.0.1
 */