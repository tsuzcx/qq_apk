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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Vec2;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Vec2$Builder;", "x", "", "y", "unknownFields", "Lokio/ByteString;", "(FFLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Vec2
  extends AndroidMessage<Vec2, Vec2.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Vec2> ADAPTER = (ProtoAdapter)new Vec2.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Vec2.class), "type.googleapis.com/publisher.Vec2");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Vec2> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Vec2.Companion Companion = new Vec2.Companion(null);
  public static final float DEFAULT_X = 0.0F;
  public static final float DEFAULT_Y = 0.0F;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=1)
  @JvmField
  public final float x;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", label=WireField.Label.REQUIRED, tag=2)
  @JvmField
  public final float y;
  
  public Vec2(float paramFloat1, float paramFloat2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  @NotNull
  public final Vec2 copy(float paramFloat1, float paramFloat2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Vec2(paramFloat1, paramFloat2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Vec2)this) {
      return true;
    }
    if (!(paramObject instanceof Vec2)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Vec2)paramObject;
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
  public Vec2.Builder newBuilder()
  {
    Vec2.Builder localBuilder = new Vec2.Builder();
    localBuilder.x = Float.valueOf(this.x);
    localBuilder.y = Float.valueOf(this.y);
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
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"Vec2{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Vec2
 * JD-Core Version:    0.7.0.1
 */