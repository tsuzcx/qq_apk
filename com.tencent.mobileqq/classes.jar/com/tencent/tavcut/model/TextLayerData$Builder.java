package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/TextLayerData$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/TextLayerData;", "()V", "applyFill", "", "Ljava/lang/Boolean;", "applyStroke", "backgroundAlpha", "", "Ljava/lang/Integer;", "backgroundColor", "baselineShift", "", "Ljava/lang/Float;", "boxText", "defaultText", "", "fauxBold", "fauxItalic", "firstBaseLine", "fontFamily", "fontSize", "fontStyle", "justification", "layerIndex", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "layerName", "layerType", "leading", "stokeWidth", "strokeColor", "strokeOverFill", "textColor", "tracking", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/model/TextLayerData$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/model/TextLayerData$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/model/TextLayerData$Builder;", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextLayerData$Builder
  extends Message.Builder<TextLayerData, Builder>
{
  @JvmField
  @Nullable
  public Boolean applyFill;
  @JvmField
  @Nullable
  public Boolean applyStroke;
  @JvmField
  @Nullable
  public Integer backgroundAlpha;
  @JvmField
  @Nullable
  public Integer backgroundColor;
  @JvmField
  @Nullable
  public Float baselineShift;
  @JvmField
  @Nullable
  public Boolean boxText;
  @JvmField
  @Nullable
  public String defaultText;
  @JvmField
  @Nullable
  public Boolean fauxBold;
  @JvmField
  @Nullable
  public Boolean fauxItalic;
  @JvmField
  @Nullable
  public Float firstBaseLine;
  @JvmField
  @Nullable
  public String fontFamily;
  @JvmField
  @Nullable
  public Float fontSize;
  @JvmField
  @Nullable
  public String fontStyle;
  @JvmField
  @Nullable
  public Integer justification;
  @JvmField
  @Nullable
  public Integer layerIndex;
  @JvmField
  @NotNull
  public List<LayerMarkData> layerMarkList = CollectionsKt.emptyList();
  @JvmField
  @Nullable
  public String layerName;
  @JvmField
  @Nullable
  public Integer layerType;
  @JvmField
  @Nullable
  public Float leading;
  @JvmField
  @Nullable
  public Float stokeWidth;
  @JvmField
  @Nullable
  public Integer strokeColor;
  @JvmField
  @Nullable
  public Boolean strokeOverFill;
  @JvmField
  @Nullable
  public Integer textColor;
  @JvmField
  @Nullable
  public Float tracking;
  
  @NotNull
  public final Builder applyFill(@Nullable Boolean paramBoolean)
  {
    this.applyFill = paramBoolean;
    return this;
  }
  
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
  public final Builder backgroundColor(@Nullable Integer paramInteger)
  {
    this.backgroundColor = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder baselineShift(@Nullable Float paramFloat)
  {
    this.baselineShift = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder boxText(@Nullable Boolean paramBoolean)
  {
    this.boxText = paramBoolean;
    return this;
  }
  
  @NotNull
  public TextLayerData build()
  {
    return new TextLayerData(this.layerIndex, this.layerName, this.layerType, this.defaultText, this.textColor, this.fontFamily, this.fontStyle, this.layerMarkList, this.applyFill, this.applyStroke, this.baselineShift, this.boxText, this.firstBaseLine, this.fauxBold, this.fauxItalic, this.fontSize, this.strokeColor, this.strokeOverFill, this.stokeWidth, this.justification, this.leading, this.tracking, this.backgroundColor, this.backgroundAlpha, buildUnknownFields());
  }
  
  @NotNull
  public final Builder defaultText(@Nullable String paramString)
  {
    this.defaultText = paramString;
    return this;
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
  public final Builder firstBaseLine(@Nullable Float paramFloat)
  {
    this.firstBaseLine = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder fontFamily(@Nullable String paramString)
  {
    this.fontFamily = paramString;
    return this;
  }
  
  @NotNull
  public final Builder fontSize(@Nullable Float paramFloat)
  {
    this.fontSize = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder fontStyle(@Nullable String paramString)
  {
    this.fontStyle = paramString;
    return this;
  }
  
  @NotNull
  public final Builder justification(@Nullable Integer paramInteger)
  {
    this.justification = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder layerIndex(@Nullable Integer paramInteger)
  {
    this.layerIndex = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder layerMarkList(@NotNull List<LayerMarkData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "layerMarkList");
    Internal.checkElementsNotNull(paramList);
    this.layerMarkList = paramList;
    return this;
  }
  
  @NotNull
  public final Builder layerName(@Nullable String paramString)
  {
    this.layerName = paramString;
    return this;
  }
  
  @NotNull
  public final Builder layerType(@Nullable Integer paramInteger)
  {
    this.layerType = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder leading(@Nullable Float paramFloat)
  {
    this.leading = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder stokeWidth(@Nullable Float paramFloat)
  {
    this.stokeWidth = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder strokeColor(@Nullable Integer paramInteger)
  {
    this.strokeColor = paramInteger;
    return this;
  }
  
  @NotNull
  public final Builder strokeOverFill(@Nullable Boolean paramBoolean)
  {
    this.strokeOverFill = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder textColor(@Nullable Integer paramInteger)
  {
    this.textColor = paramInteger;
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
 * Qualified Name:     com.tencent.tavcut.model.TextLayerData.Builder
 * JD-Core Version:    0.7.0.1
 */