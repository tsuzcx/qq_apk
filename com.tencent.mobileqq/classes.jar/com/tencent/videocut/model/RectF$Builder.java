package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/RectF$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/RectF;", "()V", "bottom", "", "left", "right", "top", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/RectF$Builder;", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class RectF$Builder
  extends Message.Builder<RectF, Builder>
{
  @JvmField
  public float a;
  @JvmField
  public float b;
  @JvmField
  public float c;
  @JvmField
  public float d;
  
  @NotNull
  public RectF a()
  {
    return new RectF(this.a, this.b, this.c, this.d, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.RectF.Builder
 * JD-Core Version:    0.7.0.1
 */