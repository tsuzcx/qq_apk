package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "()V", "index", "", "Ljava/lang/Integer;", "interactive", "", "Ljava/lang/Boolean;", "replaceType", "scaleMode", "sourceIndex", "src", "", "textReplaceItem", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PAGAsset$Replacement$Builder
  extends Message.Builder<PAGAsset.Replacement, Builder>
{
  @JvmField
  @Nullable
  public Integer index;
  @JvmField
  @Nullable
  public Boolean interactive;
  @JvmField
  @Nullable
  public Integer replaceType;
  @JvmField
  @Nullable
  public Integer scaleMode;
  @JvmField
  @Nullable
  public Integer sourceIndex;
  @JvmField
  @Nullable
  public String src;
  @JvmField
  @Nullable
  public TextReplaceItem textReplaceItem;
  
  @NotNull
  public PAGAsset.Replacement build()
  {
    return new PAGAsset.Replacement(this.index, this.src, this.replaceType, this.sourceIndex, this.scaleMode, this.interactive, this.textReplaceItem, buildUnknownFields());
  }
  
  @NotNull
  public final Builder index(@Nullable Integer paramInteger)
  {
    this.index = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder interactive(@Nullable Boolean paramBoolean)
  {
    this.interactive = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder replaceType(@Nullable Integer paramInteger)
  {
    this.replaceType = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder scaleMode(@Nullable Integer paramInteger)
  {
    this.scaleMode = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder sourceIndex(@Nullable Integer paramInteger)
  {
    this.sourceIndex = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder src(@Nullable String paramString)
  {
    this.src = paramString;
    return this;
  }
  
  @NotNull
  public final Builder textReplaceItem(@Nullable TextReplaceItem paramTextReplaceItem)
  {
    this.textReplaceItem = paramTextReplaceItem;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.Replacement.Builder
 * JD-Core Version:    0.7.0.1
 */