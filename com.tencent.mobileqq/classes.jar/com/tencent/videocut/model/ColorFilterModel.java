package com.tencent.videocut.model;

import .r8.java8methods.utility.Integer.hashCode.II;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ColorFilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/ColorFilterModel$Builder;", "sharpness", "", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "unknownFields", "Lokio/ByteString;", "(IIIIIIIILokio/ByteString;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/ColorFilterModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ColorFilterModel
  extends AndroidMessage<ColorFilterModel, ColorFilterModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ColorFilterModel> ADAPTER = (ProtoAdapter)new ColorFilterModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ColorFilterModel.class), "type.googleapis.com/publisher.ColorFilterModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ColorFilterModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final ColorFilterModel.Companion Companion = new ColorFilterModel.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  public final int brightness;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  public final int contrast;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=5)
  @JvmField
  public final int highlights;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=4)
  @JvmField
  public final int hue;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=7)
  @JvmField
  public final int saturation;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=6)
  @JvmField
  public final int shadows;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  public final int sharpness;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=8)
  @JvmField
  public final int temperature;
  
  public ColorFilterModel()
  {
    this(0, 0, 0, 0, 0, 0, 0, 0, null, 511, null);
  }
  
  public ColorFilterModel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.sharpness = paramInt1;
    this.brightness = paramInt2;
    this.contrast = paramInt3;
    this.hue = paramInt4;
    this.highlights = paramInt5;
    this.shadows = paramInt6;
    this.saturation = paramInt7;
    this.temperature = paramInt8;
  }
  
  @NotNull
  public final ColorFilterModel copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable Integer paramInteger5, @Nullable Integer paramInteger6, @Nullable Integer paramInteger7, @Nullable Integer paramInteger8, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    int i;
    if (paramInteger1 != null) {
      i = paramInteger1.intValue();
    } else {
      i = 0;
    }
    int j;
    if (paramInteger2 != null) {
      j = paramInteger2.intValue();
    } else {
      j = 0;
    }
    int k;
    if (paramInteger3 != null) {
      k = paramInteger3.intValue();
    } else {
      k = 0;
    }
    int m;
    if (paramInteger4 != null) {
      m = paramInteger4.intValue();
    } else {
      m = 0;
    }
    int n;
    if (paramInteger5 != null) {
      n = paramInteger5.intValue();
    } else {
      n = 0;
    }
    int i1;
    if (paramInteger6 != null) {
      i1 = paramInteger6.intValue();
    } else {
      i1 = 0;
    }
    int i2;
    if (paramInteger7 != null) {
      i2 = paramInteger7.intValue();
    } else {
      i2 = 0;
    }
    int i3;
    if (paramInteger8 != null) {
      i3 = paramInteger8.intValue();
    } else {
      i3 = 0;
    }
    return new ColorFilterModel(i, j, k, m, n, i1, i2, i3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (ColorFilterModel)this) {
      return true;
    }
    if (!(paramObject instanceof ColorFilterModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (ColorFilterModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.sharpness == paramObject.sharpness) && (this.brightness == paramObject.brightness) && (this.contrast == paramObject.contrast) && (this.hue == paramObject.hue) && (this.highlights == paramObject.highlights) && (this.shadows == paramObject.shadows) && (this.saturation == paramObject.saturation) && (this.temperature == paramObject.temperature);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (((((((unknownFields().hashCode() * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.sharpness)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.brightness)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.contrast)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.hue)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.highlights)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.shadows)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.saturation)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.temperature);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public ColorFilterModel.Builder newBuilder()
  {
    ColorFilterModel.Builder localBuilder = new ColorFilterModel.Builder();
    localBuilder.a = Integer.valueOf(this.sharpness);
    localBuilder.b = Integer.valueOf(this.brightness);
    localBuilder.c = Integer.valueOf(this.contrast);
    localBuilder.d = Integer.valueOf(this.hue);
    localBuilder.e = Integer.valueOf(this.highlights);
    localBuilder.f = Integer.valueOf(this.shadows);
    localBuilder.g = Integer.valueOf(this.saturation);
    localBuilder.h = Integer.valueOf(this.temperature);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    int i = this.sharpness;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sharpness=");
    localStringBuilder.append(this.sharpness);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.brightness;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("brightness=");
    localStringBuilder.append(this.brightness);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.contrast;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("contrast=");
    localStringBuilder.append(this.contrast);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.hue;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("hue=");
    localStringBuilder.append(this.hue);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.highlights;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("highlights=");
    localStringBuilder.append(this.highlights);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.shadows;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shadows=");
    localStringBuilder.append(this.shadows);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.saturation;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("saturation=");
    localStringBuilder.append(this.saturation);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.temperature;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("temperature=");
    localStringBuilder.append(this.temperature);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"ColorFilterModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ColorFilterModel
 * JD-Core Version:    0.7.0.1
 */