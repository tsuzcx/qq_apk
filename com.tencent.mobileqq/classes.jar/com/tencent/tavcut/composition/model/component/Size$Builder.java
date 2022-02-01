package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Size$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Size;", "()V", "height", "", "Ljava/lang/Integer;", "width", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/Size$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Size$Builder
  extends Message.Builder<Size, Builder>
{
  @JvmField
  @Nullable
  public Integer height;
  @JvmField
  @Nullable
  public Integer width;
  
  @NotNull
  public Size build()
  {
    return new Size(this.width, this.height, buildUnknownFields());
  }
  
  @NotNull
  public final Builder height(@Nullable Integer paramInteger)
  {
    this.height = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder width(@Nullable Integer paramInteger)
  {
    this.width = paramInteger;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Size.Builder
 * JD-Core Version:    0.7.0.1
 */