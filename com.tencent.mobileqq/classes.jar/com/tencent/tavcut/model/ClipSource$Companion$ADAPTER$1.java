package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/ClipSource$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/ClipSource;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ClipSource$Companion$ADAPTER$1
  extends ProtoAdapter<ClipSource>
{
  ClipSource$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public ClipSource decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str2 = (String)null;
    Object localObject4 = (ClipSource.ClipType)null;
    Long localLong2 = (Long)null;
    Object localObject1 = (Float)null;
    List localList = (List)new ArrayList();
    ScreenTransform localScreenTransform = (ScreenTransform)null;
    Rect localRect = (Rect)null;
    long l = paramProtoReader.beginMessage();
    String str1 = str2;
    Long localLong1 = localLong2;
    Object localObject2 = localObject1;
    Object localObject5 = str1;
    Object localObject3 = localObject1;
    localObject1 = localObject4;
    localObject4 = localObject5;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (localLong2 != null) {
          return new ClipSource(str2, (String)localObject4, (ClipSource.ClipType)localObject1, localLong2.longValue(), (Float)localObject3, (Float)localObject2, localLong1, localList, str1, localScreenTransform, localRect, paramProtoReader);
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localLong2, "duration" }));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 11: 
        localRect = (Rect)Rect.ADAPTER.decode(paramProtoReader);
        break;
      case 10: 
        localScreenTransform = (ScreenTransform)ScreenTransform.ADAPTER.decode(paramProtoReader);
        break;
      case 9: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 8: 
        localList.add(ProtoAdapter.FLOAT.decode(paramProtoReader));
        break;
      case 7: 
        localLong1 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 6: 
        localObject2 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 5: 
        localObject3 = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 4: 
        localLong2 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
        break;
      case 3: 
        try
        {
          localObject5 = (ClipSource.ClipType)ClipSource.ClipType.ADAPTER.decode(paramProtoReader);
          try
          {
            localObject1 = Unit.INSTANCE;
            localObject1 = localObject5;
          }
          catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException2)
          {
            localObject1 = localObject5;
            localObject5 = localEnumConstantNotFoundException2;
          }
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException1.value));
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException1) {}
        Unit localUnit = Unit.INSTANCE;
        break;
      case 2: 
        localObject4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull ClipSource paramClipSource)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramClipSource, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramClipSource.sourceId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramClipSource.path);
    ClipSource.ClipType.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramClipSource.type);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, Long.valueOf(paramClipSource.duration));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 5, paramClipSource.speed);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 6, paramClipSource.volume);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 7, paramClipSource.startOffset);
    ProtoAdapter.FLOAT.asRepeated().encodeWithTag(paramProtoWriter, 8, paramClipSource.matrix);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 9, paramClipSource.photoEffectPath);
    ScreenTransform.ADAPTER.encodeWithTag(paramProtoWriter, 10, paramClipSource.transform);
    Rect.ADAPTER.encodeWithTag(paramProtoWriter, 11, paramClipSource.clipRect);
    paramProtoWriter.writeBytes(paramClipSource.unknownFields());
  }
  
  public int encodedSize(@NotNull ClipSource paramClipSource)
  {
    Intrinsics.checkParameterIsNotNull(paramClipSource, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramClipSource.sourceId) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramClipSource.path) + ClipSource.ClipType.ADAPTER.encodedSizeWithTag(3, paramClipSource.type) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(paramClipSource.duration)) + ProtoAdapter.FLOAT.encodedSizeWithTag(5, paramClipSource.speed) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, paramClipSource.volume) + ProtoAdapter.INT64.encodedSizeWithTag(7, paramClipSource.startOffset) + ProtoAdapter.FLOAT.asRepeated().encodedSizeWithTag(8, paramClipSource.matrix) + ProtoAdapter.STRING.encodedSizeWithTag(9, paramClipSource.photoEffectPath) + ScreenTransform.ADAPTER.encodedSizeWithTag(10, paramClipSource.transform) + Rect.ADAPTER.encodedSizeWithTag(11, paramClipSource.clipRect) + paramClipSource.unknownFields().size();
  }
  
  @NotNull
  public ClipSource redact(@NotNull ClipSource paramClipSource)
  {
    Intrinsics.checkParameterIsNotNull(paramClipSource, "value");
    ScreenTransform localScreenTransform = paramClipSource.transform;
    if (localScreenTransform != null) {
      localScreenTransform = (ScreenTransform)ScreenTransform.ADAPTER.redact(localScreenTransform);
    } else {
      localScreenTransform = null;
    }
    Rect localRect = paramClipSource.clipRect;
    if (localRect != null) {
      localRect = (Rect)Rect.ADAPTER.redact(localRect);
    } else {
      localRect = null;
    }
    return ClipSource.copy$default(paramClipSource, null, null, null, 0L, null, null, null, null, null, localScreenTransform, localRect, ByteString.EMPTY, 511, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ClipSource.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */