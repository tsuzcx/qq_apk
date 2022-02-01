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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Quat$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Quat;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Quat$Companion$ADAPTER$1
  extends ProtoAdapter<Quat>
{
  Quat$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Quat decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Float localFloat4 = (Float)null;
    long l = paramProtoReader.beginMessage();
    Float localFloat1 = localFloat4;
    Float localFloat2 = localFloat1;
    Float localFloat3 = localFloat2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localFloat4 != null)
        {
          float f1 = localFloat4.floatValue();
          if (localFloat1 != null)
          {
            float f2 = localFloat1.floatValue();
            if (localFloat2 != null)
            {
              float f3 = localFloat2.floatValue();
              if (localFloat3 != null) {
                return new Quat(f1, f2, f3, localFloat3.floatValue(), paramProtoReader);
              }
              throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat3, "w" }));
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat2, "z" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat1, "y" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat4, "x" }));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              paramProtoReader.readUnknownField(i);
            } else {
              localFloat3 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
            }
          }
          else {
            localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
          }
        }
        else {
          localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        }
      }
      else {
        localFloat4 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Quat paramQuat)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramQuat, "value");
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 1, Float.valueOf(paramQuat.x));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 2, Float.valueOf(paramQuat.y));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 3, Float.valueOf(paramQuat.z));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 4, Float.valueOf(paramQuat.w));
    paramProtoWriter.writeBytes(paramQuat.unknownFields());
  }
  
  public int encodedSize(@NotNull Quat paramQuat)
  {
    Intrinsics.checkParameterIsNotNull(paramQuat, "value");
    return ProtoAdapter.FLOAT.encodedSizeWithTag(1, Float.valueOf(paramQuat.x)) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, Float.valueOf(paramQuat.y)) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, Float.valueOf(paramQuat.z)) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, Float.valueOf(paramQuat.w)) + paramQuat.unknownFields().size();
  }
  
  @NotNull
  public Quat redact(@NotNull Quat paramQuat)
  {
    Intrinsics.checkParameterIsNotNull(paramQuat, "value");
    return Quat.copy$default(paramQuat, 0.0F, 0.0F, 0.0F, 0.0F, ByteString.EMPTY, 15, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Quat.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */