package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/Transform$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/Transform;", "()V", "anchorPoint", "Lcom/tencent/videocut/model/PointF;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "rotate", "", "scale", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/Transform$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Transform$Builder
  extends Message.Builder<Transform, Builder>
{
  @JvmField
  public float a;
  @JvmField
  public float b;
  @JvmField
  @Nullable
  public PointF c;
  @JvmField
  @Nullable
  public SizeF d;
  
  @NotNull
  public Transform a()
  {
    return new Transform(this.a, this.b, this.c, this.d, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.Transform.Builder
 * JD-Core Version:    0.7.0.1
 */