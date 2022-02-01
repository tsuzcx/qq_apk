package com.tencent.videocut.model;

import .r8.java8methods.utility.Integer.hashCode.II;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/Rect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/Rect$Builder;", "left", "", "top", "right", "bottom", "unknownFields", "Lokio/ByteString;", "(IIIILokio/ByteString;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/Rect;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Rect
  extends AndroidMessage<Rect, Rect.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Rect> ADAPTER = (ProtoAdapter)new Rect.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Rect.class), "type.googleapis.com/publisher.Rect");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Rect> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Rect.Companion Companion = new Rect.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=4)
  @JvmField
  public final int bottom;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  public final int left;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=3)
  @JvmField
  public final int right;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  public final int top;
  
  public Rect()
  {
    this(0, 0, 0, 0, null, 31, null);
  }
  
  public Rect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  @NotNull
  public final Rect copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    int i;
    if (paramInteger1 != null) {
      i = paramInteger1.intValue();
    } else {
      i = 0;
    }
    int j;
    if (paramInteger2 != null) {
      j = paramInteger2.intValue();
    } else {
      j = 0;
    }
    int k;
    if (paramInteger3 != null) {
      k = paramInteger3.intValue();
    } else {
      k = 0;
    }
    int m;
    if (paramInteger4 != null) {
      m = paramInteger4.intValue();
    } else {
      m = 0;
    }
    return new Rect(i, j, k, m, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Rect)this) {
      return true;
    }
    if (!(paramObject instanceof Rect)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Rect)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (this.left == paramObject.left) && (this.top == paramObject.top) && (this.right == paramObject.right) && (this.bottom == paramObject.bottom);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = (((unknownFields().hashCode() * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.left)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.top)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.right)) * 37 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.bottom);
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Rect.Builder newBuilder()
  {
    Rect.Builder localBuilder = new Rect.Builder();
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
    int i = this.left;
    Object localObject2 = (Collection)localObject1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("left=");
    localStringBuilder.append(this.left);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.top;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("top=");
    localStringBuilder.append(this.top);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.right;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("right=");
    localStringBuilder.append(this.right);
    ((Collection)localObject2).add(localStringBuilder.toString());
    i = this.bottom;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("bottom=");
    localStringBuilder.append(this.bottom);
    ((Collection)localObject2).add(localStringBuilder.toString());
    localObject1 = (Iterable)localObject1;
    localObject2 = (CharSequence)"Rect{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.Rect
 * JD-Core Version:    0.7.0.1
 */