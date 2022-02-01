package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/AudioModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$Companion$ADAPTER$1
  extends ProtoAdapter<AudioModel>
{
  AudioModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull AudioModel paramAudioModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramAudioModel.id) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramAudioModel.path) + ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(paramAudioModel.sourceStartTime)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(paramAudioModel.sourceDuration)) + ProtoAdapter.INT64.encodedSizeWithTag(5, Long.valueOf(paramAudioModel.startTimeInTimeline)) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, Float.valueOf(paramAudioModel.volume)) + ProtoAdapter.FLOAT.encodedSizeWithTag(7, Float.valueOf(paramAudioModel.speed)) + AudioModel.VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(8, paramAudioModel.volumeEffects) + ProtoAdapter.STRING.encodedSizeWithTag(9, paramAudioModel.name) + ProtoAdapter.INT32.encodedSizeWithTag(10, paramAudioModel.timelineTrackIndex) + ProtoAdapter.INT64.encodedSizeWithTag(11, Long.valueOf(paramAudioModel.selectStartTime)) + ProtoAdapter.INT64.encodedSizeWithTag(12, Long.valueOf(paramAudioModel.selectDuration)) + ProtoAdapter.INT64.encodedSizeWithTag(13, Long.valueOf(paramAudioModel.fadeInDuration)) + ProtoAdapter.INT64.encodedSizeWithTag(14, Long.valueOf(paramAudioModel.fadeOutDuration)) + AudioModel.LyricInfo.ADAPTER.encodedSizeWithTag(15, paramAudioModel.lyricInfo) + AudioModel.Type.ADAPTER.encodedSizeWithTag(16, paramAudioModel.type) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(17, paramAudioModel.waveSampleData) + paramAudioModel.unknownFields().size();
  }
  
  @NotNull
  public AudioModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    List localList2 = (List)new ArrayList();
    Integer localInteger = (Integer)null;
    AudioModel.LyricInfo localLyricInfo = (AudioModel.LyricInfo)null;
    Object localObject1 = (AudioModel.Type)null;
    List localList1 = (List)new ArrayList();
    long l6 = paramProtoReader.beginMessage();
    long l7 = 0L;
    String str1 = "";
    String str2 = str1;
    String str3 = str2;
    long l8 = 0L;
    long l1 = l8;
    long l2 = l1;
    long l3 = l2;
    long l4 = l3;
    long l5 = l4;
    float f2 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new AudioModel(str1, str2, l7, l8, l1, f2, f1, localList2, str3, localInteger, l2, l3, l4, l5, localLyricInfo, (AudioModel.Type)localObject1, localList1, paramProtoReader.endMessageAndGetUnknownFields(l6));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 17: 
        localList1.add(ProtoAdapter.INT32.decode(paramProtoReader));
        break;
      case 16: 
        try
        {
          Object localObject2 = (AudioModel.Type)AudioModel.Type.ADAPTER.decode(paramProtoReader);
          try
          {
            localObject1 = Unit.INSTANCE;
            localObject1 = localObject2;
          }
          catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException2)
          {
            localObject1 = localObject2;
            localObject2 = localEnumConstantNotFoundException2;
          }
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException1.value));
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException1) {}
        Unit localUnit = Unit.INSTANCE;
        break;
      case 15: 
        localLyricInfo = (AudioModel.LyricInfo)AudioModel.LyricInfo.ADAPTER.decode(paramProtoReader);
        break;
      case 14: 
        l5 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 13: 
        l4 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 12: 
        l3 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 11: 
        l2 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 10: 
        localInteger = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 9: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 8: 
        localList2.add(AudioModel.VolumeEffect.ADAPTER.decode(paramProtoReader));
        break;
      case 7: 
        f1 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 6: 
        f2 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 5: 
        l1 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 4: 
        l8 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 3: 
        l7 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 2: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull AudioModel paramAudioModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramAudioModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramAudioModel.id);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramAudioModel.path);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 3, Long.valueOf(paramAudioModel.sourceStartTime));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, Long.valueOf(paramAudioModel.sourceDuration));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 5, Long.valueOf(paramAudioModel.startTimeInTimeline));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 6, Float.valueOf(paramAudioModel.volume));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 7, Float.valueOf(paramAudioModel.speed));
    AudioModel.VolumeEffect.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 8, paramAudioModel.volumeEffects);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 9, paramAudioModel.name);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 10, paramAudioModel.timelineTrackIndex);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 11, Long.valueOf(paramAudioModel.selectStartTime));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 12, Long.valueOf(paramAudioModel.selectDuration));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 13, Long.valueOf(paramAudioModel.fadeInDuration));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 14, Long.valueOf(paramAudioModel.fadeOutDuration));
    AudioModel.LyricInfo.ADAPTER.encodeWithTag(paramProtoWriter, 15, paramAudioModel.lyricInfo);
    AudioModel.Type.ADAPTER.encodeWithTag(paramProtoWriter, 16, paramAudioModel.type);
    ProtoAdapter.INT32.asRepeated().encodeWithTag(paramProtoWriter, 17, paramAudioModel.waveSampleData);
    paramProtoWriter.writeBytes(paramAudioModel.unknownFields());
  }
  
  @NotNull
  public AudioModel b(@NotNull AudioModel paramAudioModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioModel, "value");
    List localList = Internal.-redactElements(paramAudioModel.volumeEffects, AudioModel.VolumeEffect.ADAPTER);
    AudioModel.LyricInfo localLyricInfo = paramAudioModel.lyricInfo;
    if (localLyricInfo != null) {
      localLyricInfo = (AudioModel.LyricInfo)AudioModel.LyricInfo.ADAPTER.redact(localLyricInfo);
    } else {
      localLyricInfo = null;
    }
    return AudioModel.copy$default(paramAudioModel, null, null, null, null, null, null, null, localList, null, null, null, null, null, null, localLyricInfo, null, null, ByteString.EMPTY, 114559, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */