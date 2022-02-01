package com.tencent.weseevideo.composition.effectnode;

import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.weseevideo.model.effect.GestureModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/composition/effectnode/GestureNode;", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect;", "()V", "gestureModel", "Lcom/tencent/weseevideo/model/effect/GestureModel;", "getGestureModel", "()Lcom/tencent/weseevideo/model/effect/GestureModel;", "setGestureModel", "(Lcom/tencent/weseevideo/model/effect/GestureModel;)V", "mEffectId", "", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "getRenderSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setRenderSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect$Filter;", "effectId", "GestureFilter", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class GestureNode
  implements TAVVideoEffect
{
  @NotNull
  private GestureModel jdField_a_of_type_ComTencentWeseevideoModelEffectGestureModel;
  private final String jdField_a_of_type_JavaLangString;
  
  public GestureNode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GestureNode");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentWeseevideoModelEffectGestureModel = new GestureModel();
  }
  
  @NotNull
  public final GestureModel a()
  {
    return this.jdField_a_of_type_ComTencentWeseevideoModelEffectGestureModel;
  }
  
  @NotNull
  public TAVVideoEffect.Filter createFilter()
  {
    return (TAVVideoEffect.Filter)new GestureNode.GestureFilter(this);
  }
  
  @NotNull
  public String effectId()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.GestureNode
 * JD-Core Version:    0.7.0.1
 */