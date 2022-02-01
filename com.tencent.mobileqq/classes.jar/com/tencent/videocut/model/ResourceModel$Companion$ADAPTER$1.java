package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.Companion;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/ResourceModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/ResourceModel;", "extrasAdapter", "", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ResourceModel$Companion$ADAPTER$1
  extends ProtoAdapter<ResourceModel>
{
  private final ProtoAdapter<Map<String, String>> a = ProtoAdapter.Companion.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
  
  ResourceModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull ResourceModel paramResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramResourceModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramResourceModel.id) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramResourceModel.path) + ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(paramResourceModel.scaleDuration)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(paramResourceModel.sourceStart)) + ProtoAdapter.INT64.encodedSizeWithTag(5, Long.valueOf(paramResourceModel.sourceDuration)) + ProtoAdapter.INT64.encodedSizeWithTag(6, Long.valueOf(paramResourceModel.selectStart)) + ProtoAdapter.INT64.encodedSizeWithTag(7, Long.valueOf(paramResourceModel.selectDuration)) + MediaType.ADAPTER.encodedSizeWithTag(8, paramResourceModel.type) + SizeF.ADAPTER.encodedSizeWithTag(9, paramResourceModel.size) + ProtoAdapter.FLOAT.encodedSizeWithTag(11, Float.valueOf(paramResourceModel.volume)) + this.a.encodedSizeWithTag(12, paramResourceModel.extras) + RectF.ADAPTER.encodedSizeWithTag(13, paramResourceModel.picClipRect) + ProtoAdapter.STRING.encodedSizeWithTag(14, paramResourceModel.reversePath) + ProtoAdapter.STRING.encodedSizeWithTag(15, paramResourceModel.normalPath) + ProtoAdapter.BOOL.encodedSizeWithTag(16, paramResourceModel.isReverseMode) + paramResourceModel.unknownFields().size();
  }
  
  @NotNull
  public ResourceModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Object localObject4 = (MediaType)null;
    SizeF localSizeF = (SizeF)null;
    Float localFloat = (Float)null;
    Map localMap = (Map)new LinkedHashMap();
    RectF localRectF = (RectF)null;
    Boolean localBoolean = (Boolean)null;
    long l7 = paramProtoReader.beginMessage();
    String str = "";
    long l5 = 0L;
    Object localObject5 = "";
    Object localObject1 = localObject5;
    Object localObject2 = localObject1;
    long l4 = 0L;
    long l1 = l4;
    long l2 = l1;
    long l6 = l2;
    Object localObject3 = localObject1;
    long l3 = l1;
    l1 = l6;
    localObject1 = localObject5;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l7);
        float f;
        if (localFloat != null) {
          f = localFloat.floatValue();
        } else {
          f = 0.0F;
        }
        return new ResourceModel(str, (String)localObject1, l5, l1, l4, l3, l2, (MediaType)localObject4, localSizeF, f, localMap, localRectF, (String)localObject3, (String)localObject2, localBoolean, paramProtoReader);
      }
      switch (i)
      {
      case 10: 
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 16: 
        localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 15: 
        localObject2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 14: 
        localObject3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 13: 
        localRectF = (RectF)RectF.ADAPTER.decode(paramProtoReader);
        break;
      case 12: 
        localMap.putAll((Map)this.a.decode(paramProtoReader));
        break;
      case 11: 
        localFloat = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 9: 
        localSizeF = (SizeF)SizeF.ADAPTER.decode(paramProtoReader);
        break;
      case 8: 
        try
        {
          localObject5 = (MediaType)MediaType.ADAPTER.decode(paramProtoReader);
          localObject4 = localObject5;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException.value));
        }
      case 7: 
        l2 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 6: 
        l3 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 5: 
        l4 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 4: 
        l1 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 3: 
        l5 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 2: 
        localObject1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull ResourceModel paramResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramResourceModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramResourceModel.id);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramResourceModel.path);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 3, Long.valueOf(paramResourceModel.scaleDuration));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, Long.valueOf(paramResourceModel.sourceStart));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 5, Long.valueOf(paramResourceModel.sourceDuration));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 6, Long.valueOf(paramResourceModel.selectStart));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 7, Long.valueOf(paramResourceModel.selectDuration));
    MediaType.ADAPTER.encodeWithTag(paramProtoWriter, 8, paramResourceModel.type);
    SizeF.ADAPTER.encodeWithTag(paramProtoWriter, 9, paramResourceModel.size);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 11, Float.valueOf(paramResourceModel.volume));
    this.a.encodeWithTag(paramProtoWriter, 12, paramResourceModel.extras);
    RectF.ADAPTER.encodeWithTag(paramProtoWriter, 13, paramResourceModel.picClipRect);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 14, paramResourceModel.reversePath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 15, paramResourceModel.normalPath);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 16, paramResourceModel.isReverseMode);
    paramProtoWriter.writeBytes(paramResourceModel.unknownFields());
  }
  
  @NotNull
  public ResourceModel b(@NotNull ResourceModel paramResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramResourceModel, "value");
    SizeF localSizeF = paramResourceModel.size;
    if (localSizeF != null) {
      localSizeF = (SizeF)SizeF.ADAPTER.redact(localSizeF);
    } else {
      localSizeF = null;
    }
    RectF localRectF = paramResourceModel.picClipRect;
    if (localRectF != null) {
      localRectF = (RectF)RectF.ADAPTER.redact(localRectF);
    } else {
      localRectF = null;
    }
    return ResourceModel.copy$default(paramResourceModel, null, null, null, null, null, null, null, null, localSizeF, null, null, localRectF, null, null, null, ByteString.EMPTY, 30463, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ResourceModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */