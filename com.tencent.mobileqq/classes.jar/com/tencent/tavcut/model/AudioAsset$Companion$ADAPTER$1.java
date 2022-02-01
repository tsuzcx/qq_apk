package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.VolumeEffect;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/AudioAsset$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/AudioAsset;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class AudioAsset$Companion$ADAPTER$1
  extends ProtoAdapter<AudioAsset>
{
  AudioAsset$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public AudioAsset decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    TimeRange localTimeRange = (TimeRange)null;
    Float localFloat1 = (Float)null;
    Long localLong = (Long)null;
    List localList = (List)new ArrayList();
    Integer localInteger = (Integer)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    Float localFloat2 = localFloat1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localFloat1 != null)
        {
          float f1 = localFloat1.floatValue();
          if (localFloat2 != null)
          {
            float f2 = localFloat2.floatValue();
            if (localLong != null)
            {
              l = localLong.longValue();
              if (localInteger != null) {
                return new AudioAsset(str1, str2, localTimeRange, f1, f2, l, localList, localInteger.intValue(), paramProtoReader);
              }
              throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger, "type" }));
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong, "startOffset" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat2, "volume" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat1, "speed" }));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 8: 
        localInteger = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localList.add(VolumeEffect.ADAPTER.decode(paramProtoReader));
        break;
      case 6: 
        localLong = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 5: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 4: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 3: 
        localTimeRange = (TimeRange)TimeRange.ADAPTER.decode(paramProtoReader);
        break;
      case 2: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull AudioAsset paramAudioAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramAudioAsset, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramAudioAsset.assetId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramAudioAsset.path);
    TimeRange.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramAudioAsset.timeRange);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 4, Float.valueOf(paramAudioAsset.speed));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 5, Float.valueOf(paramAudioAsset.volume));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 6, Long.valueOf(paramAudioAsset.startOffset));
    VolumeEffect.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 7, paramAudioAsset.volumeEffects);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, Integer.valueOf(paramAudioAsset.type));
    paramProtoWriter.writeBytes(paramAudioAsset.unknownFields());
  }
  
  public int encodedSize(@NotNull AudioAsset paramAudioAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioAsset, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramAudioAsset.assetId) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramAudioAsset.path) + TimeRange.ADAPTER.encodedSizeWithTag(3, paramAudioAsset.timeRange) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, Float.valueOf(paramAudioAsset.speed)) + ProtoAdapter.FLOAT.encodedSizeWithTag(5, Float.valueOf(paramAudioAsset.volume)) + ProtoAdapter.INT64.encodedSizeWithTag(6, Long.valueOf(paramAudioAsset.startOffset)) + VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(7, paramAudioAsset.volumeEffects) + ProtoAdapter.INT32.encodedSizeWithTag(8, Integer.valueOf(paramAudioAsset.type)) + paramAudioAsset.unknownFields().size();
  }
  
  @NotNull
  public AudioAsset redact(@NotNull AudioAsset paramAudioAsset)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioAsset, "value");
    TimeRange localTimeRange = paramAudioAsset.timeRange;
    if (localTimeRange != null) {
      localTimeRange = (TimeRange)TimeRange.ADAPTER.redact(localTimeRange);
    } else {
      localTimeRange = null;
    }
    return AudioAsset.copy$default(paramAudioAsset, null, null, localTimeRange, 0.0F, 0.0F, 0L, Internal.-redactElements(paramAudioAsset.volumeEffects, VolumeEffect.ADAPTER), 0, ByteString.EMPTY, 187, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.AudioAsset.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */