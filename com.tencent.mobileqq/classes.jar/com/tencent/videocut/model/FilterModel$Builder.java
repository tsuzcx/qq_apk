package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/FilterModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/FilterModel;", "()V", "color", "Lcom/tencent/videocut/model/ColorFilterModel;", "durationUs", "", "id", "", "lut", "Lcom/tencent/videocut/model/LutFilterModel;", "startTimeUs", "timeLineIndex", "", "Ljava/lang/Integer;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/FilterModel$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/FilterModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FilterModel$Builder
  extends Message.Builder<FilterModel, Builder>
{
  @JvmField
  @Nullable
  public String a;
  @JvmField
  @Nullable
  public LutFilterModel b;
  @JvmField
  @Nullable
  public ColorFilterModel c;
  @JvmField
  public long d;
  @JvmField
  public long e;
  @JvmField
  @Nullable
  public Integer f;
  
  @NotNull
  public FilterModel a()
  {
    String str = this.a;
    if (str == null) {
      str = "";
    }
    return new FilterModel(str, this.b, this.c, this.d, this.e, this.f, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.FilterModel.Builder
 * JD-Core Version:    0.7.0.1
 */