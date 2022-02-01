package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/SpecialEffectModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/SpecialEffectModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SpecialEffectModel$Companion$ADAPTER$1
  extends ProtoAdapter<SpecialEffectModel>
{
  SpecialEffectModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull SpecialEffectModel paramSpecialEffectModel)
  {
    Intrinsics.checkParameterIsNotNull(paramSpecialEffectModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramSpecialEffectModel.id) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramSpecialEffectModel.name) + ProtoAdapter.INT32.encodedSizeWithTag(3, paramSpecialEffectModel.bgColor) + ProtoAdapter.INT64.encodedSizeWithTag(4, paramSpecialEffectModel.startTimeUs) + ProtoAdapter.INT64.encodedSizeWithTag(5, paramSpecialEffectModel.durationUs) + ProtoAdapter.INT64.encodedSizeWithTag(6, paramSpecialEffectModel.createTimeMs) + ProtoAdapter.FLOAT.encodedSizeWithTag(7, paramSpecialEffectModel.scale) + ProtoAdapter.STRING.encodedSizeWithTag(8, paramSpecialEffectModel.filePath) + AnimationMode.ADAPTER.encodedSizeWithTag(9, paramSpecialEffectModel.animationMode) + ActionScope.ADAPTER.encodedSizeWithTag(10, paramSpecialEffectModel.actionScope) + ProtoAdapter.INT32.encodedSizeWithTag(11, paramSpecialEffectModel.timeLineIndex) + ProtoAdapter.STRING.encodedSizeWithTag(12, paramSpecialEffectModel.materialId) + ProtoAdapter.STRING.encodedSizeWithTag(13, paramSpecialEffectModel.categoryId) + ProtoAdapter.STRING.encodedSizeWithTag(14, paramSpecialEffectModel.portraitFilePath) + ProtoAdapter.STRING.encodedSizeWithTag(15, paramSpecialEffectModel.landscapeFilePath) + SpecialEffectResType.ADAPTER.encodedSizeWithTag(16, paramSpecialEffectModel.type) + ProtoAdapter.STRING.encodedSizeWithTag(17, paramSpecialEffectModel.jsPath) + ProtoAdapter.STRING.encodedSizeWithTag(18, paramSpecialEffectModel.jsContentCache) + paramSpecialEffectModel.unknownFields().size();
  }
  
  @NotNull
  public SpecialEffectModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    Integer localInteger1 = (Integer)null;
    Long localLong1 = (Long)null;
    Float localFloat = (Float)null;
    Object localObject3 = (AnimationMode)null;
    Object localObject2 = (ActionScope)null;
    Object localObject1 = (SpecialEffectResType)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    String str6 = str5;
    String str7 = str6;
    String str8 = str7;
    String str9 = str8;
    Integer localInteger2 = localInteger1;
    Long localLong2 = localLong1;
    Long localLong3 = localLong2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new SpecialEffectModel(str1, str2, localInteger1, localLong1, localLong2, localLong3, localFloat, str3, (AnimationMode)localObject3, (ActionScope)localObject2, localInteger2, str4, str5, str6, str7, (SpecialEffectResType)localObject1, str8, str9, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 18: 
        str9 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 17: 
        str8 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 16: 
        try
        {
          SpecialEffectResType localSpecialEffectResType = (SpecialEffectResType)SpecialEffectResType.ADAPTER.decode(paramProtoReader);
          localObject1 = localSpecialEffectResType;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException1)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException1.value));
        }
        break;
      case 15: 
        str7 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 14: 
        str6 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 13: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 12: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 11: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 10: 
        try
        {
          ActionScope localActionScope = (ActionScope)ActionScope.ADAPTER.decode(paramProtoReader);
          localObject2 = localActionScope;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException2)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException2.value));
        }
        break;
      case 9: 
        try
        {
          AnimationMode localAnimationMode = (AnimationMode)AnimationMode.ADAPTER.decode(paramProtoReader);
          localObject3 = localAnimationMode;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException3)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException3.value));
        }
        break;
      case 8: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 7: 
        localFloat = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 6: 
        localLong3 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 5: 
        localLong2 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 4: 
        localLong1 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 3: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 2: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull SpecialEffectModel paramSpecialEffectModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramSpecialEffectModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramSpecialEffectModel.id);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramSpecialEffectModel.name);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, paramSpecialEffectModel.bgColor);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, paramSpecialEffectModel.startTimeUs);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 5, paramSpecialEffectModel.durationUs);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 6, paramSpecialEffectModel.createTimeMs);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 7, paramSpecialEffectModel.scale);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 8, paramSpecialEffectModel.filePath);
    AnimationMode.ADAPTER.encodeWithTag(paramProtoWriter, 9, paramSpecialEffectModel.animationMode);
    ActionScope.ADAPTER.encodeWithTag(paramProtoWriter, 10, paramSpecialEffectModel.actionScope);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 11, paramSpecialEffectModel.timeLineIndex);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 12, paramSpecialEffectModel.materialId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 13, paramSpecialEffectModel.categoryId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 14, paramSpecialEffectModel.portraitFilePath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 15, paramSpecialEffectModel.landscapeFilePath);
    SpecialEffectResType.ADAPTER.encodeWithTag(paramProtoWriter, 16, paramSpecialEffectModel.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 17, paramSpecialEffectModel.jsPath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 18, paramSpecialEffectModel.jsContentCache);
    paramProtoWriter.writeBytes(paramSpecialEffectModel.unknownFields());
  }
  
  @NotNull
  public SpecialEffectModel b(@NotNull SpecialEffectModel paramSpecialEffectModel)
  {
    Intrinsics.checkParameterIsNotNull(paramSpecialEffectModel, "value");
    return SpecialEffectModel.copy$default(paramSpecialEffectModel, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 262143, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.SpecialEffectModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */