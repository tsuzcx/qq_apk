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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration$Builder;", "maxDuration", "", "minDuration", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MultiMedia$ImageDuration
  extends AndroidMessage<ImageDuration, MultiMedia.ImageDuration.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ImageDuration> ADAPTER = (ProtoAdapter)new MultiMedia.ImageDuration.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageDuration.class), "type.googleapis.com/publisher.MultiMedia.ImageDuration");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ImageDuration> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final MultiMedia.ImageDuration.Companion Companion = new MultiMedia.ImageDuration.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=1)
  @JvmField
  @Nullable
  public final Integer maxDuration;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", tag=2)
  @JvmField
  @Nullable
  public final Integer minDuration;
  
  public MultiMedia$ImageDuration()
  {
    this(null, null, null, 7, null);
  }
  
  public MultiMedia$ImageDuration(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.maxDuration = paramInteger1;
    this.minDuration = paramInteger2;
  }
  
  @NotNull
  public final ImageDuration copy(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new ImageDuration(paramInteger1, paramInteger2, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (ImageDuration)this) {
      return true;
    }
    if (!(paramObject instanceof ImageDuration)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (ImageDuration)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.maxDuration, paramObject.maxDuration)) && (Intrinsics.areEqual(this.minDuration, paramObject.minDuration));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      int k = unknownFields().hashCode();
      Integer localInteger = this.maxDuration;
      j = 0;
      if (localInteger != null) {
        i = localInteger.hashCode();
      } else {
        i = 0;
      }
      localInteger = this.minDuration;
      if (localInteger != null) {
        j = localInteger.hashCode();
      }
      i = (k * 37 + i) * 37 + j;
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public MultiMedia.ImageDuration.Builder newBuilder()
  {
    MultiMedia.ImageDuration.Builder localBuilder = new MultiMedia.ImageDuration.Builder();
    localBuilder.maxDuration = this.maxDuration;
    localBuilder.minDuration = this.minDuration;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if (this.maxDuration != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("maxDuration=");
      localStringBuilder.append(this.maxDuration);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if (this.minDuration != null)
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("minDuration=");
      localStringBuilder.append(this.minDuration);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"ImageDuration{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.MultiMedia.ImageDuration
 * JD-Core Version:    0.7.0.1
 */