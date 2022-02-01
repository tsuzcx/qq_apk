package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Vec2$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Vec2;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Vec2$Companion$ADAPTER$1
  extends ProtoAdapter<Vec2>
{
  Vec2$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Vec2 decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Float localFloat2 = (Float)null;
    long l = paramProtoReader.beginMessage();
    Float localFloat1 = localFloat2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localFloat2 != null)
        {
          float f = localFloat2.floatValue();
          if (localFloat1 != null) {
            return new Vec2(f, localFloat1.floatValue(), paramProtoReader);
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat1, "y" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat2, "x" }));
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        }
      }
      else {
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Vec2 paramVec2)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramVec2, "value");
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 1, Float.valueOf(paramVec2.x));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 2, Float.valueOf(paramVec2.y));
    paramProtoWriter.writeBytes(paramVec2.unknownFields());
  }
  
  public int encodedSize(@NotNull Vec2 paramVec2)
  {
    Intrinsics.checkParameterIsNotNull(paramVec2, "value");
    return ProtoAdapter.FLOAT.encodedSizeWithTag(1, Float.valueOf(paramVec2.x)) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, Float.valueOf(paramVec2.y)) + paramVec2.unknownFields().size();
  }
  
  @NotNull
  public Vec2 redact(@NotNull Vec2 paramVec2)
  {
    Intrinsics.checkParameterIsNotNull(paramVec2, "value");
    return Vec2.copy$default(paramVec2, 0.0F, 0.0F, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Vec2.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */