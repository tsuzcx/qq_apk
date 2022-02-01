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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/RectF;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/RectF$Builder;", "left", "", "top", "right", "bottom", "unknownFields", "Lokio/ByteString;", "(FFFFLokio/ByteString;)V", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/videocut/model/RectF;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class RectF
  extends AndroidMessage<RectF, RectF.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<RectF> ADAPTER = (ProtoAdapter)new RectF.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RectF.class), "type.googleapis.com/publisher.RectF");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<RectF> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final RectF.Companion Companion = new RectF.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=4)
  @JvmField
  public final float bottom;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=1)
  @JvmField
  public final float left;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=3)
  @JvmField
  public final float right;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=2)
  @JvmField
  public final float top;
  
  public RectF()
  {
    this(0.0F, 0.0F, 0.0F, 0.0F, null, 31, null);
  }
  
  public RectF(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
  }
  
  @NotNull
  public final RectF copy(@Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable Float paramFloat3, @Nullable Float paramFloat4, @NotNull ByteString paramByteString)
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
    float f3;
    if (paramFloat3 != null) {
      f3 = paramFloat3.floatValue();
    } else {
      f3 = 0.0F;
    }
    float f4;
    if (paramFloat4 != null) {
      f4 = paramFloat4.floatValue();
    } else {
      f4 = 0.0F;
    }
    return new RectF(f1, f2, f3, f4, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (RectF)this) {
      return true;
    }
    if (!(paramObject instanceof RectF)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (RectF)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.left == paramObject.left) && (this.top == paramObject.top) && (this.right == paramObject.right) && (this.bottom == paramObject.bottom);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (((unknownFields().hashCode() * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.left)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.top)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.right)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.bottom);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public RectF.Builder newBuilder()
  {
    RectF.Builder localBuilder = new RectF.Builder();
    localBuilder.a = this.left;
    localBuilder.b = this.top;
    localBuilder.c = this.right;
    localBuilder.d = this.bottom;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    float f = this.left;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("left=");
    localStringBuilder.append(this.left);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.top;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("top=");
    localStringBuilder.append(this.top);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.right;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("right=");
    localStringBuilder.append(this.right);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.bottom;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("bottom=");
    localStringBuilder.append(this.bottom);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"RectF{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.RectF
 * JD-Core Version:    0.7.0.1
 */