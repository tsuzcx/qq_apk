package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ExportSettingModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/ExportSettingModel;", "()V", "fpsValue", "", "Ljava/lang/Integer;", "resolutionLevel", "build", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/ExportSettingModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ExportSettingModel$Builder
  extends Message.Builder<ExportSettingModel, Builder>
{
  @JvmField
  @Nullable
  public Integer a;
  @JvmField
  @Nullable
  public Integer b;
  
  @NotNull
  public ExportSettingModel a()
  {
    return new ExportSettingModel(this.a, this.b, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ExportSettingModel.Builder
 * JD-Core Version:    0.7.0.1
 */