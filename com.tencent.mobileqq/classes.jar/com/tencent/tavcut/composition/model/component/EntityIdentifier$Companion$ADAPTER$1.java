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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/EntityIdentifier$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class EntityIdentifier$Companion$ADAPTER$1
  extends ProtoAdapter<EntityIdentifier>
{
  EntityIdentifier$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public EntityIdentifier decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    Integer localInteger = (Integer)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new EntityIdentifier(str1, str2, localInteger, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramProtoReader.readUnknownField(i);
          } else {
            localInteger = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
          }
        }
        else {
          str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        }
      }
      else {
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull EntityIdentifier paramEntityIdentifier)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramEntityIdentifier, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramEntityIdentifier.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramEntityIdentifier.name);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, paramEntityIdentifier.id);
    paramProtoWriter.writeBytes(paramEntityIdentifier.unknownFields());
  }
  
  public int encodedSize(@NotNull EntityIdentifier paramEntityIdentifier)
  {
    Intrinsics.checkParameterIsNotNull(paramEntityIdentifier, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramEntityIdentifier.type) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramEntityIdentifier.name) + ProtoAdapter.INT32.encodedSizeWithTag(3, paramEntityIdentifier.id) + paramEntityIdentifier.unknownFields().size();
  }
  
  @NotNull
  public EntityIdentifier redact(@NotNull EntityIdentifier paramEntityIdentifier)
  {
    Intrinsics.checkParameterIsNotNull(paramEntityIdentifier, "value");
    return EntityIdentifier.copy$default(paramEntityIdentifier, null, null, null, ByteString.EMPTY, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.EntityIdentifier.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */