package com.tencent.tavcut.composition.model.component;

import .r8.java8methods.utility.Float.hashCode.IF;
import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Vec3;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Vec3$Builder;", "x", "", "y", "z", "unknownFields", "Lokio/ByteString;", "(FFFLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Vec3
  extends AndroidMessage<Vec3, Vec3.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Vec3> ADAPTER = (ProtoAdapter)new Vec3.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Vec3.class), "type.googleapis.com/publisher.Vec3");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Vec3> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Vec3.Companion Companion = new Vec3.Companion(null);
  public static final float DEFAULT_X = 0.0F;
  public static final float DEFAULT_Y = 0.0F;
  public static final float DEFAULT_Z = 0.0F;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=1)
  @JvmField
  public final float x;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final float y;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=3)
  @JvmField
  public final float z;
  
  public Vec3(float paramFloat1, float paramFloat2, float paramFloat3, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  @NotNull
  public final Vec3 copy(float paramFloat1, float paramFloat2, float paramFloat3, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Vec3(paramFloat1, paramFloat2, paramFloat3, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Vec3)this) {
      return true;
    }
    if (!(paramObject instanceof Vec3)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Vec3)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.x == paramObject.x) && (this.y == paramObject.y) && (this.z == paramObject.z);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = ((unknownFields().hashCode() * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.x)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.y)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.z);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Vec3.Builder newBuilder()
  {
    Vec3.Builder localBuilder = new Vec3.Builder();
    localBuilder.x = Float.valueOf(this.x);
    localBuilder.y = Float.valueOf(this.y);
    localBuilder.z = Float.valueOf(this.z);
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x=");
    localStringBuilder.append(this.x);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("y=");
    localStringBuilder.append(this.y);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("z=");
    localStringBuilder.append(this.z);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"Vec3{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Vec3
 * JD-Core Version:    0.7.0.1
 */