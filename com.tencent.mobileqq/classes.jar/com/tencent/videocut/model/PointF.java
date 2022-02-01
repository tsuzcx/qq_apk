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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/PointF;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/PointF$Builder;", "x", "", "y", "unknownFields", "Lokio/ByteString;", "(FFLokio/ByteString;)V", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lokio/ByteString;)Lcom/tencent/videocut/model/PointF;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PointF
  extends AndroidMessage<PointF, PointF.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<PointF> ADAPTER = (ProtoAdapter)new PointF.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PointF.class), "type.googleapis.com/publisher.PointF");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<PointF> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final PointF.Companion Companion = new PointF.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=1)
  @JvmField
  public final float x;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=2)
  @JvmField
  public final float y;
  
  public PointF()
  {
    this(0.0F, 0.0F, null, 7, null);
  }
  
  public PointF(float paramFloat1, float paramFloat2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  @NotNull
  public final PointF copy(@Nullable Float paramFloat1, @Nullable Float paramFloat2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    float f2 = 0.0F;
    float f1;
    if (paramFloat1 != null) {
      f1 = paramFloat1.floatValue();
    } else {
      f1 = 0.0F;
    }
    if (paramFloat2 != null) {
      f2 = paramFloat2.floatValue();
    }
    return new PointF(f1, f2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (PointF)this) {
      return true;
    }
    if (!(paramObject instanceof PointF)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (PointF)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.x == paramObject.x) && (this.y == paramObject.y);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (unknownFields().hashCode() * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.x)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.y);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public PointF.Builder newBuilder()
  {
    PointF.Builder localBuilder = new PointF.Builder();
    localBuilder.a = this.x;
    localBuilder.b = this.y;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    float f = this.x;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x=");
    localStringBuilder.append(this.x);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.y;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("y=");
    localStringBuilder.append(this.y);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"PointF{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PointF
 * JD-Core Version:    0.7.0.1
 */