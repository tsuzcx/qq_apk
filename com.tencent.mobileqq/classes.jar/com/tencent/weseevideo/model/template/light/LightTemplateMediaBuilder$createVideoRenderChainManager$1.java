package com.tencent.weseevideo.model.template.light;

import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "videoRenderChainManager", "Lcom/tencent/weseevideo/composition/VideoRenderChainManager;", "effectModel", "Lcom/tencent/weseevideo/model/effect/MediaEffectModel;", "insertEffectNode"}, k=3, mv={1, 1, 16})
final class LightTemplateMediaBuilder$createVideoRenderChainManager$1
  implements VideoRenderChainManager.IEffectNodeInterface
{
  LightTemplateMediaBuilder$createVideoRenderChainManager$1(LightTemplate paramLightTemplate, MediaModel paramMediaModel, TAVComposition paramTAVComposition) {}
  
  public final void insertEffectNode(@NotNull VideoRenderChainManager paramVideoRenderChainManager, @Nullable MediaEffectModel paramMediaEffectModel)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoRenderChainManager, "videoRenderChainManager");
    paramVideoRenderChainManager.updateLightVideoRender(this.$lightTemplate, this.$model);
    paramVideoRenderChainManager.updateLightAudioRender(this.$lightTemplate, this.$composition, this.$model);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightTemplateMediaBuilder.createVideoRenderChainManager.1
 * JD-Core Version:    0.7.0.1
 */