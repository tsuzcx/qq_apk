package com.tencent.weseevideo.model;

import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/MediaModel;", "Lcom/tencent/weseevideo/model/BaseMediaModel;", "()V", "mediaEffectModel", "Lcom/tencent/weseevideo/model/effect/MediaEffectModel;", "getMediaEffectModel", "()Lcom/tencent/weseevideo/model/effect/MediaEffectModel;", "setMediaEffectModel", "(Lcom/tencent/weseevideo/model/effect/MediaEffectModel;)V", "mediaResourceModel", "Lcom/tencent/weseevideo/model/resource/MediaResourceModel;", "getMediaResourceModel", "()Lcom/tencent/weseevideo/model/resource/MediaResourceModel;", "setMediaResourceModel", "(Lcom/tencent/weseevideo/model/resource/MediaResourceModel;)V", "mediaTemplateModel", "Lcom/tencent/weseevideo/model/template/MediaTemplateModel;", "getMediaTemplateModel", "()Lcom/tencent/weseevideo/model/template/MediaTemplateModel;", "setMediaTemplateModel", "(Lcom/tencent/weseevideo/model/template/MediaTemplateModel;)V", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class MediaModel
  extends BaseMediaModel
{
  @NotNull
  private MediaEffectModel mediaEffectModel = new MediaEffectModel();
  @NotNull
  private MediaResourceModel mediaResourceModel = new MediaResourceModel();
  @NotNull
  private MediaTemplateModel mediaTemplateModel = new MediaTemplateModel();
  
  @NotNull
  public final MediaEffectModel getMediaEffectModel()
  {
    return this.mediaEffectModel;
  }
  
  @NotNull
  public final MediaResourceModel getMediaResourceModel()
  {
    return this.mediaResourceModel;
  }
  
  @NotNull
  public final MediaTemplateModel getMediaTemplateModel()
  {
    return this.mediaTemplateModel;
  }
  
  public final void setMediaEffectModel(@NotNull MediaEffectModel paramMediaEffectModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaEffectModel, "<set-?>");
    this.mediaEffectModel = paramMediaEffectModel;
  }
  
  public final void setMediaResourceModel(@NotNull MediaResourceModel paramMediaResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaResourceModel, "<set-?>");
    this.mediaResourceModel = paramMediaResourceModel;
  }
  
  public final void setMediaTemplateModel(@NotNull MediaTemplateModel paramMediaTemplateModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaTemplateModel, "<set-?>");
    this.mediaTemplateModel = paramMediaTemplateModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.MediaModel
 * JD-Core Version:    0.7.0.1
 */