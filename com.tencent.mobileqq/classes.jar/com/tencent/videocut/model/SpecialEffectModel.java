package com.tencent.videocut.model;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/SpecialEffectModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "id", "", "name", "bgColor", "", "startTimeUs", "", "durationUs", "createTimeMs", "scale", "", "filePath", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "actionScope", "Lcom/tencent/videocut/model/ActionScope;", "timeLineIndex", "materialId", "categoryId", "portraitFilePath", "landscapeFilePath", "type", "Lcom/tencent/videocut/model/SpecialEffectResType;", "jsPath", "jsContentCache", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;Lcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/ActionScope;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/model/SpecialEffectResType;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "Ljava/lang/Float;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;Lcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/ActionScope;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/model/SpecialEffectResType;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/videocut/model/SpecialEffectModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SpecialEffectModel
  extends AndroidMessage<SpecialEffectModel, SpecialEffectModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<SpecialEffectModel> ADAPTER = (ProtoAdapter)new SpecialEffectModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SpecialEffectModel.class), "type.googleapis.com/publisher.SpecialEffectModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<SpecialEffectModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final SpecialEffectModel.Companion Companion = new SpecialEffectModel.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.ActionScope#ADAPTER", tag=10)
  @JvmField
  @Nullable
  public final ActionScope actionScope;
  @WireField(adapter="com.tencent.videocut.model.AnimationMode#ADAPTER", tag=9)
  @JvmField
  @Nullable
  public final AnimationMode animationMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  @Nullable
  public final Integer bgColor;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=13)
  @JvmField
  @Nullable
  public final String categoryId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=6)
  @JvmField
  @Nullable
  public final Long createTimeMs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=5)
  @JvmField
  @Nullable
  public final Long durationUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=8)
  @JvmField
  @Nullable
  public final String filePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String id;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=18)
  @JvmField
  @Nullable
  public final String jsContentCache;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=17)
  @JvmField
  @Nullable
  public final String jsPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=15)
  @JvmField
  @Nullable
  public final String landscapeFilePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=12)
  @JvmField
  @Nullable
  public final String materialId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=2)
  @JvmField
  @Nullable
  public final String name;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=14)
  @JvmField
  @Nullable
  public final String portraitFilePath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=7)
  @JvmField
  @Nullable
  public final Float scale;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT64", tag=4)
  @JvmField
  @Nullable
  public final Long startTimeUs;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=11)
  @JvmField
  @Nullable
  public final Integer timeLineIndex;
  @WireField(adapter="com.tencent.videocut.model.SpecialEffectResType#ADAPTER", tag=16)
  @JvmField
  @Nullable
  public final SpecialEffectResType type;
  
  public SpecialEffectModel()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
  }
  
  public SpecialEffectModel(@Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger1, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Float paramFloat, @Nullable String paramString3, @Nullable AnimationMode paramAnimationMode, @Nullable ActionScope paramActionScope, @Nullable Integer paramInteger2, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @Nullable SpecialEffectResType paramSpecialEffectResType, @Nullable String paramString8, @Nullable String paramString9, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.name = paramString2;
    this.bgColor = paramInteger1;
    this.startTimeUs = paramLong1;
    this.durationUs = paramLong2;
    this.createTimeMs = paramLong3;
    this.scale = paramFloat;
    this.filePath = paramString3;
    this.animationMode = paramAnimationMode;
    this.actionScope = paramActionScope;
    this.timeLineIndex = paramInteger2;
    this.materialId = paramString4;
    this.categoryId = paramString5;
    this.portraitFilePath = paramString6;
    this.landscapeFilePath = paramString7;
    this.type = paramSpecialEffectResType;
    this.jsPath = paramString8;
    this.jsContentCache = paramString9;
  }
  
  @NotNull
  public final SpecialEffectModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable Integer paramInteger1, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Long paramLong3, @Nullable Float paramFloat, @Nullable String paramString3, @Nullable AnimationMode paramAnimationMode, @Nullable ActionScope paramActionScope, @Nullable Integer paramInteger2, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @Nullable SpecialEffectResType paramSpecialEffectResType, @Nullable String paramString8, @Nullable String paramString9, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new SpecialEffectModel(paramString1, paramString2, paramInteger1, paramLong1, paramLong2, paramLong3, paramFloat, paramString3, paramAnimationMode, paramActionScope, paramInteger2, paramString4, paramString5, paramString6, paramString7, paramSpecialEffectResType, paramString8, paramString9, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (SpecialEffectModel)this) {
      return true;
    }
    if (!(paramObject instanceof SpecialEffectModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (SpecialEffectModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.bgColor, paramObject.bgColor)) && (Intrinsics.areEqual(this.startTimeUs, paramObject.startTimeUs)) && (Intrinsics.areEqual(this.durationUs, paramObject.durationUs)) && (Intrinsics.areEqual(this.createTimeMs, paramObject.createTimeMs)) && (Intrinsics.areEqual(this.scale, paramObject.scale)) && (Intrinsics.areEqual(this.filePath, paramObject.filePath)) && (this.animationMode == paramObject.animationMode) && (this.actionScope == paramObject.actionScope) && (Intrinsics.areEqual(this.timeLineIndex, paramObject.timeLineIndex)) && (Intrinsics.areEqual(this.materialId, paramObject.materialId)) && (Intrinsics.areEqual(this.categoryId, paramObject.categoryId)) && (Intrinsics.areEqual(this.portraitFilePath, paramObject.portraitFilePath)) && (Intrinsics.areEqual(this.landscapeFilePath, paramObject.landscapeFilePath)) && (this.type == paramObject.type) && (Intrinsics.areEqual(this.jsPath, paramObject.jsPath)) && (Intrinsics.areEqual(this.jsContentCache, paramObject.jsContentCache));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i14 = unknownFields().hashCode();
      Object localObject = this.id;
      int i13 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.name;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.bgColor;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      localObject = this.startTimeUs;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.durationUs;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.createTimeMs;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.scale;
      int i2;
      if (localObject != null) {
        i2 = localObject.hashCode();
      } else {
        i2 = 0;
      }
      localObject = this.filePath;
      int i3;
      if (localObject != null) {
        i3 = localObject.hashCode();
      } else {
        i3 = 0;
      }
      localObject = this.animationMode;
      int i4;
      if (localObject != null) {
        i4 = localObject.hashCode();
      } else {
        i4 = 0;
      }
      localObject = this.actionScope;
      int i5;
      if (localObject != null) {
        i5 = localObject.hashCode();
      } else {
        i5 = 0;
      }
      localObject = this.timeLineIndex;
      int i6;
      if (localObject != null) {
        i6 = localObject.hashCode();
      } else {
        i6 = 0;
      }
      localObject = this.materialId;
      int i7;
      if (localObject != null) {
        i7 = localObject.hashCode();
      } else {
        i7 = 0;
      }
      localObject = this.categoryId;
      int i8;
      if (localObject != null) {
        i8 = localObject.hashCode();
      } else {
        i8 = 0;
      }
      localObject = this.portraitFilePath;
      int i9;
      if (localObject != null) {
        i9 = localObject.hashCode();
      } else {
        i9 = 0;
      }
      localObject = this.landscapeFilePath;
      int i10;
      if (localObject != null) {
        i10 = localObject.hashCode();
      } else {
        i10 = 0;
      }
      localObject = this.type;
      int i11;
      if (localObject != null) {
        i11 = localObject.hashCode();
      } else {
        i11 = 0;
      }
      localObject = this.jsPath;
      int i12;
      if (localObject != null) {
        i12 = localObject.hashCode();
      } else {
        i12 = 0;
      }
      localObject = this.jsContentCache;
      if (localObject != null) {
        i13 = localObject.hashCode();
      }
      i = (((((((((((((((((i14 * 37 + i) * 37 + j) * 37 + k) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + i3) * 37 + i4) * 37 + i5) * 37 + i6) * 37 + i7) * 37 + i8) * 37 + i9) * 37 + i10) * 37 + i11) * 37 + i12) * 37 + i13;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public SpecialEffectModel.Builder newBuilder()
  {
    SpecialEffectModel.Builder localBuilder = new SpecialEffectModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.name;
    localBuilder.c = this.bgColor;
    localBuilder.d = this.startTimeUs;
    localBuilder.e = this.durationUs;
    localBuilder.f = this.createTimeMs;
    localBuilder.g = this.scale;
    localBuilder.h = this.filePath;
    localBuilder.i = this.animationMode;
    localBuilder.j = this.actionScope;
    localBuilder.k = this.timeLineIndex;
    localBuilder.l = this.materialId;
    localBuilder.m = this.categoryId;
    localBuilder.n = this.portraitFilePath;
    localBuilder.o = this.landscapeFilePath;
    localBuilder.p = this.type;
    localBuilder.q = this.jsPath;
    localBuilder.r = this.jsContentCache;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.id != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(Internal.sanitize(this.id));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.name != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(Internal.sanitize(this.name));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.bgColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bgColor=");
      localStringBuilder.append(this.bgColor);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.startTimeUs != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startTimeUs=");
      localStringBuilder.append(this.startTimeUs);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.durationUs != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("durationUs=");
      localStringBuilder.append(this.durationUs);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.createTimeMs != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("createTimeMs=");
      localStringBuilder.append(this.createTimeMs);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.scale != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scale=");
      localStringBuilder.append(this.scale);
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
    if (this.animationMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("animationMode=");
      localStringBuilder.append(this.animationMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.actionScope != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("actionScope=");
      localStringBuilder.append(this.actionScope);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.timeLineIndex != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeLineIndex=");
      localStringBuilder.append(this.timeLineIndex);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.materialId != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("materialId=");
      localStringBuilder.append(Internal.sanitize(this.materialId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.categoryId != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("categoryId=");
      localStringBuilder.append(Internal.sanitize(this.categoryId));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.portraitFilePath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("portraitFilePath=");
      localStringBuilder.append(Internal.sanitize(this.portraitFilePath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.landscapeFilePath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("landscapeFilePath=");
      localStringBuilder.append(Internal.sanitize(this.landscapeFilePath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.type != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("type=");
      localStringBuilder.append(this.type);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.jsPath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("jsPath=");
      localStringBuilder.append(Internal.sanitize(this.jsPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.jsContentCache != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("jsContentCache=");
      localStringBuilder.append(Internal.sanitize(this.jsContentCache));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"SpecialEffectModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.SpecialEffectModel
 * JD-Core Version:    0.7.0.1
 */