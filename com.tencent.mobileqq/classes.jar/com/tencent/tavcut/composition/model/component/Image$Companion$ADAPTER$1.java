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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Image$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Image;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Image$Companion$ADAPTER$1
  extends ProtoAdapter<Image>
{
  Image$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Image decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    Long localLong = (Long)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    String str2 = str1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new Image(localInteger1, localBoolean, localInteger2, localInteger3, str1, str2, localLong, localInteger4, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 8: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localLong = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 6: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 3: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 1: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Image paramImage)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramImage, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramImage.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 2, paramImage.enabled);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, paramImage.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 4, paramImage.scaleMode);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramImage.src);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramImage.type);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 7, paramImage.duration);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, paramImage.version);
    paramProtoWriter.writeBytes(paramImage.unknownFields());
  }
  
  public int encodedSize(@NotNull Image paramImage)
  {
    Intrinsics.checkParameterIsNotNull(paramImage, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramImage.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(2, paramImage.enabled) + ProtoAdapter.INT32.encodedSizeWithTag(3, paramImage.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(4, paramImage.scaleMode) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramImage.src) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramImage.type) + ProtoAdapter.INT64.encodedSizeWithTag(7, paramImage.duration) + ProtoAdapter.INT32.encodedSizeWithTag(8, paramImage.version) + paramImage.unknownFields().size();
  }
  
  @NotNull
  public Image redact(@NotNull Image paramImage)
  {
    Intrinsics.checkParameterIsNotNull(paramImage, "value");
    return Image.copy$default(paramImage, null, null, null, null, null, null, null, null, ByteString.EMPTY, 255, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Image.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */