package com.tencent.videocut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/LutFilterModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/LutFilterModel$Builder;", "name", "", "filterId", "filePath", "intensity", "", "categoryId", "themeId", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/videocut/model/LutFilterModel;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LutFilterModel
  extends AndroidMessage<LutFilterModel, LutFilterModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<LutFilterModel> ADAPTER = (ProtoAdapter)new LutFilterModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LutFilterModel.class), "type.googleapis.com/publisher.LutFilterModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<LutFilterModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final LutFilterModel.Companion Companion = new LutFilterModel.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String categoryId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=3)
  @JvmField
  @NotNull
  public final String filePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @NotNull
  public final String filterId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=4)
  @JvmField
  public final float intensity;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String name;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=6)
  @JvmField
  @Nullable
  public final String themeId;
  
  public LutFilterModel()
  {
    this(null, null, null, 0.0F, null, null, null, 127, null);
  }
  
  public LutFilterModel(@Nullable String paramString1, @NotNull String paramString2, @NotNull String paramString3, float paramFloat, @Nullable String paramString4, @Nullable String paramString5, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.name = paramString1;
    this.filterId = paramString2;
    this.filePath = paramString3;
    this.intensity = paramFloat;
    this.categoryId = paramString4;
    this.themeId = paramString5;
  }
  
  @NotNull
  public final LutFilterModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Float paramFloat, @Nullable String paramString4, @Nullable String paramString5, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    float f;
    if (paramFloat != null) {
      f = paramFloat.floatValue();
    } else {
      f = 0.0F;
    }
    return new LutFilterModel(paramString1, paramString2, paramString3, f, paramString4, paramString5, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (LutFilterModel)this) {
      return true;
    }
    if (!(paramObject instanceof LutFilterModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (LutFilterModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.filterId, paramObject.filterId)) && (Intrinsics.areEqual(this.filePath, paramObject.filePath)) && (this.intensity == paramObject.intensity) && (Intrinsics.areEqual(this.categoryId, paramObject.categoryId)) && (Intrinsics.areEqual(this.themeId, paramObject.themeId));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int m = unknownFields().hashCode();
      String str = this.name;
      int k = 0;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      int n = this.filterId.hashCode();
      int i1 = this.filePath.hashCode();
      int i2 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.intensity);
      str = this.categoryId;
      if (str != null) {
        j = str.hashCode();
      } else {
        j = 0;
      }
      str = this.themeId;
      if (str != null) {
        k = str.hashCode();
      }
      i = (((((m * 37 + i) * 37 + n) * 37 + i1) * 37 + i2) * 37 + j) * 37 + k;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public LutFilterModel.Builder newBuilder()
  {
    LutFilterModel.Builder localBuilder = new LutFilterModel.Builder();
    localBuilder.a = this.name;
    localBuilder.b = this.filterId;
    localBuilder.c = this.filePath;
    localBuilder.d = Float.valueOf(this.intensity);
    localBuilder.e = this.categoryId;
    localBuilder.f = this.themeId;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.name != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(Internal.sanitize(this.name));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.filterId != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filterId=");
      localStringBuilder.append(Internal.sanitize(this.filterId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.filePath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("filePath=");
      localStringBuilder.append(Internal.sanitize(this.filePath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    float f = this.intensity;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("intensity=");
    localStringBuilder.append(this.intensity);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.categoryId != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("categoryId=");
      localStringBuilder.append(Internal.sanitize(this.categoryId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.themeId != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("themeId=");
      localStringBuilder.append(Internal.sanitize(this.themeId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"LutFilterModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.LutFilterModel
 * JD-Core Version:    0.7.0.1
 */