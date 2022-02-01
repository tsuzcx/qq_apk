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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Quat;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Quat$Builder;", "x", "", "y", "z", "w", "unknownFields", "Lokio/ByteString;", "(FFFFLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Quat
  extends AndroidMessage<Quat, Quat.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Quat> ADAPTER = (ProtoAdapter)new Quat.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Quat.class), "type.googleapis.com/publisher.Quat");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Quat> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Quat.Companion Companion = new Quat.Companion(null);
  public static final float DEFAULT_W = 0.0F;
  public static final float DEFAULT_X = 0.0F;
  public static final float DEFAULT_Y = 0.0F;
  public static final float DEFAULT_Z = 0.0F;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=4)
  @JvmField
  public final float w;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=1)
  @JvmField
  public final float x;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final float y;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=3)
  @JvmField
  public final float z;
  
  public Quat(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
  }
  
  @NotNull
  public final Quat copy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Quat(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Quat)this) {
      return true;
    }
    if (!(paramObject instanceof Quat)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Quat)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.x == paramObject.x) && (this.y == paramObject.y) && (this.z == paramObject.z) && (this.w == paramObject.w);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (((unknownFields().hashCode() * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.x)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.y)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.z)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.w);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Quat.Builder newBuilder()
  {
    Quat.Builder localBuilder = new Quat.Builder();
    localBuilder.x = Float.valueOf(this.x);
    localBuilder.y = Float.valueOf(this.y);
    localBuilder.z = Float.valueOf(this.z);
    localBuilder.w = Float.valueOf(this.w);
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
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("w=");
    localStringBuilder.append(this.w);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"Quat{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Quat
 * JD-Core Version:    0.7.0.1
 */