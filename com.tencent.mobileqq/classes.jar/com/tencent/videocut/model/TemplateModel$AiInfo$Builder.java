package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TemplateModel$AiInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TemplateModel$AiInfo;", "()V", "agent", "", "path", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel$AiInfo$Builder
  extends Message.Builder<TemplateModel.AiInfo, Builder>
{
  @JvmField
  @NotNull
  public String a = "";
  @JvmField
  @NotNull
  public String b = "";
  
  @NotNull
  public TemplateModel.AiInfo a()
  {
    return new TemplateModel.AiInfo(this.a, this.b, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel.AiInfo.Builder
 * JD-Core Version:    0.7.0.1
 */