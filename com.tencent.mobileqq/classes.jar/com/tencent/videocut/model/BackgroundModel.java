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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/BackgroundModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/BackgroundModel$Builder;", "id", "", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "bgFillMode", "Lcom/tencent/videocut/model/BackgroundFillMode;", "bgColor", "bgPagPath", "ratioType", "Lcom/tencent/videocut/model/RatioType;", "resPack", "Lcom/tencent/videocut/model/BackgroundResPack;", "categoryId", "fillScale", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Lcom/tencent/videocut/model/SizeF;Lcom/tencent/videocut/model/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/model/RatioType;Lcom/tencent/videocut/model/BackgroundResPack;Ljava/lang/String;FLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundModel
  extends AndroidMessage<BackgroundModel, BackgroundModel.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<BackgroundModel> ADAPTER = (ProtoAdapter)new BackgroundModel.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BackgroundModel.class), "type.googleapis.com/publisher.BackgroundModel");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<BackgroundModel> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final BackgroundModel.Companion Companion = new BackgroundModel.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=4)
  @JvmField
  @NotNull
  public final String bgColor;
  @WireField(adapter="com.tencent.videocut.model.BackgroundFillMode#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final BackgroundFillMode bgFillMode;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=5)
  @JvmField
  @Nullable
  public final String bgPagPath;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=8)
  @JvmField
  @Nullable
  public final String categoryId;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=9)
  @JvmField
  public final float fillScale;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#STRING", tag=1)
  @JvmField
  @Nullable
  public final String id;
  @WireField(adapter="com.tencent.videocut.model.RatioType#ADAPTER", tag=6)
  @JvmField
  @Nullable
  public final RatioType ratioType;
  @WireField(adapter="com.tencent.videocut.model.SizeF#ADAPTER", tag=2)
  @JvmField
  @Nullable
  public final SizeF renderSize;
  @WireField(adapter="com.tencent.videocut.model.BackgroundResPack#ADAPTER", tag=7)
  @JvmField
  @Nullable
  public final BackgroundResPack resPack;
  
  public BackgroundModel()
  {
    this(null, null, null, null, null, null, null, null, 0.0F, null, 1023, null);
  }
  
  public BackgroundModel(@Nullable String paramString1, @Nullable SizeF paramSizeF, @Nullable BackgroundFillMode paramBackgroundFillMode, @NotNull String paramString2, @Nullable String paramString3, @Nullable RatioType paramRatioType, @Nullable BackgroundResPack paramBackgroundResPack, @Nullable String paramString4, float paramFloat, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.id = paramString1;
    this.renderSize = paramSizeF;
    this.bgFillMode = paramBackgroundFillMode;
    this.bgColor = paramString2;
    this.bgPagPath = paramString3;
    this.ratioType = paramRatioType;
    this.resPack = paramBackgroundResPack;
    this.categoryId = paramString4;
    this.fillScale = paramFloat;
  }
  
  @NotNull
  public final BackgroundModel copy(@Nullable String paramString1, @Nullable SizeF paramSizeF, @Nullable BackgroundFillMode paramBackgroundFillMode, @Nullable String paramString2, @Nullable String paramString3, @Nullable RatioType paramRatioType, @Nullable BackgroundResPack paramBackgroundResPack, @Nullable String paramString4, float paramFloat, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    if (paramString2 == null) {
      paramString2 = "";
    }
    return new BackgroundModel(paramString1, paramSizeF, paramBackgroundFillMode, paramString2, paramString3, paramRatioType, paramBackgroundResPack, paramString4, paramFloat, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (BackgroundModel)this) {
      return true;
    }
    if (!(paramObject instanceof BackgroundModel)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (BackgroundModel)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.renderSize, paramObject.renderSize)) && (this.bgFillMode == paramObject.bgFillMode) && (Intrinsics.areEqual(this.bgColor, paramObject.bgColor)) && (Intrinsics.areEqual(this.bgPagPath, paramObject.bgPagPath)) && (this.ratioType == paramObject.ratioType) && (Intrinsics.areEqual(this.resPack, paramObject.resPack)) && (Intrinsics.areEqual(this.categoryId, paramObject.categoryId)) && (this.fillScale == paramObject.fillScale);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int i3 = unknownFields().hashCode();
      Object localObject = this.id;
      int i2 = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.renderSize;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.bgFillMode;
      int k;
      if (localObject != null) {
        k = localObject.hashCode();
      } else {
        k = 0;
      }
      int i4 = this.bgColor.hashCode();
      localObject = this.bgPagPath;
      int m;
      if (localObject != null) {
        m = localObject.hashCode();
      } else {
        m = 0;
      }
      localObject = this.ratioType;
      int n;
      if (localObject != null) {
        n = localObject.hashCode();
      } else {
        n = 0;
      }
      localObject = this.resPack;
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      localObject = this.categoryId;
      if (localObject != null) {
        i2 = localObject.hashCode();
      }
      i = ((((((((i3 * 37 + i) * 37 + j) * 37 + k) * 37 + i4) * 37 + m) * 37 + n) * 37 + i1) * 37 + i2) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.fillScale);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public BackgroundModel.Builder newBuilder()
  {
    BackgroundModel.Builder localBuilder = new BackgroundModel.Builder();
    localBuilder.a = this.id;
    localBuilder.b = this.renderSize;
    localBuilder.c = this.bgFillMode;
    localBuilder.d = this.bgColor;
    localBuilder.e = this.bgPagPath;
    localBuilder.f = this.ratioType;
    localBuilder.g = this.resPack;
    localBuilder.h = this.categoryId;
    localBuilder.i = this.fillScale;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    if (this.id != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(Internal.sanitize(this.id));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.renderSize != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("renderSize=");
      localStringBuilder.append(this.renderSize);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.bgFillMode != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bgFillMode=");
      localStringBuilder.append(this.bgFillMode);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.bgColor != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bgColor=");
      localStringBuilder.append(Internal.sanitize(this.bgColor));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.bgPagPath != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bgPagPath=");
      localStringBuilder.append(Internal.sanitize(this.bgPagPath));
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.ratioType != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ratioType=");
      localStringBuilder.append(this.ratioType);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.resPack != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resPack=");
      localStringBuilder.append(this.resPack);
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
    float f = this.fillScale;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fillScale=");
    localStringBuilder.append(this.fillScale);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"BackgroundModel{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.BackgroundModel
 * JD-Core Version:    0.7.0.1
 */