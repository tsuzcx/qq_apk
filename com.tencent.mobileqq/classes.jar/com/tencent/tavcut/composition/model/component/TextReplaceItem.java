package com.tencent.tavcut.composition.model.component;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "fauxBold", "", "fauxItalic", "fontFamily", "", "fontPath", "applyStroke", "strokeColor", "strokeWidth", "", "leading", "tracking", "backgroundColor", "backgroundAlpha", "", "textColor", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextReplaceItem
  extends AndroidMessage<TextReplaceItem, TextReplaceItem.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TextReplaceItem> ADAPTER = (ProtoAdapter)new TextReplaceItem.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextReplaceItem.class), "type.googleapis.com/publisher.TextReplaceItem");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<TextReplaceItem> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TextReplaceItem.Companion Companion = new TextReplaceItem.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=10)
  @JvmField
  @Nullable
  public final Boolean applyStroke;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=16)
  @JvmField
  @Nullable
  public final Integer backgroundAlpha;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=15)
  @JvmField
  @Nullable
  public final String backgroundColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=6)
  @JvmField
  @Nullable
  public final Boolean fauxBold;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#BOOL", tag=7)
  @JvmField
  @Nullable
  public final Boolean fauxItalic;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=8)
  @JvmField
  @Nullable
  public final String fontFamily;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=9)
  @JvmField
  @Nullable
  public final String fontPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=13)
  @JvmField
  @Nullable
  public final Float leading;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=11)
  @JvmField
  @Nullable
  public final String strokeColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=12)
  @JvmField
  @Nullable
  public final Float strokeWidth;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=17)
  @JvmField
  @Nullable
  public final String textColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=14)
  @JvmField
  @Nullable
  public final Float tracking;
  
  public TextReplaceItem()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
  }
  
  public TextReplaceItem(@Nullable Boolean paramBoolean1, @Nullable Boolean paramBoolean2, @Nullable String paramString1, @Nullable String paramString2, @Nullable Boolean paramBoolean3, @Nullable String paramString3, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable Float paramFloat3, @Nullable String paramString4, @Nullable Integer paramInteger, @Nullable String paramString5, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.fauxBold = paramBoolean1;
    this.fauxItalic = paramBoolean2;
    this.fontFamily = paramString1;
    this.fontPath = paramString2;
    this.applyStroke = paramBoolean3;
    this.strokeColor = paramString3;
    this.strokeWidth = paramFloat1;
    this.leading = paramFloat2;
    this.tracking = paramFloat3;
    this.backgroundColor = paramString4;
    this.backgroundAlpha = paramInteger;
    this.textColor = paramString5;
  }
  
  @NotNull
  public final TextReplaceItem copy(@Nullable Boolean paramBoolean1, @Nullable Boolean paramBoolean2, @Nullable String paramString1, @Nullable String paramString2, @Nullable Boolean paramBoolean3, @Nullable String paramString3, @Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable Float paramFloat3, @Nullable String paramString4, @Nullable Integer paramInteger, @Nullable String paramString5, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new TextReplaceItem(paramBoolean1, paramBoolean2, paramString1, paramString2, paramBoolean3, paramString3, paramFloat1, paramFloat2, paramFloat3, paramString4, paramInteger, paramString5, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (TextReplaceItem)this) {
      return true;
    }
    if (!(paramObject instanceof TextReplaceItem)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (TextReplaceItem)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.fauxBold, paramObject.fauxBold)) && (Intrinsics.areEqual(this.fauxItalic, paramObject.fauxItalic)) && (Intrinsics.areEqual(this.fontFamily, paramObject.fontFamily)) && (Intrinsics.areEqual(this.fontPath, paramObject.fontPath)) && (Intrinsics.areEqual(this.applyStroke, paramObject.applyStroke)) && (Intrinsics.areEqual(this.strokeColor, paramObject.strokeColor)) && (Intrinsics.areEqual(this.strokeWidth, paramObject.strokeWidth)) && (Intrinsics.areEqual(this.leading, paramObject.leading)) && (Intrinsics.areEqual(this.tracking, paramObject.tracking)) && (Intrinsics.areEqual(this.backgroundColor, paramObject.backgroundColor)) && (Intrinsics.areEqual(this.backgroundAlpha, paramObject.backgroundAlpha)) && (Intrinsics.areEqual(this.textColor, paramObject.textColor));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i8 = unknownFields().hashCode();
      Object localObject = this.fauxBold;
      int i7 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.fauxItalic;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.fontFamily;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.fontPath;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.applyStroke;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.strokeColor;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.strokeWidth;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.leading;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.tracking;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.backgroundColor;
      int i5;
      if (localObject != null) {
        i5 = localObject.hashCode();
      } else {
        i5 = 0;
      }
      localObject = this.backgroundAlpha;
      int i6;
      if (localObject != null) {
        i6 = localObject.hashCode();
      } else {
        i6 = 0;
      }
      localObject = this.textColor;
      if (localObject != null) {
        i7 = localObject.hashCode();
      }
      i = (((((((((((i8 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TextReplaceItem.Builder newBuilder()
  {
    TextReplaceItem.Builder localBuilder = new TextReplaceItem.Builder();
    localBuilder.fauxBold = this.fauxBold;
    localBuilder.fauxItalic = this.fauxItalic;
    localBuilder.fontFamily = this.fontFamily;
    localBuilder.fontPath = this.fontPath;
    localBuilder.applyStroke = this.applyStroke;
    localBuilder.strokeColor = this.strokeColor;
    localBuilder.strokeWidth = this.strokeWidth;
    localBuilder.leading = this.leading;
    localBuilder.tracking = this.tracking;
    localBuilder.backgroundColor = this.backgroundColor;
    localBuilder.backgroundAlpha = this.backgroundAlpha;
    localBuilder.textColor = this.textColor;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
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
    if (this.fontFamily != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontFamily=");
      localStringBuilder.append(Internal.sanitize(this.fontFamily));
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
    if (this.applyStroke != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyStroke=");
      localStringBuilder.append(this.applyStroke);
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
    if (this.strokeWidth != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("strokeWidth=");
      localStringBuilder.append(this.strokeWidth);
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
      localStringBuilder.append(Internal.sanitize(this.backgroundColor));
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
    if (this.textColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("textColor=");
      localStringBuilder.append(Internal.sanitize(this.textColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"TextReplaceItem{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TextReplaceItem
 * JD-Core Version:    0.7.0.1
 */