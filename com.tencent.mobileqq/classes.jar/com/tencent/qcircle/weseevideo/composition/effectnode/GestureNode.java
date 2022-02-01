package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/composition/effectnode/GestureNode;", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect;", "()V", "gestureModel", "Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "getGestureModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "setGestureModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;)V", "mEffectId", "", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "getRenderSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setRenderSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect$Filter;", "effectId", "GestureFilter", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class GestureNode
  implements TAVVideoEffect
{
  @NotNull
  private GestureModel gestureModel;
  private final String mEffectId;
  @Nullable
  private CGSize renderSize;
  
  public GestureNode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GestureNode");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mEffectId = localStringBuilder.toString();
    this.gestureModel = new GestureModel();
  }
  
  @NotNull
  public TAVVideoEffect.Filter createFilter()
  {
    return (TAVVideoEffect.Filter)new GestureNode.GestureFilter(this);
  }
  
  @NotNull
  public String effectId()
  {
    return this.mEffectId;
  }
  
  @NotNull
  public final GestureModel getGestureModel()
  {
    return this.gestureModel;
  }
  
  @Nullable
  public final CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public final void setGestureModel(@NotNull GestureModel paramGestureModel)
  {
    Intrinsics.checkParameterIsNotNull(paramGestureModel, "<set-?>");
    this.gestureModel = paramGestureModel;
  }
  
  public final void setRenderSize(@Nullable CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.GestureNode
 * JD-Core Version:    0.7.0.1
 */