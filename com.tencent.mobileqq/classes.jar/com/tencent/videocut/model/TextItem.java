package com.tencent.videocut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Integer.hashCode.II;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/TextItem;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TextItem$Builder;", "text", "", "textColor", "fontPath", "strokeColor", "strokeWidth", "", "shadowColor", "shadowOpacity", "opacity", "index", "", "fauxBold", "", "fauxItalic", "fontFamily", "applyStroke", "leading", "tracking", "backgroundColor", "backgroundAlpha", "layerSize", "Lcom/tencent/videocut/model/Size;", "fontStyle", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;ILcom/tencent/videocut/model/Size;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "Ljava/lang/Float;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/videocut/model/Size;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/videocut/model/TextItem;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TextItem
  extends AndroidMessage<TextItem, TextItem.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TextItem> ADAPTER = (ProtoAdapter)new TextItem.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextItem.class), "type.googleapis.com/publisher.TextItem");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<TextItem> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TextItem.Companion Companion = new TextItem.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=13)
  @JvmField
  @Nullable
  public final Boolean applyStroke;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=17)
  @JvmField
  public final int backgroundAlpha;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=16)
  @JvmField
  @NotNull
  public final String backgroundColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=10)
  @JvmField
  @Nullable
  public final Boolean fauxBold;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=11)
  @JvmField
  @Nullable
  public final Boolean fauxItalic;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=12)
  @JvmField
  @NotNull
  public final String fontFamily;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @NotNull
  public final String fontPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=19)
  @JvmField
  @NotNull
  public final String fontStyle;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=9)
  @JvmField
  public final int index;
  @WireField(adapter="com.tencent.videocut.model.Size#ADAPTER", tag=18)
  @JvmField
  @Nullable
  public final Size layerSize;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=14)
  @JvmField
  @Nullable
  public final Float leading;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=8)
  @JvmField
  @Nullable
  public final Float opacity;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
  @JvmField
  @NotNull
  public final String shadowColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=7)
  @JvmField
  @Nullable
  public final Float shadowOpacity;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @NotNull
  public final String strokeColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=5)
  @JvmField
  public final float strokeWidth;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @NotNull
  public final String text;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @NotNull
  public final String textColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=15)
  @JvmField
  @Nullable
  public final Float tracking;
  
  public TextItem()
  {
    this(null, null, null, null, 0.0F, null, null, null, 0, null, null, null, null, null, null, null, 0, null, null, null, 1048575, null);
  }
  
  public TextItem(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, float paramFloat, @NotNull String paramString5, @Nullable Float paramFloat1, @Nullable Float paramFloat2, int paramInt1, @Nullable Boolean paramBoolean1, @Nullable Boolean paramBoolean2, @NotNull String paramString6, @Nullable Boolean paramBoolean3, @Nullable Float paramFloat3, @Nullable Float paramFloat4, @NotNull String paramString7, int paramInt2, @Nullable Size paramSize, @NotNull String paramString8, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.text = paramString1;
    this.textColor = paramString2;
    this.fontPath = paramString3;
    this.strokeColor = paramString4;
    this.strokeWidth = paramFloat;
    this.shadowColor = paramString5;
    this.shadowOpacity = paramFloat1;
    this.opacity = paramFloat2;
    this.index = paramInt1;
    this.fauxBold = paramBoolean1;
    this.fauxItalic = paramBoolean2;
    this.fontFamily = paramString6;
    this.applyStroke = paramBoolean3;
    this.leading = paramFloat3;
    this.tracking = paramFloat4;
    this.backgroundColor = paramString7;
    this.backgroundAlpha = paramInt2;
    this.layerSize = paramSize;
    this.fontStyle = paramString8;
  }
  
  @NotNull
  public final TextItem copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable Float paramFloat1, @Nullable String paramString5, @Nullable Float paramFloat2, @Nullable Float paramFloat3, @Nullable Integer paramInteger1, @Nullable Boolean paramBoolean1, @Nullable Boolean paramBoolean2, @Nullable String paramString6, @Nullable Boolean paramBoolean3, @Nullable Float paramFloat4, @Nullable Float paramFloat5, @Nullable String paramString7, @Nullable Integer paramInteger2, @Nullable Size paramSize, @Nullable String paramString8, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    if (paramString4 == null) {
      paramString4 = "";
    }
    float f;
    if (paramFloat1 != null) {
      f = paramFloat1.floatValue();
    } else {
      f = 0.0F;
    }
    if (paramString5 != null) {
      paramFloat1 = paramString5;
    } else {
      paramFloat1 = "";
    }
    int i;
    if (paramInteger1 != null) {
      i = paramInteger1.intValue();
    } else {
      i = 0;
    }
    if (paramString6 != null) {
      paramString5 = paramString6;
    } else {
      paramString5 = "";
    }
    if (paramString7 != null) {
      paramInteger1 = paramString7;
    } else {
      paramInteger1 = "";
    }
    int j;
    if (paramInteger2 != null) {
      j = paramInteger2.intValue();
    } else {
      j = 0;
    }
    if (paramString8 == null) {
      paramString8 = "";
    }
    return new TextItem(paramString1, paramString2, paramString3, paramString4, f, paramFloat1, paramFloat2, paramFloat3, i, paramBoolean1, paramBoolean2, paramString5, paramBoolean3, paramFloat4, paramFloat5, paramInteger1, j, paramSize, paramString8, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (TextItem)this) {
      return true;
    }
    if (!(paramObject instanceof TextItem)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (TextItem)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.text, paramObject.text)) && (Intrinsics.areEqual(this.textColor, paramObject.textColor)) && (Intrinsics.areEqual(this.fontPath, paramObject.fontPath)) && (Intrinsics.areEqual(this.strokeColor, paramObject.strokeColor)) && (this.strokeWidth == paramObject.strokeWidth) && (Intrinsics.areEqual(this.shadowColor, paramObject.shadowColor)) && (Intrinsics.areEqual(this.shadowOpacity, paramObject.shadowOpacity)) && (Intrinsics.areEqual(this.opacity, paramObject.opacity)) && (this.index == paramObject.index) && (Intrinsics.areEqual(this.fauxBold, paramObject.fauxBold)) && (Intrinsics.areEqual(this.fauxItalic, paramObject.fauxItalic)) && (Intrinsics.areEqual(this.fontFamily, paramObject.fontFamily)) && (Intrinsics.areEqual(this.applyStroke, paramObject.applyStroke)) && (Intrinsics.areEqual(this.leading, paramObject.leading)) && (Intrinsics.areEqual(this.tracking, paramObject.tracking)) && (Intrinsics.areEqual(this.backgroundColor, paramObject.backgroundColor)) && (this.backgroundAlpha == paramObject.backgroundAlpha) && (Intrinsics.areEqual(this.layerSize, paramObject.layerSize)) && (Intrinsics.areEqual(this.fontStyle, paramObject.fontStyle));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i4 = unknownFields().hashCode();
      int i5 = this.text.hashCode();
      int i6 = this.textColor.hashCode();
      int i7 = this.fontPath.hashCode();
      int i8 = this.strokeColor.hashCode();
      int i9 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.strokeWidth);
      int i10 = this.shadowColor.hashCode();
      Object localObject = this.shadowOpacity;
      int i3 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.opacity;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      int i11 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.index);
      localObject = this.fauxBold;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.fauxItalic;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      int i12 = this.fontFamily.hashCode();
      localObject = this.applyStroke;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.leading;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.tracking;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      int i13 = this.backgroundColor.hashCode();
      int i14 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.backgroundAlpha);
      localObject = this.layerSize;
      if (localObject != null) {
        i3 = localObject.hashCode();
      }
      i = ((((((((((((((((((i4 * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8) * 37 + i9) * 37 + i10) * 37 + i) * 37 + j) * 37 + i11) * 37 + k) * 37 + m) * 37 + i12) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i13) * 37 + i14) * 37 + i3) * 37 + this.fontStyle.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TextItem.Builder newBuilder()
  {
    TextItem.Builder localBuilder = new TextItem.Builder();
    localBuilder.a = this.text;
    localBuilder.b = this.textColor;
    localBuilder.c = this.fontPath;
    localBuilder.d = this.strokeColor;
    localBuilder.e = this.strokeWidth;
    localBuilder.f = this.shadowColor;
    localBuilder.g = this.shadowOpacity;
    localBuilder.h = this.opacity;
    localBuilder.i = this.index;
    localBuilder.j = this.fauxBold;
    localBuilder.k = this.fauxItalic;
    localBuilder.l = this.fontFamily;
    localBuilder.m = this.applyStroke;
    localBuilder.n = this.leading;
    localBuilder.o = this.tracking;
    localBuilder.p = this.backgroundColor;
    localBuilder.q = this.backgroundAlpha;
    localBuilder.r = this.layerSize;
    localBuilder.s = this.fontStyle;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.text != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("text=");
      localStringBuilder.append(Internal.sanitize(this.text));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.textColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("textColor=");
      localStringBuilder.append(Internal.sanitize(this.textColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fontPath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontPath=");
      localStringBuilder.append(Internal.sanitize(this.fontPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.strokeColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("strokeColor=");
      localStringBuilder.append(Internal.sanitize(this.strokeColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    float f = this.strokeWidth;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("strokeWidth=");
    localStringBuilder.append(this.strokeWidth);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.shadowColor != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shadowColor=");
      localStringBuilder.append(Internal.sanitize(this.shadowColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.shadowOpacity != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shadowOpacity=");
      localStringBuilder.append(this.shadowOpacity);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.opacity != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("opacity=");
      localStringBuilder.append(this.opacity);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    int i = this.index;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("index=");
    localStringBuilder.append(this.index);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.fauxBold != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fauxBold=");
      localStringBuilder.append(this.fauxBold);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fauxItalic != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fauxItalic=");
      localStringBuilder.append(this.fauxItalic);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fontFamily != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontFamily=");
      localStringBuilder.append(Internal.sanitize(this.fontFamily));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.applyStroke != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyStroke=");
      localStringBuilder.append(this.applyStroke);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.leading != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("leading=");
      localStringBuilder.append(this.leading);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.tracking != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tracking=");
      localStringBuilder.append(this.tracking);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.backgroundColor != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundColor=");
      localStringBuilder.append(Internal.sanitize(this.backgroundColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    i = this.backgroundAlpha;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("backgroundAlpha=");
    localStringBuilder.append(this.backgroundAlpha);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.layerSize != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("layerSize=");
      localStringBuilder.append(this.layerSize);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.fontStyle != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontStyle=");
      localStringBuilder.append(Internal.sanitize(this.fontStyle));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"TextItem{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TextItem
 * JD-Core Version:    0.7.0.1
 */