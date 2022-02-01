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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/AudioEffect$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/AudioEffect;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class AudioEffect$Companion$ADAPTER$1
  extends ProtoAdapter<AudioEffect>
{
  AudioEffect$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public AudioEffect decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new AudioEffect(localInteger1, localInteger2, localBoolean, str1, str2, localInteger3, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull AudioEffect paramAudioEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramAudioEffect, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramAudioEffect.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramAudioEffect.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramAudioEffect.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramAudioEffect.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramAudioEffect.preset);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, paramAudioEffect.version);
    paramProtoWriter.writeBytes(paramAudioEffect.unknownFields());
  }
  
  public int encodedSize(@NotNull AudioEffect paramAudioEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioEffect, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramAudioEffect.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramAudioEffect.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramAudioEffect.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramAudioEffect.type) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramAudioEffect.preset) + ProtoAdapter.INT32.encodedSizeWithTag(6, paramAudioEffect.version) + paramAudioEffect.unknownFields().size();
  }
  
  @NotNull
  public AudioEffect redact(@NotNull AudioEffect paramAudioEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioEffect, "value");
    return AudioEffect.copy$default(paramAudioEffect, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.AudioEffect.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */