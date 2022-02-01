package com.tencent.videocut.model;

import .r8.java8methods.utility.Float.hashCode.IF;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/Transform;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/Transform$Builder;", "rotate", "", "scale", "anchorPoint", "Lcom/tencent/videocut/model/PointF;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "unknownFields", "Lokio/ByteString;", "(FFLcom/tencent/videocut/model/PointF;Lcom/tencent/videocut/model/SizeF;Lokio/ByteString;)V", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/tencent/videocut/model/PointF;Lcom/tencent/videocut/model/SizeF;Lokio/ByteString;)Lcom/tencent/videocut/model/Transform;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Transform
  extends AndroidMessage<Transform, Transform.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Transform> ADAPTER = (ProtoAdapter)new Transform.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Transform.class), "type.googleapis.com/publisher.Transform");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Transform> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Transform.Companion Companion = new Transform.Companion(null);
  @WireField(adapter="com.tencent.videocut.model.PointF#ADAPTER", tag=3)
  @JvmField
  @Nullable
  public final PointF anchorPoint;
  @WireField(adapter="com.tencent.videocut.model.SizeF#ADAPTER", tag=4)
  @JvmField
  @Nullable
  public final SizeF renderSize;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=1)
  @JvmField
  public final float rotate;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=2)
  @JvmField
  public final float scale;
  
  public Transform()
  {
    this(0.0F, 0.0F, null, null, null, 31, null);
  }
  
  public Transform(float paramFloat1, float paramFloat2, @Nullable PointF paramPointF, @Nullable SizeF paramSizeF, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.rotate = paramFloat1;
    this.scale = paramFloat2;
    this.anchorPoint = paramPointF;
    this.renderSize = paramSizeF;
  }
  
  @NotNull
  public final Transform copy(@Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable PointF paramPointF, @Nullable SizeF paramSizeF, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    float f1;
    if (paramFloat1 != null) {
      f1 = paramFloat1.floatValue();
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramFloat2 != null) {
      f2 = paramFloat2.floatValue();
    } else {
      f2 = 0.0F;
    }
    return new Transform(f1, f2, paramPointF, paramSizeF, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Transform)this) {
      return true;
    }
    if (!(paramObject instanceof Transform)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Transform)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.rotate == paramObject.rotate) && (this.scale == paramObject.scale) && (Intrinsics.areEqual(this.anchorPoint, paramObject.anchorPoint)) && (Intrinsics.areEqual(this.renderSize, paramObject.renderSize));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int k = unknownFields().hashCode();
      int m = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.rotate);
      int n = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.scale);
      Object localObject = this.anchorPoint;
      j = 0;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.renderSize;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      i = (((k * 37 + m) * 37 + n) * 37 + i) * 37 + j;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Transform.Builder newBuilder()
  {
    Transform.Builder localBuilder = new Transform.Builder();
    localBuilder.a = this.rotate;
    localBuilder.b = this.scale;
    localBuilder.c = this.anchorPoint;
    localBuilder.d = this.renderSize;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    float f = this.rotate;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rotate=");
    localStringBuilder.append(this.rotate);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.scale;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("scale=");
    localStringBuilder.append(this.scale);
    ((Collection)localObject2).add(localStringBuilder.toString());
    if (this.anchorPoint != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("anchorPoint=");
      localStringBuilder.append(this.anchorPoint);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.renderSize != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("renderSize=");
      localStringBuilder.append(this.renderSize);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"Transform{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.Transform
 * JD-Core Version:    0.7.0.1
 */