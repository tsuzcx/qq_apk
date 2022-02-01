package com.tencent.tavcut.composition.model.component;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Size;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Size$Builder;", "width", "", "height", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Size;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Size
  extends AndroidMessage<Size, Size.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Size> ADAPTER = (ProtoAdapter)new Size.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Size.class), "type.googleapis.com/publisher.Size");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Size> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final Size.Companion Companion = new Size.Companion(null);
  public static final int DEFAULT_HEIGHT = 0;
  public static final int DEFAULT_WIDTH = 0;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  @Nullable
  public final Integer height;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer width;
  
  public Size()
  {
    this(null, null, null, 7, null);
  }
  
  public Size(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.width = paramInteger1;
    this.height = paramInteger2;
  }
  
  @NotNull
  public final Size copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Size(paramInteger1, paramInteger2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Size)this) {
      return true;
    }
    if (!(paramObject instanceof Size)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Size)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.width, paramObject.width)) && (Intrinsics.areEqual(this.height, paramObject.height));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int k = unknownFields().hashCode();
      Integer localInteger = this.width;
      j = 0;
      if (localInteger != null) {
        i = localInteger.hashCode();
      } else {
        i = 0;
      }
      localInteger = this.height;
      if (localInteger != null) {
        j = localInteger.hashCode();
      }
      i = (k * 37 + i) * 37 + j;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public Size.Builder newBuilder()
  {
    Size.Builder localBuilder = new Size.Builder();
    localBuilder.width = this.width;
    localBuilder.height = this.height;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.width != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("width=");
      localStringBuilder.append(this.width);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.height != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("height=");
      localStringBuilder.append(this.height);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"Size{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Size
 * JD-Core Version:    0.7.0.1
 */