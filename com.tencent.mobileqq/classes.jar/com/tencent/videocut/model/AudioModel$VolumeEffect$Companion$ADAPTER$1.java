package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/AudioModel$VolumeEffect$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel$VolumeEffect;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$VolumeEffect$Companion$ADAPTER$1
  extends ProtoAdapter<AudioModel.VolumeEffect>
{
  AudioModel$VolumeEffect$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull AudioModel.VolumeEffect paramVolumeEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramVolumeEffect, "value");
    return ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(paramVolumeEffect.durationUs)) + ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(paramVolumeEffect.startOffsetUs)) + ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(paramVolumeEffect.endOffsetUs)) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, Float.valueOf(paramVolumeEffect.startVolume)) + ProtoAdapter.FLOAT.encodedSizeWithTag(5, Float.valueOf(paramVolumeEffect.endVolume)) + paramVolumeEffect.unknownFields().size();
  }
  
  @NotNull
  public AudioModel.VolumeEffect a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    long l4 = paramProtoReader.beginMessage();
    long l3 = 0L;
    long l1 = l3;
    long l2 = l1;
    float f2 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new AudioModel.VolumeEffect(l3, l1, l2, f2, f1, paramProtoReader.endMessageAndGetUnknownFields(l4));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                paramProtoReader.readUnknownField(i);
              } else {
                f1 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
              }
            }
            else {
              f2 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
            }
          }
          else {
            l2 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
          }
        }
        else {
          l1 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        }
      }
      else {
        l3 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull AudioModel.VolumeEffect paramVolumeEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramVolumeEffect, "value");
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 1, Long.valueOf(paramVolumeEffect.durationUs));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 2, Long.valueOf(paramVolumeEffect.startOffsetUs));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 3, Long.valueOf(paramVolumeEffect.endOffsetUs));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 4, Float.valueOf(paramVolumeEffect.startVolume));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 5, Float.valueOf(paramVolumeEffect.endVolume));
    paramProtoWriter.writeBytes(paramVolumeEffect.unknownFields());
  }
  
  @NotNull
  public AudioModel.VolumeEffect b(@NotNull AudioModel.VolumeEffect paramVolumeEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramVolumeEffect, "value");
    return AudioModel.VolumeEffect.copy$default(paramVolumeEffect, null, null, null, null, null, ByteString.EMPTY, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.VolumeEffect.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */