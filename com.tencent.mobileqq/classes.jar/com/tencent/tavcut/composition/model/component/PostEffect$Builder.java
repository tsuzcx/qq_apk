package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/PostEffect;", "()V", "brightness", "", "Ljava/lang/Integer;", "componentID", "contrast", "effectType", "", "enabled", "", "Ljava/lang/Boolean;", "entityId", "highlights", "hue", "saturation", "shadows", "sharpness", "temperature", "type", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", "build", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PostEffect$Builder
  extends Message.Builder<PostEffect, Builder>
{
  @JvmField
  @Nullable
  public Integer brightness;
  @JvmField
  @Nullable
  public Integer componentID;
  @JvmField
  @Nullable
  public Integer contrast;
  @JvmField
  @Nullable
  public String effectType;
  @JvmField
  @Nullable
  public Boolean enabled;
  @JvmField
  @Nullable
  public Integer entityId;
  @JvmField
  @Nullable
  public Integer highlights;
  @JvmField
  @Nullable
  public Integer hue;
  @JvmField
  @Nullable
  public Integer saturation;
  @JvmField
  @Nullable
  public Integer shadows;
  @JvmField
  @Nullable
  public Integer sharpness;
  @JvmField
  @Nullable
  public Integer temperature;
  @JvmField
  @Nullable
  public String type;
  
  @NotNull
  public final Builder brightness(@Nullable Integer paramInteger)
  {
    this.brightness = paramInteger;
    return this;
  }
  
  @NotNull
  public PostEffect build()
  {
    return new PostEffect(this.entityId, this.componentID, this.enabled, this.type, this.effectType, this.sharpness, this.brightness, this.contrast, this.hue, this.highlights, this.shadows, this.saturation, this.temperature, buildUnknownFields());
  }
  
  @NotNull
  public final Builder componentID(@Nullable Integer paramInteger)
  {
    this.componentID = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder contrast(@Nullable Integer paramInteger)
  {
    this.contrast = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder effectType(@Nullable String paramString)
  {
    this.effectType = paramString;
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
  public final Builder highlights(@Nullable Integer paramInteger)
  {
    this.highlights = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder hue(@Nullable Integer paramInteger)
  {
    this.hue = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder saturation(@Nullable Integer paramInteger)
  {
    this.saturation = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder shadows(@Nullable Integer paramInteger)
  {
    this.shadows = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder sharpness(@Nullable Integer paramInteger)
  {
    this.sharpness = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder temperature(@Nullable Integer paramInteger)
  {
    this.temperature = paramInteger;
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
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PostEffect.Builder
 * JD-Core Version:    0.7.0.1
 */