package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/PipModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/PipModel;", "()V", "mediaClip", "Lcom/tencent/videocut/model/MediaClip;", "startOffset", "", "timelineIndex", "", "Ljava/lang/Integer;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/PipModel$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/PipModel$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipModel$Builder
  extends Message.Builder<PipModel, Builder>
{
  @JvmField
  @Nullable
  public MediaClip a;
  @JvmField
  public long b;
  @JvmField
  @Nullable
  public Integer c;
  
  @NotNull
  public PipModel a()
  {
    MediaClip localMediaClip = this.a;
    long l = this.b;
    Integer localInteger = this.c;
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    return new PipModel(localMediaClip, l, i, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PipModel.Builder
 * JD-Core Version:    0.7.0.1
 */