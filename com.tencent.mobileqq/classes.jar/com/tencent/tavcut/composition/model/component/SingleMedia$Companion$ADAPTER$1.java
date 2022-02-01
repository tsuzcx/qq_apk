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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/SingleMedia$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/SingleMedia;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class SingleMedia$Companion$ADAPTER$1
  extends ProtoAdapter<SingleMedia>
{
  SingleMedia$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public SingleMedia decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str = (String)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new SingleMedia(localInteger1, localInteger2, localBoolean, str, localInteger3, localInteger4, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 5: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 4: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 2: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 1: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull SingleMedia paramSingleMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramSingleMedia, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramSingleMedia.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramSingleMedia.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramSingleMedia.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramSingleMedia.type);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, paramSingleMedia.index);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, paramSingleMedia.version);
    paramProtoWriter.writeBytes(paramSingleMedia.unknownFields());
  }
  
  public int encodedSize(@NotNull SingleMedia paramSingleMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramSingleMedia, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramSingleMedia.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramSingleMedia.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramSingleMedia.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramSingleMedia.type) + ProtoAdapter.INT32.encodedSizeWithTag(5, paramSingleMedia.index) + ProtoAdapter.INT32.encodedSizeWithTag(6, paramSingleMedia.version) + paramSingleMedia.unknownFields().size();
  }
  
  @NotNull
  public SingleMedia redact(@NotNull SingleMedia paramSingleMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramSingleMedia, "value");
    return SingleMedia.copy$default(paramSingleMedia, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.SingleMedia.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */