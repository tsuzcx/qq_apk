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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/PostEffect$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/PostEffect;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PostEffect$Companion$ADAPTER$1
  extends ProtoAdapter<PostEffect>
{
  PostEffect$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public PostEffect decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    Integer localInteger5 = localInteger4;
    Integer localInteger6 = localInteger5;
    Integer localInteger7 = localInteger6;
    Integer localInteger8 = localInteger7;
    Integer localInteger9 = localInteger8;
    Integer localInteger10 = localInteger9;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new PostEffect(localInteger1, localInteger2, localBoolean, str1, str2, localInteger3, localInteger4, localInteger5, localInteger6, localInteger7, localInteger8, localInteger9, localInteger10, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 13: 
        localInteger10 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 12: 
        localInteger9 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 11: 
        localInteger8 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 10: 
        localInteger7 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 9: 
        localInteger6 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 8: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull PostEffect paramPostEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPostEffect, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramPostEffect.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramPostEffect.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramPostEffect.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramPostEffect.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramPostEffect.effectType);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, paramPostEffect.sharpness);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 7, paramPostEffect.brightness);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, paramPostEffect.contrast);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 9, paramPostEffect.hue);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 10, paramPostEffect.highlights);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 11, paramPostEffect.shadows);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 12, paramPostEffect.saturation);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 13, paramPostEffect.temperature);
    paramProtoWriter.writeBytes(paramPostEffect.unknownFields());
  }
  
  public int encodedSize(@NotNull PostEffect paramPostEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramPostEffect, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramPostEffect.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramPostEffect.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramPostEffect.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramPostEffect.type) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramPostEffect.effectType) + ProtoAdapter.INT32.encodedSizeWithTag(6, paramPostEffect.sharpness) + ProtoAdapter.INT32.encodedSizeWithTag(7, paramPostEffect.brightness) + ProtoAdapter.INT32.encodedSizeWithTag(8, paramPostEffect.contrast) + ProtoAdapter.INT32.encodedSizeWithTag(9, paramPostEffect.hue) + ProtoAdapter.INT32.encodedSizeWithTag(10, paramPostEffect.highlights) + ProtoAdapter.INT32.encodedSizeWithTag(11, paramPostEffect.shadows) + ProtoAdapter.INT32.encodedSizeWithTag(12, paramPostEffect.saturation) + ProtoAdapter.INT32.encodedSizeWithTag(13, paramPostEffect.temperature) + paramPostEffect.unknownFields().size();
  }
  
  @NotNull
  public PostEffect redact(@NotNull PostEffect paramPostEffect)
  {
    Intrinsics.checkParameterIsNotNull(paramPostEffect, "value");
    return PostEffect.copy$default(paramPostEffect, null, null, null, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 8191, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PostEffect.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */