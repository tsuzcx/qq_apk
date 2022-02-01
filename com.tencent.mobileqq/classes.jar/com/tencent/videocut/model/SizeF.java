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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/SizeF;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/SizeF$Builder;", "width", "", "height", "unknownFields", "Lokio/ByteString;", "(FFLokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SizeF
  extends AndroidMessage<SizeF, SizeF.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<SizeF> ADAPTER = (ProtoAdapter)new SizeF.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SizeF.class), "type.googleapis.com/publisher.SizeF");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<SizeF> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final SizeF.Companion Companion = new SizeF.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=2)
  @JvmField
  public final float height;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#FLOAT", tag=1)
  @JvmField
  public final float width;
  
  public SizeF()
  {
    this(0.0F, 0.0F, null, 7, null);
  }
  
  public SizeF(float paramFloat1, float paramFloat2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  @NotNull
  public final SizeF copy(float paramFloat1, float paramFloat2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new SizeF(paramFloat1, paramFloat2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (SizeF)this) {
      return true;
    }
    if (!(paramObject instanceof SizeF)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (SizeF)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.width == paramObject.width) && (this.height == paramObject.height);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (unknownFields().hashCode() * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.width)) * 37 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.height);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public SizeF.Builder newBuilder()
  {
    SizeF.Builder localBuilder = new SizeF.Builder();
    localBuilder.a = this.width;
    localBuilder.b = this.height;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    float f = this.width;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("width=");
    localStringBuilder.append(this.width);
    ((Collection)localObject2).add(localStringBuilder.toString());
    f = this.height;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("height=");
    localStringBuilder.append(this.height);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"SizeF{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.SizeF
 * JD-Core Version:    0.7.0.1
 */