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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/StickerModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/StickerModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerModel$Companion$ADAPTER$1
  extends ProtoAdapter<StickerModel>
{
  StickerModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull StickerModel paramStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramStickerModel.id) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramStickerModel.filePath) + ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(paramStickerModel.startTime)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(paramStickerModel.duration)) + ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(paramStickerModel.layerIndex)) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, Float.valueOf(paramStickerModel.scale)) + ProtoAdapter.FLOAT.encodedSizeWithTag(7, Float.valueOf(paramStickerModel.rotate)) + ProtoAdapter.FLOAT.encodedSizeWithTag(8, Float.valueOf(paramStickerModel.centerX)) + ProtoAdapter.FLOAT.encodedSizeWithTag(9, Float.valueOf(paramStickerModel.centerY)) + ProtoAdapter.BOOL.encodedSizeWithTag(10, Boolean.valueOf(paramStickerModel.editable)) + ProtoAdapter.INT32.encodedSizeWithTag(11, Integer.valueOf(paramStickerModel.width)) + ProtoAdapter.INT32.encodedSizeWithTag(12, Integer.valueOf(paramStickerModel.height)) + ProtoAdapter.FLOAT.encodedSizeWithTag(13, Float.valueOf(paramStickerModel.minScale)) + ProtoAdapter.FLOAT.encodedSizeWithTag(14, Float.valueOf(paramStickerModel.maxScale)) + TextItem.ADAPTER.asRepeated().encodedSizeWithTag(15, paramStickerModel.textItems) + ProtoAdapter.STRING.encodedSizeWithTag(16, paramStickerModel.thumbUrl) + ProtoAdapter.INT32.encodedSizeWithTag(17, Integer.valueOf(paramStickerModel.timelineTrackIndex)) + AnimationMode.ADAPTER.encodedSizeWithTag(18, paramStickerModel.animationMode) + StickerModel.Type.ADAPTER.encodedSizeWithTag(19, paramStickerModel.type) + ProtoAdapter.STRING.encodedSizeWithTag(20, paramStickerModel.materialId) + StickerModel.CaptionInfo.ADAPTER.encodedSizeWithTag(21, paramStickerModel.captionInfo) + ProtoAdapter.INT32.encodedSizeWithTag(22, Integer.valueOf(paramStickerModel.localThumbId)) + ProtoAdapter.INT32.encodedSizeWithTag(23, Integer.valueOf(paramStickerModel.editingLayerIndex)) + ProtoAdapter.INT64.encodedSizeWithTag(24, Long.valueOf(paramStickerModel.playEndDuration)) + StickerModel.ActionType.ADAPTER.encodedSizeWithTag(25, paramStickerModel.actionType) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(26, paramStickerModel.bgConfig) + ProtoAdapter.STRING.encodedSizeWithTag(27, paramStickerModel.bgPath) + ProtoAdapter.STRING.encodedSizeWithTag(28, paramStickerModel.configType) + paramStickerModel.unknownFields().size();
  }
  
  @NotNull
  public StickerModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    List localList1 = (List)new ArrayList();
    Object localObject3 = AnimationMode.LOOP;
    Object localObject2 = StickerModel.Type.DEFAULT;
    StickerModel.CaptionInfo localCaptionInfo = (StickerModel.CaptionInfo)null;
    Object localObject1 = StickerModel.ActionType.NONE;
    List localList2 = (List)new ArrayList();
    long l2 = paramProtoReader.beginMessage();
    long l4 = 0L;
    int i1 = 0;
    long l1 = 0L;
    String str1 = "";
    String str2 = str1;
    String str6 = str2;
    String str5 = str6;
    String str4 = str5;
    String str3 = str4;
    float f6 = 0.0F;
    float f5 = 0.0F;
    float f4 = 0.0F;
    float f3 = 0.0F;
    boolean bool = false;
    int n = 0;
    int m = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    int k = 0;
    int j = 0;
    int i = 0;
    long l3 = l1;
    for (;;)
    {
      int i2 = paramProtoReader.nextTag();
      if (i2 == -1) {
        return new StickerModel(str1, str2, l4, l3, i1, f6, f5, f4, f3, bool, n, m, f2, f1, localList1, str6, k, (AnimationMode)localObject3, (StickerModel.Type)localObject2, str5, localCaptionInfo, j, i, l1, (StickerModel.ActionType)localObject1, localList2, str4, str3, paramProtoReader.endMessageAndGetUnknownFields(l2));
      }
      Object localObject5;
      label539:
      Object localObject6;
      switch (i2)
      {
      default: 
        paramProtoReader.readUnknownField(i2);
        break;
      case 28: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 27: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 26: 
        localList2.add(ProtoAdapter.STRING.decode(paramProtoReader));
        break;
      case 25: 
        try
        {
          Object localObject4 = (StickerModel.ActionType)StickerModel.ActionType.ADAPTER.decode(paramProtoReader);
          try
          {
            localObject1 = Unit.INSTANCE;
            localObject1 = localObject4;
          }
          catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException4)
          {
            localObject1 = localObject4;
            localObject4 = localEnumConstantNotFoundException4;
          }
          paramProtoReader.addUnknownField(i2, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException1.value));
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException1) {}
        localObject5 = Unit.INSTANCE;
      case 24: 
      case 23: 
      case 22: 
      case 21: 
      case 20: 
      case 19: 
        for (;;)
        {
          break label669;
          l1 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
          break label539;
          i = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
          break label539;
          j = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
          break label539;
          localCaptionInfo = (StickerModel.CaptionInfo)StickerModel.CaptionInfo.ADAPTER.decode(paramProtoReader);
          break label539;
          str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
          break label702;
          try
          {
            localObject5 = (StickerModel.Type)StickerModel.Type.ADAPTER.decode(paramProtoReader);
            try
            {
              localObject2 = Unit.INSTANCE;
              localObject2 = localObject5;
            }
            catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException5)
            {
              localObject2 = localObject5;
              localObject5 = localEnumConstantNotFoundException5;
            }
            paramProtoReader.addUnknownField(i2, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException2.value));
          }
          catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException2) {}
        }
        localObject6 = Unit.INSTANCE;
        break;
      case 18: 
        try
        {
          localObject6 = (AnimationMode)AnimationMode.ADAPTER.decode(paramProtoReader);
          try
          {
            localObject3 = Unit.INSTANCE;
            localObject3 = localObject6;
          }
          catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException6)
          {
            localObject3 = localObject6;
            localObject6 = localEnumConstantNotFoundException6;
          }
          paramProtoReader.addUnknownField(i2, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException3.value));
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException3) {}
        Unit localUnit = Unit.INSTANCE;
        break;
      case 17: 
        k = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        break;
      case 16: 
        str6 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 15: 
        localList1.add(TextItem.ADAPTER.decode(paramProtoReader));
        break;
      case 14: 
        f1 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 13: 
        f2 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 12: 
        m = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        break;
      case 11: 
        n = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        break;
      case 10: 
        bool = ((Boolean)ProtoAdapter.BOOL.decode(paramProtoReader)).booleanValue();
        break;
      case 9: 
        f3 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 8: 
        f4 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 7: 
        f5 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 6: 
        f6 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        break;
      case 5: 
        i1 = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        break;
      case 4: 
        l3 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 3: 
        l4 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 2: 
        label669:
        label702:
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      }
      str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull StickerModel paramStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramStickerModel.id);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramStickerModel.filePath);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 3, Long.valueOf(paramStickerModel.startTime));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, Long.valueOf(paramStickerModel.duration));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, Integer.valueOf(paramStickerModel.layerIndex));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 6, Float.valueOf(paramStickerModel.scale));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 7, Float.valueOf(paramStickerModel.rotate));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 8, Float.valueOf(paramStickerModel.centerX));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 9, Float.valueOf(paramStickerModel.centerY));
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 10, Boolean.valueOf(paramStickerModel.editable));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 11, Integer.valueOf(paramStickerModel.width));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 12, Integer.valueOf(paramStickerModel.height));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 13, Float.valueOf(paramStickerModel.minScale));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 14, Float.valueOf(paramStickerModel.maxScale));
    TextItem.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 15, paramStickerModel.textItems);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 16, paramStickerModel.thumbUrl);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 17, Integer.valueOf(paramStickerModel.timelineTrackIndex));
    AnimationMode.ADAPTER.encodeWithTag(paramProtoWriter, 18, paramStickerModel.animationMode);
    StickerModel.Type.ADAPTER.encodeWithTag(paramProtoWriter, 19, paramStickerModel.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 20, paramStickerModel.materialId);
    StickerModel.CaptionInfo.ADAPTER.encodeWithTag(paramProtoWriter, 21, paramStickerModel.captionInfo);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 22, Integer.valueOf(paramStickerModel.localThumbId));
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 23, Integer.valueOf(paramStickerModel.editingLayerIndex));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 24, Long.valueOf(paramStickerModel.playEndDuration));
    StickerModel.ActionType.ADAPTER.encodeWithTag(paramProtoWriter, 25, paramStickerModel.actionType);
    ProtoAdapter.STRING.asRepeated().encodeWithTag(paramProtoWriter, 26, paramStickerModel.bgConfig);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 27, paramStickerModel.bgPath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 28, paramStickerModel.configType);
    paramProtoWriter.writeBytes(paramStickerModel.unknownFields());
  }
  
  @NotNull
  public StickerModel b(@NotNull StickerModel paramStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "value");
    List localList = Internal.-redactElements(paramStickerModel.textItems, TextItem.ADAPTER);
    StickerModel.CaptionInfo localCaptionInfo = paramStickerModel.captionInfo;
    if (localCaptionInfo != null) {
      localCaptionInfo = (StickerModel.CaptionInfo)StickerModel.CaptionInfo.ADAPTER.redact(localCaptionInfo);
    } else {
      localCaptionInfo = null;
    }
    return StickerModel.copy$default(paramStickerModel, null, null, 0L, 0L, 0, 0.0F, 0.0F, 0.0F, 0.0F, false, 0, 0, 0.0F, 0.0F, localList, null, 0, null, null, null, localCaptionInfo, 0, 0, 0L, null, null, null, null, ByteString.EMPTY, 267370495, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */