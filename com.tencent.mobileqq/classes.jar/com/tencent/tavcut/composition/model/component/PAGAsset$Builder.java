package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "()V", "componentID", "", "Ljava/lang/Integer;", "enabled", "", "Ljava/lang/Boolean;", "entityId", "musicID", "", "replacement", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "scaleMode", "src", "type", "usage", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PAGAsset$Builder
  extends Message.Builder<PAGAsset, Builder>
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
  public String musicID;
  @JvmField
  @NotNull
  public List<PAGAsset.Replacement> replacement = CollectionsKt.emptyList();
  @JvmField
  @Nullable
  public Integer scaleMode;
  @JvmField
  @Nullable
  public String src;
  @JvmField
  @Nullable
  public String type;
  @JvmField
  @Nullable
  public Integer usage;
  @JvmField
  @Nullable
  public Integer version;
  
  @NotNull
  public PAGAsset build()
  {
    return new PAGAsset(this.entityId, this.componentID, this.enabled, this.type, this.musicID, this.src, this.usage, this.version, this.replacement, this.scaleMode, buildUnknownFields());
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
  public final Builder musicID(@Nullable String paramString)
  {
    this.musicID = paramString;
    return this;
  }
  
  @NotNull
  public final Builder replacement(@NotNull List<PAGAsset.Replacement> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "replacement");
    Internal.checkElementsNotNull(paramList);
    this.replacement = paramList;
    return this;
  }
  
  @NotNull
  public final Builder scaleMode(@Nullable Integer paramInteger)
  {
    this.scaleMode = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder src(@Nullable String paramString)
  {
    this.src = paramString;
    return this;
  }
  
  @NotNull
  public final Builder type(@Nullable String paramString)
  {
    this.type = paramString;
    return this;
  }
  
  @NotNull
  public final Builder usage(@Nullable Integer paramInteger)
  {
    this.usage = paramInteger;
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
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.Builder
 * JD-Core Version:    0.7.0.1
 */