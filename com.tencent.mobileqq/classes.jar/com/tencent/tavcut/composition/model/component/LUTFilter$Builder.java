package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "()V", "componentID", "", "Ljava/lang/Integer;", "enabled", "", "Ljava/lang/Boolean;", "entityId", "intensity", "", "Ljava/lang/Float;", "src", "", "strength", "type", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/LUTFilter$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LUTFilter$Builder
  extends Message.Builder<LUTFilter, Builder>
{
  @JvmField
  @Nullable
  public Integer componentID;
  @JvmField
  @Nullable
  public Boolean enabled;
  @JvmField
  @Nullable
  public Integer entityId;
  @JvmField
  @Nullable
  public Float intensity;
  @JvmField
  @Nullable
  public String src;
  @JvmField
  @Nullable
  public Float strength;
  @JvmField
  @Nullable
  public String type;
  @JvmField
  @Nullable
  public Integer version;
  
  @NotNull
  public LUTFilter build()
  {
    return new LUTFilter(this.entityId, this.componentID, this.enabled, this.type, this.src, this.strength, this.version, this.intensity, buildUnknownFields());
  }
  
  @NotNull
  public final Builder componentID(@Nullable Integer paramInteger)
  {
    this.componentID = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder enabled(@Nullable Boolean paramBoolean)
  {
    this.enabled = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder entityId(@Nullable Integer paramInteger)
  {
    this.entityId = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder intensity(@Nullable Float paramFloat)
  {
    this.intensity = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder src(@Nullable String paramString)
  {
    this.src = paramString;
    return this;
  }
  
  @NotNull
  public final Builder strength(@Nullable Float paramFloat)
  {
    this.strength = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable String paramString)
  {
    this.type = paramString;
    return this;
  }
  
  @NotNull
  public final Builder version(@Nullable Integer paramInteger)
  {
    this.version = paramInteger;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.LUTFilter.Builder
 * JD-Core Version:    0.7.0.1
 */