package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/MediaClip$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/MediaClip;", "()V", "filter", "Lcom/tencent/videocut/model/FilterModel;", "photoClip", "Lcom/tencent/videocut/model/PhotoClipInfo;", "resource", "Lcom/tencent/videocut/model/ResourceModel;", "transform", "Lcom/tencent/videocut/model/Transform;", "voiceKindName", "", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaClip$Builder
  extends Message.Builder<MediaClip, Builder>
{
  @JvmField
  @Nullable
  public ResourceModel a;
  @JvmField
  @Nullable
  public Transform b;
  @JvmField
  @Nullable
  public FilterModel c;
  @JvmField
  @Nullable
  public String d;
  @JvmField
  @Nullable
  public PhotoClipInfo e;
  
  @NotNull
  public MediaClip a()
  {
    ResourceModel localResourceModel = this.a;
    Transform localTransform = this.b;
    FilterModel localFilterModel = this.c;
    String str = this.d;
    if (str == null) {
      str = "";
    }
    return new MediaClip(localResourceModel, localTransform, localFilterModel, str, this.e, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaClip.Builder
 * JD-Core Version:    0.7.0.1
 */