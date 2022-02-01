package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TemplateModel$FontInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TemplateModel$FontInfo;", "()V", "name", "", "path", "style", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateModel$FontInfo$Builder
  extends Message.Builder<TemplateModel.FontInfo, Builder>
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
  
  @NotNull
  public TemplateModel.FontInfo a()
  {
    return new TemplateModel.FontInfo(this.a, this.b, this.c, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TemplateModel.FontInfo.Builder
 * JD-Core Version:    0.7.0.1
 */