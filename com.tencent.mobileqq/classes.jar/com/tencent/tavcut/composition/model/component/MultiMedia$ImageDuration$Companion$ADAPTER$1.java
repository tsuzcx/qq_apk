package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MultiMedia$ImageDuration$Companion$ADAPTER$1
  extends ProtoAdapter<MultiMedia.ImageDuration>
{
  MultiMedia$ImageDuration$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public MultiMedia.ImageDuration decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger2 = (Integer)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger1 = localInteger2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new MultiMedia.ImageDuration(localInteger2, localInteger1, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        }
      }
      else {
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull MultiMedia.ImageDuration paramImageDuration)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramImageDuration, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramImageDuration.maxDuration);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramImageDuration.minDuration);
    paramProtoWriter.writeBytes(paramImageDuration.unknownFields());
  }
  
  public int encodedSize(@NotNull MultiMedia.ImageDuration paramImageDuration)
  {
    Intrinsics.checkParameterIsNotNull(paramImageDuration, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramImageDuration.maxDuration) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramImageDuration.minDuration) + paramImageDuration.unknownFields().size();
  }
  
  @NotNull
  public MultiMedia.ImageDuration redact(@NotNull MultiMedia.ImageDuration paramImageDuration)
  {
    Intrinsics.checkParameterIsNotNull(paramImageDuration, "value");
    return MultiMedia.ImageDuration.copy$default(paramImageDuration, null, null, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.MultiMedia.ImageDuration.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */