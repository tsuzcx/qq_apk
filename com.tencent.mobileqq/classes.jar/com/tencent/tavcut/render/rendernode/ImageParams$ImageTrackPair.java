package com.tencent.tavcut.render.rendernode;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/ImageParams$ImageTrackPair;", "", "image", "Lcom/tencent/tavkit/ciimage/CIImage;", "track", "Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;", "(Lcom/tencent/tavkit/ciimage/CIImage;Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;)V", "getImage", "()Lcom/tencent/tavkit/ciimage/CIImage;", "setImage", "(Lcom/tencent/tavkit/ciimage/CIImage;)V", "getTrack", "()Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ImageParams$ImageTrackPair
{
  @NotNull
  private CIImage a;
  @Nullable
  private final TAVVideoCompositionTrack b;
  
  public ImageParams$ImageTrackPair(@NotNull CIImage paramCIImage, @Nullable TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    this.a = paramCIImage;
    this.b = paramTAVVideoCompositionTrack;
  }
  
  @NotNull
  public final CIImage a()
  {
    return this.a;
  }
  
  public final void a(@NotNull CIImage paramCIImage)
  {
    Intrinsics.checkParameterIsNotNull(paramCIImage, "<set-?>");
    this.a = paramCIImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.ImageParams.ImageTrackPair
 * JD-Core Version:    0.7.0.1
 */