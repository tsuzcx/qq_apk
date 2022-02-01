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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/MediaClip$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/MediaClip;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaClip$Companion$ADAPTER$1
  extends ProtoAdapter<MediaClip>
{
  MediaClip$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "value");
    return ResourceModel.ADAPTER.encodedSizeWithTag(1, paramMediaClip.resource) + Transform.ADAPTER.encodedSizeWithTag(2, paramMediaClip.transform) + FilterModel.ADAPTER.encodedSizeWithTag(3, paramMediaClip.filter) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramMediaClip.voiceKindName) + PhotoClipInfo.ADAPTER.encodedSizeWithTag(5, paramMediaClip.photoClip) + paramMediaClip.unknownFields().size();
  }
  
  @NotNull
  public MediaClip a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    ResourceModel localResourceModel = (ResourceModel)null;
    Transform localTransform = (Transform)null;
    FilterModel localFilterModel = (FilterModel)null;
    String str = (String)null;
    PhotoClipInfo localPhotoClipInfo = (PhotoClipInfo)null;
    long l = paramProtoReader.beginMessage();
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l);
        if (str == null) {
          str = "";
        }
        return new MediaClip(localResourceModel, localTransform, localFilterModel, str, localPhotoClipInfo, paramProtoReader);
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                paramProtoReader.readUnknownField(i);
              } else {
                localPhotoClipInfo = (PhotoClipInfo)PhotoClipInfo.ADAPTER.decode(paramProtoReader);
              }
            }
            else {
              str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
            }
          }
          else {
            localFilterModel = (FilterModel)FilterModel.ADAPTER.decode(paramProtoReader);
          }
        }
        else {
          localTransform = (Transform)Transform.ADAPTER.decode(paramProtoReader);
        }
      }
      else {
        localResourceModel = (ResourceModel)ResourceModel.ADAPTER.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "value");
    ResourceModel.ADAPTER.encodeWithTag(paramProtoWriter, 1, paramMediaClip.resource);
    Transform.ADAPTER.encodeWithTag(paramProtoWriter, 2, paramMediaClip.transform);
    FilterModel.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramMediaClip.filter);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramMediaClip.voiceKindName);
    PhotoClipInfo.ADAPTER.encodeWithTag(paramProtoWriter, 5, paramMediaClip.photoClip);
    paramProtoWriter.writeBytes(paramMediaClip.unknownFields());
  }
  
  @NotNull
  public MediaClip b(@NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "value");
    ResourceModel localResourceModel = paramMediaClip.resource;
    PhotoClipInfo localPhotoClipInfo1 = null;
    if (localResourceModel != null) {
      localResourceModel = (ResourceModel)ResourceModel.ADAPTER.redact(localResourceModel);
    } else {
      localResourceModel = null;
    }
    Transform localTransform = paramMediaClip.transform;
    if (localTransform != null) {
      localTransform = (Transform)Transform.ADAPTER.redact(localTransform);
    } else {
      localTransform = null;
    }
    FilterModel localFilterModel = paramMediaClip.filter;
    if (localFilterModel != null) {
      localFilterModel = (FilterModel)FilterModel.ADAPTER.redact(localFilterModel);
    } else {
      localFilterModel = null;
    }
    PhotoClipInfo localPhotoClipInfo2 = paramMediaClip.photoClip;
    if (localPhotoClipInfo2 != null) {
      localPhotoClipInfo1 = (PhotoClipInfo)PhotoClipInfo.ADAPTER.redact(localPhotoClipInfo2);
    }
    return MediaClip.copy$default(paramMediaClip, localResourceModel, localTransform, localFilterModel, null, localPhotoClipInfo1, ByteString.EMPTY, 8, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaClip.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */