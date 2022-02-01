package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/Transform$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/Transform;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Transform$Companion$ADAPTER$1
  extends ProtoAdapter<Transform>
{
  Transform$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull Transform paramTransform)
  {
    Intrinsics.checkParameterIsNotNull(paramTransform, "value");
    return ProtoAdapter.FLOAT.encodedSizeWithTag(1, Float.valueOf(paramTransform.rotate)) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, Float.valueOf(paramTransform.scale)) + PointF.ADAPTER.encodedSizeWithTag(3, paramTransform.anchorPoint) + SizeF.ADAPTER.encodedSizeWithTag(4, paramTransform.renderSize) + paramTransform.unknownFields().size();
  }
  
  @NotNull
  public Transform a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    PointF localPointF = (PointF)null;
    SizeF localSizeF = (SizeF)null;
    long l = paramProtoReader.beginMessage();
    float f2 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new Transform(f2, f1, localPointF, localSizeF, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              paramProtoReader.readUnknownField(i);
            } else {
              localSizeF = (SizeF)SizeF.ADAPTER.decode(paramProtoReader);
            }
          }
          else {
            localPointF = (PointF)PointF.ADAPTER.decode(paramProtoReader);
          }
        }
        else {
          f1 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
        }
      }
      else {
        f2 = ((Number)ProtoAdapter.FLOAT.decode(paramProtoReader)).floatValue();
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull Transform paramTransform)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTransform, "value");
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 1, Float.valueOf(paramTransform.rotate));
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 2, Float.valueOf(paramTransform.scale));
    PointF.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramTransform.anchorPoint);
    SizeF.ADAPTER.encodeWithTag(paramProtoWriter, 4, paramTransform.renderSize);
    paramProtoWriter.writeBytes(paramTransform.unknownFields());
  }
  
  @NotNull
  public Transform b(@NotNull Transform paramTransform)
  {
    Intrinsics.checkParameterIsNotNull(paramTransform, "value");
    PointF localPointF = paramTransform.anchorPoint;
    SizeF localSizeF1 = null;
    if (localPointF != null) {
      localPointF = (PointF)PointF.ADAPTER.redact(localPointF);
    } else {
      localPointF = null;
    }
    SizeF localSizeF2 = paramTransform.renderSize;
    if (localSizeF2 != null) {
      localSizeF1 = (SizeF)SizeF.ADAPTER.redact(localSizeF2);
    }
    return Transform.copy$default(paramTransform, null, null, localPointF, localSizeF1, ByteString.EMPTY, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.Transform.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */