package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/AudioSource$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class AudioSource$Companion$ADAPTER$1
  extends ProtoAdapter<AudioSource>
{
  AudioSource$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public AudioSource decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    Float localFloat1 = (Float)null;
    List localList = (List)new ArrayList();
    long l = paramProtoReader.beginMessage();
    Float localFloat2 = localFloat1;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    String str2 = str1;
    String str3 = str2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new AudioSource(localInteger1, localInteger2, localBoolean, str1, str2, localFloat1, localInteger3, localFloat2, localList, localInteger4, str3, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 11: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 10: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 9: 
        localList.add(VolumeEffect.ADAPTER.decode(paramProtoReader));
        break;
      case 8: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 7: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 6: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 5: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull AudioSource paramAudioSource)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramAudioSource, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramAudioSource.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramAudioSource.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramAudioSource.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramAudioSource.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramAudioSource.key);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 6, paramAudioSource.speed);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 7, paramAudioSource.version);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 8, paramAudioSource.volume);
    VolumeEffect.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 9, paramAudioSource.volumeEffects);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 10, paramAudioSource.audioSourceType);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 11, paramAudioSource.src);
    paramProtoWriter.writeBytes(paramAudioSource.unknownFields());
  }
  
  public int encodedSize(@NotNull AudioSource paramAudioSource)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioSource, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramAudioSource.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramAudioSource.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramAudioSource.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramAudioSource.type) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramAudioSource.key) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, paramAudioSource.speed) + ProtoAdapter.INT32.encodedSizeWithTag(7, paramAudioSource.version) + ProtoAdapter.FLOAT.encodedSizeWithTag(8, paramAudioSource.volume) + VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(9, paramAudioSource.volumeEffects) + ProtoAdapter.INT32.encodedSizeWithTag(10, paramAudioSource.audioSourceType) + ProtoAdapter.STRING.encodedSizeWithTag(11, paramAudioSource.src) + paramAudioSource.unknownFields().size();
  }
  
  @NotNull
  public AudioSource redact(@NotNull AudioSource paramAudioSource)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioSource, "value");
    return AudioSource.copy$default(paramAudioSource, null, null, null, null, null, null, null, null, Internal.-redactElements(paramAudioSource.volumeEffects, VolumeEffect.ADAPTER), null, null, ByteString.EMPTY, 1791, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.AudioSource.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */