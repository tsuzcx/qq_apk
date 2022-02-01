package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "()V", "anchor", "Lcom/tencent/tavcut/composition/model/component/Rect;", "componentID", "", "Ljava/lang/Integer;", "eEditingMode", "eFixSize", "eKeepRatio", "", "Ljava/lang/Boolean;", "ePinToEdge", "enabled", "entityId", "euler", "Lcom/tencent/tavcut/composition/model/component/Vec3;", "objectEnabled", "offset", "pivot", "Lcom/tencent/tavcut/composition/model/component/Vec2;", "position", "rotation", "Lcom/tencent/tavcut/composition/model/component/Quat;", "scale", "type", "", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/ScreenTransform$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ScreenTransform$Builder
  extends Message.Builder<ScreenTransform, Builder>
{
  @JvmField
  @Nullable
  public Rect anchor;
  @JvmField
  @Nullable
  public Integer componentID;
  @JvmField
  @Nullable
  public Integer eEditingMode;
  @JvmField
  @Nullable
  public Integer eFixSize;
  @JvmField
  @Nullable
  public Boolean eKeepRatio;
  @JvmField
  @Nullable
  public Integer ePinToEdge;
  @JvmField
  @Nullable
  public Boolean enabled;
  @JvmField
  @Nullable
  public Integer entityId;
  @JvmField
  @Nullable
  public Vec3 euler;
  @JvmField
  @Nullable
  public Boolean objectEnabled;
  @JvmField
  @Nullable
  public Rect offset;
  @JvmField
  @Nullable
  public Vec2 pivot;
  @JvmField
  @Nullable
  public Vec3 position;
  @JvmField
  @Nullable
  public Quat rotation;
  @JvmField
  @Nullable
  public Vec3 scale;
  @JvmField
  @Nullable
  public String type;
  @JvmField
  @Nullable
  public Integer version;
  
  @NotNull
  public final Builder anchor(@Nullable Rect paramRect)
  {
    this.anchor = paramRect;
    return this;
  }
  
  @NotNull
  public ScreenTransform build()
  {
    return new ScreenTransform(this.entityId, this.componentID, this.enabled, this.type, this.anchor, this.offset, this.pivot, this.ePinToEdge, this.eFixSize, this.eEditingMode, this.eKeepRatio, this.position, this.rotation, this.scale, this.euler, this.objectEnabled, this.version, buildUnknownFields());
  }
  
  @NotNull
  public final Builder componentID(@Nullable Integer paramInteger)
  {
    this.componentID = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder eEditingMode(@Nullable Integer paramInteger)
  {
    this.eEditingMode = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder eFixSize(@Nullable Integer paramInteger)
  {
    this.eFixSize = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder eKeepRatio(@Nullable Boolean paramBoolean)
  {
    this.eKeepRatio = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder ePinToEdge(@Nullable Integer paramInteger)
  {
    this.ePinToEdge = paramInteger;
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
  public final Builder euler(@Nullable Vec3 paramVec3)
  {
    this.euler = paramVec3;
    return this;
  }
  
  @NotNull
  public final Builder objectEnabled(@Nullable Boolean paramBoolean)
  {
    this.objectEnabled = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder offset(@Nullable Rect paramRect)
  {
    this.offset = paramRect;
    return this;
  }
  
  @NotNull
  public final Builder pivot(@Nullable Vec2 paramVec2)
  {
    this.pivot = paramVec2;
    return this;
  }
  
  @NotNull
  public final Builder position(@Nullable Vec3 paramVec3)
  {
    this.position = paramVec3;
    return this;
  }
  
  @NotNull
  public final Builder rotation(@Nullable Quat paramQuat)
  {
    this.rotation = paramQuat;
    return this;
  }
  
  @NotNull
  public final Builder scale(@Nullable Vec3 paramVec3)
  {
    this.scale = paramVec3;
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
 * Qualified Name:     com.tencent.tavcut.composition.model.component.ScreenTransform.Builder
 * JD-Core Version:    0.7.0.1
 */