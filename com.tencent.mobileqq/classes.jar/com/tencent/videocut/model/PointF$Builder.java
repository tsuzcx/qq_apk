package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/PointF$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/PointF;", "()V", "x", "", "y", "build", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/PointF$Builder;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PointF$Builder
  extends Message.Builder<PointF, Builder>
{
  @JvmField
  public float a;
  @JvmField
  public float b;
  
  @NotNull
  public PointF a()
  {
    return new PointF(this.a, this.b, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.PointF.Builder
 * JD-Core Version:    0.7.0.1
 */