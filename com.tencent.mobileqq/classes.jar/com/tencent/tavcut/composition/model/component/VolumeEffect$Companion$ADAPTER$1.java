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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/VolumeEffect$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class VolumeEffect$Companion$ADAPTER$1
  extends ProtoAdapter<VolumeEffect>
{
  VolumeEffect$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public VolumeEffect decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Long localLong1 = (Long)null;
    Float localFloat1 = (Float)null;
    String str = (String)null;
    long l = paramProtoReader.beginMessage();
    Long localLong2 = localLong1;
    Long localLong3 = localLong2;
    Float localFloat2 = localFloat1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new VolumeEffect(localLong1, localLong2, localLong3, localFloat1, localFloat2, str, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 4: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 3: 
        localLong3 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 2: 
        localLong2 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 1: 
        localLong1 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull VolumeEffect paramVolumeEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramVolumeEffect, "value");
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 1, paramVolumeEffect.startOffset);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 2, paramVolumeEffect.endOffset);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 3, paramVolumeEffect.duration);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 4, paramVolumeEffect.start);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 5, paramVolumeEffect.end);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramVolumeEffect.interpolationType);
    paramProtoWriter.writeBytes(paramVolumeEffect.unknownFields());
  }
  
  public int encodedSize(@NotNull VolumeEffect paramVolumeEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramVolumeEffect, "value");
    return ProtoAdapter.INT64.encodedSizeWithTag(1, paramVolumeEffect.startOffset) + ProtoAdapter.INT64.encodedSizeWithTag(2, paramVolumeEffect.endOffset) + ProtoAdapter.INT64.encodedSizeWithTag(3, paramVolumeEffect.duration) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, paramVolumeEffect.start) + ProtoAdapter.FLOAT.encodedSizeWithTag(5, paramVolumeEffect.end) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramVolumeEffect.interpolationType) + paramVolumeEffect.unknownFields().size();
  }
  
  @NotNull
  public VolumeEffect redact(@NotNull VolumeEffect paramVolumeEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramVolumeEffect, "value");
    return VolumeEffect.copy$default(paramVolumeEffect, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.VolumeEffect.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */