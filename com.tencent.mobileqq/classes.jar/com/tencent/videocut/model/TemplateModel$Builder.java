package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TemplateModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TemplateModel;", "()V", "aiInfo", "", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "audioModel", "Lcom/tencent/videocut/model/AudioModel;", "fontInfo", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "id", "", "name", "path", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel$Builder
  extends Message.Builder<TemplateModel, Builder>
{
  @JvmField
  @Nullable
  public String a;
  @JvmField
  @Nullable
  public String b;
  @JvmField
  @Nullable
  public String c;
  @JvmField
  @NotNull
  public List<AudioModel> d = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public List<TemplateModel.FontInfo> e = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public List<TemplateModel.AiInfo> f = CollectionsKt.emptyList();
  
  @NotNull
  public TemplateModel a()
  {
    return new TemplateModel(this.a, this.b, this.c, this.d, this.e, this.f, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel.Builder
 * JD-Core Version:    0.7.0.1
 */