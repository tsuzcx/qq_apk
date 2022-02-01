package com.tencent.tavcut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import .r8.java8methods.utility.Integer.hashCode.II;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/TextPlaceInfo;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/TextPlaceInfo$Builder;", "key", "", "text", "fillColor", "", "maxLength", "layerWidth", "", "layerHeight", "replaceIndex", "entityId", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;IIFFIILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextPlaceInfo
  extends AndroidMessage<TextPlaceInfo, TextPlaceInfo.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<TextPlaceInfo> ADAPTER = (ProtoAdapter)new TextPlaceInfo.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextPlaceInfo.class), "type.googleapis.com/publisher.TextPlaceInfo");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<TextPlaceInfo> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final TextPlaceInfo.Companion Companion = new TextPlaceInfo.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=8)
  @JvmField
  public final int entityId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=3)
  @JvmField
  public final int fillColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String key;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=6)
  @JvmField
  public final float layerHeight;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=5)
  @JvmField
  public final float layerWidth;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=4)
  @JvmField
  public final int maxLength;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REQUIRED, tag=7)
  @JvmField
  public final int replaceIndex;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String text;
  
  public TextPlaceInfo(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.key = paramString1;
    this.text = paramString2;
    this.fillColor = paramInt1;
    this.maxLength = paramInt2;
    this.layerWidth = paramFloat1;
    this.layerHeight = paramFloat2;
    this.replaceIndex = paramInt3;
    this.entityId = paramInt4;
  }
  
  @NotNull
  public final TextPlaceInfo copy(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new TextPlaceInfo(paramString1, paramString2, paramInt1, paramInt2, paramFloat1, paramFloat2, paramInt3, paramInt4, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (TextPlaceInfo)this) {
      return true;
    }
    if (!(paramObject instanceof TextPlaceInfo)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (TextPlaceInfo)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.key, paramObject.key)) && (Intrinsics.areEqual(this.text, paramObject.text)) && (this.fillColor == paramObject.fillColor) && (this.maxLength == paramObject.maxLength) && (this.layerWidth == paramObject.layerWidth) && (this.layerHeight == paramObject.layerHeight) && (this.replaceIndex == paramObject.replaceIndex) && (this.entityId == paramObject.entityId);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int k = unknownFields().hashCode();
      String str = this.key;
      j = 0;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      str = this.text;
      if (str != null) {
        j = str.hashCode();
      }
      i = (((((((k * 37 + i) * 37 + j) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.fillColor)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.maxLength)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.layerWidth)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.layerHeight)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.replaceIndex)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.entityId);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public TextPlaceInfo.Builder newBuilder()
  {
    TextPlaceInfo.Builder localBuilder = new TextPlaceInfo.Builder();
    localBuilder.key = this.key;
    localBuilder.text = this.text;
    localBuilder.fillColor = Integer.valueOf(this.fillColor);
    localBuilder.maxLength = Integer.valueOf(this.maxLength);
    localBuilder.layerWidth = Float.valueOf(this.layerWidth);
    localBuilder.layerHeight = Float.valueOf(this.layerHeight);
    localBuilder.replaceIndex = Integer.valueOf(this.replaceIndex);
    localBuilder.entityId = Integer.valueOf(this.entityId);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.key != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key=");
      localStringBuilder.append(Internal.sanitize(this.key));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.text != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("text=");
      localStringBuilder.append(Internal.sanitize(this.text));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fillColor=");
    localStringBuilder.append(this.fillColor);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxLength=");
    localStringBuilder.append(this.maxLength);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("layerWidth=");
    localStringBuilder.append(this.layerWidth);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("layerHeight=");
    localStringBuilder.append(this.layerHeight);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("replaceIndex=");
    localStringBuilder.append(this.replaceIndex);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("entityId=");
    localStringBuilder.append(this.entityId);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"TextPlaceInfo{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.TextPlaceInfo
 * JD-Core Version:    0.7.0.1
 */