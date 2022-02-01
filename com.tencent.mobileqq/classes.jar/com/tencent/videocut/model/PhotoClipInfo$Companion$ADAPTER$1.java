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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/PhotoClipInfo$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/PhotoClipInfo;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PhotoClipInfo$Companion$ADAPTER$1
  extends ProtoAdapter<PhotoClipInfo>
{
  PhotoClipInfo$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull PhotoClipInfo paramPhotoClipInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPhotoClipInfo, "value");
    return RectF.ADAPTER.encodedSizeWithTag(1, paramPhotoClipInfo.imageFrameRect) + RectF.ADAPTER.encodedSizeWithTag(2, paramPhotoClipInfo.clipFrameRect) + Rect.ADAPTER.encodedSizeWithTag(3, paramPhotoClipInfo.picClipRect) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, paramPhotoClipInfo.rotate) + paramPhotoClipInfo.unknownFields().size();
  }
  
  @NotNull
  public PhotoClipInfo a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    RectF localRectF1 = (RectF)null;
    Rect localRect = (Rect)null;
    Float localFloat = (Float)null;
    long l = paramProtoReader.beginMessage();
    RectF localRectF2 = localRectF1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new PhotoClipInfo(localRectF1, localRectF2, localRect, localFloat, paramProtoReader.endMessageAndGetUnknownFields(l));
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
              localFloat = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
            }
          }
          else {
            localRect = (Rect)Rect.ADAPTER.decode(paramProtoReader);
          }
        }
        else {
          localRectF2 = (RectF)RectF.ADAPTER.decode(paramProtoReader);
        }
      }
      else {
        localRectF1 = (RectF)RectF.ADAPTER.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull PhotoClipInfo paramPhotoClipInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPhotoClipInfo, "value");
    RectF.ADAPTER.encodeWithTag(paramProtoWriter, 1, paramPhotoClipInfo.imageFrameRect);
    RectF.ADAPTER.encodeWithTag(paramProtoWriter, 2, paramPhotoClipInfo.clipFrameRect);
    Rect.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramPhotoClipInfo.picClipRect);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 4, paramPhotoClipInfo.rotate);
    paramProtoWriter.writeBytes(paramPhotoClipInfo.unknownFields());
  }
  
  @NotNull
  public PhotoClipInfo b(@NotNull PhotoClipInfo paramPhotoClipInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPhotoClipInfo, "value");
    RectF localRectF1 = paramPhotoClipInfo.imageFrameRect;
    Rect localRect1 = null;
    if (localRectF1 != null) {
      localRectF1 = (RectF)RectF.ADAPTER.redact(localRectF1);
    } else {
      localRectF1 = null;
    }
    RectF localRectF2 = paramPhotoClipInfo.clipFrameRect;
    if (localRectF2 != null) {
      localRectF2 = (RectF)RectF.ADAPTER.redact(localRectF2);
    } else {
      localRectF2 = null;
    }
    Rect localRect2 = paramPhotoClipInfo.picClipRect;
    if (localRect2 != null) {
      localRect1 = (Rect)Rect.ADAPTER.redact(localRect2);
    }
    return PhotoClipInfo.copy$default(paramPhotoClipInfo, localRectF1, localRectF2, localRect1, null, ByteString.EMPTY, 8, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PhotoClipInfo.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */