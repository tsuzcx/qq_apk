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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Vec3$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Vec3;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Vec3$Companion$ADAPTER$1
  extends ProtoAdapter<Vec3>
{
  Vec3$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Vec3 decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Float localFloat3 = (Float)null;
    long l = paramProtoReader.beginMessage();
    Float localFloat1 = localFloat3;
    Float localFloat2 = localFloat1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localFloat3 != null)
        {
          float f1 = localFloat3.floatValue();
          if (localFloat1 != null)
          {
            float f2 = localFloat1.floatValue();
            if (localFloat2 != null) {
              return new Vec3(f1, f2, localFloat2.floatValue(), paramProtoReader);
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat2, "z" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat1, "y" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat3, "x" }));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            paramProtoReader.readUnknownField(i);
          } else {
            localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
          }
        }
        else {
          localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        }
      }
      else {
        localFloat3 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Vec3 paramVec3)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramVec3, "value");
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 1, Float.valueOf(paramVec3.x));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 2, Float.valueOf(paramVec3.y));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 3, Float.valueOf(paramVec3.z));
    paramProtoWriter.writeBytes(paramVec3.unknownFields());
  }
  
  public int encodedSize(@NotNull Vec3 paramVec3)
  {
    Intrinsics.checkParameterIsNotNull(paramVec3, "value");
    return ProtoAdapter.FLOAT.encodedSizeWithTag(1, Float.valueOf(paramVec3.x)) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, Float.valueOf(paramVec3.y)) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, Float.valueOf(paramVec3.z)) + paramVec3.unknownFields().size();
  }
  
  @NotNull
  public Vec3 redact(@NotNull Vec3 paramVec3)
  {
    Intrinsics.checkParameterIsNotNull(paramVec3, "value");
    return Vec3.copy$default(paramVec3, 0.0F, 0.0F, 0.0F, ByteString.EMPTY, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Vec3.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */