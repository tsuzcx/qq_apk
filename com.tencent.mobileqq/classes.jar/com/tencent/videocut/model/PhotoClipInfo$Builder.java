package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/PhotoClipInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/PhotoClipInfo;", "()V", "clipFrameRect", "Lcom/tencent/videocut/model/RectF;", "imageFrameRect", "picClipRect", "Lcom/tencent/videocut/model/Rect;", "rotate", "", "Ljava/lang/Float;", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/PhotoClipInfo$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PhotoClipInfo$Builder
  extends Message.Builder<PhotoClipInfo, Builder>
{
  @JvmField
  @Nullable
  public RectF a;
  @JvmField
  @Nullable
  public RectF b;
  @JvmField
  @Nullable
  public Rect c;
  @JvmField
  @Nullable
  public Float d;
  
  @NotNull
  public PhotoClipInfo a()
  {
    return new PhotoClipInfo(this.a, this.b, this.c, this.d, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PhotoClipInfo.Builder
 * JD-Core Version:    0.7.0.1
 */