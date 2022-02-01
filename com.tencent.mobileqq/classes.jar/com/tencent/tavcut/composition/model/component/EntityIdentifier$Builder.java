package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/EntityIdentifier$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "()V", "id", "", "Ljava/lang/Integer;", "name", "", "type", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/EntityIdentifier$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class EntityIdentifier$Builder
  extends Message.Builder<EntityIdentifier, Builder>
{
  @JvmField
  @Nullable
  public Integer id;
  @JvmField
  @Nullable
  public String name;
  @JvmField
  @Nullable
  public String type;
  
  @NotNull
  public EntityIdentifier build()
  {
    return new EntityIdentifier(this.type, this.name, this.id, buildUnknownFields());
  }
  
  @NotNull
  public final Builder id(@Nullable Integer paramInteger)
  {
    this.id = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder name(@Nullable String paramString)
  {
    this.name = paramString;
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable String paramString)
  {
    this.type = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.EntityIdentifier.Builder
 * JD-Core Version:    0.7.0.1
 */