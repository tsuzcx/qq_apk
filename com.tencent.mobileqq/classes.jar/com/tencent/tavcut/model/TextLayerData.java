package com.tencent.tavcut.model;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/TextLayerData;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/TextLayerData$Builder;", "layerIndex", "", "layerName", "", "layerType", "defaultText", "textColor", "fontFamily", "fontStyle", "layerMarkList", "", "Lcom/tencent/tavcut/model/LayerMarkData;", "applyFill", "", "applyStroke", "baselineShift", "", "boxText", "firstBaseLine", "fauxBold", "fauxItalic", "fontSize", "strokeColor", "strokeOverFill", "stokeWidth", "justification", "leading", "tracking", "backgroundColor", "backgroundAlpha", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/model/TextLayerData;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextLayerData
  extends AndroidMessage<TextLayerData, TextLayerData.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TextLayerData> ADAPTER = (ProtoAdapter)new TextLayerData.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextLayerData.class), "type.googleapis.com/publisher.TextLayerData");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<TextLayerData> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TextLayerData.Companion Companion = new TextLayerData.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=9)
  @JvmField
  @Nullable
  public final Boolean applyFill;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=10)
  @JvmField
  @Nullable
  public final Boolean applyStroke;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=24)
  @JvmField
  @Nullable
  public final Integer backgroundAlpha;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=23)
  @JvmField
  @Nullable
  public final Integer backgroundColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=11)
  @JvmField
  @Nullable
  public final Float baselineShift;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=12)
  @JvmField
  @Nullable
  public final Boolean boxText;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @Nullable
  public final String defaultText;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=14)
  @JvmField
  @Nullable
  public final Boolean fauxBold;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=15)
  @JvmField
  @Nullable
  public final Boolean fauxItalic;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=13)
  @JvmField
  @Nullable
  public final Float firstBaseLine;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
  @JvmField
  @Nullable
  public final String fontFamily;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=16)
  @JvmField
  @Nullable
  public final Float fontSize;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=7)
  @JvmField
  @Nullable
  public final String fontStyle;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=20)
  @JvmField
  @Nullable
  public final Integer justification;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer layerIndex;
  @WireField(adapter="com.tencent.tavcut.model.LayerMarkData#ADAPTER", label=WireField.Label.REPEATED, tag=8)
  @JvmField
  @NotNull
  public final List<LayerMarkData> layerMarkList;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String layerName;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  @Nullable
  public final Integer layerType;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=21)
  @JvmField
  @Nullable
  public final Float leading;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=19)
  @JvmField
  @Nullable
  public final Float stokeWidth;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=17)
  @JvmField
  @Nullable
  public final Integer strokeColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=18)
  @JvmField
  @Nullable
  public final Boolean strokeOverFill;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=5)
  @JvmField
  @Nullable
  public final Integer textColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=22)
  @JvmField
  @Nullable
  public final Float tracking;
  
  public TextLayerData()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
  }
  
  public TextLayerData(@Nullable Integer paramInteger1, @Nullable String paramString1, @Nullable Integer paramInteger2, @Nullable String paramString2, @Nullable Integer paramInteger3, @Nullable String paramString3, @Nullable String paramString4, @NotNull List<LayerMarkData> paramList, @Nullable Boolean paramBoolean1, @Nullable Boolean paramBoolean2, @Nullable Float paramFloat1, @Nullable Boolean paramBoolean3, @Nullable Float paramFloat2, @Nullable Boolean paramBoolean4, @Nullable Boolean paramBoolean5, @Nullable Float paramFloat3, @Nullable Integer paramInteger4, @Nullable Boolean paramBoolean6, @Nullable Float paramFloat4, @Nullable Integer paramInteger5, @Nullable Float paramFloat5, @Nullable Float paramFloat6, @Nullable Integer paramInteger6, @Nullable Integer paramInteger7, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.layerIndex = paramInteger1;
    this.layerName = paramString1;
    this.layerType = paramInteger2;
    this.defaultText = paramString2;
    this.textColor = paramInteger3;
    this.fontFamily = paramString3;
    this.fontStyle = paramString4;
    this.layerMarkList = paramList;
    this.applyFill = paramBoolean1;
    this.applyStroke = paramBoolean2;
    this.baselineShift = paramFloat1;
    this.boxText = paramBoolean3;
    this.firstBaseLine = paramFloat2;
    this.fauxBold = paramBoolean4;
    this.fauxItalic = paramBoolean5;
    this.fontSize = paramFloat3;
    this.strokeColor = paramInteger4;
    this.strokeOverFill = paramBoolean6;
    this.stokeWidth = paramFloat4;
    this.justification = paramInteger5;
    this.leading = paramFloat5;
    this.tracking = paramFloat6;
    this.backgroundColor = paramInteger6;
    this.backgroundAlpha = paramInteger7;
  }
  
  @NotNull
  public final TextLayerData copy(@Nullable Integer paramInteger1, @Nullable String paramString1, @Nullable Integer paramInteger2, @Nullable String paramString2, @Nullable Integer paramInteger3, @Nullable String paramString3, @Nullable String paramString4, @NotNull List<LayerMarkData> paramList, @Nullable Boolean paramBoolean1, @Nullable Boolean paramBoolean2, @Nullable Float paramFloat1, @Nullable Boolean paramBoolean3, @Nullable Float paramFloat2, @Nullable Boolean paramBoolean4, @Nullable Boolean paramBoolean5, @Nullable Float paramFloat3, @Nullable Integer paramInteger4, @Nullable Boolean paramBoolean6, @Nullable Float paramFloat4, @Nullable Integer paramInteger5, @Nullable Float paramFloat5, @Nullable Float paramFloat6, @Nullable Integer paramInteger6, @Nullable Integer paramInteger7, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "layerMarkList");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new TextLayerData(paramInteger1, paramString1, paramInteger2, paramString2, paramInteger3, paramString3, paramString4, paramList, paramBoolean1, paramBoolean2, paramFloat1, paramBoolean3, paramFloat2, paramBoolean4, paramBoolean5, paramFloat3, paramInteger4, paramBoolean6, paramFloat4, paramInteger5, paramFloat5, paramFloat6, paramInteger6, paramInteger7, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (TextLayerData)this) {
      return true;
    }
    if (!(paramObject instanceof TextLayerData)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (TextLayerData)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.layerIndex, paramObject.layerIndex)) && (Intrinsics.areEqual(this.layerName, paramObject.layerName)) && (Intrinsics.areEqual(this.layerType, paramObject.layerType)) && (Intrinsics.areEqual(this.defaultText, paramObject.defaultText)) && (Intrinsics.areEqual(this.textColor, paramObject.textColor)) && (Intrinsics.areEqual(this.fontFamily, paramObject.fontFamily)) && (Intrinsics.areEqual(this.fontStyle, paramObject.fontStyle)) && (Intrinsics.areEqual(this.layerMarkList, paramObject.layerMarkList)) && (Intrinsics.areEqual(this.applyFill, paramObject.applyFill)) && (Intrinsics.areEqual(this.applyStroke, paramObject.applyStroke)) && (Intrinsics.areEqual(this.baselineShift, paramObject.baselineShift)) && (Intrinsics.areEqual(this.boxText, paramObject.boxText)) && (Intrinsics.areEqual(this.firstBaseLine, paramObject.firstBaseLine)) && (Intrinsics.areEqual(this.fauxBold, paramObject.fauxBold)) && (Intrinsics.areEqual(this.fauxItalic, paramObject.fauxItalic)) && (Intrinsics.areEqual(this.fontSize, paramObject.fontSize)) && (Intrinsics.areEqual(this.strokeColor, paramObject.strokeColor)) && (Intrinsics.areEqual(this.strokeOverFill, paramObject.strokeOverFill)) && (Intrinsics.areEqual(this.stokeWidth, paramObject.stokeWidth)) && (Intrinsics.areEqual(this.justification, paramObject.justification)) && (Intrinsics.areEqual(this.leading, paramObject.leading)) && (Intrinsics.areEqual(this.tracking, paramObject.tracking)) && (Intrinsics.areEqual(this.backgroundColor, paramObject.backgroundColor)) && (Intrinsics.areEqual(this.backgroundAlpha, paramObject.backgroundAlpha));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i19 = unknownFields().hashCode();
      Object localObject = this.layerIndex;
      int i18 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.layerName;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.layerType;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.defaultText;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.textColor;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.fontFamily;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.fontStyle;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      int i20 = this.layerMarkList.hashCode();
      localObject = this.applyFill;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.applyStroke;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.baselineShift;
      int i5;
      if (localObject != null) {
        i5 = localObject.hashCode();
      } else {
        i5 = 0;
      }
      localObject = this.boxText;
      int i6;
      if (localObject != null) {
        i6 = localObject.hashCode();
      } else {
        i6 = 0;
      }
      localObject = this.firstBaseLine;
      int i7;
      if (localObject != null) {
        i7 = localObject.hashCode();
      } else {
        i7 = 0;
      }
      localObject = this.fauxBold;
      int i8;
      if (localObject != null) {
        i8 = localObject.hashCode();
      } else {
        i8 = 0;
      }
      localObject = this.fauxItalic;
      int i9;
      if (localObject != null) {
        i9 = localObject.hashCode();
      } else {
        i9 = 0;
      }
      localObject = this.fontSize;
      int i10;
      if (localObject != null) {
        i10 = localObject.hashCode();
      } else {
        i10 = 0;
      }
      localObject = this.strokeColor;
      int i11;
      if (localObject != null) {
        i11 = localObject.hashCode();
      } else {
        i11 = 0;
      }
      localObject = this.strokeOverFill;
      int i12;
      if (localObject != null) {
        i12 = localObject.hashCode();
      } else {
        i12 = 0;
      }
      localObject = this.stokeWidth;
      int i13;
      if (localObject != null) {
        i13 = localObject.hashCode();
      } else {
        i13 = 0;
      }
      localObject = this.justification;
      int i14;
      if (localObject != null) {
        i14 = localObject.hashCode();
      } else {
        i14 = 0;
      }
      localObject = this.leading;
      int i15;
      if (localObject != null) {
        i15 = localObject.hashCode();
      } else {
        i15 = 0;
      }
      localObject = this.tracking;
      int i16;
      if (localObject != null) {
        i16 = localObject.hashCode();
      } else {
        i16 = 0;
      }
      localObject = this.backgroundColor;
      int i17;
      if (localObject != null) {
        i17 = localObject.hashCode();
      } else {
        i17 = 0;
      }
      localObject = this.backgroundAlpha;
      if (localObject != null) {
        i18 = localObject.hashCode();
      }
      i = (((((((((((((((((((((((i19 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i20) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8) * 37 + i9) * 37 + i10) * 37 + i11) * 37 + i12) * 37 + i13) * 37 + i14) * 37 + i15) * 37 + i16) * 37 + i17) * 37 + i18;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TextLayerData.Builder newBuilder()
  {
    TextLayerData.Builder localBuilder = new TextLayerData.Builder();
    localBuilder.layerIndex = this.layerIndex;
    localBuilder.layerName = this.layerName;
    localBuilder.layerType = this.layerType;
    localBuilder.defaultText = this.defaultText;
    localBuilder.textColor = this.textColor;
    localBuilder.fontFamily = this.fontFamily;
    localBuilder.fontStyle = this.fontStyle;
    localBuilder.layerMarkList = this.layerMarkList;
    localBuilder.applyFill = this.applyFill;
    localBuilder.applyStroke = this.applyStroke;
    localBuilder.baselineShift = this.baselineShift;
    localBuilder.boxText = this.boxText;
    localBuilder.firstBaseLine = this.firstBaseLine;
    localBuilder.fauxBold = this.fauxBold;
    localBuilder.fauxItalic = this.fauxItalic;
    localBuilder.fontSize = this.fontSize;
    localBuilder.strokeColor = this.strokeColor;
    localBuilder.strokeOverFill = this.strokeOverFill;
    localBuilder.stokeWidth = this.stokeWidth;
    localBuilder.justification = this.justification;
    localBuilder.leading = this.leading;
    localBuilder.tracking = this.tracking;
    localBuilder.backgroundColor = this.backgroundColor;
    localBuilder.backgroundAlpha = this.backgroundAlpha;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.layerIndex != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("layerIndex=");
      localStringBuilder.append(this.layerIndex);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.layerName != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("layerName=");
      localStringBuilder.append(Internal.sanitize(this.layerName));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.layerType != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("layerType=");
      localStringBuilder.append(this.layerType);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.defaultText != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("defaultText=");
      localStringBuilder.append(Internal.sanitize(this.defaultText));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.textColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("textColor=");
      localStringBuilder.append(this.textColor);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fontFamily != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontFamily=");
      localStringBuilder.append(Internal.sanitize(this.fontFamily));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fontStyle != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontStyle=");
      localStringBuilder.append(Internal.sanitize(this.fontStyle));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.layerMarkList).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("layerMarkList=");
      localStringBuilder.append(this.layerMarkList);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.applyFill != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyFill=");
      localStringBuilder.append(this.applyFill);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.applyStroke != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyStroke=");
      localStringBuilder.append(this.applyStroke);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.baselineShift != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("baselineShift=");
      localStringBuilder.append(this.baselineShift);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.boxText != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("boxText=");
      localStringBuilder.append(this.boxText);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.firstBaseLine != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("firstBaseLine=");
      localStringBuilder.append(this.firstBaseLine);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fauxBold != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fauxBold=");
      localStringBuilder.append(this.fauxBold);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fauxItalic != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fauxItalic=");
      localStringBuilder.append(this.fauxItalic);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fontSize != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontSize=");
      localStringBuilder.append(this.fontSize);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.strokeColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("strokeColor=");
      localStringBuilder.append(this.strokeColor);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.strokeOverFill != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("strokeOverFill=");
      localStringBuilder.append(this.strokeOverFill);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.stokeWidth != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stokeWidth=");
      localStringBuilder.append(this.stokeWidth);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.justification != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("justification=");
      localStringBuilder.append(this.justification);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.leading != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("leading=");
      localStringBuilder.append(this.leading);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.tracking != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tracking=");
      localStringBuilder.append(this.tracking);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundColor=");
      localStringBuilder.append(this.backgroundColor);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundAlpha != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundAlpha=");
      localStringBuilder.append(this.backgroundAlpha);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"TextLayerData{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.TextLayerData
 * JD-Core Version:    0.7.0.1
 */