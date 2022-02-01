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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/MultiMedia$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class MultiMedia$Companion$ADAPTER$1
  extends ProtoAdapter<MultiMedia>
{
  MultiMedia$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public MultiMedia decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger9 = (Integer)null;
    Boolean localBoolean1 = (Boolean)null;
    String str1 = (String)null;
    Float localFloat1 = (Float)null;
    MultiMedia.ImageDuration localImageDuration = (MultiMedia.ImageDuration)null;
    Size localSize = (Size)null;
    List localList = (List)new ArrayList();
    long l = paramProtoReader.beginMessage();
    Integer localInteger1 = localInteger9;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    Integer localInteger5 = localInteger4;
    Integer localInteger6 = localInteger5;
    Integer localInteger7 = localInteger6;
    Integer localInteger8 = localInteger7;
    Boolean localBoolean2 = localBoolean1;
    Boolean localBoolean3 = localBoolean2;
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    Float localFloat2 = localFloat1;
    Float localFloat3 = localFloat2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new MultiMedia(localInteger9, localInteger1, localBoolean1, str1, localFloat1, localImageDuration, localBoolean2, str2, localInteger2, localInteger3, localInteger4, localInteger5, localSize, localFloat2, str3, localInteger6, localFloat3, str4, localInteger7, localList, str5, localInteger8, localBoolean3, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 23: 
        localBoolean3 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 22: 
        localInteger8 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 21: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 20: 
        localList.add(VolumeEffect.ADAPTER.decode(paramProtoReader));
        break;
      case 19: 
        localInteger7 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 18: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 17: 
        localFloat3 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 16: 
        localInteger6 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 15: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 14: 
        localFloat2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 13: 
        localSize = (Size)Size.ADAPTER.decode(paramProtoReader);
        break;
      case 12: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 11: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 10: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 9: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 8: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 7: 
        localBoolean2 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 6: 
        localImageDuration = (MultiMedia.ImageDuration)MultiMedia.ImageDuration.ADAPTER.decode(paramProtoReader);
        break;
      case 5: 
        localFloat1 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 4: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        localBoolean1 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 2: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 1: 
        localInteger9 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull MultiMedia paramMultiMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramMultiMedia, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramMultiMedia.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramMultiMedia.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramMultiMedia.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramMultiMedia.type);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 5, paramMultiMedia.fillScale);
    MultiMedia.ImageDuration.ADAPTER.encodeWithTag(paramProtoWriter, 6, paramMultiMedia.imageDurations);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 7, paramMultiMedia.imageEffect);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 8, paramMultiMedia.key);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 9, paramMultiMedia.maxSourceCount);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 10, paramMultiMedia.minDuration);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 11, paramMultiMedia.minSourceCount);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 12, paramMultiMedia.scaleMode);
    Size.ADAPTER.encodeWithTag(paramProtoWriter, 13, paramMultiMedia.size);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 14, paramMultiMedia.speed);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 15, paramMultiMedia.src);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 16, paramMultiMedia.version);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 17, paramMultiMedia.volume);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 18, paramMultiMedia.backgroundColor);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 19, paramMultiMedia.backgroundFillMode);
    VolumeEffect.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 20, paramMultiMedia.volumeEffects);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 21, paramMultiMedia.backgroundPagPath);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 22, paramMultiMedia.resLoopCount);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 23, paramMultiMedia.visibleWhileOverTime);
    paramProtoWriter.writeBytes(paramMultiMedia.unknownFields());
  }
  
  public int encodedSize(@NotNull MultiMedia paramMultiMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramMultiMedia, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramMultiMedia.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramMultiMedia.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramMultiMedia.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramMultiMedia.type) + ProtoAdapter.FLOAT.encodedSizeWithTag(5, paramMultiMedia.fillScale) + MultiMedia.ImageDuration.ADAPTER.encodedSizeWithTag(6, paramMultiMedia.imageDurations) + ProtoAdapter.BOOL.encodedSizeWithTag(7, paramMultiMedia.imageEffect) + ProtoAdapter.STRING.encodedSizeWithTag(8, paramMultiMedia.key) + ProtoAdapter.INT32.encodedSizeWithTag(9, paramMultiMedia.maxSourceCount) + ProtoAdapter.INT32.encodedSizeWithTag(10, paramMultiMedia.minDuration) + ProtoAdapter.INT32.encodedSizeWithTag(11, paramMultiMedia.minSourceCount) + ProtoAdapter.INT32.encodedSizeWithTag(12, paramMultiMedia.scaleMode) + Size.ADAPTER.encodedSizeWithTag(13, paramMultiMedia.size) + ProtoAdapter.FLOAT.encodedSizeWithTag(14, paramMultiMedia.speed) + ProtoAdapter.STRING.encodedSizeWithTag(15, paramMultiMedia.src) + ProtoAdapter.INT32.encodedSizeWithTag(16, paramMultiMedia.version) + ProtoAdapter.FLOAT.encodedSizeWithTag(17, paramMultiMedia.volume) + ProtoAdapter.STRING.encodedSizeWithTag(18, paramMultiMedia.backgroundColor) + ProtoAdapter.INT32.encodedSizeWithTag(19, paramMultiMedia.backgroundFillMode) + VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(20, paramMultiMedia.volumeEffects) + ProtoAdapter.STRING.encodedSizeWithTag(21, paramMultiMedia.backgroundPagPath) + ProtoAdapter.INT32.encodedSizeWithTag(22, paramMultiMedia.resLoopCount) + ProtoAdapter.BOOL.encodedSizeWithTag(23, paramMultiMedia.visibleWhileOverTime) + paramMultiMedia.unknownFields().size();
  }
  
  @NotNull
  public MultiMedia redact(@NotNull MultiMedia paramMultiMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramMultiMedia, "value");
    MultiMedia.ImageDuration localImageDuration = paramMultiMedia.imageDurations;
    if (localImageDuration != null) {
      localImageDuration = (MultiMedia.ImageDuration)MultiMedia.ImageDuration.ADAPTER.redact(localImageDuration);
    } else {
      localImageDuration = null;
    }
    Size localSize = paramMultiMedia.size;
    if (localSize != null) {
      localSize = (Size)Size.ADAPTER.redact(localSize);
    } else {
      localSize = null;
    }
    return MultiMedia.copy$default(paramMultiMedia, null, null, null, null, null, localImageDuration, null, null, null, null, null, null, localSize, null, null, null, null, null, null, Internal.-redactElements(paramMultiMedia.volumeEffects, VolumeEffect.ADAPTER), null, null, null, ByteString.EMPTY, 7860191, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.MultiMedia.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */