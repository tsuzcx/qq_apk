package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "()V", "applyStroke", "", "Ljava/lang/Boolean;", "backgroundAlpha", "", "Ljava/lang/Integer;", "backgroundColor", "", "fauxBold", "fauxItalic", "fontFamily", "fontPath", "leading", "", "Ljava/lang/Float;", "strokeColor", "strokeWidth", "textColor", "tracking", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "build", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextReplaceItem$Builder
  extends Message.Builder<TextReplaceItem, Builder>
{
  @JvmField
  @Nullable
  public Boolean applyStroke;
  @JvmField
  @Nullable
  public Integer backgroundAlpha;
  @JvmField
  @Nullable
  public String backgroundColor;
  @JvmField
  @Nullable
  public Boolean fauxBold;
  @JvmField
  @Nullable
  public Boolean fauxItalic;
  @JvmField
  @Nullable
  public String fontFamily;
  @JvmField
  @Nullable
  public String fontPath;
  @JvmField
  @Nullable
  public Float leading;
  @JvmField
  @Nullable
  public String strokeColor;
  @JvmField
  @Nullable
  public Float strokeWidth;
  @JvmField
  @Nullable
  public String textColor;
  @JvmField
  @Nullable
  public Float tracking;
  
  @NotNull
  public final Builder applyStroke(@Nullable Boolean paramBoolean)
  {
    this.applyStroke = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder backgroundAlpha(@Nullable Integer paramInteger)
  {
    this.backgroundAlpha = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder backgroundColor(@Nullable String paramString)
  {
    this.backgroundColor = paramString;
    return this;
  }
  
  @NotNull
  public TextReplaceItem build()
  {
    return new TextReplaceItem(this.fauxBold, this.fauxItalic, this.fontFamily, this.fontPath, this.applyStroke, this.strokeColor, this.strokeWidth, this.leading, this.tracking, this.backgroundColor, this.backgroundAlpha, this.textColor, buildUnknownFields());
  }
  
  @NotNull
  public final Builder fauxBold(@Nullable Boolean paramBoolean)
  {
    this.fauxBold = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder fauxItalic(@Nullable Boolean paramBoolean)
  {
    this.fauxItalic = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder fontFamily(@Nullable String paramString)
  {
    this.fontFamily = paramString;
    return this;
  }
  
  @NotNull
  public final Builder fontPath(@Nullable String paramString)
  {
    this.fontPath = paramString;
    return this;
  }
  
  @NotNull
  public final Builder leading(@Nullable Float paramFloat)
  {
    this.leading = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder strokeColor(@Nullable String paramString)
  {
    this.strokeColor = paramString;
    return this;
  }
  
  @NotNull
  public final Builder strokeWidth(@Nullable Float paramFloat)
  {
    this.strokeWidth = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder textColor(@Nullable String paramString)
  {
    this.textColor = paramString;
    return this;
  }
  
  @NotNull
  public final Builder tracking(@Nullable Float paramFloat)
  {
    this.tracking = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TextReplaceItem.Builder
 * JD-Core Version:    0.7.0.1
 */