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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/BackgroundModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/BackgroundModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundModel$Companion$ADAPTER$1
  extends ProtoAdapter<BackgroundModel>
{
  BackgroundModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull BackgroundModel paramBackgroundModel)
  {
    Intrinsics.checkParameterIsNotNull(paramBackgroundModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramBackgroundModel.id) + SizeF.ADAPTER.encodedSizeWithTag(2, paramBackgroundModel.renderSize) + BackgroundFillMode.ADAPTER.encodedSizeWithTag(3, paramBackgroundModel.bgFillMode) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramBackgroundModel.bgColor) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramBackgroundModel.bgPagPath) + RatioType.ADAPTER.encodedSizeWithTag(6, paramBackgroundModel.ratioType) + BackgroundResPack.ADAPTER.encodedSizeWithTag(7, paramBackgroundModel.resPack) + ProtoAdapter.STRING.encodedSizeWithTag(8, paramBackgroundModel.categoryId) + ProtoAdapter.FLOAT.encodedSizeWithTag(9, Float.valueOf(paramBackgroundModel.fillScale)) + paramBackgroundModel.unknownFields().size();
  }
  
  @NotNull
  public BackgroundModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Object localObject6 = (String)null;
    SizeF localSizeF = (SizeF)null;
    BackgroundFillMode localBackgroundFillMode1 = (BackgroundFillMode)null;
    Object localObject4 = (RatioType)null;
    BackgroundResPack localBackgroundResPack = (BackgroundResPack)null;
    long l = paramProtoReader.beginMessage();
    Object localObject1 = localObject6;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    float f = 0.0F;
    Object localObject5 = localObject1;
    localObject1 = localObject6;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localObject1 == null) {
          localObject1 = "";
        }
        return new BackgroundModel((String)localObject5, localSizeF, localBackgroundFillMode1, (String)localObject1, (String)localObject2, (RatioType)localObject4, localBackgroundResPack, (String)localObject3, f, paramProtoReader);
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 9: 
        f = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 8: 
        localObject3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 7: 
        localBackgroundResPack = (BackgroundResPack)BackgroundResPack.ADAPTER.decode(paramProtoReader);
        break;
      case 6: 
        try
        {
          localObject6 = (RatioType)RatioType.ADAPTER.decode(paramProtoReader);
          localObject4 = localObject6;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException1)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException1.value));
        }
        break;
      case 5: 
        localObject2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        localObject1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        try
        {
          BackgroundFillMode localBackgroundFillMode2 = (BackgroundFillMode)BackgroundFillMode.ADAPTER.decode(paramProtoReader);
          localBackgroundFillMode1 = localBackgroundFillMode2;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException2)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException2.value));
        }
        break;
      case 2: 
        localSizeF = (SizeF)SizeF.ADAPTER.decode(paramProtoReader);
        break;
      case 1: 
        localObject5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull BackgroundModel paramBackgroundModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramBackgroundModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramBackgroundModel.id);
    SizeF.ADAPTER.encodeWithTag(paramProtoWriter, 2, paramBackgroundModel.renderSize);
    BackgroundFillMode.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramBackgroundModel.bgFillMode);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramBackgroundModel.bgColor);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramBackgroundModel.bgPagPath);
    RatioType.ADAPTER.encodeWithTag(paramProtoWriter, 6, paramBackgroundModel.ratioType);
    BackgroundResPack.ADAPTER.encodeWithTag(paramProtoWriter, 7, paramBackgroundModel.resPack);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 8, paramBackgroundModel.categoryId);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 9, Float.valueOf(paramBackgroundModel.fillScale));
    paramProtoWriter.writeBytes(paramBackgroundModel.unknownFields());
  }
  
  @NotNull
  public BackgroundModel b(@NotNull BackgroundModel paramBackgroundModel)
  {
    Intrinsics.checkParameterIsNotNull(paramBackgroundModel, "value");
    SizeF localSizeF = paramBackgroundModel.renderSize;
    if (localSizeF != null) {
      localSizeF = (SizeF)SizeF.ADAPTER.redact(localSizeF);
    } else {
      localSizeF = null;
    }
    BackgroundResPack localBackgroundResPack = paramBackgroundModel.resPack;
    if (localBackgroundResPack != null) {
      localBackgroundResPack = (BackgroundResPack)BackgroundResPack.ADAPTER.redact(localBackgroundResPack);
    } else {
      localBackgroundResPack = null;
    }
    return BackgroundModel.copy$default(paramBackgroundModel, null, localSizeF, null, null, null, null, localBackgroundResPack, null, 0.0F, ByteString.EMPTY, 445, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.BackgroundModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */