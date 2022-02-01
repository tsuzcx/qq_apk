package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/LightAssetModel$MaterialConfig$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/LightAssetModel$MaterialConfig;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightAssetModel$MaterialConfig$Companion$ADAPTER$1
  extends ProtoAdapter<LightAssetModel.MaterialConfig>
{
  LightAssetModel$MaterialConfig$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public LightAssetModel.MaterialConfig decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Object localObject = (LightAssetModel.MediaType)null;
    Integer localInteger5 = (Integer)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger1 = localInteger5;
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localInteger5 != null)
        {
          i = localInteger5.intValue();
          if (localInteger4 != null)
          {
            int j = localInteger4.intValue();
            if (localInteger1 != null)
            {
              int k = localInteger1.intValue();
              if (localInteger2 != null)
              {
                int m = localInteger2.intValue();
                if (localInteger3 != null) {
                  return new LightAssetModel.MaterialConfig((LightAssetModel.MediaType)localObject, i, j, k, m, localInteger3.intValue(), paramProtoReader);
                }
                throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger3, "maxImageDuration" }));
              }
              throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger2, "minImageDuration" }));
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger1, "minVideoDuration" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger4, "maxAssetCount" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localInteger5, "minAssetCount" }));
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
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 4: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 3: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 1: 
        try
        {
          LightAssetModel.MediaType localMediaType = (LightAssetModel.MediaType)LightAssetModel.MediaType.ADAPTER.decode(paramProtoReader);
          localObject = localMediaType;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException.value));
        }
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull LightAssetModel.MaterialConfig paramMaterialConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramMaterialConfig, "value");
    LightAssetModel.MediaType.ADAPTER.encodeWithTag(paramProtoWriter, 1, paramMaterialConfig.type);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, Integer.valueOf(paramMaterialConfig.minAssetCount));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramMaterialConfig.maxAssetCount));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 4, Integer.valueOf(paramMaterialConfig.minVideoDuration));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, Integer.valueOf(paramMaterialConfig.minImageDuration));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 6, Integer.valueOf(paramMaterialConfig.maxImageDuration));
    paramProtoWriter.writeBytes(paramMaterialConfig.unknownFields());
  }
  
  public int encodedSize(@NotNull LightAssetModel.MaterialConfig paramMaterialConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialConfig, "value");
    return LightAssetModel.MediaType.ADAPTER.encodedSizeWithTag(1, paramMaterialConfig.type) + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(paramMaterialConfig.minAssetCount)) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramMaterialConfig.maxAssetCount)) + ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(paramMaterialConfig.minVideoDuration)) + ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(paramMaterialConfig.minImageDuration)) + ProtoAdapter.INT32.encodedSizeWithTag(6, Integer.valueOf(paramMaterialConfig.maxImageDuration)) + paramMaterialConfig.unknownFields().size();
  }
  
  @NotNull
  public LightAssetModel.MaterialConfig redact(@NotNull LightAssetModel.MaterialConfig paramMaterialConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialConfig, "value");
    return LightAssetModel.MaterialConfig.copy$default(paramMaterialConfig, null, 0, 0, 0, 0, 0, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.LightAssetModel.MaterialConfig.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */